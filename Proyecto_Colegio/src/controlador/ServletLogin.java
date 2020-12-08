package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Usuario;
import service.UsuarioService;

@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	UsuarioService us = new UsuarioService();
	
    public ServletLogin() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		autenticar(request, response);
	}
	
	private void autenticar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Usuario preUsuario = new Usuario();
		preUsuario.setUsuario(request.getParameter("user"));
		preUsuario.setClave(request.getParameter("password"));
		
		Usuario usuario = us.autenticar(preUsuario);
		if (usuario.getUsuario() == null) {
			request.setAttribute("error", "Usuario o contraseña inválida");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		
		request.setAttribute("usuario", usuario);
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}
}
