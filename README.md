
# Beneficiarios-API


Aplicação para manter o cadastro de Beneficiários de um plano de saúde. 

Aplicação foi desenvolvida com Java 17 e utilizando o framework Spring Boot e conceitos clean code e design patterns. 

Conforme a representação de dependencia colocada no diagrama, para um beneficiário fazer sentindo, é nescessario ter pelo menos um documento no cadastrato, e para garantir isso, foi implementado algumas valições na API.














## Documentação da API

#### Cadastrar um beneficiário junto com seus documentos.

```http
  POST /beneficiarios
```
Pasar no escopo da requisição json com os dados no beneficiário, como exemplo:

```json
{    
    "nome": "João da Silva",
    "telefone": "1112344321",
    "dataNascimento": "21/02/1980",
    "documentos": [
        {            
            "tipoDocumento": "RG",
            "descricao": "111111-1"
        },
        {         
            "tipoDocumento": "CPF",
            "descricao": "111.111.111-11"
        }
    ]
}
```

#### Listar todos os beneficiários cadastrados.

```http
  GET /beneficiarios
```

#### Listar todos os documentos de um beneficiário a partir de seu id.

```http
  GET /beneficiarios/{beneficiarioId}/documentos
```
Ao chamar esse endpoint, teremos este resultado conforme o exemplo:

```json
[
    {
        "id": 1,
        "tipoDocumento": "RG",
        "descricao": "111111-1"
    },
    {
        "id": 2,
        "tipoDocumento": "CPF",
        "descricao": "111.111.111-11"
    }
]
```
#### Atualizar os dados cadastrais de um beneficiário.

```http
  PUT /beneficiarios/{id}
```
Pasar no escopo da requisição json com os dados no beneficiário, como exemplo:

```json
{    
    "nome": "João da Silva - Editado",
    "telefone": "1112344321",
    "dataNascimento": "21/02/1980",
    "documentos": [
        {            
            "id": 1,
            "tipoDocumento": "RG",
            "descricao": "222222-2"
        },
        {         
            "id": 2,
            "tipoDocumento": "CPF",
            "descricao": "222.222.222-22"
        }
    ]
}
```

#### Remover um beneficiário
```http
  DELETE /beneficiarios/{id}
```



## Stack utilizada

**Back-end:** Java 17, Spring Boot, Banco de dados embarcado H2.


## Build

Baixar o fonte da api, e executar partir da classe TesteEkanApplication. Que esta no diretorio:
```cmd
/src/main/java/br/com/ekan/testeEkan
```
