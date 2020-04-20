package pe.confianza.retenciones.dto;

import java.util.Date;
import java.util.List;

import pe.confianza.retenciones.modelo.Cartas;
import pe.confianza.retenciones.modelo.Documentos;
import pe.confianza.retenciones.modelo.Eventos;
import pe.confianza.retenciones.modelo.Implicados;

public class SolicitudDTO {
	
	    private Integer idSolicitud;
	    private Short codDctoIngresado;
	    private Short codRequerimiento;
	    private Short codEntidad;
	    private String numDocIngresado;
	    private Short codPrioridad;
	    private Short diasMaxRpta;
	    private Short codAgenRecep;
	    private Date fechaRecep;
	    private Short codAgenRegis;
	    private String userRegistro;
	    private Date fechaRegistro;
	    private String horaRegistro;
	    private Short cantidadHojas;
	    private String textoRespuesta;
	    private Integer idSecuenciaEventoUlti;
	    private List<Eventos> eventosList;
	    private Cartas idCarta;
	    private List<Documentos> documentosList;
	    private List<Implicados> implicadosList;
		public SolicitudDTO(Integer idSolicitud, Short codDctoIngresado, Short codRequerimiento, Short codEntidad,
				String numDocIngresado, Short codPrioridad, Short diasMaxRpta, Short codAgenRecep, Date fechaRecep,
				Short codAgenRegis, String userRegistro, Date fechaRegistro, String horaRegistro, Short cantidadHojas,
				String textoRespuesta, Integer idSecuenciaEventoUlti, List<Eventos> eventosList, Cartas idCarta,
				List<Documentos> documentosList, List<Implicados> implicadosList) {
			this.idSolicitud = idSolicitud;
			this.codDctoIngresado = codDctoIngresado;
			this.codRequerimiento = codRequerimiento;
			this.codEntidad = codEntidad;
			this.numDocIngresado = numDocIngresado;
			this.codPrioridad = codPrioridad;
			this.diasMaxRpta = diasMaxRpta;
			this.codAgenRecep = codAgenRecep;
			this.fechaRecep = fechaRecep;
			this.codAgenRegis = codAgenRegis;
			this.userRegistro = userRegistro;
			this.fechaRegistro = fechaRegistro;
			this.horaRegistro = horaRegistro;
			this.cantidadHojas = cantidadHojas;
			this.textoRespuesta = textoRespuesta;
			this.idSecuenciaEventoUlti = idSecuenciaEventoUlti;
			this.eventosList = eventosList;
			this.idCarta = idCarta;
			this.documentosList = documentosList;
			this.implicadosList = implicadosList;
		}
		public SolicitudDTO() {
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
		public List<Documentos> getDocumentosList() {
			return documentosList;
		}
		public void setDocumentosList(List<Documentos> documentosList) {
			this.documentosList = documentosList;
		}
		public List<Implicados> getImplicadosList() {
			return implicadosList;
		}
		public void setImplicadosList(List<Implicados> implicadosList) {
			this.implicadosList = implicadosList;
		}

}
