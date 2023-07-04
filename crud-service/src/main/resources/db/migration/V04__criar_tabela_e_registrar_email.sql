CREATE TABLE IF NOT EXISTS email (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR (100),
    cliente_id BIGINT,
    FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);

INSERT INTO email (email, cliente_id) values ('teste1@teste.com', 1);
INSERT INTO email (email, cliente_id) values ('teste2@teste.com', 1);
INSERT INTO email (email, cliente_id) values ('teste3@teste.com', 2);
INSERT INTO email (email, cliente_id) values ('teste4@teste.com', 2);
INSERT INTO email (email, cliente_id) values ('teste5@teste.com', 3);
INSERT INTO email (email, cliente_id) values ('teste6@teste.com', 4);
INSERT INTO email (email, cliente_id) values ('teste7@teste.com', 5);
INSERT INTO email (email, cliente_id) values ('teste8@teste.com', 5);
INSERT INTO email (email, cliente_id) values ('teste9@teste.com', 6);
INSERT INTO email (email, cliente_id) values ('teste10@teste.com', 7);
