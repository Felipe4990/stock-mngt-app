
-- CRIAÇÃO DO BANCO DE DADOS CONFEITARIA

CREATE DATABASE Confeitaria;
 
-- SELEÇÃO DO BANCO DE DADOS CONFEITARIA

USE Confeitaria;

-- CRIAÇÃO DA TABELA DE MATERIAL

CREATE TABLE MATERIAL (
	ID_MATERIAL INT NOT NULL PRIMARY KEY,
    ID_CATEGORIA INT NOT NULL,
	DESCRICAO VARCHAR(255),
	LOTE VARCHAR(255),
	DATA_COMPRA DATE,
	DATA_VALIDADE DATE
);

-- CRIAÇÃO DA TABELA DE FABRICANTE

CREATE TABLE FABRICANTE (
	ID_FABRICANTE INT NOT NULL PRIMARY KEY,
	DESCRICAO VARCHAR(255)
);

-- CRIAÇÃO DA TABELA DE TIPO DE MOVIMENTAÇÃO

CREATE TABLE TIPO_MOVIMENTACAO (
	ID_TIPO_MOVIMENTACAO INT NOT NULL PRIMARY KEY,
	DESCRICAO VARCHAR(255)
);

-- CRIAÇÃO DA TABELA DE CATEGORIA

CREATE TABLE CATEGORIA (
	ID_CATEGORIA INT NOT NULL PRIMARY KEY,
	DESCRICAO VARCHAR(255)
);

-- CRIAÇÃO DA TABELA DE MOVIMENTAÇÃO

CREATE TABLE MOVIMENTACAO (
	ID_MOVIMENTACAO INT NOT NULL PRIMARY KEY,
	ID_TIPO_MOVIMENTACAO INT NOT NULL,
	ID_MATERIAL INT NOT NULL,
	DATA_MOVIMENTACAO DATE NOT NULL,
	QUANTIDADE INT NOT NULL DEFAULT(0),
    FOREIGN KEY (ID_TIPO_MOVIMENTACAO) REFERENCES TIPO_MOVIMENTACAO (ID_TIPO_MOVIMENTACAO),
    FOREIGN KEY (ID_MATERIAL) REFERENCES MATERIAL (ID_MATERIAL)
);