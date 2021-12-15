/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubp.doo.tp.dao;

import ubp.doo.tp.dto.DetalleDTO;
import java.util.List;

/**
 *
 * @author tomas
 */
public interface DetalleDAO {
    
    void cerrarConexion();
    
    DetalleDTO buscarDetalle(int id_detalle);
    
    List<DetalleDTO> listarDetalles(int id_ficha); //Listar todos los detalles de la misma ficha
    
    boolean insertarDetalle(DetalleDTO detalle);
    
    boolean modificarDetalle(DetalleDTO detalle);
    
    boolean eliminarDetalle(DetalleDTO detalle);
}
