package dao;

import interfaces.DocenteDAO;
import interfaces.EstudianteDAO;

public abstract class DAOFactory {

	public static final int MYSQL = 1;
	
	
	public abstract EstudianteDAO getConsulta();
	public abstract DocenteDAO getDocenteDAO();
	
	public static DAOFactory getDAOFactory(int whichFactory) {
		
		switch(whichFactory) {
		case MYSQL : 
			return new MySqlDAOFactory();
		}
		return null;
	}
	
	
}
