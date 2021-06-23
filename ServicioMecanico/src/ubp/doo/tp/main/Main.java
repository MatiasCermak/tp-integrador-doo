/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubp.doo.tp.main;

import com.formdev.flatlaf.FlatLightLaf;
import ubp.doo.tp.controlador.ControladorFlujoTurno;
import ubp.doo.tp.controlador.Controlador;
import ubp.doo.tp.modelo.Cliente;
import ubp.doo.tp.modelo.Modelo;
import ubp.doo.tp.vista.SelClienteFr;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import ubp.doo.tp.vista.InterfazVista;
import ubp.doo.tp.vista.InterfazVistaSelCli;
import ubp.doo.tp.vista.RegClienteFr;

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
                
                Modelo modelo = new Cliente();
                
                InterfazVista vistaSelCli = SelClienteFr.getInstancia();
                
                InterfazVista vistaRegCli = RegClienteFr.getInstancia();
                
                Controlador control = new ControladorFlujoTurno(vistaSelCli,vistaRegCli,modelo);
                
                vistaSelCli.setControlador(control);
                
                vistaRegCli.setControlador(control);
                
                vistaSelCli.iniciaVista();
            }
        });
    }
    
}
