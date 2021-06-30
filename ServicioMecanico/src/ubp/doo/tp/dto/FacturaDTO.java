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
public class FacturaDTO {
    
    private CompSegurosDTO aseguradora;
    
    private ArrayList<String> servicios;
    
    private float costoTotal;
    
    private float pagoRealizado;

    public FacturaDTO() {
    }

    public FacturaDTO(CompSegurosDTO aseguradora, float costoTotal, float pagoRealizado) {
        this.aseguradora = aseguradora;
        this.costoTotal = costoTotal;
        this.pagoRealizado = pagoRealizado;
    }

    public CompSegurosDTO getAseguradora() {
        return aseguradora;
    }

    public void setAseguradora(CompSegurosDTO aseguradora) {
        this.aseguradora = aseguradora;
    }

    public float getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(float costoTotal) {
        this.costoTotal = costoTotal;
    }

    public float getPagoRealizado() {
        return pagoRealizado;
    }

    public void setPagoRealizado(float pagoRealizado) {
        this.pagoRealizado = pagoRealizado;
    }

    public ArrayList<String> getServicios() {
        return servicios;
    }
    
    public void agregarServicio (String servicio){
        this.servicios.add(servicio);
    }
}
