package pe.confianza.retenciones.modelo;



import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 *
 * @author JSJACOBE
 */
@Entity
@Table(name = "CORRELATIVOS", catalog = "dbretenciones", schema = "public")

public class Correlativos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCorrelativo", nullable = false)
    private Integer idCorrelativo;
    @Size(max = 250)
    @Column(name = "descripcion", length = 250)
    private String descripcion;
    @Column(name = "correlativo")
    private Integer correlativo;
    @Column(name = "codEstado")
    private Short codEstado;

    public Correlativos() {
    }

    public Correlativos(Integer idCorrelativo) {
        this.idCorrelativo = idCorrelativo;
    }

    public Integer getIdCorrelativo() {
        return idCorrelativo;
    }

    public void setIdCorrelativo(Integer idCorrelativo) {
        this.idCorrelativo = idCorrelativo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(Integer correlativo) {
        this.correlativo = correlativo;
    }

    public Short getCodEstado() {
        return codEstado;
    }

    public void setCodEstado(Short codEstado) {
        this.codEstado = codEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCorrelativo != null ? idCorrelativo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Correlativos)) {
            return false;
        }
        Correlativos other = (Correlativos) object;
        if ((this.idCorrelativo == null && other.idCorrelativo != null) || (this.idCorrelativo != null && !this.idCorrelativo.equals(other.idCorrelativo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.opensys.pruebaposgret001.Correlativos[ idCorrelativo=" + idCorrelativo + " ]";
    }
    
}
