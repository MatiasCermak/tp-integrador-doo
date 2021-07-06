/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubp.doo.tp.dao;

import java.util.List;
import ubp.doo.tp.dto.MaterialDTO;

/**
 *
 * @author tomas
 */
public interface MaterialDAO {
    
    void cerrarConexion();
    
    MaterialDTO buscarMaterial(String nombre);
    
    List<MaterialDTO> listarMateriales();
    
    String buscarTipoMat(int id);
    
    int buscarIdTipoMat(String nombre);
    
    int buscarIdMaterial(String nombre);
    
    boolean insertarMaterial(MaterialDTO material);
    
    boolean modificarMaterial(MaterialDTO material, String exNombre);
    
    boolean borrarMaterial(MaterialDTO material);
}
