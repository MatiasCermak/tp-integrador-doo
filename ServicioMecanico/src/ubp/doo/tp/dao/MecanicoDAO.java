/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubp.doo.tp.dao;

import ubp.doo.tp.dto.MecanicoDTO;
import java.util.List;

/**
 *
 * @author tomas
 */
public interface MecanicoDAO {
    
    MecanicoDTO buscarMecanico(int id_empleado);
    
    MecanicoDTO buscarMecanico(int dni, String dni_tipo);
    
    MecanicoDTO buscarMecanico(String nombre, String apellido);
    
    List<MecanicoDTO> listarMecanicos();
    
    List<MecanicoDTO> listarMecanicos(String filtro);
    
    List<MecanicoDTO> listarMecanicos(int id_especialidad);
    
    boolean insertarMecanico (MecanicoDTO mecanico);
    
    boolean modificarMecanico (MecanicoDTO mecanico);
    
    boolean eliminarMecanico (MecanicoDTO mecanico);
    
    void cerrarConexión();
}
