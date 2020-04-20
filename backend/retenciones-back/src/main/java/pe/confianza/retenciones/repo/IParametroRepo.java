package pe.confianza.retenciones.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.confianza.retenciones.modelo.Parametros;
import pe.confianza.retenciones.modelo.ParametrosPK;

public interface IParametroRepo extends JpaRepository<Parametros,ParametrosPK> {

	@Query("SELECT p FROM Parametros p WHERE p.parametrosPK.codigo = :codigo")
	List<Parametros> listarParamPorCod(@Param("codigo") Integer codigo);
}
