/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.konrad.nt.dao;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ADGS
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByUsuarioId", query = "SELECT u FROM Usuario u WHERE u.usuarioId = :usuarioId"),
    @NamedQuery(name = "Usuario.findByUsuarioCorreo", query = "SELECT u FROM Usuario u WHERE u.usuarioCorreo = :usuarioCorreo"),
    @NamedQuery(name = "Usuario.findByUsuarioClave", query = "SELECT u FROM Usuario u WHERE u.usuarioClave = :usuarioClave"),
    @NamedQuery(name = "Usuario.findByUsuarioAvatar", query = "SELECT u FROM Usuario u WHERE u.usuarioAvatar = :usuarioAvatar"),
    @NamedQuery(name = "Usuario.findByUsuarioNombre", query = "SELECT u FROM Usuario u WHERE u.usuarioNombre = :usuarioNombre")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Basic(optional = false)
    @Column(name = "usuario_id")
    private Integer usuarioId;
    @Size(max = 45)
    @Column(name = "usuario_correo")
    private String usuarioCorreo;
    @Size(max = 45)
    @Column(name = "usuario_clave")
    private String usuarioClave;
    @Size(max = 45)
    @Column(name = "usuario_avatar")
    private String usuarioAvatar;
    @Size(max = 45)
    @Column(name = "usuario_nombre")
    private String usuarioNombre;
    
    
    @JoinTable(name = "contacto", joinColumns = {
        @JoinColumn(name = "usuario_contacto", referencedColumnName = "usuario_id")}, inverseJoinColumns = {
        @JoinColumn(name = "usuario_propietario", referencedColumnName = "usuario_id")})
    @ManyToMany
    private Collection<Usuario> usuarioCollection;
    
    @ManyToMany(mappedBy = "usuarioCollection")
    private Collection<Usuario> usuarioCollection1;
    
    @ManyToMany(mappedBy = "usuarioCollection")
    private Collection<Imagen> imagenCollection;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioUsuarioId")
    private Collection<Imagen> imagenCollection1;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioUsuarioId")
    private Collection<Tarjeta> tarjetaCollection;

    public Usuario() {
    }

    public Usuario(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getUsuarioCorreo() {
        return usuarioCorreo;
    }

    public void setUsuarioCorreo(String usuarioCorreo) {
        this.usuarioCorreo = usuarioCorreo;
    }

    public String getUsuarioClave() {
        return usuarioClave;
    }

    public void setUsuarioClave(String usuarioClave) {
        this.usuarioClave = usuarioClave;
    }

    public String getUsuarioAvatar() {
        return usuarioAvatar;
    }

    public void setUsuarioAvatar(String usuarioAvatar) {
        this.usuarioAvatar = usuarioAvatar;
    }

    public String getUsuarioNombre() {
        return usuarioNombre;
    }

    public void setUsuarioNombre(String usuarioNombre) {
        this.usuarioNombre = usuarioNombre;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection1() {
        return usuarioCollection1;
    }

    public void setUsuarioCollection1(Collection<Usuario> usuarioCollection1) {
        this.usuarioCollection1 = usuarioCollection1;
    }

    @XmlTransient
    public Collection<Imagen> getImagenCollection() {
        return imagenCollection;
    }

    public void setImagenCollection(Collection<Imagen> imagenCollection) {
        this.imagenCollection = imagenCollection;
    }

    @XmlTransient
    public Collection<Imagen> getImagenCollection1() {
        return imagenCollection1;
    }

    public void setImagenCollection1(Collection<Imagen> imagenCollection1) {
        this.imagenCollection1 = imagenCollection1;
    }

    @XmlTransient
    public Collection<Tarjeta> getTarjetaCollection() {
        return tarjetaCollection;
    }

    public void setTarjetaCollection(Collection<Tarjeta> tarjetaCollection) {
        this.tarjetaCollection = tarjetaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioId != null ? usuarioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.usuarioId == null && other.usuarioId != null) || (this.usuarioId != null && !this.usuarioId.equals(other.usuarioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.konrad.nt.dao.Usuario[ usuarioId=" + usuarioId + " ]";
    }
    
}
