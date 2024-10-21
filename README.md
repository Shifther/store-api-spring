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
  "producValue": 1399.99,
  "nameProduct": "Celular",
  "producDescrpit": "Sansumg galaxy",
  "emPromocao": true,
  "vendido": true
}

```
feat: adicionar endpoint para listagem de produtos paginados
