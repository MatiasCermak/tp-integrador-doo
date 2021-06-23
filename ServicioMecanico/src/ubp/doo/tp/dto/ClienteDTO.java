/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ubp.doo.tp.dto;

import ubp.doo.tp.vehiculo.Vehiculo;
import java.util.ArrayList;

public class ClienteDTO extends Persona {
    private ArrayList<Vehiculo> listaVehiculo;

    public ClienteDTO() {
        this.listaVehiculo = new ArrayList<Vehiculo>();
    }

    public ClienteDTO(String nombre, String dniTipo, int dniNumero) {
        super(nombre, dniTipo, dniNumero);
    }

    public ArrayList<Vehiculo> getListaVehiculo() {
        return listaVehiculo;
    }
    
    public void addVehiculo(Vehiculo v){
        this.listaVehiculo.add(v);
    }
    
    public Vehiculo getVehiculo(String auto){
        return this.listaVehiculo.get(this.listaVehiculo.indexOf(auto));
    }
}