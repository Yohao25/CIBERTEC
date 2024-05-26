-- Creando base de datos por defecto
USE master; -- Usar la base de datos 'master' por defecto
GO

-- Crear la base de datos 'BD_BIBLIOTECA_SA' si no existe
IF NOT EXISTS (SELECT * FROM sys.databases WHERE name = 'BD_BIBLIOTECA_SA')
BEGIN
  CREATE DATABASE BD_BIBLIOTECA_SA;
END;
GO

-- Ingreso a la base de datos
USE BD_BIBLIOTECA_SA;
GO

-- Eliminar tabla Autores si existe
IF OBJECT_ID('Autores') IS NOT NULL
BEGIN
    DROP TABLE Autores;
END
GO

-- Tabla para almacenar informaci�n sobre autores
CREATE TABLE Autores (
    idAutor CHAR (6) NOT NULL PRIMARY KEY,
    NombreAutor VARCHAR(50) NOT NULL,
	ApellidoAutor VARCHAR(50) NOT NULL, 
    Nacionalidad VARCHAR(50) NOT NULL
);
GO

-- Eliminar tabla Generos si existe
IF OBJECT_ID('Generos') IS NOT NULL
BEGIN
    DROP TABLE Generos;
END
GO

-- Tabla para almacenar informaci�n sobre g�neros de libros
CREATE TABLE Generos (
    idGenero CHAR(5) NOT NULL PRIMARY KEY,
    NombreGenero VARCHAR(50) NOT NULL,
    Descripcion VARCHAR(350) NULL
);
GO

-- Eliminar tabla Libros si existe
IF OBJECT_ID('Libros') IS NOT NULL
BEGIN
    DROP TABLE Libros;
END
GO

-- Tabla para almacenar informaci�n sobre libros
CREATE TABLE Libros (
    idLibro CHAR(5) NOT NULL PRIMARY KEY,
    Titulo VARCHAR(200) NOT NULL,
    ISBN CHAR(14) NOT NULL,
	fecha_Publicaci�n DATE NOT NULL, 
    idAutor CHAR (6) NOT NULL,
    idGenero CHAR(5) NOT NULL,
    CONSTRAINT FK_AUTOR_LIBRO FOREIGN KEY (idAutor) REFERENCES Autores(idAutor),
    CONSTRAINT FK_GENERO_LIBRO FOREIGN KEY (idGenero) REFERENCES Generos(idGenero),
);
GO

-- Eliminar tabla TipoPrestamo si existe
IF OBJECT_ID('TipoPrestamo') IS NOT NULL
BEGIN
    DROP TABLE TipoPrestamo;
END
GO

-- Tabla para almacenar informaci�n sobre tipos de pr�stamo
CREATE TABLE TipoPrestamo (
    idTipoPrestamo CHAR (4) NOT NULL PRIMARY KEY,
    NombreTipPres VARCHAR (10) NOT NULL
);
GO

-- Eliminar tabla Administrativos si existe
IF OBJECT_ID('Administrativos') IS NOT NULL
BEGIN
    DROP TABLE Administrativos;
END
GO

-- Tabla para almacenar informaci�n sobre administrativos de la biblioteca
CREATE TABLE Administrativos (
    idAdministrativo CHAR(8) NOT NULL PRIMARY KEY,
    NombreAdmin VARCHAR(50) NOT NULL,
	ApellidoAdmin VARCHAR (50) NOT NULL,
    Cargo VARCHAR(50) NOT NULL
);
GO

-- Eliminar tabla Estudiantes si existe
IF OBJECT_ID('Estudiantes') IS NOT NULL
BEGIN
    DROP TABLE Estudiantes;
END
GO

-- Tabla para almacenar informaci�n sobre estudiantes
CREATE TABLE Estudiantes (
    idEstudiantes CHAR(8) NOT NULL PRIMARY KEY,
    NombreEst VARCHAR(50) NOT NULL,
	ApellidoEst VARCHAR (50) NOT NULL, 
	Sexo_Est CHAR (1) NULL,
	Edad_Est CHAR (2) not null, 
	Carrera VARCHAR (40) NOT NULL, 
    Direccion VARCHAR(150) NULL,
    Telefono VARCHAR(15) NULL
);
GO

-- Eliminar tabla Prestamos si existe
IF OBJECT_ID('Prestamos') IS NOT NULL
BEGIN
    DROP TABLE Prestamos;
END
GO

-- Tabla para almacenar informaci�n sobre pr�stamos de libros
CREATE TABLE Prestamos (
    idPrestamo CHAR(6) NOT NULL,
    FechaPrestamo DATE NOT NULL,
    FechaDevolucion DATE NOT NULL,
    idLibro CHAR(5) NOT NULL,
    idEstudiantes CHAR(8) NOT NULL,
	idAdministrativo CHAR(8) NOT NULL,
	idTipoPrestamo CHAR (4) NOT NULL,
    CONSTRAINT FK_LIBRO_PRESTAMO FOREIGN KEY (idLibro) REFERENCES Libros(idLibro),
    CONSTRAINT FK_EST_PRESTAMO FOREIGN KEY (idEstudiantes) REFERENCES Estudiantes(idEstudiantes),
	CONSTRAINT FK_ADM_PRESTAMO FOREIGN KEY (idAdministrativo) REFERENCES Administrativos(idAdministrativo),
	CONSTRAINT FK_TIPO_PRESTAMO FOREIGN KEY (idTipoPrestamo) REFERENCES TipoPrestamo(idTipoPrestamo),
	CONSTRAINT PK_prestamos PRIMARY KEY (idLibro, idEstudiantes, idAdministrativo, idTipoPrestamo, idPrestamo),
	CONSTRAINT CHK_FECHAS CHECK (FechaDevolucion > FechaPrestamo)
);
GO




 --@@@@@@@@@@@@@@@@@@@TRATAMIENTO DE DATOS DATOS@@@@@@@@@@@@@@@@@@@@@@@@@

 --INSERTAR REGISTROS A LA TABLA autores --Inserci�n
 INSERT INTO Autores 
 (idAutor, NombreAutor,    ApellidoAutor,   Nacionalidad) VALUES
('000001', 'Gabriel'   , 'Garc�a M�rquez', 'Colombiano'),
('000002', 'J.K.'      , 'Rowling'       , 'Brit�nico'),
('000003', 'Stephen'   , 'King'          , 'Estadounidense'),
('000004', 'Isabel'    , 'Allende'       , 'Chileno'),
('000005', 'Haruki'    , 'Murakami'      , 'Japon�s'),
('000006', 'Mario'     , 'Vargas Llosa'  , 'Peruano'),
('000007', 'Agatha'    , 'Christie'      , 'Brit�nico'),
('000008', 'Jane'      , 'Austen'        , 'Brit�nico'),
('000009', 'George'    , 'Orwell'        , 'Brit�nico'),
('000010', 'Victor'    , 'Hugo'          , 'Franc�s'),
('000011', 'Ernest'    , 'Hemingway'     , 'Estadounidense'),
('000012', 'Leo'       , 'Tolstoy'       , 'Ruso'),
('000013', 'Gabriela'  , 'Mistral'       , 'Chileno'),
('000014', 'Miguel'    , 'de Cervantes'  , 'Espa�ol'),
('000015', 'Pablo'     , 'Neruda'        , 'Chileno'),
('000016', 'J.R.R.'    , 'Tolkien'       , 'Brit�nico'),
('000017', 'Albert'    , 'Camus'         , 'Franc�s'),
('000018', 'Virginia'  , 'Woolf'         , 'Brit�nico'),
('000019', 'Fyodor'    , 'Dostoevsky'    , 'Ruso'),
('000020', 'Mark'      , 'Twain'         , 'Estadounidense'),
('000021', 'Anton'     , 'Chekhov'       , 'Ruso'),
('000022', 'Jorge Luis', 'Borges'        , 'Argentino'),
('000023', 'Hermann'   , 'Hesse'         , 'Alem�n'),
('000024', 'William'   , 'Faulkner'      , 'Estadounidense'),
('000025', 'Jane'      , 'Austen'        , 'Brit�nico'),
('000026', 'Oscar'     , 'Wilde'         , 'Irland�s'),
('000027', 'Emily'     , 'Dickinson'     , 'Estadounidense'),
('000028', 'Charles'   , 'Dickens'       , 'Brit�nico'),
('000029', 'Franz'     , 'Kafka'         , 'Checo'),
('000030', 'Leo'       , 'Tolstoy'       , 'Ruso'),
('000031', 'Marcel'    , 'Proust'        , 'Franc�s'),
('000032', 'Agatha'    , 'Christie'      , 'Brit�nico'),
('000033', 'George'    , 'Orwell'        , 'Brit�nico'),
('000034', 'John'      , 'Steinbeck'     , 'Estadounidense');

 SELECT * FROM Autores
 GO

--INSERTAR REGISTROS A LA TABLA GENEROS --Inserci�n

INSERT INTO Generos 
(idGenero, NombreGenero        , Descripcion) VALUES
('GEN01', 'Ficci�n'            , 'Narrativas creadas a partir de la imaginaci�n o fantas�a.'),
('GEN02', 'Misterio'           , 'Historias que involucran la resoluci�n de un enigma o crimen.'),
('GEN03', 'Realismo m�gico'    , 'G�nero literario que combina elementos de la realidad con elementos m�gicos o fant�sticos.'),
('GEN04', 'Romance'            , 'Narrativas centradas en relaciones amorosas.'),
('GEN05', 'Terror'             , 'Historias destinadas a causar miedo o terror en el lector.'),
('GEN06', 'Novela Hist�rica'   , 'Narrativas que tienen lugar en un per�odo hist�rico.'),
('GEN07', 'Ciencia Ficci�n'    , 'Narrativas que se basan en conceptos cient�ficos imaginarios o futuristas.'),
('GEN08', 'Poes�a'             , 'Composiciones literarias que siguen una estructura m�trica o r�tmica.'),
('GEN09', 'Drama'              , 'Narrativas destinadas a representaciones teatrales o televisivas que involucran conflictos y emociones.'),
('GEN10', 'Aventura'           , 'Historias emocionantes que implican viajes o haza�as.'),
('GEN11', 'Cl�sico'            , 'Obras literarias que han sido consideradas como ejemplos sobresalientes de la literatura a trav�s del tiempo.'),
('GEN12', 'Biograf�a'          , 'Narrativas que cuentan la historia de la vida de una persona escritas por otra persona.'),
('GEN13', 'Ensayo'             , 'Textos escritos que presentan argumentos o puntos de vista sobre un tema particular.'),
('GEN14', 'Fantas�a'           , 'Narrativas que incluyen elementos imaginarios o sobrenaturales.'),
('GEN15', 'Humor'              , 'Narrativas destinadas a hacer re�r al lector o espectador.'),
('GEN16', 'Suspense'           , 'Narrativas que mantienen al lector en tensi�n o incertidumbre sobre lo que suceder� a continuaci�n.'),
('GEN17', 'Autobiograf�a'      , 'Narrativas escritas por la propia persona sobre su propia vida.'),
('GEN18', 'Cr�nica'            , 'Narrativas que cuentan eventos de manera cronol�gica y detallada.'),
('GEN19', 'Historia'           , 'Narrativas que describen eventos pasados y sucesos.'),
('GEN20', 'Narrativa de Viajes', 'Narrativas que relatan las experiencias de viajes y exploraciones.');

SELECT * FROM Generos
 GO

--INSERTAR REGISTROS A LA TABLA lIBROS --Inserci�n
INSERT INTO Libros (idLibro, Titulo, ISBN, fecha_Publicaci�n, idAutor, idGenero) VALUES
('L0001', 'Cien a�os de soledad', '978-0307474728', '1967-05-30', '000001', 'GEN01'),
('L0002', 'Harry Potter y la piedra filosofal', '978-8478884453', '1997-06-26', '000002', 'GEN01'),
('L0003', 'It', '978-1501175466', '1986-09-15', '000003', 'GEN05'),
('L0004', 'La casa de los esp�ritus', '978-0679723252', '1982-04-12', '000004', 'GEN01'),
('L0005', 'Norwegian Wood', '978-0375704024', '1987-09-01', '000005', 'GEN01'),
('L0006', 'La ciudad y los perros', '978-8426402954', '1963-01-01', '000006', 'GEN01'),
('L0007', 'Asesinato en el Orient Express', '978-0008195090', '1934-01-01', '000007', 'GEN02'),
('L0008', 'Orgullo y prejuicio', '978-0141439518', '1813-01-28', '000008', 'GEN11'),
('L0009', '1984', '978-0141036144', '1949-06-08', '000009', 'GEN01'),
('L0010', 'Los miserables', '978-0140444308', '1862-01-01', '000010', 'GEN11'),
('L0011', 'La odisea', '978-0140268867', '0001-01-01', '000011', 'GEN01'),
('L0012', 'La divina comedia', '978-0142437223', '1300-01-01', '000012', 'GEN01'),
('L0013', 'La casa de Bernarda Alba', '978-8497404286', '1936-01-01', '000015', 'GEN09'),
('L0014', 'Orgullo y prejuicio', '978-0141439518', '1813-01-28', '000008', 'GEN11'),
('L0015', 'Crimen y castigo', '978-0143107637', '1866-01-01', '000019', 'GEN01'),
('L0016', '1984', '978-0141036144', '1949-06-08', '000009', 'GEN01'),
('L0017', 'El principito', '978-0156013925', '1943-04-06', '000016', 'GEN01'),
('L0018', 'Rayuela', '978-8437604947', '1963-01-01', '000017', 'GEN01'),
('L0019', 'La metamorfosis', '978-8499894853', '1915-01-01', '000018', 'GEN01'),
('L0020', 'Cien a�os de soledad', '978-0307474728', '1967-05-30', '000001', 'GEN01'),
('L0021', 'Harry Potter y la piedra filosofal', '978-8478884453', '1997-06-26', '000002', 'GEN01'),
('L0022', 'It', '978-1501175466', '1986-09-15', '000003', 'GEN05'),
('L0023', 'La casa de los esp�ritus', '978-0679723252', '1982-04-12', '000004', 'GEN01'),
('L0024', 'Norwegian Wood', '978-0375704024', '1987-09-01', '000005', 'GEN01'),
('L0025', 'La ciudad y los perros', '978-8426402954', '1963-01-01', '000006', 'GEN01'),
('L0026', 'Asesinato en el Orient Express', '978-0008195090', '1934-01-01', '000007', 'GEN02'),
('L0027', 'Orgullo y prejuicio', '978-0141439518', '1813-01-28', '000008', 'GEN11'),
('L0028', '1984', '978-0141036144', '1949-06-08', '000009', 'GEN01'),
('L0029', 'Los miserables', '978-0140444308', '1862-01-01', '000010', 'GEN11'),
('L0030', 'Don Quijote de la Mancha', '978-8467035260', '1605-01-16', '000014', 'GEN11'),
('L0031', 'Cien a�os de soledad', '978-0307474728', '1967-05-30', '000001', 'GEN01'),
('L0032', 'Harry Potter y la piedra filosofal', '978-8478884453', '1997-06-26', '000002', 'GEN01'),
('L0033', 'It', '978-1501175466', '1986-09-15', '000003', 'GEN05'),
('L0034', 'La casa de los esp�ritus', '978-0679723252', '1982-04-12', '000004', 'GEN01'),
('L0035', 'Norwegian Wood', '978-0375704024', '1987-09-01', '000005', 'GEN01'),
('L0036', 'La ciudad y los perros', '978-8426402954', '1963-01-01', '000006', 'GEN01'),
('L0037', 'Asesinato en el Orient Express', '978-0008195090', '1934-01-01', '000007', 'GEN02'),
('L0038', 'Orgullo y prejuicio', '978-0141439518', '1813-01-28', '000008', 'GEN11'),
('L0039', '1984', '978-0141036144', '1949-06-08', '000009', 'GEN01'),
('L0040', 'Los miserables', '978-0140444308', '1862-01-01', '000010', 'GEN11'),
('L0041', 'Don Quijote de la Mancha', '978-8467035260', '1605-01-16', '000014', 'GEN11'),
('L0042', 'La odisea', '978-0140268867', '0001-01-01', '000011', 'GEN01'),
('L0043', 'La divina comedia', '978-0142437223', '1300-01-01', '000012', 'GEN01'),
('L0044', 'La casa de Bernarda Alba', '978-8497404286', '1936-01-01', '000015', 'GEN09'),
('L0045', 'Orgullo y prejuicio', '978-0141439518', '1813-01-28', '000008', 'GEN11'),
('L0046', 'Crimen y castigo', '978-0143107637', '1866-01-01', '000019', 'GEN01'),
('L0047', '1984', '978-0141036144', '1949-06-08', '000009', 'GEN01'),
('L0048', 'El principito', '978-0156013925', '1943-04-06', '000016', 'GEN01'),
('L0049', 'Rayuela', '978-8437604947', '1963-01-01', '000017', 'GEN01'),
('L0050', 'La metamorfosis', '978-8499894853', '1915-01-01', '000018', 'GEN01'),
('L0051', 'Cien a�os de soledad', '978-0307474728', '1967-05-30', '000001', 'GEN01'),
('L0052', 'Harry Potter y la piedra filosofal', '978-8478884453', '1997-06-26', '000002', 'GEN01'),
('L0053', 'It', '978-1501175466', '1986-09-15', '000003', 'GEN05'),
('L0054', 'La casa de los esp�ritus', '978-0679723252', '1982-04-12', '000004', 'GEN01'),
('L0055', 'Norwegian Wood', '978-0375704024', '1987-09-01', '000005', 'GEN01'),
('L0056', 'La ciudad y los perros', '978-8426402954', '1963-01-01', '000006', 'GEN01'),
('L0057', 'Asesinato en el Orient Express', '978-0008195090', '1934-01-01', '000007', 'GEN02'),
('L0058', 'Orgullo y prejuicio', '978-0141439518', '1813-01-28', '000008', 'GEN11'),
('L0059', '1984', '978-0141036144', '1949-06-08', '000009', 'GEN01'),
('L0060', 'Los miserables', '978-0140444308', '1862-01-01', '000010', 'GEN11'),
('L0061', 'Don Quijote de la Mancha', '978-8467035260', '1605-01-16', '000014', 'GEN11'),
('L0062', 'La odisea', '978-0140268867', '0001-01-01', '000011', 'GEN01'),
('L0063', 'La divina comedia', '978-0142437223', '1300-01-01', '000012', 'GEN01'),
('L0064', 'La casa de Bernarda Alba', '978-8497404286', '1936-01-01', '000015', 'GEN09'),
('L0065', 'El amor en los tiempos del c�lera', '978-1400034685', '1985-01-01', '000001', 'GEN01'),
('L0066', 'Un mundo feliz', '978-6073140243', '1932-01-01', '000032', 'GEN01'),
('L0067', 'Las uvas de la ira', '978-0141185064', '1939-04-14', '000034', 'GEN01'),
('L0068', 'El amor en los tiempos del c�lera', '978-1400034685', '1985-01-01', '000001', 'GEN01'),
('L0069', 'Cr�nica de una muerte anunciada', '978-6073141189', '1981-01-01', '000001', 'GEN01'),
('L0070', 'Los detectives salvajes', '978-9706990695', '1998-01-01', '000001', 'GEN01');

SELECT * FROM Libros
 GO

--INSERTAR REGISTROS A LA TABLA ADMINISTRATIVO --Inserci�n

INSERT INTO Administrativos
(idAdministrativo, NombreAdmin, ApellidoAdmin       , Cargo) VALUES
('01234567',         'Ana'    , 'Garc�a Mart�nez'   , 'Coordinadora de Biblioteca'),
('12345678',         'Juan'   , 'Mart�nez L�pez'    , 'Bibliotecario'),
('34567890',         'Pedro'  , 'S�nchez Rodr�guez' , 'Auxiliar de Biblioteca'),
('45678901',         'Laura'  , 'Rodr�guez P�rez'   , 'Asistente Administrativo'),
('01234561',         'Marcos' , 'G�mez Hern�ndez'   , 'T�cnico de Sistemas');

SELECT * FROM Administrativos
 GO

--INSERTAR REGISTROS A LA TABLA ESTUDIANTE --Inserci�n

INSERT INTO Estudiantes 
(idEstudiantes, NombreEst  , ApellidoEst   , Sexo_Est, Edad_Est, Carrera             , Direccion                 , Telefono) VALUES
('34567890'   , 'Ana'      , 'Mart�nez'    , 'F'     , '19'    , 'Psicolog�a'          , 'Avenida Central'         , '111222333'),
('45678901'   , 'Carlos'   , 'G�mez'       , 'M'     , '23'    , 'Derecho'             , 'Calle Principal'         , '444555666'),
('56789012'   , 'Laura'    , 'Rodr�guez'   , 'F'     , '20'    , 'Arquitectura'        , 'Plaza Mayor'             , '777888999'),
('67890123'   , 'David'    , 'Fern�ndez'   , 'M'     , '21'    , 'Biolog�a'            , 'Paseo del Bosque'        , '333222111'),
('78901234'   , 'Sof�a'    , 'Gonz�lez'    , 'F'     , '22'    , 'Econom�a'            , 'Avenida del Sol'         , '666777888'),
('89012345'   , 'Javier'   , 'Ruiz'        , 'M'     , '20'    , 'Ingenier�a Civil'    , 'Callej�n Estrecho'       , '999888777'),
('90123456'   , 'Elena'    , 'Hern�ndez'   , 'F'     , '21'    , 'Medicina'            , 'Carrera 123'             , '222333444'),
('01234567'   , 'Diego'    , 'S�nchez'     , 'M'     , '22'    , 'Historia'            , 'Calle de los Libros'     , '777666555'),
('11223344'   , 'Paula'    , 'P�rez'       , 'F'     , '23'    , 'Filosof�a'           , 'Camino Antiguo'          , '888999000'),
('22334455'   , 'Alejandro', 'Mart�n'      , 'M'     , '20'    , 'Ciencias Pol�ticas'  , 'Avenida Libertad'        , '111000999'),
('33445566'   , 'Luc�a'    , 'D�az'        , 'F'     , '21'    , 'Qu�mica'             , 'Callej�n Sin Salida'     , '444333222'),
('44556677'   , 'Miguel'   , 'L�pez'       , 'M'     , '22'    , 'Marketing'           , 'Avenida de los �rboles'  , '555666777'),
('55667788'   , 'Isabel'   , 'Garc�a'      , 'F'     , '20'    , 'F�sica'              , 'Plaza de la Constituci�n', '666777888'),
('66778899'   , 'Marcos'   , 'Fern�ndez'   , 'M'     , '21'    , 'Geograf�a'           , 'Calle de la Monta�a'     , '999888777'),
('77889900'   , 'Carmen'   , 'Ruiz'        , 'F'     , '22'    , 'Educaci�n'           , 'Paseo del R�o'           , '333444555'),
('88990011'   , 'Adri�n'   , 'Gonz�lez'    , 'M'     , '20'    , 'Literatura'          , 'Calle de las Flores'     , '777888999'),
('99001122'   , 'Natalia'  , 'S�nchez'     , 'F'     , '21'    , 'Sociolog�a'          , 'Avenida del Mar'         , '222333444'),
('00112233'   , 'Sergio'   , 'P�rez'       , 'M'     , '22'    , 'Estad�stica'         , 'Calle Mayor'             , '888999000'),
('00223344'   , 'Andrea'   , 'Mart�nez'    , 'F'     , '20'    , 'Inform�tica'         , 'Avenida Nueva'           , '111000999'),
('00334455'   , 'Jorge'    , 'L�pez'       , 'M'     , '21'    , 'Ingenier�a El�ctrica', 'Calle del Bosque'        , '444333222'),
('10445566'   , 'Marcela'  , 'Gutierrez'   , 'F'     , '20'    , 'Psicolog�a'          , 'Calle del Sol'           , '123456789'),
('20556677'   , 'Ricardo'  , 'Hern�ndez'   , 'M'     , '21'    , 'Derecho'             , 'Avenida de la Paz'       , '234567890'),
('30667788'   , 'Patricia' , 'Torres'      , 'F'     , '22'    , 'Arquitectura'        , 'Carrera 456'             , '345678901'),
('40778899'   , 'Fernando' , 'Santos'      , 'M'     , '20'    , 'Biolog�a'            , 'Avenida del Bosque'      , '456789012'),
('50889900'   , 'Valentina', 'Ram�rez'     , 'F'     , '21'    , 'Econom�a'            , 'Calle Principal'         , '567890123'),
('60990011'   , 'Gabriel'  , 'Mart�nez'    , 'M'     , '22'    , 'Ingenier�a Civil'    , 'Plaza Mayor'             , '678901234'),
('71001122'   , 'Carolina' , 'S�nchez'     , 'F'     , '20'    , 'Medicina'            , 'Calle de la Luna'        , '789012345'),
('81112233'   , 'Emilio'   , 'G�mez'       , 'M'     , '21'    , 'Historia'            , 'Avenida del Mar'         , '890123456'),
('91223344'   , 'Diana'    , 'Alvarez'     , 'F'     , '22'    , 'Filosof�a'           , 'Paseo del Sol'           , '901234567'),
('01334455'   , 'Luis'     , 'Vargas'      , 'M'     , '20'    , 'Ciencias Pol�ticas'  , 'Avenida Central'         , '012345678'),
('11445566'   , 'Victoria' , 'Luna'        , 'F'     , '21'    , 'Qu�mica'             , 'Carrera 789'             , '123456789'),
('21556677'   , 'Mart�n'   , 'G�mez'       , 'M'     , '22'    , 'Marketing'           , 'Calle de los Pinos'      , '234567890'),
('31667788'   , 'Juliana'  , 'D�az'        , 'F'     , '20'    , 'F�sica'              , 'Avenida del Estadio'     , '345678901'),
('41778899'   , 'Sebasti�n', 'P�rez'       , 'M'     , '21'    , 'Geograf�a'           , 'Camino Real'             , '456789012'),
('51889900'   , 'Laura'    , 'Ramirez'     , 'F'     , '22'    , 'Educaci�n'           , 'Calle de la Monta�a'     , '567890123');

SELECT * FROM Estudiantes
 GO

--INSERTAR REGISTROS A LA TABLA TIPODEPRESTAMOS --Inserci�n

INSERT INTO TipoPrestamo  VALUES
('D001', 'Digital'),
('F002', 'F�sico');

SELECT * FROM TipoPrestamo
GO

--INSERTAR REGISTROS A LA TABLA PRESTAMOS --Inserci�n

INSERT INTO Prestamos (idPrestamo, FechaPrestamo, FechaDevolucion, idLibro, idEstudiantes, idAdministrativo, idTipoPrestamo)
VALUES
    ('P00016', '2024-04-18', '2024-04-28', 'L0008', '34567890', '12345678', 'D001'),
    ('P00017', '2024-04-17', '2024-04-27', 'L0009', '51889900', '12345678', 'F002'),
    ('P00018', '2024-04-16', '2024-04-26', 'L0010', '31667788', '12345678', 'D001'),
    ('P00019', '2024-04-15', '2024-04-25', 'L0011', '56789012', '12345678', 'F002'),
    ('P00020', '2024-04-14', '2024-04-24', 'L0012', '78901234', '12345678', 'D001'),
    ('P00021', '2024-04-13', '2024-04-23', 'L0013', '21556677', '12345678', 'F002'),
    ('P00022', '2024-04-12', '2024-04-22', 'L0014', '11445566', '12345678', 'D001'),
    ('P00023', '2024-04-11', '2024-04-21', 'L0015', '01334455', '12345678', 'F002'),
    ('P00024', '2024-04-10', '2024-04-20', 'L0016', '91223344', '12345678', 'D001'),
    ('P00025', '2024-04-09', '2024-04-19', 'L0017', '60990011', '12345678', 'F002'),
    ('P00026', '2024-04-08', '2024-04-18', 'L0018', '30667788', '12345678', 'D001'),
    ('P00027', '2024-04-07', '2024-04-17', 'L0019', '99001122', '12345678', 'F002'),
    ('P00028', '2024-04-06', '2024-04-16', 'L0020', '77889900', '12345678', 'D001'),
    ('P00029', '2024-04-05', '2024-04-15', 'L0021', '00112233', '12345678', 'F002'),
    ('P00030', '2024-04-04', '2024-04-14', 'L0022', '22334455', '12345678', 'D001'),
	('P00031', '2024-04-03', '2024-04-13', 'L0023', '00223344', '12345678', 'D001'),
    ('P00032', '2024-04-02', '2024-04-12', 'L0024', '33445566', '12345678', 'F002'),
    ('P00033', '2024-04-01', '2024-04-11', 'L0025', '30667788', '12345678', 'D001'),
    ('P00034', '2024-03-31', '2024-04-10', 'L0026', '40778899', '12345678', 'F002'),
    ('P00035', '2024-03-30', '2024-04-09', 'L0027', '30667788', '12345678', 'D001'),
    ('P00036', '2024-03-29', '2024-04-08', 'L0028', '44556677', '34567890', 'F002'),
    ('P00037', '2024-03-28', '2024-04-07', 'L0029', '01234567', '34567890', 'D001'),
    ('P00038', '2024-03-27', '2024-04-06', 'L0030', '90123456', '34567890', 'F002'),
    ('P00039', '2024-03-26', '2024-04-05', 'L0031', '71001122', '34567890', 'D001'),
    ('P00040', '2024-03-25', '2024-04-04', 'L0032', '81112233', '34567890', 'F002');

SELECT * FROM  Prestamos
GO



--VERIFICAR LAS RESTICCIONES DE LA TABLA ...
SP_HELPCONSTRAINT ADMINISTRATIVOS 
GO

--@@@@@@@@@@@@@@@@@@@TRATAMIENTO DE DATOS DATOS@@@@@@@@@@@@@@@@@@@@@@@@


--@@@@@@@@@@@@@@@@@@@Creaci�n de vistas que cumplen una tarea distinta - m�nimo 3 tablas@@@@@@@@@@@@@@@@@@@@@@@@
CREATE VIEW Vista_Autores_Libros_Generos AS
SELECT 
    A.NombreAutor, A.ApellidoAutor, L.Titulo, G.NombreGenero
FROM 
    Autores A
JOIN 
    Libros L ON A.idAutor = L.idAutor
JOIN 
    Generos G ON L.idGenero = G.idGenero;


go

CREATE VIEW Vista_Prestamos_Detalles AS
SELECT 
    P.idPrestamo, P.FechaPrestamo, P.FechaDevolucion, 
    E.NombreEst AS NombreEstudiante, E.ApellidoEst AS ApellidoEstudiante,
    A.NombreAdmin AS NombreAdministrativo, A.ApellidoAdmin AS ApellidoAdministrativo
FROM 
    Prestamos P
JOIN 
    Estudiantes E ON P.idEstudiantes = E.idEstudiantes
JOIN 
    Administrativos A ON P.idAdministrativo = A.idAdministrativo;
go

CREATE VIEW Vista_Libros_Prestados_Genero AS
SELECT 
    L.Titulo, L.ISBN, G.NombreGenero
FROM 
    Libros L
JOIN 
    Generos G ON L.idGenero = G.idGenero
WHERE 
    EXISTS (
        SELECT 1 
        FROM Prestamos P 
        WHERE P.idLibro = L.idLibro
    );
go

CREATE VIEW Vista_Detalles_Estudiantes_Prestamos AS
SELECT 
    E.idEstudiantes, E.NombreEst, E.ApellidoEst, 
    COUNT(P.idPrestamo) AS TotalPrestamos
FROM 
    Estudiantes E
LEFT JOIN 
    Prestamos P ON E.idEstudiantes = P.idEstudiantes
GROUP BY 
    E.idEstudiantes, E.NombreEst, E.ApellidoEst;

go

CREATE VIEW Vista_Detalles_Libros_Prestamo AS
SELECT 
    L.idLibro, L.Titulo, L.ISBN,
    CASE
        WHEN P.idPrestamo IS NOT NULL THEN 'Prestado'
        ELSE 'Disponible'
    END AS EstadoPrestamo
FROM 
    Libros L
LEFT JOIN 
    Prestamos P ON L.idLibro = P.idLibro;
go



--@@@@@@@@@@@@@@@@@@@Creaci�n de procedimientos almacenados que involucran tablas y @@@@@@@@@@@@@@@@@@@@@@@@
--@@@@@@@@@@@@@@@@@@@par�metros de entrada, b�squedas, inserciones, eliminaciones o actualizaciones@@@@@@@@@@@@@@@@@@@@@@@@

--el campo idPrestamos de la tabla prestamo debe comnenzar con la letra P
ALTER TABLE Prestamos
ADD CONSTRAINT CHK_IDPRESTAMO
CHECK (idPrestamo LIKE 'P[0-9][0-9][0-9][0-9][0-9]')
go
--el campo idlibro de la tabla prestamo debe comnenzar con la letra L
ALTER TABLE libros
ADD CONSTRAINT CHK_IDLIBRO
CHECK (idlibro LIKE 'L[0-9][0-9][0-9][0-9]')
go

--de la seccion fecha prestamos dia, mes del prestamo (FECHA PRESTAMO, ALUMNO, LIBRO)
SELECT f.FechaPrestamo, DAY(f.FechaPrestamo) AS 'num dia', 
                        MONTH(f.FechaPrestamo) AS 'num mes', l.Titulo, e.NombreEst, e.ApellidoEst
FROM prestamos f
INNER JOIN libros l ON f.IDLibro = l.IDLibro
INNER JOIN Estudiantes e ON f.IDEstudiantes = e.IDEstudiantes
WHERE f.FechaPrestamo >= '2024-04-14' AND f.FechaPrestamo <= '2024-04-18';
go

--estructura condicional (VERIFICAR SI EXISTE EL LIBRO)
if object_id ('verificar_libro') is not null 
drop proc verificar_libro
go 

create proc verificar_libro @titulo varchar (200)
as
if exists (select *from Libros where titulo = @titulo)
  begin
    select * from Libros where titulo = @titulo
  end
  else
  begin
    print 'no existe el libro ingresado'
  end
go
--ejecutando
execute verificar_libro 'la odisea'
go


-- para verificar prestamos de libros a travez del genero 
SELECT p.idPrestamo, p.FechaPrestamo, p.FechaDevolucion, p.idLibro, p.idEstudiantes, p.idAdministrativo, p.idTipoPrestamo
FROM Prestamos p
INNER JOIN Libros l ON p.idLibro = l.idLibro
WHERE MONTH(p.FechaPrestamo) = 4
AND l.idGenero = 'gen05';

-- libros disponibles y prestados (libros - prestamos)
SELECT 
    L.idLibro,L.Titulo,
    CASE 
        WHEN P.idPrestamo IS NOT NULL THEN 'Prestado'
        ELSE 'Disponible'
    END AS Estado
FROM 
    Libros L
LEFT JOIN 
    Prestamos P ON L.idLibro = P.idLibro;

--libros prestados por administrativos (prestamos - adminiistrativos)
SELECT 
    P.idPrestamo, P.FechaPrestamo, P.idEstudiantes, P.idAdministrativo, A.NombreAdmin, A.ApellidoAdmin
FROM 
    Prestamos P
INNER JOIN 
    Administrativos A ON P.idAdministrativo = A.idAdministrativo;

--lista de libros para prestar (libros - prestamos)
SELECT 
    L.Titulo
FROM 
    Libros L
LEFT JOIN 
    Prestamos P ON L.idLibro = P.idLibro
WHERE 
    P.idLibro IS NULL;



--@@@@@@@@@@@@@@@@@@@CONCATENANDO@@@@@@@@@@@@@@@@@@@@@@@@@


--UTILIZANDO LA FUNCI�N DATEDIFF
select p.fechaPrestamo, DATEDIFF (DD, p.fechaPrestamo, GETDATE ())'Diferencia de dias' from Prestamos p
go

--UTILIZANDO LA FUNCI�N DATEPART
select p.fechaprestamo, cast (DATEPART (dd, p.fechaPrestamo) as varchar(3)) +'/' + cast (DATEPART (mm, p.FechaPrestamo) as varchar(3)) 
as fecha_prestamo
from prestamos p
go

--UTILIZANDO LA FUNCI�N CONVERT

SELECT p.fechadevolucion, CONVERT(VARCHAR(2),DATEPART(DD , p.fechadevolucion)) +'/' + 
CONVERT(VARCHAR(2),DATEPART(MM , p.fechadevolucion)) as fecha_delolucion 
FROM Prestamos p
go

SELECT * FROM Prestamos p
WHERE 
  month (FechaPrestamo) = 04;
  go



--@@@@@@@@@@@@@@@@@@@Creaci�n de procedimientos almacenados para implementar las reglas del negocio.@@@@@@@@@@@@@@@@@@@@@@@@

--insertar administrativo
CREATE PROCEDURE InsertarAdministrativos
    @idAdministrativo CHAR(8),
    @NombreAdmin VARCHAR(50),
    @ApellidoAdmin VARCHAR(50),
    @Cargo VARCHAR(50)
AS
BEGIN
    INSERT INTO Administrativos (idAdministrativo, NombreAdmin, ApellidoAdmin, Cargo)
    VALUES (@idAdministrativo, @NombreAdmin, @ApellidoAdmin, @Cargo)
END
go
  --ejecutando
 EXEC InsertarAdministrativos
    @idAdministrativo = '71501462',
    @NombreAdmin = 'Teylor',
    @ApellidoAdmin = 'Perez',
    @Cargo = 'jefe de area';
go


--insertar autor
CREATE PROCEDURE InsertarAutor
    @idAutor CHAR(6),
    @NombreAutor VARCHAR(50),
    @ApellidoAutor VARCHAR(50),
    @Nacionalidad VARCHAR(50)
AS
BEGIN
    INSERT INTO Autores (idAutor, NombreAutor, ApellidoAutor, Nacionalidad)
    VALUES (@idAutor, @NombreAutor, @ApellidoAutor, @Nacionalidad)
END
go
EXEC InsertarAutor
    @idAutor = '000035',
    @NombreAutor = 'Juan',
    @ApellidoAutor = 'Garc�a Marquez',
    @Nacionalidad = 'Colombiano';

go 

--actualizando autor
CREATE PROCEDURE actualizarAutor
    @idAutor CHAR(6),
    @NombreAutor VARCHAR(50),
    @ApellidoAutor VARCHAR(50),
    @Nacionalidad VARCHAR(50)
AS
BEGIN
    update Autores  set  NombreAutor= @NombreAutor, ApellidoAutor= @ApellidoAutor, Nacionalidad=@Nacionalidad
    where idAutor=@idAutor
END
go

EXECUTE actualizarAutor '000035' , 'juan' ,
'Garc�a Marquez', 'peruano' 
GO

--eliminar autor
CREATE PROCEDURE eliminararAutor
    @idAutor CHAR(6)
AS
BEGIN
    delete from Autores  where  idAutor= @idAutor
END
go
--Ejecutando procedimientos almacenados
select * from Autores WHERE idAutor = '000035'
go
--eliminando
execute eliminararAutor '000035'
go


--verificando libro
if object_id ('verificar_libro') is not null 
drop proc verificar_libro
go 

create proc verificar_libro @titulo varchar (200)
as
if exists (select *from Libros where titulo = @titulo)
  begin
    select * from Libros where titulo = @titulo
  end
  else
  begin
    print 'no existe el libro ingresado'
  end
go
--ejecutando
execute verificar_libro 'la odisea'
go

--generar informes estadisticos
CREATE PROCEDURE GenerarInformeEstadisticoPrestamos
AS
BEGIN
    SELECT 
        G.NombreGenero, 
        COUNT(L.idLibro) AS TotalLibrosPrestados
    FROM 
        Libros L
    INNER JOIN 
        Generos G ON L.idGenero = G.idGenero
    INNER JOIN 
        Prestamos P ON L.idLibro = P.idLibro
    GROUP BY 
        G.NombreGenero;
END;
go


--ejecutando



--@@@@@@@@@@@@@@@@@@@ verificando comandos@@@@@@@@@@@@@@@@@@@@@@@@
SELECT * FROM Prestamos
ORDER BY FechaDevolucion desc
GO

SELECT * FROM Estudiantes 
WHERE idEstudiantes = '34567890';
go 

SELECT * FROM Estudiantes
WHERE idEstudiantes IN (
    SELECT idEstudiantes
    FROM Prestamos
    WHERE FechaPrestamo BETWEEN '2024-04-01' AND '2024-04-05'
);
go

SELECT * FROM Prestamos
WHERE FechaPrestamo BETWEEN '2024-04-01' AND '2024-04-03';
go

SELECT * from estudiantes
WHERE Edad_Est BETWEEN 18 AND 25
ORDER BY Edad_Est desc;
go

SELECT TOP 8 * FROM Prestamos
ORDER BY 3 ASC
GO

SELECT * FROM Prestamos
WHERE FechaPrestamo LIKE '2%'
GO

SELECT *
FROM Estudiantes
WHERE NombreEst LIKE 'd%' AND ApellidoEst LIKE 's%'
go

--alias

select * from Prestamos p
where p.FechaPrestamo between '2024-04-13' AND '2024-04-18'
go


--de la seccion fecha prestamos dia, mes del prestamo
select f.FechaPrestamo, day(f.fechaPrestamo)'num dia',
                        MONTH (f.fechaPrestamo) 'num mes'
from  prestamos f
go

select f.FechaPrestamo, day(f.fechaPrestamo)'num dia',
                        MONTH (f.fechaPrestamo) 'num mes'
from  prestamos f
WHERE f.FechaPrestamo >= '2024-04-14' AND f.FechaPrestamo <= '2024-04-18';
go

-- Consulta para listar las tablas creadas en la base de datos
SELECT * FROM INFORMATION_SCHEMA.TABLES;
GO

-- Consulta para listar las columnas de la tabla Prestamos
EXEC sp_columns Prestamos;
GO


--alterando la tabla alumnos 

ALTER TABLE estudiantes
ADD correo VARCHAR(100) DEFAULT 'correo@ejemplo.com';
go

alter table administrativos
add constraint uni_idAdmin
unique (idAdministrativo)
go


 --buscando el nombre de la restriccion
SELECT name
FROM sys.default_constraints
WHERE parent_object_id = OBJECT_ID('estudiantes')
AND type_desc = 'DEFAULT_CONSTRAINT'
AND parent_column_id = (
    SELECT column_id
    FROM sys.columns
    WHERE object_id = OBJECT_ID('estudiantes')
    AND name = 'correo'
);
go

SELECT name
FROM sys.indexes
WHERE object_id = OBJECT_ID('administrativos')
AND is_unique_constraint = 1
AND name LIKE 'uni_idAdmin%';
go

-- Encuentra el nombre de la restricci�n predeterminada en la tabla estudiantes
DECLARE @constraintName nvarchar(200);
SELECT @constraintName = name
FROM sys.default_constraints
WHERE parent_object_id = OBJECT_ID('estudiantes')
AND type = 'D'
AND parent_column_id = (
    SELECT column_id
    FROM sys.columns
    WHERE object_id = OBJECT_ID('estudiantes')
    AND name = 'correo'
);

-- Si se encontr� la restricci�n, elim�nala
IF @constraintName IS NOT NULL
BEGIN
    EXEC('ALTER TABLE estudiantes DROP CONSTRAINT ' + @constraintName);
END;
go

--eliminando la restriccion

select * from Administrativos
go


