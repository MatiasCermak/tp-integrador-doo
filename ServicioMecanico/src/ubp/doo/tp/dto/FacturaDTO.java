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
    
    private int id_factura;
    
    private int id_comp_seguros;
    
    private float costoTotal;
    
    private float pagoRealizado;

    public FacturaDTO() {
    }

    public FacturaDTO(int id_factura, int id_comp_seguros, float costoTotal, float pagoRealizado) {
        this.id_factura = id_factura;
        this.id_comp_seguros = id_comp_seguros;
        this.costoTotal = costoTotal;
        this.pagoRealizado = pagoRealizado;
    }

    public int getId_factura() {
        return id_factura;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }

    public int getId_comp_seguros() {
        return id_comp_seguros;
    }

    public void setId_comp_seguros(int id_comp_seguros) {
        this.id_comp_seguros = id_comp_seguros;
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
}
