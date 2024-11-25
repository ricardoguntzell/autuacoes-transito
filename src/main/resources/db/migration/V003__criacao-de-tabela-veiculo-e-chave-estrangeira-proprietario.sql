CREATE TABLE tb_veiculo (
    id BIGINT NOT NULL AUTO_INCREMENT,
    proprietario_id BIGINT NOT NULL,

    placa VARCHAR(8) UNIQUE NOT NULL,
    marca VARCHAR(150) NOT NULL,
    modelo VARCHAR(150) NOT NULL,
    situacao_veiculo ENUM('APREENDIDO', 'REGULAR') NOT NULL,

    data_cadastro TIMESTAMP(6) NOT NULL,
    data_apreensao TIMESTAMP(6),

    PRIMARY KEY (id),

    FOREIGN KEY FK_PROPRIETARIO (proprietario_id) REFERENCES tb_proprietario (id)
);