package pe.confianza.retenciones.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.confianza.retenciones.dto.ParametroDTO;
import pe.confianza.retenciones.dto.ParametroPKDTO;

import pe.confianza.retenciones.modelo.Parametros;
import pe.confianza.retenciones.modelo.ParametrosPK;
import pe.confianza.retenciones.repo.IParametroRepo;
import pe.confianza.retenciones.service.IParametroService;

@Service
public class ParametroServiceImpl implements IParametroService {

	@Autowired
	IParametroRepo repo;

	@Override
	public Parametros registrar(Parametros gen) {

		return repo.save(gen);
	}

	@Override
	public Parametros modificar(Parametros gen) {
		return repo.save(gen);
	}

	@Override
	public List<Parametros> listar() {

		return repo.findAll();
	}

	@Override
	public Parametros listarPorId(ParametrosPK id) {

		Optional<Parametros> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Parametros();
	}

	@Override
	public void eliminar(ParametrosPK id) {
		repo.deleteById(id);

	}

	@Override
	public List<ParametroDTO> listarParamPorCod(Integer codigo) {
		return repo.listarParamPorCod(codigo).stream().map(e -> new ParametroDTO(e.getParametrosPK().getCodigo(),
				e.getParametrosPK().getCorrelativo(), e.getNumero(), e.getDescripcion(), e.getImporte(), e.getFecha()))
				.collect(Collectors.toList());
	}

	@Override
	public ParametroDTO lstParametroPorId(ParametroPKDTO parametroPK) {

		Optional<Parametros> op = repo
				.findById(new ParametrosPK(parametroPK.getCodigo(), parametroPK.getCorrelativo()));
		Parametros parametros = op.isPresent() ? op.get() : new Parametros();

		if (parametros != null) {
			return new ParametroDTO(parametros.getParametrosPK().getCodigo(),
					parametros.getParametrosPK().getCorrelativo(), parametros.getNumero(), parametros.getDescripcion(),
					parametros.getImporte(), parametros.getFecha());
		} else {
			return null;
		}

	}

}
