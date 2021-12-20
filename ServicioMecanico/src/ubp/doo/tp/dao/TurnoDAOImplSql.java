/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubp.doo.tp.dao;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import ubp.doo.tp.dto.TurnoDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author tomas
 */
public class TurnoDAOImplSql implements TurnoDAO {
    
    private ConexionSql conexion = null;
    
    public TurnoDAOImplSql(){
        conexion = ConexionSql.getInstancia();
    }

    @Override
    public TurnoDTO buscarTurno(int id_agenda, Date fecha, int hora) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TurnoDTO> listarTurnos(Date fecha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TurnoDTO> listarTurnos(int id_agenda) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TurnoDTO> listarTurnos(int id_agenda, Date fecha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TurnoDTO> listarTurnos(Date fecha, int hora) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TurnoDTO> listarTurnos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insertarTurno(TurnoDTO turno) {
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        Connection con = null;
        boolean result = false;
        
        try{
            con = conexion.getConnection();
            String sql = "";
            sentencia = con.prepareStatement(sql);
            
        }catch(SQLException e){
            System.err.println(e);
        }finally{
            try{
                sentencia.close();
                rs.close();
            }catch(SQLException ex){
                System.err.println(ex);
            }
        }
        
        return result;
    }

    @Override
    public boolean modificarTurno(TurnoDTO turno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarTurno(TurnoDTO turno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cerrarConexion() {
        conexion.desconectar();
    }
    
}
