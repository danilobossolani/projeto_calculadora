# Projeto Calculadora — FinançApp

> Projeto acadêmico desenvolvido com foco em Qualidade de Software, Testes, Refatoração, Documentação e Versionamento.

---

## 1. Identificação do Projeto

**Projeto:** Projeto Calculadora  
**Contexto:** FinançApp  
**Aluno:** Danilo Bossolani  
**RA:** 250902  
**Curso:** Análise e Desenvolvimento de Sistemas — FACENS  
**Disciplina:** UX/UI e Testes de Software  
**Professor:** Daniel Ohata  
**Semestre:** 2026.2  

---

# 2. Visão Geral

O projeto consiste no desenvolvimento de um módulo de cálculos matemáticos básicos em Java para a startup fictícia **FinançApp**.

O módulo foi desenvolvido com o objetivo de ser utilizado futuramente em funcionalidades de controle financeiro, como:

- orçamento mensal;
- divisão de despesas;
- projeções financeiras;
- cálculos auxiliares.

Além do funcionamento correto das operações, o projeto aplica práticas de qualidade de software relacionadas a:

- testes;
- tratamento de erros;
- refatoração;
- documentação;
- versionamento;
- manutenção de código.

---

# 3. Problema

Durante o desenvolvimento da aplicação FinançApp, foi identificada a necessidade de criar um módulo matemático reutilizável.

Entretanto, a equipe definiu que o módulo não deveria apenas funcionar corretamente, mas também apresentar:

- código legível;
- testes automatizados;
- tratamento de falhas;
- documentação técnica;
- controle de versões;
- facilidade de manutenção.

O desafio consiste, portanto, em desenvolver uma solução funcional e ao mesmo tempo aplicar boas práticas de Engenharia de Software.

---

# 4. Objetivo

## 4.1 Objetivo Geral

Desenvolver uma calculadora em Java aplicando práticas de qualidade, testes, documentação, refatoração e versionamento.

## 4.2 Objetivos Técnicos

- implementar operações matemáticas básicas;
- tratar entradas inválidas;
- impedir divisão por zero;
- desenvolver testes automatizados;
- refatorar o código sem alterar seu comportamento;
- documentar classes e métodos com JavaDoc;
- gerar documentação HTML;
- utilizar Git e GitHub;
- organizar commits e branches;
- manter documentação técnica no README.

---

# 5. Escopo Funcional

A aplicação deverá oferecer as seguintes operações:

| ID | Funcionalidade | Descrição | Status |
|---|---|---|---|
| RF01 | Soma | Soma dois números inteiros | ✅ |
| RF02 | Subtração | Subtrai dois números inteiros | ✅ |
| RF03 | Multiplicação | Multiplica dois números inteiros | ✅ |
| RF04 | Divisão | Divide dois números inteiros | ✅ |
| RF05 | Validação de divisão | Impede divisão por zero | ✅ |
| RF06 | Operação inválida | Trata operadores não suportados | ✅ |

---

# 6. Requisitos Não Funcionais

| ID | Categoria | Requisito |
|---|---|---|
| RNF01 | Qualidade | O código deve possuir organização e legibilidade |
| RNF02 | Testabilidade | As operações devem possuir testes automatizados |
| RNF03 | Manutenção | O código deve permitir refatoração sem alteração funcional |
| RNF04 | Documentação | Classes e métodos devem possuir JavaDoc |
| RNF05 | Versionamento | O projeto deve utilizar Git e GitHub |
| RNF06 | Confiabilidade | Erros não devem interromper inesperadamente a execução |

---

# 7. Tecnologias Utilizadas

| Tecnologia | Versão | Utilização |
|---|---|---|
| Java | 21 | Desenvolvimento |
| JDK (OpenJDK) | 21 | Compilação (`javac`) e execução (`java`) |
| Testes | — | Classe `TesteCalculadora` com método `main`, conforme modelo da aula |
| Git | 2.x | Controle de versão |
| GitHub | — | Repositório remoto |
| JavaDoc | 21 | Documentação HTML |
| IDE | VS Code | Ambiente de desenvolvimento |

---

# 8. Estrutura do Projeto

```text
projeto_calculadora/
│
├── src/
│   └── calculadora/
│       └── Calculadora.java
│
├── test/
│   └── calculadora/
│       └── TesteCalculadora.java
│
├── docs/
│   └── index.html
│
├── images/
│   ├── testes/
│   ├── javadoc/
│   └── refatoracao/
│
├── README.md
└── .gitignore
```

---

# 9. Operações

Todas as operações são acessadas pelo método `calc(int a, int b, String op)` da classe `Calculadora`.

| Operador | Operação | Exemplo | Resultado |
|---|---|---|---|
| `+` | Soma | `calc(2, 3, "+")` | `5` |
| `-` | Subtração | `calc(10, 4, "-")` | `6` |
| `*` | Multiplicação | `calc(3, 5, "*")` | `15` |
| `/` | Divisão inteira | `calc(8, 2, "/")` | `4` |

## 9.1 Tratamento de erros

| Situação | Exemplo | Comportamento |
|---|---|---|
| Divisão por zero | `calc(8, 0, "/")` | Exibe `Erro: divisão por zero não é permitida.` e retorna `0` |
| Operador inválido | `calc(5, 5, "x")` | Exibe `Erro: operação inválida: x` e retorna `0` |
| Operador nulo | `calc(1, 1, null)` | Tratado como operador inválido, sem `NullPointerException` |

Em nenhum dos casos o programa é interrompido.

---

# 10. Como Executar

Na raiz do projeto:

```bash
# Compilar
javac -encoding UTF-8 -d bin src/calculadora/*.java test/calculadora/*.java

# Executar os testes
java -cp bin calculadora.TesteCalculadora
```

Para gerar a documentação JavaDoc na pasta `docs/`:

```bash
javadoc -private -author -version -encoding UTF-8 -docencoding UTF-8 -charset UTF-8 -d docs -sourcepath src:test calculadora
```

> No Windows, use `src;test` no lugar de `src:test`.

---

# 11. Testes

A classe `TesteCalculadora` executa seis casos de teste. Para cada um, são exibidos a entrada utilizada, o resultado esperado, o resultado obtido e o status.

| Caso | Entrada | Esperado | Obtido | Status |
|---|---|---|---|---|
| Soma | `2, 3, "+"` | 5 | 5 | PASSOU |
| Subtração | `10, 4, "-"` | 6 | 6 | PASSOU |
| Multiplicação | `3, 5, "*"` | 15 | 15 | PASSOU |
| Divisão | `8, 2, "/"` | 4 | 4 | PASSOU |
| Divisão por zero | `8, 0, "/"` | 0 + mensagem de erro | 0 + mensagem de erro | PASSOU |
| Operação inválida | `5, 5, "x"` | 0 + mensagem de erro | 0 + mensagem de erro | PASSOU |

## 11.1 Execução dos testes

![Execução dos testes na branch main](images/testes/testes_main.png)

---

# 12. Documentação JavaDoc

A documentação foi gerada com a ferramenta `javadoc` e está na pasta [`docs/`](docs/). Para visualizar, abra o arquivo `docs/index.html` no navegador.

Foram documentados: classes, atributos, construtores, métodos, parâmetros e retornos, usando as tags `@author`, `@version`, `@param` e `@return`.

## 12.1 Página do pacote

![JavaDoc - pacote calculadora](images/javadoc/javadoc_index_main.png)

## 12.2 Página da classe Calculadora

![JavaDoc - classe Calculadora](images/javadoc/javadoc_calculadora_main.png)

---

# 13. Branches

| Branch | Conteúdo |
|---|---|
| `main` | Versão inicial da calculadora, com testes e documentação |
| `Refatoracao` | Versão refatorada do código, com os testes executados novamente |

---

# 14. Repositório

https://github.com/danilobossolani/projeto_calculadora
