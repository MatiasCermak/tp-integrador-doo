/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubp.doo.tp.modelo;

import java.util.List;

import ubp.doo.tp.dao.CompSegurosDAO;
import ubp.doo.tp.dao.FabricaDAO;
import ubp.doo.tp.dto.CompSegurosDTO;

/**
 *
 * @author bettic
 */
public class MCompSeguros {
    private final FabricaDAO fabricaDao;
    private final CompSegurosDAO compSegurosDao;
    
    public MCompSeguros() {
    	fabricaDao = FabricaDAO.getFactory("SqlFabricaDAO");
    	compSegurosDao = fabricaDao.getCompSegurosDao();
    }
    
    public CompSegurosDTO buscarComp(String nombre) {
    	CompSegurosDTO compSeguros = compSegurosDao.buscarComp(nombre);
    	return compSeguros;
    }
    
    public List<CompSegurosDTO> listarComp(String filtro){
    	List<CompSegurosDTO> compSeguros = compSegurosDao.listarComp(filtro);
    	return compSeguros;
    }
    
    public List<CompSegurosDTO> listarComp(){
    	List<CompSegurosDTO> compSeguros = compSegurosDao.listarComp();
    	return compSeguros;
    }
    
    public boolean insertComp(CompSegurosDTO comp) {
    	return compSegurosDao.insertarComp(comp);
    }
    
    public boolean modificarComp(CompSegurosDTO comp) {
    	return compSegurosDao.modificarComp(comp);
    }
    
    public boolean eliminarComp(CompSegurosDTO comp) {
    	return compSegurosDao.eliminarComp(comp);
    }
    
    
    
}
