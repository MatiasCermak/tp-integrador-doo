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
    
    private int id_comp_seguros;
    
    private int dni_cliente;
    
    private String dniTipo_cliente;
    
    private String poliza;
    
    private String matricula;
    
    private String modelo;
    
    private String marca;

    public VehiculoDTO() {
    }

    public VehiculoDTO(int id_comp_seguros, int dni_cliente, String dniTipo_cliente, String poliza, String matricula, String modelo, String marca) {
        this.id_comp_seguros = id_comp_seguros;
        this.dni_cliente = dni_cliente;
        this.dniTipo_cliente = dniTipo_cliente;
        this.poliza = poliza;
        this.matricula = matricula;
        this.modelo = modelo;
        this.marca = marca;
    }

    public int getId_comp_seguros() {
        return id_comp_seguros;
    }

    public void setId_comp_seguros(int id_comp_seguros) {
        this.id_comp_seguros = id_comp_seguros;
    }

    public int getDni_cliente() {
        return dni_cliente;
    }

    public void setDni_cliente(int dni_cliente) {
        this.dni_cliente = dni_cliente;
    }

    public String getDniTipo_cliente() {
        return dniTipo_cliente;
    }

    public void setDniTipo_cliente(String dniTipo_cliente) {
        this.dniTipo_cliente = dniTipo_cliente;
    }

    public String getPoliza() {
        return poliza;
    }

    public void setPoliza(String poliza) {
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
