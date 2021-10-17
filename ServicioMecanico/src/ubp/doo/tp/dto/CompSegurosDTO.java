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
public class CompSegurosDTO {
    
    private int id_comp_seguros;
    
    private String nombre;

    public CompSegurosDTO() {
    }

    public CompSegurosDTO(int id_comp_seguros, String nombre) {
        this.id_comp_seguros = id_comp_seguros;
        this.nombre = nombre;
    }

    public int getId_comp_seguros() {
        return id_comp_seguros;
    }

    public void setId_comp_seguros(int id_comp_seguros) {
        this.id_comp_seguros = id_comp_seguros;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
