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
import ubp.doo.tp.dto.MaterialDTO;

/**
 *
 * @author tomas
 */
public class MaterialDAOImplSql implements MaterialDAO {
    
    private ConexionSql conexion = null;
    
    public MaterialDAOImplSql(){
        conexion = ConexionSql.getInstancia();
    }
    
    @Override
    public void cerrarConexion(){
        conexion.desconectar();
    }
    
    @Override
    public MaterialDTO buscarMaterial(String nombre){
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        MaterialDTO material = null;
        
        try {
            con = conexion.getConnection();
            String sql = "SELECT m.id_material, t.tipo_material, m.precio, m.medida " +
                         "FROM materiales m " +
                         "JOIN tipos_mat t " +
                         "ON m.id_tipo_mat = t.id_tipo_mat " +
                         "WHERE m.nombre = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setString(1, nombre);
            
            rs = sentencia.executeQuery();
            
            String nom = null;
            String tipoMat = null;
            String medida = null;
            float precio = 0;
            int id_material = 0;
            
            if(rs.next()){
                nom = rs.getString("nombre");
                tipoMat = rs.getString("tipo_material");
                precio = rs.getFloat("precio");
                medida = rs.getString("medida");
                id_material = rs.getInt("id_material");
            }
            material = new MaterialDTO(id_material,nom,tipoMat,precio,medida);
        }
        catch (SQLException e){
            System.err.println(e);
        }
        finally{
            try{
                rs.close();
                sentencia.close();
            }
            catch (SQLException ex){
                System.err.println(ex);
            }
        }
        return material;
    }
    
    @Override
    public MaterialDTO buscarMaterial(String nombre, String tipo){
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        MaterialDTO material = null;
        
        try {
            con = conexion.getConnection();
            String sql = "SELECT m.id_material, m.precio, m.medida " +
                         "FROM materiales m " +
                         "JOIN tipos_mat t " +
                         "ON m.id_tipo_mat = t.id_tipo_mat " +
                         "WHERE m.nombre = ? AND t.tipo_material = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setString(1, nombre);
            sentencia.setString(2, tipo);
            
            rs = sentencia.executeQuery();
            
            String nom = null;
            String tipoMat = null;
            String medida = null;
            float precio = 0;
            int id_material = 0;
            
            while(rs.next()){
                nom = rs.getString("nombre");
                tipoMat = rs.getString("tipo_material");
                precio = rs.getFloat("precio");
                medida = rs.getString("medida");
                id_material = rs.getInt("id_material");
            }
            material = new MaterialDTO(id_material, nom,tipoMat,precio,medida);
        }
        catch (SQLException e){
            System.err.println(e);
        }
        finally{
            try{
                rs.close();
                sentencia.close();
            }
            catch (SQLException ex){
                System.err.println(ex);
            }
        }
        return material;
    }
    
    @Override
    public List<MaterialDTO> listarMateriales(){
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        List<MaterialDTO> materiales = new ArrayList<MaterialDTO>();
        
        try {
            con = conexion.getConnection();
            String sql = "SELECT m.id_material, m.nombre, t.tipo_material, m.precio, m.medida " +
                         "FROM materiales m " +
                         "JOIN tipos_mat t " +
                         "ON m.id_tipo_mat = t.id_tipo_mat ";
            sentencia = con.prepareStatement(sql);
            
            rs = sentencia.executeQuery();
            
            String nom = null;
            String tipoMat = null;
            String medida = null;
            float precio = 0;
            int id_material = 0;
            
            while (rs.next()){
                nom = rs.getString("nombre");
                tipoMat = rs.getString("tipo_material");
                precio = rs.getFloat("precio");
                medida = rs.getString("medida");
                id_material = rs.getInt("id_material");
                
                materiales.add(new MaterialDTO(id_material, nom,tipoMat,precio,medida));
            }
        }
        catch (SQLException e){
            System.err.println(e);
        }
        finally{
            try {
                rs.close();
                sentencia.close();
            }
            catch (SQLException ex){
                System.err.println(ex);
            }
        }
        
        return materiales;
    }
    
    @Override
    public List<MaterialDTO> listarMateriales(String filtro){
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        List<MaterialDTO> materiales = new ArrayList<MaterialDTO>();
        
        try {
            con = conexion.getConnection();
            String sql = "SELECT m.id_material, m.nombre, t.tipo_material, m.precio, m.medida " +
                         "FROM materiales m " +
                         "JOIN tipos_mat t " +
                         "ON m.id_tipo_mat = t.id_tipo_mat " +
                         "WHERE m.nombre LIKE '%"+filtro+"%'";
            sentencia = con.prepareStatement(sql);
            
            rs = sentencia.executeQuery();
            
            String nom = null;
            String tipoMat = null;
            String medida = null;
            float precio = 0;
            int id_material = 0;
            
            while (rs.next()){
                nom = rs.getString("nombre");
                tipoMat = rs.getString("tipo_material");
                precio = rs.getFloat("precio");
                medida = rs.getString("medida");
                id_material = rs.getInt("id_material");
                
                materiales.add(new MaterialDTO(id_material,nom,tipoMat,precio,medida));
            }
        }
        catch (SQLException e){
            System.err.println(e);
        }
        finally {
            try{
                rs.close();
                sentencia.close();
            }
            catch (SQLException ex){
                System.err.println(ex);
            }
        }
        
        return materiales;
    }
    
    @Override
    public boolean insertarMaterial(MaterialDTO material){
        boolean result = false;
        Connection con = null;
        PreparedStatement sentencia = null;
        
        try {
            con = conexion.getConnection();
            String sql = "INSERT INTO materiales (nombre,id_tipo_mat,precio,medida) "
                       + "VALUES (?,(SELECT id_tipo_mat FROM tipos_mat WHERE tipo_material = ? LIMIT 1),?,?)";
            sentencia = con.prepareStatement(sql);
            sentencia.setString(1,material.getNombre());
            sentencia.setString(2,material.getTipo());
            sentencia.setFloat(3, material.getPrecio());
            sentencia.setString(4,material.getMedida());
            
            int r = sentencia.executeUpdate();
            
            result = (r > 0);
        }
        catch (SQLException e){
            System.err.println(e);
        }
        finally {
            try{
                sentencia.close();
            }
            catch (SQLException ex){
                System.err.println(ex);
            }
        }
        
        return result;
    }
    
    @Override
    public boolean modificarMaterial(MaterialDTO material){
        boolean result = false;
        Connection con = null;
        PreparedStatement sentencia = null;
        
        try {
            con = conexion.getConnection();
            String sql = "UPDATE TABLE materiales "
                       + "SET nombre = ?, "
                       + "id_tipo_mat = (SELECT id_tipo_mat FROM tipos_mat WHERE material = ? LIMIT 1), "
                       + "precio = ?, medida = ? "
                       + "WHERE id_material = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setString(1, material.getNombre());
            sentencia.setString(2, material.getTipo());
            sentencia.setFloat(3, material.getPrecio());
            sentencia.setString(4, material.getMedida());
            sentencia.setInt(5, material.getId_material());
            
            int r = sentencia.executeUpdate();
            
            result = (r > 0);
        }
        catch(SQLException e){
            System.err.println(e);
        }
        finally {
            try{
                sentencia.close();
            }
            catch(SQLException ex){
                System.err.println(ex);
            }
        }
        
        return result;
    }
    
    @Override
    public boolean borrarMaterial(MaterialDTO material){
        boolean result = false;
        Connection con = null;
        PreparedStatement sentencia = null;
        
        try{
            con = conexion.getConnection();
            String sql = "DELETE materiales WHERE id_material = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, material.getId_material());
            
            int r = sentencia.executeUpdate();
            
            result = (r > 0);
        }
        catch (SQLException e){
            System.err.println(e);
        }
        finally{
            try{
                sentencia.close();
            }
            catch (SQLException ex){
                System.err.println(ex);
            }
        }
        return result;
    }
}
