package Control_BD;

import consultas.ConsultarBoletas;
import consultas.ConsultarFacturas;
import static consultas.ConsultarFacturas.listadecompras;
import consultas.ConsultarVentas;
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


public class Control_Consultas {

    //modelo para la tabla
    DefaultTableModel modelo;
    //vector con los titulos de cada columna
    
    //matriz donde se almacena los datos de cada celda de la tabla
    String info[][] = {};
    // Conectar Base de Datos
    ConexionConBaseDatos conectar = new ConexionConBaseDatos();
    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    
    public void listarTodosFacturas() {
        
        String[] titulosColumnas = {"NRO-FACTURA", "CLIENTE", "TOTAL","FECHA"};

        modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
      //le asigna el modelo al jtable
        ConsultarFacturas.jTableListarFacturas.setModel(modelo);

        //ejecuta una consulta a la BD
        ejecutarConsultaTodaTabladeFacturas();

    }//cierra metodo listarTodosFacturas
    
        

     /**
     * Metodo para consultar todos los regsitros de la base de datos de clientes
     * y luego ser mostrados en una tabla.
     */
    Connection conexion = null;
    Statement sentencia = null;
    ResultSet resultado = null;
    PreparedStatement ps = null;

    public void ejecutarConsultaTodaTabladeFacturas()  {

        
        try {
            conexion = ConexionConBaseDatos.getConexion();

            sentencia = conexion.createStatement();
            String consultaSQL = " SELECT * FROM Factura inner join  table_Cliente on Factura.codCliente = table_Cliente.codCliente  ORDER BY nombres ASC";
            resultado = sentencia.executeQuery(consultaSQL);


            //mientras haya datos en la BD ejecutar eso...
            while (resultado.next()) {


             int fact = resultado.getInt("NroFactura");
                String cliente = resultado.getString("nombres") +(" ")+resultado.getString("apellidos");
                //String producto = resultado.getString("nombreP");
                String total = resultado.getString("total");
                String fecha = resultado.getString("fecha");
                //crea un vector donde los está la informacion (se crea una fila)
                Object[] info = {fact,cliente,total,fecha};

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
    
  
    public void buscarFacturas(String parametroBusqueda, boolean buscarPorFacturas, boolean buscarPorCliente, boolean buscarPorFecha) {

        String[] titulosColumnas = {"NroFactura","CLIENTE","FECHA","TOTAL"};
        if ((parametroBusqueda.trim().length() == 0)) {
            JOptionPane.showMessageDialog(null,"Error, datos incorrectos");
        } else {

            modelo = new DefaultTableModel(info, titulosColumnas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

          

            //le asigna el modelo al jtable
            ConsultarFacturas.jTableListarFacturas.setModel(modelo);
            //ejecuta una consulta a la BD
            buscarFacturasporBusqueda(parametroBusqueda, buscarPorFacturas, buscarPorCliente, buscarPorFecha);

        }

    }//cierra metodo buscarCliente
    
    /**
     * Método para buscar un registro en la base de datos dentro de la tabla
     * clientes, se puede buscar por la cedula o por el nombre.
     */
    public void buscarFacturasporBusqueda(String parametroBusqueda, boolean buscarPorFacturas, boolean buscarPorCliente, boolean buscarPorFecha) {

        try {

            
            conexion = ConexionConBaseDatos.getConexion();
            String selectSQL;
            resultado = null;
            if (buscarPorFacturas == true) {     
                System.out.print("buscando por facturas");
                selectSQL = "SELECT * FROM Factura WHERE NroFactura LIKE ? ORDER BY fecha ASC";
                ps = conexion.prepareStatement(selectSQL);
                ps.setString(1, "%" + parametroBusqueda + "%");
            } 
            else if(buscarPorCliente== true){
                System.out.print("buscando por cliente");
               // selectSQL = "SELECT * FROM Factura f inner join  table_Cliente c on f.cliente=c.codCliente WHERE   c.dni LIKE ?  or c.nombres LIKE ? ORDER BY fecha ASC";
               selectSQL = "SELECT * FROM Factura inner join  table_Cliente on Factura.codCliente = table_Cliente.codCliente WHERE dni LIKE ? or nombres LIKE ? ORDER BY fecha ASC";
                ps = conexion.prepareStatement(selectSQL);
                 ps.setString(1, "%" + parametroBusqueda + "%");
                  ps.setString(2, "%" + parametroBusqueda + "%");
                       // ps.setString(3, "%" + parametroBusqueda + "%");
            }
            else if(buscarPorFecha== true){

                System.out.print("buscando por fecha -->"+parametroBusqueda);
                selectSQL = "SELECT * FROM Factura inner join  table_Cliente on Factura.codCliente = table_Cliente.codCliente WHERE cast(fecha as date) like ?  ORDER BY nombres ASC";
                ps = conexion.prepareStatement(selectSQL);
                ps.setString(1, "%" + parametroBusqueda + "%");
            }
            resultado = ps.executeQuery();

            while (resultado.next()) {
                int fact = resultado.getInt("NroFactura");
                String cliente = resultado.getString("nombres")+resultado.getString("apellidos");
                String fecha = resultado.getString("fecha");
                String total = resultado.getString("total");
               

                //crea un vector donde los está la informacion (se crea una fila)
                Object[] info = {fact,cliente, fecha,total};
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
    
    
    //esta es la parte de mostar detalle de facturas por la tabla venta
    
    //metodo para buscar un producto
    public void buscarFacturas ( String number){
        
        String[] titulosColumnas = {"idDetalle", "PRODUCTOS", "CANTIDAD", "IMPORTE"};
        if( (number.trim().length()==0)){
            JOptionPane.showMessageDialog(null,"Error, Seleccione la Facturas");
        }
        else{
            
            modelo = new DefaultTableModel(info,titulosColumnas){
                public boolean isCellEditable(int row, int column)
                {
                return false;
                }
                
            };
         
         
         
        //le asigna el modelo al jtable
       ConsultarFacturas.listadecompras.setModel(modelo);
       
        int[] anchos = {80, 200,50,145};
        for(int i = 0; i < listadecompras.getColumnCount(); i++) {
        listadecompras.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
       //ejecuta una consulta a la BD   
        buscarFacturasDetall(number);         
        }
        
    }//cierra metodo buscarCliente
    
      public void buscarFacturasDetall(String number) {

        try {
            conexion = ConexionConBaseDatos.getConexion();
            String selectSQL;
            resultado = null;
           
                selectSQL = "SELECT * FROM detalleFactura WHERE NroFactura LIKE ? ORDER BY detalle ASC";
                ps = conexion.prepareStatement(selectSQL);
                ps.setString(1, "%" + number + "%");
            
            resultado = ps.executeQuery();

            while (resultado.next()) {
                String id = resultado.getString("idDetalle");
                String product = resultado.getString("codProducto");
                String cant = resultado.getString("cantidad");
                String imp = resultado.getString("precio");
                //crea un vector donde los está la informacion (se crea una fila)
                
                //buscar producto
                String name="";
                Statement comando = conexion.createStatement();
                 ResultSet registro = comando.executeQuery("select codP,nombreP from table_Productos where codP=" +product);
            
                 if (registro.next() == true) {
                     name = registro.getString("nombreProductos");
                    }
            // cierdda de buscar productos
                Object[] info = {id,name,cant,imp};
                //al modelo de la tabla le agrega una fila
                //con los datos que están en info
                modelo.addRow(info);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error\n " + e);
        } finally {
            CerrarConexiones.metodoCerrarConexiones(conexion, sentencia, resultado, ps);
        }


    }//cierra metodo buscarRegistro
      
      
      //parte de consultas boletas 
        public void listarTodosBoletas() {
        
        String[] titulosColumnas = {"NroBoleta", "CLIENTE", "TOTAL","FECHA"};

        modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
      //le asigna el modelo al jtable
        ConsultarBoletas.jTableListarBoletas.setModel(modelo);

        //ejecuta una consulta a la BD
        ejecutarConsultaTodaTabladeBoletas();

    }//cierra metodo listarTodosFacturas
    
        

     /**
     * Metodo para consultar todos los regsitros de la base de datos de clientes
     * y luego ser mostrados en una tabla.
     */
    public void ejecutarConsultaTodaTabladeBoletas()  {

        
        try {
            conexion = ConexionConBaseDatos.getConexion();

            sentencia = conexion.createStatement();
            //String consultaSQL = "SELECT * FROM Factura inner join f table_Cliente l on f.cliente=l.codCliente ORDER BY fecha ASC";
             String consultaSQL = " SELECT * FROM Boleta inner join  table_Cliente on Boleta.codCliente = table_Cliente.codCliente  ORDER BY nombres ASC";
            resultado = sentencia.executeQuery(consultaSQL);


            //mientras haya datos en la BD ejecutar eso...
            while (resultado.next()) {


             int fact = resultado.getInt("NroBoleta");
                String cliente = resultado.getString("nombres") +(" ")+resultado.getString("apellidos");
                String fecha = resultado.getString("fecha");
                String total = resultado.getString("total");
                //crea un vector donde los está la informacion (se crea una fila)
                Object[] info = {fact,cliente,total,fecha};

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
    
  
    public void buscarBoletas(String parametroBusqueda, boolean buscarPorFacturas, boolean buscarPorCliente, boolean buscarPorFecha) {

        String[] titulosColumnas = {"NroBoleta","CLIENTE","FECHA","TOTAL"};
        if ((parametroBusqueda.trim().length() == 0)) {
            JOptionPane.showMessageDialog(null,"Error, datos incorrectos");
        } else {

            modelo = new DefaultTableModel(info, titulosColumnas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

          

            //le asigna el modelo al jtable
            ConsultarBoletas.jTableListarBoletas.setModel(modelo);
            //ejecuta una consulta a la BD
            buscarBoletasporBusqueda(parametroBusqueda, buscarPorFacturas, buscarPorCliente, buscarPorFecha);

        }

    }//cierra metodo buscarCliente
    
    /**
     * Método para buscar un registro en la base de datos dentro de la tabla
     * clientes, se puede buscar por la cedula o por el nombre.
     */
    public void buscarBoletasporBusqueda(String parametroBusqueda, boolean buscarPorFacturas, boolean buscarPorCliente, boolean buscarPorFecha) {

        try {

            
            conexion = ConexionConBaseDatos.getConexion();
            String selectSQL;
            resultado = null;
            if (buscarPorFacturas == true) {     
                System.out.print("buscando por facturas");
                selectSQL = "SELECT * FROM Boleta WHERE NroBoleta LIKE ? ORDER BY fecha ASC";
                ps = conexion.prepareStatement(selectSQL);
                ps.setString(1, "%" + parametroBusqueda + "%");
            } 
            else if(buscarPorCliente== true){
                System.out.print("buscando por cliente");
               // selectSQL = "SELECT * FROM Factura f inner join  table_Cliente c on f.cliente=c.codCliente WHERE   c.dni LIKE ?  or c.nombres LIKE ? ORDER BY fecha ASC";
               selectSQL = "SELECT * FROM Boleta inner join  table_Cliente on Boleta.codCliente = table_Cliente.codCliente WHERE dni LIKE ? or nombres LIKE ? ORDER BY fecha ASC";
                ps = conexion.prepareStatement(selectSQL);
                 ps.setString(1, "%" + parametroBusqueda + "%");
                  ps.setString(2, "%" + parametroBusqueda + "%");
                       // ps.setString(3, "%" + parametroBusqueda + "%");
            }
            else if(buscarPorFecha== true){

                System.out.print("buscando por fecha -->"+parametroBusqueda);
                selectSQL = "SELECT * FROM Boleta inner join  table_Cliente on Boleta.codCliente = table_Cliente.codCliente WHERE cast(fecha as date) like ?  ORDER BY nombres ASC";
                ps = conexion.prepareStatement(selectSQL);
                ps.setString(1, "%" + parametroBusqueda + "%");
            }
            resultado = ps.executeQuery();

            while (resultado.next()) {
                int fact = resultado.getInt("NroBoleta");
                String cliente = resultado.getString("nombres")+(" ")+resultado.getString("apellidos");
                String fecha = resultado.getString("fecha");
                String total = resultado.getString("total");
               

                //crea un vector donde los está la informacion (se crea una fila)
                Object[] info = {fact,cliente, fecha,total};
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
    
    
    //esta es la parte de mostar detalle de facturas por la tabla venta
    
    //metodo para buscar un producto
    public void buscarBoletas ( String number){
        
        String[] titulosColumnas = {"idBoleta", "PRODUCTOS", "CANTIDAD", "IMPORTE"};
        if( (number.trim().length()==0)){
            JOptionPane.showMessageDialog(null,"Error, Seleccione la Facturas");
        }
        else{
            
            modelo = new DefaultTableModel(info,titulosColumnas){
                public boolean isCellEditable(int row, int column)
                {
                return false;
                }
                
            };
         
         
         
        //le asigna el modelo al jtable
       ConsultarFacturas.listadecompras.setModel(modelo);
       
        int[] anchos = {80, 200,50,145};
        for(int i = 0; i < listadecompras.getColumnCount(); i++) {
        listadecompras.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
       //ejecuta una consulta a la BD   
        buscarFacturasDetall(number);         
        }
        
    }//cierra metodo buscarCliente
    
      public void buscarBoletasDetall(String number) {

        try {
            conexion = ConexionConBaseDatos.getConexion();
            String selectSQL;
            resultado = null;
           
                selectSQL = "SELECT * FROM detalleBoleta WHERE NroBoleta LIKE ? ORDER BY detalle ASC";
                ps = conexion.prepareStatement(selectSQL);
                ps.setString(1, "%" + number + "%");
            
            resultado = ps.executeQuery();

            while (resultado.next()) {
                String id = resultado.getString("idDetalleB");
                String product = resultado.getString("codProducto");
                String cant = resultado.getString("cantidad");
                String imp = resultado.getString("precio");
                //crea un vector donde los está la informacion (se crea una fila)
                
                //buscar producto
                String name="";
                Statement comando = conexion.createStatement();
                 ResultSet registro = comando.executeQuery("select codP,nombreP from table_Productos where codP=" +product);
            
                 if (registro.next() == true) {
                     name = registro.getString("nombreProductos");
                    }
            // cierdda de buscar productos
                Object[] info = {id,name,cant,imp};
                //al modelo de la tabla le agrega una fila
                //con los datos que están en info
                modelo.addRow(info);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error\n " + e);
        } finally {
            CerrarConexiones.metodoCerrarConexiones(conexion, sentencia, resultado, ps);
        }


    }//cierra metodo buscarRegistro
      
      
      
      // parte de todo consultas en ventas--------------------------------------------------------------
      //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    
    public void listarTodosVentas() {
        
        String[] titulosColumnas = {"idVentas","NroFacturacion","Fecha", "Cliente", "cantidad", "Total"};

        modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
      //le asigna el modelo al jtable
        ConsultarVentas.jTableListarVentas.setModel(modelo);

        //ejecuta una consulta a la BD
        ejecutarConsultaTodaTabladeVentas();

    }//cierra metodo listarTodosFacturas
    
        

     /**
     * Metodo para consultar todos los regsitros de la base de datos de clientes
     * y luego ser mostrados en una tabla.
     */


    public void ejecutarConsultaTodaTabladeVentas() {

        try {
            conexion = ConexionConBaseDatos.getConexion();

            sentencia = conexion.createStatement();
            String consultaSQL = "SELECT        dbo.Ventas.idVentas, dbo.detalleBoleta.NroBoleta, dbo.detalleFactura.nroFactura, dbo.Boleta.fecha AS fechaBoleta, dbo.Factura.fecha AS fechaFactura, dbo.table_Cliente.nombres, dbo.detalleBoleta.cantidad AS cantidadBoleta, \n" +
"                         dbo.Boleta.total AS totalBoleta, dbo.detalleFactura.cantidad AS cantidadFactura, dbo.Factura.total AS totalFactura, dbo.Factura.total + dbo.Boleta.total AS ganancia\n" +
"FROM            dbo.Ventas INNER JOIN\n" +
"                         dbo.detalleBoleta ON dbo.Ventas.idDetalleB = dbo.detalleBoleta.idDetalleB INNER JOIN\n" +
"                         dbo.detalleFactura ON dbo.Ventas.idDetalleFact = dbo.detalleFactura.idDetalle INNER JOIN\n" +
"                         dbo.Boleta ON dbo.detalleBoleta.NroBoleta = dbo.Boleta.NroBoleta INNER JOIN\n" +
"                         dbo.Factura ON dbo.detalleFactura.nroFactura = dbo.Factura.NroFactura INNER JOIN\n" +
"                         dbo.table_Cliente ON dbo.Boleta.codCliente = dbo.table_Cliente.codCliente AND dbo.Factura.codCliente = dbo.table_Cliente.codCliente ORDER BY idVentas ASC";
            resultado = sentencia.executeQuery(consultaSQL);


            //mientras haya datos en la BD ejecutar eso...
            while (resultado.next()) {


                int num = resultado.getInt("idVenta");
                String fact = resultado.getString("nroFactura"+"nroBoleta");
                String prod = resultado.getString("nombres");
                String cant = resultado.getString("cantidad");
                String importe = resultado.getString("total");



                //crea un vector donde los está la informacion (se crea una fila)
                Object[] info = {num,fact,prod,cant,importe};

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
      
    
            
                public void buscarFacturasdeVentasFecha(String parametroBusqueda,String parametroBusqued2) {

        String[] titulosColumnas = {"cod-Ventas","Fecha", "Producto", "cantidad", "Importe"};
        if ((parametroBusqueda.trim().length() == 0)) {
            JOptionPane.showMessageDialog(null,"Error, datos incorrectos");
        } else {

            modelo = new DefaultTableModel(info, titulosColumnas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            //le asigna el modelo al jtable
            
            
            ConsultarVentas.jTableListarVentas.setModel(modelo);
            //ejecuta una consulta a la BD
            buscarFacturasporBusquedaenVentasFecha(parametroBusqueda,parametroBusqued2);

        }

    }//cierra metodo buscarCliente
    public void buscarFacturasdeVentas(String parametroBusqueda) {

        String[] titulosColumnas = {"cod-Ventas","Fecha", "Producto", "cantidad", "Importe"};
        if ((parametroBusqueda.trim().length() == 0)) {
            JOptionPane.showMessageDialog(null,"Error, datos incorrectos");
        } else {

            modelo = new DefaultTableModel(info, titulosColumnas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            


            //le asigna el modelo al jtable
            ConsultarVentas.jTableListarVentas.setModel(modelo);
            //ejecuta una consulta a la BD
            buscarFacturasporBusquedaenVentas(parametroBusqueda);

        }

    }//cierra metodo buscarCliente
    
    /**
     * Método para buscar un registro en la base de datos dentro de la tabla
     * clientes, se puede buscar por la cedula o por el nombre.
     */
    public void buscarFacturasporBusquedaenVentasFecha(String parametroBusqueda,String parametroBusqueda2) {

        try {

        
            conexion = ConexionConBaseDatos.getConexion();
            String selectSQL;
            resultado = null;
                System.err.println(parametroBusqueda2+"    "+parametroBusqueda);
                System.out.print("buscando por facturas en Ventas");
               selectSQL = "SELECT * FROM Factura f inner join  detalleFactura v on f.cod=v.NroFacturas inner join  table_Productos p on v.Productos=p.codP WHERE " +"  fecha<= '" +parametroBusqueda2+"' AND  fecha>= '"+parametroBusqueda+"'";
               
                      Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(selectSQL);
            
             
float total=0;
float ganancia=0;
//Difererencia
            while (rs.next()) {
                int num = rs.getInt("detalle");
                String fact = rs.getString("f.fecha");
                String prod = rs.getString("p.nombreP");
                String cant = rs.getString("v.cantidad");
                String importe = rs.getString("v.importe");
                total=total+rs.getFloat("v.importe");
                //ganancia=ganancia+rs.getFloat("p.Difererencia");
                ganancia=ganancia+(rs.getInt("p.Diferencia"))*(rs.getInt("v.cantidad"));

                //crea un vector donde los está la informacion (se crea una fila)
                Object[] info = {num,fact,prod,cant,importe};
                //al modelo de la tabla le agrega una fila
                //con los datos que están en info
                modelo.addRow(info);

            }
ConsultarVentas.label_total.setText(total+"  Soles");
ConsultarVentas.label_ganancia.setText(ganancia+"  Soles");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error\n Por la Causa" + e);
        } finally {
            CerrarConexiones.metodoCerrarConexiones(conexion, sentencia, resultado, ps);
        }


    }
    
    public void buscarFacturasporBusquedaenVentas(String parametroBusqueda) {

        try {

        
            conexion = ConexionConBaseDatos.getConexion();
            String selectSQL;
            resultado = null;
                
                System.out.print("buscando por facturas en Ventas");
               selectSQL = "SELECT * FROM Factura f inner join  detalleFactura v on f.NroFactura=v.NroFactura inner join  table_Productos p on v.codP=p.codP WHERE p.nombreP LIKE ? ORDER BY v.NroFactura ASC";
                ps = conexion.prepareStatement(selectSQL);
                ps.setString(1, "%" + parametroBusqueda + "%");
            
            resultado = ps.executeQuery();
float total=0;
float ganancia=0;
            while (resultado.next()) {
                int num = resultado.getInt("detalle");
                String fact = resultado.getString("f.fecha");
                String prod = resultado.getString("p.nombreP");
                String cant = resultado.getString("v.cantidad");
                String importe = resultado.getString("v.importe");
                
total=total+resultado.getInt("v.importe");
ganancia=ganancia+(resultado.getInt("p.Diferencia"))*(resultado.getInt("v.cantidad"));
                //crea un vector donde los está la informacion (se crea una fila)
                Object[] info = {num,fact,prod,cant,importe};
                //al modelo de la tabla le agrega una fila
                //con los datos que están en info
                modelo.addRow(info);

            }
ConsultarVentas.label_total.setText(total+"  Soles");
ConsultarVentas.label_ganancia.setText(ganancia+"  Soles");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error\n Por la Causa" + e);
        } finally {
            CerrarConexiones.metodoCerrarConexiones(conexion, sentencia, resultado, ps);
        }


    }//cierra metodo buscarRegistro
    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
      
      
      
}//cierra class
