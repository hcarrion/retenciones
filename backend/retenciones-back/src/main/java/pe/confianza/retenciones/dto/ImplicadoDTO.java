package pe.confianza.retenciones.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import pe.confianza.retenciones.modelo.ImplicadoProductos;
import pe.confianza.retenciones.modelo.Solicitudes;

public class ImplicadoDTO {

	private Integer idImplicado;
	private Short pais;
	private Short tipoDoc;
	private String numDoc;
	private String apePaterno;
	private String apeMaterno;
	private String nombres;
	private String expediente;
	private BigDecimal montoRetencion;
	private Short esClienteFc;
	private String usuarioRegist;
	private Date fechaRegist;
	private String horaRegist;
	private Short codFormaCarga;
	private String codProdSolic;
	private Short estado;
	private List<ImplicadoProductos> implicadoProductosList;
	private Solicitudes idSolicitud;

	public ImplicadoDTO(Integer idImplicado, Short pais, Short tipoDoc, String numDoc, String apePaterno,
			String apeMaterno, String nombres, String expediente, BigDecimal montoRetencion, Short esClienteFc,
			String usuarioRegist, Date fechaRegist, String horaRegist, Short codFormaCarga, String codProdSolic,
			Short estado, List<ImplicadoProductos> implicadoProductosList, Solicitudes idSolicitud) {
		super();
		this.idImplicado = idImplicado;
		this.pais = pais;
		this.tipoDoc = tipoDoc;
		this.numDoc = numDoc;
		this.apePaterno = apePaterno;
		this.apeMaterno = apeMaterno;
		this.nombres = nombres;
		this.expediente = expediente;
		this.montoRetencion = montoRetencion;
		this.esClienteFc = esClienteFc;
		this.usuarioRegist = usuarioRegist;
		this.fechaRegist = fechaRegist;
		this.horaRegist = horaRegist;
		this.codFormaCarga = codFormaCarga;
		this.codProdSolic = codProdSolic;
		this.estado = estado;
		this.implicadoProductosList = implicadoProductosList;
		this.idSolicitud = idSolicitud;
	}

	public ImplicadoDTO() {
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

}
