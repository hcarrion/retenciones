package pe.confianza.retenciones.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.confianza.retenciones.modelo.Cartas;

public interface ICartaRepo extends JpaRepository<Cartas, Integer>{

}
