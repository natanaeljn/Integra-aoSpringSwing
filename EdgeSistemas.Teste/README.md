<h1 align="center">
  Edge CRUD
</h1>

<p align="center">

</p>

CRUD Basica para testes!



## Tecnologias
 
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [H2](https://www.h2database.com/html/main.html)


## Práticas adotadas

- SOLID
- API REST
- Consultas com Spring Data JPA
- Injeção de Dependências
- Tratamento de respostas de erro


## Como Executar


A API poderá ser acessada em [localhost:8080](http://localhost:8080).


## API Endpoints :

Para fazer as requisições HTTP abaixo, foi utilizada a ferramenta [Postman](https://www.postman.com/downloads/):

- Criar Produto  
```
$ http://localhost:8080/produtos

[
{

    "nome": "Chocolate",
    "preco": 8.50 ,
    "marca" : "Nestle"

}
]
```



- Buscar todos os produtos:
```
$ GET http://localhost:8080/produtos/todosProdutos


- Buscar produtos por codigo (ID) :
```
$ GET http://localhost:8080/produtos/buscaPorCodigo/1



- Editar produto , passando o id do produto que deseja editar:

$ http PUT http://localhost:8080/produtos/alterarProduto/1


- Deletar Produto pelo codigo:
```
$ http DELETE http://localhost:8080/produtos/deletarProduto/1



- Buscar produtos pelo nome
```
$ http GET http://localhost:8080/produtos/buscaPorNome/Chocolate




- Buscar Produtos pelo nome da marca 
```
$ http GET http://localhost:8080/produtos/buscaPorMarca/nestle


```