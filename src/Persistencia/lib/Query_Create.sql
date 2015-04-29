drop table if exists CLIENTES;
drop table if exists CANCHAS;
drop table if exists RESERVAS;

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
	horario DATETIME,
	realizada BOOLEAN,
	FOREIGN KEY(idCliente) REFERENCES CLIENTES(idCliente),
	FOREIGN KEY(idCancha) REFERENCES CANCHAS(idCancha)
);