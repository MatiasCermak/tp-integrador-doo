/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubp.doo.tp.controlador;

import ubp.doo.tp.modelo.Modelo;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import ubp.doo.tp.vista.InterfazVista;
import ubp.doo.tp.vista.InterfazVistaSelCli;

/**
 *
 * @author tomas
 */
public abstract class Controlador extends MouseAdapter implements ActionListener, KeyListener {
    InterfazVista VISTASELCLI = null;
    InterfazVista VISTAREGCLI = null;
    Modelo MODELO = null;
}
