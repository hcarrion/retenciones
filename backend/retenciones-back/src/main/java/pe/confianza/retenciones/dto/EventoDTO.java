package pe.confianza.retenciones.dto;

import java.util.Date;

import pe.confianza.retenciones.modelo.Solicitudes;

public class EventoDTO {
    private Integer idEvento;
    private Short codProcesEjecut;
    private Short codEstadoSolicit;
    private Short codSubEstdSolicit;
    private String comentario;
    private String usuarioProceso;
    private Date fechaIniProceso;
    private String horaIniProeceso;
    private Date fechaFinProceso;
    private String foraFinProeceso;
    private Solicitudes idSolicitud;
	public EventoDTO(Integer idEvento, Short codProcesEjecut, Short codEstadoSolicit, Short codSubEstdSolicit,
			String comentario, String usuarioProceso, Date fechaIniProceso, String horaIniProeceso,
			Date fechaFinProceso, String foraFinProeceso, Solicitudes idSolicitud) {
		this.idEvento = idEvento;
		this.codProcesEjecut = codProcesEjecut;
		this.codEstadoSolicit = codEstadoSolicit;
		this.codSubEstdSolicit = codSubEstdSolicit;
		this.comentario = comentario;
		this.usuarioProceso = usuarioProceso;
		this.fechaIniProceso = fechaIniProceso;
		this.horaIniProeceso = horaIniProeceso;
		this.fechaFinProceso = fechaFinProceso;
		this.foraFinProeceso = foraFinProeceso;
		this.idSolicitud = idSolicitud;
	}
	public EventoDTO() {
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
    
    

}
