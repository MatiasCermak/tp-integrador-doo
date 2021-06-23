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
import ubp.doo.tp.modelo.Cliente;
import ubp.doo.tp.modelo.Modelo;
/**
 *
 * @author chino
 */
public class SeleccionarClienteTest {
    
    @Test
    public void testSeleccionarCliente1()
    {
        ClienteDTO cliente = new ClienteDTO();
        ClienteDTO clienteEsperado = new ClienteDTO();
        
        Modelo mod = new Cliente();
        clienteEsperado.setDniNumero(12345687);
        clienteEsperado.setDniTipo("DNI");
        clienteEsperado.setNombre("Armando Barreda");
        
        cliente=((Cliente)mod).buscarCliente("DNI",12345687);
        
        assertEquals(clienteEsperado.getNombre(),cliente.getNombre());
        assertEquals(clienteEsperado.getDniTipo(),cliente.getDniTipo());
        assertEquals(clienteEsperado.getDniNumero(),cliente.getDniNumero());
    }
    
    @Test
    public void testSeleccionarCliente2()
    {
        ClienteDTO cliente = new ClienteDTO();  
        Modelo mod = new Cliente();

        cliente=((Cliente)mod).buscarCliente("DNI",22345687);
        
        assertNull(cliente);
    }
    
}
