/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Control_BD;


import com.placeholder.PlaceHolder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class fusuario {
     public void holders(){ 
        PlaceHolder holder;
    }
        Connection cn = null;
 //   private ConexionConBaseDatos mysql = new conexion();

    private String sSQL = "";
    private String sSQL2 = "";
    public Integer totalregistros;
    
    
    

    public DefaultTableModel mostrar_inicial() {
        
        cn= ConexionConBaseDatos.getConexion();

        DefaultTableModel modelo;
        String[] titulos = {"id", "usuario", "pasword", "tipo", "nombres", "apellidos", "dni", "Teléfono"};
        String[] registro = new String[14];
        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select * from usuario";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("id");
                registro[1] = rs.getString("usuario");
                registro[2] = rs.getString("pasword");
                registro[3] = rs.getString("tipo");
                registro[4] = rs.getString("nombres");
                registro[5] = rs.getString("apellidos");
                registro[6] = rs.getString("dni");
                registro[7] = rs.getString("telefono");

                
                totalregistros = totalregistros + 1;
                modelo.addRow(registro);
            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }
    /****************************************************************************************************************/
    
    public ArrayList<vusuario> mostrarInicio(){
        
        try {
            String sql = "call all_usuario()";
            cn= ConexionConBaseDatos.getConexion();
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet res = pst.executeQuery();
            
            ArrayList<vusuario> lista = new ArrayList<>();
            vusuario usu;
            
            while(res.next()){
                usu = new vusuario();
                usu.setId(res.getInt("id"));
                usu.setUsuario(res.getString("usuario"));
                usu.setPassword(res.getString("pasword"));
                usu.setTipo(res.getString("tipo"));
                usu.setNombres(res.getString("nombres"));
                usu.setApellidos(res.getString("apellidos"));
                usu.setdni(res.getInt("dni"));
                usu.setTelefono(res.getInt("telefono"));
                
                lista.add(usu);
            }
            return lista;
            
        } catch (SQLException e) {
            System.out.println("ERROR EN USUARIO.DAO.MOSTRAR_INICIAL" + e.getMessage());
            return null;
        }
    }
    
    /****************************************************************************************************************/
    
    
    
    public DefaultTableModel mostrar(String buscar) {
        cn= ConexionConBaseDatos.getConexion();
        DefaultTableModel modelo;

        String[] titulos = {"id", "usuario", "pasword", "tipo", "nombres", "apellidos", "dni", "Teléfono"};

        String[] registro = new String[14];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select p.id,p.usuario,p.pasword,p.tipo,p.nombres,p.apellidos,"
                + "p.dni,p.telefono from usuario p"
                + " where dni like '%"
                + buscar + "%' or "
                +"nombres like '%"
                + buscar + "%' or "
                +"apellidos like '%"
                + buscar + "%'"
                + "order by id desc";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("id");
                registro[1] = rs.getString("usuario");
                registro[2] = rs.getString("pasword");
                registro[3] = rs.getString("tipo");
                registro[4] = rs.getString("nombres");
                registro[5] = rs.getString("apellidos");
                registro[6] = rs.getString("dni");
                registro[7] = rs.getString("telefono");

                
                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }
    
    /*******************************************************************************************************/
    public ArrayList<vusuario> buscarUsuario(String query){
        try {
            //String sql = "select * from usuario where (nombres like ? or apellidos like ? or dni like ?) order by id desc";
            String sql = "call buscar_usuario(?)";
            cn= ConexionConBaseDatos.getConexion();
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, "%" + query + "%");
            //pst.setString(2, "%" + query + "%");
            //pst.setString(3, "%" + query + "%");
            ResultSet res = pst.executeQuery();
            
            ArrayList<vusuario> listaBusqueda = new ArrayList<>();
            vusuario usu;
            
            while (res.next()) {                
                usu = new vusuario();
                usu.setId(res.getInt("id"));
                usu.setUsuario(res.getString("usuario"));
                usu.setPassword(res.getString("pasword"));
                usu.setTipo(res.getString("tipo"));
                usu.setNombres(res.getString("nombres"));
                usu.setApellidos(res.getString("apellidos"));
                usu.setdni(res.getInt("dni"));
                usu.setTelefono(res.getInt("telefono"));
                
                listaBusqueda.add(usu);
            }
            return listaBusqueda;

        } catch (SQLException ex) {
            System.out.println("Error en buscarUsuario.DAO = " + ex.getMessage());
            return null;
        }
    }
    /*******************************************************************************************************/

    public boolean insertar(vusuario dts) {
        cn= ConexionConBaseDatos.getConexion();
       sSQL = "insert into usuario (id,usuario,pasword,tipo,nombres,apellidos,dni,telefono)"
                + "values (?,?,?,?,?,?,?,?)";
        
        try {
                
            PreparedStatement pst = cn.prepareStatement(sSQL);
            //PreparedStatement pst2 = cn.prepareStatement(sSQL2);

            pst.setString(1, "");
            pst.setString(2, dts.getUsuario());
            pst.setString(3, dts.getPassword());
            pst.setString(4, dts.getTipo());
            pst.setString(5, dts.getNombres());
            pst.setString(6, dts.getApellidos());
            pst.setInt(7, dts.getdni());
            pst.setInt(8, dts.getTelefono());      
            
            int n2 = pst.executeUpdate();
            if (n2 != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
    /**********************************************************************************************************/
    //INSERTAR USUARIO
    
    public boolean insertarUsuario(vusuario usu){
        
        try {
            //String sql = "insert into usuario (usuario,pasword,tipo,nombres,apellidos,dni,telefono) values (?,?,?,?,?,?,?)";
            String sql = "call insert_usuario(?,?,?,?,?,?,?)";
            cn= ConexionConBaseDatos.getConexion();
            PreparedStatement pst = cn.prepareStatement(sql);
            //pst.setString(1, "");
            pst.setString(1, usu.getUsuario());
            pst.setString(2, usu.getPassword());
            pst.setString(3, usu.getTipo());
            pst.setString(4, usu.getNombres());
            pst.setString(5, usu.getApellidos());
            pst.setInt(6, usu.getdni());
            pst.setInt(7, usu.getTelefono()); 
            
            return pst.executeUpdate() > 0 ?  true : false;
            
        } catch (Exception ex) {
            System.out.println("ERROR EN INSERTARUSUARIO.DAO : " + ex.getMessage());
            return false;
        }
    }
    /**********************************************************************************************************/
    //EXISTE DNI
    public int existeDni(int dni_form){
        
        try {
            String sql = "select count(id) from usuario where dni = ?";
            cn= ConexionConBaseDatos.getConexion();
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, dni_form);
            ResultSet res = pst.executeQuery();
            
            //vusuario usu = new vusuario();
            //usu.setdni(0);
            
            if(res.next()){
                return res.getInt(1);
            }
            
            return 1;
            
        } catch (SQLException e) {
            System.out.println("Error al Validar DNI : " + e.getMessage());
            return 1;
        }
        
    }
    
    /**********************************************************************************************************/

    public boolean editar(vusuario dts) {
        cn= ConexionConBaseDatos.getConexion();
//consultar editar usuario
        
        sSQL2 = "update usuario set id=?,usuario=?,pasword=?,tipo=?,nombres=?,apellidos=?,dni=?,telefono=?"
                + " where id=?";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL2);

   

               pst.setString(1, dts.getUsuario());
            pst.setString(2, dts.getPassword());
            pst.setString(3, dts.getTipo());
            pst.setString(4, dts.getTipo());
            pst.setString(5, dts.getNombres());
            pst.setString(6, dts.getApellidos());
            pst.setInt(7, dts.getdni());
            pst.setInt(8, dts.getTelefono()); 

               int n2 = pst.executeUpdate();

                if (n2 != 0) {
                    return true;

                } else {
                    return false;
                }
         

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean eliminar(vusuario dts) {
        cn= ConexionConBaseDatos.getConexion();
//consulta eliminar usuario
                
          sSQL="delete from usuario where id=?";
       
       try {
           
           PreparedStatement pst=cn.prepareStatement(sSQL);
           
           pst.setInt(1, dts.getId());

               int n2 = pst.executeUpdate();

                if (n2 != 0) {
                    return true;

                } else {
                    return false;
                }
         

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    public DefaultTableModel login(String usuario,String password) {
        
        cn= ConexionConBaseDatos.getConexion();
        DefaultTableModel modelo;
        String[] titulos = {"id", "usuario", "pasword", "tipo", "nombres", "apellidos", "dni", "telefono"};
        String[] registro = new String[8];
        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);    
        String sql = "select * from usuario where usuario=? and pasword =?";
        
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, usuario);
            pst.setString(2, password);           
            ResultSet rs = pst.executeQuery();
    
            while (rs.next()) {    
                registro[0] = rs.getString("id");
                registro[1] = rs.getString("usuario");
                registro[2] = rs.getString("pasword");
                registro[3] = rs.getString("tipo");               
                registro[4] = rs.getString("nombres");
                registro[5] = rs.getString("apellidos");
                registro[6] = rs.getString("dni");
                registro[7] = rs.getString("telefono");
                
                totalregistros = totalregistros + 1;//usa totalrregistros para validar si el usuario ingreso o no en la vista frm
                modelo.addRow(registro);   
            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.getMessage());
            return null;
        }

    }
    
 /*************************************************************************************************************/   
    public vusuario loginUsuario(String user, String pass){
        try {
            String sql = "call autenticacion(?,?)";
            cn= ConexionConBaseDatos.getConexion();
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, user);
            pst.setString(2, pass);
            ResultSet res = pst.executeQuery();
            
            vusuario usu = null;   
            while (res.next()) { 
                usu = new vusuario();
                usu.setId(res.getInt("id"));
                usu.setUsuario(res.getString("usuario"));
                usu.setPassword(res.getString("pasword"));
                usu.setTipo(res.getString("tipo"));
                usu.setNombres(res.getString("nombres"));
                usu.setApellidos(res.getString("apellidos"));
                usu.setdni(res.getInt("dni"));
                usu.setTelefono(res.getInt("telefono"));
            }
            return usu;
        } catch (SQLException e) {
            System.out.println("Error en loginUsuario.Dao");
            return null;
        }
    }
/*************************************************************************************************************/ 
    
    public ArrayList<tipoUsuario> getTiposUsuario(){
        
        try {
            String sql = "select * from tipousuario";
            cn= ConexionConBaseDatos.getConexion();
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet res = pst.executeQuery();
            
            ArrayList<tipoUsuario> lista = new ArrayList<>();
            tipoUsuario tipo = null;
            
            while(res.next()){
                tipo = new tipoUsuario();
                tipo.setCodigo(res.getInt("codTipo"));
                tipo.setDescripcion(res.getString("descripcion"));
                lista.add(tipo);
            }
            return lista;
            
        } catch (SQLException e) {
            System.out.println("Error en ListaTipoUsuario: " + e.getMessage());
            return null;
        }
    }
    
/**************************************************************************************************************/  
    /*OBTENER ID DEL USUARIO PARA REGISTRARLO EN LA VENTA*/
    public vusuario getIdUsuario(String user, String pass){
        try {
            String sql = "select * from usuario where usuario = ? and pasword = ?";
            cn= ConexionConBaseDatos.getConexion();
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, user);
            pst.setString(2, pass);
            ResultSet res = pst.executeQuery();
            
            vusuario usu = null;   
            while (res.next()) { 
                usu = new vusuario();
                usu.setId(res.getInt("id"));
                usu.setUsuario(res.getString("usuario"));
                usu.setPassword(res.getString("pasword"));
                usu.setTipo(res.getString("tipo"));
                usu.setNombres(res.getString("nombres"));
                usu.setApellidos(res.getString("apellidos"));
                usu.setdni(res.getInt("dni"));
                usu.setTelefono(res.getInt("telefono"));
            }
            return usu;
            
        } catch (SQLException e) {
            System.out.println("Error al Obtener ID del usuario");
            return null;
        }
    }
    
/**************************************************************************************************************/ 
    
    
    public String[] GetId(String usuario,String pasword){
            sSQL = "select * from usuario where usuario = '" + usuario  + "' and pasword = '" + pasword + "'" ;
              
            String arreglo[] = new String [8];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                arreglo[0] = rs.getString("id");
                arreglo[1] = rs.getString("usuario");
                arreglo[2] = rs.getString("pasword");
                arreglo[3] = rs.getString("tipo");             
                arreglo[4] = rs.getString("nombres");
                arreglo[5] = rs.getString("apellidos");
                arreglo[6] = rs.getString("dni");
                arreglo[7] = rs.getString("telefono");
                cn.close();
                cn=null;
                rs.close();
                rs=null;
                return arreglo;
            }
                
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
        return null;
        }
    
    
    
    
    
    /**************************************************************************************************************/ 
    
    public String getTipoUsuById(String codigo){
        try {
            String sql = "call getTipoUsu(?);";
            cn= ConexionConBaseDatos.getConexion();
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, codigo);
            ResultSet res = pst.executeQuery();
            
            String descripcion = "";

            while (res.next()) { 
                descripcion = res.getString("descripcion");
            }
            return descripcion;
            
        } catch (SQLException e) {
            System.out.println("Error en getTipoUsuById.Dao");
            return null;
        }
    }
    
/**************************************************************************************************************/ 
    
    
    
    
    
    
    
    public static void main(String[] args) {
        
        fusuario udao = new fusuario();
        System.out.println(udao.getTipoUsuById("2"));
        
      /*  fusuario udao = new fusuario();
        vusuario usu = udao.getIdUsuario("admin", "admin");
        
        System.out.println(usu.getId() + " " + usu.getNombres());
        */
        
        /*
        fusuario udao = new fusuario();
        int corrobora_dni = udao.existeDni(12457845);
        
        System.out.println(corrobora_dni);*/
        
        /*
            fusuario udao = new fusuario();
            //vusuario u = new vusuario();
            
            ArrayList<vusuario> lista = udao.buscarUsuario("2");
            
            for(vusuario usu : lista){
                System.out.println(usu);
            }
            */
            
            
            
            /*//u.setId(8);
            u.setNombres("jonh1");
            u.setApellidos("durand1");
            u.setUsuario("jondu1");
            u.setPassword("1231");
            u.setTelefono(123456);
            u.setdni(12457845);
            u.setTipo("2");
            udao.insertarUsuario(u);*/
            
            /*
            u =udao.loginUsuario("admin", "admin");
            System.out.println(u.toString());*/
       
       
    }
    
}
