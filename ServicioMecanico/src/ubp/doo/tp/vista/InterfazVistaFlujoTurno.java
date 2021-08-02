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
public abstract interface InterfazVistaFlujoTurno {
    
    public static enum Operacion {
        RCNUEVOVEHI, RCCANCELAR, RCCARGAR,
        SCCARGAR, SCNUEVOCLI, SCSELCLI, SCFILTCLI, SCCANCELAR,
        RTEXAMCLI, RTNUEVOVEHI,RTSIGUIENTE, RTCANCELAR;
    }
    
    void setControlador(Controlador c);
    
    void iniciaVista();
    
    void imprimeMensaje(Exception... e);
    
}
