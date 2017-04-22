/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.konrad.nt.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
 * @author ADGS
 */
@Entity
@Table(name = "compra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Compra.findAll", query = "SELECT c FROM Compra c"),
    @NamedQuery(name = "Compra.findByCompraId", query = "SELECT c FROM Compra c WHERE c.compraId = :compraId"),
    @NamedQuery(name = "Compra.findByCompraFecha", query = "SELECT c FROM Compra c WHERE c.compraFecha = :compraFecha"),
    @NamedQuery(name = "Compra.findByCompraEstado", query = "SELECT c FROM Compra c WHERE c.compraEstado = :compraEstado"),
    @NamedQuery(name = "Compra.findByCompraCalificacion", query = "SELECT c FROM Compra c WHERE c.compraCalificacion = :compraCalificacion")})
public class Compra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "compra_id")
    private Integer compraId;
    @Column(name = "compra_fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date compraFecha;
    @Size(max = 2)
    @Column(name = "compra_estado")
    private String compraEstado;
    @Column(name = "compra_calificacion")
    private Integer compraCalificacion;
    @JoinColumn(name = "imagen_imagen_id", referencedColumnName = "imagen_id")
    @ManyToOne(optional = false)
    private Imagen imagenImagenId;
    @JoinColumn(name = "tarjeta_tarjeta_numero", referencedColumnName = "tarjeta_numero")
    @ManyToOne(optional = false)
    private Tarjeta tarjetaTarjetaNumero;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compraCompraId")
    private Collection<Notificación> notificaciónCollection;

    public Compra() {
    }

    public Compra(Integer compraId) {
        this.compraId = compraId;
    }

    public Integer getCompraId() {
        return compraId;
    }

    public void setCompraId(Integer compraId) {
        this.compraId = compraId;
    }

    public Date getCompraFecha() {
        return compraFecha;
    }

    public void setCompraFecha(Date compraFecha) {
        this.compraFecha = compraFecha;
    }

    public String getCompraEstado() {
        return compraEstado;
    }

    public void setCompraEstado(String compraEstado) {
        this.compraEstado = compraEstado;
    }

    public Integer getCompraCalificacion() {
        return compraCalificacion;
    }

    public void setCompraCalificacion(Integer compraCalificacion) {
        this.compraCalificacion = compraCalificacion;
    }

    public Imagen getImagenImagenId() {
        return imagenImagenId;
    }

    public void setImagenImagenId(Imagen imagenImagenId) {
        this.imagenImagenId = imagenImagenId;
    }

    public Tarjeta getTarjetaTarjetaNumero() {
        return tarjetaTarjetaNumero;
    }

    public void setTarjetaTarjetaNumero(Tarjeta tarjetaTarjetaNumero) {
        this.tarjetaTarjetaNumero = tarjetaTarjetaNumero;
    }

    @XmlTransient
    public Collection<Notificación> getNotificaciónCollection() {
        return notificaciónCollection;
    }

    public void setNotificaciónCollection(Collection<Notificación> notificaciónCollection) {
        this.notificaciónCollection = notificaciónCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (compraId != null ? compraId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compra)) {
            return false;
        }
        Compra other = (Compra) object;
        if ((this.compraId == null && other.compraId != null) || (this.compraId != null && !this.compraId.equals(other.compraId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.konrad.nt.dao.Compra[ compraId=" + compraId + " ]";
    }
    
}
