/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubp.doo.tp.modelo;

import java.util.List;

import ubp.doo.tp.dao.FabricaDAO;
import ubp.doo.tp.dao.VehiculoDAO;
import ubp.doo.tp.dto.VehiculoDTO;

/**
 *
 * @author bettic
 */
public class MVehiculo implements Modelo {
	private final FabricaDAO fabricaDao;
    private final VehiculoDAO vehiculoDao;
    
    public MVehiculo() {
    	fabricaDao = FabricaDAO.getFactory("SqlFabricaDAO");
    	vehiculoDao = fabricaDao.getVehiculoDao();
    }
    
    public VehiculoDTO buscarVehiculo(String matricula) {
    	VehiculoDTO vehiculo = vehiculoDao.buscarVehiculo(matricula);
    	return vehiculo;
    }
    
    public VehiculoDTO buscarVehiculo(String comp, int poliza) {
    	VehiculoDTO vehiculo = vehiculoDao.buscarVehiculo(comp, poliza);
    	return vehiculo;
    }
    
    public List<VehiculoDTO> listarVehiculos() {
    	List<VehiculoDTO> vehiculos = vehiculoDao.listarVehiculos();
    	return vehiculos;
    }

    public List<VehiculoDTO> listarVehiculos(String dniTipo, int dni) {
    	List<VehiculoDTO> vehiculos = vehiculoDao.listarVehiculos(dniTipo, dni);
    	return vehiculos;
    }

    public List<VehiculoDTO> listarVehiculos(String compania) {
    	List<VehiculoDTO> vehiculos = vehiculoDao.listarVehiculos(compania);
    	return vehiculos;
    }

    public boolean insertarVehiculo(VehiculoDTO vehiculo) {
    	return vehiculoDao.insertarVehiculo(vehiculo);
    }

    public boolean modificarVehiculo(VehiculoDTO vehiculo) {
    	return vehiculoDao.modificarVehiculo(vehiculo);
    }

    public boolean borrarVehiculo(VehiculoDTO vehiculo) {
    	return vehiculoDao.borrarVehiculo(vehiculo);
    }
    
    public void cerrarConexion() {
    	vehiculoDao.cerrarConexion();
    }
}
