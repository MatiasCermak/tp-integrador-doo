/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubp.doo.tp.dto;

import java.util.Date;
/**
 *
 * @author tomas
 */
public class TurnoDTO {
    
    private ClienteDTO cliente;
    
    private VehiculoDTO vehiculo;
    
    private Date fecha;
    
    private int hora;
    
    private int estado;
    
    private int asistencia;
    
    private AgendaDTO agenda;

    public TurnoDTO() {
    }

    public TurnoDTO(ClienteDTO cliente, VehiculoDTO vehiculo, Date fecha, int hora, int estado, int asistencia, AgendaDTO agenda) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
        this.asistencia = asistencia;
        this.agenda = agenda;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public VehiculoDTO getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(VehiculoDTO vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(int asistencia) {
        this.asistencia = asistencia;
    }

    public AgendaDTO getAgenda() {
        return agenda;
    }

    public void setAgenda(AgendaDTO agenda) {
        this.agenda = agenda;
    }

    
}
