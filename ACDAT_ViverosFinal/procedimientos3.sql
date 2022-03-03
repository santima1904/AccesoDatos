USE MartinezAralViveros
GO
CREATE PROCEDURE getInformeAnual @anho int AS
;
	BEGIN
	SELECT ImporteFinal.Anho, SUM(DISTINCT ImporteFinal.[Importe total plantas]), SUM(DISTINCT ImporteFinal.[Importe total jardineria]), (SUM(DISTINCT ImporteFinal.[Importe total plantas])+SUM(DISTINCT ImporteFinal.[Importe total jardineria])) AS [Importe total] FROM
	(
		SELECT DATEPART(YEAR, ImporteJardineriaAnho.fecha) AS Anho, ImportePlantasAnho.[Importe total plantas], ImporteJardineriaAnho.[Importe total jardineria] FROM (
			SELECT ImportePlanta.[Id de la factura], ImportePlanta.fecha,SUM(ImportePlanta.[Importe]) AS [Importe total plantas] FROM (
				SELECT F.Id AS [Id de la factura], F.fecha, P.codigo AS [Id del producto], (PF.cantidad*PF.PrecioEnEseMomento) AS [Importe] FROM Factura AS F
					INNER JOIN FacturaProducto AS PF ON F.Id = PF.IdFactura
					INNER JOIN Producto AS P ON PF.codigoProducto = P.codigo
					INNER JOIN ProductoPlanta AS PP ON P.codigo = PP.codigo
				) AS ImportePlanta
			WHERE DATEPART(YEAR, ImportePlanta.fecha) = @anho
			GROUP BY ImportePlanta.[Id de la factura], ImportePlanta.fecha
			) AS ImportePlantasAnho
			INNER JOIN
			(
			SELECT ImporteJardineria.[Id de la factura],ImporteJardineria.fecha, SUM(ImporteJardineria.[Importe]) AS [Importe total jardineria] FROM (
				SELECT F.Id AS [Id de la factura],F.fecha,  P.codigo AS [Id del producto], (PF.Cantidad*PF.PrecioEnEseMomento) AS [Importe] FROM Factura AS F
					INNER JOIN FacturaProducto AS PF ON F.Id = PF.IdFactura
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