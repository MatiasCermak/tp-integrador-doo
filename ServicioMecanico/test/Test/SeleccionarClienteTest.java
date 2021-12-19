/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;
import ubp.doo.tp.dto.ClienteDTO;
import ubp.doo.tp.modelo.MCliente;
import ubp.doo.tp.modelo.Modelo;
/**
 *
 * @author chino
 */
public class SeleccionarClienteTest {
    
    @Test
    public void testSeleccionarCliente1()
    {
        ClienteDTO cliente = new ClienteDTO("Test", "Client1", "DNI", 15151515);
        Modelo mod = new MCliente();
        
        ClienteDTO result=((MCliente)mod).buscarCliente("DNI",15151515);
        
        assertEquals(cliente.getNombre(),result.getNombre());
        assertEquals(cliente.getApellido(),result.getApellido());
        assertEquals(cliente.getDniTipo(),result.getDniTipo());
        assertEquals(cliente.getDniNumero(),result.getDniNumero());
    }
    
    @Test
    public void testSeleccionarCliente2()
    {
        Modelo mod = new MCliente();
        ClienteDTO cliente=((MCliente)mod).buscarCliente("DNI",22345687);
        
        assertNull(cliente);
    }
    
}
