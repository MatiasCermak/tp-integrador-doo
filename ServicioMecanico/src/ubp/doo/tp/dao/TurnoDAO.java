/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubp.doo.tp.dao;
import java.text.ParseException;
import ubp.doo.tp.dto.TurnoDTO;
import java.util.List;
import java.util.Date;

/**
 *
 * @author tomas
 */
public interface TurnoDAO {
    
    TurnoDTO buscarTurno(int id_agenda, Date fecha, int hora);
    
    List<TurnoDTO> listarTurnos(Date fecha);
    
    List<TurnoDTO> listarTurnos(int id_agenda);
    
    List<TurnoDTO> listarTurnos(int id_agenda, Date fecha);
    
    List<TurnoDTO> listarTurnos(Date fecha, int hora);
    
    List<TurnoDTO> listarTurnos();
    
    boolean insertarTurno(TurnoDTO turno);
    
    boolean modificarTurno(TurnoDTO turno);
    
    boolean eliminarTurno(TurnoDTO turno);
    
    void cerrarConexion();
    
}
