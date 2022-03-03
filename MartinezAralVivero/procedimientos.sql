USE MartinezAralViveros
GO
CREATE PROCEDURE insertFactura @fecha Date, @importe money, @idVendedor int, @idCliente int,@facturaId int OUTPUT AS
;
INSERT INTO Factura VALUES (@fecha, @importe, @idVendedor, @idCliente)

SELECT @facturaId = IDENT_CURRENT('Factura')
RETURN