CREATE TABLE dispositivo (
	id SERIAL, 
	numero VARCHAR(11), 
	imei VARCHAR(15) NOT NULL, 
	tipo VARCHAR(1) NOT NULL, 
	status VARCHAR(1),
	usuario_id integer 
	PRIMARY KEY (id)
	FOREIGN KEY (usuario_id) REFERENCES usuario(id);
);


CREATE TABLE usuario (
	id SERIAL, 
	cpf VARCHAR(11) NOT NULL, 
	nome VARCHAR(70) NOT NULL, 
	email VARCHAR(254), 
	data_de_criacao DATE, 
	ultima_atualizacao TIMESTAMP(6) WITHOUT TIME ZONE, 
	status VARCHAR(1),  
	UNIQUE (cpf),
	PRIMARY KEY (id)
);

CREATE TABLE dispositivo_usuario(
	dispositivo_id integer,
	usuario_id integer,
	PRIMARY KEY (dispositivo_id, usuario_id),
	FOREIGN KEY (dispositivo_id) REFERENCES dispositivo(id),
	FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);