package pe.confianza.retenciones.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
 
import pe.confianza.retenciones.modelo.Solicitudes;
import pe.confianza.retenciones.repo.ISolicitudRepo;
import pe.confianza.retenciones.service.ISolicitudService;

public class SolicitudServiceImpl implements ISolicitudService {

	@Autowired
	private ISolicitudRepo repo;
	@Override
	public Solicitudes registrar(Solicitudes gen) {

		return repo.save(gen);
	}

	@Override
	public Solicitudes modificar(Solicitudes gen) {
		
		return repo.save(gen);
	}

	@Override
	public List<Solicitudes> listar() {

		return repo.findAll();
	}

	@Override
	public Solicitudes listarPorId(Integer id) {
		Optional<Solicitudes> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Solicitudes();

	}

	@Override
	public void eliminar(Integer id) {
		
		repo.deleteById(id);
		
	}

}
