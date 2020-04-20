package pe.confianza.retenciones.dto;

public class ParametroPKDTO {

	private int codigo;
	private short correlativo;

	public ParametroPKDTO(int codigo, short correlativo) {
		this.codigo = codigo;
		this.correlativo = correlativo;
	}

	public ParametroPKDTO() {
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
