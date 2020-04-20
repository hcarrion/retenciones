package pe.confianza.retenciones.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author JSJACOBE
 */
@Entity
@Table(name = "CARTAS", catalog = "dbretenciones", schema = "public")

public class Cartas implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@NotNull
	//@TableGenerator(name = "TBCartaCorr", table = "CORRELATIVOS01", pkColumnName = "descripcion", valueColumnName = "CODIGO_CARTAS", pkColumnValue = "correlativo", initialValue = 10, allocationSize = 1, schema = "public")
	//@GeneratedValue(strategy = GenerationType.TABLE, generator = "TBCartaCorr")
	@TableGenerator(name = "TBCartaCorr", table = "CORRELATIVOS01", pkColumnName = "descripcion", valueColumnName = "correlativo", pkColumnValue = "CODIGO_CARTAS", initialValue = 10, allocationSize = 1, schema = "public")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TBCartaCorr")
	@Column(name = "idCarta", nullable = false)
	private Integer idCarta;
	@Size(max = 250)
	@Column(name = "descripcion", length = 250)
	private String descripcion;
	@Size(max = 120)
	@Column(name = "descripcionCorta", length = 120)
	private String descripcionCorta;
	@Column(name = "codEstadoCarta")
	private Short codEstadoCarta;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idCarta")
	private List<Solicitudes> solicitudesList;

	public Cartas() {
	}

	public Cartas(Integer idCarta) {
		this.idCarta = idCarta;
	}

	public Integer getIdCarta() {
		return idCarta;
	}

	public void setIdCarta(Integer idCarta) {
		this.idCarta = idCarta;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcionCorta() {
		return descripcionCorta;
	}

	public void setDescripcionCorta(String descripcionCorta) {
		this.descripcionCorta = descripcionCorta;
	}

	public Short getCodEstadoCarta() {
		return codEstadoCarta;
	}

	public void setCodEstadoCarta(Short codEstadoCarta) {
		this.codEstadoCarta = codEstadoCarta;
	}

	@XmlTransient
	public List<Solicitudes> getSolicitudesList() {
		return solicitudesList;
	}

	public void setSolicitudesList(List<Solicitudes> solicitudesList) {
		this.solicitudesList = solicitudesList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idCarta != null ? idCarta.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Cartas)) {
			return false;
		}
		Cartas other = (Cartas) object;
		if ((this.idCarta == null && other.idCarta != null)
				|| (this.idCarta != null && !this.idCarta.equals(other.idCarta))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.opensys.pruebaposgret001.Cartas[ idCarta=" + idCarta + " ]";
	}

}
