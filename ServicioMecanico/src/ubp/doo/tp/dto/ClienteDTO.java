/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ubp.doo.tp.dto;

import ubp.doo.tp.Utils.Persona;
import java.util.ArrayList;

public class ClienteDTO extends Persona {
    private ArrayList<VehiculoDTO> listaVehiculo;

    public ClienteDTO() {
        this.listaVehiculo = new ArrayList<VehiculoDTO>();
    }

    public ClienteDTO(String nombre, String apellido, String dniTipo, int dniNumero) {
        super(nombre, apellido, dniTipo, dniNumero);
    }

    public ArrayList<VehiculoDTO> getListaVehiculo() {
        return listaVehiculo;
    }
    
    public void addVehiculo(VehiculoDTO v){
        this.listaVehiculo.add(v);
    }
    
    public VehiculoDTO getVehiculo(String auto){
        return this.listaVehiculo.get(this.listaVehiculo.indexOf(auto));
    }
}