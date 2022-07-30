package Vistas;

import controlador.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import modelo.Conexion;

public class GestionarSucursalesForm extends javax.swing.JDialog {

    ComboBoxModel enumDepartamentos, enumTipoCalles, enumZonas;
    Conexion conexion = new Conexion();
    Connection connection;
    Statement st;
    ResultSet rs;

    public GestionarSucursalesForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        enumDepartamentos = new DefaultComboBoxModel(EnumDepartamento.values());
        enumTipoCalles = new DefaultComboBoxModel(EnumTipoCalle.values());
        enumZonas = new DefaultComboBoxModel(EnumZona.values());
        initComponents();
        this.setLocationRelativeTo(parent);
    }

    public void recibirDatosSucursal(int idDireccion, String sucursal, String departamento, String zona, String tipoCalle, String numero1, String numero2, String numero3) {
        enumDepartamentos.setSelectedItem(departamento);
        enumTipoCalles.setSelectedItem(tipoCalle);
        enumZonas.setSelectedItem(zona);
        txtSucursal.setText(sucursal);
        txtNumero1.setText(numero1);
        txtNumero2.setText(numero2);
        txtNumero3.setText(numero3);

    }

    public void actualizarSucursalDireccion() {
        String sucursal = txtSucursal.getText();
        String departamento = cbDepartamentos.getSelectedItem().toString();
        String tipoCalle = cbCalle.getSelectedItem().toString();
        String zona = cbZona.getSelectedItem().toString();
        String nuevaSucursal = txtNuevaSucursal.getText();
        String Numero1 = txtNumero1.getText();
        String Numero2 = txtNumero2.getText();
        String Numero3 = txtNumero3.getText();

        String queryIdDireccion = "SELECT idDireccion FROM direccion INNER JOIN sucursal WHERE direccion.IdDireccion = sucursal.FK_idDireccion AND sucursal.nombreSucursal = '" + sucursal + "'";
        try {
            connection = conexion.getConnection();
            st = connection.createStatement();
            rs = st.executeQuery(queryIdDireccion);
            while (rs.next()) {
                int idDireccion = rs.getInt("idDireccion");
                String queryActualizar = "UPDATE direccion SET zona = '" + zona + "', tipoCalle = '" + tipoCalle + "', numero1 = '" + Numero1 + "', numero2 = '" + Numero2 + "', numero3 = '" + Numero3 + "', nombreDepartamento = '" + departamento + "' WHERE idDireccion = '" + idDireccion + "';";
                try {
                    st.executeUpdate(queryActualizar);
                    JOptionPane.showMessageDialog(this, "Informacion actualizada");
                    this.dispose();
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        if (!nuevaSucursal.isEmpty()) {
            String queryIdSucursal = "SELECT idSucursal FROM sucursal INNER JOIN direccion ON sucursal.FK_idDireccion = direccion.idDireccion AND sucursal.nombreSucursal = '" + sucursal + "';";
            try {
                connection = conexion.getConnection();
                st = connection.createStatement();
                rs = st.executeQuery(queryIdSucursal);
                while (rs.next()) {
                    int idSucursal = rs.getInt("idSucursal");
                    String queryActualizarSucursal = "UPDATE sucursal SET nombreSucursal = '" + nuevaSucursal + "' WHERE idSucursal =" + idSucursal + ";";
                    try {
                        st.executeUpdate(queryActualizarSucursal);
                    } catch (SQLException e) {
                        System.out.println(e);
                    }
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

    public void eliminarSucursalDireccion() {
        String sucursal = txtSucursal.getText();
        String queryIdDireccion = "SELECT idDireccion, idSucursal FROM direccion INNER JOIN sucursal WHERE direccion.IdDireccion = sucursal.FK_idDireccion AND sucursal.nombreSucursal = '" + sucursal + "'";
        try {
            connection = conexion.getConnection();
            st = connection.createStatement();
            rs = st.executeQuery(queryIdDireccion);
            while (rs.next()) {
                int idDireccion = rs.getInt("idDireccion");
                int idSucursal = rs.getInt("idSucursal");
                String queryEliminarDireccion = "DELETE FROM direccion WHERE direccion = " + idDireccion + ";";
                String queryEliminarSucursal = "DELETE FROM sucursal WHERE idSucursal = " + idSucursal + ";";
                try {
                    st.executeUpdate(queryEliminarDireccion);
                    st.executeUpdate(queryEliminarSucursal);
                    this.dispose();
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtSucursal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNuevaSucursal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbDepartamentos = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cbZona = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cbCalle = new javax.swing.JComboBox<>();
        txtNumero1 = new javax.swing.JTextField();
        txtNumero2 = new javax.swing.JTextField();
        txtNumero3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(155, 204, 255));

        jLabel1.setText("Sucursal");

        txtSucursal.setEditable(false);
        txtSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSucursalActionPerformed(evt);
            }
        });

        jLabel2.setText("Nuevo Nombre Sucursal");

        jLabel3.setText("Departamento");

        cbDepartamentos.setModel(enumDepartamentos);

        jLabel4.setText("Zona");

        cbZona.setModel(enumZonas);

        jLabel5.setText("Tipo Calle");

        cbCalle.setModel(enumTipoCalles);

        jLabel6.setText("#No.");

        btnEditar.setText("Actualizar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbDepartamentos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtNuevaSucursal, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                                    .addComponent(cbZona, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(btnEditar)
                        .addGap(39, 39, 39)
                        .addComponent(btnEliminar)
                        .addGap(36, 36, 36)
                        .addComponent(btnCancelar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(cbCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNumero1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNumero2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtNumero3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNuevaSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbDepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbZona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtNumero1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumero2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumero3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(btnCancelar)
                    .addComponent(btnEditar))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSucursalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSucursalActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        actualizarSucursalDireccion();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        eliminarSucursalDireccion();
    }//GEN-LAST:event_btnEliminarActionPerformed

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
            java.util.logging.Logger.getLogger(GestionarSucursalesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionarSucursalesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionarSucursalesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionarSucursalesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GestionarSucursalesForm dialog = new GestionarSucursalesForm(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JComboBox<String> cbCalle;
    private javax.swing.JComboBox<String> cbDepartamentos;
    private javax.swing.JComboBox<String> cbZona;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtNuevaSucursal;
    private javax.swing.JTextField txtNumero1;
    private javax.swing.JTextField txtNumero2;
    private javax.swing.JTextField txtNumero3;
    private javax.swing.JTextField txtSucursal;
    // End of variables declaration//GEN-END:variables
}
