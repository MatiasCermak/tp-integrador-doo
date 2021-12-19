/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubp.doo.tp.dto;

import java.util.ArrayList;
/**
 *
 * @author tomas
 */
public class MecanicoDTO extends EmpleadoDTO{
    
    private int id_especialidad;
    
    private float costoHora;

    public MecanicoDTO() {
    }

    public MecanicoDTO(int id_especialidad, float costoHora, 
            int id_empleado, float salario, String rol, 
            String nombre, String apellido, String dniTipo, 
            int dniNumero) {
        super(id_empleado, salario, rol, nombre, apellido, dniTipo, dniNumero);
        this.id_especialidad = id_especialidad;
        this.costoHora = costoHora;
    }

    public float getCostoHora() {
        return costoHora;
    }

    public void setCostoHora(float costoHora) {
        this.costoHora = costoHora;
    }

    public int getId_especialidad() {
        return id_especialidad;
    }

    public void setId_especialidad(int id_especialidad) {
        this.id_especialidad = id_especialidad;
    }
    
    
}
