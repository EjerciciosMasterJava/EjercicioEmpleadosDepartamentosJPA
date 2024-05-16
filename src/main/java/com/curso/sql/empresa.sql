CREATE SCHEMA IF NOT EXISTS empresa;

USE empresa;

CREATE TABLE IF NOT EXISTS empresa.departamento(
id_dept INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
nombre VARCHAR(255) NOT NULL,
localidad VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS empresa.empleado(
id_emp INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
nombre VARCHAR(255) NOT NULL,
fecha DATE NULL,
sueldo DOUBLE NULL,
id_dept INTEGER NULL,
  CONSTRAINT `fkdept`
    FOREIGN KEY (id_dept)
    REFERENCES empresa.departamento (id_dept)
);


insert into empresa.departamento (id_dept, nombre, localidad) values (1, 'Rubie', '9 Summer Ridge Plaza');
insert into empresa.departamento (id_dept, nombre, localidad) values (2, 'Hollis', '72724 Surrey Parkway');
insert into empresa.departamento (id_dept, nombre, localidad) values (3, 'Nydia', '4 Melody Road');
insert into empresa.departamento (id_dept, nombre, localidad) values (4, 'Herby', '9 Arkansas Parkway');
insert into empresa.departamento (id_dept, nombre, localidad) values (5, 'Hetty', '07 Packers Avenue');
insert into empresa.departamento (id_dept, nombre, localidad) values (6, 'Debbie', '6214 Sachtjen Trail');
insert into empresa.departamento (id_dept, nombre, localidad) values (7, 'Patrica', '69 Judy Center');
insert into empresa.departamento (id_dept, nombre, localidad) values (8, 'Brandy', '34875 Orin Court');
insert into empresa.departamento (id_dept, nombre, localidad) values (9, 'Esra', '29 Mccormick Circle');
insert into empresa.departamento (id_dept, nombre, localidad) values (10, 'Fianna', '43715 Harper Junction');


insert into empresa.empleado (id_emp, nombre, fecha, sueldo, id_dept) values (1, 'Lou', '2023-11-10', 1722, 1);
insert into empresa.empleado (id_emp, nombre, fecha, sueldo, id_dept) values (2, 'Sacha', '2024-04-04', 1683, 7);
insert into empresa.empleado (id_emp, nombre, fecha, sueldo, id_dept) values (3, 'Marinna', '2023-11-24', 1719, 5);
insert into empresa.empleado (id_emp, nombre, fecha, sueldo, id_dept) values (4, 'Querida', '2024-04-27', 1220, 5);
insert into empresa.empleado (id_emp, nombre, fecha, sueldo, id_dept) values (5, 'Bartolomeo', '2023-11-26', 1186, 9);
insert into empresa.empleado (id_emp, nombre, fecha, sueldo, id_dept) values (6, 'Dyanne', '2023-05-17', 1528, 4);
insert into empresa.empleado (id_emp, nombre, fecha, sueldo, id_dept) values (7, 'Hewitt', '2023-08-16', 1993, 10);
insert into empresa.empleado (id_emp, nombre, fecha, sueldo, id_dept) values (8, 'Rutger', '2023-12-28', 1467, 3);
insert into empresa.empleado (id_emp, nombre, fecha, sueldo, id_dept) values (9, 'Pooh', '2023-09-10', 1888, 9);
insert into empresa.empleado (id_emp, nombre, fecha, sueldo, id_dept) values (10, 'Kesley', '2023-07-07', 1895, 1);