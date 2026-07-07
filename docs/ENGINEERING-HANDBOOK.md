# Alpha Dragon Engineering Handbook

## 1. Propósito

Este handbook é o índice principal da documentação do Alpha Dragon e serve como referência viva para arquitetura, decisões técnicas, princípios de engenharia, linguagem ubíqua, visão de produto e evolução da plataforma.

Ele existe para responder três perguntas fundamentais:
- O que estamos construindo?
- Por que estamos construindo assim?
- Como devemos evoluir sem perder coerência arquitetural?

## 2. Escopo

Este documento cobre:
- visão de produto e estratégia,
- princípios de engenharia,
- arquitetura de domínio,
- decisões de arquitetura registradas em ADRs,
- linguagem ubíqua,
- padrões de implementação,
- evolução do produto em longo prazo.

## 3. Objetivos do handbook

1. Unificar a compreensão da plataforma entre engenharia, produto e negócios.
2. Preservar decisões estratégicas mesmo com crescimento da equipe.
3. Reduzir risco de reestruturação quando o produto evoluir.
4. Tornar o Alpha Dragon uma plataforma, e não apenas um repositório de código.

## 4. Estrutura da documentação

- [docs/README.md](README.md) — visão geral da documentação.
- [docs/00-company](00-company) — contexto organizacional e visão da empresa.
- [docs/01-product](01-product) — visão do produto, modelo de negócio e posicionamento.
- [docs/02-architecture](02-architecture) — princípios arquiteturais e estruturas de referência.
- [docs/03-domain](03-domain) — glossary e modelagem do domínio.
- [docs/04-adr](04-adr) — decisões formais de arquitetura.

## 5. Princípios do Alpha Dragon

- O domínio é o centro do sistema.
- O modelo canônico é paramétrico, universal e independente de CAD.
- CADs são adaptadores, não a fonte da verdade.
- IA é uma camada de interação e assistência, não o núcleo do domínio.
- O sistema deve ser extensível para plugins, exportadores, knowledge e simulação.

## 6. Como usar este handbook

- Novos desenvolvedores devem começar por este documento.
- Novas decisões técnicas devem ser registradas em ADRs.
- Mudanças na linguagem do domínio devem ser refletidas no glossary.
- Mudanças estruturais importantes devem ser revisadas contra os princípios e ADRs.

## 7. Evolução esperada

O handbook deve evoluir junto com o produto. À medida que a plataforma amadurece, este documento deve refletir:
- novos módulos,
- novas decisões arquiteturais,
- novas fronteiras de domínio,
- novos padrões de integração.
