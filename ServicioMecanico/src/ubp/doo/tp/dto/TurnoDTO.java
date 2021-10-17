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
    
    private int id_turno;
    
    private int cliente_dni;
    
    private String cliente_dniTipo;
    
    private String matricula_vehiculo;
    
    private Date fecha;
    
    private int hora;
    
    private int estado;
    
    private int asistencia;
    
    private int id_agenda;

    public TurnoDTO() {
    }

    public TurnoDTO(int id_turno, int cliente_dni, String cliente_dniTipo, String matricula_vehiculo, Date fecha, int hora, int estado, int asistencia, int id_agenda) {
        this.id_turno = id_turno;
        this.cliente_dni = cliente_dni;
        this.cliente_dniTipo = cliente_dniTipo;
        this.matricula_vehiculo = matricula_vehiculo;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
        this.asistencia = asistencia;
        this.id_agenda = id_agenda;
    }

    public int getId_turno() {
        return id_turno;
    }

    public void setId_turno(int id_turno) {
        this.id_turno = id_turno;
    }

    public int getCliente_dni() {
        return cliente_dni;
    }

    public void setCliente_dni(int cliente_dni) {
        this.cliente_dni = cliente_dni;
    }

    public String getCliente_dniTipo() {
        return cliente_dniTipo;
    }

    public void setCliente_dniTipo(String cliente_dniTipo) {
        this.cliente_dniTipo = cliente_dniTipo;
    }

    public String getMatricula_vehiculo() {
        return matricula_vehiculo;
    }

    public void setMatricula_vehiculo(String matricula_vehiculo) {
        this.matricula_vehiculo = matricula_vehiculo;
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

    public int getId_agenda() {
        return id_agenda;
    }

    public void setId_agenda(int id_agenda) {
        this.id_agenda = id_agenda;
    }
}
