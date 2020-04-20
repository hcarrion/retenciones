package pe.confianza.retenciones.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.confianza.retenciones.modelo.Implicados;

public interface IImplicadoRepo extends JpaRepository<Implicados, Integer> {

}
