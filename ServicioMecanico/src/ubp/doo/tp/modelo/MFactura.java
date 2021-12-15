/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubp.doo.tp.modelo;

import java.util.Date;
import java.util.List;

import ubp.doo.tp.dao.FabricaDAO;
import ubp.doo.tp.dao.FacturaDAO;
import ubp.doo.tp.dto.FacturaDTO;

/**
 *
 * @author bettic
 */
public class MFactura {
	private final FabricaDAO fabricaDao;
    private final FacturaDAO facturaDao;
    
    public MFactura() {
    	fabricaDao = FabricaDAO.getFactory("SqlFabricaDAO");
    	facturaDao = fabricaDao.getFacturaDao();
    }
    
    public FacturaDTO buscarFactura(String comp, float costo, float pago, Date fecha) {
    	FacturaDTO factura = facturaDao.buscarFactura(comp, costo, pago, fecha);
    	return factura;
    }
    
    public List<FacturaDTO> filtrarFacturas(String comp) {
    	List<FacturaDTO> facturas = facturaDao.filtrarFacturas(comp);
    	return facturas;
    }
    
    public List<FacturaDTO> filtrarFacturas(float costo, float pago) {
    	List<FacturaDTO> facturas = facturaDao.filtrarFacturas(costo, pago);
    	return facturas;
    }
    
    public List<FacturaDTO> filtrarFacturas(Date fecha) {
    	List<FacturaDTO> facturas = facturaDao.filtrarFacturas(fecha);
    	return facturas;
    }
    
    public List<FacturaDTO> listarFacturas() {
    	List<FacturaDTO> facturas = facturaDao.listarFacturas();
    	return facturas;
    }
    
    public boolean insertarFactura(FacturaDTO factura) {
    	return facturaDao.insertarFactura(factura);
    }
    
    public boolean modificarFactura(FacturaDTO factura) {
    	return facturaDao.modificarFactura(factura);
    }
    
    public boolean eliminarFactura(FacturaDTO factura) {
    	return facturaDao.eliminarFactura(factura);
    }
}
