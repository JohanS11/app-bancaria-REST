CREATE TABLE IF NOT EXISTS USUARIO (

  apellido VARCHAR(20) NOT NULL,
  nombre VARCHAR(20)  NOT NULL,
  celular VARCHAR(13)  NOT NULL,
  correo VARCHAR(50)  unique NOT NULL,
  cedula VARCHAR(12)  unique NOT NULL,
  usuarioid VARCHAR(10) primary key,
  pwd VARCHAR(25) not null);
  