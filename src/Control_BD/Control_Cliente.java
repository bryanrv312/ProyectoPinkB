package Control_BD;

import BD_Cliente.EliminarCliente;
import BD_Cliente.ListarCliente;
import BD_Cliente.ModificarCliente;
import BD_Cliente.addCliente;
import principal.Ventas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * En esta clase se exponen todos los métodos para ejercer control sobre los
 * datos que van desde y hacia la tabla clientes. En esta clase se hace la
 * validación y organizacion de los datos.
 *
 * @author Richard
 */


public class Control_Cliente {

    //modelo para la tabla
    DefaultTableModel modelo;
    //vector con los titulos de cada columna
    String[] titulosColumnas = {"CÓDIGO", "NOMBRES", "APELLIDOS", "DNI", "DIRECCIÓN", "TELÉFONO", "CORREO"};
    //matriz donde se almacena los datos de cada celda de la tabla
    String info[][] = {};
    // Conectar Base de Datos
    Connection conectar = ConexionConBaseDatos.getConexion();
    
    

     public void agregarCliente(/*String codigo,*/String nombre, String apellido, String dni, String direccion,String telefono,String correo) {

         Connection reg = ConexionConBaseDatos.getConexion();
        
         String sql = "INSERT INTO table_Cliente (nombres, apellidos , dni , direccion , telefono , correo)VALUES (?,?,?,?,?,?)";
            try {
            
            PreparedStatement pst= reg.prepareStatement(sql);
            //pst.setString(1,codigo);
            pst.setString(1,nombre);
            pst.setString(2,apellido);
            pst.setString(3,dni);
            pst.setString(4, direccion);
            pst.setString(5, telefono);
            pst.setString(6, correo);
            int n = pst.executeUpdate();
            if (n>0){
                JOptionPane.showMessageDialog(null,"Cliente Registrado Exitosamente!!!");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error - "+ex);
            Logger.getLogger(addCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//cierra metodo agregarCliente

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    /**
     * Metodo para listar todos los registros de la tabla
     * de clientes, los muestra en un jtable.
     */
    public void listarTodosClientes() {

        modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
      //le asigna el modelo al jtable
        ListarCliente.jTableListarCliente.setModel(modelo);

        //ejecuta una consulta a la BD
        ejecutarConsultaTodaTabla();

    }//cierra metodo listarTodosClientes
        public void CargarModificarClientes() {

        modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
      //le asigna el modelo al jtable
            ModificarCliente.jTable_clientes.setModel(modelo);

        //ejecuta una consulta a la BD
        ejecutarConsultaTodaTabla();

    }    
        public void CargarEliminarClientes() {

        modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
      //le asigna el modelo al jtable
                  EliminarCliente.jTable_clientes.setModel(modelo);

        //ejecuta una consulta a la BD
        ejecutarConsultaTodaTabla();

    } 
        public void CargarClientes() {

        modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
      //le asigna el modelo al jtable

        //ejecuta una consulta a la BD
        ejecutarConsultaTodaTabla();

    }//cierra metodo cargarTodosClientes
    public void CargarClientesVentas() {

        modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
      //le asigna el modelo al jtable
            Ventas.SeleccionarCliente.setModel(modelo);

        //ejecuta una consulta a la BD
        ejecutarConsultaTodaTabla();

    }//cierra metodo cargarTodosClientes
     /**
     * Metodo para consultar todos los regsitros de la base de datos de clientes
     * y luego ser mostrados en una tabla.
     */
    Connection conexion = null;
    Statement sentencia = null;
    ResultSet resultado = null;
    PreparedStatement ps = null;

    public void ejecutarConsultaTodaTabla() {

        try {
            conexion = ConexionConBaseDatos.getConexion();

            sentencia = conexion.createStatement();
            String consultaSQL = "SELECT * FROM table_cliente ORDER BY nombres ASC";
            resultado = sentencia.executeQuery(consultaSQL);


            //mientras haya datos en la BD ejecutar eso...
            while (resultado.next()) {


                String codigo = resultado.getString("codCliente");
                String nombre = resultado.getString("Nombres");
                String apellido = resultado.getString("Apellidos");
                String dni = resultado.getString("dni");
                String direccion = resultado.getString("direccion");
                String telefono = resultado.getString("telefono");
                String correo = resultado.getString("correo");
                //crea un vector donde los está la informacion (se crea una fila)
                Object[] info = {codigo, nombre, apellido,dni,direccion,telefono,correo };

                //al modelo de la tabla le agrega una fila
                //con los datos que están en info
                modelo.addRow(info);

            }//cierra while (porque no hay mas datos en la BD)


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error SQL:\n" + e);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
            conexion = null;
        } finally {
            CerrarConexiones.metodoCerrarConexiones(conexion, sentencia, resultado, ps);
        }

    }//cierra metodo ejecutarConsulta
    
  
    public void buscarCliente(String parametroBusqueda, boolean buscarPorCedula, boolean buscarPorNombre, boolean buscarPorApellido) {

        

            modelo = new DefaultTableModel(info, titulosColumnas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            ;

            //le asigna el modelo al jtable
            ListarCliente.jTableListarCliente.setModel(modelo);
            //ejecuta una consulta a la BD
            buscarRegistroCedulaONombreOapellido(parametroBusqueda, buscarPorCedula, buscarPorNombre, buscarPorApellido);

        

    }//cierra metodo buscarCliente
    public void buscarListaCliente(String parametroBusqueda) {
            modelo = new DefaultTableModel(info, titulosColumnas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            ;
            //le asigna el modelo al jtable
            ListarCliente.jTableListarCliente.setModel(modelo);
            //ejecuta una consulta a la BD
            buscarRegistrodniOnombreOapellido(parametroBusqueda);

        

    }//cierra metodo buscarCliente  
    public void buscarModificarCliente(String parametroBusqueda) {
            modelo = new DefaultTableModel(info, titulosColumnas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            ;
            //le asigna el modelo al jtable
            ModificarCliente.jTable_clientes.setModel(modelo);
            //ejecuta una consulta a la BD
            buscarRegistrodniOnombreOapellido(parametroBusqueda);
    }//cierra metodo buscarCliente    
    public void buscarEliminarCliente(String parametroBusqueda) {
            modelo = new DefaultTableModel(info, titulosColumnas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            //le asigna el modelo al jtable
            EliminarCliente.jTable_clientes.setModel(modelo);
            //ejecuta una consulta a la BD
            buscarRegistrodniOnombreOapellido(parametroBusqueda);
    }//cierra metodo buscarCliente
    /**
     * Método para buscar un registro en la base de datos dentro de la tabla
     * clientes, se puede buscar por la cedula o por el nombre.
     */
        public void buscarRegistrodniOnombreOapellido(String parametroBusqueda) {
        try {
            conexion = ConexionConBaseDatos.getConexion();
          
            String selectSQL;
            resultado = null;

                selectSQL = "SELECT * FROM table_Cliente WHERE  codCliente LIKE ? or  apellidos LIKE ? or  dni LIKE ? ORDER BY codCliente ASC";
                
                ps = conexion.prepareStatement(selectSQL);
                ps.setString(1, "%" + parametroBusqueda + "%");
                ps.setString(2, "%" + parametroBusqueda + "%");
                ps.setString(3, "%" + parametroBusqueda + "%");
            resultado = ps.executeQuery();

            while (resultado.next()) {
           
                String codigo = resultado.getString("codCliente");
                String nombre = resultado.getString("Nombres");
                String apellido = resultado.getString("Apellidos");
                String dni = resultado.getString("dni");
                String direccion = resultado.getString("direccion");
                String telefono = resultado.getString("telefono");
                String correo = resultado.getString("correo");
                //crea un vector donde los está la informacion (se crea una fila)
                Object[] info = {codigo, nombre, apellido,dni,direccion,telefono,correo };               

             
                //al modelo de la tabla le agrega una fila
                //con los datos que están en info
                modelo.addRow(info);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error\n Por la Causa" + e);
        } finally {
            CerrarConexiones.metodoCerrarConexiones(conexion, sentencia, resultado, ps);
        }


    }//cierra metodo buscarRegistro
    public void buscarRegistroCedulaONombreOapellido(String parametroBusqueda, boolean buscarPorcodigo, boolean buscarPorNombre, boolean buscarPorApellido) {
        try {

            conexion = ConexionConBaseDatos.getConexion();
            String selectSQL;
            resultado = null;
       
             if(buscarPorNombre== true){
                selectSQL = "SELECT * FROM table_Cliente WHERE nombres LIKE ? ORDER BY codCliente ASC";
                ps = conexion.prepareStatement(selectSQL);
                ps.setString(1, "%" + parametroBusqueda + "%");
            }
            else if(buscarPorApellido== true){

                selectSQL = "SELECT * FROM table_Cliente WHERE apellidos LIKE ? ORDER BY codCliente ASC";
                ps = conexion.prepareStatement(selectSQL);
                ps.setString(1, "%" + parametroBusqueda + "%");
            }
            else if(buscarPorcodigo==true){
                selectSQL = "SELECT * FROM table_Cliente WHERE codCliente LIKE ? ORDER BY nombres ASC";
                ps = conexion.prepareStatement(selectSQL);
                ps.setString(1, "%" + parametroBusqueda + "%");
            }
            resultado = ps.executeQuery();
            while (resultado.next()) {
                String codigo = resultado.getString("codCliente");
                String nombre = resultado.getString("Nombres");
                String apellido = resultado.getString("Apellidos");
                String dni = resultado.getString("dni");
                String direccion = resultado.getString("direccion");
                String telefono = resultado.getString("telefono");
                String correo = resultado.getString("correo");
                //crea un vector donde los está la informacion (se crea una fila)
                Object[] info = {codigo, nombre, apellido,dni,direccion,telefono,correo };
                //al modelo de la tabla le agrega una fila
                //con los datos que están en info
                modelo.addRow(info);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error\n Por la Causa" + e);
        } finally {
            CerrarConexiones.metodoCerrarConexiones(conexion, sentencia, resultado, ps);
        }


    }//cierra metodo buscarRegistro
    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    
    /**
     * Método para validar la entrada del usuario
     * que ingresa para eliminar un cliente
     */
    public void EliminarCliente(String code) {

        try {            
            Connection conexion = ConexionConBaseDatos.getConexion();
            Statement comando = conexion.createStatement();
            int cantidad = comando.executeUpdate("delete from table_Cliente where codCliente="+code);
            if (cantidad == 1) {
   
                JOptionPane.showMessageDialog(null,"Eliminado");
            } else {
                JOptionPane.showMessageDialog(null,"No existe Cliente de Codigo "+code);
            }
            CargarClientes();
            conexion.close();
        } catch (SQLException ex) {
            System.out.println("ERROR DE TRUNCADO, HAY VENTAS HACIA ESE CLIENTE: " + ex);
            JOptionPane.showMessageDialog(null,"No se puede eliminar, este cliente tiene registrado alguna venta ");
        }

    }//cierra metodo eliminarCliente

    
    
    public void ModificarCliente(String code,String nombre, String apellido, String dni,String direccion,String telefono,String correo) {
    
        //String url="jdbc:oracle:thin:@//localhost:1521/orcl ";
        try {
            //Connection conexion = DriverManager.getConnection(url,"Pinkberry","admin123");
            //Statement comando = conexion.createStatement();
            
            conexion = ConexionConBaseDatos.getConexion();
            Statement comando = conexion.createStatement();

            int cantidad = comando.executeUpdate("update table_Cliente set nombres='" + nombre + "', "
                + " apellidos ='" + apellido + "'" +  " "+ ", dni ='" + dni + "'"+  ",direccion ='" + direccion + "',telefono ='" + telefono + "', correo ='" + correo + "'  where codCliente=" + code);
            if (cantidad == 1) {
                JOptionPane.showMessageDialog(null," Modifico con Exito");
            } else {
                JOptionPane.showMessageDialog(null,"No existe Vendedor de un codigo "+code);
            }
            conexion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null," Error -->"+ex);
        }
    }
    
    
    
    
    /***************************************************************************************************/
    public int existeDni(int dni_evaluar){
        
        try {
            String sql = "select count(codCliente) from table_Cliente where dni = ?";
            conectar = ConexionConBaseDatos.getConexion();
            PreparedStatement pst = conectar.prepareStatement(sql);
            pst.setInt(1, dni_evaluar);
            ResultSet res = pst.executeQuery();

            if(res.next()){
                return res.getInt(1);
            }
            return 1;
            
        } catch (SQLException e) {
            System.out.println("Error al Validar DNI : " + e.getMessage());
            return 1;
        }
        
    }
    /***************************************************************************************************/
 
   


}//cierra class
