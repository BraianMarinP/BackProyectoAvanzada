INSERT INTO categoria (nombre) VALUES ("Electronica");
INSERT INTO categoria (nombre) VALUES ("Ropa y accesorios");
INSERT INTO categoria (nombre) VALUES ("Hogar y jardin");
INSERT INTO categoria (nombre) VALUES ("Salud y belleza");
INSERT INTO categoria (nombre) VALUES ("Deportes y actividades al aire libre");
INSERT INTO categoria (nombre) VALUES ("Juguetes y juegos");
INSERT INTO categoria (nombre) VALUES ("Automoviles y accesorios");
INSERT INTO categoria (nombre) VALUES ("Libros y medios");

insert into moderador (cedula, num_tel, direccion, nombre,email,contrasena) values ("1234589", "1234567890", "Calle 123" , "Augusto zurruaga", "AugustoZ@gmail.com", "$2a$10$TchjG4jRvm6HAoN29ZAf/uyjHSfTPxtQE4W0HfiymgGNydAqPRqXi");
insert into moderador (cedula, num_tel, direccion, nombre,email,contrasena) values ("1234579", "1234567880", "Calle 123" , "Melena peluda ", "MelenaP@hotmail.com", "$2a$10$TchjG4jRvm6HAoN29ZAf/uyjHSfTPxtQE4W0HfiymgGNydAqPRqXi");
insert into moderador (cedula, num_tel, direccion, nombre,email,contrasena) values ("1234569", "1234567870", "Calle 123" , "Julio Jaramillo", "juliojaramillo@gmail.com", "$2a$10$TchjG4jRvm6HAoN29ZAf/uyjHSfTPxtQE4W0HfiymgGNydAqPRqXi");

insert into usuario (cedula, num_tel, direccion, nombre, email, contrasena, estado, nick_name) values ("2222220", "3130000000", "Calle 100" , "Luis Miguel García Sánchez", "brayanlll1530az@gmail.com","$2a$10$TchjG4jRvm6HAoN29ZAf/uyjHSfTPxtQE4W0HfiymgGNydAqPRqXi", "ACTIVO", "socio01");
insert into usuario (cedula, num_tel, direccion, nombre, email, contrasena, estado, nick_name) values ("2222221", "3130000001", "Calle 101" , "Laura Patricia Torres Jiménez", "laura.jimenez@gmail.com","$2a$10$TchjG4jRvm6HAoN29ZAf/uyjHSfTPxtQE4W0HfiymgGNydAqPRqXi", "ACTIVO", "socio02");
insert into usuario (cedula, num_tel, direccion, nombre, email, contrasena, estado, nick_name) values ("2222222", "3130000002", "Calle 102" , "Juan Carlos Fernández Pérez", "jc.fernandez@yahoo.com","$2a$10$TchjG4jRvm6HAoN29ZAf/uyjHSfTPxtQE4W0HfiymgGNydAqPRqXi", "ACTIVO", "socio03");
insert into usuario (cedula, num_tel, direccion, nombre, email, contrasena, estado, nick_name) values ("2222223", "3130000003", "Calle 103" , "Carmen Elena García Hernández", "carmen.hernandez@yahoo.com","$2a$10$TchjG4jRvm6HAoN29ZAf/uyjHSfTPxtQE4W0HfiymgGNydAqPRqXi", "ACTIVO", "socio04");
insert into usuario (cedula, num_tel, direccion, nombre, email, contrasena, estado, nick_name) values ("2222224", "3130000004", "Calle 104" , "José Antonio Rodríguez Medina", "jose.medina@gmail.com","$2a$10$TchjG4jRvm6HAoN29ZAf/uyjHSfTPxtQE4W0HfiymgGNydAqPRqXi", "ACTIVO", "socio05");

insert into producto (descripcion, nombre) values ("Herramienta para jugar ping pong", "Raqueta");
insert into producto (descripcion, nombre) values ("Utensilio de cocina", "Cuchara");
insert into producto (descripcion, nombre) values ("Mueble para el hogar cómodo", "Mueble");
insert into producto (descripcion, nombre) values ("Componente electrónico para computadores", "Mouse");
insert into producto (descripcion, nombre) values ("Aditamento para guitarra acústica", "Cuerdas de guitarra acústica");

insert into publicacion_producto (titulo, cantidad, estado, fecha_limite, precio, id_producto, cedula_creador, eliminado) values ("Primera publicacion", 14, "ACTIVO", '2023-04-17 03:33:42.400000', 1000, 1, "2222220", false);
insert into publicacion_producto (titulo, cantidad, estado, fecha_limite, precio, id_producto, cedula_creador, eliminado) values ("Segunda publicacion",24, "INACTIVO", '2023-05-17 02:42:42.300000', 2000, 2, "2222221", false);
insert into publicacion_producto (titulo, cantidad, estado, fecha_limite, precio, id_producto, cedula_creador, eliminado) values ("Tercera publicacion",66, "INACTIVO", '2023-02-17 04:23:42.406000', 3000, 3, "2222220", false);
insert into publicacion_producto (titulo, cantidad, estado, fecha_limite, precio, id_producto, cedula_creador, eliminado) values ("Cuerta publicacion",74, "ACTIVO", '2023-01-17 07:12:42.405000', 4000, 4, "2222223", false);
insert into publicacion_producto (titulo, cantidad, estado, fecha_limite, precio, id_producto, cedula_creador, eliminado) values ("Quinda publicacion",42, "ACTIVO", '2023-02-17 22:56:42.400010', 5000, 5, "2222224", false);

insert into imagen (url, cedula_moderador, id_publicacion, cedula_usuario) values ("https://picsum.photos/450/225", null, 1, null);
insert into imagen (url, cedula_moderador, id_publicacion, cedula_usuario) values ("https://acortar.link/OK3X2l", null, 2, null);
insert into imagen (url, cedula_moderador, id_publicacion, cedula_usuario) values ("https://acortar.link/V5kaDD", null, 3, null);
insert into imagen (url, cedula_moderador, id_publicacion, cedula_usuario) values ("https://acortar.link/Ma9Gto", null, 4, null);
insert into imagen (url, cedula_moderador, id_publicacion, cedula_usuario) values ("https://acortar.link/73iDEh", null, 5, null);

insert into compra (fecha, medio_pago, valor_total, usuario_cedula) values ('2023-04-17', "PAYPAL", 5000, "2222221");
insert into compra (fecha, medio_pago, valor_total, usuario_cedula) values ('2023-05-13', "PAYPAL", 5000, "2222222");
insert into compra (fecha, medio_pago, valor_total, usuario_cedula) values ('2023-06-1', "TARJETACREDITO", 5000, "2222223");
insert into compra (fecha, medio_pago, valor_total, usuario_cedula) values ('2023-07-15', "PAYPAL", 5000, "2222223");
insert into compra (fecha, medio_pago, valor_total, usuario_cedula) values ('2023-07-20', "TARJETACREDITO", 5000, "2222224");
insert into compra (fecha, medio_pago, valor_total, usuario_cedula) values ('2023-05-13', "TARJETACREDITO", 5000, "2222220");
insert into compra (fecha, medio_pago, valor_total, usuario_cedula) values ('2023-05-14', "PAYPAL", 5000, "2222220");
insert into compra (fecha, medio_pago, valor_total, usuario_cedula) values ('2023-01-11', "TARJETACREDITO", 5000, "2222221");

insert into compra_producto (cantidad,id_compra,id_publicacion) values (4, 1, 2);
insert into compra_producto (cantidad,id_compra,id_publicacion) values (3, 2, 2);
insert into compra_producto (cantidad,id_compra,id_publicacion) values (6, 3, 3);
insert into compra_producto (cantidad,id_compra,id_publicacion) values (1, 4, 3);
insert into compra_producto (cantidad,id_compra,id_publicacion) values (2, 5, 4);
insert into compra_producto (cantidad,id_compra,id_publicacion) values (2, 6, 4);
insert into compra_producto (cantidad,id_compra,id_publicacion) values (4, 7, 5);
insert into compra_producto (cantidad,id_compra,id_publicacion) values (3, 8, 5);

insert into producto_favorito (id_publicacion, cedula_usuario) values (1, "2222221");
insert into producto_favorito (id_publicacion, cedula_usuario) values (1, "2222220");
insert into producto_favorito (id_publicacion, cedula_usuario) values (2, "2222222");
insert into producto_favorito (id_publicacion, cedula_usuario) values (3, "2222223");
insert into producto_favorito (id_publicacion, cedula_usuario) values (4, "2222224");
insert into producto_favorito (id_publicacion, cedula_usuario) values (5, "2222220");

insert into comentario (descripcion, fecha, puntuacion, id_publicacion, cedula_usuario, eliminado) values ("Mal producto", '2023-04-17', 1.0, 1, "2222220", false);
insert into comentario (descripcion, fecha, puntuacion, id_publicacion, cedula_usuario, eliminado) values ("Que chimba de servicio, recomendad", '2023-04-17', 5.0, 2, "2222221", false);
insert into comentario (descripcion, fecha, puntuacion, id_publicacion, cedula_usuario, eliminado) values ("El producto es bueno dentro de lo que cabe", '2023-02-20', 3.0, 3, "2222220", false);
insert into comentario (descripcion, fecha, puntuacion, id_publicacion, cedula_usuario, eliminado) values ("Esta re melo", '2023-04-17', 5.0, 4,"2222223", false);
insert into comentario (descripcion, fecha, puntuacion, id_publicacion, cedula_usuario, eliminado) values ("Esta re pailas el servicio", '2023-04-17', 1.0, 5, "2222224", false);

insert into producto_categoria (id_producto, id_categoria) values (1, 3);
insert into producto_categoria (id_producto, id_categoria) values (2, 3);
insert into producto_categoria (id_producto, id_categoria) values (3, 3);
insert into producto_categoria (id_producto, id_categoria) values (3, 7);
insert into producto_categoria (id_producto, id_categoria) values (4, 2);
insert into producto_categoria (id_producto, id_categoria) values (5, 3);
