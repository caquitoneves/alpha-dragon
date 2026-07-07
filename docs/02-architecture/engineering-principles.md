# Princípios Arquiteturais

## O domínio é soberano

Toda regra de engenharia pertence exclusivamente ao domínio.

Nenhuma regra poderá existir em Controllers, Plugins ou Infraestrutura.

---

## IA nunca gera geometria

A IA interpreta intenção.

Quem gera geometria é o Geometry Kernel.

---

## Plugins não possuem inteligência

Plugins apenas convertem o Universal Engineering Model para um software CAD.

Toda inteligência permanece no núcleo.

---

## Universal Engineering Model

Existe apenas um modelo oficial.

Todos os módulos utilizam essa representação.

---

## Determinismo

A mesma entrada deve sempre produzir o mesmo resultado.

Não existem resultados probabilísticos no motor geométrico.

---

## Extensibilidade

Qualquer Engine poderá ser substituído sem alterar o restante da arquitetura.

---

## Framework Independence

O domínio jamais dependerá de Spring, banco de dados ou frameworks.