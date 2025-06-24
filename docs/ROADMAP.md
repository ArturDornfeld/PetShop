# 🗺️ Roadmap do Projeto Pet Shop

Este roadmap descreve as etapas do desenvolvimento do sistema de gerenciamento para Pet Shop com Java Swing.

---

## ✅ Etapa 1 – Organização Inicial
- [x] Criar repositório no GitHub
- [x] Configurar Git local
- [x] Criar estrutura de pastas do projeto
- [x] Criar README com instruções iniciais e descrição

---

## 🛠️ Etapa 2 – Implementação das Funcionalidades

### 2.1 Cadastro de Clientes
- [x] Criar classe `Cliente`
- [ ] Criar tela de cadastro com Swing
- [ ] Implementar validação: nome, telefone (formato), e-mail (formato)
- [ ] Implementar ações: cadastrar, listar, buscar, excluir

### 2.2 Cadastro de Pets
- [x] Criar classe `Pet` (ligada ao cliente)
- [ ] Criar tela de cadastro de pet
- [ ] Validação: idade > 0, peso > 0
- [ ] Ações: cadastrar, listar, buscar, excluir

### 2.3 Serviços
- [x] Criar classe `Servico`
- [x] Criar classe `Agendamento`
- [x] Criar classe `Pagamento`
- [ ] Tela de contratação de serviços
- [ ] Validar data (somente futuras)
- [ ] Garantir que só pets do cliente sejam usados
- [ ] Aplicar desconto em pacotes
- [ ] Ações: contratar, listar, buscar, cancelar

---

## 💾 Etapa 3 – Persistência dos Dados
- [ ] Escolher forma de persistência (arquivo ou banco)
- [ ] Implementar leitura e gravação de dados
- [ ] Testar persistência com todas as funcionalidades

---

## 🎨 Etapa 4 – Interface Gráfica com Swing
- [ ] Garantir que todas as telas sejam funcionais e intuitivas
- [ ] Organizar navegação entre janelas
- [ ] Adicionar ícones e estética agradável (opcional)

---

## 🔍 Etapa 5 – Validações Gerais
- [ ] Validar campos obrigatórios
- [ ] Validar tipos e formatos corretamente
- [ ] Validar regras de negócio (relacionamentos)

---

## 📦 Etapa 6 – Finalização
- [ ] Criar manual de uso (com imagens)
- [ ] Testar apresentação do projeto completo
- [ ] Subir todos os arquivos finais no GitHub

---

## 👥 Equipe
- Artur Dornfeld
