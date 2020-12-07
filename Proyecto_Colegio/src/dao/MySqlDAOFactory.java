package dao;

import interfaces.EstudianteDAO;

public class MySqlDAOFactory extends DAOFactory {

	@Override
	public EstudianteDAO getConsulta() {
		
		return new MysqlEstudianteDAO();
	}

}
