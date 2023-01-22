
package Pruebas;

import Control_BD.fusuario;
import Control_BD.vusuario;



/**
 *
 * @author bryam
 */
public class Login_test {


    public static void main(String[] args) {
        
        fusuario udao = new fusuario();
        vusuario usu = udao.loginUsuario("admin", "admin");
     
        System.out.println(usu);

    }
    
}
