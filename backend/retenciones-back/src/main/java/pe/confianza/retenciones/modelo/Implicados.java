package pe.confianza.retenciones.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "IMPLICADOS", catalog = "dbretenciones", schema = "public")

public class Implicados implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@NotNull
	@TableGenerator(name = "TBImplicadoCorr", table = "CORRELATIVOS01", pkColumnName = "descripcion",   valueColumnName = "correlativo", pkColumnValue = "CODIGO_IMPLICADOS", initialValue = 10, allocationSize = 1, schema = "public")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TBImplicadoCorr")
	@Column(name = "idImplicado", nullable = false)
	private Integer idImplicado;
	@Column(name = "pais")
	private Short pais;
	@Column(name = "tipoDoc ")
	private Short tipoDoc;
	@Size(max = 12)
	@Column(name = "numDoc ", length = 12)
	private String numDoc;
	@Size(max = 50)
	@Column(name = "apePaterno", length = 50)
	private String apePaterno;
	@Size(max = 50)
	@Column(name = "apeMaterno", length = 50)
	private String apeMaterno;
	@Size(max = 100)
	@Column(name = "nombres", length = 100)
	private String nombres;
	@Size(max = 100)
	@Column(name = "expediente", length = 100)
	private String expediente;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Column(name = "montoRetencion", precision = 17, scale = 2)
	private BigDecimal montoRetencion;
	@Column(name = "esClienteFc")
	private Short esClienteFc;
	@Size(max = 10)
	@Column(name = "usuarioRegist", length = 10)
	private String usuarioRegist;
	@Column(name = "fechaRegist")
	@Temporal(TemporalType.DATE)
	private Date fechaRegist;
	@Size(max = 8)
	@Column(name = "horaRegist", length = 8)
	private String horaRegist;
	@Column(name = "codFormaCarga")
	private Short codFormaCarga;
	@Size(max = 10)
	@Column(name = "codProdSolic", length = 10)
	private String codProdSolic;
	@Column(name = "estado")
	private Short estado;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idImplicado")
	private List<ImplicadoProductos> implicadoProductosList;
	@JoinColumn(name = "idSolicitud", referencedColumnName = "idSolicitud", nullable = false)
	@ManyToOne(optional = false)
	private Solicitudes idSolicitud;

	public Implicados() {
	}

	public Implicados(Integer idImplicado) {
		this.idImplicado = idImplicado;
	}

	public Integer getIdImplicado() {
		return idImplicado;
	}

	public void setIdImplicado(Integer idImplicado) {
		this.idImplicado = idImplicado;
	}

	public Short getPais() {
		return pais;
	}

	public void setPais(Short pais) {
		this.pais = pais;
	}

	public Short getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(Short tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public String getNumDoc() {
		return numDoc;
	}

	public void setNumDoc(String numDoc) {
		this.numDoc = numDoc;
	}

	public String getApePaterno() {
		return apePaterno;
	}

	public void setApePaterno(String apePaterno) {
		this.apePaterno = apePaterno;
	}

	public String getApeMaterno() {
		return apeMaterno;
	}

	public void setApeMaterno(String apeMaterno) {
		this.apeMaterno = apeMaterno;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getExpediente() {
		return expediente;
	}

	public void setExpediente(String expediente) {
		this.expediente = expediente;
	}

	public BigDecimal getMontoRetencion() {
		return montoRetencion;
	}

	public void setMontoRetencion(BigDecimal montoRetencion) {
		this.montoRetencion = montoRetencion;
	}

	public Short getEsClienteFc() {
		return esClienteFc;
	}

	public void setEsClienteFc(Short esClienteFc) {
		this.esClienteFc = esClienteFc;
	}

	public String getUsuarioRegist() {
		return usuarioRegist;
	}

	public void setUsuarioRegist(String usuarioRegist) {
		this.usuarioRegist = usuarioRegist;
	}

	public Date getFechaRegist() {
		return fechaRegist;
	}

	public void setFechaRegist(Date fechaRegist) {
		this.fechaRegist = fechaRegist;
	}

	public String getHoraRegist() {
		return horaRegist;
	}

	public void setHoraRegist(String horaRegist) {
		this.horaRegist = horaRegist;
	}

	public Short getCodFormaCarga() {
		return codFormaCarga;
	}

	public void setCodFormaCarga(Short codFormaCarga) {
		this.codFormaCarga = codFormaCarga;
	}

	public String getCodProdSolic() {
		return codProdSolic;
	}

	public void setCodProdSolic(String codProdSolic) {
		this.codProdSolic = codProdSolic;
	}

	public Short getEstado() {
		return estado;
	}

	public void setEstado(Short estado) {
		this.estado = estado;
	}

	@XmlTransient
	public List<ImplicadoProductos> getImplicadoProductosList() {
		return implicadoProductosList;
	}

	public void setImplicadoProductosList(List<ImplicadoProductos> implicadoProductosList) {
		this.implicadoProductosList = implicadoProductosList;
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
		hash += (idImplicado != null ? idImplicado.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Implicados)) {
			return false;
		}
		Implicados other = (Implicados) object;
		if ((this.idImplicado == null && other.idImplicado != null)
				|| (this.idImplicado != null && !this.idImplicado.equals(other.idImplicado))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.opensys.pruebaposgret001.Implicados[ idImplicado=" + idImplicado + " ]";
	}

}
