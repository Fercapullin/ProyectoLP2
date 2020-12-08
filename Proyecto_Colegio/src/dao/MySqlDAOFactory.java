package dao;

import interfaces.DocenteDAO;
import interfaces.EstudianteDAO;
import interfaces.UsuarioDAO;

public class MySqlDAOFactory extends DAOFactory {

	@Override
	public EstudianteDAO getConsulta() {
		
		return new MysqlEstudianteDAO();
	}

	@Override
	public DocenteDAO getDocenteDAO() {
		
		return new MysqlDocenteDAO();
	}

	@Override
	public UsuarioDAO getUsuarioDAO() {
		return new MysqlUsuarioDAO();
	}

}
