/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubp.doo.tp.vista;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import ubp.doo.tp.controlador.Controlador;
import ubp.doo.tp.vista.InterfazVistaRegVehiculo;
/**
 *
 * @author jeresabelox
 */
public class RegVehiculo extends javax.swing.JFrame implements InterfazVistaRegVehiculo {

    /**
     * Creates new form RegVehiculo
     */
    public RegVehiculo() {
        initComponents();
    }

    private static RegVehiculo instancia = null;
    public static RegVehiculo getInstancia() {
        if (instancia == null) {
            instancia = new RegVehiculo();
        }
        return instancia;
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
        cmbMarca = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtNumPoliza1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cmbCompSeguros1 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Registrar Vehiculo");

        txtModelo.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        txtModelo.setToolTipText("");

        jLabel2.setText("Matricula");

        txtMatricula.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        txtMatricula.setToolTipText("");

        jLabel3.setText("Número de Póliza");

        cmbMarca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMarcaActionPerformed(evt);
            }
        });

        jLabel4.setText("Compañia de Seguros");

        txtNumPoliza1.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        txtNumPoliza1.setToolTipText("");

        jLabel5.setText("Modelo");

        cmbCompSeguros1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbCompSeguros1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCompSeguros1ActionPerformed(evt);
            }
        });

        jLabel6.setText("Marca");

        btnCancelar.setText("Cancelar");
        btnCancelar.setActionCommand("RVCANCELAR");

        btnRegistrar.setText("Registrar");
        btnRegistrar.setActionCommand("RVREGISTRAR");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(jLabel1)
                .addGap(119, 119, 119))
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)
                                .addComponent(jLabel5)
                                .addComponent(jLabel2)
                                .addComponent(txtNumPoliza1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnRegistrar))
                            .addGap(36, 36, 36)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel6)
                                .addComponent(cmbCompSeguros1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(58, 58, 58)
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
                        .addComponent(cmbCompSeguros1)
                        .addGap(3, 3, 3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmbMarca)
                        .addGap(3, 3, 3)))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnCancelar))
                .addGap(43, 43, 43))
        );

        getAccessibleContext().setAccessibleName("Registrar Vehiculo");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbMarcaActionPerformed

    private void cmbCompSeguros1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCompSeguros1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCompSeguros1ActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarActionPerformed

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
            java.util.logging.Logger.getLogger(RegVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegVehiculo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cmbCompSeguros1;
    private javax.swing.JComboBox<String> cmbMarca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtNumPoliza1;
    // End of variables declaration//GEN-END:variables

@Override
    public void setControlador(Controlador c) {
        this.btnCancelar.addActionListener(c);
        this.btnRegistrar.addActionListener(c);
    }
    
    @Override
    public void iniciaVista() {
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    @Override
    public void imprimeMensaje(Exception... e){
        if(e.length>0){
            JOptionPane.showMessageDialog(this, "Error: " + e[0].getMessage(), "Información", JOptionPane.ERROR_MESSAGE);
        }else {
            JOptionPane.showMessageDialog(this, "Operación ejecutada con exito", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}