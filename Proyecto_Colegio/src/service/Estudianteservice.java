package service;

import java.util.List;

import dao.DAOFactory;
import interfaces.EstudianteDAO;
import modelo.Detalle_estudiante;
import modelo.Estudiante;

public class Estudianteservice {

	DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	EstudianteDAO objCon = fabrica.getConsulta();
	
	public List<Estudiante> listar(){
		return objCon.listar();
	}
	public List<Detalle_estudiante> listado(String cod)
	{
		return objCon.listado(cod);
	}
	public int registrarEstudiante(Estudiante obj) 
	{
		return objCon.registrarEstudiante(obj);
	}
	
	public String obtenerUltimoCod() {
		return objCon.obtenerUltimoCod();
	}
}
