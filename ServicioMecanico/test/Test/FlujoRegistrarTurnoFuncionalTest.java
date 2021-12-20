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
    private final String ConfirmClientRegisterButton = baseUrl + "1639979844802.png";
    private final String ClientRow = baseUrl + "1639981021246.png";
    private final String SeleccionarButton = baseUrl + "1639981225663.png";
    private final String NuevoButton = baseUrl + "1639981280565.png";
    private final String MatriculaTextField = baseUrl + "1639981096828.png";
    private final String NroPolTextField = baseUrl + "1639981378527.png";
    private final String ModeloTextField = baseUrl + "1639981390552.png";
    private final String MarcaTextField = baseUrl + "1639981404836.png";
    private final String RegistrarButton = baseUrl + "1639981443946.png";
    private final String Nombre = "John";
    private final String Apellido = "Doe";
    private final String DNI = "12121212";
    
    @Test
    public void RegistrarClientesTestFuncional(){
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
        /*try{
            screen.find(NombreTextField);
        }
        catch (FindFailed ex){
            fail(NombreTextField + " no fue encontrado");
        }*/
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
        try{
            screen.click(ConfirmClientRegisterButton);
        }
        catch (FindFailed ex){
            fail(ConfirmClientRegisterButton + " no fue encontrado");
        }
        
        
    }
    
    @Test
    public void RegistrarVehiculoTestFuncional(){
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
            screen.click(ClientRow);
        }
        catch (FindFailed ex){
            fail(ClientRow + " no fue encontrado");
        }
        try{
            screen.click(SeleccionarButton);
        }
        catch (FindFailed ex){
            fail(SeleccionarButton + " no fue encontrado");
        }
        try{
            screen.click(NuevoButton);
        }
        catch (FindFailed ex){
            fail(NuevoButton + " no fue encontrado");
        }
        try{
            screen.click(MatriculaTextField);
            screen.type("AD673KY");
        }
        catch (FindFailed ex){
            fail(MatriculaTextField + " no fue encontrado");
        }
        try{
            screen.click(NroPolTextField);
            screen.type("21312567");
        }
        catch (FindFailed ex){
            fail(NroPolTextField + " no fue encontrado");
        }
        try{
            screen.click(ModeloTextField);
            screen.type("LFA");
        }
        catch (FindFailed ex){
            fail(ModeloTextField + " no fue encontrado");
        }
        try{
            screen.click(MarcaTextField);
            screen.type("Lexus");
        }
        catch (FindFailed ex){
            fail(MarcaTextField + " no fue encontrado");
        }
        try{
            screen.click(RegistrarButton);
        }
        catch (FindFailed ex){
            fail(RegistrarButton + " no fue encontrado");
        }
    }
}
