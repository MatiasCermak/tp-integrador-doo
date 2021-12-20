/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubp.doo.tp.modelo;

import java.util.Date;
import java.util.List;
import ubp.doo.tp.dao.FabricaDAO;
import ubp.doo.tp.dao.TurnoDAO;
import ubp.doo.tp.dto.TurnoDTO;

/**
 *
 * @author bettic
 */
public class MTurno implements Modelo {
	private final FabricaDAO fabricaDao;
    private final TurnoDAO turnoDao;
    
    public MTurno() {
    	fabricaDao = FabricaDAO.getFactory("SqlFabricaDAO");
    	turnoDao = fabricaDao.getTurnoDao();
    }
    
    public TurnoDTO buscarTurno(int id_agenda, Date fecha, int hora){
        return turnoDao.buscarTurno(id_agenda, fecha, hora);
    }
    
    public List<TurnoDTO> listarTurnos(Date fecha){
        return turnoDao.listarTurnos(fecha);
    }
    
    public List<TurnoDTO> listarTurnos(int id_agenda){
        return turnoDao.listarTurnos(id_agenda);
    }
    
    public List<TurnoDTO> listarTurnos(int id_agenda, Date fecha){
        return turnoDao.listarTurnos(id_agenda, fecha);
    }
    
    public List<TurnoDTO> listarTurnos(Date fecha, int hora){
        return turnoDao.listarTurnos(fecha, hora);
    }
    
    public List<TurnoDTO> listarTurnos(){
        return turnoDao.listarTurnos();
    }
    
    public boolean insertarTurno(TurnoDTO turno){
        return turnoDao.insertarTurno(turno);
    }
    
    public boolean modificarTurno(TurnoDTO turno){
        return turnoDao.modificarTurno(turno);
    }
    
    public boolean eliminarTurno(TurnoDTO turno){
        return turnoDao.eliminarTurno(turno);
    }
}
