package pe.confianza.retenciones.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.confianza.retenciones.modelo.ImplicadoProductos;

import pe.confianza.retenciones.repo.IImplicadoProductoRepo;
import pe.confianza.retenciones.service.IImplicadoProductoService;

@Service
public class ImplicadoProductoServiceImpl implements IImplicadoProductoService {

	@Autowired
	IImplicadoProductoRepo repo;
	@Override
	public ImplicadoProductos registrar(ImplicadoProductos gen) {

		return repo.save(gen);
	}

	@Override
	public ImplicadoProductos modificar(ImplicadoProductos gen) {

		return repo.save(gen);
	}

	@Override
	public List<ImplicadoProductos> listar() {

		return repo.findAll();
	}

	@Override
	public ImplicadoProductos listarPorId(Integer id) {
		Optional<ImplicadoProductos> op = repo.findById(id);
		return op.isPresent() ? op.get() : new ImplicadoProductos();
	}

	@Override
	public void eliminar(Integer id) {
		repo.deleteById(id);
		
	}

}
