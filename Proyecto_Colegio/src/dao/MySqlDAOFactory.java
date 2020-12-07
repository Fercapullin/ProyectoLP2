package dao;

import interfaces.DocenteDAO;
import interfaces.EstudianteDAO;

public class MySqlDAOFactory extends DAOFactory {

	@Override
	public EstudianteDAO getConsulta() {
		
		return new MysqlEstudianteDAO();
	}

	@Override
	public DocenteDAO getDocenteDAO() {
		
		return new MysqlDocenteDAO();
	}

}
