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

    public TurnoDTO(Date fecha, int hora) {
        this.fecha = fecha;
        this.hora = hora;
        this.estado = 0;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public VehiculoDTO getVehiculo() {
        return vehiculo;
    }

    public Date getFecha() {
        return fecha;
    }

    public int getHora() {
        return hora;
    }

    public int getEstado() {
        return estado;
    }

    public int getAsistencia() {
        return asistencia;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public void setVehiculo(VehiculoDTO vehiculo) {
        this.vehiculo = vehiculo;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void setAsistencia(int asistencia) {
        this.asistencia = asistencia;
    }
}
