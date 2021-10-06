/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubp.doo.tp.dto;

import ubp.doo.tp.dao.CompSegurosDAO;
import ubp.doo.tp.dao.CompSegurosDAOImplSql;

/**
 *
 * @author tomas
 */
public class VehiculoDTO {
    
    private String aseguradora;
    
    private int poliza;
    
    private String matricula;
    
    private String modelo;
    
    private String marca;
    
    private String dniTipo;
    
    private int dni;

    public VehiculoDTO() {
    }

    public VehiculoDTO(String aseguradora, int poliza, String matricula, String modelo, String marca) {
        this.aseguradora = aseguradora;
        this.poliza = poliza;
        this.matricula = matricula;
        this.modelo = modelo;
        this.marca = marca;
    }

    public String getAseguradora() {
        return aseguradora;
    }

    public void setAseguradora(String aseguradora) {
        this.aseguradora = aseguradora;
    }

    public int getPoliza() {
        return poliza;
    }

    public void setPoliza(int poliza) {
        this.poliza = poliza;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDniTipo() {
        return dniTipo;
    }

    public void setDniTipo(String dniTipo) {
        this.dniTipo = dniTipo;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }
}
