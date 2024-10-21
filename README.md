API de gerenciamento de uma loja utilizando Spring Boot com persistência em PostgreSQL.

Este projeto tem como objetivo fornecer uma API REST para gerenciamento de lojas e produtos, permitindo operações CRUD.

Tecnologias usadas: Spring Boot, PostgreSQL, Java 11, JUnit, Swagger.

Para Clonar o repositório utilize:

git clone https://github.com/Shifther/store-api-spring.git
cd store-api-spring
./mvnw spring-boot:run


caso precise testar:
./mvnw test


## Exemplos de uso
### Criar um produto
**POST /api/products**
```json
{
  "name": "Notebook",
  "price": 2999.99,
  "quantity": 10
}
```
feat: adicionar endpoint para listagem de produtos paginados
