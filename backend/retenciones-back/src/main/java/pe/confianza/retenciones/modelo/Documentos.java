package pe.confianza.retenciones.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "DOCUMENTOS", catalog = "dbretenciones", schema = "public")

public class Documentos implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@NotNull
	@TableGenerator(
			name = "TBDocumentoCorr"
			, table = "CORRELATIVOS01"
			, pkColumnName = "descripcion"
			, valueColumnName = "correlativo" 
			, pkColumnValue  = "CODIGO_DOCUMENTOS"
			, initialValue = 10
			, allocationSize = 1
			, schema = "public")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TBDocumentoCorr")
	@Column(name = "idDocumento", nullable = false)
	private Integer idDocumento;
	@Size(max = 500)
	@Column(name = "descripci\u00f3n", length = 500)
	private String descripción;
	@Size(max = 500)
	@Column(name = "ruta", length = 500)
	private String ruta;
	@Lob
	@Column(name = "adjunto")
	private byte[] adjunto;
	@Column(name = "codEstadoAdjunto")
	private Short codEstadoAdjunto;
	@Size(max = 10)
	@Column(name = "usuarioAdjunto", length = 10)
	private String usuarioAdjunto;
	@Column(name = "fechaAdjunto")
	@Temporal(TemporalType.DATE)
	private Date fechaAdjunto;
	@Size(max = 8)
	@Column(name = "horaAdjunto", length = 8)
	private String horaAdjunto;
	@Size(max = 100)
	@Column(name = "idDoc", length = 100)
	private String idDoc;
	@JoinColumn(name = "idSolicitud", referencedColumnName = "idSolicitud", nullable = false)
	@ManyToOne(optional = false)
	private Solicitudes idSolicitud;

	public Documentos() {
	}

	public Documentos(Integer idDocumento) {
		this.idDocumento = idDocumento;
	}

	public Integer getIdDocumento() {
		return idDocumento;
	}

	public void setIdDocumento(Integer idDocumento) {
		this.idDocumento = idDocumento;
	}

	public String getDescripción() {
		return descripción;
	}

	public void setDescripción(String descripción) {
		this.descripción = descripción;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public byte[] getAdjunto() {
		return adjunto;
	}

	public void setAdjunto(byte[] adjunto) {
		this.adjunto = adjunto;
	}

	public Short getCodEstadoAdjunto() {
		return codEstadoAdjunto;
	}

	public void setCodEstadoAdjunto(Short codEstadoAdjunto) {
		this.codEstadoAdjunto = codEstadoAdjunto;
	}

	public String getUsuarioAdjunto() {
		return usuarioAdjunto;
	}

	public void setUsuarioAdjunto(String usuarioAdjunto) {
		this.usuarioAdjunto = usuarioAdjunto;
	}

	public Date getFechaAdjunto() {
		return fechaAdjunto;
	}

	public void setFechaAdjunto(Date fechaAdjunto) {
		this.fechaAdjunto = fechaAdjunto;
	}

	public String getHoraAdjunto() {
		return horaAdjunto;
	}

	public void setHoraAdjunto(String horaAdjunto) {
		this.horaAdjunto = horaAdjunto;
	}

	public String getIdDoc() {
		return idDoc;
	}

	public void setIdDoc(String idDoc) {
		this.idDoc = idDoc;
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
		hash += (idDocumento != null ? idDocumento.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Documentos)) {
			return false;
		}
		Documentos other = (Documentos) object;
		if ((this.idDocumento == null && other.idDocumento != null)
				|| (this.idDocumento != null && !this.idDocumento.equals(other.idDocumento))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.opensys.pruebaposgret001.Documentos[ idDocumento=" + idDocumento + " ]";
	}

}
