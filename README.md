# ⛽ Sistema de Gestão de Posto de Combustível

Aplicação desenvolvida em **Java** com **Spring Boot** para o desafio técnico de vaga Júnior. O sistema gerencia o cadastro de combustíveis, bombas e realiza o registro de abastecimentos com cálculo automático de valores e litragem, persistindo os dados em banco relacional.

## 📌 Funcionalidades Implementadas

O projeto atende a todos os requisitos propostos no desafio:

✅ **CRUD de Tipos de Combustível**
   - Criação, Listagem, Atualização e Remoção.
   - Dados: Nome e Preço por litro.

✅ **CRUD de Bombas de Combustível**
   - Cadastro de bombas vinculadas a um tipo de combustível.
   - Listagem e gerenciamento completo.

✅ **Gestão de Abastecimentos**
   - Registro contendo: Bomba utilizada, Data/Hora, Valor Total e Litros.
   - **Regra de Negócio:** O sistema calcula automaticamente a litragem abastecida baseada no valor pago e no preço do combustível da bomba (`Litros = Valor / Preço`).
   - **Atualização Inteligente:** Em caso de correção de valor (PUT), os litros são recalculados automaticamente.

## 🌟 Diferenciais Técnicos

- **Arquitetura em Camadas:** Projeto organizado em `Controller` (API), `Service` (Regras de Negócio), `Repository` (Persistência) e `Model` (Entidades).
- **API RESTful:** Utilização correta dos verbos HTTP (GET, POST, PUT, DELETE).
- **Persistência Real:** Banco de dados **MySQL** configurado (os dados não são perdidos ao reiniciar a aplicação).
- **Documentação Automática:** Interface **Swagger UI** integrada para testes visuais.

## 🛠️ Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3** (Web, Data JPA)
- **MySQL** (Banco de Dados)
- **Swagger / OpenAPI** (Documentação)
- **Maven** (Gerenciamento de Dependências)

## ⚙️ Como Rodar o Projeto

### Pré-requisitos
- Java 17 instalado.
- MySQL instalado e rodando (porta padrão 3306).

### Passo a Passo

1. **Clone este repositório:**
   ```bash
   git clone https://github.com/Mauro-Roncata/vaga-junior.git

### Passo 2: Configurar o Banco de Dados
1. Acesse seu banco de dados MySQL e crie um schema vazio:
   ```sql
   CREATE DATABASE posto_db;
   ```

2. No projeto, abra o arquivo `src/main/resources/application.properties` e configure seu usuário e senha:
   ```properties
   spring.datasource.username=root
   spring.datasource.password=SUA_SENHA_AQUI
   ```

### Passo 3: Rodar a Aplicação
No terminal, dentro da pasta raiz do projeto (onde tem o arquivo `pom.xml`), execute:

**No Windows:**
```bash
./mvnw.cmd spring-boot:run
```

**No Linux/Mac:**
```bash
./mvnw spring-boot:run
```

> **Nota:** Na primeira execução, o Maven irá baixar as dependências, o que pode levar alguns minutos. Aguarde a mensagem: `Started App in ... seconds`.

---

## 📚 Documentação da API (Swagger UI)

Para facilitar os testes sem a necessidade de instalar ferramentas externas (como Postman), o projeto inclui o **Swagger**.

Com a aplicação rodando, acesse:
👉 **http://localhost:8080/swagger-ui.html**

---

## 📂 Estrutura do Projeto

O código foi organizado seguindo o padrão MVC e Arquitetura em Camadas para garantir manutenibilidade:

```
src/main/java/com/mauroroncata
│
├── controller   # Camada que expõe a API REST (Endpoints)
├── service      # Camada de Regras de Negócio (Cálculos e Validações)
├── repository   # Camada de Acesso ao Banco de Dados (Interfaces JPA)
└── model        # Camada de Entidades (Tabelas do Banco)
```

---

Desenvolvido por **Mauro Roncata**