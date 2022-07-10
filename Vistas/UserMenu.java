/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Conexion;

/**
 *
 * @author black
 */
public class UserMenu extends javax.swing.JFrame {

    //Instancia de la clase Conexion
    Conexion conexion = new Conexion();
    Connection connection;
    //Libreria statement permite ejecutar los query  SQL
    Statement st;
    ResultSet rs;
    //Creamos una instancia de la tabla de la interfaz
    DefaultTableModel contenidoTablaEmpleados;

    public UserMenu() {
        initComponents();
        listarEmpleados();
    }

    //Metodo que trae todos los empleados existentes en la base de datos
    private void listarEmpleados() {
        String filtroBusqueda = txtSearch.getText();
        if (filtroBusqueda.isEmpty()) {
            String queryConsulta = "SELECT * FROM empleados";
            //Intentar ejecutar el query y obtener una respuesta de la base de datos
            try {
                connection = conexion.getConnection();
                st = connection.createStatement();
                rs = st.executeQuery(queryConsulta);
                //Crear objeto donde se almacene el resultado de la consulta de los empleados
                Object[] empleados = new Object[6];
                contenidoTablaEmpleados = (DefaultTableModel) tbEmpleados.getModel();
                //Recorremos el resultado de la consulta del query
                while (rs.next()) {
                    empleados[0] = rs.getInt("idEmp");
                    empleados[1] = rs.getString("nombreEmp");
                    empleados[2] = rs.getString("apellidosEmp");
                    empleados[3] = rs.getString("tipoDocumento");
                    empleados[4] = rs.getString("documento");
                    empleados[5] = rs.getString("correoElectronico");
                    //Creamos una fila dentro de la tabla por cada empleado que devuelve la consulta
                    contenidoTablaEmpleados.addRow(empleados);
                    System.out.println("id: " + empleados[0] + " Nombre: " + empleados[1] + " Documento: " + empleados[2] + " " + empleados[3] + " Correo: " + empleados[4]);
                    tbEmpleados.setModel(contenidoTablaEmpleados);
                }
            } catch (SQLException e) {
                System.out.println("Error");
            }
        } else {
            String queryConsulta = "SELECT * FROM empleados WHERE nombreEmp LIKE '%" + filtroBusqueda + "%' OR apellidosEmp LIKE '%" + filtroBusqueda + "%'";
            System.out.println(queryConsulta);
            try {
                connection = conexion.getConnection();
                st = connection.createStatement();
                rs = st.executeQuery(queryConsulta);
                //Crear objeto donde se almacene el resultado de la consulta de los empleados
                Object[] empleados = new Object[6];
                contenidoTablaEmpleados = (DefaultTableModel) tbEmpleados.getModel();
                //Recorremos el resultado de la consulta del query
                while (rs.next()) {
                    empleados[0] = rs.getInt("idEmp");
                    empleados[1] = rs.getString("nombreEmp");
                    empleados[2] = rs.getString("apellidosEmp");
                    empleados[3] = rs.getString("tipoDocumento");
                    empleados[4] = rs.getString("documento");
                    empleados[5] = rs.getString("correoElectronico");
                    //Creamos una fila dentro de la tabla por cada empleado que devuelve la consulta
                    contenidoTablaEmpleados.addRow(empleados);
                    System.out.println("id: " + empleados[0] + " Nombre: " + empleados[1] + " Documento: " + empleados[2] + " " + empleados[3] + " Correo: " + empleados[4]);
                    tbEmpleados.setModel(contenidoTablaEmpleados);
                }
            } catch (SQLException e) {
                System.out.println("Error");
            }

        }

    }

    //Cuando añado en nuevo empleado el proceso background es el siguiente:
    //Se almacena el nuevo empleado en la base de datos
    //Se eliminan los datos que tienen la tabla de tbEmpleados
    //Se llama el metodo listarEmpleados para consultar nuevamente la BD
    //Se cargan los empleados en la tabla incluyendo el recien creado
    private void borrarDatosTabla() {
        //el metodo getrowcount, devuelve la cantidad de registros existentes
        for (int i = 0; i < tbEmpleados.getRowCount(); i++) {
            contenidoTablaEmpleados.removeRow(i);
            i -= 1;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbEmpleados = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnAddUser = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);

        jTabbedPane1.setBackground(new java.awt.Color(204, 204, 255));

        jPanel5.setBackground(new java.awt.Color(153, 204, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 912, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 528, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Home", jPanel2);

        jPanel7.setBackground(new java.awt.Color(153, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel1.setText("INFORMACIÓN EMPLEADOS");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tbEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Apellido(s)", "Tipo Documento", "Numero Documento", "Correo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbEmpleados);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Nombre");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/showUser.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(104, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(jLabel2)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnAddUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/img2.png"))); // NOI18N
        btnAddUser.setText("Crear Empleado");
        btnAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAddUser))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(128, 128, 128)
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 48, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(6, 6, 6)
                        .addComponent(btnAddUser)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Empleados", jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUserActionPerformed
        // Crear instancia del dialogo
        AddUserForm addUserF = new AddUserForm(this, rootPaneCheckingEnabled);
        addUserF.setVisible(rootPaneCheckingEnabled);
        borrarDatosTabla();
        listarEmpleados();
    }//GEN-LAST:event_btnAddUserActionPerformed

    private void tbEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbEmpleadosMouseClicked
        int row = tbEmpleados.getSelectedRow();
        System.out.println("Fila seleccionada #: " + row);
        //VAlidar si el usuario no ha seleccionado un empleado
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un empleado", "", JOptionPane.WARNING_MESSAGE);
        } else {
            //Cada fila es un registro empleado
            int idEmp = Integer.parseInt(tbEmpleados.getValueAt(row, 0).toString());
            String nombreEmp = tbEmpleados.getValueAt(row, 1).toString();
            String apellidos = tbEmpleados.getValueAt(row, 2).toString();
            String tipodocumento = tbEmpleados.getValueAt(row, 3).toString();
            String documento = tbEmpleados.getValueAt(row, 4).toString();
            String correo = tbEmpleados.getValueAt(row, 5).toString();

            System.out.println("ID: " + idEmp + " Nombre " + nombreEmp + " apellidos " + apellidos + " documento " + tipodocumento + " " + documento + " correo " + correo);
            ShowUserForm showuserform = new ShowUserForm(this, true);
            //Mediante la instancia del Jdialog envaimos los datos del empleado de esta vista actual a esta vista que muestra la info en detalle
            showuserform.recibeDatos(idEmp, nombreEmp, apellidos, tipodocumento, documento, correo);
            showuserform.setVisible(rootPaneCheckingEnabled);
            //Para actualizar la tabla del empleado que se acab de editar se debe borar los datos de la tabla y cargarlos nuevamente
            borrarDatosTabla();
            listarEmpleados();
        }
    }//GEN-LAST:event_tbEmpleadosMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        borrarDatosTabla();
        listarEmpleados();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(UserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddUser;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tbEmpleados;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
