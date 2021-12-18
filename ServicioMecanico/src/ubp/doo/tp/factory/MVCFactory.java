/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubp.doo.tp.factory;
import ubp.doo.tp.vista.Vista;
import ubp.doo.tp.modelo.Modelo;
import ubp.doo.tp.controlador.Controlador;
/**
 *
 * @author tomas
 */
public interface MVCFactory {
    public Vista CreateVista(String vista);
    public Modelo CreateModelo(String modelo);
    public Controlador CreateControlador(String controlador);
}
