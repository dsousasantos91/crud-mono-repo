CREATE TABLE IF NOT EXISTS cliente (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(80) NOT NULL,
	cpf VARCHAR(11) NOT NULL UNIQUE
);

INSERT INTO cliente (nome, cpf) values ('José da Silva', '95061372000');
INSERT INTO cliente (nome, cpf) values ('Maria Eugenia ', '02358172014');
INSERT INTO cliente (nome, cpf) values ('Ana Clara Sousa', '65140007037');
INSERT INTO cliente (nome, cpf) values ('João Severo', '51318791081');
INSERT INTO cliente (nome, cpf) values ('Antônio Bastista', '78188222089');
INSERT INTO cliente (nome, cpf) values ('Carla Teixeira', '29225209002');
INSERT INTO cliente (nome, cpf) values ('Maurício Fernandes', '94294144025');
