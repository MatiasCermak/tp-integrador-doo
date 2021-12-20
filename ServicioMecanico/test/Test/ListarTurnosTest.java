/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Test;


import java.text.ParseException;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import ubp.doo.tp.modelo.MAgenda;
import ubp.doo.tp.modelo.MCliente;
import ubp.doo.tp.modelo.Modelo;
import java.util.Date;
import java.text.SimpleDateFormat;  

/**
 *
 * @author chino
 */
public class ListarTurnosTest {
    
    @Test
    public void testListarTurnos1() throws ParseException {
        Modelo mod = new MAgenda();
        
        String sDate="2021/12/20";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        Date date = formatter.parse(sDate);  

        
        List<Integer> result = ((MAgenda)mod).listarHorasDisponibles(1,date);
        assertEquals(7,result.size());
    }
    
    @Test
    public void testListarTurnos2() throws ParseException {
        Modelo mod = new MAgenda();
        
        String sDate="2021/12/21";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        Date date = formatter.parse(sDate);  

        
        List<Integer> result = ((MAgenda)mod).listarHorasDisponibles(1,date);
        assertEquals(10,result.size());
    }

}
