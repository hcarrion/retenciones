package pe.confianza.retenciones.dto;

import java.io.Serializable;
import java.util.List;



import pe.confianza.retenciones.modelo.Solicitudes;



public class CartaDTO implements Serializable{

	private static final long serialVersionUID = 1L;

    private Integer idCarta;
    private String descripcion;
    private String descripcionCorta;
    private Short codEstadoCarta;
    private List<Solicitudes> solicitudesList;
    
	public CartaDTO() {
	} 
	public CartaDTO(Integer idCarta, String descripcion, String descripcionCorta, Short codEstadoCarta,
			List<Solicitudes> solicitudesList) {
		this.idCarta = idCarta;
		this.descripcion = descripcion;
		this.descripcionCorta = descripcionCorta;
		this.codEstadoCarta = codEstadoCarta;
		this.solicitudesList = solicitudesList;
	}
	public Integer getIdCarta() {
		return idCarta;
	}
	public void setIdCarta(Integer idCarta) {
		this.idCarta = idCarta;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getDescripcionCorta() {
		return descripcionCorta;
	}
	public void setDescripcionCorta(String descripcionCorta) {
		this.descripcionCorta = descripcionCorta;
	}
	public Short getCodEstadoCarta() {
		return codEstadoCarta;
	}
	public void setCodEstadoCarta(Short codEstadoCarta) {
		this.codEstadoCarta = codEstadoCarta;
	}
	public List<Solicitudes> getSolicitudesList() {
		return solicitudesList;
	}
	public void setSolicitudesList(List<Solicitudes> solicitudesList) {
		this.solicitudesList = solicitudesList;
	}
	

    


}
