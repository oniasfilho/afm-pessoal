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

CREATE TABLE dispositivoPessoal (
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
  FOREIGN KEY(dispositivo_id) REFERENCES dispositivoPessoal(id),
  FOREIGN KEY(usuario_id) REFERENCES usuario(id)
);


INSERT INTO usuario
(cpf, nome, email, data_de_criacao, ultima_atualizacao, status)
VALUES
('03037334118', 'Onias da Rocha Filho', 'onias.filho@gmail.com', now(), now(), '1');

INSERT INTO dispositivoPessoal
(numero, imei, tipo, status, nick)
VALUES
('981522040', '123456789123456', '1', '1', 'Celular do Onias');


-- NEW SCRIPT

CREATE DATABASE sucit ENCODING = 'UTF8';
\c sucit

CREATE TABLE dispositivo_pessoal (
                                     id SERIAL,
                                     numero varchar(20),
                                     imei varchar(15),
                                     status varchar(1),
                                     nick varchar(50),

                                     PRIMARY KEY (id),
                                     UNIQUE (imei)
);

CREATE TABLE dispositivo_funcional (
                                       id SERIAL,
                                       numero varchar(20),
                                       imei varchar(15),
                                       status varchar(1),
                                       nick varchar(50),

                                       PRIMARY KEY (id),
                                       UNIQUE (imei)
);

CREATE TABLE usuario (
                         id SERIAL,
                         cpf varchar(11),
                         nome varchar(70),
                         email varchar(254),
                         data_de_criacao DATE ,
                         ultima_atualizacao TIMESTAMP ,
                         status varchar(1),
                         lotacao varchar(50),
                         dispositivo_pessoal integer,
                         dispositivo_funcional integer,

                         PRIMARY KEY (id),
                         UNIQUE (cpf),
                         FOREIGN KEY(dispositivo_pessoal) REFERENCES dispositivo_pessoal(id),
                         FOREIGN KEY(dispositivo_funcional) REFERENCES dispositivo_funcional(id)
);


INSERT INTO usuario
(cpf, nome, email, data_de_criacao, ultima_atualizacao, status, lotacao)
VALUES
('03037334118', 'Onias da Rocha Filho', 'onias.filho@gmail.com', now(), now(), '1', 'PF Cachimbo');


INSERT INTO usuario
(cpf, nome, email, data_de_criacao, ultima_atualizacao, status, lotacao)
VALUES
('05241536985', 'Jessica Milena', 'jessica.milenaa@gmail.com', now(), now(), '1', 'PF Flavio Gomes');


INSERT INTO dispositivo_funcional
(numero, imei, status, nick)
VALUES
('981522040', '123456789123456', '1', 'Celular do PF Cachimbo');



#IGNORE FOR NOW
# CREATE TYPE pf AS ENUM ('PF Cachimbo', 'PF Josafa Jacob', 'PF Flavio Gomes', 'PF Henrique Peixoto');


SELECT
    cpf, nome, dispositivo_pessoal.numero, dispositivo_pessoal.nick
FROM
    usuario, dispositivo_pessoal
WHERE
        usuario.dispositivo_pessoal = dispositivo_pessoal.id ;