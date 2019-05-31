CREATE TABLE Cliente(
	id SERIAL,
	nome VARCHAR(20) NOT NULL,
	cpf VARCHAR(11) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE Produto(
	id SERIAL,
	descricao VARCHAR(100) NOT NULL,
	valor FLOAT NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE Venda(
	id SERIAL,
	id_cliente INT,
	id_produto INT,
	quantidade INT,
	PRIMARY KEY (id),
	FOREIGN KEY (id_cliente) REFERENCES Cliente(id),
	FOREIGN KEY (id_produto) REFERENCES Produto(id)
);