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
    
    private int id_detalle;
    
    private int id_material;
    
    private int cantidad;
    
    private int id_ficha;

    public DetalleDTO() {
    }

    public DetalleDTO(int id_detalle, int id_material, int cantidad, int id_ficha) {
        this.id_detalle = id_detalle;
        this.id_material = id_material;
        this.cantidad = cantidad;
        this.id_ficha = id_ficha;
    }

    public int getId_detalle() {
        return id_detalle;
    }

    public void setId_detalle(int id_detalle) {
        this.id_detalle = id_detalle;
    }

    public int getId_material() {
        return id_material;
    }

    public void setId_material(int id_material) {
        this.id_material = id_material;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getId_ficha() {
        return id_ficha;
    }

    public void setId_ficha(int id_ficha) {
        this.id_ficha = id_ficha;
    }
}
