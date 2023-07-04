CREATE TABLE IF NOT EXISTS telefone (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	ddd NUMBER (2) NOT NULL,
	numero NUMBER(9) NOT NULL,
    tipo VARCHAR (20),
    cliente_id BIGINT,
    FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);

INSERT INTO telefone (ddd, numero, tipo, cliente_id) values (61, 36237097, 'RESIDENCIAL', 1);
INSERT INTO telefone (ddd, numero, tipo, cliente_id) values (61, 991482755, 'CELULAR', 1);
INSERT INTO telefone (ddd, numero, tipo, cliente_id) values (61, 36228957, 'COMERCIAL', 1);
INSERT INTO telefone (ddd, numero, tipo, cliente_id) values (61, 36292980, 'RESIDENCIAL', 2);
INSERT INTO telefone (ddd, numero, tipo, cliente_id) values (61, 993760845, 'CELULAR', 2);
INSERT INTO telefone (ddd, numero, tipo, cliente_id) values (61, 33458791, 'COMERCIAL', 3);
INSERT INTO telefone (ddd, numero, tipo, cliente_id) values (61, 36294587, 'COMERCIAL', 4);
INSERT INTO telefone (ddd, numero, tipo, cliente_id) values (61, 992237196, 'CELULAR', 5);
INSERT INTO telefone (ddd, numero, tipo, cliente_id) values (61, 991598636, 'CELULAR', 6);
INSERT INTO telefone (ddd, numero, tipo, cliente_id) values (61, 993452728, 'CELULAR', 7);
