/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubp.doo.tp.modelo;

import java.util.List;

import ubp.doo.tp.dao.DetalleDAO;
import ubp.doo.tp.dao.FabricaDAO;
import ubp.doo.tp.dto.DetalleDTO;

/**
 *
 * @author bettic
 */
public class MDetalle extends Modelo {
	private final FabricaDAO fabricaDao;
    private final DetalleDAO detalleDao;
    
    public MDetalle() {
    	fabricaDao = FabricaDAO.getFactory("SqlFabricaDAO");
    	detalleDao = fabricaDao.getDetalleDao();
    }
    
    public void cerrarConexion() {
    	detalleDao.cerrarConexion();
    }
    
    public DetalleDTO buscarDetalle(int id_detalle) {
    	DetalleDTO detalle = detalleDao.buscarDetalle(id_detalle);
    	return detalle;
    }
    
    public List<DetalleDTO> listarDetalles(int id_ficha) {
    	List<DetalleDTO> detalles = detalleDao.listarDetalles(id_ficha);
    	return detalles;
    } //Listar todos los detalles de la misma ficha
    
    public boolean insertarDetalle(DetalleDTO detalle) {
    	return detalleDao.insertarDetalle(detalle);
    }
    
    public boolean modificarDetalle(DetalleDTO detalle) {
    	return detalleDao.modificarDetalle(detalle);
    }
    
    public boolean eliminarDetalle(DetalleDTO detalle) {
    	return detalleDao.eliminarDetalle(detalle);
    }
}
