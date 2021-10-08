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
public class UsuarioDTO {
    
    private String user;
    
    private String password;
    
    private EmpleadoDTO empleado;

    public UsuarioDTO() {
    }

    public UsuarioDTO(String user, String password, EmpleadoDTO empleado) {
        this.user = user;
        this.password = password;
        this.empleado = empleado;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public EmpleadoDTO getEmpleado() {
        return empleado;
    }

    public void setEmpleado(EmpleadoDTO empleado) {
        this.empleado = empleado;
    }
}
