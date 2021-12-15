/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubp.doo.tp.dao;

import ubp.doo.tp.dto.DetalleDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tomas
 */
public class DetalleDAOImplSql implements DetalleDAO{
    
    private ConexionSql conexion = null;
    
    public DetalleDAOImplSql(){
        conexion = ConexionSql.getInstancia();
    }

    @Override
    public void cerrarConexion() {
        conexion.desconectar();
    }

    @Override
    public DetalleDTO buscarDetalle(int id_detalle) {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        DetalleDTO detalle = null;
        
        try {
            con = conexion.getConnection();
            String sql = "SELECT d.id_detalle, d.id_material, d.id_ficha, d.cantidad "
                    + "FROM detalles d "
                    + "WHERE d.id_detalle = ? "
                    + "ORDER BY d.id_detalle ASC LIMIT 1";
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, id_detalle);
            
            rs = sentencia.executeQuery();
            
            if(rs.next()){
                detalle = new DetalleDTO(id_detalle, rs.getInt("id_material"), rs.getInt("cantidad"), rs.getInt("id_ficha"));
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
        
        return detalle;
    }

    @Override
    public List<DetalleDTO> listarDetalles(int id_ficha) {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        List<DetalleDTO> detalles = new ArrayList<DetalleDTO>();
        
        try{
            con = conexion.getConnection();
            String sql = "SELECT id_detalle, id_material, cantidad FROM detalles WHERE id_ficha = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, id_ficha);
            
            rs = sentencia.executeQuery();
                
            while (rs.next()){
                detalles.add(new DetalleDTO(rs.getInt("id_detalle"), rs.getInt("id_material"), rs.getInt("cantidad"), id_ficha));
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
        
        return detalles;
    }

    @Override
    public boolean insertarDetalle(DetalleDTO detalle) {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        boolean result = false;
        
        try{
            con = conexion.getConnection();
            String sql = "INSERT INTO detalles (id_material, id_ficha, cantidad) VALUES(?,?,?)";
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, detalle.getId_material());
            sentencia.setInt(2, detalle.getId_ficha());
            sentencia.setInt(3, detalle.getCantidad());
            
            result = sentencia.executeUpdate() > 0;
            
            if (result){
                sql = "SELECT id_detalle FROM detalles ORDER BY id_detalle DESC LIMIT 1";
                sentencia = con.prepareStatement(sql);
                
                rs = sentencia.executeQuery();
                
                if (rs.next()){
                    detalle.setId_detalle(rs.getInt("id_detalle"));
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
    public boolean modificarDetalle(DetalleDTO detalle) {
        Connection con = null;
        PreparedStatement sentencia = null;
        boolean result = false;
        
        try{
            con = conexion.getConnection();
            String sql = "UPDATE detalles SET id_material = ?, id_ficha = ?, cantidad = ? WHERE id_detalle = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, detalle.getId_material());
            sentencia.setInt(2, detalle.getId_ficha());
            sentencia.setInt(3, detalle.getCantidad());
            sentencia.setInt(4, detalle.getId_detalle());
            
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
    public boolean eliminarDetalle(DetalleDTO detalle) {
        Connection con = null;
        PreparedStatement sentencia = null;
        boolean result = false;
        
        try{
            con = conexion.getConnection();
            String sql = "DELETE FROM detalles WHERE id_detalle = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, detalle.getId_detalle());
            
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
    
}
