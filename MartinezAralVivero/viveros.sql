CREATE DATABASE MartinezAralViveros
GO
USE MartinezAralViveros
GO
CREATE TABLE UsuarioVendedor (
	ID int identity Constraint PK_UsuarioVendedor Primary Key,
	Nombre VarChar(20) not null,
	DNI Char(9) unique not null,
	Direccion VarChar(30) not null,
	CodigoPostal Char(5) not null,
	Ciudad VarChar(15) not null,
	Telefono Char(9) not null,
	Correo VarChar(30) not null,
	NombreUsuario VarChar(15) not null,
	Contrasenya VarChar(20) not null
	)
GO
CREATE TABLE UsuarioGestor(
	ID int identity Constraint PK_UsuarioGestor Primary Key,
	Nombre VarChar(20) not null,
	DNI Char(9) unique not null,
	Direccion VarChar(30) not null,
	CodigoPostal Char(5) not null,
	Ciudad VarChar(15) not null,
	Telefono Char(9) not null,
	Correo VarChar(30) not null,
	NombreUsuario VarChar(15) not null,
	Contrasenya VarChar(20) not null
	)
GO
CREATE TABLE Cliente(
	ID int identity Constraint PK_Cliente Primary Key,
	Nombre VarChar(20) not null,
	DNI Char(9) unique not null,
	Direccion VarChar(30) not null,
	CodigoPostal Char(5) not null,
	Ciudad VarChar(15) not null,
	Telefono Char(9) not null,
	Correo VarChar(30) not null
)
GO
CREATE TABLE Producto(
	Codigo Char(10) Constraint PK_Producto Primary Key,
	Descripcion VarChar(40) not null,
	PrecioUnitario smallmoney not null,
	UnidadesDisponibles int not null
)
GO
CREATE TABLE Categoria(
	ID int identity Constraint PK_Categoria Primary Key,
	Nombre VarChar(30) not null
)
GO
CREATE TABLE ProductoJardineria(
	Codigo Char(10) Constraint PK_ProductoJardineria Primary Key,
	Constraint FK_ProductoJardineria Foreign Key (Codigo) REFERENCES Producto(Codigo) ON DELETE NO ACTION ON UPDATE NO ACTION
)
GO
CREATE TABLE ProductoPlanta(
	Codigo Char(10) Constraint PK_ProductoPlanta Primary Key,
	IDCategoria int not null,
	Constraint FK_ProductoPlanta Foreign Key (Codigo) REFERENCES Producto(Codigo) ON DELETE NO ACTION ON UPDATE NO ACTION,
	Constraint FK_Categoria Foreign Key (IDCategoria) REFERENCES Categoria(ID) ON DELETE NO ACTION ON UPDATE NO ACTION
)
GO
CREATE TABLE Factura(
	ID int identity Constraint PK_Factura Primary Key,
	Fecha DateTime not null,
	ImporteTotal money not null,
	IDVendedor int not null,
	IDCliente int not null,
	Constraint FK_Vendedor Foreign Key (IDVendedor) REFERENCES UsuarioVendedor(ID) ON DELETE NO ACTION ON UPDATE NO ACTION,
	Constraint FK_Cliente Foreign Key (IDCliente) REFERENCES Cliente(ID) ON DELETE NO ACTION ON UPDATE NO ACTION 
)
GO
CREATE TABLE FacturaProducto(
	IDFactura int not null,
	CodigoProducto Char(10) not null,
	Cantidad int not null,
	PrecioEnEseMomento smallmoney not null,
	Constraint PK_FacturaProducto Primary Key (IDFactura,CodigoProducto),
	Constraint FK_FacturaProducto Foreign Key(IDFactura) REFERENCES Factura(ID) ON DELETE NO ACTION ON UPDATE NO ACTION,
	Constraint FK_ProductorFactura Foreign Key(CodigoProducto) REFERENCES Producto(Codigo) ON DELETE NO ACTION ON UPDATE NO ACTION 
)
GO