# Trabalho2-API
Trabalho Avaliativo de API

# Trabalho em Grupo de API REST

## 👥 Equipe
* Almir Acacio - [GitHub](https://github.com/AlmirAcacio)
* Elisa Barbosa Kappaun - [GitHub](https://github.com/elisakappaun-netizen?tab=repositories)
* Maicon Muniz - [GitHub](https://github.com/NezyMZ)
* Rafael Couto - [GitHub](https://github.com/RafaelSilvc)
* Rebeka Cardoso - [GitHub](https://github.com/rebekaoc)

# 📊 API de Controle de Lançamento de Vendas

Projeto desenvolvido como avaliação para a disciplina de API REST. Consiste em um sistema de gerenciamento de vendas que aplica conceitos avançados de Mapeamento Objeto-Relacional (ORM), herança de entidades, Data Transfer Objects (DTOs) e documentação automatizada.

## 🚀 Tecnologias Utilizadas
* **Java 17+**
* **Spring Boot**
  * Spring Web
  * Spring Data JPA
  * Bean Validation
  * Spring Boot DevTools
* **Bancos de Dados:** H2 Database (Dev) e PostgreSQL (Prod)
* **Documentação:** Swagger (Springdoc OpenAPI)
* **Gerenciador de Pacotes:** Maven

---

## 🏗️ Estrutura e Regras de Negócio

### 1. Entidades e Herança (Estratégia JPA)
O projeto implementa herança de entidades para a classe `Vendedor`, otimizando a criação das tabelas no banco de dados com as seguintes variações:
* **Vendedor (Superclasse):** Código, nome, e-mail e salário.
* **Vendedor Autônomo:** Herda de `Vendedor` e acrescenta `comissao`.
* **Vendedor Profissional:** Herda de `Vendedor` e acrescenta `cnpj`.

### 2. Relacionamentos
* **Vendedor 1 ➔ N LançamentoVendas:** Um vendedor pode possuir um ou vários lançamentos de vendas atrelados a ele.

### 3. Validações de Entrada (@Valid)
A API conta com segurança e validação de dados rigorosa:
* **Nome:** Não pode ser nulo ou vazio (`@NotBlank`).
* **E-mail:** Validação de formato de e-mail válido (`@Email`).
* **Salário:** O valor não pode ser inferior ao salário mínimo vigente (`@Min(value = 1412.0)`).

### 4. Tratamento Global de Exceções
Possui uma classe com `@ControllerAdvice` para interceptar e tratar erros padronizados:
* Tratamento para erros de **Validação (Status 400 - Bad Request)**, exibindo os campos incorretos.
* Tratamento para **Recursos Não Encontrados (Status 404 - Not Found)**.

---

## ⚙️ Perfis de Execução (Profiles)

A aplicação foi configurada para trabalhar com dois ambientes distintos, definidos via `application.properties`:

* **Perfil `dev` (Padrão):** Utiliza o banco de dados H2, salvando os dados localmente em formato de arquivo para persistência durante o desenvolvimento.
* **Perfil `prod`:** Configurado para se conectar a um banco de dados PostgreSQL real.

*Nota: A tabela de vendedores do banco de dados está populada com 1.000 registros fictícios gerados via Mockaroo.*

---

## 🛣️ Endpoints da API

A API expõe as seguintes rotas exclusivamente para a gestão de `LancamentoVendas`, utilizando DTOs (`LancamentoVendasResponseDTO`) para retornar apenas os dados cruciais (Data da venda, Valor da venda e Nome do vendedor):

* `GET /lancamentos/{id}` - Retorna os dados de um lançamento específico formatado via DTO.
* `POST /lancamentos` - Insere um novo lançamento de venda no sistema.

---

## 📚 Documentação (Swagger)

A API está totalmente documentada via Swagger. Com a aplicação em execução, você pode testar os endpoints e visualizar a estrutura dos objetos JSON acessando:

**URL de acesso local:** `http://localhost:8080/swagger-ui.html`
