# Tools Payment API

## Descrição
Este projeto é uma implementação de uma API de Pagamentos para um banco na área de cartões de crédito, desenvolvido como parte do processo seletivo da empresa Tools. A API suporta operações de pagamento, estorno e consulta de transações.

## Tecnologias Utilizadas
- Java 21
- Spring Boot 3.2.2
- Maven para gerenciamento de dependências e build do projeto
- Lombok para redução de boilerplate code em modelos Java
- Spring Web para criar endpoints REST
- Jackson para serialização/deserialização de objetos JSON

## Dependências do Projeto
As principais dependências incluídas no `pom.xml` são:
- `spring-boot-starter-web`: Para suportar a criação de aplicações web, incluindo RESTful, utilizando o Spring MVC.
- `spring-boot-starter-test`: Para suportar testes unitários e de integração com frameworks como JUnit, Hamcrest e Mockito.
- `lombok`: Para reduzir o código repetitivo para modelos através de anotações.

## Configurações
O arquivo `application.properties` inclui configurações essenciais para o projeto:
- `spring.main.banner-mode=off`: Desativa o banner padrão do Spring Boot que é mostrado no console ao iniciar a aplicação, reduzindo a quantidade de informações no console.
- `server.http2.enabled=true`: Habilita o suporte ao HTTP/2 no servidor, permitindo uma comunicação mais eficiente e rápida entre o cliente e o servidor melhorando o desempenho.
- `server.compression.enabled=true`: Ativa a compressão de respostas HTTP, o que pode reduzir o tamanho dos dados enviados do servidor para o cliente, melhorando o tempo de carregamento para o usuário e desempenho da aplicação.

## Como Executar
Para executar a aplicação, siga os passos:
1. Clone o repositório: `git clone` `https://github.com/jeferson0306/ToolsChallenge.git`
2. Navegue até a pasta do projeto: `cd tools-challenge`
3. Execute a aplicação: `./mvnw spring-boot:run`

## Endpoints
A API define os seguintes endpoints:
- `POST /api/v1/transacoes/pagamento`: Realiza um pagamento.
- `POST /api/v1/transacoes/estorno`: Realiza o estorno de um pagamento.
- `GET /api/v1/transacoes/{id}`: Consulta uma transação pelo ID.
- `GET /api/v1/transacoes/all`: Lista todas as transações.

## Contato
- LinkedIn: [Tools Software](https://www.linkedin.com/company/toolssoftware/)
- Website: [https://tools.com.br/](https://tools.com.br/)

---

Desenvolvido por Jeferson Siqueira como parte do desafio de seleção para a empresa Tools.
- LinkedIn: [Jeferson Siqueira](https://www.linkedin.com/in/developerjefersonsiqueira/)
- Email: [jeferson0306@gmail.com](jeferson0306@gmail.com)
