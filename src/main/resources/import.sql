-- DUMP-TB_PROPRIETARIO
INSERT INTO tb_proprietario (nome, email, telefone, situacao) VALUES ('Neelix', 'neelix@offbeat.com', '11988887777', 'ATIVO')
INSERT INTO tb_proprietario (nome, email, telefone, situacao) VALUES ('Phaxe', 'phaxe@offbeat.com', '11988886666', 'ATIVO')
INSERT INTO tb_proprietario (nome, email, telefone, situacao) VALUES ('Ranji', 'ranji@offbeat.com', '11988885555', 'ATIVO')

-- DUMP-TB_VEICULO
INSERT INTO tb_veiculo (proprietario_id, marca, modelo, placa, situacao_veiculo, data_cadastro) VALUES(1, 'Fiat', 'Strada', 'NEM5729', 'REGULAR', '2024-11-07 17:18:32')
INSERT INTO tb_veiculo (proprietario_id, marca, modelo, placa, situacao_veiculo, data_cadastro) VALUES(2, 'VW', 'Polo', 'JTA9943', 'REGULAR', '2024-11-07 17:18:32')
INSERT INTO tb_veiculo (proprietario_id, marca, modelo, placa, situacao_veiculo, data_cadastro) VALUES(3, 'Chevrolet', 'Onix', 'BAF2710', 'REGULAR', '2024-11-07 17:18:32')
INSERT INTO tb_veiculo (proprietario_id, marca, modelo, placa, situacao_veiculo, data_cadastro) VALUES(3, 'Hyundai', 'HB20', 'MYK6592', 'REGULAR', '2024-11-07 17:18:32')
