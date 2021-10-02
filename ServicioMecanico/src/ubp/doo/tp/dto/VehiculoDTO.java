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
    
    private CompSegurosDTO aseguradora;
    
    private int poliza;
    
    private String matricula;
    
    private String modelo;
    
    private String marca;

    public VehiculoDTO() {
    }

    public VehiculoDTO(String aseguradora, int poliza, String matricula, String modelo, String marca) {
        CompSegurosDAO cDao = new CompSegurosDAOImplSql();
        this.aseguradora = cDao.buscarComp(aseguradora);
        this.poliza = poliza;
        this.matricula = matricula;
        this.modelo = modelo;
        this.marca = marca;
    }

    public CompSegurosDTO getAseguradora() {
        return aseguradora;
    }

    public void setAseguradora(CompSegurosDTO aseguradora) {
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
    
}
