/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubp.doo.tp.dao;

import ubp.doo.tp.dto.VehiculoDTO;
import java.util.List;
/**
 *
 * @author tomas
 */
public interface VehiculoDAO {
    
    VehiculoDTO buscarVehiculo(String matricula);
    
    VehiculoDTO buscarVehiculo(int id_comp_seguros, int poliza);
    
    List<VehiculoDTO> listarVehiculos();

    List<VehiculoDTO> listarVehiculos(String dniTipo, int dni);

    List<VehiculoDTO> listarVehiculos(int id_comp_seguros);

    boolean insertarVehiculo(VehiculoDTO vehiculo);

    boolean modificarVehiculo(VehiculoDTO vehiculo);

    boolean borrarVehiculo(VehiculoDTO vehiculo);
    
    void cerrarConexion();
}
