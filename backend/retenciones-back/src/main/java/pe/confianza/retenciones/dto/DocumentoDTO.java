package pe.confianza.retenciones.dto;

import java.util.Date;



import pe.confianza.retenciones.modelo.Solicitudes;

public class DocumentoDTO {
	
	 private Integer idDocumento;
	    private String descripción;
	    private String ruta;
	    private byte[] adjunto;
	    private Short codEstadoAdjunto;
	    private String usuarioAdjunto;
	    private Date fechaAdjunto;
	    private String horaAdjunto;
	    private String idDoc;
	    private Solicitudes idSolicitud;
		public DocumentoDTO() {
		}
		
		public DocumentoDTO(Integer idDocumento, String descripción, String ruta, byte[] adjunto,
				Short codEstadoAdjunto, String usuarioAdjunto, Date fechaAdjunto, String horaAdjunto, String idDoc,
				Solicitudes idSolicitud) {
			this.idDocumento = idDocumento;
			this.descripción = descripción;
			this.ruta = ruta;
			this.adjunto = adjunto;
			this.codEstadoAdjunto = codEstadoAdjunto;
			this.usuarioAdjunto = usuarioAdjunto;
			this.fechaAdjunto = fechaAdjunto;
			this.horaAdjunto = horaAdjunto;
			this.idDoc = idDoc;
			this.idSolicitud = idSolicitud;
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
		
	    
	    

}
