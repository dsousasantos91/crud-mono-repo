CREATE TABLE IF NOT EXISTS cliente (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(80) NOT NULL,
	cpf VARCHAR(11) NOT NULL UNIQUE,
    endereco_id BIGINT,
    FOREIGN KEY (endereco_id) REFERENCES endereco(id)
);

INSERT INTO cliente (nome, cpf, endereco_id) values ('José da Silva', '95061372000', 1);
INSERT INTO cliente (nome, cpf, endereco_id) values ('Maria Eugenia ', '02358172014', 2);
INSERT INTO cliente (nome, cpf, endereco_id) values ('Ana Clara Sousa', '65140007037', 3);
INSERT INTO cliente (nome, cpf, endereco_id) values ('João Severo', '51318791081', 4);
INSERT INTO cliente (nome, cpf, endereco_id) values ('Antônio Bastista', '78188222089', 5);
INSERT INTO cliente (nome, cpf, endereco_id) values ('Carla Teixeira', '29225209002', 6);
INSERT INTO cliente (nome, cpf, endereco_id) values ('Maurício Fernandes', '94294144025', 7);
