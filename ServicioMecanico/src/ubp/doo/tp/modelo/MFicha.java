/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubp.doo.tp.modelo;

import ubp.doo.tp.dao.FabricaDAO;
import ubp.doo.tp.dao.FichaDAO;

/**
 *
 * @author bettic
 */
public class MFicha {
	private final FabricaDAO fabricaDao;
    private final FichaDAO fichaDao;
    
    public MFicha() {
        fabricaDao = FabricaDAO.getFactory("SqlFabricaDAO");
        fichaDao = fabricaDao.getFichaDao();
    }
}
