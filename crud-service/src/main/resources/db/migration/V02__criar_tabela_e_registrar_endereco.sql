CREATE TABLE IF NOT EXISTS endereco (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	cep VARCHAR(8),
	logradouro VARCHAR(100),
	bairro VARCHAR(50),
	cidade VARCHAR(50),
	uf VARCHAR(2),
	complemento VARCHAR(100),
	cliente_id BIGINT,
	FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);

INSERT INTO endereco (cep, logradouro, bairro, cidade, uf, complemento, cliente_id) values ('72855307', 'Quadra 7', 'Parque Residencial Faro', 'Luziânia', 'GO', '', 1);
INSERT INTO endereco (cep, logradouro, bairro, cidade, uf, complemento, cliente_id) values ('72872520', 'Conjunto Residencial 1 Condomínio 2', 'Parque das Cachoeiras', 'Valparaíso de Goiás', 'GO', '', 2);
INSERT INTO endereco (cep, logradouro, bairro, cidade, uf, complemento, cliente_id) values ('71640200', 'SHIS QI 16', 'Setor de Habitações Individuais Sul', 'Brasília', 'DF', '', 3);
INSERT INTO endereco (cep, logradouro, bairro, cidade, uf, complemento, cliente_id) values ('72852520', 'Rua Copacabana', 'Jardim Flamboyant', 'Luziânia', 'GO', '', 4);
INSERT INTO endereco (cep, logradouro, bairro, cidade, uf, complemento, cliente_id) values ('72872340', 'Rua 55', 'Pacaembu', 'Valparaíso de Goiás', 'GO', '', 5);
INSERT INTO endereco (cep, logradouro, bairro, cidade, uf, complemento, cliente_id) values ('71940720', 'Rua 19', 'Sul (Águas Claras)', 'Brasília', 'DF', '', 6);
INSERT INTO endereco (cep, logradouro, bairro, cidade, uf, complemento, cliente_id) values ('70070120', 'SBS Quadra 2', 'Asa Sul', 'Brasília', 'DF', '', 7);
