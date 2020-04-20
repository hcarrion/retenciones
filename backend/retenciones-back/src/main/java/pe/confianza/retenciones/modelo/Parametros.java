package pe.confianza.retenciones.modelo;



import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;


/**
 *
 * @author JSJACOBE
 */
@Entity
@Table(name = "PARAMETROS", catalog = "dbretenciones", schema = "public")

public class Parametros implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ParametrosPK parametrosPK;
    @Column(name = "numero")
    private Short numero;
    @Size(max = 90)
    @Column(name = "descripcion", length = 90)
    private String descripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "importe", precision = 17, scale = 2)
    private BigDecimal importe;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    public Parametros() {
    }

    public Parametros(ParametrosPK parametrosPK) {
        this.parametrosPK = parametrosPK;
    }

    public Parametros(int codigo, short correlativo) {
        this.parametrosPK = new ParametrosPK(codigo, correlativo);
    }

    public ParametrosPK getParametrosPK() {
        return parametrosPK;
    }

    public void setParametrosPK(ParametrosPK parametrosPK) {
        this.parametrosPK = parametrosPK;
    }

    public Short getNumero() {
        return numero;
    }

    public void setNumero(Short numero) {
        this.numero = numero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (parametrosPK != null ? parametrosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parametros)) {
            return false;
        }
        Parametros other = (Parametros) object;
        if ((this.parametrosPK == null && other.parametrosPK != null) || (this.parametrosPK != null && !this.parametrosPK.equals(other.parametrosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.opensys.pruebaposgret001.Parametros[ parametrosPK=" + parametrosPK + " ]";
    }
    
}
