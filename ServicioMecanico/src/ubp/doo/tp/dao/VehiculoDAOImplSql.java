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
    public List<VehiculoDTO> listarVehiculos() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<VehiculoDTO> listarVehiculos(String dniTipo, int dni) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<VehiculoDTO> listarVehiculos(String compania) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean insertarVehiculo(VehiculoDTO vehiculo) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean modificarVehiculo(VehiculoDTO vehiculo) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean borrarVehiculo(VehiculoDTO vehiculo) {
        // TODO Auto-generated method stub
        return false;
    }
    
}
