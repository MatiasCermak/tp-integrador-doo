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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import ubp.doo.tp.dto.AgendaDTO;
import ubp.doo.tp.dto.EmpleadoDTO;

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
    public AgendaDTO buscarAgenda(String dniTipo, int dni) {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        AgendaDTO agenda = null;
        
        try {
            con = conexion.getConnection();
            String sql = "SELECT FIRST a.hora_inicio, a.hora_fin, e.nombre, e.apellido, e.dni, dt.tipo, e.salario, r.rol "
                    + "FROM agendas a "
                    + "JOIN empleados e ON a.id_empleado = e.id_empleado "
                    + "JOIN dni_tipos dt ON e.id_dni_tipo = dt.id_dni_tipo "
                    + "JOIN roles r ON e.id_rol = r.id_rol "
                    + "WHERE e.dni = ? AND dt.tipo = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, dni);
            sentencia.setString(2, dniTipo);
            
            rs = sentencia.executeQuery();
            
            int hInicio;
            int hFin;
            String nombre, apellido, rol;
            float salario;
            
            while (rs.next()){
                hInicio = rs.getInt("hora_inicio");
                hFin = rs.getInt("hora_fin");
                nombre = rs.getString("nombre");
                apellido = rs.getString("apellido");
                rol = rs.getString("rol");
                salario = rs.getFloat("salario");
                agenda = new AgendaDTO(hInicio, hFin, new EmpleadoDTO(salario,rol, nombre, apellido, dniTipo, dni));
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
        boolean result = false;
        
        try{
            con = conexion.getConnection();
            String sql = "INSERT INTO agendas (hora_inicio, hora_fin, id_empleado)"
                    + "VALUES (?,?,"
                    + "(SELECT FIRST e.id_empleado "
                    + "FROM empleados e "
                    + "JOIN dni_tipos dt "
                    + "ON e.id_dni_tipo = dt.id_dni_tipo "
                    + "WHERE e.dni = ? AND dt.tipo = ?))";
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, agenda.getHoraInicio());
            sentencia.setInt(2, agenda.getHoraFin());
            sentencia.setInt(3, agenda.getEmpleado().getDniNumero());
            sentencia.setString(4, agenda.getEmpleado().getDniTipo());
            
            result = sentencia.executeUpdate() > 0;
        }catch (SQLException e){
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
    public boolean modificarAgenda(AgendaDTO agenda) {
        Connection con = null;
        PreparedStatement sentencia = null;
        boolean result = false;
        
        try{
            con = conexion.getConnection();
            String sql = "UPDATE agendas SET hora_inicio = ?, hora_fin = ? WHERE "
                    + "id_empleado = (SELECT FIRST e.id_empleado "
                    + "FROM empleados e "
                    + "JOIN dni_tipos dt "
                    + "ON e.id_dni_tipo = dt.id_dni_tipo "
                    + "WHERE e.dni = ? AND dt.tipo = ?)";
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, agenda.getHoraInicio());
            sentencia.setInt(2, agenda.getHoraFin());
            sentencia.setInt(3, agenda.getEmpleado().getDniNumero());
            sentencia.setString(4, agenda.getEmpleado().getDniTipo());
            
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
                    + "JOIN agenda a "
                    + "ON t.id_agenda = a.id_agenda "
                    + "WHERE a.id_empleado = (SELECT FIRST e.id_empleado "
                    + "FROM empleados e "
                    + "JOIN dni_tipos dt "
                    + "ON e.id_dni_tipo = dt.id_dni_tipo "
                    + "WHERE e.dni = ? AND dt.tipo = ?)";
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, agenda.getEmpleado().getDniNumero());
            sentencia.setString(1, agenda.getEmpleado().getDniTipo());
            
            rs = sentencia.executeQuery();
            
            if (rs.next()){
                JOptionPane.showMessageDialog(null, "Error", "No se puede eliminar la agenda ya que tiene turnos asociados", JOptionPane.ERROR_MESSAGE);
            }
            else{
                sql = "DELETE FROM agendas WHERE id_empleado = (SELECT FIRST e.id_empleado "
                    + "FROM empleados e "
                    + "JOIN dni_tipos dt "
                    + "ON e.id_dni_tipo = dt.id_dni_tipo "
                    + "WHERE e.dni = ? AND dt.tipo = ?)";
                sentencia = con.prepareStatement(sql);
                sentencia.setInt(1,agenda.getEmpleado().getDniNumero());
                sentencia.setString(2, agenda.getEmpleado().getDniTipo());
                
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
