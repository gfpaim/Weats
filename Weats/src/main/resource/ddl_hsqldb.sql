CREATE TABLE PAPEL (
	PAPEL_ID INTEGER IDENTITY,
	DESCRICAO varchar(100) NOT NULL
);

INSERT INTO PAPEL ("DESCRICAO") VALUES ('cliente');
INSERT INTO PAPEL ("DESCRICAO") VALUES ('fornecedor');

CREATE TABLE USUARIO (
	USUARIO_ID INTEGER IDENTITY,
	PAPEL INTEGER,
	LOGIN varchar(100) NOT NULL,
	SENHA varchar(100) NOT NULL,
	CNPJ varchar(100) NOT NULL,
	ENDERECO varchar(200) NOT NULL,
);

INSERT INTO USUARIO ("LOGIN","SENHA","PAPEL","CNPJ","ENDERECO") VALUES ('adminC','admin',0,'000','000');
INSERT INTO USUARIO ("LOGIN","SENHA","PAPEL","CNPJ","ENDERECO") VALUES ('adminF','admin',1,'111','111');

CREATE TABLE LICITACAO (
	LICITACAO_ID INTEGER IDENTITY,
	USUARIO_ID INTEGER,
	DESCRICAO VARCHAR(100),
	ITENS VARCHAR(100),
	OBSERVACOES VARCHAR(250),
	DATA_INICIAL DATE,
	DATA_FINAL DATE,
)

CREATE TABLE ORCAMENTO (
	ORCAMENTO_ID INTEGER IDENTITY,
	LICITACAO_ID INTEGER,
	USUARIO_ID INTEGER,
	DESCRICAO VARCHAR(100),
	VALOR INTEGER, 
	PRAZO DATE
)