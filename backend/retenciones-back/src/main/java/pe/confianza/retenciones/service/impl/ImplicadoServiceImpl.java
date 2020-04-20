package pe.confianza.retenciones.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.confianza.retenciones.modelo.Implicados;

import pe.confianza.retenciones.repo.IImplicadoRepo;
import pe.confianza.retenciones.service.IImplicadoService;

@Service
public class ImplicadoServiceImpl implements IImplicadoService {

	@Autowired
	private IImplicadoRepo repo;
	
	@Override
	public Implicados registrar(Implicados gen) {

		return repo.save(gen);
	}

	@Override
	public Implicados modificar(Implicados gen) {
		return repo.save(gen);
	}

	@Override
	public List<Implicados> listar() {

		return repo.findAll();
	}

	@Override
	public Implicados listarPorId(Integer id) {
		Optional<Implicados> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Implicados();
	}

	@Override
	public void eliminar(Integer id) {
		repo.deleteById(id);
 
		
	}

}
