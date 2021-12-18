 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubp.doo.tp.main;

import com.formdev.flatlaf.FlatLightLaf;
import ubp.doo.tp.facade.FacadeInitOpciones;
import ubp.doo.tp.controlador.ControladorFlujoRegTurnos;
import ubp.doo.tp.controlador.Controlador;
import ubp.doo.tp.modelo.MCliente;
import ubp.doo.tp.modelo.Modelo;
import ubp.doo.tp.vista.SelClienteFr;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import ubp.doo.tp.facade.Facade;
import ubp.doo.tp.vista.InterfazVistaSelCliente;
import ubp.doo.tp.vista.RegClienteFr;
import ubp.doo.tp.vista.RegTurnoFr;
import ubp.doo.tp.vista.InterfazVistaRegTurno;
import ubp.doo.tp.vista.SelAgendaFr;
import ubp.doo.tp.vista.InterfazVistaSelAgenda;
import ubp.doo.tp.vista.RegVehiculoFr;
import ubp.doo.tp.vista.InterfazVistaRegVehiculo;
import ubp.doo.tp.vista.InterfazVistaFlujoRegTurno;

/**
 *
 * @author chino
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                try {
                    UIManager.setLookAndFeel(new FlatLightLaf());
                } catch (UnsupportedLookAndFeelException ex) {
                    System.err.println("Failed to initialize LaF");
                }
                
                FacadeInitOpciones facadeOpciones = new FacadeInitOpciones();
                facadeOpciones.execFlujo("RegistrarTurno");
            }
        });
    }
    
}