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
public abstract interface InterfazVistaFlujoRegTurno {
    
    public static enum Operacion {
        RCNUEVOVEHI, RCCANCELAR, RCCARGAR, SCCARGAR, CARGARREGCLI, SCNUEVOCLI, SCSELCLI, SCFILTCLI, SCCANCELAR, RTCANCELAR, RTSIGUIENTE, RTEXAMCLI, RTNUEVOVEHI;
    }
    
    void setControlador(Controlador c);
    
    void iniciaVista();
    
    void imprimeMensaje(Exception... e);
    
}
