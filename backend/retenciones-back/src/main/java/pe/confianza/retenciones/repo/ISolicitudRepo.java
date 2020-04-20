package pe.confianza.retenciones.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.confianza.retenciones.modelo.Solicitudes;

public interface ISolicitudRepo extends JpaRepository<Solicitudes, Integer> {

}
