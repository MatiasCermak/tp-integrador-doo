/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubp.doo.tp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import ubp.doo.tp.dto.CompSegurosDTO;

/**
 *
 * @author tomas
 */
public class CompSegurosDAOImplSql implements CompSegurosDAO{

    private ConexionSql conexion = null;
    
    public void CompSegurosDAO(){
        conexion = ConexionSql.getInstancia();
    }
    
    @Override
    public CompSegurosDTO buscarComp(String nombre) {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        CompSegurosDTO compania = null;
        
        try {
            con = conexion.getConnection();
            String sql = "SELECT nombre FROM comp_seguros WHERE nombre = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setString(1, nombre);
            
            rs = sentencia.executeQuery();
            
            while (rs.next()){
                compania = new CompSegurosDTO(rs.getString("nombre"));
                break;
            }
        }
        catch (SQLException e){
            System.err.println(e);
        }
        finally{
            try {
                rs.close();
                sentencia.close();
            }
            catch (SQLException ex){
                System.err.println(ex);
            }
        }
        
        return compania;
    }

    @Override
    public List<CompSegurosDTO> listarComp(String filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CompSegurosDTO> listarComp() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insertarComp(CompSegurosDTO comp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificarComp(CompSegurosDTO comp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarComp(CompSegurosDTO comp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
