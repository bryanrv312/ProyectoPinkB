
package Pruebas;

import Control_BD.fusuario;
import Control_BD.vusuario;
import java.util.ArrayList;
import javax.swing.JOptionPane;



/**
 *
 * @author bryam
 */
public class BusquedaUsuario_test {

    public static void main(String[] args) {
        fusuario udao = new fusuario(); 
        ArrayList<vusuario> lista = udao.buscarUsuario("br");
        
        for(vusuario u : lista){
            System.out.println(u);
        }
       
        //JOptionPane.showMessageDialog(null, "Producto no encontrado");
        
    }
    
}
