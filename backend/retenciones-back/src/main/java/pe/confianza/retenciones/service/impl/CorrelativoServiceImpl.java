package pe.confianza.retenciones.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.confianza.retenciones.modelo.Correlativos;


import pe.confianza.retenciones.repo.ICorrelativoRepo;
import pe.confianza.retenciones.service.IMantenimiento;

@Service
public class CorrelativoServiceImpl implements IMantenimiento<Correlativos, Integer> {

	@Autowired
	private ICorrelativoRepo repo;
	
	@Override
	public Correlativos registrar(Correlativos gen) {

		return repo.save(gen);
	}

	@Override
	public Correlativos modificar(Correlativos gen) {

		return repo.save(gen);
	}

	@Override
	public List<Correlativos> listar() {

		return repo.findAll();
	}

	@Override
	public Correlativos listarPorId(Integer id) {
		Optional<Correlativos> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Correlativos();		

	}

	@Override
	public void eliminar(Integer id) {
		repo.deleteById(id);
	
		
	}

}
