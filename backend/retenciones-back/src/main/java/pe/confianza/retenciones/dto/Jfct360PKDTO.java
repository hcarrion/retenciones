package pe.confianza.retenciones.dto;

import java.io.Serializable;

public class Jfct360PKDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private int codigo;
    private short correlativo;
	public Jfct360PKDTO() {
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
	

}
