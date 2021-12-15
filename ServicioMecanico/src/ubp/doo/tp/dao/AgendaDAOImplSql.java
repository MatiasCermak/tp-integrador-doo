/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubp.doo.tp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import ubp.doo.tp.dto.AgendaDTO;

/**
 *
 * @author tomas
 */
public class AgendaDAOImplSql implements AgendaDAO{
    
    private ConexionSql conexion = null;
    
    public AgendaDAOImplSql(){
        conexion = ConexionSql.getInstancia();
    }

    @Override
    public AgendaDTO buscarAgenda(int id_empleado) {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        AgendaDTO agenda = null;
        
        try {
            con = conexion.getConnection();
            String sql = "SELECT a.id_agenda, a.hora_inicio, a.hora_fin, a.id_empleado "
                    + "FROM agendas a "
                    + "WHERE a.id_empleado = ? "
                    + "ORDER BY a.id_agenda ASC LIMIT 1";
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, id_empleado);
            
            rs = sentencia.executeQuery();
            
            int hInicio;
            int hFin;
            int id_agenda;
            
            while (rs.next()){
                hInicio = rs.getInt("hora_inicio");
                hFin = rs.getInt("hora_fin");
                id_agenda = rs.getInt("id_agenda");
                agenda = new AgendaDTO(id_agenda, hInicio, hFin, id_empleado);
            }
            
        }catch (SQLException e){
            System.err.println(e);
        }finally{
            try{
                rs.close();
                sentencia.close();
            }catch(SQLException ex){
                System.err.println(ex);
            }
        }
        
        return agenda;
    }

    @Override
    public boolean insertarAgenda(AgendaDTO agenda) {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        boolean result = false;
        
        try{
            con = conexion.getConnection();
            String sql = "INSERT INTO agendas (hora_inicio, hora_fin, id_empleado)"
                    + "VALUES (?,?,?)";
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, agenda.getHoraInicio());
            sentencia.setInt(2, agenda.getHoraFin());
            sentencia.setInt(3, agenda.getId_empleado());
            
            result = sentencia.executeUpdate() > 0;
            
            if (result){
                sql = "SELECT id_agenda FROM agendas ORDER BY id_agenda DESC LIMIT 1";
                sentencia = con.prepareStatement(sql);
                rs = sentencia.executeQuery();
                if (rs.next()){
                    agenda.setId_agenda(rs.getInt("id_agenda"));
                }
            }
        }catch (SQLException e){
            System.err.println(e);
        }finally{
            try{
                sentencia.close();
                rs.close();
            }catch (SQLException ex){
                System.err.println(ex);
            }
        }
        
        return result;
    }

    @Override
    public boolean modificarAgenda(AgendaDTO agenda) {
        Connection con = null;
        PreparedStatement sentencia = null;
        boolean result = false;
        
        try{
            con = conexion.getConnection();
            String sql = "UPDATE agendas SET hora_inicio = ?, hora_fin = ?, id_empleado "
                    + "WHERE id_agenda = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, agenda.getHoraInicio());
            sentencia.setInt(2, agenda.getHoraFin());
            sentencia.setInt(3, agenda.getId_empleado());
            sentencia.setInt(4, agenda.getId_agenda());
            
            result = sentencia.executeUpdate() > 0;
        }catch(SQLException e){
            System.err.println(e);
        }finally{
            try{
                sentencia.close();
            }catch (SQLException ex){
                System.err.println(ex);
            }
        }
        
        return result;
    }

    @Override
    public boolean eliminarAgenda(AgendaDTO agenda) {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        boolean result = false;
        
        try{
            con = conexion.getConnection();
            String sql = "SELECT * "
                    + "FROM turnos t "
                    + "JOIN agendas a "
                    + "ON t.id_agenda = a.id_agenda "
                    + "WHERE a.id_agenda = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, agenda.getId_agenda());
            
            rs = sentencia.executeQuery();
            
            if (rs.next()){
                JOptionPane.showMessageDialog(null, "Error", "No se puede eliminar la agenda ya que tiene turnos asociados", JOptionPane.ERROR_MESSAGE);
            }
            else{
                sql = "DELETE FROM agendas WHERE id_agenda = ?";
                sentencia = con.prepareStatement(sql);
                sentencia.setInt(1, agenda.getId_agenda());
                
                result = sentencia.executeUpdate() > 0;
            }
            
        }catch(SQLException e){
            System.err.println(e);
        }finally{
            try{
                sentencia.close();
                rs.close();
            }catch (SQLException ex){
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
