/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BD_Productos;

import Control_BD.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Sergio
 */
public class EliminarProductos extends javax.swing.JDialog {

    String idproducto = "";
    /**
     * Creates new form asdfg
     */

    Control_Productos prodao = new Control_Productos();

    private void llamarProductos() {

        // llamada de datos
        Control_Productos load = new Control_Productos();
        load.CargarProductos_eliminar();
        int[] anchos = {35, 300, 50, 150, 40, 50};
        for (int i = 0; i < jTable_productos.getColumnCount(); i++) {
            jTable_productos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }

    }

    public EliminarProductos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        llamarProductos();
        this.jButtonBuscar.setVisible(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField_busqueda = new javax.swing.JTextField();
        jButtonBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButtonEliminarCliente = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_productos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("EliminarClientes");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField_busqueda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_busqueda.setToolTipText("Ingrese el código del cliente para ser buscado.");
        jTextField_busqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_busquedaKeyPressed(evt);
            }
        });
        jPanel1.add(jTextField_busqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 110, -1));

        jButtonBuscar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonBuscar.setText("Buscar");
        jButtonBuscar.setToolTipText("Pulse para buscar datos del cliente.");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 100, 30));

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 290, 120));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Nombre");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(204, 0, 0));
        jButton1.setText("Cancelar");
        jButton1.setToolTipText("Pulse para regresar al menú.");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 320, 130, 40));

        jButtonEliminarCliente.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonEliminarCliente.setText("Eliminar ");
        jButtonEliminarCliente.setToolTipText("Pulse para eliminar el cliente.");
        jButtonEliminarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarClienteActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonEliminarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, 150, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Trash Full.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, -1, -1));

        jLabel8.setFont(new java.awt.Font("Constantia", 0, 40)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 0, 0));
        jLabel8.setText("Eliminar Productos");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 450, -1));

        jTable_productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable_productos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_productosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable_productos);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 669, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 528, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 400, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 264, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(92, 92, 92))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed

        Control_Productos cc = new Control_Productos();
        String parametroBusqueda = jTextField_busqueda.getText();
        cc.buscarProductosparaEliminarProductos(parametroBusqueda);
        int[] anchos = {35, 200, 80, 150, 40, 50};
        for (int i = 0; i < jTable_productos.getColumnCount(); i++) {
            jTable_productos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonEliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarClienteActionPerformed

        //   String code = jTextField_busqueda.getText();
        if(jTextArea1.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Primero seleccione un Producto");
        }else{
            prodao.EliminarProductos(idproducto);
            jTextField_busqueda.setText("");
            jTextArea1.setText(""); 
            llamarProductos();
        }
        

    }//GEN-LAST:event_jButtonEliminarClienteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.gc();//limpiar basura
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable_productosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_productosMouseClicked
        // TODO add your handling code here:
        //btn_eliminar.setEnabled(true);
        //btn_modificar.setEnabled(true);

        int fila = jTable_productos.rowAtPoint(evt.getPoint());

        idproducto = (jTable_productos.getValueAt(fila, 0).toString());
        
        jTextArea1.setText("Codigo: " + jTable_productos.getValueAt(fila, 0).toString() +
                           "\nNombre: " + jTable_productos.getValueAt(fila, 1).toString() +
                           "\nPrecio de venta: " + jTable_productos.getValueAt(fila, 2).toString() +
                           "\nDescripcion: " + jTable_productos.getValueAt(fila, 3).toString() +
                           "\nCantidad: " + jTable_productos.getValueAt(fila, 4).toString() +
                           "\nPrecio de compra: " + jTable_productos.getValueAt(fila, 5).toString()                   
        );
        jTextArea1.setEnabled(false);
        /*jTextFieldNombre.setText((jTable_productos.getValueAt(fila, 1).toString()));
        jTextFieldPrecios.setText((jTable_productos.getValueAt(fila, 2).toString()));
        jTextArea_descripcion.setText((jTable_productos.getValueAt(fila, 3).toString()));
        jTextField_cantidad.setText((jTable_productos.getValueAt(fila, 4).toString()));
        jTextField_preciocompra.setText((jTable_productos.getValueAt(fila, 5).toString()));*/
    }//GEN-LAST:event_jTable_productosMouseClicked

    private void jTextField_busquedaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_busquedaKeyPressed
        // TODO add your handling code here:
        Control_Productos cc = new Control_Productos();
        String parametroBusqueda = jTextField_busqueda.getText();
        cc.buscarProductosparaEliminarProductos(parametroBusqueda);
        int[] anchos = {35, 300, 50, 150, 40, 50};
        for (int i = 0; i < jTable_productos.getColumnCount(); i++) {
            jTable_productos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
    }//GEN-LAST:event_jTextField_busquedaKeyPressed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EliminarProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EliminarProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EliminarProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EliminarProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EliminarProductos dialog = new EliminarProductos(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonEliminarCliente;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    public static javax.swing.JTable jTable_productos;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField_busqueda;
    // End of variables declaration//GEN-END:variables
}