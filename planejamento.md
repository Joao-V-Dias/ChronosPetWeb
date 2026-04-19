# 🐾 Sistema de Gestão de Vacinação de Pets – Lógica Completa (Sem Veterinário)

## 🎯 Objetivo

Construir um sistema completo para gerenciar vacinas de pets, incluindo cadastro, controle, histórico e agendamento de próximas doses — **sem dependência de veterinário**, focado no tutor.

---

# 🧩 1. Entidades Principais

## 🐶 Pet

Representa o animal.

**Campos:**

- id
- name (nome)
- species (espécie: cachorro, gato, etc.)
- breed (raça)
- birthDate (data de nascimento)
- ownerId

---

## 👤 Owner (Tutor)

Representa o dono do pet.

**Campos:**

- id
- name
- email
- phone

---

## 💉 Vaccine (Vacina)

Representa o tipo de vacina.

**Campos:**

- id
- name (ex: Antirrábica, V10)
- description
- doseIntervalDays (intervalo entre doses em dias)

---

## 📅 VaccinationRecord (Registro de Vacinação) ⭐

Representa o controle da vacina do pet.

**Campos:**

- id
- petId
- vaccineId
- applicationDate (data de aplicação)
- nextDoseDate (próxima dose)
- status (PENDING, APPLIED, OVERDUE)

---

# 🔗 2. Relacionamentos

- Um Owner → vários Pets
- Um Pet → vários VaccinationRecords
- Uma Vaccine → vários VaccinationRecords

---

# ⚙️ 3. Regras de Negócio

## 📌 3.1 Criar Pet

- Validar campos obrigatórios (nome, espécie)
- Associar a um Owner

---

## 📌 3.2 Criar Vacina

- Validar nome
- Validar intervalo (deve ser > 0)

---

## 📌 3.3 Criar Registro de Vacinação

### Passos:

1. Selecionar Pet
2. Selecionar Vacina
3. Inicialmente **não informar data** (vacina ainda não aplicada)
4. Definir:
   - status = `PENDING`

---

## 📌 3.4 Aplicar Vacina (ação do usuário)

Quando o usuário informar que a vacina foi aplicada:

```id="app1"
applicationDate = hoje
nextDoseDate = hoje + doseIntervalDays
status = APPLIED
```

---

## 📌 3.5 Atualizar Status Automaticamente

### Regras:

- Se `status = APPLIED` → permanece aplicado
- Se hoje > nextDoseDate e não aplicada → `OVERDUE`
- Se ainda não aplicada → `PENDING`

---

## 📌 3.6 Verificação Automática (IMPORTANTE)

Executar ao listar ou consultar dados:

```id="app2"
SE hoje > nextDoseDate E status != APPLIED
    status = OVERDUE
```

---

## 📌 3.7 Histórico de Vacinação por Pet

- Listar todos os registros do pet
- Ordenar por data de aplicação (mais recente primeiro)

---

## 📌 3.8 Listar Vacinas Atrasadas

Filtro:

```id="app3"
status = OVERDUE
```

---

## 📌 3.9 Lembrete de Próxima Dose

Filtro:

```id="app4"
nextDoseDate <= hoje + X dias
```

(X pode ser 7 dias, por exemplo)

---

# 🧠 4. Validações

## Pet

- name: obrigatório, mínimo 3 caracteres
- species: obrigatório

## Vaccine

- name: obrigatório
- doseIntervalDays: obrigatório, maior que 0

## VaccinationRecord

- pet: obrigatório
- vaccine: obrigatório

---

# 🏗️ 5. Arquitetura do Sistema

## Camadas recomendadas:

### Controller

- Recebe requisições
- Valida entrada (DTO)

### Service

- Contém regras de negócio
- Calcula próxima dose
- Atualiza status

### Repository

- Acesso ao banco de dados

### DTO

- Validação de dados de entrada
- Evita expor entidades diretamente

---

# 🔄 6. Fluxos Principais

## 🟢 Cadastro de Pet

- Criar Owner (se não existir)
- Criar Pet

---

## 🟢 Cadastro de Vacina

- Registrar tipos de vacina

---

## 🟢 Criar Registro de Vacinação

- Pet + Vacina
- Status inicial = `PENDING`

---

## 🟢 Aplicar Vacina

- Atualizar registro
- Definir applicationDate
- Calcular próxima dose
- Status = `APPLIED`

---

## 🟢 Dashboard (Opcional, mas diferencial)

Exibir:

- Total de pets
- Vacinas aplicadas
- Vacinas atrasadas
- Próximas vacinas

---

# 📊 7. Funcionalidades Extras (Portfólio)

## 🔥 Intermediário

- Filtro por espécie
- Busca por nome do pet
- Paginação

## 🚀 Avançado

- Sistema de notificações (lembretes)
- Autenticação (login)
- API + Frontend (React)

---

# ⚠️ 8. Erros Comuns

❌ Colocar vacinas direto dentro do Pet
❌ Não calcular próxima dose
❌ Não tratar vacinas atrasadas
❌ Não separar regras de negócio

---

# ✅ 9. Checklist Final

- [ ] Criar entidades (Pet, Owner, Vaccine, VaccinationRecord)
- [ ] Definir relacionamentos (JPA)
- [ ] Adicionar validações
- [ ] Criar DTOs
- [ ] Implementar Services
- [ ] Criar Controllers
- [ ] Criar formulários ou endpoints
- [ ] Tratar erros de validação
- [ ] Implementar lógica de status
- [ ] Criar dashboard (opcional)

---

# 🚀 10. Resultado Final

Um sistema completo capaz de:

- Gerenciar pets e tutores
- Controlar histórico de vacinas
- Permitir marcar vacinas como aplicadas
- Calcular próximas doses automaticamente
- Identificar vacinas atrasadas
- Gerar lembretes e insights

---

Se você seguir essa estrutura, você terá um sistema **simples, mas muito bem estruturado e com nível profissional para portfólio**.
