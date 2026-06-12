create database Academia;
use Academia;
CREATE TABLE aluno (
    matricula INT PRIMARY KEY,
    nome VARCHAR(100),
    cpf VARCHAR(14),
    dataNascimento DATE,
    numeroTelefone varchar(14)
);

CREATE TABLE pagamento (
	id_pagamento INT PRIMARY KEY,
    valor FLOAT
);

CREATE TABLE formaPagamento (
    id INT PRIMARY KEY,
    tipo VARCHAR(20),
    chave_pix VARCHAR(50),
	tipo_chave VARCHAR(20),
    bandeira VARCHAR(28),
    parcelas VARCHAR(23),
	id_pagamento INT,
	FOREIGN KEY (id_pagamento) REFERENCES pagamento(id_pagamento) 
);

CREATE TABLE login (
	id INT PRIMARY KEY,
    codigo VARCHAR(40),
    senhaHash VARCHAR(100)
);

CREATE TABLE Professor (
    cpf VARCHAR(14) PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    dataNascimento DATE NOT NULL,
    numeroTelefone VARCHAR(20),
    cref VARCHAR(20) NOT NULL UNIQUE,
    especialidade VARCHAR(100)
);
CREATE TABLE PlanoTreino (
    idPlanoTreino INT AUTO_INCREMENT PRIMARY KEY,
    matriculaAluno INT NOT NULL,
    cpfProfessor VARCHAR(14) NOT NULL,
    dataDeCriacao DATE NOT NULL,

    FOREIGN KEY (matriculaAluno)
        REFERENCES Aluno(matricula),

    FOREIGN KEY (cpfProfessor)
        REFERENCES Professor(cpf)
);
CREATE TABLE ExerciciosPlanoTreino (
    idExercicioPlanoTreino INT AUTO_INCREMENT PRIMARY KEY,
    idPlanoTreino INT NOT NULL,
    nomeExercicio VARCHAR(100) NOT NULL,
    quantidade INT NOT NULL,

    FOREIGN KEY (idPlanoTreino)
        REFERENCES PlanoTreino(idPlanoTreino)
);

Select * from Professor;
Select * from Aluno;