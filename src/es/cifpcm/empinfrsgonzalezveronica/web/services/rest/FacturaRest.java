/**
 * 
 */
package es.cifpcm.empinfrsgonzalezveronica.web.services.rest;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import es.cifpcm.empinfrsgonzalezveronica.web.data.FacturaDaoImpl;
import es.cifpcm.empinfrsgonzalezveronica.web.model.Factura;

/**
 * @author vero_
 *
 */
@Path("/factura")
public class FacturaRest {
	FacturaDaoImpl listaFacturas= new FacturaDaoImpl();
	
	public FacturaRest() {
		
	}
	
	@GET
	@Produces((MediaType.APPLICATION_JSON))
	public String selectAll() {
		List<Factura> facturas=listaFacturas.selectAll();
		String json= new Gson().toJson(facturas);
		return json;
		
	}
	
	@POST
    @Consumes((MediaType.APPLICATION_JSON))

    public void insertFactura(String jsonFactura) {
        Factura factura = new Gson().fromJson(jsonFactura, Factura.class);
        //Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        listaFacturas.insert(factura);
        
        
    }
    
}

