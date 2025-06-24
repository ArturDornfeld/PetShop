# 🐾 PetShop

Projeto Java com interface Swing para um sistema de gerenciamento de Pet Shop. Permite cadastrar clientes e pets, contratar serviços pré-definidos, associar serviços a pets e seus respectivos donos e listar todas as informações. Desenvolvido com foco em orientação a objetos e persistência de dados em arquivos `.txt`.

---

## 📚 Funcionalidades

* Cadastro de Cliente
* Cadastro de Pet com vinculação ao Cliente
* Contratação de Serviços pré-definidos (Banho, Tosa, Consulta)
* Listagem geral de Clientes, Pets e Serviços
* Exclusão de Clientes, Pets e Serviços (em andamento)
* Interface gráfica com Java Swing
* Armazenamento de dados em arquivos `.txt`

---

## 📁 Estrutura do Projeto

```
PetShop/
├── dados/                  # Persistência local
│   ├── clientes.txt
│   ├── pets.txt
│   └── servicos.txt
├── src/
│   ├── controller/
│   │   ├── ClienteController.java
│   │   ├── PetController.java
│   │   └── ServicoController.java
│   ├── model/
│   │   ├── Cliente.java
│   │   ├── Pet.java
│   │   └── Servico.java
│   ├── util/
│   │   └── ArquivoUtil.java
│   └── view/
│       ├── TelaPrincipal.java
│       ├── TelaCadastroCliente.java
│       ├── TelaCadastroPet.java
│       ├── TelaCadastroServico.java
│       └── TelaListagem.java
```

---

## 🚀 Como Executar

1. Clone o repositório:

```bash
git clone https://github.com/ArturDornfeld/PetShop.git
```

2. Abra o projeto no Eclipse:

   * `Arquivo → Importar → Projeto existente`
   * Selecione a pasta `PetShop`

3. Execute a classe `Main.java` (ou `TelaPrincipal.java`):

   * Botão direito → Run As > Java Application

---

## ℹ️ Informações Adicionais

### 👨‍💻 Tecnologias

* Java 17+
* Eclipse IDE
* Git / GitHub
* Java Swing

### 👤 Autor

**Artur Dornfeld**
GitHub: [@ArturDornfeld](https://github.com/ArturDornfeld)

---

## 📊 Roadmap

### Funcionalidades concluídas:
```
* [x] Cadastro de cliente e pet com associação
* [x] Contratação de serviços pré-definidos
* [x] Interface gráfica completa com Swing
* [x] Persistência em `.txt`
* [x] Listagem geral com relações completas
* [x] Exclusão de cliente
* [x] Exclusão de pet
* [x] Exclusão de serviço
```
---
