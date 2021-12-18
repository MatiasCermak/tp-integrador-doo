/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubp.doo.tp.facade;

import ubp.doo.tp.controlador.Controlador;
import ubp.doo.tp.controlador.ControladorFlujoRegTurnos;
import ubp.doo.tp.factory.MVCFactory;
import ubp.doo.tp.factory.MVCFactoryFlujoRegistrarTurnos;
import ubp.doo.tp.modelo.MAgenda;
import ubp.doo.tp.modelo.MCliente;
import ubp.doo.tp.modelo.MCompSeguros;
import ubp.doo.tp.modelo.MEspecialidad;
import ubp.doo.tp.modelo.MMecanico;
import ubp.doo.tp.modelo.MTurno;
import ubp.doo.tp.modelo.MVehiculo;
import ubp.doo.tp.modelo.Modelo;
import ubp.doo.tp.vista.InterfazVistaFlujoRegTurno;

/**
 *
 * @author tomas
 */
public class FacadeInitOpciones implements Facade {
    
       public void FacadeInitOpciones(){}
    
       public void execFlujo(String flujo){
        switch (flujo){
            case "RegistrarTurno" -> {
                MVCFactory flujoRegistrarTurnoFactory = new MVCFactoryFlujoRegistrarTurnos();
                //Inicialización de Vistas, Controladores y Modelos
                InterfazVistaFlujoRegTurno regTurno = (InterfazVistaFlujoRegTurno) flujoRegistrarTurnoFactory.CreateVista("RegTurno");
                InterfazVistaFlujoRegTurno selCliente = (InterfazVistaFlujoRegTurno) flujoRegistrarTurnoFactory.CreateVista("SelCliente");
                InterfazVistaFlujoRegTurno regCliente = (InterfazVistaFlujoRegTurno) flujoRegistrarTurnoFactory.CreateVista("RegCliente");
                InterfazVistaFlujoRegTurno regVehiculo = (InterfazVistaFlujoRegTurno) flujoRegistrarTurnoFactory.CreateVista("RegVehiculo");
                InterfazVistaFlujoRegTurno selAgenda = (InterfazVistaFlujoRegTurno) flujoRegistrarTurnoFactory.CreateVista("SelAgenda"); 
                Controlador controladorFlujoRegTurno = (ControladorFlujoRegTurnos) flujoRegistrarTurnoFactory.CreateControlador("");
                Modelo mClientes = (MCliente) flujoRegistrarTurnoFactory.CreateModelo("Clientes");
                Modelo mAgendas = (MAgenda) flujoRegistrarTurnoFactory.CreateModelo("Agendas");
                Modelo mCompSeguros = (MCompSeguros) flujoRegistrarTurnoFactory.CreateModelo("CompSeguros");
                Modelo mEspecialidades = (MEspecialidad) flujoRegistrarTurnoFactory.CreateModelo("Especialidades");
                Modelo mMecanicos = (MMecanico) flujoRegistrarTurnoFactory.CreateModelo("Mecanicos");
                Modelo mTurnos = (MTurno) flujoRegistrarTurnoFactory.CreateModelo("Turnos");
                Modelo mVehiculo = (MVehiculo) flujoRegistrarTurnoFactory.CreateModelo("Vehiculos");
                
                ((ControladorFlujoRegTurnos)controladorFlujoRegTurno).setVistaRegCli(regCliente);
                ((ControladorFlujoRegTurnos)controladorFlujoRegTurno).setVistaRegTurno(regTurno);
                ((ControladorFlujoRegTurnos)controladorFlujoRegTurno).setVistaRegVehiculo(regVehiculo);
                ((ControladorFlujoRegTurnos)controladorFlujoRegTurno).setVistaSelAgenda(selAgenda);
                ((ControladorFlujoRegTurnos)controladorFlujoRegTurno).setVistaSelCli(selCliente);
                
                
                ((ControladorFlujoRegTurnos)controladorFlujoRegTurno).setMAgendas(mAgendas);
                ((ControladorFlujoRegTurnos)controladorFlujoRegTurno).setMClientes(mClientes);
                ((ControladorFlujoRegTurnos)controladorFlujoRegTurno).setMCompSeguros(mCompSeguros);
                ((ControladorFlujoRegTurnos)controladorFlujoRegTurno).setMEspecialidades(mEspecialidades);
                ((ControladorFlujoRegTurnos)controladorFlujoRegTurno).setMMecanicos(mMecanicos);
                ((ControladorFlujoRegTurnos)controladorFlujoRegTurno).setMTurnos(mTurnos);
                ((ControladorFlujoRegTurnos)controladorFlujoRegTurno).setMVehiculos(mVehiculo);
                
                
                selCliente.setControlador(controladorFlujoRegTurno);
                
                regCliente.setControlador(controladorFlujoRegTurno);
                
                regTurno.setControlador(controladorFlujoRegTurno);
                
                regVehiculo.setControlador(controladorFlujoRegTurno);
                
                selAgenda.setControlador(controladorFlujoRegTurno);
                
                regTurno.iniciaVista();
            }   
        }
    }
}
