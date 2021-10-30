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
import java.util.ArrayList;
import java.util.List;
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
            String sql = "SELECT id_especialidad FROM especialidades WHERE especialidad = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setString(1,especialidad);
            
            while (rs.next()){
                r = new EspecialidadDTO(rs.getInt("id_especialidad"), especialidad);
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
            String sql = "SELECT id_especialidad, especialidad FROM especialidades";
            sentencia = con.prepareStatement(sql);
            
            rs = sentencia.executeQuery();
            
            while(rs.next()){
                lista.add(new EspecialidadDTO(rs.getInt("id_especialidad"), rs.getString("especialidad")));
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
        ResultSet rs = null;
        boolean r = false;
        
        try {
            con = conexion.getConnection();
            String sql = "INSERT INTO especialidades ('especialidad') VALUES ('"+especialidad.getNombre()+"')";
            sentencia = con.prepareStatement(sql);
            
            int resultado = sentencia.executeUpdate();
            
            r = (resultado > 0);
            
            if (r){
                sql = "SELEC id_especialidad FROM especialidades ORDER BY id_especialidades DESC LIMIT 1";
                sentencia = con.prepareStatement(sql);
                rs = sentencia.executeQuery();
                
                if (rs.next()){
                    especialidad.setId_especialidad(rs.getInt("id_especialidad"));
                }
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
    public boolean modificarEspecialidad(EspecialidadDTO especialidad) {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        boolean r = false;
        
        try{
            con = conexion.getConnection();
            String sql = "SELECT * FROM mecanicos WHERE id_especialidad = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, especialidad.getId_especialidad());
            
            rs = sentencia.executeQuery();
            
            int cant = 0;
            
            while (rs.next()){
                cant++;
            }
            
            int confirmar = 0;
            if (cant > 0){
                confirmar = JOptionPane.showConfirmDialog(null,"Warning","Está a punto de modificar una especialidad que tiene mecánicos asociados.\nDesea continuar?",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
            }
            
            if (confirmar == 0) {
                sql = "UPDATE especialidades SET especialidad = ? "
                        + "WHERE id_especialidad = ?";
                sentencia = con.prepareStatement(sql);
                sentencia.setString(1, especialidad.getNombre());
                sentencia.setInt(2, especialidad.getId_especialidad());

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
            sentencia.setInt(1, especialidad.getId_especialidad());
            
            rs = sentencia.executeQuery();
            
            int cant = 0;
            
            while (rs.next()){
                cant++;
            }
            
            if (cant > 0){
                JOptionPane.showMessageDialog(null,"Error","No puede eliminar especialidad ya que hay mecanicos asociados a la misma",JOptionPane.ERROR_MESSAGE);
            }
            else {
                sql = "DELETE especialidades WHERE id_especialidad = ?";
                sentencia = con.prepareStatement(sql);
                sentencia.setInt(1, especialidad.getId_especialidad());

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
