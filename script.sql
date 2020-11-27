CREATE DATABASE sucit ENCODING = 'UTF8';
\c sucit

CREATE TABLE usuario (
  id SERIAL,
  cpf varchar(11),
  nome varchar(70),
  email varchar(254),
  data_de_criacao DATE ,
  ultima_atualizacao TIMESTAMP ,
  status varchar(1),

  PRIMARY KEY (id),
  UNIQUE (cpf)
);

CREATE TABLE dispositivo (
  id SERIAL,
  numero varchar(20),
  imei varchar(15),
  tipo varchar(1),
  status varchar(1),

  PRIMARY KEY (id),
  UNIQUE (imei)
);

CREATE TABLE dispositivo_usuario(
  dispositivo_id integer NOT NULL,
  usuario_id integer NOT NULL,

  PRIMARY KEY(dispositivo_id, usuario_id),
  FOREIGN KEY(dispositivo_id) REFERENCES dispositivo(id),
  FOREIGN KEY(usuario_id) REFERENCES usuario(id)
);
