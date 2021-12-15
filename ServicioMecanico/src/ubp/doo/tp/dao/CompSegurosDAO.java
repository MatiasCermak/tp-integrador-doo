/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubp.doo.tp.dao;

import ubp.doo.tp.dto.CompSegurosDTO;
import java.util.List;
/**
 *
 * @author tomas
 */
public interface CompSegurosDAO {
    
    CompSegurosDTO buscarComp(String nombre);
    
    List<CompSegurosDTO> listarComp(String filtro);
    
    List<CompSegurosDTO> listarComp();
    
    boolean insertarComp(CompSegurosDTO comp);
    
    boolean modificarComp(CompSegurosDTO comp);
    
    boolean eliminarComp(CompSegurosDTO comp);
}
