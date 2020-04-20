package pe.confianza.retenciones.service.impl;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.confianza.retenciones.dto.Jfct360DTO;
import pe.confianza.retenciones.dto.Jfct360PKDTO;
import pe.confianza.retenciones.modelo.Jfct360;
import pe.confianza.retenciones.modelo.Jfct360PK;
import pe.confianza.retenciones.repo.IJfct360Repo;
import pe.confianza.retenciones.service.IJfct360Service;

@Service
public class Jfct360ServiceImpl implements IJfct360Service{

	@Autowired
	private IJfct360Repo repo;
	
	@Override
	public Jfct360 registrar(Jfct360 gen) {
		return repo.save(gen);
	}

	@Override
	public Jfct360 modificar(Jfct360 gen) {

		return repo.save(gen);
	}

	@Override
	public List<Jfct360> listar() {
		
		return repo.findAll();
	}

	@Override
	public Jfct360 listarPorId(Jfct360PK id) {
		Optional<Jfct360> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Jfct360();
	}

	@Override
	public void eliminar(Jfct360PK id) {
		repo.deleteById(id);
		
	}

	@Override
	public List<Jfct360DTO> listarParamPorCod(Integer codigo) {
		
		List<Jfct360DTO> lista =repo.listarParamPorCod(codigo).stream()
															  .map(e -> new Jfct360DTO(e.getIdCodigo().getCodigo()
																	  ,e.getIdCodigo().getCorrelativo()
																	  ,e.getNumero()
																	  ,e.getDescripcion()
																	  ,e.getImporte()
																	  ,e.getFecha()))
															  .collect(Collectors.toList());
		return lista;
		

	}

	@Override
	public Jfct360DTO lstParametroPorId(Jfct360PKDTO idCodigo) {

	    int codigo;
	    short correlativo;

	    codigo =  idCodigo.getCodigo();
	    correlativo = idCodigo.getCorrelativo();

		Jfct360PK jfct360pk  = new Jfct360PK(codigo, correlativo);
		Jfct360DTO jfct360dto = new Jfct360DTO();
		Optional<Jfct360> op = repo.findById(jfct360pk);
		Jfct360 jfct360;
		jfct360 = op.isPresent() ? op.get() : new Jfct360();
		if(jfct360 != null) {
			jfct360dto.setCodigo(idCodigo.getCodigo());
			jfct360dto.setCorrelativo(idCodigo.getCorrelativo());
			jfct360dto.setNumero(jfct360.getNumero());
			jfct360dto.setImporte(jfct360.getImporte());
			jfct360dto.setFecha(jfct360.getFecha());
			jfct360dto.setDescripcion(jfct360.getDescripcion());

			return jfct360dto;
		}else {
			return null;
			
		}

	}

}
