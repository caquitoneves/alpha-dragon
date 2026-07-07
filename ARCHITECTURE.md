# Alpha Dragon Domain Architecture

## 1. Objetivo

Este documento descreve a arquitetura revisada do domínio do Alpha Dragon e o conjunto inicial de Architecture Decision Records (ADRs) que devem ser aprovados antes de qualquer implementação de código.

O foco aqui é:
- modelar um núcleo de engenharia paramétrica universal,
- manter o domínio independente de frameworks e infraestrutura,
- garantir extensibilidade para IA, CAD, simulação e colaboração,
- evitar agregados transacionais gigantescos,
- estabelecer um design adequado para +15 anos de evolução.

---

## 2. Visão Geral da Arquitetura

A arquitetura proposta é baseada em:
- Domain-Driven Design (DDD),
- Clean Architecture / Hexagonal,
- Modular Monolith com boundaries claras,
- Domínio puro sem dependências de Spring, JPA, JSON, HTTP ou banco de dados.

### 2.1 Princípios principais

- Domínio rico: objetos com comportamento, não apenas dados.
- Agregados locais: cada agregado gerencia sua consistência.
- Contextos claros: domínio separados por responsabilidade.
- Kernel geométrico comportamental: Geometry é comportamento, não um VO.
- Parametric engine independente: expressão, dependência e solver.
- Sketch como primeiro estágio de modelagem.
- Knowledge como camada consultiva externa ao kernel.
- CAD adapters como tradutores do modelo canônico.
- Intent Engine como camada de borda para transformar linguagem em comandos técnicos.

---

## 3. Bounded Contexts Revisados

### 3.1 engineering-project
- EngineeringProject (Aggregate Root)
- EngineeringDocument
- Revision
- AuditTrail
- Metadata do projeto

### 3.2 engineering-assembly
- Assembly (Aggregate Root)
- AssemblyConstraint
- AssemblyInterface
- CoordinateSystem

### 3.3 engineering-part
- Part (Aggregate Root)
- Body
- Material
- MassProperties
- ManufacturingProcess

### 3.4 engineering-geometry-kernel
- GeometryKernel
- Geometry
- Topology
- BRep
- Face
- Edge
- Vertex
- BoundingBox
- Constraint

### 3.5 engineering-math
- Matrix
- Vector
- Quaternion
- Plane
- Transform
- Rotation
- Projection
- SpatialAlgebra

### 3.6 engineering-feature
- Feature (sealed hierarchy)
- Hole
- Slot
- Pocket
- Fillet
- Chamfer
- Thread
- Bend
- Extrusion
- Revolution
- Cut
- BooleanFeature (Union, Subtract, Intersect, Split, Shell, Offset, Mirror, Pattern)

### 3.7 engineering-parametric
- Parameter
- Expression
- Equation
- Formula
- DependencyGraph
- ConstraintSolver
- ParametricAssignment

### 3.8 engineering-sketch
- Sketch
- SketchEntity
- Line
- Circle
- Arc
- Spline
- Polyline
- Dimension
- SketchConstraint

### 3.9 engineering-validation
- EngineeringRule
- EngineeringValidation
- Specification
- ValidationResult
- ValidationSeverity

### 3.10 engineering-process
- ManufacturingProcess
- SurfaceFinish
- Tolerance
- ProcessStep
- ManufacturingStage

> Nota: este contexto pode evoluir para um bounded context próprio `manufacturing` no futuro, com subdomínios como CAM, Laser, Plasma, Waterjet, CNC e Press Brake.

### 3.11 engineering-knowledge
- MaterialCatalog
- Standard
- ProfileLibrary
- FastenerLibrary
- NormativeReference (ABNT, ISO, DIN, ASTM)

### 3.12 engineering-ports
- Repository interfaces
- Factory interfaces
- DomainService interfaces
- DomainEventPublisher
- ValidationPolicy

### 3.13 cad-adapters
- AutoCADAdapter
- SolidWorksAdapter
- InventorAdapter
- FusionAdapter
- STEPAdapter
- DXFAdapter
- STLAdapter

### 3.14 engineering-intent
- IntentEngine
- IntentCommand
- IntentTranslator
- IntentContext
- IntentPolicy

### 3.15 engineering-history
- FeatureNode
- FeatureGraph
- Timeline
- DependencyTree
- HistorySnapshot
- ChangeRecord

### 3.16 plugin-sdk
- Plugin API
- CAD Adapter API
- Extension API
- PluginRegistration
- PluginLifecycle

---

## 4. Agregados Principais e Consistência

### 4.1 EngineeringProject

Aggregate Root de nível mais alto para contexto organizacional:
- agrupa assemblies,
- mantém metadata do documento,
- controla revisões e auditoria,
- não define consistência transacional de todos os objetos do projeto.

### 4.2 Assembly

Aggregate Root que controla consistência de montagem:
- referências a partes,
- restrições e interfaces de acoplamento,
- coordinate systems relativos.

### 4.3 Part

Aggregate Root que controla consistência de peça:
- corpo(s),
- material,
- features,
- propriedades de massa,
- processo de manufatura.

### 4.4 Body

Entidade comportamental dentro de Part:
- representa a forma geométrica sólida,
- encapsula operações Booleanas e topológicas,
- delega a geometria de baixo nível para o módulo `engineering-geometry-kernel`.

---

## 5. Modelo de Geometria Comportamental

### 5.1 Geometry como módulo de domínio

Geometry não é apenas um VO. Ele deve conter:
- topologia e conectividade,
- BRep com faces, arestas e vértices,
- operações de análise geométrica,
- validações de integridade,
- regras de malha e fechamento.

### 5.2 Hierarquia proposta

- GeometryKernel
  - Geometry
    - Topology
    - BRep
    - Face
    - Edge
    - Vertex
    - BoundingBox
    - MassProperties

Essa hierarquia dá ao domínio um kernel geométrico capaz de evoluir para um motor CAD próprio ou integrar-se a um kernel externo.

---

## 6. Corpo e Operações Booleanas

O `Body` deve conhecer e orquestrar operações fundamentais:
- Union
- Subtract
- Intersect
- Split
- Shell
- Offset
- Mirror
- Pattern

Essas operações não são apenas features; são primitivas de modelagem sólido.

---

## 7. Parametric Engine

### 7.1 Motivação

A modelagem deve ser baseada em parâmetros e equações, não em valores fixos. O domínio precisa de um mecanismo dedicado para:
- representar parâmetros,
- resolver dependências,
- avaliar expressões,
- manter coerência de fórmulas.

### 7.2 Componentes do contexto

- `Parameter`
- `ParameterHistory`
- `ParameterSnapshot`
- `Expression`
- `Equation`
- `Formula`
- `DependencyGraph`
- `ConstraintSolver`
- `ParametricAssignment`
- `EvaluationContext`

### 7.3 Versioned Parameters

- `Parameter` deve suportar histórico de valores e snapshots de estado.
- `ParameterHistory` registra mudanças de valor e contexto de alteração.
- `ParameterSnapshot` captura o estado dos parâmetros em um ponto no tempo.
- Isso permite reconstrução, rollback e análise de variação.

### 7.4 Papel no domínio

- `Feature` e `Sketch` usam parâmetros,
- `Body` e `Geometry` podem ser gerados a partir de parâmetros,
- a engine paramétrica deve suportar grafo de dependência, não apenas variáveis isoladas.

---

## 8. Sketch como estágio inicial

### 8.1 Por quê Sketch?

CAD moderno raramente cria corpos diretamente. O fluxo típico é:
- Sketch → Extrude / Revolve / Cut → Body.

### 8.2 Componentes do módulo

- `Sketch`
- `SketchEntity`
- `Line`
- `Circle`
- `Arc`
- `Spline`
- `Polyline`
- `Dimension`
- `SketchConstraint`

### 8.3 Integração

O sketch alimenta as features paramétricas e mantém o histórico de intenção geométrica.

---

## 9. Knowledge Engine separado

### 9.1 Razão

Conhecimento de domínio (normas, catálogos, materiais) não deve poluir o kernel de geometria ou regras de engenharia.

### 9.2 Componentes

- `MaterialCatalog`
- `StandardRepository`
- `ProfileLibrary`
- `FastenerLibrary`
- `NormativeReference`

### 9.3 Uso

A IA e o `Intent Engine` consultam essa camada para:
- sugerir materiais,
- validar normas,
- enriquecer decisões de projeto.

---

## 10. CAD Adapters

### 10.1 Papel

Cada adaptador traduz o modelo canônico para um formato ou API CAD específico.

### 10.2 Design

- adaptadores são implementações de portas,
- não contêm regras de engenharia,
- são substituíveis e desacoplados.

### 10.3 Exemplos

- `AutoCADAdapter`
- `SolidWorksAdapter`
- `InventorAdapter`
- `FusionAdapter`
- `STEPAdapter`
- `DXFAdapter`
- `STLAdapter`

---

## 11. Engineering Intent Engine

### 11.1 Papel estratégico

Essa camada transforma linguagem natural e intenções de produto em comandos estruturados do domínio.

### 11.2 Fluxo proposto

Usuário → LLM → Intent Engine → EngineeringModel → Rule Engine → Geometry Engine → CAD Adapter

### 11.3 Componentes

- `IntentEngine`
- `IntentCommand`
- `IntentTranslator`
- `IntentContext`
- `IntentPolicy`

### 11.4 Justificativa

Isso cria o diferencial do produto e mantém a borda de IA separada do kernel de engenharia.

---

## 12. Terminologia do Modelo Canônico

### 12.1 Nome recomendado

- `EngineeringDocument` ou
- `EngineeringModel`

### 12.2 Papel

Representa o documento de engenharia como entidade de negócio:
- peça,
- conjunto,
- desenho,
- revisão,
- simulação.

### 12.3 Por que evitar `UniversalEngineeringModel` como root?

- nome muito técnico,
- tende a virar um agregado enorme,
- não representa bem o domínio de produto.

---

## 13. Relação entre componentes (Diagrama textual)

```
EngineeringProject
  ├─ EngineeringDocument
  │    ├─ Assembly
  │    │    ├─ Part
  │    │    │    ├─ Body
  │    │    │    │    ├─ GeometryKernel
  │    │    │    │    │    ├─ Geometry
  │    │    │    │    │    │    ├─ Topology
  │    │    │    │    │    │    ├─ BRep
  │    │    │    │    │    │    ├─ Face
  │    │    │    │    │    │    ├─ Edge
  │    │    │    │    │    │    └─ Vertex
  │    │    │    │    │    ├─ BoundingBox
  │    │    │    │    │    └─ MassProperties
  │    │    │    │    ├─ BooleanOperation
  │    │    │    │    └─ MassProperties
  │    │    │    ├─ Feature*
  │    │    │    ├─ Material
  │    │    │    ├─ CoordinateSystem
  │    │    │    └─ ManufacturingProcess
  │    │    ├─ AssemblyConstraint
  │    │    └─ CoordinateSystem
  │    ├─ Sketch
  │    │    ├─ Line
  │    │    ├─ Circle
  │    │    ├─ Arc
  │    │    ├─ Spline
  │    │    ├─ Polyline
  │    │    └─ Dimension
  │    ├─ ParametricEngine
  │    │    ├─ Parameter
  │    │    ├─ ParameterHistory
  │    │    ├─ ParameterSnapshot
  │    │    ├─ Expression
  │    │    ├─ Equation
  │    │    ├─ Formula
  │    │    ├─ DependencyGraph
  │    │    └─ ConstraintSolver
  │    ├─ History
  │    │    ├─ FeatureNode
  │    │    ├─ FeatureGraph
  │    │    ├─ Timeline
  │    │    └─ DependencyTree
  │    ├─ Math
  │    │    ├─ Vector
  │    │    ├─ Matrix
  │    │    ├─ Quaternion
  │    │    ├─ Plane
  │    │    ├─ Transform
  │    │    └─ Rotation
  │    └─ Validation
  │         ├─ EngineeringRule
  │         └─ EngineeringValidation
  ├─ Revision
  ├─ AuditTrail
  └─ Metadata

Domain Services
  ├─ GeometryValidator
  ├─ MassPropertiesCalculator
  ├─ FeatureApplicator
  ├─ AssemblyConstraintEvaluator
  ├─ EngineeringRuleEngine
  └─ ManufacturingProcessPlanner

Ports / Adapters
  ├─ Repository
  ├─ Factory
  ├─ EventPublisher
  ├─ CADAdapter
  └─ IntentEngine

Knowledge
  ├─ MaterialCatalog
  ├─ StandardRepository
  └─ FastenerLibrary
```

---

## 14. Decision Records Iniciais (ADR)

### ADR 001 — Arquitetura inicial: Modular Monolith

- Decisão: usar Modular Monolith no MVP.
- Justificativa: menor complexidade operacional, integração mais simples e foco rápido no kernel.
- Impacto: permite evoluir módulos internamente antes de considerar microsserviços.

### ADR 002 — Modelo canônico: EngineeringDocument / EngineeringModel

- Decisão: usar `EngineeringDocument` / `EngineeringModel` como termo canônico.
- Justificativa: reflete domínio de produto e evita um agregado global muito técnico.
- Impacto: melhora comunicação com stakeholders e mantém o kernel flexível.

### ADR 003 — CAD adapters são adaptadores

- Decisão: todos os plugins CAD serão adaptadores de borda.
- Justificativa: regras de engenharia permanecem no domínio puro.
- Impacto: mantém o core independente e facilita suporte a novos formatos.

### ADR 004 — Separação de intent, rule e geometry engines

- Decisão: `Intent Engine`, `Rule Engine` e `Geometry Engine` são camadas separadas.
- Justificativa: cada camada tem responsabilidade distinta e evita acoplamento entre IA, lógica e kernel geométrico.
- Impacto: permite evoluir IA e regras sem tocar o kernel básico.

### ADR 005 — Parametric Engine como contexto próprio

- Decisão: `engineering-parametric` é um bounded context separado.
- Justificativa: parametrização e resolução de dependências são um domínio por si só.
- Impacto: evita que features ou bodies cresçam em complexidade e mantém a modelagem paramétrica tratável.

### ADR 006 — Knowledge Engine consultivo

- Decisão: `engineering-knowledge` será camada de consulta externa.
- Justificativa: normas e catálogos não são regras geométricas fundamentais.
- Impacto: conhecimento pode ser enriquecido e trocado sem afetar o kernel.

### ADR 007 — Geometry com comportamento

- Decisão: Geometry não é VO; é módulo comportamental rico.
- Justificativa: topologia, BRep e validações são comportamentos centrais para CAD.
- Impacto: permite evoluir para um kernel geométrico real, inclusive integração com bibliotecas CAD futuras.

### ADR 008 — Sketch como ponto de partida

- Decisão: adicionar `engineering-sketch` como contexto inicial.
- Justificativa: fluxos CAD modernos começam com sketch.
- Impacto: fortalece a modelagem paramétrica e torna o workflow previsível.

### ADR 009 — Operações booleanas no Body

- Decisão: `Body` conhece operações booleanas nativas.
- Justificativa: booleans são primitivas de modelagem sólido e devem residir no kernel.
- Impacto: evita fragmentação de lógica entre feature e corpo.

### ADR 010 — Representação geométrica canônica e kernel

- Decisão: definir o modelo geométrico interno oficial do Alpha Dragon antes da implementação.
- Justificativa: essa escolha impacta B-Rep canônico, abstração de kernel e compatibilidade com importações STEP/DXF.
- Impacto: orienta a separação entre `GeometryKernel`, `Geometry`, `Topology` e a futura capacidade de integrar ou substituir kernels externos.

---

## 15. Roadmap do Domínio

### Fase 1 — Núcleo do domínio
- Definir pacotes e bounded contexts,
- Implementar `EngineeringProject`, `Assembly`, `Part`, `Body`, `Geometry`, `Feature`,
- Criar `engineering-parametric` básico,
- Adicionar sketch básico,
- Definir interfaces de portas e events.

### Fase 2 — Regras e validação
- Implementar `EngineeringRuleEngine`, `Specifications`, `Validation`,
- Adicionar `ManufacturingProcess`, `SurfaceFinish`, `Tolerance`,
- Desenvolver `Knowledge Engine` consultivo.

### Fase 3 — Parametrização avançada
- Expandir `DependencyGraph`, `ConstraintSolver`, `Expression`,
- Suportar parâmetros dependentes e fórmulas complexas,
- Integrar parâmetros com features e sketches,
- Adicionar `engineering-history` para feature tree e dependência de operações.

### Fase 4 — Adapters e integração
- Criar `cad-adapters` para formatos e APIs relevantes,
- Desenvolver `Intent Engine` para IA / linguagem natural,
- Adicionar versionamento e histórico de mudanças,
- Definir `plugin-sdk` para extensão de terceiros.

### Fase 5 — Plataforma
- Construir API/SDK sobre o domínio,
- Adicionar colaboração em tempo real,
- Suportar marketplace e plugins,
- Evoluir para simulação e auditoria extendida,
- Iniciar estudo de `engineering-simulation` para stress, thermal, mass e motion.
- Construir API/SDK sobre o domínio,
- Adicionar colaboração em tempo real,
- Suportar marketplace e plugins,
- Evoluir para simulação e auditoria extendida.

---

## 16. Próximos passos

1. Aprovar este blueprint e os ADRs.
2. Definir o escopo do MVP inicial do domínio.
3. Criar a estrutura de pacotes e interfaces do domínio.
4. Implementar o modelo de domínio com prioridade em:
   - agregados locais,
   - kernel geométrico comportamental,
   - engine paramétrica,
   - sketch,
   - separação de intent / knowledge / CAD adapters.

---

## 17. Observações finais

Este desenho enfatiza escalabilidade, baixo acoplamento e futuro suporte a IA e plugins CAD. Ele evita começar com um aggregate monolítico e adiciona os contextos de parametrização e sketch que são essenciais para um verdadeiro kernel de engenharia.
