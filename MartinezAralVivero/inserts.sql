USE MartinezAralViveros
GO
SET IDENTITY_INSERT dbo.Cliente ON
GO
INSERT INTO Cliente (ID,Nombre,DNI,Direccion,CodigoPostal,Ciudad,Telefono,Correo) VALUES (0,'Invitado','30012456D','c/no tengo descuento','41005','invitopolis','654070809','soyuninvitado@gmail.com')
GO
SET IDENTITY_INSERT dbo.Cliente OFF
GO
INSERT INTO Cliente VALUES ('Babi','32145678G','c/lloreria','21000','Lagrimas','654020103','babi@gmail.com'), ('Charmander','12332112H','c/volcan','59713','La Palma','650324354','fuego@gmail.com'), ('Lucifer','32111155G','c/dualidad','10022','Los Cielos','978435301','luzysombra@gmail.com'), ('Martial','98889000V','c/sevillista','55443','Sevilla','921334556','soysevillista@gmail.com'), ('Maria-Juana','55500077L','c/ojos rojos','00420','Felicidad','933567420','trespapeles@gmail.com'), ('Artorias','44558899X','c/abismont','12361','Dark Souls','657980989','huskylover@gmail.com')
GO
INSERT INTO Categoria VALUES ('Plantas de Interior'), ('Plantas de Exterior'), ('Arboles Ornamentales'), ('Arboles Frutales')
GO
INSERT INTO Producto VALUES ('PJ1','Hoz',10,100), ('PJ2','Seto Artificial',35,20), ('PJ3','Podadora',60,10), ('PJ4','M�quina Cortacesped',150,10), ('PJ5','Casco Anitirruido',8.5,15), ('PJ6','Guantes Protectores',5,100), ('PP1','Cactus',33.95,20), ('PP2','Alocasia',20.95,20), ('PP3','Dr�cena',19.95,30), ('PP4','Ficus',22.95,40), ('PP5','Zamioculca',35.95,50), ('PP6','Beaucarnea',119.95,10), ('PP7','Roble',31.95,35), ('PP8','Cyca',33.95,40), ('PP9','Acer',34.95,40), ('PP10','Cipr�s Totem',45.95,20), ('PP11','Cupressus',27.95,15), ('PP12','Ulmus',96.95,10), ('PP13','Mimosa',31.95,25),  ('PP14','Pata de Vaca',23.95,30), ('PP15','�rbol de J�piter',59.95,10), ('PP16','Arce de Canada',30.95,15), ('PP17','Juglans',151.95,5), ('PP18','Sauce Boxeador',599.95,1), ('PP19','Cerezo',45.95,10), ('PP20','Manzano',25.95,10), ('PP21','Limonero',20.95,15), ('PP22','Naranjo',90.95,10), ('PP23','Melocotonero',130.95,30), ('PP24','Palmera',155.95,40)
GO
INSERT INTO ProductoJardineria VALUES ('PJ1'), ('PJ2'), ('PJ3'), ('PJ4'), ('PJ5'), ('PJ6')
GO
INSERT INTO ProductoPlanta VALUES ('PP1','1'), ('PP2','1'), ('PP3','1'), ('PP4','1'), ('PP5','1'), ('PP6','1'), ('PP7','2'), ('PP8','2'), ('PP9','2'), ('PP10','2'), ('PP11','2'), ('PP12','2'), ('PP13','3'), ('PP14','3'), ('PP15','3'), ('PP16','3'), ('PP17','3'), ('PP18','3'), ('PP19','4'), ('PP20','4'), ('PP21','4'), ('PP22','4'), ('PP23','4'), ('PP24','4')
GO
INSERT INTO UsuarioVendedor VALUES ('Vendedor','89009123C','c/Vendiendo Mucho','10001','Vendepolis','678091434','crackvendedor@gmail.com','vendedor','abc'), ('Bruce','67788990D','c/Mansion Wayne','34567','Gotham','678654321','nosoybatman@gmail.com','Batman','superheroe'), ('VendePlantas','12345678Z','c/Arbol','00001','Bosque','954671403','misplantitas@hotmail.es','Groot','planta123'), ('Tiburon','09010203E','c/Mentalidad Tiburon','56700','Oceano','456321978','setupropiojefe@gmail.com','Antonio','Urbano'), ('PersonaMisteriosa','11122233P','c/Empresa','89980','Runaterra','900800700','okgracias@gmail.com','Paco','paco'), ('Tecatito','65478901V','c/Me pone','12345','Mexico','300567123','soysevillista@gmail.com','Corona','Rojiblanco')
GO
INSERT INTO Factura VALUES (CURRENT_TIMESTAMP,127.85,1,0), (CURRENT_TIMESTAMP,321.3,2,0), (CURRENT_TIMESTAMP,141.28,3,0), (CURRENT_TIMESTAMP,313.8,4,0), (CURRENT_TIMESTAMP,124.35,5,0), (CURRENT_TIMESTAMP,140.8,6,0), (CURRENT_TIMESTAMP,152.7,1,1), (CURRENT_TIMESTAMP,198.5,2,1), (CURRENT_TIMESTAMP,140.41,3,1), (CURRENT_TIMESTAMP,203.1,4,1), (CURRENT_TIMESTAMP,656,5,1), (CURRENT_TIMESTAMP,102.41,6,1), (CURRENT_TIMESTAMP,208.3,1,2), (CURRENT_TIMESTAMP,202.2,2,2), (CURRENT_TIMESTAMP,225.4,3,2), (CURRENT_TIMESTAMP,509.9,4,2), (CURRENT_TIMESTAMP,154.2,5,2), (CURRENT_TIMESTAMP,282,6,2), (CURRENT_TIMESTAMP,234.46,1,3), (CURRENT_TIMESTAMP,226.8,2,3), (CURRENT_TIMESTAMP,251.6,3,3), (CURRENT_TIMESTAMP,313.3,4,3), (CURRENT_TIMESTAMP,253.4,5,3), (CURRENT_TIMESTAMP,278.1,6,3), (CURRENT_TIMESTAMP,218.3,1,4), (CURRENT_TIMESTAMP,217.9,2,4), (CURRENT_TIMESTAMP,222.15,3,4), (CURRENT_TIMESTAMP,282.9,4,4), (CURRENT_TIMESTAMP,251.6,5,4), (CURRENT_TIMESTAMP,208.86,6,4)
GO
INSERT INTO FacturaProducto VALUES (1,'PJ1',1,10), (1,'PJ2',1,35), (1,'PP1',1,33.95), (1,'PJ6',1,5), (1,'PP21',1,20.95), (1,'PP4',1,22.95), (2,'PJ3',1,60), (2,'PP10',1,45.95), (2,'PP17',1,151.95), (2,'PP3',1,19.95), (2,'PP9',1,34.95), (2,'PJ5',1,8.5), (3,'PJ1',1,10), (3,'PP10',1,45.95), (3,'PP1',1,33.95), (3,'PP3',1,19.95), (3,'PJ5',1,8.5), (3,'PP4',1,22.95), (4,'PJ4',1,150), (4,'PP5',1,33.95), (4,'PP20',1,25.95), (4,'PP19',1,45.95), (4,'PP2',1,20.95), (4,'PJ2',1,35),(5,'PP8',1,33.95), (5,'PP9',1,34.95), (5,'PJ1',1,10), (5,'PJ5',1,8.5), (5,'PJ6',1,5), (5,'PP13',1,31.95), (6,'PP8',1,33.95), (6,'PP5',1,35.95), (6,'PP9',1,34.95), (6,'PJ6',1,5), (6,'PJ1',1,10), (6,'PP2',1,20.95), (7,'PP20',1,25.95), (7,'PP2',1,20.95), (7,'PP5',1,35.95), (7,'PP4',1,22.95), (7,'PP3',1,19.95), (7,'PP9',1,34.95), (8,'PP11',1,27.95), (8,'PP1',1,33.95), (8,'PP12',1,96.95), (8,'PJ1',1,10), (8,'PJ6',1,5), (8,'PJ2',1,35), (9,'PP20',1,25.95), (9,'PP1',1,33.95), (9,'PJ1',1,10), (9,'PP4',1,22.95), (9,'PP3',1,19.95), (9,'PJ2',1,35), (10,'PP14',1,23.95), (10,'PP15',1,59.95), (10,'PJ3',1,60), (10,'PP7',1,31.95), (10,'PP9',1,34.95), (10,'PP21',1,20.95), (11,'PP23',1,130.95), (11,'PP24',1,155.95), (11,'PJ4',1,150), (11,'PP12',1,96.95), (11,'PP17',1,151.95), (11,'PJ6',1,5), (12,'PP14',1,23.95), (12,'PJ1',1,10), (12,'PJ6',1,5), (12,'PP3',1,19.95), (12,'PP2',1,20.95), (12,'PP11',1,27.95), (13,'PP10',1,45.95), (13,'PP14',1,23.95), (13,'PJ5',1,8.5), (13,'PP8',1,33.95), (13,'PP12',1,96.95), (13,'PJ1',1,10), (14,'PP7',1,31.95), (14,'PP15',1,59.95), (14,'PJ2',1,35), (14,'PP21',1,20.95), (14,'PJ3',1,60), (14,'PJ6',1,5), (15,'PP10',1,45.95), (15,'PP15',1,59.95), (15,'PJ5',1,8.5), (15,'PP21',1,20.95), (15,'PP12',1,96.95), (15,'PJ6',1,5), (16,'PP24',1,155.95), (16,'PP2',1,20.95), (16,'PP4',1,22.95), (16,'PJ4',1,150), (16,'PP17',1,151.95), (16,'PP9',1,34.95), (17,'PJ1',1,10), (17,'PP16',1,30.95), (17,'PJ2',1,35), (17,'PP13',1,31.95), (17,'PP19',1,45.95), (17,'PJ5',1,8.5), (18,'PJ1',1,10), (18,'PP2',1,20.95), (18,'PJ2',1,35), (18,'PJ4',1,150), (18,'PP19',1,45.95), (18,'PP9',1,34.95), (19,'PP8',1,33.95), (19,'PP9',1,34.95), (19,'PJ6',1,5), (19,'PJ1',1,10), (19,'PP23',1,130.95), (19,'PP13',1,31.95), (20,'PP2',1,20.95), (20,'PP1',1,33.95), (20,'PP22',1,90.95), (20,'PJ2',1,35), (20,'PP7',1,31.95), (20,'PP20',1,25.95), (21,'PP8',1,33.95), (21,'PP1',1,33.95), (21,'PJ6',1,5), (21,'PJ2',1,35), (21,'PP23',1,130.95), (21,'PP20',1,25.95), (22,'PP11',1,27.95), (22,'PP5',1,35.95), (22,'PJ4',1,150), (22,'PP14',1,23.95), (22,'PP10',1,45.95), (22,'PP19',1,45.95), (23,'PJ1',1,10), (23,'PJ6',1,5), (23,'PP24',1,155.95), (23,'PP16',1,30.95), (23,'PP2',1,20.95), (23,'PP4',1,22.95), 	(24,'PJ1',1,10), (24,'PP5',1,35.95), (24,'PP24',1,155.95), (24,'PP14',1,23.95), (24,'PP2',1,20.95), (24,'PP19',1,45.95), (25,'PP12',1,96.95), (25,'PP3',1,19.95), (25,'PP5',1,35.95), (25,'PP9',1,34.95), (25,'PJ1',1,10), (25,'PP7',1,31.95), (26,'PJ2',1,35), (26,'PP20',1,25.95), (26,'PP10',1,45.95), (26,'PJ3',1,60), (26,'PP19',1,45.95),	(26,'PJ6',1,5), (27,'PP12',1,96.95), (27,'PP20',1,25.95), (27,'PP5',1,35.95), (27,'PJ3',1,60), (27,'PJ1',1,10), (27,'PJ6',1,5), (28,'PP17',1,151.95), (28,'PP1',1,33.93), (28,'PP13',1,31.95), (28,'PP21',1,20.95), (28,'PP14',1,23.95), (28,'PJ2',1,35), (29,'PJ1',1,10), (29,'PP22',1,90.95), (29,'PP15',1,59.95), (29,'PP2',1,20.95), (29,'PJ3',1,60), (29,'PP4',1,22.95), (30,'PJ1',1,10), (30,'PP1',1,33.95), (30,'PP15',1,59.95), (30,'PP21',1,20.95), (30,'PJ3',1,60), (30,'PJ2',1,35)
GO
INSERT INTO UsuarioGestor VALUES ('Gestor','11223344B','c/Gestionando Mucho','01110','Gestopolis','678091343','crackgestor@gmail.com','root','toor'), ('Cristiano','99009900Y','c/Soy el mejor','23456','Portugal','345000111','soyportugues@gmail.com','Ronaldo','soyelmejor123'), ('MoureDev','77665511P','c/Programando Movil','78234','Android','901345678','desarrolladormovil@hotmail.es','MoureDev','hola321'), ('Xokas','95123670V','c/Pagando Impuestos','12345','Espa�a','654378902','tumadre@gmail.com','Xokas','123456'), ('IlloJuan','12345000A','c/Durmiendo Siesta','22220','Malaga','678901260','alopresidente@hotmail.com','Lmdshow','adios12'),('Pikachu','55566607X','c/Ash Ketchup','11102','Kanto','907070809','rayos@gmail.com','Pokemon','rayosytruenos')