/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubp.doo.tp.dao;

import ubp.doo.tp.dto.FacturaDTO;
import java.util.Date;
import java.util.List;
/**
 *
 * @author tomas
 */
public interface FacturaDAO {
    
    void cerrarConexion();
    
    FacturaDTO buscarFactura(String comp, float costo, float pago, Date fecha);
    
    List<FacturaDTO> filtrarFacturas(String comp);
    
    List<FacturaDTO> filtrarFacturas(float costo, float pago);
    
    List<FacturaDTO> filtrarFacturas(Date fecha);
    
    List<FacturaDTO> listarFacturas();
    
    boolean insertarFactura(FacturaDTO factura);
    
    boolean modificarFactura(FacturaDTO factura);
    
    boolean eliminarFactura(FacturaDTO factura);
}
