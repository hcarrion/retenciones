package pe.confianza.retenciones.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.confianza.retenciones.modelo.Documentos;

public interface IDocumentoRepo extends JpaRepository<Documentos, Integer> {

}
