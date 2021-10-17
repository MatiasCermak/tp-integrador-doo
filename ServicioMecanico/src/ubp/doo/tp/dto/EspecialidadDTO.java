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
public class EspecialidadDTO {
    
    private int id_especialidad;
    
    private String nombre;
    
    public EspecialidadDTO() {
    }

    public EspecialidadDTO(int id_especialidad, String nombre) {
        this.id_especialidad = id_especialidad;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_especialidad() {
        return id_especialidad;
    }

    public void setId_especialidad(int id_especialidad) {
        this.id_especialidad = id_especialidad;
    }
    
}
