# VerticalLogisticsAPI
Esse repositório implementa o VerticalLogisticsAPI: API de processamento de arquivos e consulta de pedidos, projeto feito com as tecnologias Java, Spring e PostgreSQL

# Objetivo
O VerticalLogisticsAPI tem como objetivo possibilitar aos usuários a importação de um arquivo com dados de pedidos realizados por usuários, realizando o processamento do mesmo e disponibilizando as informações via requisição Rest pela propria API.

# Tecnologias
- Java 17
- Spring 3.1.3
- Postgresql
- Docker

# Funcionalidade idealizadas
Dentre as funcionalidade idealizadas estavam 
- Importação do arquivo (Implementada)
- processamento e salvamento dos dados (Implementada)
- Busca de pedidos filtrada (Implementada)

# Como executar

## Requisitos

- java 17
- spring 3.1.3
- postgresql
- docker

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

Após a inicialização dos containers o sistemas estarão disponiveis nas portas padrão, qualquer necessidade de modificação deverá ser replicada no código.

- Frontend: http://localhost:80
- Backend: http://localhost:8030

# Autoria

Esse projeto foi desenvolvido por Ítalo Lima
- Github: https://italolima.com/
- WebSite: https://github.com/italoou