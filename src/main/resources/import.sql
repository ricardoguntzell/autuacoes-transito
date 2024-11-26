-- DUMP-TB_PROPRIETARIO
INSERT INTO tb_proprietario (nome, email, telefone, situacao) VALUES ('Neelix', 'neelix@offbeat.com', '11988887777', 'ATIVO')
INSERT INTO tb_proprietario (nome, email, telefone, situacao) VALUES ('Phaxe', 'phaxe@offbeat.com', '11988886666', 'ATIVO')
INSERT INTO tb_proprietario (nome, email, telefone, situacao) VALUES ('Ranji', 'ranji@offbeat.com', '11988885555', 'ATIVO')

-- DUMP-TB_VEICULO
INSERT INTO tb_veiculo (proprietario_id, marca, modelo, placa, situacao_veiculo, data_cadastro) VALUES(1, 'Fiat', 'Strada', 'NEM5729', 'REGULAR', '2024-11-07 17:18:32')
INSERT INTO tb_veiculo (proprietario_id, marca, modelo, placa, situacao_veiculo, data_cadastro) VALUES(2, 'VW', 'Polo', 'JTA9943', 'REGULAR', '2024-11-07 17:18:32')
INSERT INTO tb_veiculo (proprietario_id, marca, modelo, placa, situacao_veiculo, data_cadastro) VALUES(3, 'Chevrolet', 'Onix', 'BAF2710', 'REGULAR', '2024-11-07 17:18:32')
INSERT INTO tb_veiculo (proprietario_id, marca, modelo, placa, situacao_veiculo, data_cadastro) VALUES(3, 'Hyundai', 'HB20', 'MYK6592', 'REGULAR', '2024-11-07 17:18:32')

-- DUMP-TB_AUTUACAO
INSERT INTO tb_autuacao (veiculo_id, tipo_multa, descricao, valor_multa, data_ocorrencia) VALUES (1, 'GRAVISSIMA', 'Dirigiu sob influência de álcool e recusou o teste do bafômetro', 2934.70, '2024-11-17 17:00:00')
INSERT INTO tb_autuacao (veiculo_id, tipo_multa, descricao, valor_multa, data_ocorrencia) VALUES (2, 'LEVE', 'Dirigir sem atenção ou sem os cuidados indispensáveis à segurança', 88.38, '2024-11-15 17:00:00')
INSERT INTO tb_autuacao (veiculo_id, tipo_multa, descricao, valor_multa, data_ocorrencia) VALUES (1, 'LEVE', 'Dirigir sem atenção ou sem os cuidados indispensáveis à segurança', 88.38, '2024-11-13 17:00:00')
INSERT INTO tb_autuacao (veiculo_id, tipo_multa, descricao, valor_multa, data_ocorrencia) VALUES (3, 'MEDIA', 'Abandonar na via objetos ou substâncias', 130.16, '2024-11-13 17:00:00')
INSERT INTO tb_autuacao (veiculo_id, tipo_multa, descricao, valor_multa, data_ocorrencia) VALUES (4, 'GRAVE', 'Deixar o passageiro de usar o cinto segurança', 195.23, '2024-11-13 17:00:00')