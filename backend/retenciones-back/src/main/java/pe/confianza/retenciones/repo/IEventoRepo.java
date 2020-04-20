package pe.confianza.retenciones.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.confianza.retenciones.modelo.Eventos;

public interface IEventoRepo extends JpaRepository<Eventos, Integer> {

}
