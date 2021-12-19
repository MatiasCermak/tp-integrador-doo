/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubp.doo.tp.factory;

import ubp.doo.tp.controlador.Controlador;
import ubp.doo.tp.controlador.ControladorFlujoRegTurnos;
import ubp.doo.tp.modelo.MAgenda;
import ubp.doo.tp.modelo.MCliente;
import ubp.doo.tp.modelo.MCompSeguros;
import ubp.doo.tp.modelo.MEspecialidad;
import ubp.doo.tp.modelo.MMecanico;
import ubp.doo.tp.modelo.MTurno;
import ubp.doo.tp.modelo.MVehiculo;
import ubp.doo.tp.modelo.Modelo;
import ubp.doo.tp.vista.Vista;
import ubp.doo.tp.vista.RegClienteFr;
import ubp.doo.tp.vista.RegTurnoFr;
import ubp.doo.tp.vista.RegVehiculoFr;
import ubp.doo.tp.vista.SelAgendaFr;
import ubp.doo.tp.vista.SelClienteFr;

/**
 *
 * @author tomas
 */
public class MVCFactoryFlujoRegistrarTurnos implements MVCFactory {

    @Override
    public Vista CreateVista(String vista) {
        Vista aux = null;
        switch (vista){
            case "RegTurno" -> {
                aux = RegTurnoFr.getInstancia();
            }
            case "SelCliente" -> {
                aux = SelClienteFr.getInstancia();
            }
            case "RegCliente" -> {
                aux = RegClienteFr.getInstancia();
            }
            case "RegVehiculo" -> {
                aux = RegVehiculoFr.getInstancia();
            }
            case "SelAgenda" -> {
                aux = SelAgendaFr.getInstancia();
            }
        }
        return aux;
    }

    @Override
    //Modelos se llaman con la forma PLURAL a lo que referencian
    public Modelo CreateModelo(String modelo) {
        Modelo aux = null;
        switch (modelo){
            case "Clientes" -> {
                aux = new MCliente();
            }
            case "Agendas" -> {
                aux = new MAgenda();
            }
            case "CompSeguros" -> {
                aux = new MCompSeguros();
            }
            case "Especialidades" -> {
                aux = new MEspecialidad();
            }
            case "Mecanicos" -> {
                aux = new MMecanico();
            }
            case "Turnos" -> {
                aux = new MTurno();
            }
            case "Vehiculos" -> {
                aux = new MVehiculo();
            }
        }
        return aux;
    }

    @Override
    //En este flujo usamos solo un controlador
    public Controlador CreateControlador(String controlador) {
        return new ControladorFlujoRegTurnos();
    }
    
}
