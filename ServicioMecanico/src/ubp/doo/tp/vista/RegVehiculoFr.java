/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubp.doo.tp.vista;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import ubp.doo.tp.controlador.Controlador;
/**
 *
 * @author jeresabelox
 */
public class RegVehiculoFr extends javax.swing.JFrame implements InterfazVistaRegVehiculo {

    /**
     * Creates new form RegVehiculo
     */
    public RegVehiculoFr() {
        initComponents();
    }

    private static RegVehiculoFr instancia = null;
    public static RegVehiculoFr getInstancia() {
        if (instancia == null) {
            instancia = new RegVehiculoFr();
        }
        return instancia;
    }
    
    private InterfazVistaFlujoRegTurno previous;
    
    public void setPrevious(InterfazVistaFlujoRegTurno i){
        this.previous = i;
    }
    
    public InterfazVistaFlujoRegTurno getPrevious(){
        return this.previous;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtMatricula = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNumPoliza1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cmbCompSeguros = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        txtMarca = new javax.swing.JTextField();
        txtCliente = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Registrar Vehiculo");

        txtModelo.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        txtModelo.setToolTipText("");

        jLabel2.setText("Matricula");

        txtMatricula.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        txtMatricula.setToolTipText("");

        jLabel3.setText("N??mero de P??liza");

        jLabel4.setText("Compa??ia de Seguros");

        txtNumPoliza1.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        txtNumPoliza1.setToolTipText("");
        txtNumPoliza1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNumPoliza1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNumPoliza1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumPoliza1KeyTyped(evt);
            }
        });

        jLabel5.setText("Modelo");

        jLabel6.setText("Marca");

        btnCancelar.setText("Cancelar");
        btnCancelar.setActionCommand("RVCANCELAR");

        btnRegistrar.setText("Registrar");
        btnRegistrar.setActionCommand("RVREGISTRAR");

        txtMarca.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        txtMarca.setToolTipText("");

        txtCliente.setEditable(false);
        txtCliente.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        txtCliente.setToolTipText("");

        jLabel7.setText("Cliente");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtCliente))
                        .addComponent(txtMatricula)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel2)
                                    .addComponent(txtNumPoliza1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnRegistrar))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6)
                                    .addComponent(cmbCompSeguros, 0, 209, Short.MAX_VALUE)
                                    .addComponent(txtMarca)))
                            .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNumPoliza1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmbCompSeguros)
                        .addGap(3, 3, 3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnCancelar))
                .addGap(43, 43, 43))
        );

        getAccessibleContext().setAccessibleName("Registrar Vehiculo");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNumPoliza1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumPoliza1KeyPressed
        char c = evt.getKeyChar();
        if (!((c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)
                || (c == KeyEvent.VK_ENTER) || (c == KeyEvent.VK_TAB)
                || (Character.isDigit(c)))){
            evt.consume();
        }
    }//GEN-LAST:event_txtNumPoliza1KeyPressed

    private void txtNumPoliza1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumPoliza1KeyReleased
        char c = evt.getKeyChar();
        if (!((c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)
                || (c == KeyEvent.VK_ENTER) || (c == KeyEvent.VK_TAB)
                || (Character.isDigit(c)))){
            evt.consume();
        }
    }//GEN-LAST:event_txtNumPoliza1KeyReleased

    private void txtNumPoliza1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumPoliza1KeyTyped
        char c = evt.getKeyChar();
        if (!((c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)
                || (c == KeyEvent.VK_ENTER) || (c == KeyEvent.VK_TAB)
                || (Character.isDigit(c)))){
            evt.consume();
        }
    }//GEN-LAST:event_txtNumPoliza1KeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegVehiculoFr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegVehiculoFr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegVehiculoFr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegVehiculoFr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegVehiculoFr().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cmbCompSeguros;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtNumPoliza1;
    // End of variables declaration//GEN-END:variables

@Override
    public void setControlador(Controlador c) {
        this.btnCancelar.addActionListener(c);
        this.btnRegistrar.addActionListener(c);
        c.actionPerformed(new ActionEvent(this,0,InterfazVistaRegVehiculo.Operacion.RVCARGAR.toString()));
    }
    
    @Override
    public void iniciaVista() {
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    @Override
    public void cierraVista(){
        setVisible(false);
        limpiar();
        dispose();
    }
    
    @Override
    public void limpiar(){
        this.txtMarca.setText("");
        this.txtMatricula.setText("");
        this.txtModelo.setText("");
        this.txtNumPoliza1.setText("");
    }
    
    @Override
    public void imprimeMensaje(Exception... e){
        if(e.length>0){
            JOptionPane.showMessageDialog(this, "Error: " + e[0].getMessage(), "Informaci??n", JOptionPane.ERROR_MESSAGE);
        }else {
            JOptionPane.showMessageDialog(this, "Operaci??n ejecutada con exito", "Informaci??n", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void setTxtCliente(String cli){
        this.txtCliente.setText(cli);
    }
    
    public javax.swing.JComboBox getCmbCompanias(){
        return this.cmbCompSeguros;
    }
    
    public String getTxtMatricula(){
        return this.txtMatricula.getText();
    }
    
    public String getTxtMarca(){
        return this.txtMarca.getText();
    }
    
    public String getTxtModelo(){
        return this.txtModelo.getText();
    }
    
    public String getTxtPoliza(){
        return this.txtNumPoliza1.getText();
    }
}
