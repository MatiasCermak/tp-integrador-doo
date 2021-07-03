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
import ubp.doo.tp.dto.EspecialidadDTO;

/**
 *
 * @author tomas
 */
public class EspecialidadDAOImplSql implements EspecialidadDAO {
    
    private ConexionSql conexion = null;
    
    public EspecialidadDAOImplSql(){
        conexion = ConexionSql.getInstancia();
    }

    @Override
    public void cerrarConexion() {
        conexion.desconectar();
    }

    @Override
    public EspecialidadDTO buscarEspecialidad(String especialidad) {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        EspecialidadDTO r = null;
        
        try {
            con = conexion.getConnection();
            String sql = "SELECT especialidad FROM especialidades WHERE especialidad = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setString(1,especialidad);
            
            String esp;
            int id;
            
            while (rs.next()){
                esp = rs.getString("especialidad");
                id = rs.getInt("id_especialidad");
                r = new EspecialidadDTO(esp,id);
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
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }
        
        return r;
    }

    @Override
    public List<EspecialidadDTO> listarEspecialidades() {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        List<EspecialidadDTO> lista = new ArrayList<EspecialidadDTO>();
        
        try{
            con = conexion.getConnection();
            String sql = "SELECT especialidad FROM especialidades";
            sentencia = con.prepareStatement(sql);
            
            rs = sentencia.executeQuery();
            
            String esp;
            int id;
            
            while(rs.next()){
                esp = rs.getString("especialidad");
                id = rs.getInt("id_especialidad");
                lista.add(new EspecialidadDTO(esp,id));
            }
        }
        catch (SQLException e){
            System.err.println(e);
        }
        finally{
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
    public boolean insertarEspecialidad(EspecialidadDTO especialidad) {
        Connection con = null;
        PreparedStatement sentencia = null;
        boolean r = false;
        
        try {
            con = conexion.getConnection();
            String sql = "INSERT INTO especialidades ('especialidad') VALUES ('"+especialidad.getNombre()+"')";
            sentencia = con.prepareStatement(sql);
            
            int resultado = sentencia.executeUpdate();
            
            r = (resultado > 0);
        }
        catch (SQLException e){
            System.err.println(e);
        }
        finally{
            try {
                sentencia.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }
        
        return r;
    }

    @Override
    public boolean modificarEspecialidad(EspecialidadDTO especialidad) {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        boolean r = false;
        
        try{
            con = conexion.getConnection();
            String sql = "SELECT * FROM mecanicos WHERE id_especialidad = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, especialidad.getId());
            
            rs = sentencia.executeQuery();
            
            int cant = 0;
            
            while (rs.next()){
                cant++;
            }
            
            if (cant > 0){
                JOptionPane.showMessageDialog(null,"Error","No puede modificar especialidad ya que hay mecanicos asociados a la misma",JOptionPane.WARNING_MESSAGE);
            }
            else {
                sql = "UPDATE especialidades SET especialidad = ? WHERE id_especialidad = ?";
                sentencia = con.prepareStatement(sql);
                sentencia.setString(1, especialidad.getNombre());
                sentencia.setInt(2, especialidad.getId());

                int resultado = sentencia.executeUpdate();

                r = (resultado > 0);
            }
        }
        catch (SQLException e){
            System.err.println(e);
        }
        finally{
            try {
                sentencia.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }
        
        return r;
    }

    @Override
    public boolean borrarEspecialidad(EspecialidadDTO especialidad) {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        boolean r = false;
        
        try{
            con = conexion.getConnection();
            String sql = "SELECT * FROM mecanicos WHERE id_especialidad = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, especialidad.getId());
            
            rs = sentencia.executeQuery();
            
            int cant = 0;
            
            while (rs.next()){
                cant++;
            }
            
            if (cant > 0){
                JOptionPane.showMessageDialog(null,"Error","No puede eliminar especialidad ya que hay mecanicos asociados a la misma",JOptionPane.WARNING_MESSAGE);
            }
            else {
                sql = "UDELETE especialidades WHERE id_especialidad = ?";
                sentencia = con.prepareStatement(sql);
                sentencia.setString(1, especialidad.getNombre());
                sentencia.setInt(2, especialidad.getId());

                int resultado = sentencia.executeUpdate();

                r = (resultado > 0);
            }
        }
        catch (SQLException e){
            System.err.println(e);
        }
        finally{
            try {
                sentencia.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }
        
        return r;
    }
    
}
