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
    
    private int id_agenda;
    
    private int horaInicio;
    
    private int horaFin;
    
    private int id_empleado;

    public AgendaDTO() {
    }

    public AgendaDTO(int id_agenda, int horaInicio, int horaFin, int id_empleado) {
        this.id_agenda = id_agenda;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.id_empleado = id_empleado;
    }

    public int getId_agenda() {
        return id_agenda;
    }

    public void setId_agenda(int id_agenda) {
        this.id_agenda = id_agenda;
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

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }
}
