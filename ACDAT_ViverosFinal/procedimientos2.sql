USE MartinezAralViveros
GO
CREATE PROCEDURE getInformeMensual @mes int AS 
;
	BEGIN

	SELECT ImporteFinal.Mes, SUM(DISTINCT ImporteFinal.[Importe total plantas]), SUM(DISTINCT ImporteFinal.[Importe total jardineria]), (SUM(DISTINCT ImporteFinal.[Importe total plantas])+SUM(DISTINCT ImporteFinal.[Importe total jardineria])) AS [Importe total] FROM
	(
		SELECT DATEPART(MONTH, ImporteJardineriaMes.fecha) AS [Mes], ImportePlantasMes.[Importe total plantas], ImporteJardineriaMes.[Importe total jardineria] FROM (
			SELECT ImportePlanta.[Id de la factura], ImportePlanta.fecha,SUM(ImportePlanta.[Importe]) AS [Importe total plantas] FROM (
				SELECT F.Id AS [Id de la factura], F.fecha, P.codigo AS [Id del producto], (PF.cantidad*PF.PrecioEnEseMomento) AS [Importe] FROM Factura AS F
					INNER JOIN FacturaProducto AS PF ON F.Id = PF.IdFactura
					INNER JOIN Producto AS P ON PF.codigoProducto = P.codigo
					INNER JOIN ProductoPlanta AS PP ON P.codigo = PP.codigo
				) AS ImportePlanta
			WHERE DATEPART(MONTH, ImportePlanta.fecha) = @mes
			GROUP BY ImportePlanta.[Id de la factura], ImportePlanta.fecha
			) AS ImportePlantasMes
			INNER JOIN
			(
			SELECT ImporteJardineria.[Id de la factura],ImporteJardineria.fecha, SUM(ImporteJardineria.[Importe]) AS [Importe total jardineria] FROM (
				SELECT F.Id AS [Id de la factura],F.fecha,  P.codigo AS [Id del producto], (PF.cantidad*PF.PrecioEnEseMomento) AS [Importe] FROM Factura AS F
					INNER JOIN FacturaProducto AS PF ON F.Id = PF.IdFactura
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