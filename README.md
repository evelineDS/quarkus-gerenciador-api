# 📌 API de Gerenciamento de Tarefas

Este projeto foi desenvolvido como parte de um **processo seletivo para a vaga de Desenvolvedor(a) Back-End**.

O objetivo é construir uma **API RESTful** para gerenciamento de tarefas, que será consumida pela equipe de front-end.

---

## ✅ Requisitos da Proposta

- A API deve seguir o padrão REST
- Linguagem: **Java**
- Framework: **Quarkus** (alternativa sugerida: Spring Boot)
- Banco de dados: **PostgreSQL**
- Deve conter **testes unitários**

---

## 🧰 Tecnologias Utilizadas

| Ferramenta       | Finalidade                                 |
|------------------|---------------------------------------------|
| Java 17+         | Linguagem de programação                    |
| Quarkus          | Framework para construção da API            |
| PostgreSQL       | Banco de dados relacional                   |
| Docker           | Contêiner do banco de dados                 |
| DBeaver          | Gerenciador visual para o PostgreSQL        |
| Postman          | Testes de requisições HTTP                  |
| Flyway           | Controle de versionamento de migrations     |
| JUnit + RESTAssured | Testes unitários e integração             |

---

O projeto usará por padrão o banco de dados teste conforme definido no application.yml para o perfil %Teste.

# Funcionalidades Implementadas

CRUD completo de Pessoa

CRUD completo de Tarefa

Alocação de pessoa à tarefa conforme departamento (PUT /tarefas/alocar/{id})

Finalização de tarefa (PUT /tarefas/finalizar/{id})

# 📌 Observações Finais

O projeto foi desenvolvido com foco em clareza, boas práticas e legibilidade.

O código segue o estilo idiomático do Quarkus, utilizando o Panache ORM para simplificar a persistência.

# 📚 Referências Utilizadas

### Instalação do Docker no Windows (via WSL)
https://www.youtube.com/watch?v=Lgh8JgcYFwM  
https://www.youtube.com/watch?v=vrglmtlPTek  

### Instalação do Docker + uso prático com Quarkus
Canal: @dr.marciosilva83 
  https://www.youtube.com/@dr.marciosilva83
Canal: @rinaldodev
  https://www.youtube.com/@rinaldodev       

### CRUD com Java e Quarkus (vídeo)
Criando um CRUD com Java e Quarkus | JAVA ULTRA RÁPIDO  
https://www.youtube.com/watch?v=osGxaQ8ekTE  

### IA
Auxílio técnico e explicações fornecidos pela IA ChatGPT (OpenAI)  
Suporte oferecido por ChatGPT Plus com modelo GPT-4  
Orientações e códigos sugeridos, testados e ajustados em tempo real.




