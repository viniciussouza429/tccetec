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
nometurma varchar (40),
CONSTRAINT pk_turma PRIMARY KEY (idturma)
);

CREATE TABLE redacao(
idredacao serial,
descredacao varchar (40),
dataentregaredacao date,
CONSTRAINT pk_redacao PRIMARY KEY (idredacao)
);


CREATE TABLE mencao(
idmencao serial,
nomemencao varchar (40),
descmencao varchar (40),
anexoaudio varchar (40),
anexoimagem varchar (40),
CONSTRAINT pk_mencao PRIMARY KEY (idmencao)
);


