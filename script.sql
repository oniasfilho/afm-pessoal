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
  nick varchar(50),

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


INSERT INTO usuario
(cpf, nome, email, data_de_criacao, ultima_atualizacao, status)
VALUES
('03037334118', 'Onias da Rocha Filho', 'onias.filho@gmail.com', now(), now(), '1');

INSERT INTO dispositivo
(numero, imei, tipo, status, nick)
VALUES
('981522040', '123456789123456', '1', '1', 'Celular do Onias');