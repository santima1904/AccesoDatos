USE MartinezAral
GO
--CREATE PROCEDURE SP_CrearFactura @idPedido int AS ;
--INSERT INTO Factura(idPedido, Fecha) VALUES (@idPedido, CURRENT_TIMESTAMP)
--GO

--Mostrar una lista de productos que contiene la base de datos indicando el tipo.
--Jardineria
SELECT * FROM Producto AS P
--Plantas
SELECT P.codigo, P.descripcion, P.precioUnitario, P.unidades, TP.nombre FROM Producto AS P
INNER JOIN ProductoPlanta AS PP ON P.codigo = PP.codigo
INNER JOIN TipoPlanta AS TP ON PP.idTipoPlanta = TP.Id

--Mostrar una lista de clientes.
SELECT * FROM Cliente

--Mostrar una lista de vendedores.
SELECT * FROM UsuarioVendedor

--Mostrar una lista de gestores.
SELECT * FROM UsuarioGestor

--Mostrar las facturas de un cliente concreto.
SELECT F.Id, F.fecha, F.importe, F.idVendedor, C.nombre FROM Cliente AS C
INNER JOIN Factura AS F ON C.Id = F.idCliente
--WHERE C.Id = 

--Generar un informe con el total de ventas de un mes indicando la fecha.
--Este informe incluirá las ventas totales por cada tipo de producto y el total global.


--Generar un informe de ventas de todo un año, con los mismos datos que el anterior.
