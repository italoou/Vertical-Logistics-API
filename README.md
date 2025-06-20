# VerticalLogisticsAPI
Esse repositório implementa o VerticalLogisticsAPI: API de processamento de arquivos e consulta de pedidos, projeto feito com as tecnologias Java, Spring e PostgreSQL

# Objetivo
O VerticalLogisticsAPI tem como objetivo possibilitar aos usuários a importação de um arquivo com dados de pedidos realizados por usuários, realizando o processamento do mesmo e disponibilizando as informações via requisição Rest pela propria API.

# Tecnologias
- Java 21
- Spring 3.5.0
- Postgresql
- Docker

# Funcionalidade idealizadas
Dentre as funcionalidade idealizadas estavam 
- Importação do arquivo (Implementada)
- processamento e salvamento dos dados (Implementada)
- Busca de pedidos filtrada (Implementada)

# Como executar

## Requisitos

- java 21
- spring 3.5.0
- postgresql
- docker (não obrigatório)

## Clone o repositório 

```bash
git clone https://github.com/italoou/Vertical-Logistics-API
cd Vertical-Logistics-API
```

## .ENV

Remova o .sample do nome do arquivo .env.sample, por padrão os dados presentes no .env são os abaixo
```json
DATABASE_HOST=vertical-logistics-postgres
DATABASE_PORT=5432
DATABASE_USER=vertical-logistics-api
DATABASE_PASSWORD=vertical-logistic
DATABASE_NAME=VerticalLogisticsDB
```

## Execução Docker

```bash
docker-compose build
docker-compose up -d
```

## Execução Terminal

```bash
mvn clean install
java -jar target/Vertical-Logistics-API-0.0.1-SNAPSHOT.jar
```

## Acesso

Após a inicialização dos containers, ou execução do código, a API estará disponivel na porta padrão, qualquer necessidade de modificação deverá ser replicada no código.

- Backend: http://localhost:8080

# Autoria

Esse projeto foi desenvolvido por Ítalo Lima
- Github: https://github.com/italoou
- WebSite: https://italolima.com/