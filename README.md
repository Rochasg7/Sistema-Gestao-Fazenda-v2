# 🌱 Sistema de Gestão de Fazenda

Sistema desenvolvido em Java para auxiliar no gerenciamento de uma fazenda de café, permitindo controlar funcionários, frota, talhões, registros de serviços e gerar relatórios administrativos.

> Projeto desenvolvido com foco em programação orientada a objetos, organização em camadas e persistência de dados utilizando arquivos CSV.

---

## 📚 Funcionalidades

- 👨‍🌾 Cadastro e gerenciamento de funcionários
- 🚜 Cadastro e gerenciamento da frota
- 🌾 Cadastro de talhões
- 📋 Registro de serviços realizados
- 📊 Geração de relatórios
- 💾 Persistência dos dados em arquivos CSV

---

## 🛠 Tecnologias utilizadas

- Java
- Programação Orientada a Objetos (POO)
- Manipulação de arquivos (CSV)
- Visual Studio Code

---

## 📁 Estrutura do projeto

```
src/
│
├── Equipe/
├── Frota/
├── Talhoes/
├── Registros/
├── Relatorios/
│
├── SistemaPrincipal.java
└── MercadoCafe.java
```

Cada pacote é responsável por um módulo específico do sistema, facilitando manutenção e organização do código.

---

## ▶ Como executar

1. Clone o repositório

```bash
git clone https://github.com/seuusuario/sistema-gestao-fazenda.git
```

2. Abra o projeto no Visual Studio Code ou em sua IDE Java preferida.

3. Compile o projeto.

4. Execute a classe:

```
SistemaPrincipal.java
```

---

## 💾 Persistência

Os dados do sistema são armazenados na pasta:

```
banco/
```

Arquivos utilizados:

- funcionarios.csv
- frota.csv
- talhoes.csv
- registros.csv

Assim, as informações permanecem salvas mesmo após encerrar a aplicação.

---

## 📌 Conceitos aplicados

- Programação Orientada a Objetos
- Encapsulamento
- Organização em pacotes
- Separação de responsabilidades
- Persistência em arquivos
- Manipulação de coleções
- Menus interativos no terminal

---

## 🚀 Melhorias futuras

- Migração da persistência para banco de dados (MySQL ou PostgreSQL)
- Interface gráfica utilizando JavaFX
- Sistema de autenticação de usuários
- Dashboard com indicadores da fazenda
- Testes unitários utilizando JUnit

---

## 👨‍💻 Autor

Desenvolvido por Rocha como projeto de estudos para aprofundar conhecimentos em Java e Programação Orientada a Objetos.