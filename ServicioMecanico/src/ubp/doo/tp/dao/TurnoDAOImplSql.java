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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        Connection con = null;
        TurnoDTO turno = null;
        
        try{
            con = conexion.getConnection();
            String sql = "SELECT t.id_turno, t.dni, dt.tipo, t.matricula, "
                    + "t.estado, t.asistencia "
                    + "FROM turnos t "
                    + "JOIN dni_tipos dt "
                    + "ON t.id_dni_tipo = dt.id_dni_tipo "
                    + "WHERE t.id_agenda = ? AND t.fecha = ? AND t.hora = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, id_agenda);
            sentencia.setString(2, new java.sql.Date(fecha.getTime()).toString());
            sentencia.setInt(3, hora);
            
            rs = sentencia.executeQuery();
            
            if (rs.next()){
                turno = new TurnoDTO(rs.getInt("id_turno"),rs.getInt("dni"),
                    rs.getString("tipo"),rs.getString("matricula"), fecha, hora,
                    rs.getInt("estado"), rs.getInt("asistencia"), id_agenda);
            }
            
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
        
        return turno;
    }

    @Override
    public List<TurnoDTO> listarTurnos(Date fecha) {
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        Connection con = null;
        List<TurnoDTO> turnos = new ArrayList<TurnoDTO>();
        
        try{
            con = conexion.getConnection();
            String sql = "SELECT t.id_turno, t.dni, dt.tipo, t.matricula, "
                    + "t.estado, t.asistencia, t.hora, t.id_agenda "
                    + "FROM turnos t "
                    + "JOIN dni_tipos dt "
                    + "ON t.id_dni_tipo = dt.id_dni_tipo "
                    + "WHERE t.fecha = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setString(1, new java.sql.Date(fecha.getTime()).toString());
            
            rs = sentencia.executeQuery();
            
            while (rs.next()){
                turnos.add(new TurnoDTO(rs.getInt("id_turno"),rs.getInt("dni"),
                    rs.getString("tipo"),rs.getString("matricula"), fecha, rs.getInt("hora"),
                    rs.getInt("estado"), rs.getInt("asistencia"), rs.getInt("id_agenda")));
            }
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
        
        return turnos;
    }

    @Override
    public List<TurnoDTO> listarTurnos(int id_agenda){
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        Connection con = null;
        List<TurnoDTO> turnos = new ArrayList<TurnoDTO>();
        
        try{
            con = conexion.getConnection();
            String sql = "SELECT t.id_turno, t.dni, dt.tipo, t.matricula, "
                    + "t.estado, t.asistencia, t.fecha, t.hora "
                    + "FROM turnos t "
                    + "JOIN dni_tipos dt "
                    + "ON t.id_dni_tipo = dt.id_dni_tipo "
                    + "WHERE t.id_agenda = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, id_agenda);
            
            rs = sentencia.executeQuery();
            
            while (rs.next()){
                turnos.add(new TurnoDTO(rs.getInt("id_turno"),rs.getInt("dni"),
                    rs.getString("tipo"),rs.getString("matricula"),  
                    new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("fecha")), rs.getInt("hora"), rs.getInt("estado"), 
                    rs.getInt("asistencia"), id_agenda));
            }
        }catch(SQLException e){
            System.err.println(e);
        } catch (ParseException ex) {
            Logger.getLogger(TurnoDAOImplSql.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
                sentencia.close();
                rs.close();
            }catch(SQLException ex){
                System.err.println(ex);
            }
        }
        
        return turnos;
    }

    @Override
    public List<TurnoDTO> listarTurnos(int id_agenda, Date fecha) {
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        Connection con = null;
        List<TurnoDTO> turnos = new ArrayList<TurnoDTO>();
        
        try{
            con = conexion.getConnection();
            String sql = "SELECT t.id_turno, t.dni, dt.tipo, t.matricula, "
                    + "t.estado, t.asistencia, t.hora "
                    + "FROM turnos t "
                    + "JOIN dni_tipos dt "
                    + "ON t.id_dni_tipo = dt.id_dni_tipo "
                    + "WHERE t.id_agenda = ? AND t.fecha = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, id_agenda);
            sentencia.setString(2, new java.sql.Date(fecha.getTime()).toString());
            
            rs = sentencia.executeQuery();
            
            while (rs.next()){
                turnos.add(new TurnoDTO(rs.getInt("id_turno"),rs.getInt("dni"),
                    rs.getString("tipo"),rs.getString("matricula"), fecha, rs.getInt("hora"),
                    rs.getInt("estado"), rs.getInt("asistencia"), id_agenda));
            }
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
        
        return turnos;
    }

    @Override
    public List<TurnoDTO> listarTurnos(Date fecha, int hora) {
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        Connection con = null;
        List<TurnoDTO> turnos = new ArrayList<TurnoDTO>();
        
        try{
            con = conexion.getConnection();
            String sql = "SELECT t.id_turno, t.dni, dt.tipo, t.matricula, "
                    + "t.estado, t.asistencia, t.id_agenda "
                    + "FROM turnos t "
                    + "JOIN dni_tipos dt "
                    + "ON t.id_dni_tipo = dt.id_dni_tipo "
                    + "WHERE t.fecha = ? AND t.hora = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setString(1, new java.sql.Date(fecha.getTime()).toString());
            sentencia.setInt(2, hora);
            
            rs = sentencia.executeQuery();
            
            while (rs.next()){
                turnos.add(new TurnoDTO(rs.getInt("id_turno"),rs.getInt("dni"),
                    rs.getString("tipo"),rs.getString("matricula"), fecha, hora,
                    rs.getInt("estado"), rs.getInt("asistencia"), rs.getInt("id_agenda")));
            }
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
        
        return turnos;
    }
    
    @Override
    public List<TurnoDTO> listarTurnos(){
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        Connection con = null;
        List<TurnoDTO> turnos = new ArrayList<TurnoDTO>();
        
        try{
            con = conexion.getConnection();
            String sql = "SELECT t.id_turno, t.dni, dt.tipo, t.matricula, "
                    + "t.estado, t.asistencia, t.id_agenda, t.fecha, t.hora "
                    + "FROM turnos t "
                    + "JOIN dni_tipos dt "
                    + "ON t.id_dni_tipo = dt.id_dni_tipo";
            sentencia = con.prepareStatement(sql);
            
            rs = sentencia.executeQuery();
            
            while (rs.next()){
                turnos.add(new TurnoDTO(rs.getInt("id_turno"),rs.getInt("dni"),
                    rs.getString("tipo"),rs.getString("matricula"), 
                    new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("fecha")), rs.getInt("hora"), rs.getInt("estado"),
                    rs.getInt("asistencia"), rs.getInt("id_agenda")));
            }
        }catch(SQLException e){
            System.err.println(e);
        } catch (ParseException ex) {
            Logger.getLogger(TurnoDAOImplSql.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
                sentencia.close();
                rs.close();
            }catch(SQLException ex){
                System.err.println(ex);
            }
        }
        return turnos;
    }

    @Override
    public boolean insertarTurno(TurnoDTO turno) {
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        Connection con = null;
        boolean result = false;
        
        try{
            con = conexion.getConnection();
            String sql = "INSERT INTO turnos (dni, id_dni_tipo, matricula, fecha,"
                    + "hora, estado, asistencia, id_agenda) VALUES "
                    + "(?,"
                    + "(SELECT dt.id_dni_tipo FROM dni_tipos dt WHERE dt.tipo = ? LIMIT 1),"
                    + "?,?,?,1,0,?)";
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, turno.getCliente_dni());
            sentencia.setString(2, turno.getCliente_dniTipo());
            sentencia.setString(3, turno.getMatricula_vehiculo());
            sentencia.setString(4, new java.sql.Date(turno.getFecha().getTime()).toString());
            sentencia.setInt(5, turno.getHora());
            sentencia.setInt(6, turno.getId_agenda());
            
            result = sentencia.executeUpdate() > 0;
            
            if (result){
                sql = "SELECT id_turno FROM turnos ORDER BY id_turno DESC LIMIT 1";
                sentencia = con.prepareStatement(sql);
                
                rs = sentencia.executeQuery();
                if (rs.next()){
                    turno.setId_turno(rs.getInt("id_turno"));
                }
            }
            
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
        PreparedStatement sentencia = null;
        Connection con = null;
        boolean result = false;
        
        try{
            con = conexion.getConnection();
            String sql = "UPDATE turnos SET "
                    + "dni = ?, "
                    + "id_dni_tipo = (SELECT dt.id_dni_tipo FROM dni_tipos dt WHERE dt.tipo = ? LIMIT 1), "
                    + "matricula = ?, fecha = ?, "
                    + "hora = ?, estado = ?, asistencia = ?, id_agenda = ? "
                    + "WHERE id_turno = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, turno.getCliente_dni());
            sentencia.setString(2, turno.getCliente_dniTipo());
            sentencia.setString(3, turno.getMatricula_vehiculo());
            sentencia.setString(4, new java.sql.Date(turno.getFecha().getTime()).toString());
            sentencia.setInt(5, turno.getHora());
            sentencia.setInt(6, turno.getEstado());
            sentencia.setInt(7, turno.getAsistencia());
            sentencia.setInt(8, turno.getId_agenda());
            sentencia.setInt(9, turno.getId_turno());
            
            result = sentencia.executeUpdate() > 0;
            
        }catch(SQLException e){
            System.err.println(e);
        }finally{
            try{
                sentencia.close();
            }catch(SQLException ex){
                System.err.println(ex);
            }
        }
        
        return result;
    }

    @Override
    public boolean eliminarTurno(TurnoDTO turno) {
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        Connection con = null;
        boolean result = false;
        try{
            con = conexion.getConnection();
            String sql = "SELECT id_ficha FROM fichas WHERE id_turno = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, turno.getId_turno());
            
            rs = sentencia.executeQuery();
            
            if (rs.next()){
                JOptionPane.showMessageDialog(null,"No se puede eliminar un turno que ya tiene fichas asociadas",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
                sql = "DELETE FROM turnos WHERE id_turno = ?";
                sentencia = con.prepareStatement(sql);
                sentencia.setInt(1, turno.getId_turno());
                
                result = sentencia.executeUpdate() > 0;
            }
            
        }catch(SQLException e){
            System.err.println(e);
        }finally{
            try{
                sentencia.close();
                if (rs!=null)
                    rs.close();
            }catch(SQLException ex){
                System.err.println(ex);
            }
        }
        
        return result;
    }

    @Override
    public void cerrarConexion() {
        conexion.desconectar();
    }
    
}
