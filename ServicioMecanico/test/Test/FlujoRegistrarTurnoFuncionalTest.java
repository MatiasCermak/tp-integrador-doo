/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ubp.doo.tp.main.Main;
import java.lang.Thread;
import junit.framework.Assert;
import org.sikuli.script.Screen;
import org.sikuli.script.FindFailed;

/**
 *
 * @author mcrmak
 */
public class FlujoRegistrarTurnoFuncionalTest  {
    private final String projectUrl = System.getProperty("user.dir");
    private final String baseUrl = projectUrl + "/test/TestImages.sikuli/";
    private final String ExaminarButton = baseUrl + "1639957174740.png";
    private final String AgregarClienteButton = baseUrl + "1639957360715.png";
    private final String NombreTextField = baseUrl + "1639957395607.png";
    private final String ApellidoTextField = baseUrl + "1639957426909.png";
    private final String DNITextField = baseUrl + "1639957504814.png";
    private final String SiguienteButton = baseUrl + "1639957552386.png";
    private final String Nombre = "John";
    private final String Apellido = "Doe";
    private final String DNI = "12121212";
    @Test
    public void FlujoRegistrarTurnoTestFuncional(){
        System.out.println(projectUrl);
        String[] str = {""};
        Main.main(str);
        Screen screen = Screen.all();
        try{
            screen.click(ExaminarButton);
        }
        catch (FindFailed ex){
            fail(ExaminarButton + " no fue encontrado");
        }
        try{
            screen.click(AgregarClienteButton);
        }
        catch (FindFailed ex){
            fail(AgregarClienteButton + " no fue encontrado");
        }
        try{
            screen.find(NombreTextField);
        }
        catch (FindFailed ex){
            fail(NombreTextField + " no fue encontrado");
        }
        screen.type(Nombre);
        try{
            screen.click(ApellidoTextField);
        }
        catch (FindFailed ex){
            fail(ApellidoTextField + " no fue encontrado");
        }
        screen.type(Apellido);
        try{
            screen.click(DNITextField);
        }
        catch (FindFailed ex){
            fail(DNITextField + " no fue encontrado");
        }
        screen.type(DNI);
        try{
            screen.click(SiguienteButton);
        }
        catch (FindFailed ex){
            fail(SiguienteButton + " no fue encontrado");
        }
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
