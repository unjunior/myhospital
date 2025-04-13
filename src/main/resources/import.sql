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



-- MODELO USUÁRIO / PAPEIS

INSERT INTO tb_usuario (nome, email, telefone, senha) VALUES ('Alex', 'alex@gmail.com', '(71)98888-8888','$2a$10$KSDm/4vsuhI8hvsa.p26JOlRRSJTUztzBL0aErcugdwUqkRJ/KqTW');
INSERT INTO tb_usuario (nome, email, telefone, senha) VALUES ('Maria', 'maria@gmail.com', '(71)97777-7777','$2a$10$KSDm/4vsuhI8hvsa.p26JOlRRSJTUztzBL0aErcugdwUqkRJ/KqTW');

INSERT INTO tb_papel (permissao) VALUES ('ADMIN');
INSERT INTO tb_papel (permissao) VALUES ('COMUM');

INSERT INTO tb_usuario_papel (usuario_id, papel_id) VALUES (1, 1);
INSERT INTO tb_usuario_papel (usuario_id, papel_id) VALUES (2, 1);
INSERT INTO tb_usuario_papel (usuario_id, papel_id) VALUES (2, 2);


