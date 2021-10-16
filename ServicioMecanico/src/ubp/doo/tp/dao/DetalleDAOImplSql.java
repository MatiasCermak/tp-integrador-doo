/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubp.doo.tp.dao;

import java.util.List;
import ubp.doo.tp.dto.*;
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

/**
 *
 * @author tomas
 */
public class DetalleDAOImplSql implements DetalleDAO{
    
    private ConexionSql conexion = null;
    
    public DetalleDAOImplSql(){
        conexion = ConexionSql.getInstancia();
    }

    @Override
    public void cerrarConexion() {
        conexion.desconectar();
    }

    @Override
    public DetalleDTO buscarDetalle(int idOperacion) {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        DetalleDTO detalle = null;
        
        try {
            con = conexion.getConnection();
            String sql = "SELECT m.nombre AS mnombre, mt.tipo_material, m.precio, m.medida, "
                    + "d.cantidad, d.id_detalle, "
                    + "f.conformidad, f.mot_conformidad, et.etapa, "
                    + "t.dni AS tdni, dt.tipo AS ttipo, t.matricula, t.fecha, t.hora, t.estado, t.asistencia,"
                    + "a.hora_inicio, a.hora_fin, "
                    + "e.dni AS edni, edt.tipo AS etipo, r.rol, e.nombre AS enombre, e.apellido AS eapellido, "
                    + "e.salario, c.nombre AS cnombre, c.apellido AS capellido, "
                    + "v.poliza, v.marca, v.modelo, cs.nombre AS csnmbre, "
                    + "FROM detalles d "
                    + "JOIN materiales m ON d.id_material = m.id_material "
                    + "JOIN fichas f ON d.id_ficha = f.id_ficha "
                    + "JOIN turnos t ON f.id_turno = t.id_turno "
                    + "JOIN etapas et ON f.id_etapa = et.id_etapa "
                    + "JOIN dni_tipos dt ON t.id_dni_tipo = dt.id_dni_tipo "
                    + "JOIN agendas a ON t.id_agenda = a.id_agenda "
                    + "JOIN empleados e ON a.id_empleado = e.id_empleado "
                    + "JOIN dni_tipos edt ON e.id_dni_tipo = edt.id_dni_tipo "
                    + "JOIN roles r ON e.id_rol = r.id_rol "
                    + "JOIN clientes c ON t.dni = c.dni AND t.id_dni_tipo = c.id_dni_tipo "
                    + "WHERE d.id_detalle = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, idOperacion);
            
            rs = sentencia.executeQuery();
            
            if(rs.next()){
                String mNombre, tipo_material, medida, motConformidad, etapa, cDniTipo, eDniTipo, rol, eNombre, 
                        eApellido, modelo, marca, vMatricula, csNombre, cNombre, cApellido;
                int cantidad, cDni, hora, estado, asistencia, aHoraI, aHoraF, eDni, poliza;
                float precio, salario;
                Date fecha;
                boolean conformidad;
                
                mNombre = rs.getString("mnombre");
                tipo_material = rs.getString("tipo_material");
                medida = rs.getString("medida");
                motConformidad = rs.getString("mot_conformidad");
                etapa = rs.getString("etapa");
                cDniTipo = rs.getString("ttipo");
                eDniTipo = rs.getString("etipo");
                rol = rs.getString("rol");
                eNombre = rs.getString("enombre");
                eApellido = rs.getString("eapellido");
                cNombre = rs.getString("cnombre");
                cApellido = rs.getString("capellido");
                modelo = rs.getString("modelo");
                marca = rs.getString("marca");
                csNombre = rs.getString("csnombre");
                cantidad = rs.getInt("cantidad");
                conformidad = rs.getBoolean("conformidad");
                cDni = rs.getInt("tdni");
                vMatricula = rs.getString("matricula");
                hora = rs.getInt("hora");
                estado = rs.getInt("estado");
                asistencia = rs.getInt("asistencia");
                aHoraI = rs.getInt("hora_inicio");
                aHoraF = rs.getInt("hora_fin");
                eDni = rs.getInt("edni");
                poliza = rs.getInt("poliza");
                fecha = rs.getDate("fecha");
                precio = rs.getFloat("precio");
                salario = rs.getFloat("salario");
                
                ClienteDTO cliente = new ClienteDTO(cNombre, cApellido, cDniTipo, cDni);
                detalle = new DetalleDTO(new MaterialDTO(mNombre,tipo_material, precio, medida),cantidad, 
                        new FichaDTO(new TurnoDTO(cliente,
                                new VehiculoDTO(new CompSegurosDTO(), cliente, poliza, vMatricula, modelo, marca), 
                                fecha, hora, estado, asistencia, 
                                new AgendaDTO(aHoraI, aHoraF, 
                                        new EmpleadoDTO(salario, rol, eNombre, eApellido, eDniTipo, eDni))),
                                conformidad, motConformidad,etapa),
                        idOperacion);
            }
            
        }catch(SQLException e){
            System.err.println(e);
        }finally{
            try{
                sentencia.close();
                rs.close();
            }catch(SQLException ex){
                System.err.println(ex);
            }
        }
        
        return detalle;
    }

    @Override
    public List<DetalleDTO> listarDetalles(DetalleDTO detalle) {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        List<DetalleDTO> detalles = new ArrayList<DetalleDTO>();
        
        try{
            String sql = "SELECT m.nombre AS mnombre, mt.tipo_material, m.precio, m.medida, "
                    + "d.cantidad, d.id_detalle, "
                    + "f.conformidad, f.mot_conformidad, et.etapa, "
                    + "t.dni AS tdni, dt.tipo AS ttipo, t.matricula, t.fecha, t.hora, t.estado, t.asistencia,"
                    + "a.hora_inicio, a.hora_fin, "
                    + "e.dni AS edni, edt.tipo AS etipo, r.rol, e.nombre AS enombre, e.apellido AS eapellido, "
                    + "e.salario, c.nombre AS cnombre, c.apellido AS capellido, "
                    + "v.poliza, v.marca, v.modelo, cs.nombre AS csnmbre, "
                    + "FROM detalles d "
                    + "JOIN materiales m ON d.id_material = m.id_material "
                    + "JOIN fichas f ON d.id_ficha = f.id_ficha "
                    + "JOIN turnos t ON f.id_turno = t.id_turno "
                    + "JOIN etapas et ON f.id_etapa = et.id_etapa "
                    + "JOIN dni_tipos dt ON t.id_dni_tipo = dt.id_dni_tipo "
                    + "JOIN agendas a ON t.id_agenda = a.id_agenda "
                    + "JOIN empleados e ON a.id_empleado = e.id_empleado "
                    + "JOIN dni_tipos edt ON e.id_dni_tipo = edt.id_dni_tipo "
                    + "JOIN roles r ON e.id_rol = r.id_rol "
                    + "JOIN clientes c ON t.dni = c.dni AND t.id_dni_tipo = c.id_dni_tipo "
                    + "WHERE f.conformidad = ?, "
                    + "f.mot_conformidad = ?, "
                    + "et.etapa = ?, "
                    + "t.dni = ?, "
                    + "dt.tipo = ?, "
                    + "t.matricula = ?, "
                    + "t.fecha = ?, "
                    + "t.hora = ?, "
                    + "t.estado = ?, "
                    + "t.asistencia = ?, "
                    + "a.hora_inicio = ?, "
                    + "a.hora_fin = ?, "
                    + "e.dni = ?, "
                    + "edt.tipo = ?, "
                    + "r.rol = ?, "
                    + "e.nombre = ?, "
                    + "e.apellido = ?, "
                    + "e.salario = ?, "
                    + "c.nombre = ?, "
                    + "c.apellido = ?, "
                    + "v.poliza = ?, "
                    + "v.marca = ?, "
                    + "v.modelo = ?, "
                    + "cs.nombre = ?";
            sentencia = con.prepareStatement(sql);
            sentencia.setBoolean(1, detalle.getFicha().isConformidad());
            sentencia.setString(2, detalle.getFicha().getMotivoConformidad());
            sentencia.setString(3, detalle.getFicha().getEtapa());
            sentencia.setInt(4, detalle.getFicha().getTurno().getCliente().getDniNumero());
            sentencia.setString(5, detalle.getFicha().getTurno().getCliente().getDniTipo());
            sentencia.setString(6, detalle.getFicha().getTurno().getVehiculo().getMatricula());
            sentencia.setDate(7, new java.sql.Date(detalle.getFicha().getTurno().getFecha().getTime()));
            sentencia.setInt(8, detalle.getFicha().getTurno().getHora());
            sentencia.setInt(9, detalle.getFicha().getTurno().getEstado());
            sentencia.setInt(10, detalle.getFicha().getTurno().getAsistencia());
            sentencia.setInt(11, detalle.getFicha().getTurno().getAgenda().getHoraInicio());
            sentencia.setInt(12, detalle.getFicha().getTurno().getAgenda().getHoraFin());
            sentencia.setInt(13, detalle.getFicha().getTurno().getAgenda().getEmpleado().getDniNumero());
            sentencia.setString(14, detalle.getFicha().getTurno().getAgenda().getEmpleado().getDniTipo());
            sentencia.setString(15, detalle.getFicha().getTurno().getAgenda().getEmpleado().getRol());
            sentencia.setString(16, detalle.getFicha().getTurno().getAgenda().getEmpleado().getNombre());
            sentencia.setString(17, detalle.getFicha().getTurno().getAgenda().getEmpleado().getApellido());
            sentencia.setFloat(18, detalle.getFicha().getTurno().getAgenda().getEmpleado().getSalario());
            sentencia.setString(19, detalle.getFicha().getTurno().getCliente().getNombre());
            sentencia.setString(20, detalle.getFicha().getTurno().getCliente().getApellido());
            sentencia.setInt(21, detalle.getFicha().getTurno().getVehiculo().getPoliza());
            sentencia.setString(22, detalle.getFicha().getTurno().getVehiculo().getMarca());
            sentencia.setString(23, detalle.getFicha().getTurno().getVehiculo().getModelo());
            sentencia.setString(24, detalle.getFicha().getTurno().getVehiculo().getAseguradora().getNombre());
            
            rs = sentencia.executeQuery();
            
                String mNombre, tipo_material, medida, motConformidad, etapa, cDniTipo, eDniTipo, rol, eNombre, 
                        eApellido, modelo, marca, vMatricula, csNombre, cNombre, cApellido;
                int idOperacion, cantidad, cDni, hora, estado, asistencia, aHoraI, aHoraF, eDni, poliza;
                float precio, salario;
                Date fecha;
                boolean conformidad;
                
            while (rs.next()){
                
                mNombre = rs.getString("mnombre");
                tipo_material = rs.getString("tipo_material");
                medida = rs.getString("medida");
                motConformidad = rs.getString("mot_conformidad");
                etapa = rs.getString("etapa");
                cDniTipo = rs.getString("ttipo");
                eDniTipo = rs.getString("etipo");
                rol = rs.getString("rol");
                eNombre = rs.getString("enombre");
                eApellido = rs.getString("eapellido");
                cNombre = rs.getString("cnombre");
                cApellido = rs.getString("capellido");
                modelo = rs.getString("modelo");
                marca = rs.getString("marca");
                csNombre = rs.getString("csnombre");
                cantidad = rs.getInt("cantidad");
                conformidad = rs.getBoolean("conformidad");
                cDni = rs.getInt("tdni");
                vMatricula = rs.getString("matricula");
                hora = rs.getInt("hora");
                estado = rs.getInt("estado");
                asistencia = rs.getInt("asistencia");
                aHoraI = rs.getInt("hora_inicio");
                aHoraF = rs.getInt("hora_fin");
                eDni = rs.getInt("edni");
                poliza = rs.getInt("poliza");
                idOperacion = rs.getInt("id_detalle");
                fecha = rs.getDate("fecha");
                precio = rs.getFloat("precio");
                salario = rs.getFloat("salario");
                
                ClienteDTO cliente = new ClienteDTO(cNombre, cApellido, cDniTipo, cDni);
                detalles.add(new DetalleDTO(new MaterialDTO(mNombre,tipo_material, precio, medida),cantidad, 
                        new FichaDTO(new TurnoDTO(cliente,
                                new VehiculoDTO(new CompSegurosDTO(), cliente, poliza, vMatricula, modelo, marca), 
                                fecha, hora, estado, asistencia, 
                                new AgendaDTO(aHoraI, aHoraF, 
                                        new EmpleadoDTO(salario, rol, eNombre, eApellido, eDniTipo, eDni))),
                                conformidad, motConformidad,etapa),
                        idOperacion));
            }
        }catch(SQLException e){
            System.err.println(e);
        }finally{
            try{
                sentencia.close();
                rs.close();
            }catch(SQLException ex){
                System.err.println(ex);
            }
        }
        
        return detalles;
    }

    @Override
    public boolean insertarDetalle(DetalleDTO detalle) {
        
    }

    @Override
    public boolean modificarDetalle(DetalleDTO detalle) {
        
    }

    @Override
    public boolean eliminarDetalle(DetalleDTO detalle) {
        
    }
    
}
