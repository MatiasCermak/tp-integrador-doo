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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdDniTipo() {
        return idDniTipo;
    }

    public void setIdDniTipo(int idDniTipo) {
        this.idDniTipo = idDniTipo;
    }

    public int getDniNumero() {
        return dniNumero;
    }

    public void setDniNumero(int dniNumero) {
        this.dniNumero = dniNumero;
    }

    public Persona() {
    }

    public Persona(String nombre, String apellido, int dniTipo, int dniNumero) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.idDniTipo = dniTipo;
        this.dniNumero = dniNumero;
    }
    
    private String nombre;
    private String apellido;
    private int idDniTipo;
    private int dniNumero;
    
    
}
