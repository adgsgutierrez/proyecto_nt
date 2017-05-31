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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DesarrolloMovil_1
 */
@Entity
@Table(name = "tarjeta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tarjeta.findAll", query = "SELECT t FROM Tarjeta t")
    , @NamedQuery(name = "Tarjeta.findByTarjetaNumero", query = "SELECT t FROM Tarjeta t WHERE t.tarjetaNumero = :tarjetaNumero")
    , @NamedQuery(name = "Tarjeta.findByTarjetaCvc", query = "SELECT t FROM Tarjeta t WHERE t.tarjetaCvc = :tarjetaCvc")
    , @NamedQuery(name = "Tarjeta.findByTarjetaFecha", query = "SELECT t FROM Tarjeta t WHERE t.tarjetaFecha = :tarjetaFecha")})
public class Tarjeta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "tarjeta_numero")
    private Integer tarjetaNumero;
    @Column(name = "tarjeta_cvc")
    private Integer tarjetaCvc;
    @Column(name = "tarjeta_fecha")
    @Temporal(TemporalType.DATE)
    private Date tarjetaFecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tarjetaTarjetaNumero")
    private Collection<Compra> compraCollection;
    @JoinColumn(name = "usuario_usuario_id", referencedColumnName = "usuario_id")
    @ManyToOne(optional = false)
    private Usuario usuarioUsuarioId;

    public Tarjeta() {
    }

    public Tarjeta(Integer tarjetaNumero) {
        this.tarjetaNumero = tarjetaNumero;
    }

    public Integer getTarjetaNumero() {
        return tarjetaNumero;
    }

    public void setTarjetaNumero(Integer tarjetaNumero) {
        this.tarjetaNumero = tarjetaNumero;
    }

    public Integer getTarjetaCvc() {
        return tarjetaCvc;
    }

    public void setTarjetaCvc(Integer tarjetaCvc) {
        this.tarjetaCvc = tarjetaCvc;
    }

    public Date getTarjetaFecha() {
        return tarjetaFecha;
    }

    public void setTarjetaFecha(Date tarjetaFecha) {
        this.tarjetaFecha = tarjetaFecha;
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
        hash += (tarjetaNumero != null ? tarjetaNumero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tarjeta)) {
            return false;
        }
        Tarjeta other = (Tarjeta) object;
        if ((this.tarjetaNumero == null && other.tarjetaNumero != null) || (this.tarjetaNumero != null && !this.tarjetaNumero.equals(other.tarjetaNumero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.konrad.nt.entities.Tarjeta[ tarjetaNumero=" + tarjetaNumero + " ]";
    }
    
}
