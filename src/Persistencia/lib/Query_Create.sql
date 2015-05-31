drop table if exists USUARIOS;
drop table if exists CLIENTES;
drop table if exists CANCHAS;
drop table if exists RESERVAS;

create table USUARIOS (
	idUsuario INTEGER PRIMARY KEY AUTOINCREMENT, 
	usuario STRING, 
	contrase�a STRING, 
	email STRING,
	nivelPermisos INTEGER
); 

create table CLIENTES (
	idCliente INTEGER PRIMARY KEY AUTOINCREMENT, 
	nombre STRING, 
	apellido STRING, 
	telefono INTEGER
); 

create table CANCHAS (
	idCancha INTEGER PRIMARY KEY AUTOINCREMENT, 
	nombre STRING, 
	tipo_cancha STRING,
	maxJugadores INTEGER,
	precioPorHora INTEGER
);

create table RESERVAS (
	idReserva INTEGER PRIMARY KEY AUTOINCREMENT, 
	idCliente INTEGER, 
	idCancha INTEGER,
	horario STRING,
	tiempo INTEGER,
	se�a INTEGER,
	realizada BOOLEAN,
	FOREIGN KEY(idCliente) REFERENCES CLIENTES(idCliente),
	FOREIGN KEY(idCancha) REFERENCES CANCHAS(idCancha)
);