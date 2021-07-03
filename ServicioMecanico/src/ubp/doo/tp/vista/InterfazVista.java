/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubp.doo.tp.vista;

import ubp.doo.tp.controlador.Controlador;

/**
 *
 * @author tomas
 */
public abstract interface InterfazVista {
    
    public static enum Operacion {
        NUEVOVEHI, CANCELREGCLI, CARGARSELCLI, CARGARREGCLI, NUEVOCLI, SELCLI, FILTCLI, CANCELSELCLI;;
    }
    
    void setControlador(Controlador c);
    
    void iniciaVista();
    
    void imprimeMensaje(Exception... e);
    
}