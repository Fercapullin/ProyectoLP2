package service;

import java.util.List;

import dao.DAOFactory;
import interfaces.DocenteDAO;
import modelo.Docente;

public class DocenteService {
	
	DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	DocenteDAO obj = factory.getDocenteDAO();
	
	public List<Docente> listarDocentes() {
		return obj.listarDocentes();
	}
	
	public List<Docente> buscarDocente(String cod) {
		return obj.buscarDocente(cod);
	}
	
	public int registrarDocente(Docente docente) {
		return obj.registrarDocente(docente);
	}
	
	public int actualizarDocente(Docente docente) {
		return obj.actualizarDocente(docente);
	}
	
	public int eliminarDocente(String cod) {
		return obj.eliminarDocente(cod);
	}
	
	public String obtenerUltimoCod() {
		return obj.obtenerUltimoCod();
	}
}
