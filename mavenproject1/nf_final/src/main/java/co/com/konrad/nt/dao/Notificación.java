/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.konrad.nt.dao;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ADGS
 */
@Entity
@Table(name = "notificaci\u00f3n")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notificaci\u00f3n.findAll", query = "SELECT n FROM Notificaci\u00f3n n"),
    @NamedQuery(name = "Notificaci\u00f3n.findByNotificacionId", query = "SELECT n FROM Notificaci\u00f3n n WHERE n.notificacionId = :notificacionId"),
    @NamedQuery(name = "Notificaci\u00f3n.findByNotificacionDescripci\u00f3n", query = "SELECT n FROM Notificaci\u00f3n n WHERE n.notificacionDescripci\u00f3n = :notificacionDescripci\u00f3n"),
    @NamedQuery(name = "Notificaci\u00f3n.findByNotificaci\u00f3nEstado", query = "SELECT n FROM Notificaci\u00f3n n WHERE n.notificaci\u00f3nEstado = :notificaci\u00f3nEstado")})
public class Notificación implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "notificacion_id")
    private Integer notificacionId;
    @Size(max = 100)
    @Column(name = "notificacion_descripci\u00f3n")
    private String notificacionDescripción;
    @Size(max = 2)
    @Column(name = "notificaci\u00f3n_estado")
    private String notificaciónEstado;
    @JoinColumn(name = "compra_compra_id", referencedColumnName = "compra_id")
    @ManyToOne(optional = false)
    private Compra compraCompraId;

    public Notificación() {
    }

    public Notificación(Integer notificacionId) {
        this.notificacionId = notificacionId;
    }

    public Integer getNotificacionId() {
        return notificacionId;
    }

    public void setNotificacionId(Integer notificacionId) {
        this.notificacionId = notificacionId;
    }

    public String getNotificacionDescripción() {
        return notificacionDescripción;
    }

    public void setNotificacionDescripción(String notificacionDescripción) {
        this.notificacionDescripción = notificacionDescripción;
    }

    public String getNotificaciónEstado() {
        return notificaciónEstado;
    }

    public void setNotificaciónEstado(String notificaciónEstado) {
        this.notificaciónEstado = notificaciónEstado;
    }

    public Compra getCompraCompraId() {
        return compraCompraId;
    }

    public void setCompraCompraId(Compra compraCompraId) {
        this.compraCompraId = compraCompraId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (notificacionId != null ? notificacionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notificación)) {
            return false;
        }
        Notificación other = (Notificación) object;
        if ((this.notificacionId == null && other.notificacionId != null) || (this.notificacionId != null && !this.notificacionId.equals(other.notificacionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.konrad.nt.dao.Notificaci\u00f3n[ notificacionId=" + notificacionId + " ]";
    }
    
}
