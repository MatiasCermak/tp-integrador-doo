/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubp.doo.tp.dao;

/**
 *
 * @author tomas
 */
public class SqlFabricaDAO extends FabricaDAO {
    
    @Override
    public ClienteDAO getClienteDao(){
        return new ClienteDAOImplSql();
    }
    
    @Override
    public AgendaDAO getAgendaDao(){
        return new AgendaDAOImplSql();
    }
    
    @Override
    public CompSegurosDAO getCompSegurosDao(){
        return new CompSegurosDAOImplSql();
    }

    @Override
    public DetalleDAO getDetalleDao() {
        return new DetalleDAOImplSql();
    }

    @Override
    public EmpleadoDAO getEmpleadoDao() {
        return new EmpleadoDAOImplSql();
    }

    @Override
    public EspecialidadDAO getEspecialidadDao() {
        return new EspecialidadDAOImplSql();
    }

    @Override
    public FacturaDAO getFacturaDao() {
        return new FacturaDAOImplSql();
    }

    @Override
    public FichaDAO getFichaDao() {
        return new FichaDAOImplSql();
    }

    @Override
    public MaterialDAO getMaterialDao() {
        return new MaterialDAOImplSql();
    }

    @Override
    public MecanicoDAO getMecanicoDao() {
        return new MecanicoDAOImplSql();
    }

    @Override
    public TurnoDAO getTurnoDao() {
        return new TurnoDAOImplSql();
    }

    @Override
    public UsuarioDAO getUsuarioDAO() {
        return new UsuarioDAOImplSql();
    }

    @Override
    public VehiculoDAO getVehiculoDao() {
        return new VehiculoDAOImplSql();
    }
    
}
