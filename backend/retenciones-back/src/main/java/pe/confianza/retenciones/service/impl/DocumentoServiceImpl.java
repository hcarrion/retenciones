package pe.confianza.retenciones.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.confianza.retenciones.modelo.Documentos;

import pe.confianza.retenciones.repo.IDocumentoRepo;
import pe.confianza.retenciones.service.IDocumentoService;

@Service
public class DocumentoServiceImpl implements IDocumentoService {

	@Autowired
	private IDocumentoRepo repo;
	
	@Override
	public Documentos registrar(Documentos gen) {

		return repo.save(gen);
	}

	@Override
	public Documentos modificar(Documentos gen) {

		return repo.save(gen);
	}

	@Override
	public List<Documentos> listar() {

		return repo.findAll();
	}

	@Override
	public Documentos listarPorId(Integer id) {
		Optional<Documentos> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Documentos();
	}

	@Override
	public void eliminar(Integer id) {
		repo.deleteById(id);
		
	}

}
