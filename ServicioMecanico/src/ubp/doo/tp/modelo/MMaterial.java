/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubp.doo.tp.modelo;

import java.util.List;

import ubp.doo.tp.dao.FabricaDAO;
import ubp.doo.tp.dao.MaterialDAO;
import ubp.doo.tp.dto.MaterialDTO;

/**
 *
 * @author bettic
 */
public class MMaterial extends Modelo {
	private final FabricaDAO fabricaDao;
    private final MaterialDAO materialDao;
    
    public MMaterial() {
        fabricaDao = FabricaDAO.getFactory("SqlFabricaDAO");
        materialDao = fabricaDao.getMaterialDao();
    }
    
    public void cerrarConexion() {
    	materialDao.cerrarConexion();
    }
    
    public MaterialDTO buscarMaterial(String nombre) {
    	MaterialDTO material = materialDao.buscarMaterial(nombre);
    	return material;
    }
    
    public MaterialDTO buscarMaterial(String nombre, String tipo) {
    	MaterialDTO material = materialDao.buscarMaterial(nombre, tipo);
    	return material;
    }
    
    public List<MaterialDTO> listarMateriales() {
    	List<MaterialDTO> materiales = materialDao.listarMateriales();
    	return materiales;
    }

    public List<MaterialDTO> listarMateriales(String filtro) {
    	List<MaterialDTO> materiales = materialDao.listarMateriales(filtro);
    	return materiales;
    }
    
    public boolean insertarMaterial(MaterialDTO material) {
    	return materialDao.insertarMaterial(material);
    }
    
    public boolean modificarMaterial(MaterialDTO material, String nombre, String tipo) {
    	return materialDao.modificarMaterial(material, nombre, tipo);
    }
    
    public boolean borrarMaterial(MaterialDTO material) {
    	return materialDao.borrarMaterial(material);
    }
}
