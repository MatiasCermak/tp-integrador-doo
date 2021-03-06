/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubp.doo.tp.modelo;

import java.util.Date;
import java.util.List;
import ubp.doo.tp.dao.AgendaDAO;
import ubp.doo.tp.dao.FabricaDAO;
import ubp.doo.tp.dto.AgendaDTO;
import java.util.List;
import java.util.Date;

/**
 *
 * @author bettic
 */
public class MAgenda implements Modelo {
    private final FabricaDAO fabricaDao;
    private final AgendaDAO agendaDao;
    
    public MAgenda() {
    	fabricaDao = FabricaDAO.getFactory("SqlFabricaDAO");
    	agendaDao = fabricaDao.getAgendaDao();
    }
    

    public AgendaDTO buscarAgenda(int id_empleado) {
    	AgendaDTO agenda = agendaDao.buscarAgenda(id_empleado);
    	return agenda;
    }
    
    public boolean insertarAgenda(AgendaDTO agenda) {
    	return agendaDao.insertarAgenda(agenda);
    }
    
    public boolean modificarAgenda(AgendaDTO agenda) {
    	return agendaDao.modificarAgenda(agenda);
    }
    
    public void cerrarConexion() {
    	agendaDao.cerrarConexion();
    }
    
    
    public List<Integer> listarHorasDisponibles(int id_empleado, Date fecha){
        return agendaDao.listarHorasDisponibles(id_empleado, fecha);
    }
}
