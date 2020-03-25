/*Tabla paises*/
INSERT INTO paises (id,nombre,iso,prefijotel) VALUES (1,'Colombia','CO',57);
INSERT INTO paises (id,nombre,iso,prefijotel) VALUES (2,'Mejico','ME',56);
INSERT INTO paises (id,nombre,iso,prefijotel) VALUES (3,'Argentina','AR',55);
INSERT INTO paises (id,nombre,iso,prefijotel) VALUES (4,'Paraguay','PA',54);
INSERT INTO paises (id,nombre,iso,prefijotel) VALUES (5,'Peru','PE',53);
INSERT INTO paises (id,nombre,iso,prefijotel) VALUES (6,'Venezuela','VE',52);



/*Tabla Estados*/
INSERT INTO estados (id,nombre,pais_id) VALUES (1,'Guadalajara',2);
INSERT INTO estados (id,nombre,pais_id) VALUES (2,'Mejico',2);
INSERT INTO estados (id,nombre,pais_id) VALUES (3,'Yucatan',2);
INSERT INTO estados (id,nombre,pais_id) VALUES (4,'Jalisco',2);
INSERT INTO estados (id,nombre,pais_id) VALUES (5,'Antioquia',1);
INSERT INTO estados (id,nombre,pais_id) VALUES (6,'Cundinamarca',1);
INSERT INTO estados (id,nombre,pais_id) VALUES (7,'Atlantico',1);
INSERT INTO estados (id,nombre,pais_id) VALUES (8,'Bolivar',1);
INSERT INTO estados (id,nombre,pais_id) VALUES (9,'Maracaibo',6);


/*Tabla Contactos*/
INSERT INTO contactos (nombre, telefono, celular, direccion,estado_id,latitud,longitud,fechacreacion,fechamodificacion) VALUES ('contacto1','2601085','3032134567','calle 46 no.54-32',1,'latitud','longitud','2019-05-13','2019-05-13');
INSERT INTO contactos (nombre, telefono, celular, direccion,estado_id,latitud,longitud,fechacreacion,fechamodificacion) VALUES ('contacto2','2601085','3032134567','calle 6 no.4-32',2,'latitud','longitud','2020-01-13','2020-12-13');
INSERT INTO contactos (nombre, telefono, celular, direccion,estado_id,latitud,longitud,fechacreacion,fechamodificacion) VALUES ('contacto3','2601085','3032134567','carrera 96 no.54-32',3,'latitud','longitud','2020-02-13','2020-11-13');



/*Tabla Empresas*/
INSERT INTO empresas (correo,direccion,fechacreacion,estado_id,idcontacto,latitud,idlogo,longitud,nombre,numeroid,telefono,tipoid,fechamodificacion) VALUES ('empresa@correo.gmail.com','calle 46 no.54-32','2019-05-13',1,1,'latitud',13,'longitud','empresa fabricante',8600029644,2601083,'N','2019-05-13');
INSERT INTO empresas (correo,direccion,fechacreacion,estado_id,idcontacto,latitud,idlogo,longitud,nombre,numeroid,telefono,tipoid,fechamodificacion) VALUES ('empresa@b.hotmail.com','calle 13 no.54-10','2019-01-13',6,2,'latitud',14,'longitud','empresa usuaria',8911129644,2601083,'N','2019-05-13');


