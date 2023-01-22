/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import BD_Cliente.addCliente;
import Control_BD.*;
import com.itextpdf.text.Image;
import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Felipe
 */
public class Ventas extends javax.swing.JDialog {

    public static String arreglo[];
    public vusuario usuarioVendedor;
    int n = 0;
    float totals = 0;
    //String son = "";
    String nro_factura = "";
    String nro_boleta = "";
    DefaultTableModel modelo;
    DefaultTableModel modelo2;
    // llamada clase de conexion
    ConexionConBaseDatos conectar = new ConexionConBaseDatos();
    String ClienteExistente = "no";

    private List<productos> listaProd;

    /**
     * Creates new form Ventas
     */
    public Ventas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        /**
         * ******************************************************
         */
        /*SETEAMOS AL USUARIO QUE VENDERA*/
        MenuPrincipal menu = new MenuPrincipal();
        //txtusuarioventa.setText(menu.nombre_usu);
        //txtusuarioventa.setEnabled(false);
        txtusuariocodigoventa.setText(menu.codigo_usu);
        txtusuariocodigoventa.setEnabled(false);
        /**
         * ******************************************************
         */
        modelo = new DefaultTableModel();
        // Agrega fila

        modelo.addColumn("Cod");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Productos");
        modelo.addColumn("Descripción");

        modelo.addColumn("Precio Unitario");
        modelo.addColumn("Importe");

        this.JTableProduct.setModel(modelo);
        setLocationRelativeTo(null);

        // CONFIGURAR el taño de ancho de la tabla
        //TABLA FINAL
        int[] anchos = {50, 80, 150, 150, 100, 100};
        for (int i = 0; i < JTableProduct.getColumnCount(); i++) {
            JTableProduct.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);

            ocultar_columnas();

            //tbla 2
            modelo2 = new DefaultTableModel();
            // Agrega fila

            modelo2.addColumn("importe");

            // Leer la fecha de computador y colocarlo el cuadro de fecha
            Date fechaActual = new Date();
            SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
            String fecha = formateador.format(fechaActual);
            jTextFieldFecha.setText(fecha);
            jTextFieldFecha.setEditable(false);
            //-------------------------------------------
        }
        listaProd = new ArrayList<>();
    }

    Ventas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //ventana de productos
    //LO LLAMAMOS EN EL BOTON *NUEVO PRODUCTO* (jbutton2)
    private void llamarProductos() {

        // llamada de datos
        Control_Productos load = new Control_Productos();
        load.CargarProductosVentas();//se carga todos los productos
        //Centramos nuestro jDialog
        jDialogProductos.setLocation(200, 100);
        //La hacemos modal
        jDialogProductos.setModal(true);
        //Establecemos dimensiones.
        jDialogProductos.setMinimumSize(new Dimension(747, 385));

        //Establecemos un título para el jDialog
        jDialogProductos.setTitle("Lista de Productos.");
        //La hacemos visible.
        jDialogProductos.setVisible(true);
    }

    //ventana de productos
    //ventana de productos
    private void llamarCliente() {

        // llamada de datos
        Control_Cliente loadss = new Control_Cliente();
        loadss.CargarClientesVentas();
        //Centramos nuestro jDialog
        jDialogCliente.setLocation(250, 150);
        //La hacemos modal
        jDialogCliente.setModal(true);
        //Establecemos dimensiones.
        jDialogCliente.setMinimumSize(new Dimension(530, 358));
        //Establecemos un título para el jDialog
        jDialogCliente.setTitle("Lista de Clientes.");
        JTextField texto = new JTextField();
        jDialogCliente.add(texto);
        //La hacemos visible.
        jDialogCliente.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialogVendedor = new javax.swing.JDialog();
        jScrollPane1 = new javax.swing.JScrollPane();
        SeleccionarVendedor = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jDialogProductos = new javax.swing.JDialog();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        SeleccionarProductos = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jTextFieldParametroBusqueda = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jDialogCliente = new javax.swing.JDialog();
        jScrollPane4 = new javax.swing.JScrollPane();
        SeleccionarCliente = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        JTableProduct = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldCodigoCliente = new javax.swing.JTextField();
        jTextFieldNombreCliente = new javax.swing.JTextField();
        jTextFieldApellido = new javax.swing.JTextField();
        jTextField_direccion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jTextField_dni = new javax.swing.JTextField();
        jButton_reg_cliente = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldFecha = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldCodProducto = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldValor = new javax.swing.JTextField();
        xcant = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea_descripcion = new javax.swing.JTextArea();
        jLabel24 = new javax.swing.JLabel();
        jTextFieldProductos = new javax.swing.JTextField();
        jTextFieldNo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jTextFieldCant = new javax.swing.JTextField();
        jTextFieldImporte = new javax.swing.JTextField();
        jTextFieldTotals = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jButton_nuevo = new javax.swing.JButton();
        btn_factura = new javax.swing.JButton();
        btn_boleta = new javax.swing.JButton();
        jTextField_son = new javax.swing.JTextField();
        txtusuariocodigoventa = new javax.swing.JTextField();

        jDialogVendedor.setResizable(false);
        jDialogVendedor.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        SeleccionarVendedor.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        SeleccionarVendedor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(SeleccionarVendedor);

        jDialogVendedor.getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 330, 120));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 102, 102));
        jButton1.setText("Seleccionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jDialogVendedor.getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, -1, -1));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Nota-10092-helados_pinkberry_a_un_sol.jpg"))); // NOI18N
        jDialogVendedor.getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(-120, 0, 670, 350));

        jDialogProductos.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 204, 0));
        jLabel16.setText("Productos");
        jDialogProductos.getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));

        jScrollPane2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        SeleccionarProductos.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        SeleccionarProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setViewportView(SeleccionarProductos);

        jDialogProductos.getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 610, 230));

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton7.setForeground(new java.awt.Color(0, 102, 102));
        jButton7.setText("Seleccionar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jDialogProductos.getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 300, -1, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel21.setText("Buscar ");

        jTextFieldParametroBusqueda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldParametroBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldParametroBusquedaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel21)
                    .addGap(12, 12, 12)
                    .addComponent(jTextFieldParametroBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel21)
                        .addComponent(jTextFieldParametroBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jDialogProductos.getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 250, 40));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/59661fb2ef130f6ad73a76da6741addc-size900.jpg"))); // NOI18N
        jDialogProductos.getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 350));

        SeleccionarCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SeleccionarCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(SeleccionarCliente);

        jLabel20.setFont(new java.awt.Font("Sylfaen", 0, 36)); // NOI18N
        jLabel20.setText("Lista de Clientes");

        jButton10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton10.setForeground(new java.awt.Color(0, 51, 51));
        jButton10.setText("Seleccionar");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialogClienteLayout = new javax.swing.GroupLayout(jDialogCliente.getContentPane());
        jDialogCliente.getContentPane().setLayout(jDialogClienteLayout);
        jDialogClienteLayout.setHorizontalGroup(
            jDialogClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogClienteLayout.createSequentialGroup()
                .addGroup(jDialogClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialogClienteLayout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(jButton10))
                    .addGroup(jDialogClienteLayout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(jLabel20)))
                .addContainerGap(159, Short.MAX_VALUE))
            .addGroup(jDialogClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDialogClienteLayout.createSequentialGroup()
                    .addGap(0, 30, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 30, Short.MAX_VALUE)))
        );
        jDialogClienteLayout.setVerticalGroup(
            jDialogClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogClienteLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 190, Short.MAX_VALUE)
                .addComponent(jButton10)
                .addContainerGap())
            .addGroup(jDialogClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDialogClienteLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JTableProduct.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        JTableProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        JTableProduct.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        JTableProduct.setRowHeight(30);
        JTableProduct.setSelectionBackground(new java.awt.Color(153, 153, 153));
        jScrollPane3.setViewportView(JTableProduct);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 580, 200));

        jLabel1.setFont(new java.awt.Font("Constantia", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registro de Venta");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 360, 40));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Datos personales de Cliente o Empresa", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        jLabel3.setText("Nombres/R.S");

        jTextFieldCodigoCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextFieldNombreCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextFieldApellido.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextField_direccion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        jLabel4.setText("Dirección");

        jLabel5.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        jLabel5.setText("Apellidos");

        jLabel6.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        jLabel6.setText("Cod_Cliente");

        jButton3.setText("cliente existente ?");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        jLabel22.setText("DNI/RUC");

        jTextField_dni.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_dni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_dniActionPerformed(evt);
            }
        });
        jTextField_dni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_dniKeyTyped(evt);
            }
        });

        jButton_reg_cliente.setText("Registrar cliente");
        jButton_reg_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_reg_clienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldCodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jTextField_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField_dni, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(jButton_reg_cliente))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jButton3)
                    .addComponent(jButton_reg_cliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel22))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel5)))
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_dni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 660, 140));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 490, 10));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Facturas y Ventas", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 18))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Source Sans Pro", 0, 18)); // NOI18N
        jLabel7.setText("Id-Ventas");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 140, 20));

        jTextFieldFecha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldFechaActionPerformed(evt);
            }
        });
        jPanel3.add(jTextFieldFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 150, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Valor S/.");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, -1, -1));

        jTextFieldCodProducto.setEditable(false);
        jTextFieldCodProducto.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldCodProducto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldCodProducto.setEnabled(false);
        jTextFieldCodProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCodProductoActionPerformed(evt);
            }
        });
        jPanel3.add(jTextFieldCodProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 50, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Cant");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, -1, -1));

        jTextFieldValor.setEditable(false);
        jTextFieldValor.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldValor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel3.add(jTextFieldValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 100, -1));

        xcant.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        xcant.setModel(new javax.swing.SpinnerNumberModel(1, 0, 30, 1));
        xcant.setToolTipText("");
        jPanel3.add(xcant, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, 47, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("COD");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Producto");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, -1, -1));
        jPanel3.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 380, 10));

        jLabel14.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        jLabel14.setText("Descripción");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, -1, 20));

        jButton2.setText("Nuevo Producto");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, -1, -1));

        jButton6.setText("Agregar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, -1, -1));

        jTextArea_descripcion.setColumns(20);
        jTextArea_descripcion.setRows(5);
        jTextArea_descripcion.setEnabled(false);
        jScrollPane5.setViewportView(jTextArea_descripcion);

        jPanel3.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, 190, -1));

        jLabel24.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        jLabel24.setText("Fecha");
        jPanel3.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 50, 20));

        jTextFieldProductos.setEditable(false);
        jTextFieldProductos.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldProductos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldProductos.setEnabled(false);
        jPanel3.add(jTextFieldProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 150, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, 650, 170));
        jPanel3.getAccessibleContext().setAccessibleName("Factura y Venta");

        jTextFieldNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNoActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, 40, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/story-pb_2.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 200, -1));

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 0, 0));
        jButton4.setText("Eliminar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 450, -1, -1));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(204, 0, 0));
        jButton5.setText("Cerrar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 590, -1, -1));

        jTextFieldCant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCantActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldCant, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 410, 40, -1));
        jPanel1.add(jTextFieldImporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 410, 40, -1));

        jTextFieldTotals.setEditable(false);
        jTextFieldTotals.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldTotals.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldTotals.setForeground(new java.awt.Color(0, 102, 0));
        jTextFieldTotals.setText("00.0");
        jTextFieldTotals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTotalsActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldTotals, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 530, 130, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setText("Totals a Pagar S/.");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 500, -1, -1));

        jButton_nuevo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_nuevo.setForeground(new java.awt.Color(204, 0, 0));
        jButton_nuevo.setText("Nuevo");
        jButton_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_nuevoActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 590, -1, -1));

        btn_factura.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_factura.setForeground(new java.awt.Color(0, 51, 51));
        btn_factura.setText("Factura");
        btn_factura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_facturaActionPerformed(evt);
            }
        });
        jPanel1.add(btn_factura, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 580, -1, -1));

        btn_boleta.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_boleta.setForeground(new java.awt.Color(0, 51, 51));
        btn_boleta.setText(" Boleta");
        btn_boleta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_boletaActionPerformed(evt);
            }
        });
        jPanel1.add(btn_boleta, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 580, -1, -1));

        jTextField_son.setEditable(false);
        jTextField_son.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_son.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_son.setEnabled(false);
        jPanel1.add(jTextField_son, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 390, 310, -1));
        jPanel1.add(txtusuariocodigoventa, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 10, 40, -1));

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldCodProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCodProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCodProductoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        llamarProductos();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        //JDIALOG AL SELECCIONAR UN PRODUCTO....BTN SELECCIONAR
        // boton de selecciona productos
        int i = SeleccionarProductos.getSelectedRow();
        if (i == -1) {
            JOptionPane.showMessageDialog(null, "Favor... seleccione una fila");
        } else {
            jTextFieldCodProducto.setText(String.valueOf(SeleccionarProductos.getValueAt(i, 0)));
            jTextFieldProductos.setText(String.valueOf(SeleccionarProductos.getValueAt(i, 1)));
            jTextFieldValor.setText(String.valueOf(SeleccionarProductos.getValueAt(i, 2)));
            jTextArea_descripcion.setText(String.valueOf(SeleccionarProductos.getValueAt(i, 3)));
        }
        jDialogProductos.dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        /*int i = SeleccionarVendedor.getSelectedRow();
        if (i == -1) {
            JOptionPane.showMessageDialog(null, "Favor... seleccione una fila");
        } else//de lo contrario si se selecciono la fila 
        {
            // obtener valor de tabla por columna y enviar datos a texfield
           // jTextFieldCodVendedor.setText(String.valueOf(SeleccionarVendedor.getValueAt(i, 0)));
            //vendedors.setText(String.valueOf(SeleccionarVendedor.getValueAt(i, 1)));
        }
        jDialogVendedor.dispose();
         */
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        //sumar contador
        //BOTON AGREGAR

        if (jTextFieldCodProducto.getText().equals("") || jTextFieldProductos.getText().equals("")
                || jTextFieldValor.getText().equals("")) {

            JOptionPane.showMessageDialog(rootPane, "Primero Seleccione el producto a agregar");
        } else {
            n = 1 + n;
            jTextFieldNo.setText(String.valueOf(n));
            //jTextFieldNo.setVisible(true);
            // leer la cantidad pedidas
            int cant = (Integer) xcant.getValue();
            //problema de obrtener valor de spinner toca dar vuelta
            jTextFieldCant.setText(String.valueOf(cant));
            //jTextFieldCant.setVisible(true);

            float a = Float.valueOf(jTextFieldValor.getText());
            float b = Float.valueOf(jTextFieldCant.getText());
            // Calcular la cantidad por valor
            float importe = (float) ((a * b) * 1.00);
            jTextFieldImporte.setText(String.valueOf(importe));

            //Agregar datos a la tabla        
            String datos[] = new String[7];
            datos[0] = jTextFieldCodProducto.getText();
            datos[1] = jTextFieldCant.getText();
            datos[2] = jTextFieldProductos.getText();
            datos[3] = jTextArea_descripcion.getText();
            datos[4] = jTextFieldValor.getText();
            datos[5] = jTextFieldImporte.getText();
            productos p = new productos(datos[2], a, cant, datos[3]);
            listaProd.add(p);
            modelo.addRow(datos);

            totals = totals + importe;
            jTextFieldTotals.setText(String.valueOf(totals));
            //pasamos el total como con un entero a la funcion y nos convierte en string 
            //luego escribimos el son en string en el jtexfield.settex(son)

            String numero;
            numero = jTextFieldTotals.getText();
            // son=jTextField_son.getText();
            xcant.setValue(1);
            // jTextFieldCant.setText("1"); g
        }

    }//GEN-LAST:event_jButton6ActionPerformed
    private static boolean band() {
        if (Math.random() > .5) {
            return true;
        } else {
            return false;
        }
    }
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:

        // seleccion la fila
        int i = JTableProduct.getSelectedRow();
        if (i == -1) {
            JOptionPane.showMessageDialog(null, "Favor... seleccione una fila");
        } else//de lo contrario si se selecciono la fila 
        {

            System.out.println("valor de seleccion de fila = " + i);

            // coje variable de importe que elimino
            String nums = (String) JTableProduct.getValueAt(i, 5);
            System.out.println("getValueAt(i,5)" + nums); //es el importe
            float entero = Float.valueOf(nums);
            System.out.println("getValueAt(i,5) float" + entero);
            try {
                String producto_nom = (String) JTableProduct.getValueAt(i, 2);
                float precio_unit = (float) JTableProduct.getValueAt(i, 4);

                //deleteLst((String)JTableProduct.getValueAt(i, 2),Integer.parseInt((String)JTableProduct.getValueAt(i, 4)));
            } catch (Exception e) {
                System.out.println("deleteLst error: " + e);
            }
            // cambiarlo de subtotalas que va eliminar 
            // sumar total
            totals = totals - entero;
            jTextFieldTotals.setText(String.valueOf(totals));
            String numero;
            numero = jTextFieldTotals.getText();

            // eliminar fila
            this.modelo.removeRow(i);
            // restar un aticulos
            n = n - 1;
            // poner nuevo ciclo
            int num = 1;
            //      String mm=""+ JTableProduct.getValueAt(i, 1);
            //     int smm = Integer.parseInt(mm);
            for (int w = 0; w < n; w = w + 1) {
                //agregado de nuevo 
                JTableProduct.setValueAt(num, w, 0);
                num = num + 1;
            }

        }
    }//GEN-LAST:event_jButton4ActionPerformed
    void ocultar_columnas() {
        JTableProduct.getColumnModel().getColumn(0).setMaxWidth(0);
        JTableProduct.getColumnModel().getColumn(0).setMinWidth(0);
        JTableProduct.getColumnModel().getColumn(0).setPreferredWidth(0);
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

//        System.out.println("DIA " + fecha.get);
        llamarCliente();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed

        // boton de seleccionado
        int i = SeleccionarCliente.getSelectedRow();
        if (i == -1) {
            JOptionPane.showMessageDialog(null, "Favor... seleccione una fila");
        } else//de lo contrario si se selecciono la fila 
        {
            ClienteExistente = "si";
            // obtener valor de tabla por columna y enviar datos a texfield
            jTextFieldCodigoCliente.setText(String.valueOf(SeleccionarCliente.getValueAt(i, 0)));
            jTextFieldNombreCliente.setText(String.valueOf(SeleccionarCliente.getValueAt(i, 1)));
            jTextFieldApellido.setText(String.valueOf(SeleccionarCliente.getValueAt(i, 2)));
            jTextField_dni.setText(String.valueOf(SeleccionarCliente.getValueAt(i, 3)));
            jTextField_direccion.setText(String.valueOf(SeleccionarCliente.getValueAt(i, 4)));

        }
        jDialogCliente.dispose();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jTextFieldParametroBusquedaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldParametroBusquedaKeyPressed
        // TODO add your handling code here:
        Control_Productos cc = new Control_Productos();
        String parametroBusqueda = jTextFieldParametroBusqueda.getText();
        cc.buscarProductosparaVentas(parametroBusqueda);
        int[] anchos = {35, 300, 50, 100, 40};
        for (int i = 0; i < Ventas.SeleccionarProductos.getColumnCount(); i++) {
            Ventas.SeleccionarProductos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }


    }//GEN-LAST:event_jTextFieldParametroBusquedaKeyPressed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        dispose();
        MenuPrincipal menu = new MenuPrincipal();
        //txtusuarioventa.setText(menu.nombre_usu);
        //txtusuarioventa.setEnabled(false);
        txtusuariocodigoventa.setText(menu.codigo_usu);
        txtusuariocodigoventa.setEnabled(false);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_nuevoActionPerformed
        // TODO add your handling code here:
        dispose();
        Ventas.main(null);

    }//GEN-LAST:event_jButton_nuevoActionPerformed

    private void btn_facturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_facturaActionPerformed
        // TODO add your handling code here:  
        Object[] fila = new Object[6];
        fila[0] = jTextFieldTotals.getText();
        modelo2.addRow(fila);

        Connection reg = conectar.getConexion();

        //PARA DETERMINAR SI ES CLIENTE EXISTENTE O NO
        if (ClienteExistente == "si") {
            JOptionPane.showMessageDialog(null, " Cliente existente");
        } //sino agregado cliente existente entonces lo guarda nuevo cliente
        else {
            // regristar bd a la tabla de cliente
            String nombre = jTextFieldNombreCliente.getText();
            String apellido = jTextFieldApellido.getText();
            String direccion = (jTextField_direccion.getText());
            String ruc = jTextField_dni.getText();

            Control_Cliente add = new Control_Cliente();

        }

        // regristo de BD a la tabla de Facturas
        String sql_Facturas = "INSERT INTO Factura (codCliente,fecha,codempleado,total)VALUES (?,?,?,?)";
        try {
            PreparedStatement pst = reg.prepareStatement(sql_Facturas);
            pst.setString(1, (jTextFieldCodigoCliente.getText()));
            pst.setString(2, jTextFieldFecha.getText());
            pst.setInt(3, Integer.parseInt(arreglo[0]));
            //pst.setInt(3, Integer.parseInt(txtusuariocodigoventa.getText()));
            pst.setString(4, (jTextFieldTotals.getText()));

            if (totals >= 50) {
                totals = (float) (totals - totals * 0.10);
            }

            int ns = pst.executeUpdate();
            if (ns > 0) {
                JOptionPane.showMessageDialog(null, "Regristo Exitoso de Factura ");
            }
        } catch (SQLException ex) {
            System.out.println("Error - " + ex);
            JOptionPane.showMessageDialog(null, "Rellene todos los campos");
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
        }

        //consulta mostrar cargar tabla plan con parametros nombre o dias
        //String[] titulos = {"id", "nombres", "precio", "dias"};
        String[] registro = new String[14];
        int totalregistros = 0;

        try {
            String sSQL = "select NroFactura from Factura";
            Statement st = reg.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("NroFactura");

                nro_factura = (registro[0]);

                totalregistros = totalregistros + 1;
                //  modelo.addRow(registro);

            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.getMessage());

        }

        // regristar bd a la tabla de ventas
        // guardar base de datos a la tabla de ventas
        // se regrista por fila con el ciclo hasta No. de ultimo.
        for (int w = 0; w < n; w = w + 1) {

            //obteniendo valor fila por columna a la ves y w es fila y n es total de articulos comprados
            System.out.println("col1  " + (String) JTableProduct.getValueAt(w, 0));
            System.out.println("col2  " + (String) JTableProduct.getValueAt(w, 1));
            System.out.println("col3  " + (String) JTableProduct.getValueAt(w, 5));
            //System.out.println("col4  " + (String) JTableProduct.getValueAt(w, 9));
            String col1 = "" + JTableProduct.getValueAt(w, 0);// valor de codigo ventas

            String col2 = (String) JTableProduct.getValueAt(w, 1);// valor de codigo productos
            //suma=(String) JTableProduct.getValueAt(w, 3);
            //String col3 = (String) JTableProduct.getValueAt(w, 4);// valor de cantidad productos
            String col3 = (String) JTableProduct.getValueAt(w, 5);// valor de importe

            String sql_Ventas = "INSERT INTO detalleFactura (NroFactura,codProducto,cantidad,precio)VALUES (?,?,?,?)";
            try {
                PreparedStatement pst = reg.prepareStatement(sql_Ventas);
                pst.setString(1, nro_factura);
                pst.setString(2, col1);
                pst.setString(3, col2);
                pst.setString(4, col3);
                int ns = pst.executeUpdate();
                if (ns > 0) {
                    System.out.println("Registro exitoso del detalle de la factura " + col1);

                }

            } catch (SQLException ex) {
                System.out.println("Error al procesar el registro de factura.dao " + ex);
                JOptionPane.showMessageDialog(null, "Porfavor rellene todos los campos");
                Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
            }
            //buscar cantidad actual de los prodcutos
            Connection conexion = null;
            Statement sentencia = null;
            ResultSet resultado = null;
            PreparedStatement ps = null;
            int cantidad_nueva = 0;
            try {
                conexion = ConexionConBaseDatos.getConexion();

                sentencia = conexion.createStatement();
                String consultaSQL = "SELECT * FROM table_Productos WHERE codP=" + col1;
                resultado = sentencia.executeQuery(consultaSQL);

                while (resultado.next()) {
                    cantidad_nueva = resultado.getInt("cantidadP") - Integer.parseInt(col2);
                }

            } catch (SQLException e) {
                System.out.println("error al obtener la cantidad del producto");
                JOptionPane.showMessageDialog(null, "Error SQL:\n" + e);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
                conexion = null;
            } finally {
                CerrarConexiones.metodoCerrarConexiones(conexion, sentencia, resultado, ps);
            }
            //actualizar stock del producto

            try {
                conexion = ConexionConBaseDatos.getConexion();
                Statement comando = conexion.createStatement();

                // linea de codigo de mysql que actualiza regristos que va modificar
                int cantidad = comando.executeUpdate("update table_Productos set cantidadP =" + cantidad_nueva + "" + " where codP=" + col1);
                if (cantidad == 1) {
                    System.out.println("Modifico con Exito");

                } else {
                    JOptionPane.showMessageDialog(null, "No existe  de un codigo " + col1);
                }
                conexion.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, " Error -->" + ex);
            }

        }

        // cierra de ventas
        float subtotal, igv;
        igv = (18 * totals) / 100;
        subtotal = totals - igv;

        if (jTextFieldCodigoCliente.getText().length() == 0 || jTextFieldCodProducto.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "No se Registro la Factura");
        } else {
            grabarpdfFactura pdf = new grabarpdfFactura(listaProd, jTextFieldNombreCliente.getText() + " " + jTextFieldApellido.getText(), jTextField_dni.getText(), jTextField_direccion.getText(), totals, nro_factura);
            pdf.grabarPdf();
        }

        dispose();
        Ventas.main(null);
    }//GEN-LAST:event_btn_facturaActionPerformed

    private void btn_boletaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_boletaActionPerformed
        // TODO add your handling code here:

        Object[] fila = new Object[6];

        fila[0] = jTextFieldTotals.getText();
        modelo2.addRow(fila);

        Connection reg = conectar.getConexion();

        //PARA DETERMINAR SI ES CLIENTE EXISTENTE O NO
        if (ClienteExistente == "si") {
            JOptionPane.showMessageDialog(null, " Cliente Si existe");
        } //sino agregado cliente existente entonces lo guarda nuevo cliente
        else {
            // regristar bd a la tabla de cliente
            // obtener datos         

            String nombre = jTextFieldNombreCliente.getText();
            String apellido = jTextFieldApellido.getText();
            String direccion = (jTextField_direccion.getText());
            String dni = (jTextField_dni.getText());

            //String razon_social=jTextField_razon_social.getText();
            //String ruc=jTextField_razon_social.getText();
            Control_Cliente add = new Control_Cliente();
            // enviar datos a regristar en el control_cliente

            //       add.agregarCliente( nombre, apellido, direccion,razon_social,ruc);
        }

        // regristo de BD a la tabla de Facturas
        try {
            String sql_Boletas = "INSERT INTO Boleta (codCliente,fecha,codusuario,total)VALUES (?,?,?,?)";
            PreparedStatement pst = reg.prepareStatement(sql_Boletas);

            fusuario udao = new fusuario();
            //usuarioVendedor = udao.getIdUsuario(nro_boleta, sql_Boletas);
            //pst.setString(1, (jTextField_codfacturacion.getText()));
            // pst.setString(1, (""));
            pst.setString(1, (jTextFieldCodigoCliente.getText()));
            pst.setString(2, jTextFieldFecha.getText());
            pst.setInt(3, Integer.parseInt(arreglo[0]));
            //pst.setInt(3, Integer.parseInt(txtusuariocodigoventa.getText()));
            pst.setString(4, (jTextFieldTotals.getText()));

            int ns = pst.executeUpdate();

            if (ns > 0) {
                JOptionPane.showMessageDialog(null, "Regristado Exitosamente de Boleta ");
            } else {
                JOptionPane.showMessageDialog(null, "Regristado FALLIDO de Boleta ");
            }

        } catch (SQLException ex) {
            System.out.println("eror en guardar la venta en BOLETA");
            JOptionPane.showMessageDialog(null, "Error - Rellene todos los campos");
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
        }

        //
//consulta mostrar cargar tabla plan con parametros nombre o dias
        //String[] titulos = {"id", "nombres", "precio", "dias"};
        String[] registro = new String[14];

        int totalregistros = 0;
        //     modelo = new DefaultTableModel(null, titulos);
        /*String sSQL = "";
        sSQL = "select NroBoleta from Boleta where NroBoleta = (SELECT MAX(NroBoleta) from Boleta)";*/
        String sSQL = "select NroBoleta from Boleta";

        try {
            Statement st = reg.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("NroBoleta");
                nro_boleta = (registro[0]);
                totalregistros = totalregistros + 1;
                //  modelo.addRow(registro);
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            //  return null;

        }

        //
        // regristar bd a la tabla de ventas
        // guardar base de datos a la tabla de ventas
        // se regrista por fila con el ciclo hasta No. de ultimo.
        for (int w = 0; w < n; w++) {

            String col1 = "" + JTableProduct.getValueAt(w, 0);// valor de codigo ventas

            String col2 = (String) JTableProduct.getValueAt(w, 1);// valor de codigo productos
            //           suma=(String) JTableProduct.getValueAt(w, 3);
            //     String col3 = (String) JTableProduct.getValueAt(w, 4);// valor de cantidad productos
            String col3 = (String) JTableProduct.getValueAt(w, 5);// valor de importe

            String sql_Ventas = "INSERT INTO detalleBoleta (NroBoleta,codProducto,cantidad,precio)VALUES (?,?,?,?)";
            try {
                PreparedStatement pst = reg.prepareStatement(sql_Ventas);
                //pst.setString(1, nro_boleta);
                pst.setString(1, nro_boleta);
                pst.setInt(2, Integer.parseInt(col1));
                pst.setInt(3, Integer.parseInt(col2));
                pst.setFloat(4, Float.parseFloat(col3));
                int ns = pst.executeUpdate();
                if (ns > 0) {
                    System.out.println("Regristado Exitosamente de Ventas " + col1);

                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error - " + ex);
                Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
            }
            //buscar cantidad actual de los prodcutos
            Connection conexion = null;
            Statement sentencia = null;
            ResultSet resultado = null;
            PreparedStatement ps = null;
            int cantidad_nueva = 0;
            try {
                conexion = ConexionConBaseDatos.getConexion();

                sentencia = conexion.createStatement();
                String consultaSQL = "SELECT * FROM table_Productos WHERE codP=" + col1;
                resultado = sentencia.executeQuery(consultaSQL);

                //mientras haya datos en la BD ejecutar eso...
                while (resultado.next()) {

                    cantidad_nueva = resultado.getInt("cantidadP") - Integer.parseInt(col2);

                }//cierra while (porque no hay mas datos en la BD)

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error SQL:\n" + e);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
                conexion = null;
            } finally {
                CerrarConexiones.metodoCerrarConexiones(conexion, sentencia, resultado, ps);
            }
            //actualizar stop del producto

            try {
                conexion = ConexionConBaseDatos.getConexion();
                Statement comando = conexion.createStatement();

                // linea de codigo de mysql que actualiza regristos que va modificar
                int cantidad = comando.executeUpdate("update table_Productos set cantidadP =" + cantidad_nueva + "" + " where codP=" + col1);
                if (cantidad == 1) {
                    System.out.println("Modifico con Exito");

                } else {
                    JOptionPane.showMessageDialog(null, "No existe  de un codigo " + col1);
                }
                conexion.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, " Error -->" + ex);
            }

        }
        // cierra de ventas

        // y ahora genera facturas guardada en la carpeta Facturas
        Image portada;

        // CREA DOCUMENTOS CON TAMAÑO CARTAS Y MARGENE DE TODO LADO DE 50   
        //Document document = new Document(PageSize.LETTER, 50, 50, 50, 50);
        if (jTextFieldCodigoCliente.getText().length() == 0 || jTextFieldCodProducto.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "No se Registro la Boleta");
        } else {

            grabarpdfBoleta pdf = new grabarpdfBoleta(listaProd, jTextFieldNombreCliente.getText() + " " + jTextFieldApellido.getText(), jTextField_dni.getText(), jTextField_direccion.getText(), totals, nro_boleta);
            pdf.grabarPdf();
        }
        dispose();
        Ventas.main(null);
    }//GEN-LAST:event_btn_boletaActionPerformed

    private void jButton_reg_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_reg_clienteActionPerformed
        // TODO add your handling code here:
        dispose();
        addCliente.main(null);
        addCliente.ventas = "ventas";
    }//GEN-LAST:event_jButton_reg_clienteActionPerformed

    private void jTextField_dniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_dniKeyTyped
        // TODO add your handling code here:
        if (jTextField_dni.getText().length() >= 11) {
            String dni = "";
            dni = jTextField_dni.getText();
            jTextField_dni.setText(dni.substring(0, dni.length() - 1));
        }
        char c = evt.getKeyChar();
//             String ruc=jTextField_rucKeyTyped(evt);.getText();

        if (Character.isLetter(c)) {

            getToolkit().beep();

            evt.consume();
        }
    }//GEN-LAST:event_jTextField_dniKeyTyped

    private void jTextFieldCantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCantActionPerformed

    private void jTextFieldNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNoActionPerformed

    private void jTextFieldTotalsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTotalsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTotalsActionPerformed

    private void jTextField_dniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_dniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_dniActionPerformed

    private void jTextFieldFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFechaActionPerformed

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
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Ventas dialog = new Ventas(new javax.swing.JFrame(), true);
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

    private productos buscar(String nom, int cantidad) {
        for (productos obj : listaProd) {
            if (nom.equalsIgnoreCase(obj.getNombre()) && cantidad == obj.getCantidad()) {
                return obj;
            }
        }
        return null;
    }

    private void deleteLst(String nom, int cantidad) {//borrar fila
        listaProd.remove(buscar(nom, cantidad));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTable JTableProduct;
    public static javax.swing.JTable SeleccionarCliente;
    public static javax.swing.JTable SeleccionarProductos;
    public static javax.swing.JTable SeleccionarVendedor;
    private javax.swing.JButton btn_boleta;
    private javax.swing.JButton btn_factura;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton_nuevo;
    private javax.swing.JButton jButton_reg_cliente;
    private javax.swing.JDialog jDialogCliente;
    private javax.swing.JDialog jDialogProductos;
    private javax.swing.JDialog jDialogVendedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea jTextArea_descripcion;
    private javax.swing.JTextField jTextFieldApellido;
    private javax.swing.JTextField jTextFieldCant;
    private javax.swing.JTextField jTextFieldCodProducto;
    private javax.swing.JTextField jTextFieldCodigoCliente;
    private javax.swing.JTextField jTextFieldFecha;
    private javax.swing.JTextField jTextFieldImporte;
    private javax.swing.JTextField jTextFieldNo;
    private javax.swing.JTextField jTextFieldNombreCliente;
    private javax.swing.JTextField jTextFieldParametroBusqueda;
    private javax.swing.JTextField jTextFieldProductos;
    private javax.swing.JTextField jTextFieldTotals;
    private javax.swing.JTextField jTextFieldValor;
    private javax.swing.JTextField jTextField_direccion;
    private javax.swing.JTextField jTextField_dni;
    private javax.swing.JTextField jTextField_son;
    public static javax.swing.JTextField txtusuariocodigoventa;
    private javax.swing.JSpinner xcant;
    // End of variables declaration//GEN-END:variables
}
