/*
 * Usuarios habilitados para ingresar
 */ 
insert into USUARIOS values(1, 'drick', '123456', 'rickdari@gmail.com', 1);
insert into USUARIOS values(2, 'kperez', '123456', 'perezkaren1905@gmail.com', 1);

/*
 * Agrego clientes de prueba
 */ 
insert into CLIENTES values(1, 'Karen', 'Perez', 46600000);
insert into CLIENTES values(2, 'Darío', 'Rick', 42223456);
insert into CLIENTES values(3, 'Juan', 'Flores', 4565587);
insert into CLIENTES values(4, 'Mauro', 'Viale', 42223456);
insert into CLIENTES values(5, 'Jorge', 'Lanata', 4558987);
insert into CLIENTES values(6, 'Ricardo', 'Fort', 42225156);

/*
 * Agrego canchas de prueba
 */ 
insert into CANCHAS values(1, 'Cancha 1', 'Cancha de 7', 150, 8);
insert into CANCHAS values(2, 'Cancha 2', 'Cancha de 11', 200, 11);

/*
 * Agrego reservas de prueba
 */ 
insert into RESERVAS values (1, 1, 1, '01-01-2015 10:00:00', 60, 30, 0);
insert into RESERVAS values (2, 1, 2, '01-01-2015 15:00:00', 60, 30, 0);
insert into RESERVAS values (3, 2, 1, '31-05-2015 10:00:00', 60, 30, 0);
insert into RESERVAS values (4, 2, 2, '31-05-2015 11:00:00', 60, 30, 0);
insert into RESERVAS values (5, 2, 1, '31-05-2015 12:00:00', 60, 30, 0);
insert into RESERVAS values (6, 1, 1, '31-05-2015 13:00:00', 60, 30, 0);
insert into RESERVAS values (7, 1, 2, '31-05-2015 14:30:00', 60, 30, 0);

