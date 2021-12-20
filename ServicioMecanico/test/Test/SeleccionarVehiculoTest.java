/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Test;


import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import ubp.doo.tp.dto.VehiculoDTO;
import ubp.doo.tp.modelo.Modelo;
import ubp.doo.tp.modelo.MVehiculo;
/**
 *
 * @author chino
 */
public class SeleccionarVehiculoTest {
    
    @Test
    public void testSeleccionarVehiculo1() {
        VehiculoDTO vehiculo = new VehiculoDTO(3,15151515, "DNI", "1515151515", "TEST1", "TestModel", "TestV");
        Modelo mod = new MVehiculo();
        
        VehiculoDTO result =  ((MVehiculo)mod).buscarVehiculo("TEST1");
    
        assertEquals(vehiculo.getPoliza(), result.getPoliza());
        assertEquals(vehiculo.getMarca(), result.getMarca());
        assertEquals(vehiculo.getModelo(), result.getModelo());
    }
    
    @Test
    public void testSeleccionarVehiculo2() {
        
        Modelo mod = new MVehiculo();
        
        List<VehiculoDTO> result =  ((MVehiculo)mod).listarVehiculos("DNI", 15151515);
    
        assertEquals(2, result.size());
    }
}
