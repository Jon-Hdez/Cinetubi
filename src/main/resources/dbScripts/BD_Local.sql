DROP DATABASE IF EXISTS CineTubi;
CREATE DATABASE IF NOT EXISTS CineTubi;
USE CineTubi;

-- Crear tabla Socio
CREATE TABLE socio (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(50) NOT NULL,
  paterno VARCHAR(50) NOT NULL,
  materno VARCHAR(50) NOT NULL,
  fecha_inicio DATE,
  puntos INT DEFAULT 0,
  passwd VARCHAR(72) NOT NULL
);

-- Crear tabla categoria_empleado
CREATE TABLE categoria_empleado (
    id INT AUTO_INCREMENT PRIMARY KEY,
    categoria VARCHAR(50) NOT NULL,
    sueldo DECIMAL(10, 2) NOT NULL CHECK (sueldo > 0),
    area VARCHAR(15) NOT NULL DEFAULT 'dulceria'
);

-- Crear tabla empleado
CREATE TABLE empleado (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    paterno VARCHAR(50) NOT NULL,
    materno VARCHAR(50) NOT NULL,
    id_categoria INT NOT NULL,
    psw VARCHAR(25) NOT NULL,
    CONSTRAINT fk_categoria FOREIGN KEY (id_categoria) REFERENCES categoria_empleado(id)
        ON DELETE RESTRICT ON UPDATE CASCADE
);

-- Crear tabla pelicula
CREATE TABLE pelicula (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(50) NOT NULL,
    duracion INT NOT NULL CHECK (duracion > 0),
    distribuidor VARCHAR(50) NOT NULL,
    clasificacion VARCHAR(10) NOT NULL,
    director VARCHAR(50) NOT NULL,
    pais VARCHAR(50) NOT NULL,
    descripcion MEDIUMTEXT
    
);

-- Crear tabla sala
CREATE TABLE sala (
    id INT AUTO_INCREMENT PRIMARY KEY,
    categoria VARCHAR(50) NOT NULL CHECK (categoria IN ('VIP', '3D', 'Estandar')),
    capacidad INT NOT NULL CHECK (capacidad > 0),
    estado VARCHAR(50) NOT NULL CHECK (estado IN ('disponible', 'ocupada', 'mantenimiento'))
);
-- Crear tabla función
CREATE TABLE funcion (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_pelicula INT NOT NULL,
    horario TIME NOT NULL,
    id_sala INT NOT NULL,
    idioma VARCHAR(30) NOT NULL CHECK (idioma IN ('Español', 'Ingles')),
    fecha DATE NULL,
    CONSTRAINT fk_pelicula FOREIGN KEY (id_pelicula) REFERENCES pelicula(id)
        ON DELETE RESTRICT ON UPDATE CASCADE,
    CONSTRAINT fk_sala FOREIGN KEY (id_sala) REFERENCES sala(id)
        ON DELETE RESTRICT ON UPDATE CASCADE
);

-- Crear tabla snack
CREATE TABLE snack (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    precio DECIMAL(10, 2) NOT NULL CHECK (precio > 0),
    tamanio VARCHAR(15) NULL CHECK (tamanio IN ('chico', 'mediano', 'grande', null))
);

-- Crear tabla cartelera
CREATE TABLE cartelera (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_funcion INT NOT NULL,
    CONSTRAINT fk_funcion FOREIGN KEY (id_funcion) REFERENCES funcion(id)
        ON DELETE RESTRICT ON UPDATE CASCADE
);

-- Crear tabla venta
CREATE TABLE venta (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_empleado INT NOT NULL,
    id_socio INT,
    metodo_pago VARCHAR(30) NOT NULL CHECK (metodo_pago IN ('efectivo', 'credito')),
    area VARCHAR(30) NOT NULL CHECK (area IN ('taquilla', 'dulceria')),
    total DECIMAL DEFAULT 100.0,
    creada_en DATETIME DEFAULT NOW(),
    CONSTRAINT fk_empleado FOREIGN KEY (id_empleado) REFERENCES empleado(id)
        ON DELETE RESTRICT ON UPDATE CASCADE,
    CONSTRAINT fk_socio FOREIGN KEY (id_socio) REFERENCES socio(id)
        ON DELETE SET NULL ON UPDATE CASCADE
);

-- Crear tabla combo
CREATE TABLE combo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(30),
    precio DECIMAL(10,2) CHECK (precio >0)
);


-- Versión usando llave compuesta para Asiento, nota como se tienen que agregar dos columnas a Boleto, id_sala y numero_asiento, para poder implementar la llave foranea compuesta que hace referencia a Asiento.
CREATE TABLE asiento (
	id_sala INT NOT NULL,
    numero INT NOT NULL CHECK (numero BETWEEN 1 AND 30),
    PRIMARY KEY (id_sala, numero),
    CONSTRAINT fk_a_id_sala FOREIGN KEY (id_sala) REFERENCES sala(id)
);
-- Crear tabla boleto
CREATE TABLE boleto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_funcion INT NOT NULL,
    id_venta INT NOT NULL,
    id_sala INT NOT NULL,
    numero_asiento INT NOT NULL,
    -- CONSTRAINT fk_b_funcion FOREIGN KEY (id_funcion) REFERENCES funcion(id),
    CONSTRAINT fk_b_venta FOREIGN KEY (id_venta) REFERENCES venta(id)-- ,
    -- CONSTRAINT fk_b_asiento FOREIGN KEY (id_sala, numero_asiento) REFERENCES asiento(id_sala, numero)
);

/*
CREATE TABLE asiento (
	id INT PRIMARY KEY AUTO_INCREMENT,
	id_sala INT NOT NULL,
    numero INT NOT NULL,
    CONSTRAINT fk_a_id_sala FOREIGN KEY (id_sala) REFERENCES sala(id)
);

-- Crear tabla boleto
CREATE TABLE boleto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_funcion INT NOT NULL,
    id_venta INT NOT NULL,
    id_asiento INT NOT NULL,
    CONSTRAINT fk_b_funcion FOREIGN KEY (id_funcion) REFERENCES funcion(id) ON DELETE CASCADE,
    CONSTRAINT fk_b_venta FOREIGN KEY (id_venta) REFERENCES venta(id) ON DELETE CASCADE,
    CONSTRAINT fk_b_asiento FOREIGN KEY (id_asiento) REFERENCES asiento(id) ON DELETE CASCADE
);
*/
-- Tablas Puente
CREATE TABLE venta_snack (	
	id INT PRIMARY KEY AUTO_INCREMENT,
    id_venta INT NOT NULL,
    id_snack INT NOT NULL,
    CONSTRAINT fk_vs_venta FOREIGN KEY (id_venta) REFERENCES venta(id) ON DELETE CASCADE,
    CONSTRAINT fk_vs_snack FOREIGN KEY (id_snack) REFERENCES snack(id) ON DELETE CASCADE
);

-- Se murio
/*
CREATE TABLE venta_combo (	
	id INT PRIMARY KEY AUTO_INCREMENT,
    id_venta INT NOT NULL,
    id_combo INT NOT NULL,
    CONSTRAINT fk_vc_venta FOREIGN KEY (id_venta) REFERENCES venta(id) ON DELETE CASCADE,
    CONSTRAINT fk_vc_combo FOREIGN KEY (id_combo) REFERENCES combo(id) ON DELETE CASCADE
);*/

CREATE TABLE combo_snack (	
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_combo INT NOT NULL,
    id_snack INT NOT NULL,
    CONSTRAINT fk_cs_combo FOREIGN KEY (id_combo) REFERENCES combo(id) ON DELETE CASCADE,
    CONSTRAINT fk_cs_snack FOREIGN KEY (id_snack) REFERENCES snack(id) ON DELETE CASCADE
);

-- Insert sample data into socio
INSERT INTO socio (nombre, paterno, materno, fecha_inicio, puntos, passwd) VALUES
('Juan', 'Pérez', 'Gómez', '2023-01-15', 100, 'password123'),
('Ana', 'García', 'Lopez', '2023-02-20', 200, 'password456'),
('Luis', 'Martínez', 'Paredes', '2023-03-05', 150, 'password789'),
('Marta', 'Jiménez', 'Fernández', '2023-04-10', 250, 'password321'),
('Pedro', 'Hernández', 'Sánchez', '2023-05-15', 300, 'password654'),
('Claudia', 'Morales', 'Ramírez', '2023-06-20', 180, 'password987'),
('Jorge', 'Torres', 'Pérez', '2023-07-25', 120, 'password654'),
('Elena', 'González', 'Molina', '2023-08-30', 200, 'password112'),
('Ricardo', 'Álvarez', 'López', '2023-09-10', 220, 'password113'),
('Sofía', 'Reyes', 'Castro', '2023-10-05', 160, 'password114');

-- Insert sample data into categoria_empleado
INSERT INTO categoria_empleado (categoria, sueldo, area) VALUES
('Cajero', 1500.00, 'dulceria'),
('Encargado', 2500.00, 'cartelera'),
('Gerente', 3500.00, 'cartelera'),
('Supervisor', 3000.00, 'dulceria'),
('Auxiliar', 1200.00, 'taquilla');

-- Insert sample data into empleado
INSERT INTO empleado (nombre, paterno, materno, id_categoria, psw) VALUES
('droot', 'droot', 'droot', 1, 'droot'),
('admin', 'admin', 'admin', 2, 'admin'),
('María', 'Rodríguez', 'Sánchez', 2, 'psw101112'),
('Ana', 'Martínez', 'Gómez', 3, 'psw131415'),
('Pedro', 'González', 'Ríos', 4, 'psw161718'),
('Lucía', 'Pérez', 'Fernández', 5, 'psw192021'),
('Gabriel', 'Soto', 'López', 1, 'psw222324'),
('Laura', 'Ramírez', 'Hernández', 2, 'psw252627'),
('Miguel', 'Jiménez', 'Rodríguez', 3, 'psw282930'),
('Isabel', 'Álvarez', 'García', 4, 'psw313233'),
('Andrés', 'Cano', 'Martínez', 5, 'psw343536'),
('ramita','tacos', 'pastor', 5, 'psw');

-- Insert sample data into pelicula
INSERT INTO Pelicula (titulo, distribuidor, duracion, clasificacion, director, pais) VALUES 
('Inception', 'Warner Bros', 148, 'PG-13', 'Christopher Nolan', 'USA'),
('The Matrix', 'Warner Bros', 136, 'R', 'Lana Wachowski, Lilly Wachowski', 'USA'),
('Interstellar', 'Paramount Pictures', 169, 'PG-13', 'Christopher Nolan', 'USA'),
('The Dark Knight', 'Warner Bros', 152, 'PG-13', 'Christopher Nolan', 'USA'),
('Pulp Fiction', 'Miramax', 154, 'R', 'Quentin Tarantino', 'USA'),
('Fight Club', '20th Century Fox', 139, 'R', 'David Fincher', 'USA'),
('Forrest Gump', 'Paramount Pictures', 142, 'PG-13', 'Robert Zemeckis', 'USA'),
('The Shawshank Redemption', 'Columbia Pictures', 142, 'R', 'Frank Darabont', 'USA'),
('The Godfather', 'Paramount Pictures', 175, 'R', 'Francis Ford Coppola', 'USA'),
('The Godfather Part II', 'Paramount Pictures', 202, 'R', 'Francis Ford Coppola', 'USA'),
('The Lord of the Rings: The Fellowship of the Ring', 'New Line Cinema', 178, 'PG-13', 'Peter Jackson', 'New Zealand'),
('The Lord of the Rings: The Two Towers', 'New Line Cinema', 179, 'PG-13', 'Peter Jackson', 'New Zealand'),
('The Lord of the Rings: The Return of the King', 'New Line Cinema', 201, 'PG-13', 'Peter Jackson', 'New Zealand'),
('Gladiator', 'DreamWorks', 155, 'R', 'Ridley Scott', 'USA'),
('The Departed', 'Warner Bros', 151, 'R', 'Martin Scorsese', 'USA'),
('The Silence of the Lambs', 'Orion Pictures', 118, 'R', 'Jonathan Demme', 'USA'),
('The Usual Suspects', 'Bryan Singer', 106, 'R', 'Bryan Singer', 'USA'),
('Se7en', 'New Line Cinema', 127, 'R', 'David Fincher', 'USA'),
('The Lion King', 'Disney', 88, 'G', 'Roger Allers, Rob Minkoff', 'USA'),
('Toy Story', 'Pixar', 81, 'G', 'John Lasseter', 'USA'),
('Finding Nemo', 'Pixar', 100, 'G', 'Andrew Stanton', 'USA'),
('Up', 'Pixar', 96, 'PG', 'Pete Docter', 'USA'),
('WALL-E', 'Pixar', 98, 'G', 'Andrew Stanton', 'USA'),
('Ratatouille', 'Pixar', 111, 'G', 'Brad Bird', 'USA'),
('The Incredibles', 'Pixar', 115, 'PG', 'Brad Bird', 'USA'),
('Monsters, Inc.', 'Pixar', 92, 'G', 'Pete Docter', 'USA'),
('Brave', 'Pixar', 93, 'PG', 'Mark Andrews, Brenda Chapman', 'USA'),
('Coco', 'Pixar', 105, 'PG', 'Lee Unkrich', 'USA'),
('Inside Out', 'Pixar', 95, 'PG', 'Pete Docter', 'USA'),
('Star Wars: A New Hope', 'Lucasfilm', 121, 'PG', 'George Lucas', 'USA'),
('Star Wars: The Empire Strikes Back', 'Lucasfilm', 124, 'PG', 'Irvin Kershner', 'USA'),
('Star Wars: Return of the Jedi', 'Lucasfilm', 131, 'PG', 'Richard Marquand', 'USA'),
('Star Wars: The Phantom Menace', 'Lucasfilm', 136, 'PG', 'George Lucas', 'USA'),
('Star Wars: Attack of the Clones', 'Lucasfilm', 142, 'PG', 'George Lucas', 'USA'),
('Star Wars: Revenge of the Sith', 'Lucasfilm', 140, 'PG-13', 'George Lucas', 'USA'),
('Star Wars: The Force Awakens', 'Lucasfilm', 138, 'PG-13', 'J.J. Abrams', 'USA'),
('Star Wars: The Last Jedi', 'Lucasfilm', 152, 'PG-13', 'Rian Johnson', 'USA'),
('Star Wars: The Rise of Skywalker', 'Lucasfilm', 142, 'PG-13', 'J.J. Abrams', 'USA'),
('Jurassic Park', 'Universal Pictures', 127, 'PG-13', 'Steven Spielberg', 'USA'),
('Jurassic World', 'Universal Pictures', 124, 'PG-13', 'Colin Trevorrow', 'USA'),
('E.T. the Extra-Terrestrial', 'Universal Pictures', 115, 'PG', 'Steven Spielberg', 'USA'),
('Back to the Future', 'Universal Pictures', 116, 'PG', 'Robert Zemeckis', 'USA'),
('Indiana Jones and the Raiders of the Lost Ark', 'Paramount Pictures', 115, 'PG', 'Steven Spielberg', 'USA'),
('Indiana Jones and the Last Crusade', 'Paramount Pictures', 127, 'PG-13', 'Steven Spielberg', 'USA'),
('Raiders of the Lost Ark', 'Paramount Pictures', 115, 'PG', 'Steven Spielberg', 'USA'),
('Jaws', 'Universal Pictures', 124, 'PG', 'Steven Spielberg', 'USA'),
('Casablanca', 'Warner Bros', 102, 'PG', 'Michael Curtiz', 'USA'),
('The Big Lebowski', 'Universal Pictures', 117, 'R', 'Joel Coen, Ethan Coen', 'USA'),
('Goodfellas', 'Warner Bros', 146, 'R', 'Martin Scorsese', 'USA'),
('The Graduate', 'United Artists', 106, 'PG', 'Mike Nichols', 'USA');


-- Insert sample data into sala
INSERT INTO sala (categoria, capacidad, estado) VALUES
('VIP', 30, 'disponible'),
('Estandar', 30, 'disponible'),
('Estandar', 30, 'ocupada'),
('Estandar', 30, 'disponible'),
('Estandar', 30, 'disponible'),
('Estandar', 30, 'disponible'),
('Estandar', 30, 'ocupada'),
('Estandar', 30, 'disponible'),
('Estandar', 30, 'disponible'),
('Estandar', 30, 'disponible');

-- Insert sample data into funcion
INSERT INTO funcion (id_pelicula, horario, id_sala, idioma, fecha) VALUES
(1, '18:00:00', 1, 'Español', '2024-09-16'),
(2, '20:30:00', 2, 'Español', '2024-09-14'),
(3, '21:00:00', 3, 'Inglés', '2024-09-15'),
(4, '19:00:00', 4, 'Español', '2024-09-15'),
(5, '17:00:00', 5, 'Español', '2024-09-17'),
(6, '22:00:00', 6, 'Español', '2024-09-18'),
(7, '18:30:00', 7, 'Inglés', '2024-09-19'),
(8, '20:00:00', 8, 'Español', '2024-09-20'),
(9, '21:30:00', 9, 'Inglés', '2024-09-21'),
(10, '23:00:00', 10, 'Español', '2024-09-22');

-- Insert sample data into snack
INSERT INTO snack (nombre, precio, tamanio) VALUES
('Palomitas', 10.00, 'chicas'),
('Palomitas', 15.00, 'medianas'),
('Palomitas', 20.00, 'grandes'),
('Refresco', 8.00, null),
('Nachos', 6.00, null),
('Hot Dog', 7.00, null),
('Chocolates', 4.50, null);


-- Insert sample data into combo
INSERT INTO combo (nombre, precio) VALUES
('Combo Familiar', 12.00),
('Combo Individual', 6.00),
('Combo Grande', 15.00),
('Combo Pequeño', 8.00),
('Combo Premium', 18.00),
('Combo Básico', 10.00),
('Combo Deluxe', 20.00),
('Combo Especial', 14.00),
('Combo Standard', 7.00),
('Combo Extra', 16.00);

-- Insert sample data into cartelera
INSERT INTO cartelera (id_funcion) VALUES
(1),
(2),
(3),
(4),
(5),
(6),
(7),
(8),
(9),
(10);

-- Insert sample data into venta
INSERT INTO venta (id_empleado, id_socio, metodo_pago, area) VALUES
(1, 1, 'efectivo', 'taquilla'),
(2, 2, 'credito', 'dulceria'),
(3, 3, 'efectivo', 'taquilla'),
(4, 4, 'credito', 'dulceria'),
(5, 5, 'efectivo', 'taquilla'),
(6, 6, 'credito', 'dulceria'),
(7, 7, 'efectivo', 'taquilla'),
(8, 8, 'credito', 'dulceria'),
(9, 9, 'efectivo', 'taquilla'),
(10, 10, 'credito', 'dulceria'),
(11, null, 'credito', 'taquilla');

-- Insert sample data into asiento
INSERT INTO asiento (id_sala, numero) VALUES
(1, 1),(1, 2),(1, 3),(1, 4),(1, 5),(1, 6),(1, 7),(1, 8),(1, 9),(1, 10),
(2, 1),(2, 2),(2, 3),(2, 4),(2, 5),(2, 6),(2, 7),(2, 8),(2, 9),(2, 10),
(3, 1),(3, 2),(3, 3),(3, 4),(3, 5),(3, 6),(3, 7),(3, 8),(3, 9),(3, 10),
(4, 1),(4, 2),(4, 3),(4, 4),(4, 5),(4, 6),(4, 7),(4, 8),(4, 9),(4, 10),
(5, 1),(5, 2),(5, 3),(5, 4),(5, 5),(5, 6),(5, 7),(5, 8),(5, 9),(5, 10);

-- Insert sample data into boleto
INSERT INTO boleto (id_funcion, id_venta, id_sala, numero_asiento) VALUES
(1, 1, 1, 1), (1, 1, 1, 2), (1, 1, 1, 3), (1, 1, 1, 4), (1, 1, 1, 5),
(1, 1, 1, 6), (1, 1, 1, 7), (1, 1, 1, 8), (1, 1, 1, 9), (1, 1, 1, 10),
(2, 2, 2, 1), (2, 2, 2, 2), (2, 2, 2, 3), (2, 2, 2, 4), (2, 2, 2, 5),
(2, 2, 2, 6), (2, 2, 2, 7), (2, 2, 2, 8), (2, 2, 2, 9), (2, 2, 2, 10),
(3, 3, 3, 1), (3, 3, 3, 2), (3, 3, 3, 3), (3, 3, 3, 4), (3, 3, 3, 5),
(3, 3, 3, 6), (3, 3, 3, 7), (3, 3, 3, 8), (3, 3, 3, 9), (3, 3, 3, 10),
(4, 4, 4, 1), (4, 4, 4, 2), (4, 4, 4, 3), (4, 4, 4, 4), (4, 4, 4, 5);
-- Insert sample data into venta_snack
INSERT INTO venta_snack (id_venta, id_snack) VALUES
(1, 1),(1, 2),
(2, 3),(2, 4),
(3, 5),(3, 6),
(4, 7),(4, 1),
(5, 2),(5, 3),
(6, 1),(6, 3),
(7, 2),(7, 4),
(8, 5),(8, 6),
(9, 7),(9, 1),
(10, 2);

-- Insert sample data into combo_snack
INSERT INTO combo_snack (id_combo, id_snack) VALUES
(1, 1),(1, 2),
(2, 3),(2, 4),
(3, 5),(3, 6),
(4, 7),(4, 1),
(5, 2),(5, 3),
(6, 1),(6, 3),
(7, 2),(7, 4),
(8, 5),(8, 6),
(9, 7),(9, 1),
(10, 2);

-- Vista utilizada para ver los asientos, Ya no se utiliza pero se ve bien ;) 
/*CREATE VIEW boleto_asiento AS SELECT f.id AS idFuncion, a.numero AS numAsiento
FROM funcion AS f INNER JOIN sala AS s ON f.id_sala=s.id
INNER JOIN asiento AS a ON s.id=a.id_sala;


select *  from boleto_asiento;
SELECT * FROM boleto;
select * from funcion;

select b.numero_asiento as numAsiento
from  boleto as b inner join funcion as f on b.id_funcion=f.id
where f.id=1;

select * from pelicula where id=5;

SELECT MAX(id) FROM venta;


SELECT * FROM venta;

SELECT MAX(id) FROM venta;
*/