package pe.confianza.retenciones.service;

import java.util.List;


import pe.confianza.retenciones.dto.ParametroDTO;
import pe.confianza.retenciones.dto.ParametroPKDTO;
import pe.confianza.retenciones.modelo.Parametros;
import pe.confianza.retenciones.modelo.ParametrosPK;

public interface IParametroService extends IMantenimiento<Parametros, ParametrosPK> {

	List<ParametroDTO> listarParamPorCod(Integer codigo);
	ParametroDTO lstParametroPorId(ParametroPKDTO parametroPK); 
}
 