/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubp.doo.tp.modelo;

import ubp.doo.tp.dao.FabricaDAO;
import ubp.doo.tp.dao.TurnoDAO;

/**
 *
 * @author bettic
 */
public class MTurno extends Modelo {
	private final FabricaDAO fabricaDao;
    private final TurnoDAO turnoDao;
    
    public MTurno() {
    	fabricaDao = FabricaDAO.getFactory("SqlFabricaDAO");
    	turnoDao = fabricaDao.getTurnoDao();
    }
}
