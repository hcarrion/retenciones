package pe.confianza.retenciones.dto;


public class CorrelativoDTO {
	

	    private Integer idCorrelativo;
	    private String descripcion;
	    private Integer correlativo;
	    private Short codEstado;
		public CorrelativoDTO() {
		}
		
		public CorrelativoDTO(Integer idCorrelativo, String descripcion, Integer correlativo, Short codEstado) {
			this.idCorrelativo = idCorrelativo;
			this.descripcion = descripcion;
			this.correlativo = correlativo;
			this.codEstado = codEstado;
		}

		public Integer getIdCorrelativo() {
			return idCorrelativo;
		}
		public void setIdCorrelativo(Integer idCorrelativo) {
			this.idCorrelativo = idCorrelativo;
		}
		public String getDescripcion() {
			return descripcion;
		}
		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}
		public Integer getCorrelativo() {
			return correlativo;
		}
		public void setCorrelativo(Integer correlativo) {
			this.correlativo = correlativo;
		}
		public Short getCodEstado() {
			return codEstado;
		}
		public void setCodEstado(Short codEstado) {
			this.codEstado = codEstado;
		}
	    
	    

}
