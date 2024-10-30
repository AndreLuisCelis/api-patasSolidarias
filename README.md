# Patas Solidárias API

![GitHub repo size](https://img.shields.io/github/repo-size/AndreLuisCelis/api-patasSolidarias)
![GitHub last commit](https://img.shields.io/github/last-commit/AndreLuisCelis/api-patasSolidarias)
![GitHub contributors](https://img.shields.io/github/contributors/AndreLuisCelis/api-patasSolidarias)

Uma API desenvolvida para facilitar o cadastro de adotantes de animais, ajudando a ONG Patas Solidárias a gerenciar informações de pessoas interessadas em adotar animais.

## 📋 Índice
- [Sobre o Projeto](#sobre-o-projeto)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Pré-requisitos](#pré-requisitos)
- [Instalação](#instalação)
- [Uso](#uso)
- [Endpoints](#endpoints)
- [Contribuição](#contribuição)
- [Licença](#licença)

---

## Sobre o Projeto

A API Patas Solidárias foi desenvolvida para permitir o cadastro e gerenciamento de informações de adotantes de animais, visando auxiliar o processo de adoção realizado pela ONG Patas Solidárias. A aplicação utiliza uma arquitetura RESTful para fornecer endpoints para a criação, leitura, atualização e exclusão de registros de adotantes.

## Tecnologias Utilizadas

- **Java** - Linguagem de programação principal.
- **Spring Boot** - Framework para criar a API REST.
- **MongoDB Atlas** - Banco de dados NoSQL em nuvem para armazenar informações dos adotantes.
- **Docker** - Para conteinerização da aplicação.
- **Swagger** - Documentação da API.
  
## Pré-requisitos

Antes de iniciar, certifique-se de ter os seguintes itens instalados:

- [Java JDK 17+](https://openjdk.org/projects/jdk/17/)
- [Maven](https://maven.apache.org/)
- [Docker](https://www.docker.com/) (opcional, se preferir rodar a API em um container)
- **Conta no MongoDB Atlas** - para configuração do banco de dados remoto

## Instalação

1. Clone o repositório:

    ```bash
    git clone https://github.com/AndreLuisCelis/api-patasSolidarias.git
    ```

2. Acesse o diretório do projeto:

    ```bash
    cd api-patasSolidarias
    ```

3. Configure a conexão com o MongoDB Atlas:

   No arquivo `application.properties`, localizado em `src/main/resources`, adicione a string de conexão do MongoDB Atlas:

    ```properties
    spring.data.mongodb.uri=mongodb+srv://<usuario>:<senha>@cluster0.mongodb.net/patasSolidarias?retryWrites=true&w=majority
    ```

    Substitua `<usuario>` e `<senha>` pelas suas credenciais do MongoDB Atlas e `patasSolidarias` pelo nome do seu banco de dados.

4. Compile e construa o projeto com Maven:

    ```bash
    mvn clean install
    ```

5. Inicie a aplicação:

    ```bash
    mvn spring-boot:run
    ```

6. (Opcional) Execute o projeto em um container Docker:

    ```bash
    docker-compose up
    ```

## Uso

Após iniciar a API, você pode acessar a documentação dos endpoints via Swagger na URL:

