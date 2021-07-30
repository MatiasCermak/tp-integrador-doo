/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubp.doo.tp.dao;

import java.util.List;
import ubp.doo.tp.dto.EmpleadoDTO;

/**
 *
 * @author tomas
 */
public interface EmpleadoDAO {
    
    void cerrarConexion();
    
    int buscarIdRol(String rol);
    
    int buscarIdEmpleado(String nombre);
    
    EmpleadoDTO buscarEspecialidad(String empleado);
    
    List<EmpleadoDTO> listarEspecialidades();
    
    boolean insertarEspecialidad(EmpleadoDTO empleado);
    
    boolean modificarEspecialidad(EmpleadoDTO empleado);
    
    boolean borrarEspecialidad(EmpleadoDTO empleado);
}
