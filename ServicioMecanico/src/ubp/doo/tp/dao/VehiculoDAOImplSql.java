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
import java.util.List;
import javax.swing.JOptionPane;

import ubp.doo.tp.dto.VehiculoDTO;

/**
 *
 * @author tomas
 */
public class VehiculoDAOImplSql implements VehiculoDAO {

    private ConexionSql conexion = null;

    public VehiculoDAOImplSql(){
        conexion = ConexionSql.getInstancia();
    }

    @Override
    public VehiculoDTO buscarVehiculo(String matricula) {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        VehiculoDTO vehiculo = null;

        try {
            con = conexion.getConnection();
            String sql = "SELECT v.matricula, v.poliza, v.marca, v.modelo, c.nombre "
                        +"FROM vehiculos v "
                        +"JOIN comp_seguros c "
                        +"ON v.id_comp_seguro = c.id_com_seguro "
                        +"WHERE v.matricula = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setString(1, matricula);

            rs = sentencia.executeQuery();

            String matr;
            int poliza;
            String marca;
            String modelo;
            String comp;

            while (rs.next()){
                matr = rs.getString("matricula");
                poliza = rs.getInt("poliza");
                marca = rs.getString("marca");
                modelo = rs.getString("modelo");
                comp = rs.getString("nombre");
                vehiculo = new VehiculoDTO(comp,poliza,matr,modelo,marca);
                break;
            }
        } catch (SQLException e){
            System.err.println(e);
        } finally {
            try {
                rs.close();
                sentencia.close();
            } catch (SQLException ex){
                System.err.println(ex);
            }
        }

        return vehiculo;
    }

    @Override
    public VehiculoDTO buscarVehiculo(String comp, int poliza) {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        VehiculoDTO vehiculo = null;

        try {
            con = conexion.getConnection();
            String sql = "SELECT v.matricula, v.poliza, v.marca, v.modelo, c.nombre "
                        +"FROM vehiculos v "
                        +"JOIN comp_seguros c "
                        +"ON v.id_comp_seguro = c.id_com_seguro "
                        +"WHERE c.nombre = ? AND v.poliza = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setString(1, comp);
            sentencia.setInt(2, poliza);

            rs = sentencia.executeQuery();

            String matr;
            int pol;
            String marca;
            String modelo;
            String compania;

            while (rs.next()){
                matr = rs.getString("matricula");
                pol = rs.getInt("poliza");
                marca = rs.getString("marca");
                modelo = rs.getString("modelo");
                compania = rs.getString("nombre");
                vehiculo = new VehiculoDTO(compania,pol,matr,modelo,marca);
                break;
            }
        } catch (SQLException e){
            System.err.println(e);
        } finally {
            try {
                rs.close();
                sentencia.close();
            } catch (SQLException ex){
                System.err.println(ex);
            }
        }

        return vehiculo;
    }

    @Override
    public List<VehiculoDTO> listarVehiculos() {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        List<VehiculoDTO> vehiculos = null;

        try {
            con = conexion.getConnection();
            String sql = "SELECT v.matricula, v.poliza, v.marca, v.modelo, c.nombre "
                        +"FROM vehiculos v "
                        +"JOIN comp_seguros c "
                        +"ON v.id_comp_seguro = c.id_com_seguro";
            sentencia = con.prepareStatement(sql);

            rs = sentencia.executeQuery();

            String matr;
            int poliza;
            String marca;
            String modelo;
            String compania;

            while (rs.next()){
                matr = rs.getString("matricula");
                poliza = rs.getInt("poliza");
                marca = rs.getString("marca");
                modelo = rs.getString("modelo");
                compania = rs.getString("nombre");
                vehiculos.add(new VehiculoDTO(compania,poliza,matr,modelo,marca));
            }
        } catch (SQLException e){
            System.err.println(e);
        } finally {
            try {
                rs.close();
                sentencia.close();
            } catch (SQLException ex){
                System.err.println(ex);
            }
        }

        return vehiculos;
    }

    @Override
    public List<VehiculoDTO> listarVehiculos(String dniTipo, int dni) {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        List<VehiculoDTO> vehiculos = null;

        try {
            con = conexion.getConnection();
            String sql = "SELECT v.matricula, v.poliza, v.marca, v.modelo, c.nombre "
                        +"FROM vehiculos v "
                        +"JOIN comp_seguros c "
                        +"ON v.id_comp_seguro = c.id_com_seguro "
                        + "WHERE v.dni = ? AND "
                        + "v.id_dni_tipo = (SELECT FIRST dt.id_dni_tipo FROM dni_tipos dt WHERE dt.tipo = ?)";
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, dni);
            sentencia.setString(2, dniTipo);

            rs = sentencia.executeQuery();

            String matr;
            int poliza;
            String marca;
            String modelo;
            String compania;

            while (rs.next()){
                matr = rs.getString("matricula");
                poliza = rs.getInt("poliza");
                marca = rs.getString("marca");
                modelo = rs.getString("modelo");
                compania = rs.getString("nombre");
                vehiculos.add(new VehiculoDTO(compania,poliza,matr,modelo,marca));
            }
        } catch (SQLException e){
            System.err.println(e);
        } finally {
            try {
                rs.close();
                sentencia.close();
            } catch (SQLException ex){
                System.err.println(ex);
            }
        }

        return vehiculos;
    }

    @Override
    public List<VehiculoDTO> listarVehiculos(String comp) {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        List<VehiculoDTO> vehiculos = null;

        try {
            con = conexion.getConnection();
            String sql = "SELECT v.matricula, v.poliza, v.marca, v.modelo, c.nombre "
                        +"FROM vehiculos v "
                        +"JOIN comp_seguros c "
                        +"ON v.id_comp_seguro = c.id_com_seguro "
                        +"WHERE c.nombre = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setString(1, comp);

            rs = sentencia.executeQuery();

            String matr;
            int poliza;
            String marca;
            String modelo;
            String compania;

            while (rs.next()){
                matr = rs.getString("matricula");
                poliza = rs.getInt("poliza");
                marca = rs.getString("marca");
                modelo = rs.getString("modelo");
                compania = rs.getString("nombre");
                vehiculos.add(new VehiculoDTO(compania,poliza,matr,modelo,marca));
            }
        } catch (SQLException e){
            System.err.println(e);
        } finally {
            try {
                rs.close();
                sentencia.close();
            } catch (SQLException ex){
                System.err.println(ex);
            }
        }

        return vehiculos;
    }

    @Override
    public boolean insertarVehiculo(VehiculoDTO vehiculo) {
        Connection con = null;
        PreparedStatement sentencia = null;
        boolean result = false;
        
        try{
            con = conexion.getConnection();
            String sql = "INSERT INTO vehiculos (matricula, poliza, marca, modelo, id_comp_seguro, dni, id_dni_tipo)"
                    + "VALUES (?,?,?,?,(SELECT FIRTS c.id_comp_seguro FROM comp_seguros c WHERE c.nombre = ?),?,"
                    + "(SELECT FIRST dt.id_dni_tipo FROM dni_tipos dt WHERE dt.tipo = ?))";
            sentencia = con.prepareStatement(sql);
            sentencia.setString(1, vehiculo.getMatricula());
            sentencia.setInt(2, vehiculo.getPoliza());
            sentencia.setString(3, vehiculo.getMarca());
            sentencia.setString(4, vehiculo.getModelo());
            sentencia.setString(5, vehiculo.getAseguradora());
            sentencia.setInt(6, vehiculo.getDni());
            sentencia.setString(7, vehiculo.getDniTipo());
            
            int r = sentencia.executeUpdate();
            
            result = r > 0;
        } catch (SQLException e){
            System.err.println(e);
        } finally{
            try{
                sentencia.close();
            }catch(SQLException ex){
                System.err.println(ex);
            }
        }
        
        return result;
    }

    @Override
    public boolean modificarVehiculo(VehiculoDTO vehiculo) {
        Connection con = null;
        PreparedStatement sentencia = null;
        boolean result = false;
        
        try{
            con = conexion.getConnection();
            String sql = "UPDATE vehiculos SET "
                    + "poliza = ?, "
                    + "marca = ?, "
                    + "modelo = ?, "
                    + "id_comp_seguro = (SELECT FIRST cs.id_comp_seguro FROM comp_seguros cs WHERE cs.nombre = ?), "
                    + "dni = ?, "
                    + "id_dni_tipo = (SELECT FIRST dt.id_dni_tipo FROM dni_tipos dt WHERE dt.tipo = ?) "
                    + "WHERE matricula = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setString(7, vehiculo.getMatricula());
            sentencia.setInt(1, vehiculo.getPoliza());
            sentencia.setString(2, vehiculo.getMarca());
            sentencia.setString(3, vehiculo.getModelo());
            sentencia.setString(4, vehiculo.getAseguradora());
            sentencia.setInt(5, vehiculo.getDni());
            sentencia.setString(6, vehiculo.getDniTipo());
            
            int r = sentencia.executeUpdate();
            
            result = r > 0;
        } catch (SQLException e){
            System.err.println(e);
        } finally{
            try{
                sentencia.close();
            }catch(SQLException ex){
                System.err.println(ex);
            }
        }
        
        return result;
    }

    @Override
    public boolean borrarVehiculo(VehiculoDTO vehiculo) {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        boolean result = false;
        
        try {
            con = conexion.getConnection();
            String sql = "SELECT * FROM turnos WHERE matricula = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setString(1, vehiculo.getMatricula());
            
            rs = sentencia.executeQuery();
            
            if (rs.next()){
                JOptionPane.showMessageDialog(null, "Error", "No se puede eliminar el vehículo ya que hay turnos asociados",JOptionPane.WARNING_MESSAGE);
            }
            else {
                sql = "DELETE FROM vehiculos WHERE matricula = ?";
                sentencia = con.prepareStatement(sql);
                sentencia.setString(1, vehiculo.getMatricula());
                
                result = (sentencia.executeUpdate()) > 0;
            }
            
        }catch (SQLException e){
            System.err.println(e);
        }finally{
            try{
                rs.close();
                sentencia.close();
            }catch (SQLException ex){
                System.err.println(ex);
            }
        }
        
        return result;
    }
    
    @Override
    public void cerrarConexion() {
        conexion.desconectar();
    }
}
