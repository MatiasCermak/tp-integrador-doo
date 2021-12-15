/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubp.doo.tp.modelo;

import ubp.doo.tp.dao.FabricaDAO;
import ubp.doo.tp.dao.UsuarioDAO;

/**
 *
 * @author bettic
 */
public class MUsuario extends Modelo  {
	private final FabricaDAO fabricaDao;
	private final UsuarioDAO usuarioDao;
	
	public MUsuario() {
		fabricaDao = FabricaDAO.getFactory("SqlFabricaDAO");
		usuarioDao = fabricaDao.getUsuarioDAO();
	}
}
