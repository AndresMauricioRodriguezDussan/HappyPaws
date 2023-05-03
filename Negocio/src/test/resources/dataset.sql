INSERT INTO usuario VALUES (1,'juan@example.com', 1, 'Juan Perez', 'password123', 'juanperez');
INSERT INTO usuario VALUES (2,'maria@example.com', 1, 'Maira Garcia', 'qwerty123', 'mairagarcia');
INSERT INTO usuario VALUES (3,'jose@example.com', 1, 'Jose Rodriguez', 'pass1234', 'joserodriguez');
INSERT INTO usuario VALUES (4,'ana@example.com', 1, 'Ana Lopez', 'mypassword', 'anita');
INSERT INTO usuario VALUES (5,'carlos@example.com', 1, 'Carlos Gomez', 'clave123', 'carlosg');
INSERT INTO usuario VALUES (6,'lucia@example.com', 1, 'Lucia Fernandez', 'mipass', 'luciaf');
INSERT INTO usuario VALUES (7,'pedro@example.com', 1, 'Pedro Garcia', 'p12345', 'pedrog');
INSERT INTO usuario VALUES (8,'luisa@example.com', 1, 'Luisa Perez', 'contrasena', 'luisap');
INSERT INTO usuario VALUES (9,'julia@example.com', 1, 'Julia Gonzalez', 'password789', 'juliag');
INSERT INTO usuario VALUES (10,'manuel@example.com', 1, 'Manuel Fernandez', '12345678', 'manuelf');

INSERT INTO cliente VALUES ("calle falsa 1",1);
INSERT INTO cliente VALUES ("calle falsa 2",2);
INSERT INTO cliente VALUES ("calle falsa 3",3);
INSERT INTO cliente VALUES ("calle falsa 4",4);
INSERT INTO cliente VALUES ("calle falsa 5",5);

INSERT INTO empleado VALUES ('VETERINARIO', 'A123456', 6);
INSERT INTO empleado VALUES ('VENDEDOR',null,7);
INSERT INTO empleado VALUES ('VETERINARIO', 'B789012',8 );
INSERT INTO empleado VALUES ('ADMINISTRADOR',null, 9);
INSERT INTO empleado VALUES ('VETERINARIO', 'C345678', 10);

INSERT INTO mascota VALUES (1, 2, 'PERRO', 'MACHO', 'Firulais', 'Bulldog', 1);
INSERT INTO mascota VALUES (2, 1, 'GATO', 'HEMBRA', 'Pelusa',null, 2);
INSERT INTO mascota VALUES (3, 5, 'AVE', 'DESCONOCIDO', 'Piolín', 'Canario', 3);
INSERT INTO mascota VALUES (4, 3, 'CONEJO', 'HEMBRA', 'Lola', 'Angora', 4);
INSERT INTO mascota VALUES (5, 1, 'OTRO', 'DESCONOCIDO', 'Loki',null, 5);
INSERT INTO mascota VALUES (6, 4, 'PERRO', 'MACHO', 'Toby', 'Dálmata', 2);
INSERT INTO mascota VALUES (7, 2, 'GATO', 'HEMBRA', 'Griselda', null, 3);
INSERT INTO mascota VALUES (8, 7, 'OTRO', 'DESCONOCIDO', 'Rufus', 'Tortuga', 4);
INSERT INTO mascota VALUES (9, 3, 'GATO', 'MACHO', 'Garfield', 'Siamés', 2);
INSERT INTO mascota VALUES (10, 2, 'CONEJO', 'HEMBRA', 'Lola', null, 5);

INSERT INTO producto  VALUES (1,'Pienso para perros adultos', 'pienso_perro_adulto.png', 'Pienso para perros adultos', 45.99, 100);
INSERT INTO producto  VALUES (2,'Juguete para gatos con plumas', 'juguete_gato_plumas.png', 'Juguete para gatos con plumas', 8.99, 50);
INSERT INTO producto  VALUES (3,'Shampoo para perros de razas pequeñas', 'shampoo_perro_razas_pequenas.png', 'Shampoo para perros de razas pequeñas', 12.99, 30);
INSERT INTO producto  VALUES (4,'Golosinas para perros de todas las edades', 'golosinas_perro.png', 'Golosinas para perros', 5.99, 200);
INSERT INTO producto  VALUES (5,'Cepillo para el cuidado de la piel de gatos', 'cepillo_gato.png', 'Cepillo para gatos', 6.99, 20);

INSERT INTO servicio  VALUES (1,'Servicio de baño y corte', 120, 'Baño y corte', 25.99);
INSERT INTO servicio  VALUES (2,'Servicio de vacunacion antirrabica', 30, 'Vacuna antirrabica', 12.99);
INSERT INTO servicio  VALUES (3,'Servicio de consultorio general', 45, 'Consulta general', 35.99);
INSERT INTO servicio  VALUES (4,'Servicio de peluqueria canina', 90, 'Peluqueria canina', 20.99);
INSERT INTO servicio  VALUES (5,'Servicio de desparasitacion', 20, 'Desparasitacion', 15.99);

INSERT INTO agenda_empleado VALUES (1,'2023-04-23',6);
INSERT INTO agenda_empleado VALUES (2,'2023-04-23',8);
INSERT INTO agenda_empleado VALUES (3,'2023-04-23',10);
INSERT INTO agenda_empleado VALUES (4,'2023-04-23',6);
INSERT INTO agenda_empleado VALUES (5,'2023-04-23',8);

INSERT INTO tarea VALUES (1,'Limpieza dental', 'Limpieza dental');
INSERT INTO tarea VALUES (2,'Corte de pelo', 'Corte de pelo');
INSERT INTO tarea VALUES (3,'Vacunacion', 'Vacunacion de Bobby');
INSERT INTO tarea VALUES (4,'Revision general', 'Revision de salud');
INSERT INTO tarea VALUES (5,'Desparasitacion', 'Desparasitacion');

INSERT INTO servicio_tareas VALUES (1,1);
INSERT INTO servicio_tareas VALUES (1,2);
INSERT INTO servicio_tareas VALUES (2,3);
INSERT INTO servicio_tareas VALUES (3,4);
INSERT INTO servicio_tareas VALUES (3,3);
INSERT INTO servicio_tareas VALUES (4,2);
INSERT INTO servicio_tareas VALUES (5,5);

INSERT INTO cita VALUES (1,'2023-04-23 8:00:00','2023-04-23 6:00:00',1,1,1);
INSERT INTO cita VALUES (2,'2023-04-23 12:00:00','2023-04-23 11:30:00',2,2,2);
INSERT INTO cita VALUES (3,'2023-04-23 16:00:00','2023-04-23 15:15:00',3,3,3);
INSERT INTO cita VALUES (4,'2023-04-23 20:00:00','2023-04-23 18:30:00',4,4,4);
INSERT INTO cita VALUES (5,'2023-04-23 14:00:00','2023-04-23 13:40:00',5,5,5);

INSERT INTO usuario_telefonos VALUES (1,"3122867662","personal");
INSERT INTO usuario_telefonos VALUES (1,"3122867662","casa");
INSERT INTO usuario_telefonos VALUES (2,"313467662","personal");
INSERT INTO usuario_telefonos VALUES (4,"3155963662","personal");
INSERT INTO usuario_telefonos VALUES (3,"3122866932","personal");
INSERT INTO usuario_telefonos VALUES (5,"3032867662","personal");