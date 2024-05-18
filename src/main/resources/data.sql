CREATE TABLE IF NOT EXISTS TB_CATEGORIAS (
    ID BIGINT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    ativo VARCHAR(5)
);

INSERT INTO TB_CATEGORIAS (ID, NOME, ATIVO) VALUES (1, 'ELETRONICOS', TRUE);
INSERT INTO TB_CATEGORIAS (ID, NOME, ATIVO) VALUES (2, 'ELETRODOMÉSTICO', TRUE);
INSERT INTO TB_CATEGORIAS (ID, NOME, ATIVO) VALUES (3, 'CASA', TRUE);
INSERT INTO TB_CATEGORIAS (ID, NOME, ATIVO) VALUES (4, 'AUTOMOTIVOS', TRUE);