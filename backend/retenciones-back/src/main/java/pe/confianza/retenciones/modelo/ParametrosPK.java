package pe.confianza.retenciones.modelo;



import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author JSJACOBE
 */
@Embeddable
public class ParametrosPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo", nullable = false)
    private int codigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "correlativo", nullable = false)
    private short correlativo;

    public ParametrosPK() {
    }

    public ParametrosPK(int codigo, short correlativo) {
        this.codigo = codigo;
        this.correlativo = correlativo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public short getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(short correlativo) {
        this.correlativo = correlativo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigo;
        hash += (int) correlativo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParametrosPK)) {
            return false;
        }
        ParametrosPK other = (ParametrosPK) object;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (this.correlativo != other.correlativo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.opensys.pruebaposgret001.ParametrosPK[ codigo=" + codigo + ", correlativo=" + correlativo + " ]";
    }
    
}
