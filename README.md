# timesheet

Para iniciar o projeto primeiro deve executar o comando "docker-compose up" e logar no banco na url http://localhost:16543/ com a email e senha admin@admin.com e senha Teste123 e se conectar com o servidor postgress nome do DB é timesheet user postgress e senha admin e porta 5432 e dentro do database timesheet criar dois schemas auth e projects .

Uma vez criado o banco as tabelas serão criadas pelo proprio backend atráves do flyway , para rodar o programa basta abrir na idea e importar as configurações e depois executar os modulos config, eureka, gateway, auth e projects.

Para rodar o front end so executar o npm i e depois o npm start dentro da pasta client/timesheet-app. rodará na url http://localhost:16543/login
