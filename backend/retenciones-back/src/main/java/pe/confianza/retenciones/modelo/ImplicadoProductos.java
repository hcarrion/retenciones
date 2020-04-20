package pe.confianza.retenciones.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "IMPLICADO_PRODUCTOS", catalog = "dbretenciones", schema = "public")

public class ImplicadoProductos implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@NotNull
	@TableGenerator(name = "TBImplicProducCorr", table = "CORRELATIVOS01", pkColumnName = "descripcion",  valueColumnName = "correlativo", pkColumnValue = "CODIGO_IMPLICADO_PRODUCTOS", initialValue = 10, allocationSize = 1, schema = "public")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TBImplicProducCorr")
	@Column(name = "idProducto", nullable = false)
	private Integer idProducto;
	@Size(max = 120)
	@Column(name = "codProducto", length = 120)
	private String codProducto;
	@Size(max = 180)
	@Column(name = "nomProducto", length = 180)
	private String nomProducto;
	@Column(name = "fechaAltaProd")
	@Temporal(TemporalType.DATE)
	private Date fechaAltaProd;
	@Column(name = "codTipoProducto")
	private Short codTipoProducto;
	@Column(name = "CodEstadoProducto")
	private Short codEstadoProducto;
	@Column(name = "fechaUltimaOper")
	@Temporal(TemporalType.DATE)
	private Date fechaUltimaOper;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Column(name = "monto", precision = 17, scale = 2)
	private BigDecimal monto;
	@Size(max = 10)
	@Column(name = "usuarioConsulta", length = 10)
	private String usuarioConsulta;
	@Column(name = "fechaConsulta")
	@Temporal(TemporalType.DATE)
	private Date fechaConsulta;
	@Size(max = 8)
	@Column(name = "horaConsulta", length = 8)
	private String horaConsulta;
	@Column(name = "codAccionEjecutada")
	private Short codAccionEjecutada;
	@Column(name = "montoEjecutado", precision = 17, scale = 2)
	private BigDecimal montoEjecutado;
	@Size(max = 10)
	@Column(name = "usuarioEjecucion", length = 10)
	private String usuarioEjecucion;
	@Column(name = "fechaEjecucion")
	@Temporal(TemporalType.DATE)
	private Date fechaEjecucion;
	@Size(max = 10)
	@Column(name = "horaEjecucion", length = 10)
	private String horaEjecucion;
	@Column(name = "codProducReportar")
	private Short codProducReportar;
	@Column(name = "codCore")
	private Short codCore;
	@JoinColumn(name = "idImplicado", referencedColumnName = "idImplicado", nullable = false)
	@ManyToOne(optional = false)
	private Implicados idImplicado;

	public ImplicadoProductos() {
	}

	public ImplicadoProductos(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public String getCodProducto() {
		return codProducto;
	}

	public void setCodProducto(String codProducto) {
		this.codProducto = codProducto;
	}

	public String getNomProducto() {
		return nomProducto;
	}

	public void setNomProducto(String nomProducto) {
		this.nomProducto = nomProducto;
	}

	public Date getFechaAltaProd() {
		return fechaAltaProd;
	}

	public void setFechaAltaProd(Date fechaAltaProd) {
		this.fechaAltaProd = fechaAltaProd;
	}

	public Short getCodTipoProducto() {
		return codTipoProducto;
	}

	public void setCodTipoProducto(Short codTipoProducto) {
		this.codTipoProducto = codTipoProducto;
	}

	public Short getCodEstadoProducto() {
		return codEstadoProducto;
	}

	public void setCodEstadoProducto(Short codEstadoProducto) {
		this.codEstadoProducto = codEstadoProducto;
	}

	public Date getFechaUltimaOper() {
		return fechaUltimaOper;
	}

	public void setFechaUltimaOper(Date fechaUltimaOper) {
		this.fechaUltimaOper = fechaUltimaOper;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public String getUsuarioConsulta() {
		return usuarioConsulta;
	}

	public void setUsuarioConsulta(String usuarioConsulta) {
		this.usuarioConsulta = usuarioConsulta;
	}

	public Date getFechaConsulta() {
		return fechaConsulta;
	}

	public void setFechaConsulta(Date fechaConsulta) {
		this.fechaConsulta = fechaConsulta;
	}

	public String getHoraConsulta() {
		return horaConsulta;
	}

	public void setHoraConsulta(String horaConsulta) {
		this.horaConsulta = horaConsulta;
	}

	public Short getCodAccionEjecutada() {
		return codAccionEjecutada;
	}

	public void setCodAccionEjecutada(Short codAccionEjecutada) {
		this.codAccionEjecutada = codAccionEjecutada;
	}

	public BigDecimal getMontoEjecutado() {
		return montoEjecutado;
	}

	public void setMontoEjecutado(BigDecimal montoEjecutado) {
		this.montoEjecutado = montoEjecutado;
	}

	public String getUsuarioEjecucion() {
		return usuarioEjecucion;
	}

	public void setUsuarioEjecucion(String usuarioEjecucion) {
		this.usuarioEjecucion = usuarioEjecucion;
	}

	public Date getFechaEjecucion() {
		return fechaEjecucion;
	}

	public void setFechaEjecucion(Date fechaEjecucion) {
		this.fechaEjecucion = fechaEjecucion;
	}

	public String getHoraEjecucion() {
		return horaEjecucion;
	}

	public void setHoraEjecucion(String horaEjecucion) {
		this.horaEjecucion = horaEjecucion;
	}

	public Short getCodProducReportar() {
		return codProducReportar;
	}

	public void setCodProducReportar(Short codProducReportar) {
		this.codProducReportar = codProducReportar;
	}

	public Short getCodCore() {
		return codCore;
	}

	public void setCodCore(Short codCore) {
		this.codCore = codCore;
	}

	public Implicados getIdImplicado() {
		return idImplicado;
	}

	public void setIdImplicado(Implicados idImplicado) {
		this.idImplicado = idImplicado;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idProducto != null ? idProducto.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof ImplicadoProductos)) {
			return false;
		}
		ImplicadoProductos other = (ImplicadoProductos) object;
		if ((this.idProducto == null && other.idProducto != null)
				|| (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.opensys.pruebaposgret001.ImplicadoProductos[ idProducto=" + idProducto + " ]";
	}

}
