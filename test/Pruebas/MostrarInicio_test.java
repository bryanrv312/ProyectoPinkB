
package Pruebas;

import Control_BD.fusuario;
import Control_BD.vusuario;
import java.util.ArrayList;

/**
 *
 * @author bryam
 */
public class MostrarInicio_test {

   
    public static void main(String[] args) {
        fusuario udao = new fusuario();
        ArrayList<vusuario> listaUsuario = udao.mostrarInicio();
        
        for(vusuario u : listaUsuario){
            System.out.println(u);
        }

    }
    
}
