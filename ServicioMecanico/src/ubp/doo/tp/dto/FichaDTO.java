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
public class FichaDTO {
    
    private TurnoDTO turno;
    
    private boolean conformidad;
    
    private String motivoConformidad;
    
    private String etapa;
    
    private ArrayList<DetalleDTO> detalles;
    
    private ArrayList<String> actividades;

    public FichaDTO() {
    }

    public FichaDTO(TurnoDTO turno, boolean conformidad, String motivoConformidad, String etapa) {
        this.turno = turno;
        this.conformidad = conformidad;
        this.motivoConformidad = motivoConformidad;
        this.etapa = etapa;
    }

    public TurnoDTO getTurno() {
        return turno;
    }

    public void setTurno(TurnoDTO turno) {
        this.turno = turno;
    }

    public boolean isConformidad() {
        return conformidad;
    }

    public void setConformidad(boolean conformidad) {
        this.conformidad = conformidad;
    }

    public String getMotivoConformidad() {
        return motivoConformidad;
    }

    public void setMotivoConformidad(String motivoConformidad) {
        this.motivoConformidad = motivoConformidad;
    }

    public String getEtapa() {
        return etapa;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }

    public ArrayList<DetalleDTO> getDetalles() {
        return detalles;
    }

    public ArrayList<String> getActividades() {
        return actividades;
    }
    
    public void agregarDetalle (DetalleDTO detalle){
        this.detalles.add(detalle);
    }
    
    public void agregarActividad (String actividad){
        this.actividades.add(actividad);
    }
}
