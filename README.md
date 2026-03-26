# 🇧🇷 TaxaddAPI (Simulador da Reforma Tributária)

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Swagger](https://img.shields.io/badge/-Swagger-%23Clojure?style=for-the-badge&logo=swagger&logoColor=white)

Em ano de eleição, muito se fala sobre economia, mas pouco sobre o desafio técnico nos bastidores das empresas. A **TaxaddAPI** é um motor de cálculo fiscal backend desenvolvido para simular e comparar o impacto financeiro da **Reforma Tributária Brasileira**.

O sistema calcula os impostos de uma transação comercial utilizando as regras do modelo atual (ICMS, PIS, COFINS) e as compara com o novo modelo de IVA Dual (IBS e CBS) em milissegundos.

##  Objetivo do Projeto
Demonstrar a aplicação de Engenharia de Software e Design Patterns na resolução de um problema de negócio real e de altíssima demanda atual: a transição de milhares de sistemas brasileiros para o novo modelo tributário.

##  Tecnologias e Arquitetura

* **Java 17+**
* **Spring Boot 3** (Spring Web)
* **Lombok** (Redução de boilerplate)
* **Springdoc OpenAPI (Swagger)** (Documentação interativa)
* **Jakarta Validation** (Validação de dados de entrada)

###  Design Pattern: Strategy
Para evitar um código rígido e cheio de `if/else`, o coração financeiro da aplicação foi construído utilizando o **Strategy Pattern**.
Cada imposto implementa uma interface comum (`TaxStrategy`). Isso garante:
1.  **Baixo Acoplamento:** Novas regras ou alterações de alíquotas do governo não quebram o código existente.
2.  **Manutenção Fácil:** Permite criar regras de transição anuais de forma isolada.
3.  **Precisão Financeira:** Todos os cálculos utilizam `BigDecimal` e arredondamento comercial (`HALF_UP`) para evitar erros de ponto flutuante comuns do `Double`.

## ⚙️ Como Executar o Projeto

1. Clone o repositório:
```bash
git clone (hhttps://github.com/mathesilva/tax-reform-tributaria.git)
Entre na pasta do projeto:
```

2. Entre na pasta do projeto:
```bash
cd tax-reform-tributaria

Execute a aplicação (usando o Maven Wrapper embutido):

Bash
./mvnw spring-boot:run
```

### Documentação da API (Swagger)

A API está totalmente documentada utilizando o Swagger UI. Após rodar o projeto, acesse o link abaixo no seu navegador para visualizar os endpoints e testar as requisições em tempo real:

👉 http://localhost:8080/swagger-ui.html

### Exemplo de Uso

**Endpoint:** POST /api/v1/taxes/simulate

**Payload de Entrada (JSON):**
````
JSON
{
  "produto": "Notebook Dell",
  "preco": 5000.00,
  "estado": "SP",
  "tipoEmpresa": "LUCRO_PRESUMIDO",
  "categoria": "Tecnologia",
  "anoSimulacao": 2026
}
````
**Resposta de Saída (JSON):**
````
JSON
{
  "modeloAtual": {
    "icms": 900.00,
    "pis": 82.50,
    "cofins": 380.00,
    "totalImpostos": 1362.50
  },
  "novoModelo": {
    "cbs": 450.00,
    "ibs": 900.00,
    "totalImpostos": 1350.00
  },
  "diferenca": -12.50
}
(Valores negativos na diferença indicam economia tributária com o novo modelo).
````

👨‍💻 Dev

Matheus Faias
