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
public class Jfct360PK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "CT360COD", nullable = false)
    private int codigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CT360CORR", nullable = false)
    private short correlativo;

    public Jfct360PK() {
    }

    public Jfct360PK(int codigo, short correlativo) {
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
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		result = prime * result + correlativo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jfct360PK other = (Jfct360PK) obj;
		if (codigo != other.codigo)
			return false;
		if (correlativo != other.correlativo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Jfct360PK [codigo=" + codigo + ", correlativo=" + correlativo + "]";
	}
    
    
    
    
/*
    public int getCt360cod() {
        return ct360cod;
    }

    public void setCt360cod(int ct360cod) {
        this.ct360cod = ct360cod;
    }

    public short getCt360corr() {
        return ct360corr;
    }

    public void setCt360corr(short ct360corr) {
        this.ct360corr = ct360corr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) ct360cod;
        hash += (int) ct360corr;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jfct360PK)) {
            return false;
        }
        Jfct360PK other = (Jfct360PK) object;
        if (this.ct360cod != other.ct360cod) {
            return false;
        }
        if (this.ct360corr != other.ct360corr) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.opensys.pruebaposgret001.Jfct360PK[ ct360cod=" + ct360cod + ", ct360corr=" + ct360corr + " ]";
    }
    */
}

