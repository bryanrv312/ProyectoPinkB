/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BD_Usuario;


import Control_BD.fusuario;
import Control_BD.vusuario;
import com.placeholder.PlaceHolder;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class frmusuario extends javax.swing.JFrame {
    
    PlaceHolder holders;
    
    public frmusuario() {
        initComponents();
        this.setLocationRelativeTo(null);
        //this.getContentPane().setBackground(Color.green);
        this.setTitle("Mantenimiento Usuario ");
        holders=new PlaceHolder(txt_buscar,"Ingrese nombre o dni");
        iniciar();
    }
    
    public void iniciar(){
            try {
                fusuario udao = new fusuario(); 
                ArrayList<vusuario> listaUsuario = udao.mostrarInicio();
          
                //modelo = func.mostrar_inicial();
                String[] titulos = {"id", "usuario", "pasword", "tipo", "nombres", "apellidos", "dni", "telefono"};
                DefaultTableModel modelo = new DefaultTableModel(null,titulos); 
                
                Object o[] = null;
                
                for(int i = 0; i < listaUsuario.size(); i++){
                    modelo.addRow(o);
                    vusuario usu = (vusuario) listaUsuario.get(i);
                    modelo.setValueAt(usu.getId(), i, 0);
                    modelo.setValueAt(usu.getUsuario(), i, 1);
                    modelo.setValueAt(usu.getPassword(), i, 2);
                    modelo.setValueAt(udao.getTipoUsuById(usu.getTipo()), i, 3);
                    modelo.setValueAt(usu.getNombres(), i, 4);
                    modelo.setValueAt(usu.getApellidos(), i, 5);
                    modelo.setValueAt(usu.getdni(), i, 6);
                    modelo.setValueAt(usu.getTelefono(), i, 7);      
                }

                jTable_listado.setModel(modelo);


        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }

    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_salir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txt_buscar = new javax.swing.JTextField();
        btn_nuevo = new javax.swing.JButton();
        btn_buscar = new javax.swing.JButton();
        btn_salir1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_listado = new javax.swing.JTable();

        btn_salir.setForeground(new java.awt.Color(11, 7, 7));
        btn_salir.setText("Salir");
        btn_salir.setEnabled(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 255));
        jLabel1.setText("LISTA DE USUARIOS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(307, 11, -1, 36));

        txt_buscar.setForeground(new java.awt.Color(138, 138, 138));
        getContentPane().add(txt_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 82, 258, -1));

        btn_nuevo.setText("Nuevo");
        btn_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevoActionPerformed(evt);
            }
        });
        getContentPane().add(btn_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 100, -1, -1));

        btn_buscar.setText("Buscar");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(284, 81, -1, -1));

        btn_salir1.setText("Salir");
        btn_salir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salir1ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_salir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 130, 63, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 606, 774, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 457, 10));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/logo4.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 170));

        jTable_listado.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable_listado);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 173, 784, 402));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoActionPerformed
        // TODO add your handling code here:
        frmusuarionuevo form =new frmusuarionuevo();
        //this.add(form);
        form.toFront();
        form.setVisible(true);
        
    }//GEN-LAST:event_btn_nuevoActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
         try {
                fusuario udao = new fusuario(); 
                ArrayList<vusuario> listaUsuario = udao.buscarUsuario(txt_buscar.getText());
                String[] titulos = {"id", "usuario", "pasword", "tipo", "nombres", "apellidos", "dni", "telefono"};
                DefaultTableModel modelo = new DefaultTableModel(null,titulos); 
                
                Object o[] = null;
                
                for(int i = 0; i < listaUsuario.size(); i++){
                    modelo.addRow(o);
                    vusuario usu = (vusuario) listaUsuario.get(i);
                    modelo.setValueAt(usu.getId(), i, 0);
                    modelo.setValueAt(usu.getUsuario(), i, 1);
                    modelo.setValueAt(usu.getPassword(), i, 2);
                    modelo.setValueAt(usu.getTipo(), i, 3);
                    modelo.setValueAt(usu.getNombres(), i, 4);
                    modelo.setValueAt(usu.getApellidos(), i, 5);
                    modelo.setValueAt(usu.getdni(), i, 6);
                    modelo.setValueAt(usu.getTelefono(), i, 7);      
                }

                jTable_listado.setModel(modelo);
                txt_buscar.setText("");
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }
                
        /*try {
            DefaultTableModel modelo;
            fusuario func = new fusuario();
            modelo = func.mostrar(txt_buscar.getText());

            jTable_listado.setModel(modelo);
            //ocultar_columnas();
            //lbltotalregistros.setText("Total Registros " + Integer.toString(func.totalregistros));

        } catch (Exception e) {
        }*/
            //txt_buscar.setText("");
           
            
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_salir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salir1ActionPerformed
        // TODO add your handling code here:
                dispose();
    }//GEN-LAST:event_btn_salir1ActionPerformed

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
            java.util.logging.Logger.getLogger(frmusuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmusuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmusuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmusuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmusuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_nuevo;
    private javax.swing.JButton btn_salir;
    private javax.swing.JButton btn_salir1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable_listado;
    private javax.swing.JTextField txt_buscar;
    // End of variables declaration//GEN-END:variables
}
