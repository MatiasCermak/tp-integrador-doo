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
    
    private int id_ficha;
    
    private int id_turno;
    
    private boolean conformidad;
    
    private String motivoConformidad;
    
    private String etapa;

    public FichaDTO() {
    }

    public FichaDTO(int id_ficha, int id_turno, boolean conformidad, String motivoConformidad, String etapa) {
        this.id_ficha = id_ficha;
        this.id_turno = id_turno;
        this.conformidad = conformidad;
        this.motivoConformidad = motivoConformidad;
        this.etapa = etapa;
    }

    public int getId_ficha() {
        return id_ficha;
    }

    public void setId_ficha(int id_ficha) {
        this.id_ficha = id_ficha;
    }

    public int getId_turno() {
        return id_turno;
    }

    public void setId_turno(int id_turno) {
        this.id_turno = id_turno;
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
}
