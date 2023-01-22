
package Pruebas;

import Control_BD.fusuario;
import Control_BD.vusuario;



public class InsertarUsuario_test {

    
    public static void main(String[] args) {
        
        fusuario udao = new fusuario();
        vusuario u = new vusuario();
        
        u.setNombres("pablo11");
        u.setApellidos("romero11");
        u.setUsuario("pablo111");
        u.setPassword("12345");
        u.setTelefono(123456);
        u.setdni(12457845);
        u.setTipo("2"); 
        
        udao.insertarUsuario(u);
        System.out.println(u);
    }
    
}
