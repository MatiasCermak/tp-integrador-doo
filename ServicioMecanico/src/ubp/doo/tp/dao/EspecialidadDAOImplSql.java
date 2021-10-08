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
            
            while (rs.next()){
                esp = rs.getString("especialidad");
                r = new EspecialidadDTO(esp);
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
            
            while(rs.next()){
                esp = rs.getString("especialidad");
                lista.add(new EspecialidadDTO(esp));
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
    public boolean modificarEspecialidad(EspecialidadDTO especialidad, String ex_esp) {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        boolean r = false;
        
        try{
            con = conexion.getConnection();
            String sql = "SELECT * "
                    + "FROM mecanicos m "
                    + "JOIN especialidades e "
                    + "ON e.id_especialidad = m.id_especialidad "
                    + "WHERE e.especialidad = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setString(1, ex_esp);
            
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
                        + "WHERE id_especialidad = (SELECT FIRST e.id_especialidad FROM especialidades e WHERE e.especialidad = ?)";
                sentencia = con.prepareStatement(sql);
                sentencia.setString(1, especialidad.getNombre());
                sentencia.setString(2, ex_esp);

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
            String sql = "SELECT * "
                    + "FROM mecanicos m "
                    + "JOIN especialidades e "
                    + "ON e.id_especialidad = m. id_especialidad "
                    + "WHERE e.especialidad = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setString(1, especialidad.getNombre());
            
            rs = sentencia.executeQuery();
            
            int cant = 0;
            
            while (rs.next()){
                cant++;
            }
            
            if (cant > 0){
                JOptionPane.showMessageDialog(null,"Error","No puede eliminar especialidad ya que hay mecanicos asociados a la misma",JOptionPane.ERROR_MESSAGE);
            }
            else {
                sql = "DELETE especialidades WHERE especialidad = ?";
                sentencia = con.prepareStatement(sql);
                sentencia.setString(1, especialidad.getNombre());

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
