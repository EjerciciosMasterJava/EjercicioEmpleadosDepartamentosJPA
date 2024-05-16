CREATE SCHEMA IF NOT EXISTS `empresa`;

USE `empresa`;

CREATE TABLE IF NOT EXISTS `empresa`.`departamento`(`id_dept` INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,`nombre` VARCHAR(255) NOT NULL,`localidad` VARCHAR(255) NOT NULL);

CREATE TABLE IF NOT EXISTS `empresa`.`empleado`(`id_emp` INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,`nombre` VARCHAR(255) NOT NULL,`fecha` DATE NULL,`sueldo` DOUBLE NULL,`id_dept` INTEGER NULL,CONSTRAINT `fkdept`FOREIGN KEY (id_dept)REFERENCES `empresa`.`departamento` (id_dept));