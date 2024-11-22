CREATE TABLE tb_proprietario (
    id BIGINT AUTO_INCREMENT,

    nome VARCHAR(255),
    email VARCHAR(150) UNIQUE,
    telefone VARCHAR(20),
    situacao ENUM('ATIVO', 'INATIVO'),

    PRIMARY KEY (id)
);