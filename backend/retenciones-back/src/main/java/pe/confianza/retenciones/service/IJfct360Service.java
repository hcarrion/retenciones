package pe.confianza.retenciones.service;

import java.util.List;

import pe.confianza.retenciones.dto.Jfct360DTO;
import pe.confianza.retenciones.dto.Jfct360PKDTO;
import pe.confianza.retenciones.modelo.Jfct360;
import pe.confianza.retenciones.modelo.Jfct360PK;

public interface IJfct360Service extends IMantenimiento<Jfct360,Jfct360PK> {

	List<Jfct360DTO> listarParamPorCod(Integer codigo);
	Jfct360DTO lstParametroPorId(Jfct360PKDTO idCodigo); 
}
