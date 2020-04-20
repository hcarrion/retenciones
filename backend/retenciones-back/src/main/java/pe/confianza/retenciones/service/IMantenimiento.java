package pe.confianza.retenciones.service;

import java.util.List;

public interface IMantenimiento<T,V> {
	T registrar(T gen);
	T modificar(T gen);
	List<T> listar();
	T listarPorId(V id);
	void eliminar(V id);

}
