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
public class AgendaDTO {
    
    private int horaInicio;
    
    private int horaFin;
    
    private EmpleadoDTO empleado;

    public AgendaDTO() {
    }

    public AgendaDTO(int horaInicio, int horaFin, EmpleadoDTO empleado) {
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.empleado = empleado;
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(int horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(int horaFin) {
        this.horaFin = horaFin;
    }

    public EmpleadoDTO getEmpleado() {
        return empleado;
    }

    public void setEmpleado(EmpleadoDTO empleado) {
        this.empleado = empleado;
    }
}
