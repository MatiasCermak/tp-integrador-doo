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
import ubp.doo.tp.dto.ClienteDTO;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author tomas
 */
public class ClienteDAOImplSql implements ClienteDAO {
    
    private ConexionSql conexion = null;
    
    public ClienteDAOImplSql() {
        conexion = ConexionSql.getInstancia();
    }
    
    @Override
    public ClienteDTO buscarCliente(String nombre){
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        ClienteDTO cliente = null;
        
        try {
            con = conexion.getConnection();
            String sql = "select dni, nombre, tipo_dni from Clientes where nombre = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setString(1,nombre);
            
            rs = sentencia.executeQuery();
            
            String nom;
            int dni;
            String dniTipo;
            
            while(rs.next()) {
                nom = rs.getString("nombre");
                dni = rs.getInt("dni");
                dniTipo = rs.getString("tipo_dni");
                cliente = new ClienteDTO(nom,dniTipo,dni);
            }
            
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                rs.close();
                sentencia.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }
        return cliente;
    }
    
    @Override
    public ClienteDTO buscarCliente(String dniTipo,int dni){
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        ClienteDTO cliente = null;
        
        try {
            con = conexion.getConnection();
            String sql = "select dni, nombre, tipo_dni from Clientes where dni = ? and tipo_dni = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1,dni);
            sentencia.setString(2, dniTipo);
            
            rs = sentencia.executeQuery();
            
            String nom;
            int dniNum;
            String dniT;
            
            while(rs.next()) {
                nom = rs.getString("nombre");
                dniNum = rs.getInt("dni");
                dniT = rs.getString("tipo_dni");
                cliente = new ClienteDTO(nom,dniT,dniNum);
            }
            
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                rs.close();
                sentencia.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }
        
        return cliente;
    }
    
    @Override
    public List<ClienteDTO> listarClientes(String filtro){
        List<ClienteDTO> lista = new ArrayList<ClienteDTO>();
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        
        try {
            con = conexion.getConnection();
            String sql = "select dni, nombre, tipo_dni from Clientes where nombre like '%"+filtro+"%'";
            sentencia = con.prepareStatement(sql);
            
            rs = sentencia.executeQuery();
            
            String nom;
            int dni;
            String dniTipo;
            
            while(rs.next()) {
                nom = rs.getString("nombre");
                dni = rs.getInt("dni");
                dniTipo = rs.getString("tipo_dni");
                lista.add(new ClienteDTO(nom,dniTipo,dni));
            }
            
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                rs.close();
                sentencia.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }
        
        return lista;
    }
    
    @Override
    public List<ClienteDTO> listarClientes(){
        List<ClienteDTO> lista = new ArrayList<ClienteDTO>();
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        
        try {
            con = conexion.getConnection();
            String sql = "select dni, nombre, tipo_dni from Clientes order by nombre";
            sentencia = con.prepareStatement(sql);
            
            rs = sentencia.executeQuery();
            
            String nom;
            int dni;
            String dniTipo;
            
            while(rs.next()) {
                nom = rs.getString("nombre");
                dni = rs.getInt("dni");
                dniTipo = rs.getString("tipo_dni");
                lista.add(new ClienteDTO(nom,dniTipo,dni));
            }
            
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                rs.close();
                sentencia.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }
        
        return lista;
    }
    
    @Override
    public boolean insertarCliente(ClienteDTO cliente){
        Connection con = null;
        PreparedStatement sentencia = null;
        boolean result = false;
        
        try{
            con = conexion.getConnection();
            String sql = "insert into Clientes (dni,nombre,tipo_dni) values (?,?,?)";
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1,cliente.getDniNumero());
            sentencia.setString(2, cliente.getNombre());
            sentencia.setString(3, cliente.getDniTipo());
            
            int resultado = sentencia.executeUpdate();
            
            result = (resultado > 0);
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                sentencia.close();
            }catch (SQLException ex) {
                System.err.println(ex);
            }
        }
        
        return result;
    }
    
    @Override
    public boolean modificarCliente(ClienteDTO cliente){
        Connection con = null;
        PreparedStatement sentencia = null;
        boolean r = false;
        
        try {
            con = conexion.getConnection();
            String sql = "update Clientes set nombre = ?, tipo_dni = ? where dni = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setString(1,cliente.getNombre());
            sentencia.setString(2, cliente.getDniTipo());
            sentencia.setInt(3,cliente.getDniNumero());
            
            int resultado = sentencia.executeUpdate();
            
            r = (resultado > 0);
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                sentencia.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }
        
        return r;
    }
    
    @Override
    public boolean borrarCliente(ClienteDTO cliente){
        Connection con = null;
        PreparedStatement sentencia = null;
        boolean r = false;
        
        try {
            con = conexion.getConnection();
            String sql = "delete from Clientes where dni = ?, nombre = ?, tipo_dni = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, cliente.getDniNumero());
            sentencia.setString(2, cliente.getNombre());
            sentencia.setString(3, cliente.getDniTipo());
            
            int res = sentencia.executeUpdate();
            
            r = (res > 0);
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                sentencia.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }
        return r;
    }
    
    @Override
    public void cerrarConexion() {
        conexion.desconectar();
    }
}
