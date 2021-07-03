/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubp.doo.tp.modelo;

import ubp.doo.tp.dao.ClienteDAO;
import ubp.doo.tp.dao.FabricaDAO;
import ubp.doo.tp.dto.ClienteDTO;
import java.util.List;

/**
 *
 * @author tomas
 */
public class MCliente extends Modelo {
    
    private final FabricaDAO fabricaDao;
    private final ClienteDAO clienteDao;
    
    public MCliente() {
        fabricaDao = FabricaDAO.getFactory("SqlFabricaDAO");
        clienteDao = fabricaDao.getClienteDao();
    }
    
    public ClienteDTO buscarCliente(String nombre) {
        ClienteDTO cliente= clienteDao.buscarCliente(nombre);
        return cliente;
    }
    
    public ClienteDTO buscarCliente(String dniTipo,int dni){
        ClienteDTO cliente = clienteDao.buscarCliente(dniTipo, dni);
        return cliente;
    }
    
    public List<ClienteDTO> listarClientes(String filtro){
        List<ClienteDTO> clientes = clienteDao.listarClientes(filtro);
        return clientes;
    }
    
    public List<ClienteDTO> listarClientes(){
        return clienteDao.listarClientes();
    }
    
    public boolean insertarCliente(ClienteDTO cliente){
        return clienteDao.insertarCliente(cliente);
    }
    
    public boolean modificarCliente(ClienteDTO cliente){
        return clienteDao.modificarCliente(cliente);
    }
    
    public boolean borrarCliente(ClienteDTO cliente){
        return clienteDao.borrarCliente(cliente);
    }
    
    public List<String> listadoDniTipos(){
        return clienteDao.listarTiposDNI();
    }
    
    @Override
    protected void finalize() throws Throwable {
        clienteDao.cerrarConexion();
    }
}
