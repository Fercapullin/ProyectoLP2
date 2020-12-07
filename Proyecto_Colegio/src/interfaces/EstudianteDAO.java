package interfaces;

import java.util.List;

import modelo.Detalle_estudiante;
import modelo.Estudiante;

public interface EstudianteDAO {

	public List<Estudiante> listar();
	
	public List<Detalle_estudiante> listado(String cod);
	
	public int registrarEstudiante(Estudiante obj);
	
	public int actualizarEstudiante(Estudiante obj);
	
	public int eliminarEstudiante( String cod) ;
	
	public String obtenerUltimoCod();
}
