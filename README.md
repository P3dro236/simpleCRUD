# simpleCRUD

API REST simples para gerenciamento de usuários, desenvolvida com Spring Boot.

> **Projeto para estudo:** este repositório foi criado com o objetivo de praticar a construção de uma API CRUD, integração com banco de dados e organização básica de uma aplicação Java. Não é recomendado utilizá-lo em produção sem melhorias de segurança, validação e tratamento de erros.

## Tecnologias

- Java 24
- Spring Boot 3.4.4
- Spring Web
- Spring Data JPA
- PostgreSQL
- Maven

## Funcionalidades

- Criar usuários
- Listar todos os usuários
- Buscar um usuário por ID
- Atualizar o e-mail de um usuário
- Excluir um usuário

## Pré-requisitos

- Java 24
- PostgreSQL
- Maven (opcional, pois o projeto inclui o Maven Wrapper)

## Configuração do banco de dados

Por padrão, a aplicação utiliza as seguintes configurações em `src/main/resources/application.properties`:

```properties
URL: jdbc:postgresql://localhost:3035/api_usuario
Usuário: api_user
Senha: password
```

Crie o banco e o usuário no PostgreSQL ou altere essas propriedades conforme o seu ambiente.

## Executando o projeto

No Linux/macOS:

```bash
./mvnw spring-boot:run
```

No Windows:

```bat
mvnw.cmd spring-boot:run
```

A aplicação será iniciada na porta padrão `8080`.

## Endpoints

| Método | Endpoint | Descrição |
|---|---|---|
| `GET` | `/users` | Lista todos os usuários |
| `GET` | `/users/{id}` | Busca um usuário por ID |
| `POST` | `/users` | Cria um usuário |
| `PUT` | `/users/{id}?newEmail=novo@email.com` | Atualiza o e-mail |
| `DELETE` | `/users/{id}` | Exclui um usuário |

### Exemplo de criação

```http
POST /users
Content-Type: application/json
```

```json
{
  "completeName": "Maria da Silva",
  "email": "maria@example.com",
  "password": "senha123"
}
```

## Testes

Para executar os testes:

```bash
./mvnw test
```

## Licença

Este projeto é destinado a fins educacionais e de estudo.
