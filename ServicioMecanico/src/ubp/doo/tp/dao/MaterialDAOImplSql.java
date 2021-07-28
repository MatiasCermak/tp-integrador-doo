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
        this.conexion = ConexionSql.getInstancia();
    }

    @Override
    public void cerrarConexion() {
        this.conexion.desconectar();
    }

    @Override
    public String buscarTipoMat(int id){
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        String tMaterial = null;
        
        try{
            con = conexion.getConnection();
            String sql = "SELECT tipo_material FROM tipos_mat WHERE id_tipo_mat = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, id);
            
            rs = sentencia.executeQuery();
            
            while (rs.next()){
                tMaterial = rs.getString("tipo_material");
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
        
        return tMaterial;
    }
    
    @Override
    public int buscarIdTipoMat(String nombre){
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        int id = -1;
        
        try {
            con = conexion.getConnection();
            String sql = "SELECT id_tipo_mat FROM tipos_mat WHERE tipo_material = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setString(1,nombre);
            
            rs = sentencia.executeQuery();
            
            while (rs.next()){
                id = rs.getInt("id_tipo_mat");
                break;
            }
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
        
        return id;
    }
    
    @Override
    public int buscarIdMaterial(String nombre){
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        int idM = -1;
        
        try{
            con = conexion.getConnection();
            String sql = "SELECT id_material FROM materiales WHERE nombre = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setString(1, nombre);
            
            rs = sentencia.executeQuery();
            
            while (rs.next()){
                idM = rs.getInt("id_material");
                break;
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
        
        return idM;
    }
    
    @Override
    public MaterialDTO buscarMaterial(String nombre) {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        MaterialDTO material = null;
        
        try {
            con = conexion.getConnection();
            String sql = "SELECT * FROM materiales WHERE nombre = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setString(1,nombre);
            
            rs = sentencia.executeQuery();
            
            String nom;
            String tipo;
            String medida;
            float precio;
            int tipoM;
            
            while (rs.next()){
                nom = rs.getString("nombre");
                tipoM = rs.getInt("id_tipo_mat");
                medida = rs.getString("medida");
                precio = rs.getFloat("precio");
                
                tipo = buscarTipoMat(tipoM);
                
                material = new MaterialDTO(nom,tipo,precio,medida);
                break;
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
        
        return material;
    }

    @Override
    public List<MaterialDTO> listarMateriales() {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        List<MaterialDTO> lista = new ArrayList<MaterialDTO>();
        
        try{
            con = conexion.getConnection();
            String sql = "SELECT * FROM materiales";
            sentencia = con.prepareStatement(sql);
            
            rs = sentencia.executeQuery();
            
            String nom;
            String tipo;
            String medida;
            float precio;
            int tipoM;
            
            while (rs.next()){
                nom = rs.getString("nombre");
                tipoM = rs.getInt("id_tipo_mat");
                medida = rs.getString("medida");
                precio = rs.getFloat("precio");
                
                tipo = buscarTipoMat(tipoM);
                
                lista.add(new MaterialDTO(nom,tipo,precio,medida));
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
        
        return lista;
    }

    @Override
    public boolean insertarMaterial(MaterialDTO material) {
        Connection con = null;
        PreparedStatement sentencia = null;
        boolean r = false;
        
        try {
            int idTipo = buscarIdTipoMat(material.getTipo());
            if (idTipo > 0){
                con = conexion.getConnection();
                String sql = "INSERT INTO materiales (nombre,id_tipo_mat,precio,medida) VALUES ('"+material.getNombre()+"'"
                        + ",'"+idTipo+"','"+material.getPrecio()+"','"+material.getMedida()+"')";
                sentencia = con.prepareStatement(sql);
                
                int result = sentencia.executeUpdate();
                
                r = (result > 0);
            }
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
        return r;
    }

    @Override
    public boolean modificarMaterial(MaterialDTO material, String exNombre) {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        boolean r = false;
        
        try {
            int idTipo = buscarIdTipoMat(material.getTipo());
            if (idTipo > 0){
                con = conexion.getConnection();
                int id = buscarIdMaterial(exNombre);
                String sql = "SELECT * FROM detalles WHERE id_material = ?";
                sentencia = con.prepareStatement(sql);
                sentencia.setInt(1,id);
                
                rs = sentencia.executeQuery();
                
                int cant = 0;
                while(rs.next()){
                    cant++;
                }
                
                int opc = 0;
                if (cant > 0){
                    opc = JOptionPane.showConfirmDialog(null,"Warning","Hay detalles asociados al material que está intentando modificar.\nDesea continuar?",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
                }
                
                if (opc == 0){
                    sql = "UPDATE materiales SET nombre = ?, id_tipo_mat = ?, precio = ?, medida = ? WHERE id_material = ?";
                    sentencia = con.prepareStatement(sql);
                    sentencia.setString(1,material.getNombre());
                    sentencia.setInt(2, buscarIdTipoMat(material.getTipo()));
                    sentencia.setFloat(3, material.getPrecio());
                    sentencia.setString(4, material.getMedida());
                    sentencia.setInt(5, id);
                    
                    int result = sentencia.executeUpdate();
                
                    r = (result > 0);
                }
                
            }
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
        return r;
    }

    @Override
    public boolean borrarMaterial(MaterialDTO material) {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        boolean r = false;
        
        try {
            int idTipo = buscarIdTipoMat(material.getTipo());
            if (idTipo > 0){
                con = conexion.getConnection();
                int id = buscarIdMaterial(material.getNombre());
                String sql = "SELECT * FROM detalles WHERE id_material = ?";
                sentencia = con.prepareStatement(sql);
                sentencia.setInt(1,id);
                
                rs = sentencia.executeQuery();
                
                int cant = 0;
                while(rs.next()){
                    cant++;
                }
                
                if (cant > 0){
                    JOptionPane.showMessageDialog(null,"Error","No puede eliminar el material ya que hay detalles asociados al mismo",JOptionPane.ERROR_MESSAGE);
                }
                else {
                    sql = "DELETE materiales WHERE id_material = ?";
                    sentencia = con.prepareStatement(sql);
                    sentencia.setInt(1, id);
                    
                    int result = sentencia.executeUpdate();
                
                    r = (result > 0);
                }
                
            }
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
        return r;
    }
    
}
