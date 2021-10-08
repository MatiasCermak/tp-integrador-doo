/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubp.doo.tp.dao;

import ubp.doo.tp.dto.EspecialidadDTO;
import java.util.List;

/**
 *
 * @author tomas
 */
public interface EspecialidadDAO {
    
    void cerrarConexion();
    
    EspecialidadDTO buscarEspecialidad(String especialidad);
    
    List<EspecialidadDTO> listarEspecialidades();
    
    boolean insertarEspecialidad(EspecialidadDTO especialidad);
    
    boolean modificarEspecialidad(EspecialidadDTO especialidad, String ex_esp);
    
    boolean borrarEspecialidad(EspecialidadDTO especialidad);
}
