/**
 * 
 */
package es.cifpcm.empinfrsgonzalezveronica.web.data;

import java.util.List;

import es.cifpcm.empinfrsgonzalezveronica.web.model.Factura;

/**
 * @author vero_
 *
 */
public interface FacturaDao {
	public List<Factura> selectAll();

    public void insert(Factura factura);
}
