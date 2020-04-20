package pe.confianza.retenciones.dto;

import java.math.BigDecimal;
import java.util.Date;

import pe.confianza.retenciones.modelo.Implicados;

public class ImplicadoProductoDTO {

	private Integer idProducto;
	private String codProducto;
	private String nomProducto;
	private Date fechaAltaProd;
	private Short codTipoProducto;
	private Short codEstadoProducto;
	private Date fechaUltimaOper;
	private BigDecimal monto;
	private String usuarioConsulta;
	private Date fechaConsulta;
	private String horaConsulta;
	private Short codAccionEjecutada;
	private BigDecimal montoEjecutado;
	private String usuarioEjecucion;
	private Date fechaEjecucion;
	private String horaEjecucion;
	private Short codProducReportar;
	private Short codCore;
	private Implicados idImplicado;
	public ImplicadoProductoDTO(Integer idProducto, String codProducto, String nomProducto, Date fechaAltaProd,
			Short codTipoProducto, Short codEstadoProducto, Date fechaUltimaOper, BigDecimal monto,
			String usuarioConsulta, Date fechaConsulta, String horaConsulta, Short codAccionEjecutada,
			BigDecimal montoEjecutado, String usuarioEjecucion, Date fechaEjecucion, String horaEjecucion,
			Short codProducReportar, Short codCore, Implicados idImplicado) {
		this.idProducto = idProducto;
		this.codProducto = codProducto;
		this.nomProducto = nomProducto;
		this.fechaAltaProd = fechaAltaProd;
		this.codTipoProducto = codTipoProducto;
		this.codEstadoProducto = codEstadoProducto;
		this.fechaUltimaOper = fechaUltimaOper;
		this.monto = monto;
		this.usuarioConsulta = usuarioConsulta;
		this.fechaConsulta = fechaConsulta;
		this.horaConsulta = horaConsulta;
		this.codAccionEjecutada = codAccionEjecutada;
		this.montoEjecutado = montoEjecutado;
		this.usuarioEjecucion = usuarioEjecucion;
		this.fechaEjecucion = fechaEjecucion;
		this.horaEjecucion = horaEjecucion;
		this.codProducReportar = codProducReportar;
		this.codCore = codCore;
		this.idImplicado = idImplicado;
	}
	public ImplicadoProductoDTO() {
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
	
	
	
	
	

}
