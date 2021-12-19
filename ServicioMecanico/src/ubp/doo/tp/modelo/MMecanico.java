/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubp.doo.tp.modelo;

import java.util.List;
import ubp.doo.tp.dao.FabricaDAO;
import ubp.doo.tp.dao.MecanicoDAO;
import ubp.doo.tp.dto.MecanicoDTO;

/**
 *
 * @author bettic
 */
public class MMecanico implements Modelo {
    private final FabricaDAO fabricaDao;
    private final MecanicoDAO mecanicoDao;
    
    public MMecanico() {
        fabricaDao = FabricaDAO.getFactory("SqlFabricaDAO");
        mecanicoDao = fabricaDao.getMecanicoDao();
    }
    
    public MecanicoDTO buscarMecanico(int id_empleado) {
        MecanicoDTO mecanico = mecanicoDao.buscarMecanico(id_empleado);
        return mecanico;
    }
    
    public MecanicoDTO buscarMecanico(int dni, String dni_tipo) {
        MecanicoDTO mecanico =  mecanicoDao.buscarMecanico(dni_tipo, dni_tipo);
        return mecanico;
    }
    
    public MecanicoDTO buscarMecanico(String nombre, String apellido) {
        MecanicoDTO mecanico =  mecanicoDao.buscarMecanico(nombre, apellido);
        return mecanico;
    }
    
    public List<MecanicoDTO> listarMecanicos() {
        List<MecanicoDTO> mecanicos = mecanicoDao.listarMecanicos();
        return mecanicos;
    }
    
    public List<MecanicoDTO> listarMecanicos(String filtro) {
        List<MecanicoDTO> mecanicos = mecanicoDao.listarMecanicos(filtro);
        return mecanicos;
    }
    
    public List<MecanicoDTO> listarMecanicos(int id_especialidad){
        List<MecanicoDTO> mecanicos = mecanicoDao.listarMecanicos(id_especialidad);
        return mecanicos;
    }
    
    public boolean insertarMecanico (MecanicoDTO mecanico) {
        return mecanicoDao.insertarMecanico(mecanico);
    }
    
    public boolean modificarMecanico (MecanicoDTO mecanico) {
        return mecanicoDao.modificarMecanico(mecanico);
    }
    
    public boolean eliminarMecanico (MecanicoDTO mecanico) {
        return mecanicoDao.eliminarMecanico(mecanico);
    }
    
    public void cerrarConexión() {
        mecanicoDao.cerrarConexión();
    }
}
