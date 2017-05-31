/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.konrad.nt.dao;

/**
 *
 * @author DesarrolloMovil_1
 */
public class UsuarioInput {
    
    private String usuario;
    private String clave;

    public UsuarioInput() {
    }

    public UsuarioInput(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }

    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "UsuarioInput{" + "usuario=" + usuario + ", clave=" + clave + '}';
    }
}
