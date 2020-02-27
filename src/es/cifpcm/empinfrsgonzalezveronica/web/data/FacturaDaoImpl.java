package es.cifpcm.empinfrsgonzalezveronica.web.data;

import es.cifpcm.empinfrsgonzalezveronica.web.model.Factura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FacturaDaoImpl implements FacturaDao {

	DAOFactory connection = new DAOFactory();
	Connection conn = connection.getConexion();
	ArrayList<Factura> listaFacturas = new ArrayList<Factura>();

	@Override
	public List<Factura> selectAll() {
		try {
			String sql = "SELECT * FROM factura order by NFactura desc limit 10";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Factura f = new Factura();
				f.setIdFactura(rs.getInt(1));
				f.setFecha(rs.getTimestamp(2));
				f.setCliente(rs.getString(3));
				f.setIdTienda(rs.getInt(4));
				listaFacturas.add(f);
			}
			conn.close();
		} catch (SQLException ex) {
			Logger.getLogger(FacturaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
		}
		return listaFacturas;

	}

	@Override
	public void insert(Factura factura) {
		try {
            String query = "INSERT INTO factura (NFactura, cliente, idTienda) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, factura.getIdFactura());
            //pstmt.setTimestamp(2, factura.getFecha());
            pstmt.setString(2, factura.getCliente());
            pstmt.setInt(3, factura.getIdTienda());
            pstmt.executeUpdate();
            conn.close();
            

        } catch (SQLException ex) {
            Logger.getLogger(FacturaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
}
