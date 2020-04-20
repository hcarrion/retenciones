package pe.confianza.retenciones.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author JSJACOBE
 */
@Entity
@Table(name = "SOLICITUDES", catalog = "dbretenciones", schema = "public")

public class Solicitudes implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@NotNull

	@TableGenerator(name = "TBSolicitudCorr", table = "CORRELATIVOS01", pkColumnName = "descripcion",  valueColumnName = "correlativo", pkColumnValue = "CODIGO_SOLICITUDES", initialValue = 10, allocationSize = 1, schema = "public")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TBSolicitudCorr")
	@Column(name = "idSolicitud", nullable = false)
	private Integer idSolicitud;
	@Column(name = "codDctoIngresado")
	private Short codDctoIngresado;
	@Column(name = "codRequerimiento")
	private Short codRequerimiento;
	@Column(name = "codEntidad")
	private Short codEntidad;
	@Size(max = 102)
	@Column(name = "numDocIngresado", length = 102)
	private String numDocIngresado;
	@Column(name = "codPrioridad")
	private Short codPrioridad;
	@Column(name = "diasMaxRpta")
	private Short diasMaxRpta;
	@Column(name = "codAgenRecep")
	private Short codAgenRecep;
	@Column(name = "fechaRecep")
	@Temporal(TemporalType.DATE)
	private Date fechaRecep;
	@Column(name = "codAgenRegis")
	private Short codAgenRegis;
	@Size(max = 10)
	@Column(name = "userRegistro", length = 10)
	private String userRegistro;
	@Column(name = "fechaRegistro")
	@Temporal(TemporalType.DATE)
	private Date fechaRegistro;
	@Size(max = 8)
	@Column(name = "horaRegistro", length = 8)
	private String horaRegistro;
	@Column(name = "cantidadHojas")
	private Short cantidadHojas;
	@Size(max = 900)
	@Column(name = "textoRespuesta", length = 900)
	private String textoRespuesta;
	@Column(name = "idSecuenciaEventoUlti")
	private Integer idSecuenciaEventoUlti;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idSolicitud")
	private List<Eventos> eventosList;
	@JoinColumn(name = "idCarta", referencedColumnName = "idCarta", nullable = false)
	@ManyToOne(optional = false)
	private Cartas idCarta;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idSolicitud")
	private List<Documentos> documentosList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idSolicitud")
	private List<Implicados> implicadosList;

	public Solicitudes() {
	}

	public Solicitudes(Integer idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public Integer getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(Integer idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public Short getCodDctoIngresado() {
		return codDctoIngresado;
	}

	public void setCodDctoIngresado(Short codDctoIngresado) {
		this.codDctoIngresado = codDctoIngresado;
	}

	public Short getCodRequerimiento() {
		return codRequerimiento;
	}

	public void setCodRequerimiento(Short codRequerimiento) {
		this.codRequerimiento = codRequerimiento;
	}

	public Short getCodEntidad() {
		return codEntidad;
	}

	public void setCodEntidad(Short codEntidad) {
		this.codEntidad = codEntidad;
	}

	public String getNumDocIngresado() {
		return numDocIngresado;
	}

	public void setNumDocIngresado(String numDocIngresado) {
		this.numDocIngresado = numDocIngresado;
	}

	public Short getCodPrioridad() {
		return codPrioridad;
	}

	public void setCodPrioridad(Short codPrioridad) {
		this.codPrioridad = codPrioridad;
	}

	public Short getDiasMaxRpta() {
		return diasMaxRpta;
	}

	public void setDiasMaxRpta(Short diasMaxRpta) {
		this.diasMaxRpta = diasMaxRpta;
	}

	public Short getCodAgenRecep() {
		return codAgenRecep;
	}

	public void setCodAgenRecep(Short codAgenRecep) {
		this.codAgenRecep = codAgenRecep;
	}

	public Date getFechaRecep() {
		return fechaRecep;
	}

	public void setFechaRecep(Date fechaRecep) {
		this.fechaRecep = fechaRecep;
	}

	public Short getCodAgenRegis() {
		return codAgenRegis;
	}

	public void setCodAgenRegis(Short codAgenRegis) {
		this.codAgenRegis = codAgenRegis;
	}

	public String getUserRegistro() {
		return userRegistro;
	}

	public void setUserRegistro(String userRegistro) {
		this.userRegistro = userRegistro;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getHoraRegistro() {
		return horaRegistro;
	}

	public void setHoraRegistro(String horaRegistro) {
		this.horaRegistro = horaRegistro;
	}

	public Short getCantidadHojas() {
		return cantidadHojas;
	}

	public void setCantidadHojas(Short cantidadHojas) {
		this.cantidadHojas = cantidadHojas;
	}

	public String getTextoRespuesta() {
		return textoRespuesta;
	}

	public void setTextoRespuesta(String textoRespuesta) {
		this.textoRespuesta = textoRespuesta;
	}

	public Integer getIdSecuenciaEventoUlti() {
		return idSecuenciaEventoUlti;
	}

	public void setIdSecuenciaEventoUlti(Integer idSecuenciaEventoUlti) {
		this.idSecuenciaEventoUlti = idSecuenciaEventoUlti;
	}

	@XmlTransient
	public List<Eventos> getEventosList() {
		return eventosList;
	}

	public void setEventosList(List<Eventos> eventosList) {
		this.eventosList = eventosList;
	}

	public Cartas getIdCarta() {
		return idCarta;
	}

	public void setIdCarta(Cartas idCarta) {
		this.idCarta = idCarta;
	}

	@XmlTransient
	public List<Documentos> getDocumentosList() {
		return documentosList;
	}

	public void setDocumentosList(List<Documentos> documentosList) {
		this.documentosList = documentosList;
	}

	@XmlTransient
	public List<Implicados> getImplicadosList() {
		return implicadosList;
	}

	public void setImplicadosList(List<Implicados> implicadosList) {
		this.implicadosList = implicadosList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idSolicitud != null ? idSolicitud.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Solicitudes)) {
			return false;
		}
		Solicitudes other = (Solicitudes) object;
		if ((this.idSolicitud == null && other.idSolicitud != null)
				|| (this.idSolicitud != null && !this.idSolicitud.equals(other.idSolicitud))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.opensys.pruebaposgret001.Solicitudes[ idSolicitud=" + idSolicitud + " ]";
	}

}
