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
public interface InterfazVistaFlujoRegTurno extends Vista {
    
    public static enum Operacion {
        RCNUEVOVEHI, RCCANCELAR, RCCARGAR,  
        SCNUEVOCLI, SCCARGAR, SCSELCLI, SCFILTCLI, SCCANCELAR, 
        RTCARGAR, RTCANCELAR, RTSIGUIENTE, RTEXAMCLI, RTNUEVOVEHI, 
        SACARGAR, SAACEPTAR, SACANCELAR,
        RVREGISTRAR, RVCANCELAR, RVCARGAR;
    }
    
    void setControlador(Controlador c);
    
    void iniciaVista();
    
    void cierraVista();
    
    void limpiar();
    
    void imprimeMensaje(Exception... e);
    
}
