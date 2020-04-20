package pe.confianza.retenciones.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author JSJACOBE
 */
@Entity
@Table(name = "EVENTOS", catalog = "dbretenciones", schema = "public")

public class Eventos implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@NotNull
	@TableGenerator(name = "TBEventoCorr", table = "CORRELATIVOS01", pkColumnName = "descripcion",   valueColumnName = "correlativo", pkColumnValue = "CODIGO_EVENTOS", initialValue = 10, allocationSize = 1, schema = "public")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TBEventoCorr")
	@Column(name = "idEvento", nullable = false)
	private Integer idEvento;
	@Column(name = "codProcesEjecut")
	private Short codProcesEjecut;
	@Column(name = "codEstadoSolicit")
	private Short codEstadoSolicit;
	@Column(name = "codSubEstdSolicit")
	private Short codSubEstdSolicit;
	@Size(max = 500)
	@Column(name = "comentario", length = 500)
	private String comentario;
	@Size(max = 10)
	@Column(name = "usuarioProceso", length = 10)
	private String usuarioProceso;
	@Column(name = "fechaIniProceso")
	@Temporal(TemporalType.DATE)
	private Date fechaIniProceso;
	@Size(max = 8)
	@Column(name = "horaIniProeceso", length = 8)
	private String horaIniProeceso;
	@Column(name = "fechaFinProceso")
	@Temporal(TemporalType.DATE)
	private Date fechaFinProceso;
	@Size(max = 8)
	@Column(name = "foraFinProeceso", length = 8)
	private String foraFinProeceso;
	@JoinColumn(name = "idSolicitud", referencedColumnName = "idSolicitud", nullable = false)
	@ManyToOne(optional = false)
	private Solicitudes idSolicitud;

	public Eventos() {
	}

	public Eventos(Integer idEvento) {
		this.idEvento = idEvento;
	}

	public Integer getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(Integer idEvento) {
		this.idEvento = idEvento;
	}

	public Short getCodProcesEjecut() {
		return codProcesEjecut;
	}

	public void setCodProcesEjecut(Short codProcesEjecut) {
		this.codProcesEjecut = codProcesEjecut;
	}

	public Short getCodEstadoSolicit() {
		return codEstadoSolicit;
	}

	public void setCodEstadoSolicit(Short codEstadoSolicit) {
		this.codEstadoSolicit = codEstadoSolicit;
	}

	public Short getCodSubEstdSolicit() {
		return codSubEstdSolicit;
	}

	public void setCodSubEstdSolicit(Short codSubEstdSolicit) {
		this.codSubEstdSolicit = codSubEstdSolicit;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getUsuarioProceso() {
		return usuarioProceso;
	}

	public void setUsuarioProceso(String usuarioProceso) {
		this.usuarioProceso = usuarioProceso;
	}

	public Date getFechaIniProceso() {
		return fechaIniProceso;
	}

	public void setFechaIniProceso(Date fechaIniProceso) {
		this.fechaIniProceso = fechaIniProceso;
	}

	public String getHoraIniProeceso() {
		return horaIniProeceso;
	}

	public void setHoraIniProeceso(String horaIniProeceso) {
		this.horaIniProeceso = horaIniProeceso;
	}

	public Date getFechaFinProceso() {
		return fechaFinProceso;
	}

	public void setFechaFinProceso(Date fechaFinProceso) {
		this.fechaFinProceso = fechaFinProceso;
	}

	public String getForaFinProeceso() {
		return foraFinProeceso;
	}

	public void setForaFinProeceso(String foraFinProeceso) {
		this.foraFinProeceso = foraFinProeceso;
	}

	public Solicitudes getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(Solicitudes idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idEvento != null ? idEvento.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Eventos)) {
			return false;
		}
		Eventos other = (Eventos) object;
		if ((this.idEvento == null && other.idEvento != null)
				|| (this.idEvento != null && !this.idEvento.equals(other.idEvento))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.opensys.pruebaposgret001.Eventos[ idEvento=" + idEvento + " ]";
	}

}
