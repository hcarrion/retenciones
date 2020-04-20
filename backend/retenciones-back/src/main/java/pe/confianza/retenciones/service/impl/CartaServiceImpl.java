package pe.confianza.retenciones.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.confianza.retenciones.modelo.Cartas;
import pe.confianza.retenciones.repo.ICartaRepo;
import pe.confianza.retenciones.service.ICartaService;
@Service
public class CartaServiceImpl implements ICartaService {
	
	@Autowired
	private ICartaRepo repo;

	@Override
	public Cartas registrar(Cartas gen) {
		return repo.save(gen);
	}

	@Override
	public Cartas modificar(Cartas gen) {
		return  repo.save(gen);
	}

	@Override
	public List<Cartas> listar() {
		
		return repo.findAll();
	}

	@Override
	public Cartas listarPorId(Integer id) {
		Optional<Cartas> op = repo.findById(id);
	
		return op.isPresent() ? op.get() : new Cartas();
	}

	@Override
	public void eliminar(Integer id) {
		repo.deleteById(id);
		
	}

}
