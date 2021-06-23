/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubp.doo.tp.dao;

import ubp.doo.tp.dto.ClienteDTO;
import java.util.List;

/**
 *
 * @author tomas
 */
public interface ClienteDAO {
    
    ClienteDTO buscarCliente(String nombre);
    
    ClienteDTO buscarCliente(String dniTipo,int dni);
    
    List<ClienteDTO> listarClientes(String filtro);
    
    List<ClienteDTO> listarClientes();
    
    boolean insertarCliente(ClienteDTO cliente);
    
    boolean modificarCliente(ClienteDTO cliente);
    
    boolean borrarCliente(ClienteDTO cliente);
    
    void cerrarConexion();
}
