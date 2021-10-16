/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubp.doo.tp.dto;

/**
 *
 * @author tomas
 */
public class DetalleDTO {
    
    private MaterialDTO Material;
    
    private int cantidad;
    
    private FichaDTO ficha;
    
    private int idOperacion;

    public DetalleDTO() {
    }

    public DetalleDTO(MaterialDTO Material, int cantidad, FichaDTO Ficha, int idOperacion) {
        this.Material = Material;
        this.cantidad = cantidad;
        this.ficha = Ficha;
        this.idOperacion = idOperacion;
    }

    public MaterialDTO getMaterial() {
        return Material;
    }

    public void setMaterial(MaterialDTO Material) {
        this.Material = Material;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public FichaDTO getFicha() {
        return ficha;
    }

    public void setFicha(FichaDTO Ficha) {
        this.ficha = Ficha;
    }

    public int getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(int idOperacion) {
        this.idOperacion = idOperacion;
    }
}
