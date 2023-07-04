CREATE TABLE IF NOT EXISTS endereco (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	cep VARCHAR(8),
	logradouro VARCHAR(100),
	bairro VARCHAR(50),
	cidade VARCHAR(50),
	uf VARCHAR(2),
	complemento VARCHAR(100)
);

INSERT INTO endereco (cep, logradouro, bairro, cidade, uf, complemento) values ('72855307', 'Quadra 7', 'Parque Residencial Faro', 'Luziânia', 'GO', '');
INSERT INTO endereco (cep, logradouro, bairro, cidade, uf, complemento) values ('72872520', 'Conjunto Residencial 1 Condomínio 2', 'Parque das Cachoeiras', 'Valparaíso de Goiás', 'GO', '');
INSERT INTO endereco (cep, logradouro, bairro, cidade, uf, complemento) values ('71640200', 'SHIS QI 16', 'Setor de Habitações Individuais Sul', 'Brasília', 'DF', '');
INSERT INTO endereco (cep, logradouro, bairro, cidade, uf, complemento) values ('72852520', 'Rua Copacabana', 'Jardim Flamboyant', 'Luziânia', 'GO', '');
INSERT INTO endereco (cep, logradouro, bairro, cidade, uf, complemento) values ('72872340', 'Rua 55', 'Pacaembu', 'Valparaíso de Goiás', 'GO', '');
INSERT INTO endereco (cep, logradouro, bairro, cidade, uf, complemento) values ('71940720', 'Rua 19', 'Sul (Águas Claras)', 'Brasília', 'DF', '');
INSERT INTO endereco (cep, logradouro, bairro, cidade, uf, complemento) values ('70070120', 'SBS Quadra 2', 'Asa Sul', 'Brasília', 'DF', '');
