/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.konrad.nt.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ADGS
 */
@XmlRootElement
public class UsuarioDTO {
    
    private Integer id;
    private String usuario;
    private String clave;
    private String nombre;
    private String avatar;

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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    } 

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" + "id=" + id + ", usuario=" + usuario + ", nombre=" + nombre + ", avatar=" + avatar + '}';
    }
    
}
