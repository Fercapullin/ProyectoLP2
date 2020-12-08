package service;

import dao.DAOFactory;
import interfaces.UsuarioDAO;
import modelo.Usuario;

public class UsuarioService {
	
	DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	UsuarioDAO obj = factory.getUsuarioDAO();
	
	public Usuario autenticar(Usuario usuario) {
		return obj.autenticar(usuario);
	}
}
