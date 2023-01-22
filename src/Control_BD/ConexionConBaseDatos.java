package Control_BD;

import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConexionConBaseDatos {
    
    static Connection c = null;
    
    public static Connection getConexion() {
        
        try {
            DriverManager.registerDriver(new Driver());   
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pink3", "root", ""); 
            
            if(c != null){System.out.println("exito de conexion");}
            
        } catch (SQLException ex) {
            Logger.getLogger(ConexionConBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se pudo establecer la conexion "+ex.getMessage(),"Error de conecion",JOptionPane.ERROR_MESSAGE);
           System.out.println("erorr >>>> "+ ex.getMessage());
        }
        return c;
    }
    
    
}