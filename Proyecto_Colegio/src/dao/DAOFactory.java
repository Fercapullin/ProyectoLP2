package dao;

import interfaces.DocenteDAO;
import interfaces.EstudianteDAO;
import interfaces.UsuarioDAO;

public abstract class DAOFactory {

	public static final int MYSQL = 1;
	
	
	public abstract EstudianteDAO getConsulta();
	public abstract DocenteDAO getDocenteDAO();
	public abstract UsuarioDAO getUsuarioDAO();
	
	public static DAOFactory getDAOFactory(int whichFactory) {
		
		switch(whichFactory) {
		case MYSQL : 
			return new MySqlDAOFactory();
		}
		return null;
	}
	
	
}
