/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Control_BD;

/**
 *
 * @author richard
 */
public class vusuario {
    
    private int id;
    private int dni;
    private String usuario;
    private String password;
    private String tipo;
    private String nombres;
    private String apellidos;
    private int telefono;

    public vusuario() {
    }

    public vusuario(int id, int dni, String usuario, String password, String tipo, String nombres, String apellidos, int telefono) {
        this.id = id;
        this.dni = dni;
        this.usuario = usuario;
        this.password = password;
        this.tipo = tipo;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
    }
    
    

    public vusuario(int dni) {
        this.dni = dni;
    }

    public int getdni() {
        return dni;
    }

    public void setdni(int dni) {
        this.dni = dni;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * @param nombres the nombres to set
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the telefono
     */
    public int getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "vusuario{" + "id=" + id + ", dni=" + dni + ", usuario=" + usuario + ", password=" + password + ", tipo=" + tipo + ", nombres=" + nombres + ", apellidos=" + apellidos + ", telefono=" + telefono + '}';
    }

    public void setTipo(int tipo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
