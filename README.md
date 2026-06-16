# Sistema de Academia

Sistema desktop em Java (Swing) para gerenciamento de uma academia, desenvolvido pelos estudantes **Juan Santos** e **Gabriel Liz** para a matéria de Programação Avançada.

O sistema permite o cadastro de alunos, professores e planos de treino, controle de login, registro de exercícios por categoria muscular e processamento de pagamentos (dinheiro, cartão de crédito, cartão de débito e Pix).

## Sumário

- [Tecnologias](#tecnologias)
- [Pré-requisitos](#pré-requisitos)
- [Configuração do Banco de Dados](#configuração-do-banco-de-dados)
- [Como Executar](#como-executar)
- [Arquitetura do Projeto](#arquitetura-do-projeto)
- [Estrutura de Pastas](#estrutura-de-pastas)
- [Principais Módulos](#principais-módulos)
- [Telas (Views)](#telas-views)
- [Testes](#testes)
- [Diagrama UML](#diagrama-uml)

## Tecnologias

- **Java** (Swing para interface gráfica)
- **MySQL** como banco de dados (via JDBC, driver `com.mysql.cj.jdbc.Driver`)
- Padrão **DAO (Data Access Object)** para acesso a dados
- Padrão **Strategy/Herança** para tipos de exercícios e formas de pagamento

## Pré-requisitos

- JDK instalado (Java 8 ou superior)
- MySQL Server em execução
- Driver JDBC do MySQL (`mysql-connector-j`) no classpath do projeto

## Configuração do Banco de Dados

A conexão é feita pela classe `models/BD.java`, que define os seguintes valores padrão:

| Parâmetro | Valor padrão |
|-----------|--------------|
| Host      | `localhost`  |
| Porta     | `3306`       |
| Banco     | `academia`   |
| Usuário   | `root`       |
| Senha     | `2386`       |

Antes de executar o projeto:

1. Crie um banco de dados MySQL chamado `academia`.
2. Ajuste host, usuário e senha em `BD.java` conforme seu ambiente, caso necessário.
3. Crie as tabelas correspondentes às entidades do sistema (aluno, professor, login, plano de treino, pagamento, etc.), de acordo com os campos utilizados pelas classes DAO (`AlunoDAO`, `ProfessorDAO`, `LoginDAO`, `PlanoTreinoDAO`, `PagamentoDAO`).

> ⚠️ **Atenção**: as credenciais do banco estão fixas no código-fonte. Para uso real (fora de ambiente acadêmico), recomenda-se externalizar essas configurações (arquivo `.properties` ou variáveis de ambiente).

## Como Executar

1. Importe o projeto em uma IDE Java (Eclipse, IntelliJ, NetBeans).
2. Adicione o driver JDBC do MySQL (`mysql-connector-j`) como dependência/biblioteca externa.
3. Configure o banco de dados conforme a seção anterior.
4. Execute a classe `src/views/Main.java` (ponto de entrada da aplicação), que abre a tela de login (`GuiLogin`).

## Arquitetura do Projeto

O projeto segue uma organização baseada em camadas, separando **Model**, **DAO (persistência)** e **View (interface gráfica)**:

- **`models`** — Entidades de domínio (Aluno, Professor, Pagamento, Exercícios, etc.) e classes responsáveis pelo acesso ao banco de dados (DAOs).
- **`views`** — Telas Swing (JFrame) que compõem a interface do usuário e interagem com os models/DAOs.
- **`test`** — Classe de teste manual (`MainTeste`) para validar regras de negócio sem depender da interface gráfica.

### Hierarquia de Classes Principais

```
Pessoa (abstrata)
├── Aluno
└── Professor

Exercicios (abstrata)
├── ExercicioComRepeticao (abstrata)
│   ├── AbdominalArticulado, AgachamentoLivre, AgachamentoNoHack,
│   │   BicepsRoscaComHalter, BicepsRoscaNaPolia, Bulgaro,
│   │   DesenvolvimentoComHalter, ElevacaoFrontal, ElevacaoLateral,
│   │   ElevacaoPelvica, LegPress45, MesaFlexora, PranchaFrontal,
│   │   RemadaCurvadaComHalter, RemadaSerrote, Stiff,
│   │   SupinoInclinado, SupinoRetoComBarra, SupinoRetoComHalter,
│   │   TricepsComHalter, TricepsNaPolia, TricepsTesta
│   └── ...
└── ExercicioComTempo (abstrata)
    └── Bicicleta, Eliptico, Escada, Esteira,
        PanturrilhaEmPe, PanturrilhaSentado, PularCorda, WallSit

FormaPagamento (abstrata)
├── Dinheiro
├── Pix
└── Cartao (abstrata)
    ├── CartaoCredito
    └── CartaoDebito

OperacaoBd (interface)
├── AlunoDAO
├── ProfessorDAO
├── LoginDAO
├── PagamentoDAO
└── PlanoTreinoDAO
```

### Fluxo Geral

1. `Main` inicia a aplicação e abre `GuiLogin`.
2. `GuiLogin` valida as credenciais via `Login` / `LoginDAO`, conectando ao banco através de `BD`.
3. Após o login, o usuário é direcionado ao menu correspondente (`GuiMenuPrincipal` ou `GuiMenuAluno`, dependendo do perfil).
4. A partir dos menus, é possível:
   - Cadastrar/consultar alunos (`GuiCadastroAluno` + `AlunoDAO`)
   - Cadastrar professores (`GuiCadastroProfessor` + `ProfessorDAO`)
   - Criar e consultar planos de treino (`GuiCadastroPlanoTreino`, `GuiPlanoTreinoConsulta` + `PlanoTreinoDAO`)
   - Registrar pagamentos de planos (`GuiPagamento` + `PagamentoDAO`, `Compra`, `Pagamento`, `FormaPagamento`)

## Estrutura de Pastas

```
Sistema_de_Academia/
├── README.md
├── resource/
│   └── Create do Banco de dados/Popular
│   └── Apresentação/Documentação
│   └── Av2_atuali_3.3.drawio     # Diagrama de classes/UML do projeto
└── src/
    ├── models/                     # Entidades de domínio e DAOs
    ├── views/                      # Telas Swing (interface gráfica)
    └── test/
        └── MainTeste.java          # Testes manuais de regras de negócio
```

## Principais Módulos

### Acesso a Dados

- **`BD`** — Encapsula a conexão JDBC com o MySQL (host, porta, banco, usuário, senha).
- **`OperacaoBd`** — Interface implementada pelas classes DAO, definindo os métodos `localizar()` e `atualizar(TipoOperacaoBd operacao)`.
- **`TipoOperacaoBd`** — Enum que define os tipos de operação (ex.: inserir, alterar, excluir) usados pelas DAOs.
- **`AlunoDAO`, `ProfessorDAO`, `LoginDAO`, `PlanoTreinoDAO`, `PagamentoDAO`** — Implementações concretas de acesso ao banco para cada entidade.

### Pessoas

- **`Pessoa`** (abstrata) — Atributos comuns: nome, CPF, data de nascimento, telefone.
- **`Aluno`** — Estende `Pessoa`, adiciona matrícula.
- **`Professor`** — Estende `Pessoa`, adiciona CREF e especialidade.

### Autenticação

- **`Login`** — Armazena código de acesso e hash da senha; possui `validarLogin()` para autenticação e `setSenhaHash()` para gerar o hash a partir de uma senha em texto puro.
- **`LoginDAO`** — Persiste e consulta dados de login no banco.

### Exercícios

- **`Exercicios`** (abstrata) — Atributos comuns: nome, descrição.
- **`ExercicioComRepeticao`** (abstrata) — Exercícios avaliados por repetição (ex.: Supino Reto com Barra, Agachamento Livre, Rosca Bíceps).
- **`ExercicioComTempo`** (abstrata) — Exercícios avaliados por tempo (ex.: Esteira, Bicicleta, Wall Sit, Pular Corda).
- Cada exercício concreto (ex.: `SupinoRetoComBarra`, `Esteira`) define seu próprio valor unitário (por repetição ou por segundo).

### Planos de Treino

- **`PlanoTreino`** — Relaciona um aluno, um professor responsável, data de criação, lista de exercícios e quantidades correspondentes.
- **`PlanoTreinoDAO`** — Persistência de planos de treino e seus exercícios associados.

### Pagamentos

- **`FormaPagamento`** (abstrata) — Atributos comuns: descrição, id.
- **`Dinheiro`**, **`Pix`** — Formas de pagamento sem cartão.
- **`Cartao`** (abstrata) — Adiciona bandeira do cartão (`BandeiraCartao`).
  - **`CartaoCredito`**, **`CartaoDebito`** — Especializações de `Cartao`.
- **`Pagamento`** — Representa um pagamento, com valor e forma(s) de pagamento.
- **`Compra`** — Relaciona um ou mais planos de treino a um pagamento e calcula o valor total (`SomaTotal`).
- **`PagamentoDAO`** — Persistência dos registros de pagamento.

## Telas (Views)

| Classe | Função |
|--------|--------|
| `Main` | Ponto de entrada da aplicação |
| `GuiLogin` | Tela de autenticação do usuário |
| `GuiMenuPrincipal` | Menu principal |
| `GuiCadastroAluno` | Cadastro e edição de alunos |
| `GuiCadastroProfessor` | Cadastro e edição de professores |
| `GuiCadastroPlanoTreino` | Criação de planos de treino, associando exercícios e quantidades a um aluno |
| `GuiPlanoTreinoConsulta` | Consulta de planos de treino existentes |
| `GuiPagamento` | Registro de pagamentos de planos de treino |

## Testes

A classe `src/test/MainTeste.java` contém testes manuais para validar as regras de negócio (cálculo de valores, validação de login, etc.) sem a necessidade de interagir com a interface gráfica.

## Diagrama UML

O arquivo `resource/Av2_atuali_3.3.drawio` contém o diagrama de classes do sistema e pode ser aberto em [draw.io](https://app.diagrams.net/) para visualização da modelagem completa.
