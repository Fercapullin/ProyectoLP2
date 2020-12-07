package interfaces;

import java.util.List;

import modelo.Docente;

public interface DocenteDAO {
	
	public List<Docente> listarDocentes();
	public List<Docente> buscarDocente(String cod);
	public int registrarDocente(Docente docente);
	public int actualizarDocente(Docente docente);
	public int eliminarDocente(String codigo);
	public String obtenerUltimoCod();
}