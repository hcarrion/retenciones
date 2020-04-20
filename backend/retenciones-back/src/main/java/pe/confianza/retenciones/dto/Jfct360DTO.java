package pe.confianza.retenciones.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Jfct360DTO implements Serializable {


	private static final long serialVersionUID = 1L;
	private int codigo;
    private short correlativo;
    private Integer numero;
    private String descripcion;
    private BigDecimal importe;
    private Date fecha;
    
	public Jfct360DTO(int codigo, short correlativo, Integer numero, String descripcion, BigDecimal importe,
			Date fecha) {
		this.codigo = codigo;
		this.correlativo = correlativo;
		this.numero = numero;
		this.descripcion = descripcion;
		this.importe = importe;
		this.fecha = fecha;
	}


	public Jfct360DTO() {
		
	}

	
	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public short getCorrelativo() {
		return correlativo;
	}


	public void setCorrelativo(short correlativo) {
		this.correlativo = correlativo;
	}


	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public BigDecimal getImporte() {
		return importe;
	}
	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
    
    

}
