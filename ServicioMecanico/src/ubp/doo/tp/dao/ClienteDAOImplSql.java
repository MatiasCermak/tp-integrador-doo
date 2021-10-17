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
import ubp.doo.tp.dto.ClienteDTO;

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
            String sql = "select c.dni, dt.tipo, c.nombre, c.apellido "
                    + "from clientes c "
                    + "join dni_tipos dt "
                    + "on dt.id_dni_tipo = c.id_dni_tipo "
                    + "where c.nombre = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setString(1,nombre);
            
            rs = sentencia.executeQuery();
            
            String nom;
            String ape;
            int dni;
            String dniTipo;
            
            while(rs.next()) {
                nom = rs.getString("nombre");
                ape = rs.getString("apellido");
                dni = rs.getInt("dni");
                dniTipo = rs.getString("tipo");
                cliente = new ClienteDTO(nom,ape,dniTipo,dni);
                break;
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
            String sql = "select c.dni, c.nombre, c.apellido, dt.tipo "
                    + "from clientes c "
                    + "join dni_tipos dt "
                    + "on c.id_dni_tipo = dt.id_dni_tipo "
                    + "where c.dni = ? and dt.tipo = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1,dni);
            sentencia.setString(2, dniTipo);
            
            rs = sentencia.executeQuery();
            
            String nom;
            String ape;
            int dniNum;
            String dniT;
            
            while(rs.next()) {
                nom = rs.getString("nombre");
                ape = rs.getString("apellido");
                dniNum = rs.getInt("dni");
                dniT = rs.getString("tipo");
                cliente = new ClienteDTO(nom,ape,dniT,dniNum);
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
            String sql = "select c.dni, c.nombre, c.apellido, dt.tipo "
                    + "from clientes c "
                    + "join dni_tipos dt "
                    + "on dt.id_dni_tipo = c.id_dni_tipo "
                    + "where c.nombre like '%"+filtro+"%' "
                    + "order by c.nombre";
            sentencia = con.prepareStatement(sql);
            
            rs = sentencia.executeQuery();
            
            String nom;
            String ape;
            int dni;
            String dniTipo;
            
            while(rs.next()) {
                nom = rs.getString("nombre");
                ape = rs.getString("apellido");
                dni = rs.getInt("dni");
                dniTipo = rs.getString("tipo");
                lista.add(new ClienteDTO(nom,ape,dniTipo,dni));
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
            String sql = "select c.dni, c.nombre, c.apellido, dt.tipo "
                    + "from clientes c "
                    + "join dni_tipos dt "
                    + "on dt.id_dni_tipo = c.id_dni_tipo "
                    + "order by c.nombre";
            sentencia = con.prepareStatement(sql);
            
            rs = sentencia.executeQuery();
            
            String nom;
            String ape;
            int dni;
            String dniTipo;
            
            while(rs.next()) {
                nom = rs.getString("nombre");
                ape = rs.getString("apellido");
                dni = rs.getInt("dni");
                dniTipo = rs.getString("tipo");
                lista.add(new ClienteDTO(nom,ape,dniTipo,dni));
            }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                sentencia.close();
            }catch (SQLException ex) {
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
            String sql = "insert into clientes (dni,id_dni_tipo,nombre,apellido) "
                    + "values (?,"
                    + "(select dt.id_dni_tipo from dni_tipos dt where dt.tipo = ? order by dt.id_dni_tipo asc limit 1),"
                    + "?,?)";
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1,cliente.getDniNumero());
            sentencia.setString(2, cliente.getDniTipo());
            sentencia.setString(3, cliente.getNombre());
            sentencia.setString(4,cliente.getApellido());
            
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
            String sql = "update Clientes set "
                    + "nombre = ?, "
                    + "id_dni_tipo = (select dt.id_dni_tipo from dni_tipos dt where dt.tipo = ? order by dt.id_dni_tipo asc limit 1),"
                    + " apellido = ? where dni = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setString(1,cliente.getNombre());
            sentencia.setString(2, cliente.getDniTipo());
            sentencia.setInt(4,cliente.getDniNumero());
            sentencia.setString(3,cliente.getApellido());
            
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
        ResultSet rs = null;
        boolean r = false;
        
        try {
            con = conexion.getConnection();
            String sql = "SELECT * FROM turnos WHERE dni = ? AND "
                    + "id_dni_tipo = (select dt.id_dni_tipo from dni_tipos dt where dt.tipo = ? order by dt.id_dni_tipo asc limit 1)";
            sentencia.setInt(1, cliente.getDniNumero());
            sentencia.setString(2, cliente.getDniTipo());
            
            rs = sentencia.executeQuery();
            
            if (rs.next()){
                JOptionPane.showMessageDialog(null,"Error","No se puede eliminar el cliente ya que hay turnos asociados",JOptionPane.WARNING_MESSAGE);
            }
            else {
                sql = "delete from Clientes where dni = ?, "
                        + "id_dni_tipo = (select dt.id_dni_tipo from dni_tipos dt where dt.tipo = ? order by dt.id_dni_tipo asc limit 1)";
                sentencia = con.prepareStatement(sql);
                sentencia.setInt(1, cliente.getDniNumero());
                sentencia.setString(2, cliente.getDniTipo());

                int res = sentencia.executeUpdate();

                r = (res > 0);
            }
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
    
    @Override
    public List<String> listarTiposDNI(){
        List<String> lista = new ArrayList<String>();
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        
        try {
            con = conexion.getConnection();
            String sql = "SELECT tipo FROM dni_tipos";
            sentencia = con.prepareStatement(sql);
            
            rs = sentencia.executeQuery();
            
            String tipo;
            
            while(rs.next()) {
                tipo = rs.getString("tipo");
                lista.add(tipo);
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
}
