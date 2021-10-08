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
    
    private MaterialDTO material;
    
    private int cantidad;
    
    private FichaDTO ficha;

    public DetalleDTO(MaterialDTO material, int cantidad, FichaDTO ficha) {
        this.material = material;
        this.cantidad = cantidad;
        this.ficha = ficha;
    }

    public DetalleDTO() {
    }

    public MaterialDTO getMaterial() {
        return material;
    }

    public void setMaterial(MaterialDTO material) {
        this.material = material;
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

    public void setFicha(FichaDTO ficha) {
        this.ficha = ficha;
    }
}
