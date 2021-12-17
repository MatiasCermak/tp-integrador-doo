/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubp.doo.tp.modelo;

import java.util.List;

import ubp.doo.tp.dao.EspecialidadDAO;
import ubp.doo.tp.dao.FabricaDAO;
import ubp.doo.tp.dto.EspecialidadDTO;

/**
 *
 * @author bettic
 */
public class MEspecialidad implements Modelo {
	private final FabricaDAO fabricaDao;
    private final EspecialidadDAO especialidadDao;
    
    public MEspecialidad() {
    	fabricaDao = FabricaDAO.getFactory("SqlFabricaDAO");
    	especialidadDao = fabricaDao.getEspecialidadDao();
    }
    
    public void cerrarConexion() {
    	especialidadDao.cerrarConexion();
    }
    
    public EspecialidadDTO buscarEspecialidad(String especialidad) {
    	EspecialidadDTO espec = especialidadDao.buscarEspecialidad(especialidad);
    	return espec;
    }
    
    public List<EspecialidadDTO> listarEspecialidades(){
    	List<EspecialidadDTO> especialidades=especialidadDao.listarEspecialidades();
    	return especialidades;
    }
    
    public boolean insertarEspecialidad(EspecialidadDTO especialidad) {
    	return especialidadDao.insertarEspecialidad(especialidad);
    }
    
    public boolean modificarEspecialidad(EspecialidadDTO especialidad) {
    	return especialidadDao.modificarEspecialidad(especialidad);
    }
    
    public boolean borrarEspecialidad(EspecialidadDTO especialidad) {
    	return especialidadDao.borrarEspecialidad(especialidad);
    }
}
