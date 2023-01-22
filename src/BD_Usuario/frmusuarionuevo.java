/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BD_Usuario;


import Control_BD.fusuario;
import Control_BD.tipoUsuario;
import Control_BD.vusuario;
import com.placeholder.PlaceHolder;
import java.awt.HeadlessException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author richard
 */
public class frmusuarionuevo extends javax.swing.JFrame {
    PlaceHolder holders;
    
    
    public frmusuarionuevo() {
        initComponents();
        llenarTipoUsuario();
        this.setLocationRelativeTo(null);
        // this.getContentPane().setBackground(Color.orange);
               this.setTitle("Usuario Nuevo ");
              /* holders=new PlaceHolder(txt_nombres,"Ingrese nombres");
               holders=new PlaceHolder(txt_apellidos,"Ingrese apellidos");
               holders=new PlaceHolder(txt_dni,"Ingrese dni");
               holders=new PlaceHolder(txt_usuario,"Ingrese usuario");
               holders=new PlaceHolder(txt_pasword,"Ingrese contraseña");
               holders=new PlaceHolder(txt_telefono,"Ingrese telefono");*/
    }
    
    private void llenarTipoUsuario(){
        fusuario udao = new fusuario();
        ArrayList<tipoUsuario> lista = udao.getTiposUsuario();
        
        combo_tipo.removeAllItems();
        
        for(tipoUsuario tipo : lista){
            combo_tipo.addItem(tipo.getDescripcion());
        }
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btn_guardar = new javax.swing.JButton();
        btn_salir = new javax.swing.JButton();
        txt_nombres = new javax.swing.JTextField();
        txt_usuario = new javax.swing.JTextField();
        txt_apellidos = new javax.swing.JTextField();
        txt_pasword = new javax.swing.JTextField();
        txt_dni = new javax.swing.JTextField();
        combo_tipo = new javax.swing.JComboBox();
        txt_telefono = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Nombres");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, 20));

        jLabel8.setText("Telefono");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 180, -1, -1));

        jLabel7.setText("Password");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, -1, -1));

        jLabel6.setText("Usuario");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, -1, -1));

        jLabel4.setText("Apellidos");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        jLabel5.setText("Nro Dni");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        btn_guardar.setText("Guardar");
        btn_guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_guardarMouseClicked(evt);
            }
        });
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(583, 67, -1, -1));

        btn_salir.setText("Salir");
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });
        getContentPane().add(btn_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(599, 139, -1, -1));

        txt_nombres.setForeground(new java.awt.Color(153, 143, 143));
        getContentPane().add(txt_nombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 103, 250, -1));

        txt_usuario.setForeground(new java.awt.Color(153, 143, 143));
        getContentPane().add(txt_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, 123, -1));

        txt_apellidos.setForeground(new java.awt.Color(153, 143, 143));
        getContentPane().add(txt_apellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 139, 250, -1));

        txt_pasword.setForeground(new java.awt.Color(153, 143, 143));
        getContentPane().add(txt_pasword, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 140, 123, -1));

        txt_dni.setForeground(new java.awt.Color(153, 143, 143));
        getContentPane().add(txt_dni, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 180, 110, -1));

        combo_tipo.setForeground(new java.awt.Color(157, 155, 155));
        combo_tipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Administrador", "Empleado" }));
        combo_tipo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        combo_tipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_tipoActionPerformed(evt);
            }
        });
        getContentPane().add(combo_tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 145, -1));

        txt_telefono.setForeground(new java.awt.Color(153, 143, 143));
        getContentPane().add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, 123, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("REGISTRO DE USUARIO");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 340, 10));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/logo3.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 270));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
           
       String nom = txt_nombres.getText();
       String ape = txt_apellidos.getText();
       String uss = txt_usuario.getText();
       String pas = txt_pasword.getText();
       String dni = txt_dni.getText();
       String tel = txt_telefono.getText();
       
       
       if(nom.length() == 0 || ape.length() == 0 || uss.length() == 0 || pas.length() == 0 || dni.length() == 0 || tel.length() == 0 ){
           JOptionPane.showMessageDialog(null, "rellene todos los cmpos");
       }else{
           vusuario usu = new vusuario();
           fusuario udao = new fusuario();
           
           int dni_evaluar = Integer.parseInt(dni);
           
             if(udao.existeDni(dni_evaluar) == 0){

                    usu.setNombres(txt_nombres.getText());
                    usu.setApellidos(txt_apellidos.getText());
                    usu.setUsuario(txt_usuario.getText());
                    
                    /*int tipo = combo_tipo.getSelectedIndex();
                    usu.setTipo("2");*/
                    
                    //int tipo = combo_tipo.getSelectedIndex();
                    //usu.setTipo((String) combo_tipo.getItemAt(tipo));
                    //String tipo = (String) combo_tipo.getSelectedItem();
                    int tipo_id = combo_tipo.getSelectedIndex() + 1;
                    String tipo = String.valueOf(tipo_id);
                    //System.out.println("brv " + tipo);
                    usu.setTipo(tipo);

                    usu.setdni(Integer.parseInt(txt_dni.getText()));
                    usu.setPassword(txt_pasword.getText());
                    usu.setTelefono( Integer.parseInt(txt_telefono.getText()));

                    if (udao.insertarUsuario(usu)) {
                        JOptionPane.showMessageDialog(rootPane, "El Usuario fue insertado satisfactoriamente");
                    }else{
                        JOptionPane.showMessageDialog(rootPane, "El Usuario NO se logró insertar");
                    }
                    
                }else{
                    JOptionPane.showMessageDialog(rootPane, "DNI ya Existente!!");
                }
                
            
       }
       
        
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        // TODO add your handling code here:
                dispose();
    }//GEN-LAST:event_btn_salirActionPerformed

    private void combo_tipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_tipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_tipoActionPerformed

    private void btn_guardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_guardarMouseClicked
        // TODO add your handling code here:
            
    }//GEN-LAST:event_btn_guardarMouseClicked

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
            java.util.logging.Logger.getLogger(frmusuarionuevo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmusuarionuevo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmusuarionuevo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmusuarionuevo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmusuarionuevo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_salir;
    private javax.swing.JComboBox combo_tipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txt_apellidos;
    private javax.swing.JTextField txt_dni;
    private javax.swing.JTextField txt_nombres;
    private javax.swing.JTextField txt_pasword;
    private javax.swing.JTextField txt_telefono;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
}
