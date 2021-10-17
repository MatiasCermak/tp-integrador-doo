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
import ubp.doo.tp.dto.CompSegurosDTO;

/**
 *
 * @author tomas
 */
public class CompSegurosDAOImplSql implements CompSegurosDAO{

    private ConexionSql conexion = null;
    
    public void CompSegurosDAO(){
        conexion = ConexionSql.getInstancia();
    }
    
    @Override
    public CompSegurosDTO buscarComp(String nombre) {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        CompSegurosDTO compania = null;
        
        try {
            con = conexion.getConnection();
            String sql = "SELECT id_comp_seguro, nombre FROM comp_seguros WHERE nombre = ? ORDER BY id_comp_seguro ASC LIMIT 1";
            sentencia = con.prepareStatement(sql);
            sentencia.setString(1, nombre);
            
            rs = sentencia.executeQuery();
            
            if (rs.next()){
                compania = new CompSegurosDTO(rs.getInt("id_comp_seguro"), nombre);
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
        
        return compania;
    }

    @Override
    public List<CompSegurosDTO> listarComp(String filtro) {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        List<CompSegurosDTO> companias = new ArrayList<CompSegurosDTO>();
        
        try{
            con = conexion.getConnection();
            String sql = "SELECT c.id_comp_seguro, c.nombre "
                    + "FROM comp_seguros c "
                    + "WHERE c.nombre LIKE '%"+filtro+"%' "
                    + "ORDER BY c.nombre";
            sentencia = con.prepareStatement(sql);
            
            rs = sentencia.executeQuery();
            
            while (rs.next()){
                companias.add(new CompSegurosDTO(rs.getInt("id_comp_seguro"), rs.getString("nombre")));
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
        
        return companias;
    }

    @Override
    public List<CompSegurosDTO> listarComp() {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        List<CompSegurosDTO> companias = new ArrayList<CompSegurosDTO>();
        
        try{
            con = conexion.getConnection();
            String sql = "SELECT c.id_comp_seguro, c.nombre "
                    + "FROM comp_seguros c "
                    + "ORDER BY c.nombre";
            sentencia = con.prepareStatement(sql);
            
            rs = sentencia.executeQuery();
            
            while (rs.next()){
                companias.add(new CompSegurosDTO(rs.getInt("id_comp_seguro"), rs.getString("nombre")));
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
        
        return companias;
    }

    @Override
    public boolean insertarComp(CompSegurosDTO comp) {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        boolean result = false;
        
        try{
            con = conexion.getConnection();
            String sql = "INSERT INTO comp_seguros (nombre) VALUES (?)";
            sentencia = con.prepareStatement(sql);
            sentencia.setString(1, comp.getNombre());
            
            result = sentencia.executeUpdate() > 0;
            
            if (result){
                sql = "SELECT id_comp_seguro FROM comp_seguros ORDER BY id_comp_seguro DESC LIMIT 1";
                sentencia = con.prepareStatement(sql);
                rs = sentencia.executeQuery();
                
                if(rs.next()){
                    comp.setId_comp_seguros(rs.getInt("id_comp_seguro"));
                }
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
        
        return result;
    }

    @Override
    public boolean modificarComp(CompSegurosDTO comp) {
        Connection con = null;
        PreparedStatement sentencia = null;
        boolean result = false;
        
        try{
            con = conexion.getConnection();
            String sql = "UPDATE comp_seguros SET nombre = ? WHERE id_comp_seguro = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setString(1, comp.getNombre());
            sentencia.setInt(2, comp.getId_comp_seguros());
            
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
    public boolean eliminarComp(CompSegurosDTO comp) {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        boolean result = false;
        
        try{
            con = conexion.getConnection();
            String sql = "SELECT * FROM vehiculos WHERE id_comp_seguro = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, comp.getId_comp_seguros());
            
            rs = sentencia.executeQuery();
            
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Error", "No se puede eliminar la compañía ya que hay vehículos asocioados", JOptionPane.ERROR_MESSAGE);
            }
            else{
                sql = "DELETE FROM comp_seguros WHERE id_comp_seguro = ?";
                sentencia = con.prepareStatement(sql);
                sentencia.setInt(1, comp.getId_comp_seguros());
                
                result = sentencia.executeUpdate() > 0;
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
        
        return result;
    }
    
}
