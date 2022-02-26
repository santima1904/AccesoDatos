CREATE DATABASE MartinezAral
GO

USE MartinezAral
GO

--DBCC CHECKIDENT(Cliente, NORESEED) 
--GO

CREATE TABLE UsuarioGestor (
	Id smallint IDENTITY CONSTRAINT PK_Usuario Primary key
	, nombre nvarchar(30) not null
	, dni nvarchar(9) not null
	, codigoPostal nvarchar(5) null
	, ciudad nvarchar(50) null
	, telefono nvarchar(9) null
	, correo nvarchar(30) null
	, usuario nvarchar(15) not null
	, contrasenha nvarchar(15) not null
)
GO

CREATE TABLE UsuarioVendedor (
	Id smallint IDENTITY CONSTRAINT PK_UsuarioVendedor Primary key
	, nombre nvarchar(30) not null
	, dni nvarchar(9) not null
	, codigoPostal nvarchar(5) null
	, ciudad nvarchar(50) null
	, telefono nvarchar(9) null
	, correo nvarchar(30) null
	, usuario nvarchar(15) not null
	, contrasenha nvarchar(15) not null
)
GO

CREATE TABLE Cliente (
	Id smallint IDENTITY CONSTRAINT PK_Cliente Primary key
	, nombre nvarchar(30) not null
	, dni nvarchar(9) not null
	, codigoPostal nvarchar(5) null
	, ciudad nvarchar(50) null
	, telefono nvarchar(9) null
	, correo nvarchar(30) null
)
GO

CREATE TABLE Producto (
	codigo smallint CONSTRAINT PK_Producto Primary key
	, descripcion nvarchar(300) null
	, precioUnitario float not null
	, unidades int not null
)
GO

CREATE TABLE ProductoJardineria (
	codigo smallint CONSTRAINT PK_ProductoJardineria Primary key
	, CONSTRAINT FK_Producto1 Foreign key (codigo) REFERENCES Producto(codigo) ON UPDATE NO ACTION ON DELETE NO ACTION
)
GO

CREATE TABLE TipoPlanta (
	Id smallint IDENTITY CONSTRAINT PK_TipoPlanta Primary key
	, nombre nvarchar(30) not null
)
GO

CREATE TABLE ProductoPlanta (
	codigo smallint CONSTRAINT PK_ProductoPlanta Primary key
	, idTipoPlanta smallint not null
	, CONSTRAINT FK_Producto2 Foreign key (codigo) REFERENCES Producto(codigo) ON UPDATE NO ACTION ON DELETE NO ACTION
	, CONSTRAINT FK_TipoPlanta Foreign key (idTipoPlanta) REFERENCES TipoPlanta(Id) ON UPDATE NO ACTION ON DELETE NO ACTION 
)
GO

CREATE TABLE Factura (
	Id smallint IDENTITY CONSTRAINT PK_Factura Primary key
	, fecha datetime not null
	, importe float not null
	, idVendedor smallint not null CONSTRAINT FK_UsuarioVendedor Foreign key REFERENCES UsuarioVendedor(Id) ON UPDATE NO ACTION ON DELETE NO ACTION
	, idCliente smallint not null CONSTRAINT FK_Cliente Foreign key REFERENCES Cliente(Id) ON UPDATE NO ACTION ON DELETE NO ACTION
)
GO

CREATE TABLE ProductoFactura (
	IdFactura smallint not null CONSTRAINT FK_Factura Foreign key REFERENCES Factura(Id) ON UPDATE NO ACTION ON DELETE NO ACTION
	, codigoProducto smallint not null CONSTRAINT FK_ProductoFactura Foreign key REFERENCES Producto(codigo) ON UPDATE NO ACTION ON DELETE NO ACTION
	, cantidad int not null
	, precio float not null
	, CONSTRAINT PK_ProductoFactura Primary key (IdFactura, codigoProducto)
)
GO

--Insercción de datos
INSERT INTO Producto (codigo, descripcion, precioUnitario, unidades)
VALUES 
  (1,'Abono especial para plantas 100% natural', 27, 8)
, (2, 'Herrramienta perfecta para trabajar la tierra', 14, 5)
, (3,'Maceta de flores en un diseño simple para uso en interiores y exteriores', 16, 24)
, (4, 'Podadera a dos manos de piñones hook y hojas cubiertas con PTFE', 50, 10)
, (5, 'Tijera para podar especialmente indicada para jardines o terrazas con la facilidad de usarla solo con una mano', 9, 25)
, (6, 'Palita recogedor a una mano en metal de 46,5 x 14 cm. con mango de madera. Uso: para recoger o cenizas', 7, 30)
, (7, 'El ficus es una planta que añade mucha naturaleza a tu casa gracia a sus hojas puntiagudas', 40, 3)
, (8, 'La Areca es de esas plantas resistentes que exigen poca atención, perfecta para principiantes que buscan una compañera de piso fácil de cuidar', 32, 6)
, (9,'El Cupressus Goldcrest es uno de los arbustos más utilizados para decorar entradas y como elementos ornamentales de topiaria', 124,2)
, (10, 'La Monstera Deliciosa es perfecta para dar un toque de jungla a tu hogar', 23, 8)
, (11, 'La Mimosa es uno de los árboles ornamentales más habituales de ver. Se trata en realidad de un arbusto, aunque puede llegar a alcanzar alturas de hasta 8 metros', 60, 9)
, (12, 'Sauce plateado se cree que este árbol caduco tiene su origen en Rusia. Alcanza alturas de más de 12 metros en las condiciones adecuadas', 55, 9)
, (13, 'El almendro se engalana con una magnifica floración blanca a finales del invierno', 47, 11)
, (14, 'El Limonero tiene su origen en Asia desde hace más de dos mil años. Es una planta de exterior cada vez más popular y, además, muy fácil de cuidar', 57, 10)
GO

INSERT INTO TipoPlanta (nombre)
VALUES
  ('interior')
, ('exterior')
, ('árboles ornamentales')
, ('árboles frutales')
GO

INSERT INTO ProductoJardineria (codigo)
VALUES
  (1)
, (2)
, (3)
, (4) 
, (5)
, (6)
GO

INSERT INTO ProductoPlanta(codigo,idTipoPlanta)
VALUES
  (7, 1)
, (8, 1)
, (9, 2)
, (10, 2) 
, (11, 3)
, (12, 3)
, (13, 4)
, (14, 4)
GO

INSERT INTO UsuarioGestor (nombre,dni,codigoPostal,ciudad,telefono,correo,usuario,contrasenha)
VALUES  
  ('master','000000000', '41098', 'Babilonia', '00000000', 'omnipotente@si.si', 'root', 'toor')
, ('Bladimir Putin','111111111', '41098', 'La madre Rusia', '982361273', 'rusiaaaaaaaa@aaaaa.a', 'putinin14', 'tengofrio93')
, ('Pat the postman','222222222', '41098', 'Greendale','982361273', 'yosoypat@elcartero.guau', 'tupatchulo56', 'cartitaforyou16')
, ('Federico Chiesa','333333333', '41098', 'Bergamo', '982361273', 'paquirrin@elcartero.com', 'tertulini65', 'plaquinisolarin')
, ('Amador Rivas','444444444', '41098', 'Toledo', '982361273', 'amay@amay.amay', 'merengue643', 'pandereta49')
, ('Mariano Rajoy','555555555', '41098', 'Sidney', '982361273', 'mipresidente@ppppppp.pp', 'perrosanchezhat', 'odioelpsoe')
GO

INSERT INTO UsuarioVendedor (nombre,dni,codigoPostal,ciudad,telefono,correo,usuario,contrasenha)
VALUES
  ('master','666666666', '41098', 'Babilonia', '982361273', 'omnipotente@si.si', 'vendedor', 'abc')
, ('Ricardo Botichelli','777777777', '41098', 'aaaaaaaaaaa', '982361273', 'tucantantefav@aaaaa.a', 'farinellilachup', 'figarooo')
, ('David Bisbal','888888888', '41098', 'ESPANHA', '982361273', 'avemaria@cuandoseras.mia', 'situquisieras', 'todotedaria')
, ('Upamecano','999999999', '41098', 'Munich', '982361273', 'patata@patata.com', 'upamechulo', 'konatetraidor38')
, ('Sonic','111122222', '41098', 'Nium', '982361273', 'patata@pata.ta', 'tuerizorechulon', 'odioalcarahuevo')
, ('Pedro Picapiedra','333344444', '41098', 'Mesopotamia', '982361273', 'ungaunga@unga.unga', 'paleoliticoenjo', 'odioelmetal')
GO

INSERT INTO Cliente(nombre,dni,codigoPostal,ciudad,telefono,correo)
VALUES 
  ('especial','555556666', '41098', 'Omnipotente', '982361273', 'omnipotente@si.si')
, ('Stephen King','777788888', '41098', 'Florida', '982361273', 'soyelrey@tonto.a')
, ('Ben Tenison','999922222', '41098', 'California', '982361273', 'ben10@omnitrix.yeah')
, ('Michael Phelps','222211111', '41098', 'New York sity', '982361273', 'mariposa@mariposita.com')
, ('Mr Hauwei','444443333', '41098', 'Hong Kong', '982361273', 'soyunamierda@nomecompres.es')
, ('Pablo Motos','666665555', '41098', 'Madrid', '982361273', 'tengounhumor@horrible.arbol')
, ('Laura Pausini','666655555', '41098', 'Glasgow', '982361273', 'nosequienes@pata.ta')
GO

INSERT INTO Factura (fecha,importe,idVendedor,idCliente)
VALUES
   (CURRENT_TIMESTAMP,30,3,6)
  ,(CURRENT_TIMESTAMP,110,4,2)
  ,(CURRENT_TIMESTAMP,30,1,5)
 GO

INSERT INTO ProductoFactura (IdFactura,codigoProducto,cantidad,precio)
VALUES
    (1,2,1,14)
   ,(1,3,1,16)
   ,(2,4,1,50)
   ,(2,11,1,60)
   ,(3,6,1,7)
   ,(3,10,1,23)
