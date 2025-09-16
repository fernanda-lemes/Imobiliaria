# Sistema de Gestão de Imobiliária

Este é um sistema desenvolvido em **Java** para gerenciar uma imobiliária familiar. O sistema é operado via **terminal** e utiliza **JDBC** para persistência em banco de dados **MySQL**.


## Funcionalidades

- Cadastrar imóveis com suas características (endereço, tipo, valor do aluguel, disponibilidade)
- Cadastrar clientes
- Cadastrar contratos de aluguel (valor, data de início e fim, vínculo com cliente e imóvel)
- Listar imóveis disponíveis para aluguel
- Listar contratos ativos
- Listar clientes com mais contratos
- Listar contratos expirando nos próximos 30 dias


## Estrutura do Projeto

imobiliaria/

├─ src/

│ ├─ model/ # Classes do modelo (Imovel, Cliente, Contrato)

│ ├─ dao/ # Acesso ao banco de dados (CRUD)

│ ├─ service/ # Serviços de relatório

│ └─ app/ # Classe principal Main.java

├─ sql/

│ └─ script.sql # Script de criação e inserção de dados

├─ diagrams/

│ ├─ DiagramaMER.pdf

│ └─ DiagramaClasse.pdf

└─ README.md


## Configuração do Banco de Dados

1. Instale o **MySQL** e crie um usuário.
2. Execute o script SQL disponível em `sql/script.sql` para criar o banco e as tabelas:

```sql
mysql -u root -p < sql/script.sql
```


## Como Executar

- **Compile o projeto:**

javac -d bin src/model/*.java src/dao/*.java src/service/*.java src/app/*.java


- **Execute o sistema:**

java -cp bin app.Main


O menu interativo será exibido no terminal e você poderá escolher as opções desejadas.

---

## Exemplos de Uso

- Cadastrar um imóvel: Informe endereço, tipo e valor do aluguel.

- Cadastrar cliente: Informe nome, CPF e telefone.

- Cadastrar contrato: Informe ID do cliente, ID do imóvel, datas de início e fim, e valor.

- Relatórios: Listam imóveis disponíveis, contratos ativos, clientes com mais contratos e contratos próximos do vencimento.

---

## Diagramas

**Diagrama de Classes:** diagrams/DiagramaClasse.pdf

Representa as classes Imovel, Cliente, Contrato e suas relações.

**Relações:** 
- Contrato possui referências a Cliente e Imovel.
- Imovel e Cliente não possuem referência direta entre si, apenas via Contrato.

**Diagrama MER:** diagrams/DiagramaMER.pdf

Mostra as tabelas do banco de dados e suas chaves primárias/estrangeiras.

**Explicação:**
- Cliente → Contrato: Um cliente pode ter vários contratos (1:N).
- Imovel → Contrato: Um imóvel pode ter vários contratos ao longo do tempo, mas apenas um ativo por vez (1:N).
- Chaves primárias: id em cada tabela.
- Chaves estrangeiras: Contrato.idCliente → Cliente.id, Contrato.idImovel → Imovel.id.

---

**Observações:**

- O sistema atual funciona via terminal.
- Todos os dados são persistidos no banco MySQL.
- Ao cadastrar um contrato, o imóvel relacionado será marcado automaticamente como indisponível.

---

Autores:
[Fernanda Lemes, Héryck Teixeira]
