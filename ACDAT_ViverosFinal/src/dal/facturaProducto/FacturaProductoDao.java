package dal.facturaProducto;

import dal.Conexion;
import dal.producto.ProductoDao;
import entidades.FacturaProducto;
import mensaje.Salida;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class FacturaProductoDao {
    public static void facturaLineaPedidos(int idFactura, ArrayList<FacturaProducto> lista){
        String consultaSql = "INSERT INTO FacturaProducto VALUES (?,?,?,?)";
        try(Connection conexion = Conexion.realizarConexion()) {
            PreparedStatement s = conexion.prepareStatement(consultaSql);
            s.setInt(1,idFactura);
            for (FacturaProducto fp : lista){
                s.setString(2,fp.getCode());
                s.setInt(3,fp.getCantidad());
                s.setDouble(4, fp.getValorPrecio());
                s.executeUpdate();
                ProductoDao.actualizarBBDD(fp);
            }
            Salida.mostrarString(Salida.FACTURA_INTRODUCIDA_EXITO);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
