/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubp.doo.tp.dao;

import ubp.doo.tp.dto.AgendaDTO;
import java.util.List;
import java.util.Date;
/**
 *
 * @author tomas
 */
public interface AgendaDAO {
    
    AgendaDTO buscarAgenda(int id_empleado);
    
    List<Integer> listarHorasDisponibles(int id_empleado, Date fecha);
    
    boolean insertarAgenda(AgendaDTO agenda);
    
    boolean modificarAgenda(AgendaDTO agenda);
    
    boolean eliminarAgenda(AgendaDTO agenda);
    
    void cerrarConexion();
}
