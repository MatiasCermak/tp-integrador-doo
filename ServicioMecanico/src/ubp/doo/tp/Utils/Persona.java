/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubp.doo.tp.Utils;

/**
 *
 * @author tomas
 */
public abstract class Persona {

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDniTipo() {
        return dniTipo;
    }

    public void setDniTipo(int dniTipo) {
        this.dniTipo = dniTipo;
    }

    public int getDniNumero() {
        return dniNumero;
    }

    public void setDniNumero(int dniNumero) {
        this.dniNumero = dniNumero;
    }

    public Persona() {
    }

    public Persona(String nombre, int dniTipo, int dniNumero) {
        this.nombre = nombre;
        this.dniTipo = dniTipo;
        this.dniNumero = dniNumero;
    }
    
    private String nombre;
    private int dniTipo;
    private int dniNumero;
    
    
}
