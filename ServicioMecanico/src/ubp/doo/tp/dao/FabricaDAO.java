/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubp.doo.tp.dao;

import java.lang.reflect.InvocationTargetException;

/**
 *
 * @author tomas
 */
public abstract class FabricaDAO {
    
    public abstract ClienteDAO getClienteDao();
    
    public abstract AgendaDAO getAgendaDao();
    
    public abstract CompSegurosDAO getCompSegurosDao();
    
    public abstract DetalleDAO getDetalleDao();
    
    public abstract EmpleadoDAO getEmpleadoDao();
    
    public abstract EspecialidadDAO getEspecialidadDao();
    
    public abstract FacturaDAO getFacturaDao();
    
    public abstract FichaDAO getFichaDao();
    
    public abstract MaterialDAO getMaterialDao();
    
    public abstract MecanicoDAO getMecanicoDao();
    
    public abstract TurnoDAO getTurnoDao();
    
    public abstract UsuarioDAO getUsuarioDAO();
    
    public abstract VehiculoDAO getVehiculoDao();
    
    public static FabricaDAO getFactory(String nombreClase){
        try {            
            return (FabricaDAO) Class.forName(FabricaDAO.class.getPackageName() + "." + nombreClase).getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException e) {
            System.err.println(e);
            throw new IllegalArgumentException();
        }
    }
}
