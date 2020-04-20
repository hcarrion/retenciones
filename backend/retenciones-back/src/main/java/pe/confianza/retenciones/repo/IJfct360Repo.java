package pe.confianza.retenciones.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import pe.confianza.retenciones.modelo.Jfct360;
import pe.confianza.retenciones.modelo.Jfct360PK;

public interface IJfct360Repo extends JpaRepository<Jfct360, Jfct360PK> {
	@Query("SELECT ct360 FROM Jfct360 ct360 WHERE ct360.idCodigo.codigo = :codigo")
	List<Jfct360> listarParamPorCod(@Param("codigo") Integer codigo);

}


