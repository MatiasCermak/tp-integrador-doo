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
    
    private EspecialidadDTO especialidad;
    
    private float costoHora;

    public MecanicoDTO() {
    }

    public MecanicoDTO(EspecialidadDTO especialidad, float costoHora, float salario, String rol, String nombre, String apellido, String dniTipo, int dniNumero) {
        super(salario, rol,nombre, apellido, dniTipo, dniNumero);
        this.especialidad = especialidad;
        this.costoHora = costoHora;
    }

    public EspecialidadDTO getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(EspecialidadDTO especialidad) {
        this.especialidad = especialidad;
    }

    public float getCostoHora() {
        return costoHora;
    }

    public void setCostoHora(float costoHora) {
        this.costoHora = costoHora;
    }
}
