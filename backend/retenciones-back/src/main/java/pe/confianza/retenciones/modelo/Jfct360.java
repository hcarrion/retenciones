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
@Table(name = "JFCT360", catalog = "dbretenciones", schema = "public")

public class Jfct360 implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected Jfct360PK idCodigo;
    @Column(name = "CT360NUM")
    private Integer numero;
    @Size(max = 90)
    @Column(name = "CT360DESC", length = 90)
    private String descripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CT360IMP", precision = 17, scale = 2)
    private BigDecimal importe;
    @Column(name = "CT360FECH")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    public Jfct360() {
    }

    public Jfct360(Jfct360PK idCodigo) {
        this.idCodigo = idCodigo;
    }

    public Jfct360(int codigo, short correlativo) {
        this.idCodigo = new Jfct360PK(codigo, correlativo);
    }

	public Jfct360PK getIdCodigo() {
		return idCodigo;
	}

	public void setIdCodigo(Jfct360PK idCodigo) {
		this.idCodigo = idCodigo;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
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
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((idCodigo == null) ? 0 : idCodigo.hashCode());
		result = prime * result + ((importe == null) ? 0 : importe.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
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
		Jfct360 other = (Jfct360) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (idCodigo == null) {
			if (other.idCodigo != null)
				return false;
		} else if (!idCodigo.equals(other.idCodigo))
			return false;
		if (importe == null) {
			if (other.importe != null)
				return false;
		} else if (!importe.equals(other.importe))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Jfct360 [idCodigo=" + idCodigo + ", numero=" + numero + ", descripcion=" + descripcion + ", importe="
				+ importe + ", fecha=" + fecha + "]";
	}

}
