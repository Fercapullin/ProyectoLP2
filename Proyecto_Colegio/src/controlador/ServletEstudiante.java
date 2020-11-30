package controlador;
import java.util.*;
import modelo.Estudiante;
import entidad.ModelEstudiante;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ServletEstudiante")
public class ServletEstudiante extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletEstudiante() {
        super();
       
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tipo = request.getParameter("tipo"); // ¿QUE DESEA HACER EL USUARIO?
		if (tipo.equals("listar"))
			listar(request, response);
		
	}
	
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Estudiante> info = new ModelEstudiante().listar();
		request.setAttribute("data", info);
		request.getRequestDispatcher("listarEstudiantes.jsp").forward(request, response);
	}

}
