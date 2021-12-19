/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubp.doo.tp.dao;

import java.util.List;
import ubp.doo.tp.dto.MecanicoDTO;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author tomas
 */
public class MecanicoDAOImplSql implements MecanicoDAO {
    
    private ConexionSql conexion = null;

    @Override
    public MecanicoDTO buscarMecanico(int id_empleado) {
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        Connection con = null;
        MecanicoDTO mecanico = null;
        
        try {
            con = conexion.getConnection();
            String sql = "SELECT m.id_especialidad, m.costo_hora, "
                    + "e.salario, r.rol, e.nombre, e.apellido, dt.tipo, e.dni "
                    + "FROM mecanicos m "
                    + "JOIN empleados e ON e.id_empleado = m.id_empleado "
                    + "JOIN roles r ON e.id_rol = r.id_rol "
                    + "JOIN dni_tipos dt ON e.id_dni_tipo = dt.id_dni_tipo "
                    + "WHERE m.id_empleado = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, id_empleado);
            
            rs = sentencia.executeQuery();
            
            if (rs.next()){
                mecanico = new MecanicoDTO(rs.getInt("id_especialidad"), 
                        rs.getFloat("costo_hora"), id_empleado, 
                        rs.getFloat("salario"), rs.getString("rol"),
                        rs.getString("nombre"), rs.getString("apellido"),
                        rs.getString("tipo"), rs.getInt("dni"));
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
        
        return mecanico;
    }

    @Override
    public MecanicoDTO buscarMecanico(int dni, String dni_tipo) {
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        Connection con = null;
        MecanicoDTO mecanico = null;
        
        try {
            con = conexion.getConnection();
            String sql = "SELECT m.id_empleado, m.id_especialidad, m.costo_hora, "
                    + "e.salario, r.rol, e.nombre, e.apellido "
                    + "FROM mecanicos m "
                    + "JOIN empleados e ON e.id_empleado = m.id_empleado "
                    + "JOIN roles r ON e.id_rol = r.id_rol "
                    + "JOIN dni_tipos dt ON e.id_dni_tipo = dt.id_dni_tipo "
                    + "WHERE e.dni = ? AND dt.tipo = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, dni);
            sentencia.setString(2, dni_tipo);
            
            rs = sentencia.executeQuery();
            
            if (rs.next()){
                mecanico = new MecanicoDTO(rs.getInt("id_especialidad"), 
                        rs.getFloat("costo_hora"), rs.getInt("id_empleado"), 
                        rs.getFloat("salario"), rs.getString("rol"),
                        rs.getString("nombre"), rs.getString("apellido"),
                        dni_tipo, dni);
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
        
        return mecanico;
    }

    @Override
    public MecanicoDTO buscarMecanico(String nombre, String apellido) {
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        Connection con = null;
        MecanicoDTO mecanico = null;
        
        try {
            con = conexion.getConnection();
            String sql = "SELECT m.id_empleado, m.id_especialidad, m.costo_hora, "
                    + "e.salario, r.rol, dt.tipo, e.dni "
                    + "FROM mecanicos m "
                    + "JOIN empleados e ON e.id_empleado = m.id_empleado "
                    + "JOIN roles r ON e.id_rol = r.id_rol "
                    + "JOIN dni_tipos dt ON e.id_dni_tipo = dt.id_dni_tipo "
                    + "WHERE e.nombre = ? AND e.apellido = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setString(1, nombre);
            sentencia.setString(2, apellido);
            
            rs = sentencia.executeQuery();
            
            if (rs.next()){
                mecanico = new MecanicoDTO(rs.getInt("id_especialidad"), 
                        rs.getFloat("costo_hora"), rs.getInt("id_empleado"), 
                        rs.getFloat("salario"), rs.getString("rol"),
                        nombre, apellido,
                        rs.getString("tipo"), rs.getInt("dni"));
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
        
        return mecanico;
    }

    @Override
    public List<MecanicoDTO> listarMecanicos() {
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        Connection con = null;
        List<MecanicoDTO> mecanicos = new ArrayList<MecanicoDTO>();
        
        try {
            con = conexion.getConnection();
            String sql = "SELECT m.id_empleado, m.id_especialidad, m.costo_hora, "
                    + "e.salario, r.rol, dt.tipo, e.dni, e.nombre, e.apellido "
                    + "FROM mecanicos m "
                    + "JOIN empleados e ON e.id_empleado = m.id_empleado "
                    + "JOIN roles r ON e.id_rol = r.id_rol "
                    + "JOIN dni_tipos dt ON e.id_dni_tipo = dt.id_dni_tipo";
            sentencia = con.prepareStatement(sql);
            
            rs = sentencia.executeQuery();
            
            while (rs.next()){
                mecanicos.add(new MecanicoDTO(rs.getInt("id_especialidad"), 
                        rs.getFloat("costo_hora"), rs.getInt("id_empleado"), 
                        rs.getFloat("salario"), rs.getString("rol"),
                        rs.getString("nombre"), rs.getString("apellido"),
                        rs.getString("tipo"), rs.getInt("dni")));
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
        return mecanicos;
    }

    @Override
    public List<MecanicoDTO> listarMecanicos(String filtro) {
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        Connection con = null;
        List<MecanicoDTO> mecanicos = new ArrayList<MecanicoDTO>();
        
        try {
            con = conexion.getConnection();
            String sql = "SELECT m.id_empleado, m.id_especialidad, m.costo_hora, "
                    + "e.salario, r.rol, dt.tipo, e.dni, e.nombre, e.apellido "
                    + "FROM mecanicos m "
                    + "JOIN empleados e ON e.id_empleado = m.id_empleado "
                    + "JOIN roles r ON e.id_rol = r.id_rol "
                    + "JOIN dni_tipos dt ON e.id_dni_tipo = dt.id_dni_tipo "
                    + "WHERE e.nombre LIKE '%"+filtro+"%' OR "
                          + "e.apellido LIKE '%"+filtro+"%'";
            sentencia = con.prepareStatement(sql);
            
            rs = sentencia.executeQuery();
            
            while (rs.next()){
                mecanicos.add(new MecanicoDTO(rs.getInt("id_especialidad"), 
                        rs.getFloat("costo_hora"), rs.getInt("id_empleado"), 
                        rs.getFloat("salario"), rs.getString("rol"),
                        rs.getString("nombre"), rs.getString("apellido"),
                        rs.getString("tipo"), rs.getInt("dni")));
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
        return mecanicos;
    }

    @Override
    public List<MecanicoDTO> listarMecanicos(int id_especialidad) {
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        Connection con = null;
        List<MecanicoDTO> mecanicos = new ArrayList<MecanicoDTO>();
        
        try {
            con = conexion.getConnection();
            String sql = "SELECT m.id_empleado, m.costo_hora, "
                    + "e.salario, r.rol, dt.tipo, e.dni, e.nombre, e.apellido "
                    + "FROM mecanicos m "
                    + "JOIN empleados e ON e.id_empleado = m.id_empleado "
                    + "JOIN roles r ON e.id_rol = r.id_rol "
                    + "JOIN dni_tipos dt ON e.id_dni_tipo = dt.id_dni_tipo "
                    + "WHERE m.id_especialidad = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, id_especialidad);
            
            rs = sentencia.executeQuery();
            
            while (rs.next()){
                mecanicos.add(new MecanicoDTO(id_especialidad, 
                        rs.getFloat("costo_hora"), rs.getInt("id_empleado"), 
                        rs.getFloat("salario"), rs.getString("rol"),
                        rs.getString("nombre"), rs.getString("apellido"),
                        rs.getString("tipo"), rs.getInt("dni")));
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
        return mecanicos;
    }

    @Override
    public boolean insertarMecanico(MecanicoDTO mecanico) {
        PreparedStatement sentencia = null;
        Connection con = null;
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
            sentencia.setInt(1, mecanico.getDniNumero());
            sentencia.setString(2, mecanico.getDniTipo());
            sentencia.setString(3, mecanico.getRol());
            sentencia.setString(4, mecanico.getNombre());
            sentencia.setString(5, mecanico.getApellido());
            sentencia.setFloat(6, mecanico.getSalario());
            
            resultado = sentencia.executeUpdate() > 0;
            
            if (resultado){
                sql = "SELECT e.id_empleado FROM empleados e ORDER BY e.id_empleado DESC LIMIT 1";
                sentencia = con.prepareStatement(sql);
                rs = sentencia.executeQuery();
                if (rs.next()){
                    mecanico.setId_empleado(rs.getInt("id_empleado"));
                }
                
                sql = "INSERT INTO mecanicos (id_empleado, id_especialidad, costo_hora "
                        + "VALUES (?,?,?)";
                sentencia = con.prepareStatement(sql);
                sentencia.setInt(1,mecanico.getId_empleado());
                sentencia.setInt(2, mecanico.getId_especialidad());
                sentencia.setFloat(3, mecanico.getCostoHora());
                
                resultado = sentencia.executeUpdate() > 0;
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
        
        return resultado;
    }

    @Override
    public boolean modificarMecanico(MecanicoDTO mecanico) {
        PreparedStatement sentencia = null;
        Connection con = null;
        boolean resultado = false;
        
        try {
            con = conexion.getConnection();
            String sql = "UPDATE mecanicos SET "
                    + "id_especialidad = ?, costo_hora = ? "
                    + "WHERE id_empleado = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, mecanico.getId_especialidad());
            sentencia.setFloat(2, mecanico.getCostoHora());
            sentencia.setInt(3, mecanico.getId_empleado());
            
            resultado = sentencia.executeUpdate() > 0;
            
            if (resultado){
                sql = "UPDATE empleados SET "
                        + "id_rol = (SELECT r.id_rol FROM roles r WHERE r.rol = ? LIMIT 1),"
                        + "nombre = ?, apellido = ?, salario = ? "
                        + "WHERE id_empleado = ?";
                sentencia = con.prepareStatement(sql);
                sentencia.setString(1, mecanico.getRol());
                sentencia.setString(2, mecanico.getNombre());
                sentencia.setString(3, mecanico.getApellido());
                sentencia.setFloat(4, mecanico.getSalario());
                sentencia.setInt(5, mecanico.getId_empleado());
                
                resultado = sentencia.executeUpdate() > 0;
            }
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
    public boolean eliminarMecanico(MecanicoDTO mecanico) {
        PreparedStatement sentencia = null;
        Connection con = null;
        ResultSet rs = null;
        boolean resultado = false;
        
        try {
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
        
        return resultado;
    }

    @Override
    public void cerrarConexión() {
        conexion.desconectar();
    }
    
}
