/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubp.doo.tp.controlador;

import ubp.doo.tp.dto.ClienteDTO;
import ubp.doo.tp.modelo.Cliente;
import ubp.doo.tp.modelo.Modelo;
import ubp.doo.tp.vista.SelClienteFr;
import ubp.doo.tp.vista.RegClienteFr;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import ubp.doo.tp.vista.InterfazVista;
import ubp.doo.tp.vista.InterfazVistaSelCli;
import ubp.doo.tp.vista.InterfazVistaRegCli;
/**
 *
 * @author tomas
 */
public class ControladorFlujoTurno extends Controlador {
    
    public ControladorFlujoTurno(InterfazVista vistaSelCli, InterfazVista vistaRegCli, Modelo modelo){
        VISTASELCLI = vistaSelCli;
        VISTAREGCLI = vistaRegCli;
        MODELO = modelo;
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        DefaultTableModel modeloTabla = (DefaultTableModel)((SelClienteFr)this.VISTASELCLI).getModeloTblClientes();
        String filtro;
        boolean resultado = false;
        String nombre;
        int dni;
        String tipo_dni;
        ClienteDTO cliente;
        List<ClienteDTO> listadoClientes;
        try {
            switch (InterfazVista.Operacion.valueOf(e.getActionCommand())){
                case NUEVOVEHI:
                    if ((((RegClienteFr)this.VISTAREGCLI).getTxtApellido().getText().length() <= 0)
                        || (((RegClienteFr)this.VISTAREGCLI).getTxtNombre().getText().length() <= 0)
                        || (((RegClienteFr)this.VISTAREGCLI).getTxtDni().getText().length() <= 0)){
                        JOptionPane.showMessageDialog(((RegClienteFr)this.VISTAREGCLI),"Complete los campos para continuar","Error",JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        cliente = new ClienteDTO(((RegClienteFr)this.VISTAREGCLI).getTxtNombre().getText()+" "+((RegClienteFr)this.VISTAREGCLI).getTxtApellido().getText(),
                                   ((RegClienteFr)this.VISTAREGCLI).getCbDniTipo().getSelectedItem().toString() ,Integer.valueOf(((RegClienteFr)this.VISTAREGCLI).getTxtDni().getText()));
                        ((Cliente)this.MODELO).insertarCliente(cliente);
                        System.out.println(cliente.getNombre());
                        JOptionPane.showMessageDialog(((RegClienteFr)this.VISTAREGCLI),"El siguiente formulario corresponderá a la carga de vehículo","Flujo de sistema",JOptionPane.INFORMATION_MESSAGE);
                        ((RegClienteFr)this.VISTAREGCLI).setVisible(false);
                        ((RegClienteFr)this.VISTAREGCLI).limpiar();
                        ((RegClienteFr)this.VISTAREGCLI).dispose();
                        this.actionPerformed(new ActionEvent(this,0,InterfazVista.Operacion.CARGARSELCLI.toString()));
                        ((SelClienteFr)this.VISTASELCLI).setVisible(true);
                    }
                    break;
                case CARGARSELCLI:
                    modeloTabla.setRowCount(0);
                    modeloTabla.fireTableDataChanged();
                    listadoClientes = ((Cliente)this.MODELO).listarClientes();
                    for (ClienteDTO cli : listadoClientes){
                        modeloTabla.addRow(new Object[]{cli.getNombre(), cli.getDniNumero(),cli.getDniTipo()});
                    }
                    break;
                case NUEVOCLI:
                    ((SelClienteFr)this.VISTASELCLI).setVisible(false);
                    ((RegClienteFr)this.VISTAREGCLI).iniciaVista();
                    break;
                case SELCLI:
                    if (((SelClienteFr)this.VISTASELCLI).getTblClientes().getSelectedRow() >= 0){
                        cliente = ((Cliente)this.MODELO).buscarCliente((String)modeloTabla.getValueAt(((SelClienteFr)this.VISTASELCLI).getTblClientes().getSelectedRow(), 0));
                        System.out.println(cliente.getNombre() + ": "+cliente.getDniTipo()+"= "+String.valueOf(cliente.getDniNumero()));
                    }
                    break;
                case FILTCLI:
                    modeloTabla.setRowCount(0);
                    modeloTabla.fireTableDataChanged();
                    filtro = (String)((SelClienteFr)this.VISTASELCLI).getFiltro();
                    listadoClientes = ((Cliente)this.MODELO).listarClientes(filtro);
                    for (ClienteDTO cli : listadoClientes){
                        modeloTabla.addRow(new Object[]{cli.getNombre(), cli.getDniNumero(),cli.getDniTipo()});
                    }
                    break;
                case CANCELSELCLI:
                    ((SelClienteFr)this.VISTASELCLI).setVisible(false);
                    ((SelClienteFr)this.VISTASELCLI).dispose();
                    ((RegClienteFr)this.VISTAREGCLI).dispose();
                    break;
                case CANCELREGCLI:
                    ((RegClienteFr)this.VISTAREGCLI).setVisible(false);
                    ((RegClienteFr)this.VISTAREGCLI).dispose();
                    this.actionPerformed(new ActionEvent(this,0,InterfazVista.Operacion.CARGARSELCLI.toString()));
                    ((SelClienteFr)this.VISTASELCLI).setVisible(true);
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
            this.actionPerformed(new ActionEvent(this,0,InterfazVistaSelCli.Operacion.FILTCLI.toString()));
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
