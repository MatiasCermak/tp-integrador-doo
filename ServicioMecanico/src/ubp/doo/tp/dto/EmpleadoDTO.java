/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubp.doo.tp.dto;

import ubp.doo.tp.Utils.Persona;

/**
 *
 * @author tomas
 */
public class EmpleadoDTO extends Persona{
    
    private float salario;
    
    private String rol;

    public EmpleadoDTO() {
    }

    public EmpleadoDTO(float salario, String rol,String nombre, String apellido, String dniTipo, int dniNumero) {
        super(nombre, apellido, dniTipo, dniNumero);
        this.salario = salario;
        this.rol = rol;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    } 
}
