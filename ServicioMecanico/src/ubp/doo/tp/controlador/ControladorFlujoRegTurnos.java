/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubp.doo.tp.controlador;

//Importar DTOs a utilizar
import ubp.doo.tp.dto.ClienteDTO;
import ubp.doo.tp.dto.EspecialidadDTO;
import ubp.doo.tp.dto.VehiculoDTO;
import ubp.doo.tp.dto.AgendaDTO;
import ubp.doo.tp.dto.CompSegurosDTO;
import ubp.doo.tp.dto.MecanicoDTO;
import ubp.doo.tp.dto.TurnoDTO;
//Importar modelos a utilizar
import ubp.doo.tp.modelo.MCliente;
import ubp.doo.tp.modelo.MEspecialidad;
import ubp.doo.tp.modelo.Modelo;
import ubp.doo.tp.modelo.MVehiculo;
import ubp.doo.tp.modelo.MCompSeguros;
import ubp.doo.tp.modelo.MMecanico;
import ubp.doo.tp.modelo.MAgenda;
import ubp.doo.tp.modelo.MTurno;
//Importar vistas (frames) a itilizar
import ubp.doo.tp.vista.SelClienteFr;
import ubp.doo.tp.vista.RegClienteFr;
import ubp.doo.tp.vista.RegTurnoFr;
import ubp.doo.tp.vista.SelAgendaFr;
import ubp.doo.tp.vista.RegVehiculoFr;
//Importar interfaces de vistas
import ubp.doo.tp.vista.InterfazVistaFlujoRegTurno;
//importar librerías auxiliares
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import com.toedter.calendar.JDateChooser;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author tomas
 */
public class ControladorFlujoRegTurnos extends Controlador {
    
    private InterfazVistaFlujoRegTurno VISTASELCLI = null;
    private InterfazVistaFlujoRegTurno VISTAREGCLI = null;
    private InterfazVistaFlujoRegTurno VISTAREGTURNO = null;
    private InterfazVistaFlujoRegTurno VISTAREGVEHICULO = null;
    private InterfazVistaFlujoRegTurno VISTASELAGENDA = null;
    private Modelo MCLIENTES = null;
    private Modelo MAGENDAS = null;
    private Modelo MCOMPSEGUROS = null;
    private Modelo MESPECIALIDADES = null;
    private Modelo MMECANICOS = null;
    private Modelo MTURNOS = null;
    private Modelo MVEHICULOS = null;
    //Variables internas para el seguimiento y continuidad del flujo
    private ClienteDTO cliente;
    private VehiculoDTO vehiculo;
    private Date fecha;
    private int hora;
    private AgendaDTO agenda;
    private EspecialidadDTO especialidad;
    private TurnoDTO turno;
    
    
    public ControladorFlujoRegTurnos(){}
    
    public ControladorFlujoRegTurnos(InterfazVistaFlujoRegTurno vistaSelAge, InterfazVistaFlujoRegTurno vistaRegVeh,InterfazVistaFlujoRegTurno vistaSelCli, InterfazVistaFlujoRegTurno vistaRegCli, InterfazVistaFlujoRegTurno vistaRegTur, Modelo modelo){
        VISTASELCLI = vistaSelCli;
        VISTAREGCLI = vistaRegCli;
        VISTAREGTURNO = vistaRegTur;
        VISTAREGVEHICULO = vistaRegVeh;
        VISTASELAGENDA = vistaSelAge;
        MCLIENTES = modelo;
    }
    
    public void setVistaSelCli(InterfazVistaFlujoRegTurno vista){
        this.VISTASELCLI = vista;
    }
    
    public void setVistaRegCli(InterfazVistaFlujoRegTurno vista){
        this.VISTAREGCLI = vista;
    }
    
    public void setVistaRegTurno(InterfazVistaFlujoRegTurno vista){
        this.VISTAREGTURNO = vista;
    }
    
    public void setVistaRegVehiculo(InterfazVistaFlujoRegTurno vista){
        this.VISTAREGVEHICULO = vista;
    }
    
    public void setVistaSelAgenda(InterfazVistaFlujoRegTurno vista){
        this.VISTASELAGENDA = vista;
    }
    
    public void setMClientes(Modelo modelo){
        this.MCLIENTES = modelo;
    }
    
    public void setMAgendas(Modelo modelo){
        this.MAGENDAS = modelo;
    }
    
    public void setMCompSeguros(Modelo modelo){
        this.MCOMPSEGUROS = modelo;
    }
    
    public void setMEspecialidades(Modelo modelo){
        this.MESPECIALIDADES = modelo;
    }
    
    public void setMMecanicos(Modelo modelo){
        this.MMECANICOS = modelo;
    }
    
    public void setMTurnos(Modelo modelo){
        this.MTURNOS = modelo;
    }
    
    public void setMVehiculos(Modelo modelo){
        this.MVEHICULOS = modelo;
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        DefaultTableModel mTablaCli = (DefaultTableModel)((SelClienteFr)this.VISTASELCLI).getModeloTblClientes();
        String filtro;
        boolean resultado = false;
        String nombre, apellido;
        int dni, opc = -1;
        String tipo_dni;
        List<ClienteDTO> listadoClientes;
        List<String> tipos;
        
        try {
            switch (InterfazVistaFlujoRegTurno.Operacion.valueOf(e.getActionCommand())){
                case SCNUEVOCLI:
                    ((SelClienteFr)this.VISTASELCLI).cierraVista();
                    ((RegClienteFr)this.VISTAREGCLI).iniciaVista();
                    break;
                case SCCARGAR:
                    mTablaCli.setRowCount(0);
                    mTablaCli.fireTableDataChanged();
                    listadoClientes = ((MCliente)this.MCLIENTES).listarClientes();
                    for (ClienteDTO cli : listadoClientes){
                        mTablaCli.addRow(new Object[]{cli.getNombre(),cli.getApellido(), cli.getDniNumero(),cli.getDniTipo()});
                    }
                    break; 
                case SCSELCLI:
                    if (((SelClienteFr)this.VISTASELCLI).getTblClientes().getSelectedRow() >= 0){
                        int row = ((SelClienteFr)this.VISTASELCLI).getTblClientes().getSelectedRow();
                        dni = (int)mTablaCli.getValueAt(row, 2);
                        tipo_dni = (String)mTablaCli.getValueAt(row, 3);
                        cliente = ((MCliente)this.MCLIENTES).buscarCliente(tipo_dni, dni);
                        ((RegTurnoFr)this.VISTAREGTURNO).setCliente(cliente.getNombre()
                                +" "+cliente.getApellido()
                                +", "+cliente.getDniTipo()
                                +"= "+cliente.getDniNumero());
                        ((SelClienteFr)this.VISTASELCLI).cierraVista();
                        this.actionPerformed(new ActionEvent((SelClienteFr)this.VISTASELCLI,0,InterfazVistaFlujoRegTurno.Operacion.RTCARGAR.toString()));
                        ((RegTurnoFr)this.VISTAREGTURNO).iniciaVista();
                    }
                    break;
                case SCFILTCLI:
                    mTablaCli.setRowCount(0);
                    mTablaCli.fireTableDataChanged();
                    filtro = (String)((SelClienteFr)this.VISTASELCLI).getFiltro();
                    listadoClientes = ((MCliente)this.MCLIENTES).listarClientes(filtro);
                    for (ClienteDTO cli : listadoClientes){
                        mTablaCli.addRow(new Object[]{cli.getNombre(),cli.getApellido(), cli.getDniNumero(),cli.getDniTipo()});
                    }
                    break;
                case SCCANCELAR:
                    opc = JOptionPane.showConfirmDialog((SelClienteFr)this.VISTASELCLI, 
                            "No ha seleccionado ningún cliente.\n"
                                    + "Si cancela no podrá registrar un turno hasta que seleccione un cliente.\n"
                                    + "Desea continuar?", "Advertencia", 
                                    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if (opc == 0){
                        ((SelClienteFr)this.VISTASELCLI).cierraVista();
                        ((RegTurnoFr)this.VISTAREGTURNO).iniciaVista();
                    }
                    break;
                case RCNUEVOVEHI:
                    if ((((RegClienteFr)this.VISTAREGCLI).getTxtApellido().getText().length() <= 0)
                        || (((RegClienteFr)this.VISTAREGCLI).getTxtNombre().getText().length() <= 0)
                        || (((RegClienteFr)this.VISTAREGCLI).getTxtDni().getText().length() <= 0)){
                        JOptionPane.showMessageDialog(((RegClienteFr)this.VISTAREGCLI),"Complete los campos para continuar","Error",JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        dni = Integer.valueOf(((RegClienteFr)this.VISTAREGCLI).getTxtDni().getText());
                        tipo_dni = ((RegClienteFr)this.VISTAREGCLI).getCbDniTipo().getSelectedItem().toString() ;
                        nombre = ((RegClienteFr)this.VISTAREGCLI).getTxtNombre().getText();
                        apellido = ((RegClienteFr)this.VISTAREGCLI).getTxtApellido().getText();
                        cliente = new ClienteDTO(nombre, apellido, tipo_dni, dni);
                        if (((MCliente)this.MCLIENTES).buscarCliente(tipo_dni, dni) != null){
                            JOptionPane.showMessageDialog(((RegClienteFr)this.VISTAREGCLI),"El "+tipo_dni+" ingresado ya se encuentra registrado","Error",JOptionPane.ERROR_MESSAGE);
                        }
                        else {
                            if (JOptionPane.showConfirmDialog((RegClienteFr)this.VISTAREGCLI, "Confirma los datos ingresados", "Confirmación", JOptionPane.YES_NO_OPTION) == 0){
                                ((RegVehiculoFr)this.VISTAREGVEHICULO).setTxtCliente(tipo_dni+":"+((RegClienteFr)this.VISTAREGCLI).getTxtDni().getText()+" - "+nombre+","+apellido);
                                ((RegClienteFr)this.VISTAREGCLI).setVisible(false);
                                ((RegVehiculoFr)this.VISTAREGVEHICULO).setPrevious((RegClienteFr)this.VISTAREGCLI);
                                ((RegVehiculoFr)this.VISTAREGVEHICULO).iniciaVista();
                            }
                        }
                    }
                    break;
                case RCCARGAR:
                    tipos = ((MCliente)this.MCLIENTES).listadoDniTipos();
                    for (String tipo : tipos){
                        ((RegClienteFr)this.VISTAREGCLI).getCbDniTipo().addItem(tipo);
                    }
                    break;
                case RCCANCELAR:
                    opc = JOptionPane.showConfirmDialog((RegClienteFr)this.VISTAREGCLI,
                            "Está seguro que desea volver atrás?", "Confirmación", 
                            JOptionPane.YES_NO_OPTION);
                    if (opc == 0){
                        ((RegClienteFr)this.VISTAREGCLI).cierraVista();
                        this.actionPerformed(new ActionEvent(this,0,InterfazVistaFlujoRegTurno.Operacion.SCCARGAR.toString()));
                        ((SelClienteFr)this.VISTASELCLI).iniciaVista();
                    }
                    break;
                case RTCARGAR:
                    ((RegTurnoFr)this.VISTAREGTURNO).getCmbVehiculos().removeAllItems();
                    ((RegTurnoFr)this.VISTAREGTURNO).getCmbEspecialidad().removeAllItems();
                    List<EspecialidadDTO> especialidades = ((MEspecialidad)this.MESPECIALIDADES).listarEspecialidades();
                    for (EspecialidadDTO esp : especialidades){
                        ((RegTurnoFr)this.VISTAREGTURNO).getCmbEspecialidad().addItem(esp.getNombre());
                    }
                    if (cliente != null){
                        List<VehiculoDTO> vehiculos = ((MVehiculo)this.MVEHICULOS).listarVehiculos(cliente.getDniTipo(), cliente.getDniNumero());
                        if (vehiculos == null || vehiculos.isEmpty()){
                            ((RegTurnoFr)this.VISTAREGTURNO).getCmbVehiculos().addItem("El cliente no tiene vehículo registrado");
                        }
                        else {
                            for (VehiculoDTO v : vehiculos){
                                ((RegTurnoFr)this.VISTAREGTURNO).getCmbVehiculos().addItem(v.getMatricula()+":"+v.getMarca()+", "+v.getModelo());
                            }
                        }
                    }
                    break;
                case RTCANCELAR:
                    opc = JOptionPane.showConfirmDialog((RegTurnoFr)this.VISTAREGTURNO, 
                            "Está seguro que desea salir de esta opción?", 
                            "Confirmación", JOptionPane.YES_NO_OPTION);
                    if (opc == 0){
                        ((RegTurnoFr)this.VISTAREGTURNO).cierraVista();
                        JOptionPane.showMessageDialog((RegTurnoFr)this.VISTAREGTURNO, 
                                "Saliendo del sistema.", "Saliendo...", JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                    }
                    break;
                case RTSIGUIENTE:
                    if (!(((RegTurnoFr)this.VISTAREGTURNO)).clienteSeleccionado()){
                        JOptionPane.showMessageDialog(((RegTurnoFr)this.VISTAREGTURNO),
                                "Debe seleccionar un cliente para continuar","Error",JOptionPane.ERROR_MESSAGE);
                    }
                    else if (((RegTurnoFr)this.VISTAREGTURNO).getCmbVehiculos().getItemAt(0) == "El cliente no tiene vehículo registrado"){
                        JOptionPane.showMessageDialog(((RegTurnoFr)this.VISTAREGTURNO),
                                "Debe seleccionar un vehículo para continuar","Error",JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        opc = JOptionPane.showConfirmDialog((RegTurnoFr)this.VISTAREGTURNO, 
                                "Confirma los datos seleccionados", "Confirmación", 
                                JOptionPane.YES_NO_OPTION);
                        if (opc == 0){
                            String vehSel = (String)((RegTurnoFr)this.VISTAREGTURNO).getCmbVehiculos().getSelectedItem();
                            vehiculo = ((MVehiculo)this.MVEHICULOS).buscarVehiculo(vehSel.substring(0, vehSel.indexOf(":")));
                            especialidad = ((MEspecialidad)this.MESPECIALIDADES).buscarEspecialidad((String)((RegTurnoFr)this.VISTAREGTURNO).getCmbEspecialidad().getSelectedItem());
                            this.actionPerformed(new ActionEvent(this,0,InterfazVistaFlujoRegTurno.Operacion.SACARGAR.toString()));
                            ((RegTurnoFr)this.VISTAREGTURNO).cierraVista();
                            ((SelAgendaFr)this.VISTASELAGENDA).iniciaVista();
                        }
                    }
                    break;
                case RTEXAMCLI:
                    ((RegTurnoFr)this.VISTAREGTURNO).cierraVista();
                    this.actionPerformed(new ActionEvent(this,0,InterfazVistaFlujoRegTurno.Operacion.SCCARGAR.toString()));
                    ((SelClienteFr)this.VISTASELCLI).iniciaVista();
                    break;
                case RTNUEVOVEHI:
                    ((RegTurnoFr)this.VISTAREGTURNO).setVisible(false);
                    ((RegVehiculoFr)this.VISTAREGVEHICULO).setTxtCliente(cliente.getDniTipo()+":"+cliente.getDniNumero()+" - "+cliente.getNombre()+","+cliente.getApellido());
                    ((RegVehiculoFr)this.VISTAREGVEHICULO).setPrevious((RegTurnoFr)this.VISTAREGTURNO);
                    ((RegVehiculoFr)this.VISTAREGVEHICULO).iniciaVista();
                    break;
                case SACARGAR:
                    ((SelAgendaFr)this.VISTASELAGENDA).getCmbMecanicos().removeAllItems();
                    ((SelAgendaFr)this.VISTASELAGENDA).getCmbHorario().removeAllItems();
                    ((SelAgendaFr)this.VISTASELAGENDA).getDateChooser().setDate(null);
                    List<MecanicoDTO> mecanicos = ((MMecanico)this.MMECANICOS).listarMecanicos(especialidad.getId_especialidad());
                    if (mecanicos == null || mecanicos.isEmpty()){
                        JOptionPane.showMessageDialog((SelAgendaFr)this.VISTASELAGENDA,"No hay mecánicos cargados para esta especialidad","Error", JOptionPane.ERROR_MESSAGE);
                        ((SelAgendaFr)this.VISTASELAGENDA).cierraVista();
                        this.actionPerformed(new ActionEvent(this,0,InterfazVistaFlujoRegTurno.Operacion.RTCARGAR.toString()));
                        ((RegTurnoFr)this.VISTAREGTURNO).iniciaVista();
                    }
                    else{
                        for (MecanicoDTO m : mecanicos){
                            ((SelAgendaFr)this.VISTASELAGENDA).getCmbMecanicos().addItem(Integer.toString(m.getId_empleado())+":"+m.getNombre()+", "+m.getApellido());
                        }
                    }
                    break;
                case SAACEPTAR:
                    opc = JOptionPane.showConfirmDialog((SelAgendaFr)this.VISTASELAGENDA, 
                            "Confirma los datos seleccionados?", "Confirmación", 
                            JOptionPane.YES_NO_OPTION);
                    if (opc == 0){
                        hora = ((SelAgendaFr)this.VISTASELAGENDA).getHoraTurno();
                        fecha = ((SelAgendaFr)this.VISTASELAGENDA).getFechaTurno();
                        turno = new TurnoDTO(-1,cliente.getDniNumero(), cliente.getDniTipo(),
                            vehiculo.getMatricula(), fecha, hora, 1, 0, agenda.getId_agenda());
                        if (((MTurno)this.MTURNOS).insertarTurno(turno)){
                            ((SelAgendaFr)this.VISTASELAGENDA).cierraVista();
                            JOptionPane.showMessageDialog((SelAgendaFr)this.VISTASELAGENDA,
                                    "Turno registrado correctamente", "Éxito",
                                    JOptionPane.INFORMATION_MESSAGE);
                            System.out.println(turno);
                            ((RegTurnoFr)this.VISTAREGTURNO).iniciaVista();
                        }
                        else{
                            JOptionPane.showMessageDialog((SelAgendaFr)this.VISTASELAGENDA, 
                                    "Hubo un error al intentar registrar el turno",
                                    "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    break;
                case SACANCELAR:
                    opc = JOptionPane.showConfirmDialog((SelAgendaFr)this.VISTASELAGENDA, 
                            "Está seguro que desea volver a la pantalla anterior?", 
                            "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    ((SelAgendaFr)this.VISTASELAGENDA).cierraVista();
                    ((RegTurnoFr)this.VISTAREGTURNO).iniciaVista();
                    break;
                case SALISTARHORAS:
                    ((SelAgendaFr)this.VISTASELAGENDA).getCmbHorario().removeAllItems();
                    String mSel = (String)((SelAgendaFr)this.VISTASELAGENDA).getCmbMecanicos().getSelectedItem();

                    if (mSel != null){
                        int id_empleado = Integer.parseInt(mSel.substring(0, mSel.indexOf(":")));
                        List<Integer> horas = ((MAgenda)this.MAGENDAS).listarHorasDisponibles(id_empleado, ((SelAgendaFr)this.VISTASELAGENDA).getFechaTurno());
                        agenda = ((MAgenda)this.MAGENDAS).buscarAgenda(id_empleado);
                        if (horas == null || horas.isEmpty()){
                            JOptionPane.showMessageDialog((SelAgendaFr)this.VISTASELAGENDA,
                                    "El empleado seleccionado no tiene turnos disponibles en la fecha elegida.",
                                    "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else{
                            for (int h : horas){
                                ((SelAgendaFr)this.VISTASELAGENDA).getCmbHorario().addItem(h);
                            }
                        }
                    }
                    break;
                case RVREGISTRAR:
                    opc = JOptionPane.showConfirmDialog((RegVehiculoFr)this.VISTAREGVEHICULO, 
                            "Confirma los datos ingresados?", "Confirmación", 
                            JOptionPane.YES_NO_OPTION);
                    if (opc == 0){
                        String matr = ((RegVehiculoFr)this.VISTAREGVEHICULO).getTxtMatricula();
                        vehiculo = ((MVehiculo)this.MVEHICULOS).buscarVehiculo(matr);
                        if (((RegVehiculoFr)this.VISTAREGVEHICULO).getTxtMarca().isBlank() &&
                                ((RegVehiculoFr)this.VISTAREGVEHICULO).getTxtMatricula().isBlank() &&
                                ((RegVehiculoFr)this.VISTAREGVEHICULO).getTxtModelo().isBlank() &&
                                ((RegVehiculoFr)this.VISTAREGVEHICULO).getTxtPoliza().isBlank()){
                            JOptionPane.showMessageDialog(((RegVehiculoFr)this.VISTAREGVEHICULO), 
                                    "Debe completar todos los campos para continuar", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                        else if (vehiculo != null){
                            JOptionPane.showMessageDialog(((RegVehiculoFr)this.VISTAREGVEHICULO),
                                    "La matrícula ingresada ya se encuentra registrada en otro vehículo",
                                    "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        else{
                            if (((RegVehiculoFr)this.VISTAREGVEHICULO).getPrevious() == ((RegClienteFr)this.VISTAREGCLI)){
                                boolean success = ((MCliente)this.MCLIENTES).insertarCliente(cliente);
                                if (!success){
                                    JOptionPane.showMessageDialog((RegVehiculoFr)this.VISTAREGVEHICULO,
                                            "Ha ocurrido un error registrando el cliente",
                                            "Error", JOptionPane.ERROR_MESSAGE);
                                    ((RegVehiculoFr)this.VISTAREGVEHICULO).cierraVista();
                                    this.actionPerformed(new ActionEvent(this,0,InterfazVistaFlujoRegTurno.Operacion.SCCARGAR.toString()));
                                    ((SelClienteFr)this.VISTASELCLI).iniciaVista();
                                }
                            }
                            int id_comp_seguros = ((MCompSeguros)this.MCOMPSEGUROS).buscarComp(
                                (String)((RegVehiculoFr)this.VISTAREGVEHICULO).getCmbCompanias().getSelectedItem()).getId_comp_seguros();
                            vehiculo = new VehiculoDTO(id_comp_seguros, 
                                cliente.getDniNumero(), cliente.getDniTipo(), 
                                ((RegVehiculoFr)this.VISTAREGVEHICULO).getTxtPoliza(), 
                                ((RegVehiculoFr)this.VISTAREGVEHICULO).getTxtMatricula(),
                                ((RegVehiculoFr)this.VISTAREGVEHICULO).getTxtModelo(),
                                ((RegVehiculoFr)this.VISTAREGVEHICULO).getTxtMarca());
                            boolean success = ((MVehiculo)this.MVEHICULOS).insertarVehiculo(vehiculo);
                            if (!success){
                                JOptionPane.showMessageDialog((RegVehiculoFr)this.VISTAREGVEHICULO,
                                            "Ha ocurrido un error registrando el vehículo",
                                            "Error", JOptionPane.ERROR_MESSAGE);
                            }

                            ((RegVehiculoFr)this.VISTAREGVEHICULO).cierraVista();
                            if (((RegVehiculoFr)this.VISTAREGVEHICULO).getPrevious() == (RegTurnoFr)this.VISTAREGTURNO){
                                this.actionPerformed(new ActionEvent((RegVehiculoFr)this.VISTAREGVEHICULO,0,InterfazVistaFlujoRegTurno.Operacion.RTCARGAR.toString()));
                                ((RegVehiculoFr)this.VISTAREGVEHICULO).getPrevious().iniciaVista();
                            }
                            else{
                                this.actionPerformed(new ActionEvent(this,0,InterfazVistaFlujoRegTurno.Operacion.SCCARGAR.toString()));
                                ((SelClienteFr)this.VISTASELCLI).iniciaVista();
                            }
                        }
                    }
                    break;
                case RVCANCELAR:
                    ((RegVehiculoFr)this.VISTAREGVEHICULO).cierraVista();
                    if (((RegVehiculoFr)this.VISTAREGVEHICULO).getPrevious() == (RegTurnoFr)this.VISTAREGTURNO)
                            this.actionPerformed(new ActionEvent((RegVehiculoFr)this.VISTAREGVEHICULO,0,InterfazVistaFlujoRegTurno.Operacion.RTCARGAR.toString()));
                    ((RegVehiculoFr)this.VISTAREGVEHICULO).getPrevious().iniciaVista();
                    break;
                case RVCARGAR:
                    List<CompSegurosDTO> companias = ((MCompSeguros)this.MCOMPSEGUROS).listarComp();
                    for (CompSegurosDTO comp : companias){
                        ((RegVehiculoFr)this.VISTAREGVEHICULO).getCmbCompanias().addItem(comp.getNombre());
                    }
                    break;
            }
            
        } catch (RuntimeException ex) {
            VISTASELCLI.imprimeMensaje(ex);
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        verificarInputTxt(e);
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        verificarInputTxt(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        verificarInputTxt(e);
    }

    public void verificarInputTxt(KeyEvent e) {
        char c = e.getKeyChar();
        if (!((c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)
                || (c == KeyEvent.VK_ENTER) || (c == KeyEvent.VK_TAB)
                || (Character.isDigit(c)))&&(!(e.getSource() instanceof JTextField))) {
            e.consume();
        }
        
    }
    
        
    
}
