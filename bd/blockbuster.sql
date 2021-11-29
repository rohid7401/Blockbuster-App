drop database if exists blockbuster;
create database if not exists blockbuster;
use blockbuster;

drop user if exists 'blockbusterappuser'@'localhost';
create user if not exists 'blockbusterappuser'@'localhost' identified by 'blockbusterapppass';
grant select, insert, update, delete, execute on blockbuster.* to 'blockbusterappuser'@'localhost';

SET autocommit = OFF;

CREATE TABLE CLIENTE (
    cedula INT PRIMARY KEY NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    direccion VARCHAR(50),
    telefono VARCHAR(30)    
);

CREATE TABLE CATEGORIA (
	id INT PRIMARY KEY NOT NULL,
    nombre VARCHAR(30) NOT NULL
);

CREATE TABLE PELICULA (
    codigo INT PRIMARY KEY NOT NULL,
    titulo VARCHAR(30) NOT NULL,
    fecha_lanzamiento date,
    categoria_id INT,
    constraint categoria_fk foreign key (categoria_id) REFERENCES CATEGORIA(id)
);

CREATE TABLE PRESTAMO (
    cedula INT NOT NULL,
    codigo INT NOT NULL,
    estado VARCHAR(20),
    fecha_prestamo date,
    fecha_devolucion date,
    constraint cedula_fk foreign key (cedula) REFERENCES CLIENTE(cedula),
    constraint codigo_fk foreign key (codigo) REFERENCES PELICULA(codigo)
);

ALTER TABLE PRESTAMO ADD PRIMARY KEY (cedula, codigo);
ALTER TABLE CLIENTE ALTER COLUMN direccion SET DEFAULT 'N/A';

DELIMITER //
create procedure createLoan(in ced int,in cod int,in est VARCHAR(20),in fp date,in fd date)
begin
	insert into PRESTAMO(cedula, codigo, estado, fecha_prestamo, fecha_devolucion) values(ced, cod, est, fp, fd);
commit;
END //
DELIMITER ;
call createLoan(1, 1, 'inactivo', 20211119, 20211121);

DELIMITER //
create procedure readLoan(in ced int,in cod int)
begin
	select * from PRESTAMO where cedula=ced AND codigo=cod;
commit;
END //
DELIMITER ;
call readLoan(1, 1);

DELIMITER //
create procedure updateLoan(in ced int,in cod int,in est VARCHAR(20),in fd date)
begin
	update PRESTAMO set estado=est, fecha_devolucion=fd where cedula=ced AND codigo=cod; 
commit;
END //
DELIMITER ;
call updateLoan(1, 1, 'Activo', 20211129)

DELIMITER //
create procedure deleteLoan(in ced int,in cod int)
begin
	delete from	PRESTAMO where cedula=ced AND codigo=cod;
commit;
END //
DELIMITER ;

-- 
DELIMITER //
create procedure createCategory(in id int,in nombre VARCHAR(30))
begin
	insert into CATEGORIA(id, nombre) values(id, nombre);
commit;
END //
DELIMITER ;

DELIMITER //
create procedure readCategory(in id int)
begin
	select * from CATEGORIA where id=id;
commit;
END //
DELIMITER ;

DELIMITER //
create procedure updateCategory(in id int,in nombre varchar(30))
begin
	update CATEGORIA set nombre=nombre where id=id; 
commit;
END //
DELIMITER ;

DELIMITER //
create procedure deleteCategory(in id int)
begin
	delete from	CATEGORIA where id=id;
commit;
END //
DELIMITER ;

select * from CLIENTE;
select * from CATEGORIA where nombre='';
select * from PELICULA;
select * from PRESTAMO;
select cedula, nombre, apellido, telefono from CLIENTE where cedula in(select cedula from PRESTAMO);
select cedula, count(*) from PRESTAMO where estado = 'activo';
select cedula, count(*) from PRESTAMO where estado = 'inactivo';
select count(*) from PRESTAMO where estado = 'inactivo';
select * from CLIENTE where cedula not in(select cedula from PRESTAMO);
update CLIENTE SET direccion='Guanacaste' where cedula=10; 
select cedula, nombre, apellido from CLIENTE where cedula in(select cedula from PRESTAMO where estado='activo');


insert into CLIENTE(cedula, nombre, apellido, direccion, telefono) values (1, 'Andrea', 'Baldioceda', 'Liberia', '84123456');
insert into CLIENTE(cedula, nombre, apellido, direccion, telefono) values (2, 'Adrian', 'Parajeles', 'Cañas', '87654321');
insert into CLIENTE(cedula, nombre, apellido, direccion, telefono) values (3, 'Alberto', 'Sandi', 'Guapiles', '42680135');
insert into CLIENTE(cedula, nombre, apellido, direccion, telefono) values (4, 'Jocxan', 'Sandi', 'Siquirres', '98765432');
insert into CLIENTE(cedula, nombre, apellido, direccion, telefono) values (5, 'Paul', 'Bogantes', 'Barranca', '24941234');
insert into CLIENTE(cedula, nombre, apellido, direccion, telefono) values (6, 'Fabiola', 'Quesada', 'Guacimo', '24949876');
insert into CLIENTE(cedula, nombre, apellido, direccion, telefono) values (7, 'Brayan', 'Bonilla', 'San Juan', '56892317');
insert into CLIENTE(cedula, nombre, apellido, telefono) values (8, 'Cristian', 'Perez', '42687139');
insert into CLIENTE(cedula, nombre, apellido, direccion, telefono) values (9, 'Kenneth', 'Mendoza', 'Tacares', '78561234');
insert into CLIENTE(cedula, nombre, apellido, direccion, telefono) values (10, 'Rohi', 'Prendas', 'Grecia', '91378624');

insert into CATEGORIA(id, nombre) values(1, "Action");
insert into CATEGORIA(id, nombre) values(2, "Sci-fi");
insert into CATEGORIA(id, nombre) values(3, "Drama");
insert into CATEGORIA(id, nombre) values(4, "Fantasy");
insert into CATEGORIA(id, nombre) values(5, "Comedy");
insert into CATEGORIA(id, nombre) values(6, "Adventure");
insert into CATEGORIA(id, nombre) values(7, "Romance");
insert into CATEGORIA(id, nombre) values(8, "Suspense");
insert into CATEGORIA(id, nombre) values(9, "Thriller");
insert into CATEGORIA(id, nombre) values(10, "Musical");

insert into PELICULA(codigo, titulo, fecha_lanzamiento, categoria_id) values(1, 'Godzilla vs. Kong', 20210331, 2);
insert into PELICULA(codigo, titulo, fecha_lanzamiento, categoria_id) values(2, 'Venom', 20181005, 1);
insert into PELICULA(codigo, titulo, fecha_lanzamiento, categoria_id) values(3, 'Soul ', 20201011, 4);
insert into PELICULA(codigo, titulo, fecha_lanzamiento, categoria_id) values(4, 'Spider-Man: Far from Home', 20190502, 1);
insert into PELICULA(codigo, titulo, fecha_lanzamiento, categoria_id) values(5, 'Joker', 20191004, 3);
insert into PELICULA(codigo, titulo, fecha_lanzamiento, categoria_id) values(6, 'Avengers: Endgame', 20190426, 1);
insert into PELICULA(codigo, titulo, fecha_lanzamiento, categoria_id) values(7, 'The Chronicles of Narnia', 20101210, 4);
insert into PELICULA(codigo, titulo, fecha_lanzamiento, categoria_id) values(8, 'Nanny McPhee Returns', 20100402, 5);
insert into PELICULA(codigo, titulo, fecha_lanzamiento, categoria_id) values(9, 'How to Train Your Dragon', 20100321, 6);
insert into PELICULA(codigo, titulo, fecha_lanzamiento, categoria_id) values(10, 'Toy Story 3', 20100518, 5);

insert into PRESTAMO(cedula, codigo, estado, fecha_prestamo, fecha_devolucion) values(1, 1, 'activo', 20210930, 20211003);
insert into PRESTAMO(cedula, codigo, estado, fecha_prestamo, fecha_devolucion) values(1, 2, 'inactivo', 20210818, 20210821);
insert into PRESTAMO(cedula, codigo, estado, fecha_prestamo, fecha_devolucion) values(1, 3, 'activo', 20210930, 20211003);
insert into PRESTAMO(cedula, codigo, estado, fecha_prestamo, fecha_devolucion) values(2, 4, 'inactivo', 20210730, 20210802);
insert into PRESTAMO(cedula, codigo, estado, fecha_prestamo, fecha_devolucion) values(3, 5, 'activo', 20211001, 20211004);
insert into PRESTAMO(cedula, codigo, estado, fecha_prestamo, fecha_devolucion) values(4, 6, 'inactivo', 20210927, 20210930);
insert into PRESTAMO(cedula, codigo, estado, fecha_prestamo, fecha_devolucion) values(5, 7, 'inactivo', 20210925, 20210928);
insert into PRESTAMO(cedula, codigo, estado, fecha_prestamo, fecha_devolucion) values(6, 8, 'activo', 20210930, 20211003);
insert into PRESTAMO(cedula, codigo, estado, fecha_prestamo, fecha_devolucion) values(7, 9, 'inactivo', 20210921, 20210924);
insert into PRESTAMO(cedula, codigo, estado, fecha_prestamo, fecha_devolucion) values(7, 10, 'activo', 20210130, 20210202);