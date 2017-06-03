/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.konrad.nt.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DesarrolloMovil_1
 */
@Entity
@Table(name = "imagen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Imagen.findAll", query = "SELECT i FROM Imagen i")
    , @NamedQuery(name = "Imagen.findByImagenId", query = "SELECT i FROM Imagen i WHERE i.imagenId = :imagenId")
    , @NamedQuery(name = "Imagen.findByImagenNombre", query = "SELECT i FROM Imagen i WHERE i.imagenNombre = :imagenNombre")
    , @NamedQuery(name = "Imagen.findByImagenDescripcion", query = "SELECT i FROM Imagen i WHERE i.imagenDescripcion = :imagenDescripcion")
    , @NamedQuery(name = "Imagen.findByImagenFecha", query = "SELECT i FROM Imagen i WHERE i.imagenFecha = :imagenFecha")
    , @NamedQuery(name = "Imagen.findByImagenEstado", query = "SELECT i FROM Imagen i WHERE i.imagenEstado = :imagenEstado")
    , @NamedQuery(name = "Imagen.findByImagenCosto", query = "SELECT i FROM Imagen i WHERE i.imagenCosto = :imagenCosto")
    , @NamedQuery(name = "Imagen.findByImagenMin", query = "SELECT i FROM Imagen i WHERE i.imagenMin = :imagenMin")
    , @NamedQuery(name = "Imagen.findByImagenFull", query = "SELECT i FROM Imagen i WHERE i.imagenFull = :imagenFull")})
public class Imagen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "imagen_id")
    private Integer imagenId;
    @Size(max = 45)
    @Column(name = "imagen_nombre")
    private String imagenNombre;
    @Size(max = 100)
    @Column(name = "imagen_descripcion")
    private String imagenDescripcion;
    @Column(name = "imagen_fecha")
    @Temporal(TemporalType.DATE)
    private Date imagenFecha;
    @Size(max = 2)
    @Column(name = "imagen_estado")
    private String imagenEstado;
    @Column(name = "imagen_costo")
    private Integer imagenCosto;
    @Size(max = 45)
    @Column(name = "imagen_min")
    private String imagenMin;
    @Size(max = 45)
    @Column(name = "imagen_full")
    private String imagenFull;
    @JoinTable(name = "like", joinColumns = {
        @JoinColumn(name = "imagen_imagen_id", referencedColumnName = "imagen_id")}, inverseJoinColumns = {
        @JoinColumn(name = "usuario_usuario_id", referencedColumnName = "usuario_id")})
    @ManyToMany
    private Collection<Usuario> usuarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "imagenImagenId")
    private Collection<Compra> compraCollection;
    @JoinColumn(name = "usuario_usuario_id", referencedColumnName = "usuario_id")
    @ManyToOne(optional = false)
    private Usuario usuarioUsuarioId;

    public Imagen() {
    }

    public Imagen(Integer imagenId) {
        this.imagenId = imagenId;
    }

    public Integer getImagenId() {
        return imagenId;
    }

    public void setImagenId(Integer imagenId) {
        this.imagenId = imagenId;
    }

    public String getImagenNombre() {
        return imagenNombre;
    }

    public void setImagenNombre(String imagenNombre) {
        this.imagenNombre = imagenNombre;
    }

    public String getImagenDescripcion() {
        return imagenDescripcion;
    }

    public void setImagenDescripcion(String imagenDescripcion) {
        this.imagenDescripcion = imagenDescripcion;
    }

    public Date getImagenFecha() {
        return imagenFecha;
    }

    public void setImagenFecha(Date imagenFecha) {
        this.imagenFecha = imagenFecha;
    }

    public String getImagenEstado() {
        return imagenEstado;
    }

    public void setImagenEstado(String imagenEstado) {
        this.imagenEstado = imagenEstado;
    }

    public Integer getImagenCosto() {
        return imagenCosto;
    }

    public void setImagenCosto(Integer imagenCosto) {
        this.imagenCosto = imagenCosto;
    }

    public String getImagenMin() {
        return imagenMin;
    }

    public void setImagenMin(String imagenMin) {
        this.imagenMin = imagenMin;
    }

    public String getImagenFull() {
        return imagenFull;
    }

    public void setImagenFull(String imagenFull) {
        this.imagenFull = imagenFull;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @XmlTransient
    public Collection<Compra> getCompraCollection() {
        return compraCollection;
    }

    public void setCompraCollection(Collection<Compra> compraCollection) {
        this.compraCollection = compraCollection;
    }

    public Usuario getUsuarioUsuarioId() {
        return usuarioUsuarioId;
    }

    public void setUsuarioUsuarioId(Usuario usuarioUsuarioId) {
        this.usuarioUsuarioId = usuarioUsuarioId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (imagenId != null ? imagenId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Imagen)) {
            return false;
        }
        Imagen other = (Imagen) object;
        if ((this.imagenId == null && other.imagenId != null) || (this.imagenId != null && !this.imagenId.equals(other.imagenId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Imagen{" + "imagenId=" + imagenId + ", imagenNombre=" + imagenNombre + ", imagenDescripcion=" + imagenDescripcion + ", imagenFecha=" + imagenFecha + ", imagenEstado=" + imagenEstado + ", imagenCosto=" + imagenCosto + ", imagenMin=" + imagenMin + ", imagenFull=" + imagenFull + ", usuarioCollection=" + usuarioCollection + ", compraCollection=" + compraCollection + ", usuarioUsuarioId=" + usuarioUsuarioId + '}';
    }


    
}
