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
            String sql = "SELECT v.poliza, v.marca, v.modelo, "
                        + "v.dni, dt.tipo, v.id_comp_seguro "
                        + "FROM vehiculos v "
                        + "JOIN dni_tipos dt ON v.id_dni_tipo = dt.id_dni_tipo "
                        + "WHERE v.matricula = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setString(1, matricula);

            rs = sentencia.executeQuery();

            String poliza;
            String marca;
            String modelo;
            int dni;
            String dniTipo;

            if (rs.next()){
                poliza = rs.getString("poliza");
                marca = rs.getString("marca");
                modelo = rs.getString("modelo");
                dni = rs.getInt("dni");
                dniTipo = rs.getString("tipo");
                
                vehiculo = new VehiculoDTO(rs.getInt("id_comp_seguro"), dni, dniTipo, poliza, matricula, modelo, marca);
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
    public VehiculoDTO buscarVehiculo(int id_comp_seguros, String poliza) {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        VehiculoDTO vehiculo = null;

        try {
            con = conexion.getConnection();
            String sql = "SELECT v.matricula, v.marca, v.modelo, "
                        + "v.dni, dt.tipo "
                        + "FROM vehiculos v "
                        + "JOIN dni_tipos dt ON v.id_dni_tipo = dt.id_dni_tipo "
                        + "WHERE v.id_comp_seguro = ? AND v.poliza = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, id_comp_seguros);
            sentencia.setString(2, poliza);

            rs = sentencia.executeQuery();

            String matr;
            String marca;
            String modelo;
            int dni;
            String dniTipo;

            if (rs.next()){
                matr = rs.getString("matricula");
                marca = rs.getString("marca");
                modelo = rs.getString("modelo");
                dni = rs.getInt("dni");
                dniTipo = rs.getString("tipo");
                
                vehiculo = new VehiculoDTO(id_comp_seguros, dni, dniTipo, poliza, matr, modelo, marca);
            }
        } catch (SQLException e){
            System.err.println(e);
        } finally {
            try {
                if (rs != null)
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
        List<VehiculoDTO> vehiculos = new ArrayList<VehiculoDTO>();

        try {
            con = conexion.getConnection();
            String sql = "SELECT v.matricula, v.poliza, v.marca, v.modelo, "
                        + "v.dni, dt.tipo, v.id_comp_seguro "
                        + "FROM vehiculos v "
                        + "JOIN dni_tipos dt ON v.id_dni_tipo = dt.id_dni_tipo";
            sentencia = con.prepareStatement(sql);

            rs = sentencia.executeQuery();

            String matr;
            String poliza;
            String marca;
            String modelo;
            int dni, id_comp_seguro;
            String dniTipo;

            while (rs.next()){
                matr = rs.getString("matricula");
                poliza = rs.getString("poliza");
                marca = rs.getString("marca");
                modelo = rs.getString("modelo");
                dni = rs.getInt("dni");
                dniTipo = rs.getString("tipo");
                id_comp_seguro = rs.getInt("id_comp_seguro");
                
                vehiculos.add(new VehiculoDTO(id_comp_seguro, dni, dniTipo, poliza, matr, modelo, marca));
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
        List<VehiculoDTO> vehiculos = new ArrayList<VehiculoDTO>();

        try {
            con = conexion.getConnection();
            String sql = "SELECT v.matricula, v.poliza, v.marca, v.modelo, "
                        + "v.id_comp_seguro "
                        + "FROM vehiculos v "
                        + "JOIN dni_tipos dt ON v.id_dni_tipo = dt.id_dni_tipo "
                        + "WHERE dt.tipo = ? AND v.dni = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setString(1, dniTipo);
            sentencia.setInt(2, dni);

            rs = sentencia.executeQuery();

            String matr;
            int id_comp_seguro;
            String marca;
            String modelo;
            String poliza;

            while (rs.next()){
                matr = rs.getString("matricula");
                poliza = rs.getString("poliza");
                marca = rs.getString("marca");
                modelo = rs.getString("modelo");
                id_comp_seguro = rs.getInt("id_comp_seguro");
                
                vehiculos.add(new VehiculoDTO(id_comp_seguro, dni, dniTipo, poliza, matr, modelo, marca));
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
    public List<VehiculoDTO> listarVehiculos(int id_comp_seguro) {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        List<VehiculoDTO> vehiculos = new ArrayList<VehiculoDTO>();

        try {
            con = conexion.getConnection();
            String sql = "SELECT v.matricula, v.poliza, v.marca, v.modelo, "
                        + "v.dni, dt.tipo "
                        + "FROM vehiculos v "
                        + "JOIN dni_tipos dt ON v.id_dni_tipo = dt.id_dni_tipo "
                        + "WHERE v.id_comp_seguro = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, id_comp_seguro);

            rs = sentencia.executeQuery();

            String matr;
            String poliza;
            String marca;
            String modelo;
            String dniTipo;
            int dni;

            while (rs.next()){
                matr = rs.getString("matricula");
                poliza = rs.getString("poliza");
                marca = rs.getString("marca");
                modelo = rs.getString("modelo");
                dniTipo = rs.getString("tipo");
                dni = rs.getInt("dni");
                
                vehiculos.add(new VehiculoDTO(id_comp_seguro, dni, dniTipo, poliza, matr, modelo, marca));
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
            String sql = "INSERT INTO vehiculos (matricula, poliza, marca, modelo, id_comp_seguro, dni, id_dni_tipo) "
                    + "VALUES (?,?,?,?,?,?,"
                    + "(SELECT dt.id_dni_tipo FROM dni_tipos dt WHERE dt.tipo = ? LIMIT 1))";
            sentencia = con.prepareStatement(sql);
            sentencia.setString(1, vehiculo.getMatricula());
            sentencia.setString(2, vehiculo.getPoliza());
            sentencia.setString(3, vehiculo.getMarca());
            sentencia.setString(4, vehiculo.getModelo());
            sentencia.setInt(5, vehiculo.getId_comp_seguros());
            sentencia.setInt(6, vehiculo.getDni_cliente());
            sentencia.setString(7, vehiculo.getDniTipo_cliente());
            
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
                    + "id_comp_seguro = ?, "
                    + "dni = ?, "
                    + "id_dni_tipo = (SELECT FIRST dt.id_dni_tipo FROM dni_tipos dt WHERE dt.tipo = ?) "
                    + "WHERE matricula = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setString(1, vehiculo.getPoliza());
            sentencia.setString(2, vehiculo.getMarca());
            sentencia.setString(3, vehiculo.getModelo());
            sentencia.setInt(4, vehiculo.getId_comp_seguros());
            sentencia.setInt(5, vehiculo.getDni_cliente());
            sentencia.setString(6, vehiculo.getDniTipo_cliente());
            sentencia.setString(7, vehiculo.getMatricula());
            
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
                JOptionPane.showMessageDialog(null, "Error", "No se puede eliminar el veh??culo ya que hay turnos asociados",JOptionPane.WARNING_MESSAGE);
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
