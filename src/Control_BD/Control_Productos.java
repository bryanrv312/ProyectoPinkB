package Control_BD;

import BD_Productos.ConsultarProductos;
import BD_Productos.EliminarProductos;
import BD_Productos.ModificarProductos;
import principal.Ventas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * En esta clase se exponen todos los métodos para ejercer control sobre los
 * datos que van desde y hacia la tabla clientes. En esta clase se hace la
 * validación y organizacion de los datos.
 *
 * @author Sergio
 */
public class Control_Productos {

    //modelo para la tabla
    DefaultTableModel modelo;
    private String sSQL = "";
    //vector con los titulos de cada columna
    String[] titulosColumnas = {"CODIGO", "NOMBRE", " PRECIO VENTA", "DESCRIPCION", "CANTIDAD", "PRECIO COMPRA"};
    //matriz donde se almacena los datos de cada celda de la tabla
    String info[][] = {};

    public void agregarProductos(String cedula, String nombre, String apellido, String direccion, String telefono) {

    }

    public void CargarProductos() {

        modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        //le asigna el modelo al jtable
        Ventas.SeleccionarProductos.setModel(modelo);

        //ejecuta una consulta a la BD
        ejecutarConsultaTodaTabla();

        /*              int[] anchos = {35, 300, 40, 200, 40};
        for (int i = 0; i < Ventas.SeleccionarProductos.getColumnCount(); i++) {
            Ventas.SeleccionarProductos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);}
         */
    }

    public void CargarProductosVentas() {

        modelo = new DefaultTableModel(info, titulosColumnas) {

            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        //le asigna el modelo al jtable
        Ventas.SeleccionarProductos.setModel(modelo);

        //ejecuta una consulta a la BD
        ejecutarConsultaTodaTablaventas();

        /*              int[] anchos = {35, 300, 40, 200, 40};
        for (int i = 0; i < Ventas.SeleccionarProductos.getColumnCount(); i++) {
            Ventas.SeleccionarProductos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);}
         */
    }

    public void CargarProductosGuiaReimsion() {

        modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        //le asigna el modelo al jtable

        //ejecuta una consulta a la BD
        ejecutarConsultaTodaTablaventas();

        /*              int[] anchos = {35, 300, 40, 200, 40};
        for (int i = 0; i < Ventas.SeleccionarProductos.getColumnCount(); i++) {
            Ventas.SeleccionarProductos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);}
         */
    }

    public void CargarProductos2() {

        modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        //le asigna el modelo al jtable
        ModificarProductos.jTable_productos.setModel(modelo);

        //ejecuta una consulta a la BD
        ejecutarConsultaTodaTabla();

    }

    public void CargarProductos_eliminar() {

        modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        //le asigna el modelo al jtable
        EliminarProductos.jTable_productos.setModel(modelo);

        //ejecuta una consulta a la BD
        ejecutarConsultaTodaTabla();

    }

    public DefaultTableModel mostrar_inicial() {
        //cargar tabla plan sin parametros
        // conexion = ConexionConBaseDatos.getConexion();

        int totalregistros;
        //   DefaultTableModel modelo1;

        String[] titulos = {"codigo", "nombres", "precio", "dias"};

        String[] registro = new String[14];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "SELECT codP,nombreP,precioP,descripcionP,cantidadP,preciocompraP FROM table_Productos ORDER BY codP ASC";

        try {
            conexion = ConexionConBaseDatos.getConexion();

//              conexion = DriverManager.getConnection("jdbc:mysql://localhost/Ultimate_FerreteriaAndres", "root", "");
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {

                registro[0] = resultado.getString("codP");
                registro[1] = resultado.getString("nombreP");
                registro[2] = resultado.getString("precioP");
                registro[3] = resultado.getString("descripcionP");
                registro[4] = resultado.getString("cantidadP");
                registro[5] = resultado.getString("preciocompraP");
                //crea un vector donde los está la informacion (se crea una fila)
                // Object[] info = {codigo, nombre, precioventa,descripcion,cantidad,preciocompra};

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    /**
     * Metodo para listar todos los registros de la tabla de clientes, los
     * muestra en un jtable.
     */
    public void listarTodosProductos_por_agotar() {

        modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        ConsultarProductos.jTableListarCliente.setModel(modelo);
        ejecutarConsultaTodaTabla_por_agotar();

    }

    public void listarTodosProductos() {

        modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        //le asigna el modelo al jtable
        ConsultarProductos.jTableListarCliente.setModel(modelo);

        //ejecuta una consulta a la BD
        ejecutarConsultaTodaTabla();

    }//cierra metodo listarTodosClientes

    /**
     * Metodo para consultar todos los regsitros de la base de datos de clientes
     * y luego ser mostrados en una tabla.
     */
    Connection conexion = null;
    Statement sentencia = null;
    ResultSet resultado = null;
    PreparedStatement ps = null;

    public void ejecutarConsultaTodaTabla_por_agotar() {
        try {
            conexion = ConexionConBaseDatos.getConexion();
            sentencia = conexion.createStatement();
            String consultaSQL = "select * from table_Productos where cantidadP <= 4";
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(consultaSQL);

            while (rs.next()) {
                String codigo = rs.getString("codP");
                String nombre = rs.getString("nombreP");
                String precioventa = rs.getString("precioP");
                String descripcion = rs.getString("descripcionP");
                String cantidad = rs.getString("cantidadP");
                String preciocompraProductos = rs.getString("preciocompraP");

                Object[] info = {codigo, nombre, precioventa, descripcion, cantidad, preciocompraProductos};
                modelo.addRow(info);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error SQL:\n" + e);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            conexion = null;
        } finally {
            CerrarConexiones.metodoCerrarConexiones(conexion, sentencia, resultado, ps);
        }
    }

    public void ejecutarConsultaTodaTablaventas() {

        try {
            conexion = ConexionConBaseDatos.getConexion();

            sentencia = conexion.createStatement();
            String consultaSQL = "SELECT * FROM table_Productos WHERE cantidadP>0 ORDER BY codP ASC ";
            resultado = sentencia.executeQuery(consultaSQL);

            //mientras haya datos en la BD ejecutar eso...
            while (resultado.next()) {

                String codigo = resultado.getString("codP");
                String nombre = resultado.getString("nombreP");
                String precioventa = resultado.getString("precioP");
                String descripcion = resultado.getString("descripcionP");
                String cantidad = resultado.getString("cantidadP");
                String preciocompraProductos = resultado.getString("preciocompraP");

                //crea un vector donde los está la informacion (se crea una fila)
                Object[] info = {codigo, nombre, precioventa, descripcion, cantidad, preciocompraProductos};

                //al modelo de la tabla le agrega una fila
                //con los datos que están en info
                modelo.addRow(info);

            }//cierra while (porque no hay mas datos en la BD)

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error SQL:\n" + e);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            conexion = null;
        } finally {
            CerrarConexiones.metodoCerrarConexiones(conexion, sentencia, resultado, ps);
        }

    }//cierra metodo ejecutarConsulta

    public void ejecutarConsultaTodaTabla() {

        try {
            conexion = ConexionConBaseDatos.getConexion();

            sentencia = conexion.createStatement();
            String consultaSQL = "SELECT * FROM table_Productos ORDER BY codP ASC";
            resultado = sentencia.executeQuery(consultaSQL);

            //mientras haya datos en la BD ejecutar eso...
            while (resultado.next()) {

                String codigo = resultado.getString("codP");
                String nombre = resultado.getString("nombreP");
                String precioventa = resultado.getString("precioP");
                String descripcion = resultado.getString("descripcionP");
                String cantidad = resultado.getString("cantidadP");
                String preciocompraProductos = resultado.getString("preciocompraP");

                //crea un vector donde los está la informacion (se crea una fila)
                Object[] info = {codigo, nombre, precioventa, descripcion, cantidad, preciocompraProductos};

                //al modelo de la tabla le agrega una fila
                //con los datos que están en info
                modelo.addRow(info);

            }//cierra while (porque no hay mas datos en la BD)

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error SQL:\n" + e);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            conexion = null;
        } finally {
            CerrarConexiones.metodoCerrarConexiones(conexion, sentencia, resultado, ps);
        }

    }//cierra metodo ejecutarConsulta

    public void buscarProductos(String parametroBusqueda) {

        modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        ;
        ConsultarProductos.jTableListarCliente.setModel(modelo);
        buscarRegistroProductos(parametroBusqueda);

    }

//    
    public void buscarRegistroProductos(String parametroBusqueda) {

        try {

            conexion = ConexionConBaseDatos.getConexion();
            String selectSQL;
            resultado = null;

            selectSQL = "SELECT * FROM table_Productos WHERE nombreP LIKE ? ORDER BY codP ASC";
            ps = conexion.prepareStatement(selectSQL);
            ps.setString(1, "%" + parametroBusqueda + "%");

            resultado = ps.executeQuery();

            while (resultado.next()) {
                String codigo = resultado.getString("codP");
                String nombre = resultado.getString("nombreP");
                String precioventa = resultado.getString("precioP");
                String descripcion = resultado.getString("descripcionP");
                String cantidad = resultado.getString("cantidadP");
                String preciocompra = resultado.getString("preciocompraP");

                Object[] info = {codigo, nombre, precioventa, descripcion, cantidad, preciocompra};

                modelo.addRow(info);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error\n Por la Causa" + e);
        } finally {
            CerrarConexiones.metodoCerrarConexiones(conexion, sentencia, resultado, ps);
        }

    }//cierra metodo buscarRegistro
    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    /**
     * Método para validar la entrada del usuario que ingresa para eliminar un
     * cliente
     */
    public void EliminarProductos(String code) {

        try {
            conexion = ConexionConBaseDatos.getConexion();
            Statement comando = conexion.createStatement();
            int cantidad = comando.executeUpdate("delete from table_Productos where codP=" + code);
            if (cantidad == 1) {

                JOptionPane.showMessageDialog(null, "Producto Eliminado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No existe Producto de Codigo " + code);
            }
            conexion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error " + ex);
        }

    }//cierra metodo eliminarCliente

    /**
     * Método para validar y modificar la información de un cliente.
     */
    public void ModificarProductos(String code, String nombre, float precios, String descripcion,
            int cantidad_productos, float preciocompra, float dif) {

        try {
            conexion = ConexionConBaseDatos.getConexion();
            Statement comando = conexion.createStatement();

            // linea de codigo de mysql que actualiza regristos que va modificar
            int cantidad = comando.executeUpdate("update table_Productos set nombreP ='" + nombre + "', "
                    + " precioP ='" + precios + "' " + ", descripcionP ='" + descripcion + "'" + ", cantidadP ='" + cantidad_productos + "'" + " , preciocompraP ='" + preciocompra + "' , diferencia =" + dif + "  where codP=" + code);
            if (cantidad == 1) {
                JOptionPane.showMessageDialog(null, " Modifico con Exito");
            } else {
                JOptionPane.showMessageDialog(null, "No existe Vendedor de un codigo " + code);
            }
            conexion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error -->" + ex);
        }
    }//cierra metodo modificarCliente

    //es para buscar productos de compras en ventas- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public void buscarProductosparaGuia(String parametroBusqueda) {

        modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        ;
        //le asigna el modelo al jtable
        //ejecuta una consulta a la BD
        buscarRegistroProductoss(parametroBusqueda);

    }

    public void buscarProductosparaVentas(String parametroBusqueda) {

        modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        ;
        //le asigna el modelo al jtable
        Ventas.SeleccionarProductos.setModel(modelo);
        //ejecuta una consulta a la BD
        buscarRegistroProductoss(parametroBusqueda);

    }

    public void buscarProductosparaProductos(String parametroBusqueda) {

        modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        ;
        //le asigna el modelo al jtable
        ModificarProductos.jTable_productos.setModel(modelo);
        //ejecuta una consulta a la BD
        buscarRegistroProductoss(parametroBusqueda);

    }

    public void buscarProductosparaEliminarProductos(String parametroBusqueda) {

        modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        ;
        //le asigna el modelo al jtable
        EliminarProductos.jTable_productos.setModel(modelo);
        //ejecuta una consulta a la BD
        buscarRegistroProductoss(parametroBusqueda);

    }

    public void buscarRegistroProductoss(String parametroBusqueda) {

        try {

            conexion = ConexionConBaseDatos.getConexion();
            String selectSQL;
            resultado = null;
                         
            selectSQL = "SELECT * FROM table_Productos WHERE nombreP LIKE ? AND cantidadP>0 ORDER BY codP ASC";
            ps = conexion.prepareStatement(selectSQL);
            ps.setString(1, "%" + parametroBusqueda + "%");

            resultado = ps.executeQuery();

            while (resultado.next()) {
                String codigo = resultado.getString("codP");
                String nombre = resultado.getString("nombreP");
                String precioventa = resultado.getString("precioP");
                String descripcion = resultado.getString("descripcionP");
                String cantidad = resultado.getString("cantidadP");
                String preciocompra = resultado.getString("preciocompraP");
                //crea un vector donde los está la informacion (se crea una fila)
                Object[] info = {codigo, nombre, precioventa, descripcion, cantidad, preciocompra};
                //al modelo de la tabla le agrega una fila
                //con los datos que están en info
                modelo.addRow(info);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error\n Por la Causa" + e);
        } finally {
            CerrarConexiones.metodoCerrarConexiones(conexion, sentencia, resultado, ps);
        }

    }

}//cierra class
