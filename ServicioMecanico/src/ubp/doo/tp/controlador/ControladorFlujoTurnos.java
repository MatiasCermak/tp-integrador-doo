/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubp.doo.tp.controlador;

import ubp.doo.tp.dto.ClienteDTO;
import ubp.doo.tp.modelo.MCliente;
import ubp.doo.tp.modelo.Modelo;
import ubp.doo.tp.vista.SelClienteFr;
import ubp.doo.tp.vista.RegClienteFr;
import ubp.doo.tp.vista.RegTurnoFr;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import ubp.doo.tp.vista.InterfazVistaSelCli;
import ubp.doo.tp.vista.InterfazVistaRegCliente;
import ubp.doo.tp.vista.InterfazVistaFlujoTurno;
/**
 *
 * @author tomas
 */
public class ControladorFlujoTurnos extends Controlador {
    
    private InterfazVistaFlujoTurno VISTASELCLI = null;
    private InterfazVistaFlujoTurno VISTAREGCLI = null;
    private InterfazVistaFlujoTurno VISTAREGTURNO = null;
    private Modelo MODELO = null;
    
    public ControladorFlujoTurnos(InterfazVistaFlujoTurno vistaSelCli, InterfazVistaFlujoTurno vistaRegCli, InterfazVistaFlujoTurno vistaRegTur, Modelo modelo){
        VISTASELCLI = vistaSelCli;
        VISTAREGCLI = vistaRegCli;
        VISTAREGTURNO = vistaRegTur;
        MODELO = modelo;
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        DefaultTableModel modeloTabla = (DefaultTableModel)((SelClienteFr)this.VISTASELCLI).getModeloTblClientes();
        String filtro;
        boolean resultado = false;
        String nombre;
        int dni;
        int tipo_dni;
        ClienteDTO cliente;
        List<ClienteDTO> listadoClientes;
        List<String> tipos;
        try {
            switch (InterfazVistaFlujoTurno.Operacion.valueOf(e.getActionCommand())){
                case RCNUEVOVEHI:
                    if ((((RegClienteFr)this.VISTAREGCLI).getTxtApellido().getText().length() <= 0)
                        || (((RegClienteFr)this.VISTAREGCLI).getTxtNombre().getText().length() <= 0)
                        || (((RegClienteFr)this.VISTAREGCLI).getTxtDni().getText().length() <= 0)){
                        JOptionPane.showMessageDialog(((RegClienteFr)this.VISTAREGCLI),"Complete los campos para continuar","Error",JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        cliente = new ClienteDTO(((RegClienteFr)this.VISTAREGCLI).getTxtNombre().getText(),((RegClienteFr)this.VISTAREGCLI).getTxtApellido().getText(),
                                   ((RegClienteFr)this.VISTAREGCLI).getCbDniTipo().getSelectedIndex() ,Integer.valueOf(((RegClienteFr)this.VISTAREGCLI).getTxtDni().getText()));
                        ((MCliente)this.MODELO).insertarCliente(cliente);
                        System.out.println(cliente.getNombre()+" "+cliente.getApellido());
                        JOptionPane.showMessageDialog(((RegClienteFr)this.VISTAREGCLI),"El siguiente formulario corresponderá a la carga de vehículo","Flujo de sistema",JOptionPane.INFORMATION_MESSAGE);
                        ((RegClienteFr)this.VISTAREGCLI).setVisible(false);
                        ((RegClienteFr)this.VISTAREGCLI).limpiar();
                        ((RegClienteFr)this.VISTAREGCLI).dispose();
                        this.actionPerformed(new ActionEvent(this,0,InterfazVistaFlujoTurno.Operacion.SCCARGAR.toString()));
                    }
                    break;
                case RCCARGAR:
                    tipos = ((MCliente)this.MODELO).listadoDniTipos();
                    for (String tipo : tipos){
                        ((RegClienteFr)this.VISTAREGCLI).getCbDniTipo().addItem(tipo);
                    }
                    break;
                case RCCANCELAR:
                    ((RegClienteFr)this.VISTAREGCLI).setVisible(false);
                    ((RegClienteFr)this.VISTAREGCLI).dispose();
                    this.actionPerformed(new ActionEvent(this,0,InterfazVistaFlujoTurno.Operacion.SCCARGAR.toString()));
                    ((SelClienteFr)this.VISTASELCLI).setVisible(true);
                    break;
                case SCCARGAR:
                    modeloTabla.setRowCount(0);
                    modeloTabla.fireTableDataChanged();
                    listadoClientes = ((MCliente)this.MODELO).listarClientes();
                    for (ClienteDTO cli : listadoClientes){
                        modeloTabla.addRow(new Object[]{cli.getNombre()+" "+cli.getApellido(), cli.getDniNumero(),((MCliente)this.MODELO).buscarTipoDni(cli.getIdDniTipo())});
                    }
                    ((SelClienteFr)this.VISTASELCLI).setVisible(true);
                    break; 
                case SCNUEVOCLI:
                    ((SelClienteFr)this.VISTASELCLI).setVisible(false);
                    ((SelClienteFr)this.VISTASELCLI).dispose();
                    ((RegClienteFr)this.VISTAREGCLI).iniciaVista();
                    break;
                case SCSELCLI:
                    if (((SelClienteFr)this.VISTASELCLI).getTblClientes().getSelectedRow() >= 0){
                        int row = ((SelClienteFr)this.VISTASELCLI).getTblClientes().getSelectedRow();
                        int numDni = (int)modeloTabla.getValueAt(row, 1);
                        String tipo = (String)modeloTabla.getValueAt(row, 2);
                        cliente = ((MCliente)this.MODELO).buscarCliente(tipo, numDni);
                        ((RegTurnoFr)this.VISTAREGTURNO).setCliente(cliente.getNombre()
                                +" "+cliente.getApellido()
                                +", "+((MCliente)this.MODELO).buscarTipoDni(cliente.getIdDniTipo())
                                +"= "+cliente.getDniNumero());
                        ((SelClienteFr)this.VISTASELCLI).setVisible(false);
                        ((SelClienteFr)this.VISTASELCLI).dispose();
                        
                        ((RegTurnoFr)this.VISTAREGTURNO).setVisible(true);
                    }
                    break;
                case SCFILTCLI:
                    modeloTabla.setRowCount(0);
                    modeloTabla.fireTableDataChanged();
                    filtro = (String)((SelClienteFr)this.VISTASELCLI).getFiltro();
                    listadoClientes = ((MCliente)this.MODELO).listarClientes(filtro);
                    for (ClienteDTO cli : listadoClientes){
                        modeloTabla.addRow(new Object[]{cli.getNombre()+" "+cli.getApellido(), cli.getDniNumero(),cli.getIdDniTipo()});
                    }
                    break;
                case SCCANCELAR:
                    ((SelClienteFr)this.VISTASELCLI).setVisible(false);
                    ((SelClienteFr)this.VISTASELCLI).dispose();
                    ((RegClienteFr)this.VISTAREGCLI).dispose();
                    break;
                case RTCANCELAR:
                    ((RegTurnoFr)this.VISTAREGTURNO).setVisible(false);
                    this.actionPerformed(new ActionEvent(this,0,InterfazVistaFlujoTurno.Operacion.SCCANCELAR.toString()));
                    ((RegTurnoFr)this.VISTAREGTURNO).dispose();
                    break;
                case RTSIGUIENTE:
                    break;
                case RTEXAMCLI:
                    ((RegTurnoFr)this.VISTAREGTURNO).setVisible(false);
                    this.actionPerformed(new ActionEvent(this,0,InterfazVistaFlujoTurno.Operacion.SCCARGAR.toString()));
                    ((SelClienteFr)this.VISTASELCLI).setVisible(true);
                    break;
                case RTNUEVOVEHI:
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
        if (e.getSource() instanceof JTextField){
            this.actionPerformed(new ActionEvent(this,0,InterfazVistaSelCli.Operacion.SCFILTCLI.toString()));
        }
        else { 
            verificarInputTxt(e);
        }
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
