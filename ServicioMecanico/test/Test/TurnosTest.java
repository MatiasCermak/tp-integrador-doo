/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Test;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import ubp.doo.tp.dto.TurnoDTO;
import ubp.doo.tp.modelo.Modelo;
import ubp.doo.tp.modelo.MTurno;

/**
 *
 * @author chino
 */
public class TurnosTest {
    private TurnoDTO turno;

    public TurnosTest() throws ParseException {
        this.turno = new TurnoDTO(-1, 16161617, "DNI", "TEST2", new SimpleDateFormat("yyyy/MM/dd").parse("2021/12/20"),10,1,1,2);
    }
            
    @Test@Before
    public void testCreateTurno() throws ParseException {
        Modelo mod = new MTurno();
        boolean result = ((MTurno)mod).insertarTurno(turno);
        assertTrue(result);
    }
    
    @Test
    public void testUpdateTurno() throws ParseException {
        Modelo mod = new MTurno();
        turno = ((MTurno)mod).buscarTurno(turno.getId_agenda(), turno.getFecha(), turno.getHora());
        String sDate="2021/12/22";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        this.turno.setFecha(formatter.parse(sDate));
        boolean result = ((MTurno)mod).modificarTurno(turno);
        assertTrue(result);
    }
    
    @Test@After
    public void testDeleteTurno() throws ParseException {
        Modelo mod = new MTurno();
        turno = ((MTurno)mod).buscarTurno(turno.getId_agenda(), turno.getFecha(), turno.getHora());
        boolean result = ((MTurno)mod).eliminarTurno(turno);
        
        assertTrue(result);
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
