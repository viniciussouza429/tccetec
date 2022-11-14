CREATE TABLE usuario(
idusuario serial,
nomeusuario varchar (40),
emailusuario  varchar (40),
telefoneusuario  varchar(40),
loginusuario  varchar(40),
senhausuario  varchar(40),
CONSTRAINT pk_usuario PRIMARY KEY (idusuario)
);

CREATE TABLE professor(
idprofessor serial,
rmprofessor varchar (40), 
idusuario Integer,
CONSTRAINT pk_professor PRIMARY KEY (idprofessor),
CONSTRAINT fk_professor_usuario FOREIGN KEY (idusuario) REFERENCES usuario(idusuario)
);



CREATE TABLE aluno(
idaluno serial,
raaluno varchar(40),
idusuario Integer,  
CONSTRAINT pk_aluno PRIMARY KEY (idaluno),
CONSTRAINT fk_aluno_usuario FOREIGN KEY (idusuario) REFERENCES usuario(idusuario)
);

CREATE TABLE turma(
idturma serial,
nomesala varchar (40),
idprofessor integer,
CONSTRAINT pk_turma PRIMARY KEY (idturma),
CONSTRAINT fk_turma_professor FOREIGN KEY (idprofessor) REFERENCES professor(idprofessor)
);

CREATE TABLE redacao(
idredacao serial,
descredacao varchar (40),
dataentregaredacao date,
idturma integer,
CONSTRAINT pk_redacao PRIMARY KEY (idredacao),
CONSTRAINT fk_redacao_turma FOREIGN KEY (idturma) REFERENCES turma(idturma)
);


CREATE TABLE mencao(
idmencao serial,
nomemencao varchar (40),
descmencao varchar (40),
anexoaudio varchar (40),
anexoimagem varchar (40),
idredacao integer,
idaluno integer,
CONSTRAINT pk_mencao PRIMARY KEY (idmencao),
CONSTRAINT fk_mencao_redacao FOREIGN KEY (idredacao) REFERENCES redacao(idredacao),
CONSTRAINT fk_mencao_aluno FOREIGN KEY (idaluno) REFERENCES aluno(idaluno)
);



