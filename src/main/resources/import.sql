-- CARTEIRA

INSERT INTO tb_carteira(numero_carteira, emissao) values ('MYH1000', '2015-05-16');
INSERT INTO tb_carteira(numero_carteira, emissao) values ('MYH2000', '2020-06-06');
INSERT INTO tb_carteira(numero_carteira, emissao) values ('MYH3000', '2022-01-31');


--PACIENTE
INSERT INTO tb_paciente(nome, cpf, sexo, carteira_id) VALUES('Maria', '11111111-11', 'F', 1);
INSERT INTO tb_paciente(nome, cpf, sexo, carteira_id) VALUES('João', '22222222-22', 'M', 2);
INSERT INTO tb_paciente(nome, cpf, sexo, carteira_id) VALUES('Ana', '333333333-33', 'F', 3);


--MEDICO
INSERT INTO tb_medico(nome, especialidade, crm) VALUES('Ana Néri', 'PEDIATRIA', 'CRM1990-01');
INSERT INTO tb_medico(nome, especialidade, crm) VALUES('Roberto Kalil', 'CLINICO', 'CRM1990-02');
INSERT INTO tb_medico(nome, especialidade, crm) VALUES('Doutor Bacteria', 'CLINICO', 'CRM1990-03');


-- CONSULTA
INSERT INTO tb_consulta(horario, medico_id, paciente_id) VALUES('2025-06-18 08:00:00', 1, 1);
INSERT INTO tb_consulta(horario, medico_id, paciente_id) VALUES('2025-06-18 10:00:00', 1, 2);
INSERT INTO tb_consulta(horario, medico_id, paciente_id) VALUES('2025-06-18 10:00:00', 2, 1);




