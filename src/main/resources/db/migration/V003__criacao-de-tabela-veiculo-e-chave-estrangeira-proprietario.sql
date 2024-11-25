CREATE TABLE tb_veiculo (
    id BIGINT NOT NULL AUTO_INCREMENT,
    proprietario_id BIGINT,

    placa VARCHAR(8) UNIQUE,
    marca VARCHAR(150),
    modelo VARCHAR(150),
    situacao_veiculo ENUM('APREENDIDO', 'REGULAR'),

    data_cadastro TIMESTAMP(6),
    data_apreensao TIMESTAMP(6),

    PRIMARY KEY (id),

    FOREIGN KEY FK_PROPRIETARIO (proprietario_id) REFERENCES tb_proprietario (id)
);