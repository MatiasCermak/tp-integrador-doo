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
    
    EmpleadoDTO buscarEmpleado(int id_empleado);
    
    List<EmpleadoDTO> listarEmleados();
    
    List<EmpleadoDTO> filtrarEmpleados(String filtro);
    
    boolean insertarEmpleado(EmpleadoDTO empleado);
    
    boolean modificarEmpleado(EmpleadoDTO empleado);
    
    boolean borrarEmpleado(EmpleadoDTO empleado);
}
