/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubp.doo.tp.modelo;

import ubp.doo.tp.dao.FabricaDAO;
import ubp.doo.tp.dao.MecanicoDAO;

/**
 *
 * @author bettic
 */
public class MMecanico {
	private final FabricaDAO fabricaDao;
    private final MecanicoDAO mecanicoDao;
    
    public MMecanico() {
        fabricaDao = FabricaDAO.getFactory("SqlFabricaDAO");
        mecanicoDao = fabricaDao.getMecanicoDao();
    }
}
