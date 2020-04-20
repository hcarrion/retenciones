package pe.confianza.retenciones.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.confianza.retenciones.modelo.Eventos;

import pe.confianza.retenciones.repo.IEventoRepo;
import pe.confianza.retenciones.service.IEventoService;

@Service
public class EventoServiceImpl implements IEventoService {

	
	@Autowired
	private IEventoRepo repo;
	
	@Override
	public Eventos registrar(Eventos gen) {

		return repo.save(gen);
	}

	@Override
	public Eventos modificar(Eventos gen) {

		return repo.save(gen);
	}

	@Override
	public List<Eventos> listar() {

		return repo.findAll();
	}

	@Override
	public Eventos listarPorId(Integer id) {
		Optional<Eventos> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Eventos();
	}

	@Override
	public void eliminar(Integer id) {
		
		repo.deleteById(id);
	
	}

}
