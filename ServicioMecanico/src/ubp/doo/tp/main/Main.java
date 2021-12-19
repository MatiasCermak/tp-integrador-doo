 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubp.doo.tp.main;

import com.formdev.flatlaf.FlatLightLaf;
import ubp.doo.tp.facade.FacadeInitOpciones;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

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