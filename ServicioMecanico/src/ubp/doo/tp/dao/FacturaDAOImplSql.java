/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubp.doo.tp.dao;

import java.util.Date;
import java.util.List;
import ubp.doo.tp.dto.FacturaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author tomas
 */
public class FacturaDAOImplSql implements FacturaDAO {
    
    private ConexionSql conexion = null;
    
    public FacturaDAOImplSql(){
        conexion = ConexionSql.getInstancia();
    }

    @Override
    public void cerrarConexion() {
        conexion.desconectar();
    }

    @Override
    public FacturaDTO buscarFactura(String comp, float costo, float pago, Date fecha) {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        FacturaDTO factura = null;
        
        try{
            con = conexion.getConnection();
            String sql = "";
            sentencia = con.prepareStatement(sql);
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
        
        return factura;
    }

    @Override
    public List<FacturaDTO> filtrarFacturas(String comp) {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        FacturaDTO factura = null;
        
        try{
            con = conexion.getConnection();
            String sql = "";
            sentencia = con.prepareStatement(sql);
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
        
        return factura;
    }

    @Override
    public List<FacturaDTO> filtrarFacturas(float costo, float pago) {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        FacturaDTO factura = null;
        
        try{
            con = conexion.getConnection();
            String sql = "";
            sentencia = con.prepareStatement(sql);
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
        
        return factura;
    }

    @Override
    public List<FacturaDTO> filtrarFacturas(Date fecha) {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        FacturaDTO factura = null;
        
        try{
            con = conexion.getConnection();
            String sql = "";
            sentencia = con.prepareStatement(sql);
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
        
        return factura;
    }

    @Override
    public List<FacturaDTO> listarFacturas() {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        FacturaDTO factura = null;
        
        try{
            con = conexion.getConnection();
            String sql = "";
            sentencia = con.prepareStatement(sql);
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
        
        return factura;
    }

    @Override
    public boolean insertarFactura(FacturaDTO factura) {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        FacturaDTO factura = null;
        
        try{
            con = conexion.getConnection();
            String sql = "";
            sentencia = con.prepareStatement(sql);
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
        
        return factura;
    }

    @Override
    public boolean modificarFactura(FacturaDTO factura) {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        FacturaDTO factura = null;
        
        try{
            con = conexion.getConnection();
            String sql = "";
            sentencia = con.prepareStatement(sql);
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
        
        return factura;
    }

    @Override
    public boolean eliminarFactura(FacturaDTO factura) {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        FacturaDTO factura = null;
        
        try{
            con = conexion.getConnection();
            String sql = "";
            sentencia = con.prepareStatement(sql);
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
        
        return factura;
    }
    
}
