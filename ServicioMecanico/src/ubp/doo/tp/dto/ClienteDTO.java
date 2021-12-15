/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ubp.doo.tp.dto;

import ubp.doo.tp.Utils.Persona;
import java.util.ArrayList;

public class ClienteDTO extends Persona {

    public ClienteDTO() {
    }

    public ClienteDTO(String nombre, String apellido, String dniTipo, int dniNumero) {
        super(nombre, apellido, dniTipo, dniNumero);
    }
}