/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD_Productos;

import Control_BD.ConexionConBaseDatos;
import principal.Ventas;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Felipe
 */
public class addProductos extends javax.swing.JDialog {

    String path = "";//creamos una variable global para guardar el path
    String id_producto = "";
    /**
     * Creates new form addCliente
     */
    ConexionConBaseDatos conectar = new ConexionConBaseDatos();

    public addProductos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        jLabel_imagen.setVisible(false);
        btn_abrir_imagen.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldPrecios = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_descripcion = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldCantidad = new javax.swing.JTextField();
        jTextField_preciocompra = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel_imagen = new javax.swing.JLabel();
        btn_abrir_imagen = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Datos de Productos", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        jTextFieldNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldNombreKeyTyped(evt);
            }
        });

        jTextFieldPrecios.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldPrecios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldPreciosKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        jLabel5.setText("Precio compra");

        jLabel7.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        jLabel7.setText("Stock");

        jTextArea_descripcion.setColumns(20);
        jTextArea_descripcion.setRows(5);
        jScrollPane1.setViewportView(jTextArea_descripcion);

        jLabel8.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        jLabel8.setText("Descripci??n");

        jTextFieldCantidad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldCantidadKeyTyped(evt);
            }
        });

        jTextField_preciocompra.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_preciocompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_preciocompraKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        jLabel9.setText("Precio venta");

        jLabel4.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        jLabel4.setText("Nombre de producto");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextFieldCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(401, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jTextField_preciocompra, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(53, 53, 53)
                                        .addComponent(jLabel9)
                                        .addGap(52, 52, 52)
                                        .addComponent(jTextFieldPrecios, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(74, 74, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField_preciocompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jTextFieldPrecios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(23, 23, 23))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icon-shipping-and-receiving.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 32)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nuevo Producto");

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 153, 153));
        jButton3.setText("Nuevo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Regristar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(204, 0, 0));
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel_imagen.setText("Imagen");

        btn_abrir_imagen.setText("Seleccione imagen");
        btn_abrir_imagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_abrir_imagenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_abrir_imagen)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel_imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
            .addGroup(layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(jButton2)
                .addGap(67, 67, 67)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel_imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)
                            .addComponent(jButton3))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_abrir_imagen)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel2.getAccessibleContext().setAccessibleName("Datos del Producto");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        dispose();
        addProductos.main(null);

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code her

        String nombre = jTextFieldNombre.getText();
        String precio = jTextFieldPrecios.getText();
        String precio2 = jTextField_preciocompra.getText();
        String descripcion = jTextArea_descripcion.getText();
        String stock = jTextFieldCantidad.getText();

        if (nombre.equalsIgnoreCase("") || precio.equalsIgnoreCase("") || precio2.equalsIgnoreCase("") || descripcion.equalsIgnoreCase("") || stock.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(rootPane, "Rellene todos los Campos");
        } else {

            Double pre_com = Double.parseDouble(jTextField_preciocompra.getText());
            Double pre_ven = Double.parseDouble(jTextFieldPrecios.getText());

            if (pre_ven < pre_com) {
                JOptionPane.showMessageDialog(rootPane, "Ingrese un precio de venta MAYOR al de compra");
            } else {

                Connection reg = conectar.getConexion();

                String sql = "INSERT INTO table_Productos (nombreP, precioP,descripcionP,cantidadP,preciocompraP,Diferencia) VALUES (?,?,?,?,?,?)";
                try {
                    PreparedStatement pst = reg.prepareStatement(sql);
                    pst.setString(1, jTextFieldNombre.getText());
                    pst.setString(2, jTextFieldPrecios.getText());
                    pst.setString(3, jTextArea_descripcion.getText());
                    pst.setInt(4, Integer.parseInt(jTextFieldCantidad.getText()));
                    float dif = 0;
                    dif = Float.valueOf(jTextFieldPrecios.getText()) - Float.valueOf(jTextField_preciocompra.getText());
                    pst.setString(5, (jTextField_preciocompra.getText()));
                    pst.setString(6, dif + "");
                    int n = pst.executeUpdate();
                    if (n > 0) {
                        JOptionPane.showMessageDialog(null, "Regristado Exitosamente");

                    }

                    String[] registro = new String[14];

                    int totalregistros = 0;
                    String sSQL = "select codP from table_Productos";
                    Statement st = reg.createStatement();
                    ResultSet rs = st.executeQuery(sSQL);

                    while (rs.next()) {
                        registro[0] = rs.getString("codP");
                        id_producto = (registro[0]);
                        totalregistros++;
                        //  modelo.addRow(registro);
                    }
                    save();

                    dispose();
                    addProductos.main(null);
                } catch (Exception ex) {
                    System.out.println("error" + ex);
                    //JOptionPane.showMessageDialog(null, "Error |-|-|-| " + ex);
                    Logger.getLogger(addProductos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btn_abrir_imagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_abrir_imagenActionPerformed
        // TODO add your handling code here:
        try {
            open();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }//GEN-LAST:event_btn_abrir_imagenActionPerformed

    private void jTextFieldCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCantidadKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
//             String ruc=jTextField_rucKeyTyped(evt);.getText();

        if (Character.isLetter(c)) {

            getToolkit().beep();

            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldCantidadKeyTyped

    private void jTextField_preciocompraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_preciocompraKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
//             String ruc=jTextField_rucKeyTyped(evt);.getText();

        if (Character.isLetter(c)) {

            getToolkit().beep();

            evt.consume();
        }
    }//GEN-LAST:event_jTextField_preciocompraKeyTyped

    private void jTextFieldPreciosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPreciosKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
//             String ruc=jTextField_rucKeyTyped(evt);.getText();

        if (Character.isLetter(c)) {

            getToolkit().beep();

            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldPreciosKeyTyped

    private void jTextFieldNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNombreKeyTyped
        if (jTextFieldNombre.getText().length() >= 50) {
            String ruc = "";
            ruc = jTextFieldNombre.getText();
            jTextFieldNombre.setText(ruc.substring(0, ruc.length()));
            evt.consume();
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "Ingrese solo 50 caracteres ");
        }
        char c = evt.getKeyChar();
//            String ruc=jTextField_rucKeyTyped(evt);.getText();
        if (Character.isDigit(c)) {
            evt.consume();
            //getToolkit().beep(); 
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Ingrese solo letras ");
        }
    }//GEN-LAST:event_jTextFieldNombreKeyTyped
    void open() throws IOException {
        //empezamos implementando la clase JFileChooser para abrir archivos
        JFileChooser JFC = new JFileChooser();
        //filtro que muestra solo los archivos con extension *.edu
        JFC.setFileFilter(new FileNameExtensionFilter("todos los archivos *.jpg", "png", "JPG"));
        //se comprueba si se ha dado al boton aceptar
        int abrir = JFC.showDialog(null, "Abrir");
        if (abrir == JFileChooser.APPROVE_OPTION) {
            FileReader FR = null;
            BufferedReader BR = null;

            try {
                //abro el fichero y creo un BufferedReader para hacer
                //una lectura comoda (tener el metodo readLine();)
                File archivo = JFC.getSelectedFile();//abre un archivo .lengf

                //evitar abrir archivo con otra extension que no sea *.LFP
                String PATH = JFC.getSelectedFile().getAbsolutePath();
                if (PATH.endsWith(".jpg") || PATH.endsWith(".png")) {

                    FR = new FileReader(archivo);
                    BR = new BufferedReader(FR);

                    //leyendo el archivo
                    String linea;//variable para leer linea por linea el archivo de entrada
                    if (path.compareTo(archivo.getAbsolutePath()) == 0) {
                        System.out.println("Archivo Abierto" + "Oops! Error" + JOptionPane.ERROR_MESSAGE);
                    } else {
                        path = archivo.getAbsolutePath();
                        //   jTextArea.setText(null);//limpiamos el textArea antes de sobreescribir
                        while ((linea = BR.readLine()) != null) { //cuando termina el texto del archivo?
                            //  jTextArea.append(linea+"\n");//utilizamos append para escribir en el textArea
                            //  textodir=linea+"\n";
                        }
                    }
                    jLabel_imagen.setIcon(new ImageIcon(path));
                    ImageIcon icon = new ImageIcon(path);
                    Image img = icon.getImage();
                    Image newimg = img.getScaledInstance(jLabel_imagen.getWidth(), jLabel_imagen.getHeight(), java.awt.Image.SCALE_SMOOTH);
                    ImageIcon newIcon = new ImageIcon(newimg);
                    jLabel_imagen.setIcon(newIcon);
                    jLabel_imagen.setSize(jLabel_imagen.getWidth(), jLabel_imagen.getHeight());

                } else {
                    System.out.println("Archivo no soportado" + "Oops! Error" + JOptionPane.ERROR_MESSAGE);
                    open();
                }

            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
                //Logger.getLogger(fileChooser.class.getName()).log(Level.SEVERE, null, ex);
                //cerramos el fichero, para asegurar que se cierra tanto
                // si todo va bien si salta una excepcion
            } finally {
                try {
                    if (null != FR) {
                        FR.close();
                    }

                } catch (IOException ex) {
                    ex.printStackTrace();
                    //Logger.getLogger(fileChooser.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private void save() {

        try {
            String file = new String("/imgproductos/" + id_producto + ".jpg");
            String master = System.getProperty("user.dir") + file;

            File source = new File(path);

            File dest = new File(master);

            System.out.println("origen :" + path + "destino: " + master);

            // copy file using FileStreams
            long start = System.nanoTime();

            long end;

            copyFileUsingFileStreams(source, dest);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private static void copyFileUsingFileStreams(File source, File dest)
            throws IOException {

        InputStream input = null;

        OutputStream output = null;

        try {

            input = new FileInputStream(source);

            output = new FileOutputStream(dest);

            byte[] buf = new byte[1024];

            int bytesRead;

            while ((bytesRead = input.read(buf)) > 0) {

                output.write(buf, 0, bytesRead);

            }

        } finally {

            input.close();

            output.close();

        }
    }

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
            java.util.logging.Logger.getLogger(addProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                addProductos dialog = new addProductos(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_abrir_imagen;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_imagen;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea jTextArea_descripcion;
    private javax.swing.JTextField jTextFieldCantidad;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldPrecios;
    private javax.swing.JTextField jTextField_preciocompra;
    // End of variables declaration//GEN-END:variables
}
