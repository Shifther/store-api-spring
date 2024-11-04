# Store API

## Descrição

A Store API é uma aplicação desenvolvida com Spring Boot que permite gerenciar produtos e vendas em um ambiente de loja virtual. Este projeto foi criado para fins de estudo e demonstração de boas práticas em desenvolvimento de APIs RESTful utilizando Java 23 e Spring Boot.

## Funcionalidades

- **Gerenciamento de Produtos**: Adicionar, atualizar e listar produtos disponíveis.
- **Controle de Vendas**: Registrar vendas e consultar produtos vendidos.
- **Documentação da API**: Interface Swagger para fácil acesso à documentação das rotas disponíveis.

## Tecnologias Utilizadas

- **Java**: JDK 23
- **Spring Boot**: 3.3.4
- **Banco de Dados**: PostgreSQL
- **Documentação**: Swagger
- **Testes**: Spring Boot Test

## Estrutura do Projeto

```plaintext
store-api-spring/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── springoverview/
│   │   │       └── sa/
│   │   │           └── store_api/
│   │   │               ├── config/         # Configurações do Swagger e do banco de dados
│   │   │               ├── controllers/    # Controladores para gerenciar rotas da API
│   │   │               ├── models/         # Modelos de dados para produtos e vendas
│   │   │               ├── services/       # Lógica de negócios
│   │   │               └── StoreApiApplication.java  # Classe principal
│   │   └── resources/
│   │       ├── application.properties      # Configurações da aplicação
│   │       └── static/                     # Arquivos estáticos (se houver)
│   └── test/
│       └── java/
│           └── springoverview/
│               └── sa/
│                   └── store_api/         # Testes unitários e de integração
└── pom.xml                                   # Configuração do Maven
```

## Pré-requisitos

Antes de executar a aplicação, você precisará ter instalado:

- [Java JDK 23+](https://www.oracle.com/java/technologies/javase-jdk23-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)
- [PostgreSQL](https://www.postgresql.org/download/)

## Instalação

1. Clone o repositório:

   ```bash
   git clone https://github.com/Shifther/store-api-spring.git
   ```
Navegue até o diretório do projeto:

```bash

cd store-api-spring
```
Configure o banco de dados PostgreSQL, criando um banco de dados e atualizando as credenciais no arquivo application.properties.

Compile o projeto:

```bash
mvn clean install
```

Execute a aplicação:

```bash
    mvn spring-boot:run
```
Endpoints da API

    GET /api/v1/produtos - Listar todos os produtos
    POST /api/v1/produtos - Adicionar um novo produto
    PUT /api/v1/produtos/{id} - Atualizar um produto existente
    DELETE /api/v1/produtos/{id} - Remover um produto

Acesso à Documentação da API

Após iniciar a aplicação, você pode acessar a documentação interativa da API via Swagger em:

```bash

http://localhost:8080/swagger-ui/
```
Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou pull requests.
Licença

Este projeto está licenciado sob a MIT License.
