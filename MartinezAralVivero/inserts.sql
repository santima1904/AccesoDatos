USE MartinezAralViveros
GO
SET IDENTITY_INSERT dbo.Cliente ON
GO
INSERT INTO Cliente (ID,Nombre,DNI,Direccion,CodigoPostal,Ciudad,Telefono,Correo) VALUES (0,'Invitado','30012456D','c/no tengo descuento','41005','invitopolis','654070809','soyuninvitado@gmail.com')
GO
SET IDENTITY_INSERT dbo.Cliente OFF
GO
INSERT INTO Cliente VALUES ('Stephen','32145678G','c/lloreria','41098','Florida','982361273','omnipotente@si.si'), ('Ben Tenison','12332112H','c/volcan','41098','California','982361273','ben10@omnitrix.yeah'), ('Michael Phelps','32111155G','c/dualidad','41098','New York sity','982365773','mariposa@mariposita.com'), ('Mr Hauwei','98889000V','c/sevillista','41098','Hong Kong','921334556','soyunamierda@nomecompres.es'), ('Pablo Motos','55500077L','c/ojos rojos','00420','Madrid','933567420','tengounhumor@horrible.arbol'), ('Laura Pausini','44558899X','c/abismont','12361','Glasgow','657980989','nosequienes@pata.ta')
GO
INSERT INTO Categoria VALUES ('Plantas de Interior'), ('Plantas de Exterior'), ('Arboles Ornamentales'), ('Arboles Frutales')
GO
INSERT INTO Producto VALUES ('P1','Abono especial', 27, 8), ('P2', 'Herrramienta para la tierra', 14, 5), ('P3','Maceta de flores', 16, 24), ('P4', 'Podadera a dos manos', 50, 10), ('P5', 'Tijera para podar', 9, 25), ('P6', 'Palita recogedor', 7, 30), ('P7', 'Ficus', 40, 3), ('P8', 'Areca', 32, 6), ('P9','Cupressus Goldcrest', 124,2), ('P10', 'Monstera Deliciosa', 23, 8), ('P11', 'Mimosa', 60, 9), ('P12', 'Sauce plateado', 55, 9), ('P13', 'Almendro', 47, 11), ('P14', 'Limonero', 57, 10)
GO
INSERT INTO ProductoJardineria VALUES ('P1'), ('P2'), ('P3'), ('P4'), ('P5'), ('P6')
GO
INSERT INTO ProductoPlanta VALUES ('P7','1'), ('P8','1'), ('P9','2'), ('P10','2'), ('P11','3'), ('P12','3'), ('P13','4'), ('P14','4')
GO
INSERT INTO UsuarioVendedor VALUES ('Vendedor','89009123C','c/Vendiendo Mucho','10001','Vendepolis','678091434','crackvendedor@gmail.com','vendedor','abc'), ('Ricardo Botichelli','67788990D','c/Mansion Wayne','34567','aaaaaaaaaaa','678654321','tucantantefav@aaaaa.a','farinellilachup','figarooo'), ('David Bisbal','12345678Z','c/Arbol','00001','ESPANHA','954671403','avemaria@cuandoseras.mia','situquisieras','todotedaria'), ('Upamecano','09010203E','c/Mentalidad Tiburon','56700','Munich','456321978','patata@patata.com','upamechulo','konatetraidor38'), ('Sonic','11122233P','c/Empresa','89980','Nium','900800700','patata@pata.ta','tuerizorechulon','odioalcarahuevo'), ('Pedro Picapiedra','65478901V','c/Me pone','12345','Mesopotamia','300567123','ungaunga@unga.unga','paleoliticoenjo','odioelmetal')
GO
INSERT INTO Factura VALUES (CURRENT_TIMESTAMP,30,3,6), (CURRENT_TIMESTAMP,110,4,2), (CURRENT_TIMESTAMP,30,1,5)
GO
INSERT INTO FacturaProducto VALUES  (1,'P2',1,14), (1,'P3',1,16), (2,'P4',1,50), (2,'P11',1,60), (3,'P6',1,7), (3,'P10',1,23)
GO
INSERT INTO UsuarioGestor VALUES ('Gestor','11223344B','c/Gestionando Mucho','01110','Gestopolis','678091343','crackgestor@gmail.com','root','toor'), ('Cristiano','99009900Y','c/Soy el mejor','23456','Portugal','345000111','soyportugues@gmail.com','Ronaldo','soyelmejor123'), ('Pat the postman','77665511P','c/Programando Movil','78234','Greendale','901345678','yosoypat@elcartero.guau','tupatchulo56','cartitaforyou16'), ('Federico Chiesa','95123670V','c/Pagando Impuestos','12345','Bergamo','654378902','paquirrin@elcartero.com','tertulini65','plaquinisolarin'), ('Amador Rivas','12345000A','c/Durmiendo Siesta','22220','Toledo','678901260','amay@amay.amay','merengue643','pandereta49'),('Pikachu','55566607X','c/Ash Ketchup','11102','Kanto','907070809','rayos@gmail.com','Pokemon','rayosytruenos')
