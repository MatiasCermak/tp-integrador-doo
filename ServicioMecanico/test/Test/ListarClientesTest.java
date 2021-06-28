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
public class ListarClientesTest {
    
    @Test
    public void testListarClientes1()
    {
        ClienteDTO cliente = new ClienteDTO();
        Modelo mod = new MCliente();
        cliente.setDniNumero(40000005);
        cliente.setDniTipo("dni");
        cliente.setNombre("juan cho");
        
        List<ClienteDTO>result=((MCliente)mod).listarClientes("juan cho");
        
        assertEquals(cliente.getNombre(),result.get(0).getNombre());
        assertEquals(cliente.getDniTipo(),result.get(0).getDniTipo());
        assertEquals(cliente.getDniNumero(),result.get(0).getDniNumero());
    }
    
    @Test
    public void testListarClientes2()
    {
        ClienteDTO cliente = new ClienteDTO();
        Modelo mod = new MCliente();
        
        List<ClienteDTO>result=((MCliente)mod).listarClientes("No existe");
        
        assertTrue(result.isEmpty());
    }
    
    @Test
    public void testListarClientes3()
    {
        Modelo mod = new MCliente();
        List<ClienteDTO>result=((MCliente)mod).listarClientes("juan");
        
        assertEquals(5,result.size());
    }
}
