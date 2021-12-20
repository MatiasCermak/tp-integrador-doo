/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Test;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import ubp.doo.tp.dto.TurnoDTO;
import ubp.doo.tp.modelo.Modelo;
import ubp.doo.tp.modelo.MTurno;
import java.util.List;

/**
 *
 * @author chino
 */
public class TurnosTest {
    private TurnoDTO turno1;
    private TurnoDTO turno2;
    private TurnoDTO turno3;
    private static Modelo mod = new MTurno();

    public TurnosTest() throws ParseException{
        turno1 = new TurnoDTO(-1, 16161617, "DNI", "TEST2", new SimpleDateFormat("yyyy/MM/dd").parse("2021/12/20"),10,1,1,2);
        List<TurnoDTO> turnos = ((MTurno)mod).listarTurnos();
        System.out.println(turnos);
        turno2 = turnos.get(0);
        turno3 = turnos.get(turnos.size() - 1);
    }
            
    @Test
    public void testCreateTurno(){
        boolean result = ((MTurno)mod).insertarTurno(turno1);
        assertTrue(result);
        assertTrue(turno1.getId_turno() != -1);
    }
    
    @Test
    public void testUpdateTurno() throws ParseException {
        String sDate="2021/12/22";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        turno2.setFecha(formatter.parse(sDate));
        boolean result = ((MTurno)mod).modificarTurno(turno2);
        assertTrue(result);
    }
    
    @Test
    public void testDeleteTurno(){
        boolean result = ((MTurno)mod).eliminarTurno(turno3);
        assertTrue(result);
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
