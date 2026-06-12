USE Academia;

-- =========================================================
-- ALUNOS
-- =========================================================
INSERT INTO aluno (matricula, nome, cpf, dataNascimento, numeroTelefone) VALUES
(1, 'Joao Pedro Silva', '111.111.111-11', '2000-03-15', '(11) 91111-1111'),
(2, 'Maria Eduarda Souza', '222.222.222-22', '1998-07-22', '(11) 92222-2222'),
(3, 'Carlos Henrique Lima', '333.333.333-33', '1995-11-05', '(11) 93333-3333'),
(4, 'Ana Beatriz Costa', '444.444.444-44', '2002-01-30', '(11) 94444-4444'),
(5, 'Felipe Augusto Rocha', '555.555.555-55', '1999-09-18', '(11) 95555-5555');

-- =========================================================
-- PROFESSORES
-- =========================================================
INSERT INTO Professor (cpf, nome, dataNascimento, numeroTelefone, cref, especialidade) VALUES
('666.666.666-66', 'Roberto Almeida', '1985-04-12', '(11) 96666-6666', 'CREF001234-G/SP', 'Musculacao'),
('777.777.777-77', 'Patricia Mendes', '1990-08-25', '(11) 97777-7777', 'CREF005678-G/SP', 'Funcional'),
('888.888.888-88', 'Lucas Ferreira', '1988-12-02', '(11) 98888-8888', 'CREF009012-G/SP', 'Cardio e Resistencia');

-- =========================================================
-- LOGIN
-- (senhaHash gerado a partir de String.hashCode() das senhas: "1234", "abcd", "senha123")
-- =========================================================
INSERT INTO login (id, codigo, senhaHash) VALUES
(1, 'admin', '1509442'),
(2, 'joao.pedro', '2987074'),
(3, 'roberto.almeida', '1251475389');

-- =========================================================
-- PAGAMENTOS
-- =========================================================
INSERT INTO pagamento (id_pagamento, valor) VALUES
(1, 150.00),
(2, 280.50),
(3, 99.90),
(4, 320.00);

-- =========================================================
-- FORMA DE PAGAMENTO
-- tipo: DINHEIRO, PIX, CREDITO, DEBITO
-- =========================================================
INSERT INTO formaPagamento (id, tipo, chave_pix, tipo_chave, bandeira, parcelas, id_pagamento) VALUES
(1, 'DINHEIRO', NULL, NULL, NULL, NULL, 1),
(2, 'PIX', 'maria.souza@email.com', 'EMAIL', NULL, NULL, 2),
(3, 'CREDITO', NULL, NULL, 'VISA', '3', 3),
(4, 'DEBITO', NULL, NULL, 'MASTERCARD', NULL, 4);

-- =========================================================
-- PLANO DE TREINO
-- =========================================================
INSERT INTO PlanoTreino (idPlanoTreino, matriculaAluno, cpfProfessor, dataDeCriacao) VALUES
(1, 1, '666.666.666-66', '2024-02-01'),
(2, 2, '777.777.777-77', '2024-02-10'),
(3, 3, '888.888.888-88', '2024-03-05'),
(4, 4, '666.666.666-66', '2024-03-20');

-- =========================================================
-- EXERCICIOS DO PLANO DE TREINO
-- =========================================================
INSERT INTO ExerciciosPlanoTreino (idExercicioPlanoTreino, idPlanoTreino, nomeExercicio, quantidade) VALUES
(1, 1, 'SupinoRetoComBarra', 4),
(2, 1, 'RemadaCurvadaComHalter', 3),
(3, 1, 'TricepsNaPolia', 3),
(4, 2, 'Esteira', 1),
(5, 2, 'Bicicleta', 1),
(6, 2, 'AbdominalArticulado', 4),
(7, 3, 'AgachamentoLivre', 4),
(8, 3, 'LegPress45', 3),
(9, 3, 'PanturrilhaEmPe', 4),
(10, 4, 'ElevacaoLateral', 3),
(11, 4, 'BicepsRoscaComHalter', 3),
(12, 4, 'Esteira', 1);
