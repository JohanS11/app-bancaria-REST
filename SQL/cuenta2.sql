-- Drop table


DROP TABLE public.transaccion;
DROP TABLE public.cuenta;
DROP TABLE public.usuario;
DROP TABLE public.transferencia;


CREATE TABLE usuario (
    apellido varchar(20) NOT NULL,
    nombre varchar(20) NOT NULL,
    celular varchar(13) NOT NULL,
    correo varchar(50) NOT NULL,
    cedula varchar(13) NOT NULL,
    usuarioid varchar(10) NOT NULL,
    pwd varchar(25) NOT NULL,
    rol varchar(7) not null,
    CONSTRAINT usuario_cedula_key UNIQUE (cedula),
    CONSTRAINT usuario_correo_key UNIQUE (correo),
    CONSTRAINT usuario_pkey PRIMARY KEY (usuarioid)
);


CREATE TABLE cuenta (
    id varchar(50) NOT NULL,
    numerodecuenta varchar(11) NOT NULL,
    saldo numeric NOT NULL,
    tipodecuenta varchar(9) NOT NULL,
    usuario varchar(13) NOT NULL,
    CONSTRAINT cuenta_pk PRIMARY KEY (id),
    CONSTRAINT cuenta_fk FOREIGN KEY (usuario) REFERENCES usuario(cedula)
);

-- Drop table



CREATE TABLE transaccion (
    identificador varchar(50) NOT NULL,
    numerodecuenta varchar(50) NOT NULL,
    saldoatransferir varchar(50) NOT NULL,
    aprobacion bool NOT NULL,
    fecha date not null,
    detalle varchar(300),
    CONSTRAINT transaccion_pk PRIMARY KEY (identificador),
    CONSTRAINT transaccion_fk FOREIGN KEY (numerodecuenta) REFERENCES cuenta(id)
);

-- Drop table



CREATE TABLE transferencia (
    identificador varchar NOT NULL,
    retiro varchar NOT NULL,
    deposito varchar NOT NULL,
    aprobacion bool NULL
);

-- Drop table



