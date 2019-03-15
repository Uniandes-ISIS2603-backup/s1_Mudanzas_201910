delete from AgendaEntity;
delete from CargaEntity;
delete from ConductorEntity;
delete from DiaEntity;
delete from DireccionEntity;
delete from OfertaEntity;
delete from ProveedorEntity;
delete from SubastaEntity;
delete from TarjetaDeCreditoEntity;
delete from UsuarioEntity;
delete from VehiculoEntity;
delete from ViajesEntity;

/*Usuarios*/
/*10001 Usuario 1 usuarioPrueba1*/
insert into UsuarioEntity (id, login, password, nombre, apellido, correoElectronico, ciudadDeOrigen) values (10001, 'luismigolondo', 'Qwerty2@', 'Luis Miguel', 'Gomez Londono', 'luismigolondo@gmail.com', 'Manizales');
/*10002 Usuario 2 usuarioPrueba2*/
insert into UsuarioEntity (id, login, password, nombre, apellido, correoElectronico, ciudadDeOrigen) values (10002, 'julianosorio', 'Qwerty3@', 'Julian', 'Osorio', 'juliano@gmail.com', 'Bogota');

/*Tarjetas Usuario 1*/
/*10003 t1u1*/
insert into TarjetaDeCreditoEntity (id, nombreTarjeta, numeroSerial, codigoSeguridad, fechaVencimiento, usuario_id) values (10003, 'Tarjeta primaria', '123456789102', 951, '02/10/2020', 10001); 
/*10004 t2u1*/
insert into TarjetaDeCreditoEntity (id, nombreTarjeta, numeroSerial, codigoSeguridad, fechaVencimiento, usuario_id) values (10004, 'Tarjeta secundaria', '123456789103', 952, '02/10/2020', 10001); 

/*Tarjetas Usuario 2*/
/*10005 t1u2*/
insert into TarjetaDeCreditoEntity (id, nombreTarjeta, numeroSerial, codigoSeguridad, fechaVencimiento, usuario_id) values (10005, 'Tarjeta primaria', '123456789104', 953, '02/10/2021', 10002); 
/*10006 t2u2*/
insert into TarjetaDeCreditoEntity (id, nombreTarjeta, numeroSerial, codigoSeguridad, fechaVencimiento, usuario_id) values (10006, 'Tarjeta secundaria', '123456789105', 954, '02/10/2021', 10002);

/*Cargas Usuario 1*/
/*10007 c1u1*/
insert into CargaEntity (id, viaje_id, usuario_id, datosEnvio, volumen, imagenes, lugarSalida, lugarLlegada, fechaEstimadaLlegada, fechaEnvio, observaciones) values (10007, 10025, 10001, 'Carga muy grande', 15, 'imagen1 imagen2', 'Medellin', 'Bogota', '03/10/2019', '03/08/2019', 'muy delicado pilas');
/*10008 c2u1*/
insert into CargaEntity (id, viaje_id, usuario_id, datosEnvio, volumen, imagenes, lugarSalida, lugarLlegada, fechaEstimadaLlegada, fechaEnvio, observaciones) values (10008, 10025, 10001, 'Carga muy grande', 16, 'imagen1 imagen2', 'Bogota', 'Armenia', '03/10/2019', '03/08/2019', 'muy fragil pilas');
/*Cargas Usuario 2*/
/*10009 c1u2*/
insert into CargaEntity (id, viaje_id, usuario_id, datosEnvio, volumen, imagenes, lugarSalida, lugarLlegada, fechaEstimadaLlegada, fechaEnvio, observaciones) values (10007, 10026, 10002, 'Carga muy grande', 15, 'imagen1 imagen2', 'Barranquilla', 'Bogota', '03/10/2019', '03/08/2019', 'muy delicado pilas');
/*10010 c2u2*/
insert into CargaEntity (id, viaje_id, usuario_id, datosEnvio, volumen, imagenes, lugarSalida, lugarLlegada, fechaEstimadaLlegada, fechaEnvio, observaciones) values (10008, 10026, 10002, 'Carga muy grande', 16, 'imagen1 imagen2', 'Bucaramanga', 'Armenia', '03/10/2019', '03/08/2019', 'muy fragil pilas');

/*Proveedores*/
/*10011 Proveedor 1 proveedorPrueba1*/
insert into ProveedorEntity (id, login, password, nombre, logotipo, ciudadOrigen, correoElectronico, telefono, numeroVehiculos, dineroDisponible, calificacion) values (10011, 'mudanzasunidas', 'Qwerty2@', 'MudanzasUnidas', 'movisi.jpg', 'Manizales', 'mudanzasunidas@gmail.com', '3206648854', 2, 15000000, 5);
/*10012 Proveedor 1 proveedorPrueba1*/
insert into ProveedorEntity (id, login, password, nombre, logotipo, ciudadOrigen, correoElectronico, telefono, numeroVehiculos, dineroDisponible, calificacion) values (10012, 'trasteoincluded', 'Qwerty3@', 'Trasteo Inc', 'movisi.jpg','Bogota', 'trasteoinc@gmail.com', '3206648855', 2, 16000000, 4);

/*Subastas Usuario 1*/
/*10013 s1u1 proveedorPrueba1*/
insert into SubastaEntity (id, valorInicial, valorFinal, proveedor_id, usuario_id) values (10013, 123456, 1234567, 10011, 10001);
/*10014 s2u1 proveedorPrueba1*/
insert into SubastaEntity (id, valorInicial, valorFinal, proveedor_id, usuario_id) values (10014, 123456, 1234567, 10012, 10001);

/*Subastas Usuario 2*/
/*10015 s1u1 proveedorPrueba1*/
insert into SubastaEntity (id, valorInicial, valorFinal, proveedor_id, usuario_id) values (10015, 123456, 1234567, 10011, 10002);
/*10016 s2u1 proveedorPrueba1*/
insert into SubastaEntity (id, valorInicial, valorFinal, proveedor_id, usuario_id) values (10016, 123456, 1234567, 10012, 10002);

/*Vehiculos Proveedor 1*/
/*10017 v1p1 proveedorPrueba1*/
insert into VehiculoEntity(id, placa, rendimiento, idConductorActual, marca, numeroConductores, color, dimensiones, proveedor_id, agenda_id, ubicacionActual_id) values (10017, 'VYC943', 23, 123456789, 'Buggatti', 2, 'Azul', 'dimension', 10011, 10027, 10026);
/*10018 v2p1 proveedorPrueba1*/
insert into VehiculoEntity(id, placa, rendimiento, idConductorActual, marca, numeroConductores, color, dimensiones, proveedor_id, agenda_id, ubicacionActual_id) values (10018, 'VYC944', 23, 123456789, 'Buggatti', 2, 'Azul', 'dimension', 10011, 10099, 10026);

/*Vehiculos Proveedor 2*/
/*10019 v1p2 proveedorPrueba2*/
insert into VehiculoEntity(id, placa, rendimiento, idConductorActual, marca, numeroConductores, color, dimensiones, proveedor_id, agenda_id, ubicacionActual_id) values (10019, 'VYC945', 23, 123456789, 'Buggatti', 2, 'Azul', 'dimension', 10012, 10028, 10026);
/*10020 v2p2 proveedorPrueba2*/
insert into VehiculoEntity(id, placa, rendimiento, idConductorActual, marca, numeroConductores, color, dimensiones, proveedor_id, agenda_id, ubicacionActual_id) values (10020, 'VYC946', 23, 123456789, 'Buggatti', 2, 'Azul', 'dimension', 10012, 10100, 10026);

/*Conductores Proveedor 1*/
/*10021 c1p1 proveedorPrueba1*/
insert into ConductorEntity(id, nombre, calificacion, telefono, proveedor_id, viajes_id) values(10021, 'Cesar', 5, '885444444', 10011, 10025);
/*10022 c2p1 proveedorPrueba1*/
insert into ConductorEntity(id, nombre, calificacion, telefono, proveedor_id, viajes_id) values(10022, 'Ruby', 5, '885444445', 10011, 10025);

/*Conductores Proveedor 2*/
/*10023 c1p2 proveedorPrueba2*/
insert into ConductorEntity(id, nombre, calificacion, telefono, proveedor_id, viajes_id) values(10023, 'German', 5, '885444443', 10012, 10026);
/*10024 c2p2 proveedorPrueba2*/
insert into ConductorEntity(id, nombre, calificacion, telefono, proveedor_id, viajes_id) values(10024, 'Claudia', 5, '885444446', 10012, 10026);

/*Viajes Proveedor 1 Conductor 1*/
/*10025 v1p1 proveedorPrueba1*/
insert into ViajeEntity(id, conductor_id, lugarSalida, lugarLlegada, tiempo, gastoGasolina, clima, horaPartida, horaLlegada) values (10025, 10021, 'Barranquilla', 'Pasto', 3600, 1500, 'Fog', '03/10/2019 23:26:00', '03/10/2019 00:26:00');
/*Viajes Proveedor 2 Conductor 1*/
/*10026 v1p2 proveedorPrueba2*/
insert into ViajeEntity(id, conductor_id, lugarSalida, lugarLlegada, tiempo, gastoGasolina, clima, horaPartida, horaLlegada) values (10026, 10023, 'Barranquilla', 'Pasto', 3600, 1500, 'Fog', '03/10/2019 23:26:00', '03/10/2019 00:26:00');

/*Agenda Vehiculo 1 Proveedor 1*/
/*10027 proveedorPrueba1*/
insert AgendaEntity(id, horaSalida, horaLlegada, disponibilidad) values (10027, '03/10/2019 23:26:00', '03/10/2019 00:26:00', 0);
/*Agenda Vehiculo 1 Proveedor 2*/
/*10028 proveedorPrueba2*/
insert AgendaEntity(id, horaSalida, horaLlegada, disponibilidad) values (10028, '03/10/2019 23:26:00', '03/10/2019 00:26:00', 0);