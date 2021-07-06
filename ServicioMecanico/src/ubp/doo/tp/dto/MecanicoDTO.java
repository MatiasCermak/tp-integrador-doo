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
    
    private AgendaDTO agenda;

    public MecanicoDTO() {
    }

    public MecanicoDTO(EspecialidadDTO especialidad, float costoHora, AgendaDTO agenda, float salario, String rol, UsuarioDTO usuario, String nombre, String apellido, int dniTipo, int dniNumero) {
        super(salario, rol, usuario, nombre, apellido, dniTipo, dniNumero);
        this.especialidad = especialidad;
        this.costoHora = costoHora;
        this.agenda = agenda;
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

    public AgendaDTO getAgenda() {
        return agenda;
    }

    public void setAgenda(AgendaDTO agenda) {
        this.agenda = agenda;
    }
    
}
