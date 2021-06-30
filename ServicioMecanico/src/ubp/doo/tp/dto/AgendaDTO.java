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
    
    private ArrayList<TurnoDTO> turnos;
    
    public void agregarTurno (TurnoDTO t){
        this.turnos.add(t);
    }

    public ArrayList<TurnoDTO> getTurnos() {
        return turnos;
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

    public AgendaDTO(int horaInicio, int horaFin) {
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public AgendaDTO() {
    }
}
