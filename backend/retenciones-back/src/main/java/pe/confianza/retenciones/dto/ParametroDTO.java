package pe.confianza.retenciones.dto;

import java.math.BigDecimal;
import java.util.Date;

public class ParametroDTO {
	private int codigo;
	private short correlativo;
	private Short numero;
	private String descripcion;
	private BigDecimal importe;
	private Date fecha;

	public ParametroDTO(int codigo, short correlativo, Short numero, String descripcion, BigDecimal importe,
			Date fecha) {

		this.codigo = codigo;
		this.correlativo = correlativo;
		this.numero = numero;
		this.descripcion = descripcion;
		this.importe = importe;
		this.fecha = fecha;
	}

	public ParametroDTO() {
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

	public Short getNumero() {
		return numero;
	}

	public void setNumero(Short numero) {
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
