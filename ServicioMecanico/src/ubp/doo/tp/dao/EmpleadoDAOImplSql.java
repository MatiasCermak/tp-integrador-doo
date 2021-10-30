/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubp.doo.tp.dao;

import java.util.List;
import ubp.doo.tp.dto.EmpleadoDTO;
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

/**
 *
 * @author tomas
 */
public class EmpleadoDAOImplSql implements EmpleadoDAO {

    private ConexionSql conexion = null;
    
    public EmpleadoDAOImplSql(){
        conexion = ConexionSql.getInstancia();
    }
    
    @Override
    public void cerrarConexion() {
        conexion.desconectar();
    }

    @Override
    public EmpleadoDTO buscarEmpleado(int id_empleado) {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        EmpleadoDTO empleado = null;
        
        try {
            con = conexion.getConnection();
            String sql = "SELECT e.dni, dt.tipo, r.rol, e.nombre, e.apellido, e.salario "
                    + "FROM empleados e "
                    + "JOIN roles r "
                    + "ON r.id_rol = e.id_rol "
                    + "JOIN dni_tipos dt "
                    + "ON dt.id_dni_tipo = e.id_dni_tipo "
                    + "WHERE e.id_empleado = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, id_empleado);
            
            rs = sentencia.executeQuery();
            
            if (rs.next()){
                empleado = new EmpleadoDTO(id_empleado, rs.getFloat("salario"), rs.getString("rol"), 
                        rs.getString("nombre"), rs.getString("apellido"), rs.getString("tipo"), rs.getInt("dni"));
            }
        }catch(SQLException e){
            System.err.println(e);
        }finally{
            try{
                rs.close();
                sentencia.close();
            }catch(SQLException ex){
                System.err.println(ex);
            }
        }
        
        return empleado;
    }

    @Override
    public List<EmpleadoDTO> listarEmleados() {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        List<EmpleadoDTO> resultado = new ArrayList<EmpleadoDTO>();
        
        try {
            con = conexion.getConnection();
            String sql = "SELECT e.id_empleado, e.dni, dt.tipo, r.rol, e.nombre, e.apellido, e.salario "
                    + "FROM empleados e "
                    + "JOIN roles r "
                    + "ON r.id_rol = e.id_rol "
                    + "JOIN dni_tipos dt "
                    + "ON dt.id_dni_tipo = e.id_dni_tipo";
            sentencia = con.prepareStatement(sql);
            
            rs = sentencia.executeQuery();
            
            while (rs.next()){
                resultado.add(new EmpleadoDTO(rs.getInt("id_empleado"), rs.getFloat("salario"), rs.getString("rol"), 
                        rs.getString("nombre"), rs.getString("apellido"), rs.getString("tipo"), rs.getInt("dni")));
            }
            
        }catch(SQLException e){
            System.err.println(e);
        }finally{
            try{
                rs.close();
                sentencia.close();
            }catch(SQLException ex){
                System.err.println(ex);
            }
        }
        
        return resultado;
    }
    
    @Override
    public List<EmpleadoDTO> filtrarEmpleados(String filtro) {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        List<EmpleadoDTO> resultado = new ArrayList<EmpleadoDTO>();
        
        try {
            con = conexion.getConnection();
            String sql = "SELECT e.id_empleado, e.dni, dt.tipo, r.rol, e.nombre, e.apellido, e.salario "
                    + "FROM empleados e "
                    + "JOIN roles r "
                    + "ON r.id_rol = e.id_rol "
                    + "JOIN dni_tipos dt "
                    + "ON dt.id_dni_tipo = e.id_dni_tipo "
                    + "WHERE e.nombre LIKE '%"+filtro+"%' OR e.apellido LIKE '%"+filtro+"%'";
            sentencia = con.prepareStatement(sql);
            
            rs = sentencia.executeQuery();
            
            while (rs.next()){
                resultado.add(new EmpleadoDTO(rs.getInt("id_empleado"), rs.getFloat("salario"), rs.getString("rol"), 
                        rs.getString("nombre"), rs.getString("apellido"), rs.getString("tipo"), rs.getInt("dni")));
            }
            
        }catch(SQLException e){
            System.err.println(e);
        }finally{
            try{
                rs.close();
                sentencia.close();
            }catch(SQLException ex){
                System.err.println(ex);
            }
        }
        
        return resultado;
    }

    @Override
    public boolean insertarEmpleado(EmpleadoDTO empleado) {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        boolean resultado = false;
        
        try {
            con = conexion.getConnection();
            String sql = "INSERT INTO empleados (dni, id_dni_tipo, id_rol, nombre, apellido, salario) "
                    + "VALUES"
                    + "("
                    + " ?,"
                    + " (SELECT dt.id_dni_tipo FROM dni_tipos dt WHERE dt.tipo = ? ORDER BY dt.id_dni_tipo ASC LIMIT 1),"
                    + " (SELECT r.id_rol FROM roles r WHERE r.rol = ? ORDER BY r.id_rol ASC LIMIT 1),"
                    + " ?,?,?"
                    + ")";
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, empleado.getDniNumero());
            sentencia.setString(2, empleado.getDniTipo());
            sentencia.setString(3, empleado.getRol());
            sentencia.setString(4, empleado.getNombre());
            sentencia.setString(5, empleado.getApellido());
            sentencia.setFloat(6, empleado.getSalario());
            
            resultado = sentencia.executeUpdate() > 0;
            
            if (resultado){
                sql = "SELECT e.id_empleado FROM empleados e ORDER BY e.id_empleado DESC LIMIT 1";
                sentencia = con.prepareStatement(sql);
                rs = sentencia.executeQuery();
                if (rs.next()){
                    empleado.setId_empleado(rs.getInt("id_empleado"));
                }
            }
            
        }catch(SQLException e){
            System.err.println(e);
        }finally{
            try{
                rs.close();
                sentencia.close();
            }catch(SQLException ex){
                System.err.println(ex);
            }
        }
        
        return resultado;
    }

    @Override
    public boolean modificarEmpleado(EmpleadoDTO empleado) {
        Connection con = null;
        PreparedStatement sentencia = null;
        boolean resultado = false;
        
        try {
            con = conexion.getConnection();
            String sql = "UPDATE empleados e SET e.dni = ?, "
                    + "e.id_dni_tipo = (SELECT dt.id_dni_tipo FROM dni_tipos dt WHERE dt.tipo = ? ORDER BY dt.id_dni_tipo ASC LIMIT 1), "
                    + "e.id_rol = (SELECT r.id_rol FROM roles r WHERE r.rol = ? ORDER BY r.id_rol ASC LIMIT 1),"
                    + "e.nombre = ?, e.apellido = ?, e.salario = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, empleado.getDniNumero());
            sentencia.setString(2, empleado.getDniTipo());
            sentencia.setString(3, empleado.getRol());
            sentencia.setString(4, empleado.getNombre());
            sentencia.setString(5, empleado.getApellido());
            sentencia.setFloat(6, empleado.getSalario());
            
            resultado = sentencia.executeUpdate() > 0;
            
        }catch(SQLException e){
            System.err.println(e);
        }finally{
            try{
                sentencia.close();
            }catch(SQLException ex){
                System.err.println(ex);
            }
        }
        
        return resultado;
    }

    @Override
    public boolean borrarEmpleado(EmpleadoDTO empleado) {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        boolean resultado = false;
        
        try {
            con = conexion.getConnection();
            String sql = "SELECT * FROM turnos t "
                    + "JOIN agendas a "
                    + "ON t.id_agenda = a.id_agenda "
                    + "WHERE a.id_empleado = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, empleado.getId_empleado());
            
            rs = sentencia.executeQuery();
            
            if (rs.next()){
                JOptionPane.showMessageDialog(null, "Error", "No se puede eliminar el empleado dado que hay turnos asociados", JOptionPane.ERROR);
            } else {
                sql = "DELETE empleados WHERE id_empleado = ?";
                sentencia = con.prepareStatement(sql);
                sentencia.setInt(1, empleado.getId_empleado());
                
                resultado = sentencia.executeUpdate() > 0;
            }
            
        }catch(SQLException e){
            System.err.println(e);
        }finally{
            try{
                rs.close();
                sentencia.close();
            }catch(SQLException ex){
                System.err.println(ex);
            }
        }
        
        return resultado;
    }
}
