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
GO
--Necesito dos vistas, una de las ventas de plantas en un mes, y otra de las ventas de jardineria en un mes
CREATE PROCEDURE GetInformeMensual @mes int 
AS 
	BEGIN

	SELECT ImporteFinal.Mes, SUM(DISTINCT ImporteFinal.[Importe total plantas]), SUM(DISTINCT ImporteFinal.[Importe total jardineria]), (SUM(DISTINCT ImporteFinal.[Importe total plantas])+SUM(DISTINCT ImporteFinal.[Importe total jardineria])) AS [Importe total] FROM
	(
		SELECT DATEPART(MONTH, ImporteJardineriaMes.fecha) AS [Mes], ImportePlantasMes.[Importe total plantas], ImporteJardineriaMes.[Importe total jardineria] FROM (
			SELECT ImportePlanta.[Id de la factura], ImportePlanta.fecha,SUM(ImportePlanta.[Importe]) AS [Importe total plantas] FROM (
				SELECT F.Id AS [Id de la factura], F.fecha, P.codigo AS [Id del producto], (PF.cantidad*PF.precio) AS [Importe] FROM Factura AS F
					INNER JOIN ProductoFactura AS PF ON F.Id = PF.IdFactura
					INNER JOIN Producto AS P ON PF.codigoProducto = P.codigo
					INNER JOIN ProductoPlanta AS PP ON P.codigo = PP.codigo
				) AS ImportePlanta
			WHERE DATEPART(MONTH, ImportePlanta.fecha) = @mes
			GROUP BY ImportePlanta.[Id de la factura], ImportePlanta.fecha
			) AS ImportePlantasMes
			INNER JOIN
			(
			SELECT ImporteJardineria.[Id de la factura],ImporteJardineria.fecha, SUM(ImporteJardineria.[Importe]) AS [Importe total jardineria] FROM (
				SELECT F.Id AS [Id de la factura],F.fecha,  P.codigo AS [Id del producto], (PF.cantidad*PF.precio) AS [Importe] FROM Factura AS F
					INNER JOIN ProductoFactura AS PF ON F.Id = PF.IdFactura
					INNER JOIN Producto AS P ON PF.codigoProducto = P.codigo
					INNER JOIN ProductoJardineria AS PP ON P.codigo = PP.codigo
				) AS ImporteJardineria
			WHERE DATEPART(MONTH,ImporteJardineria.fecha) = @mes
			GROUP BY ImporteJardineria.[Id de la factura], ImporteJardineria.fecha
			) AS ImporteJardineriaMes
		ON ImportePlantasMes.[Id de la factura] = ImportePlantasMes.[Id de la factura]
		GROUP BY DATEPART(MONTH, ImporteJardineriaMes.fecha), ImportePlantasMes.[Importe total plantas], ImporteJardineriaMes.[Importe total jardineria]
	) AS ImporteFinal
	GROUP BY ImporteFinal.Mes
	END
GO

--Generar un informe de ventas de todo un año, con los mismos datos que el anterior.
CREATE PROCEDURE GetInformeAnual @anho int 
AS 
	BEGIN
	SELECT ImporteFinal.Anho, SUM(DISTINCT ImporteFinal.[Importe total plantas]), SUM(DISTINCT ImporteFinal.[Importe total jardineria]), (SUM(DISTINCT ImporteFinal.[Importe total plantas])+SUM(DISTINCT ImporteFinal.[Importe total jardineria])) AS [Importe total] FROM
	(
		SELECT DATEPART(YEAR, ImporteJardineriaAnho.fecha) AS Anho, ImportePlantasAnho.[Importe total plantas], ImporteJardineriaAnho.[Importe total jardineria] FROM (
			SELECT ImportePlanta.[Id de la factura], ImportePlanta.fecha,SUM(ImportePlanta.[Importe]) AS [Importe total plantas] FROM (
				SELECT F.Id AS [Id de la factura], F.fecha, P.codigo AS [Id del producto], (PF.cantidad*PF.precio) AS [Importe] FROM Factura AS F
					INNER JOIN ProductoFactura AS PF ON F.Id = PF.IdFactura
					INNER JOIN Producto AS P ON PF.codigoProducto = P.codigo
					INNER JOIN ProductoPlanta AS PP ON P.codigo = PP.codigo
				) AS ImportePlanta
			WHERE DATEPART(YEAR, ImportePlanta.fecha) = @anho
			GROUP BY ImportePlanta.[Id de la factura], ImportePlanta.fecha
			) AS ImportePlantasAnho
			INNER JOIN
			(
			SELECT ImporteJardineria.[Id de la factura],ImporteJardineria.fecha, SUM(ImporteJardineria.[Importe]) AS [Importe total jardineria] FROM (
				SELECT F.Id AS [Id de la factura],F.fecha,  P.codigo AS [Id del producto], (PF.cantidad*PF.precio) AS [Importe] FROM Factura AS F
					INNER JOIN ProductoFactura AS PF ON F.Id = PF.IdFactura
					INNER JOIN Producto AS P ON PF.codigoProducto = P.codigo
					INNER JOIN ProductoJardineria AS PP ON P.codigo = PP.codigo
				) AS ImporteJardineria
			WHERE DATEPART(YEAR,ImporteJardineria.fecha) = @anho
			GROUP BY ImporteJardineria.[Id de la factura], ImporteJardineria.fecha
			) AS ImporteJardineriaAnho
		ON ImportePlantasAnho.[Id de la factura] = ImportePlantasAnho.[Id de la factura]
		GROUP BY DATEPART(YEAR, ImporteJardineriaAnho.fecha), ImportePlantasAnho.[Importe total plantas], ImporteJardineriaAnho.[Importe total jardineria]
	) AS ImporteFinal
	GROUP BY ImporteFinal.Anho
	END
GO

