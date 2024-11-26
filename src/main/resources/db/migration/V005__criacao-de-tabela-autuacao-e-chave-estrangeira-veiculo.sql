CREATE TABLE tb_autuacao (
    id BIGINT NOT NULL AUTO_INCREMENT,
    veiculo_id BIGINT NOT NULL,

    tipo_multa ENUM('GRAVE', 'GRAVISSIMA', 'LEVE', 'MEDIA') NOT NULL,
    descricao TEXT NOT NULL,
    valor_multa DECIMAL(10 , 2 ) NOT NULL,
    data_ocorrencia TIMESTAMP(6) NOT NULL,
    PRIMARY KEY (id),

    FOREIGN KEY (veiculo_id)
        REFERENCES tb_veiculo (id)
);