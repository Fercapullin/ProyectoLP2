package controlador;

import java.util.*;

import modelo.Detalle_estudiante;
import modelo.Estudiante;
import service.Estudianteservice;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletEstudiante")
public class ServletEstudiante extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	Estudianteservice estu = new Estudianteservice();
	
	public ServletEstudiante() {
		super();

	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String tipo = request.getParameter("tipo"); // ¿QUE DESEA HACER EL USUARIO?
		if (tipo.equals("listar"))
			listar(request, response);
		else if (tipo.equals("buscar"))
			buscar(request, response);
		else if (tipo.equals("registrar"))
			registrar(request,response);
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Estudiante obj = new Estudiante();
		String cod=request.getParameter("txt_cod");
		String nom=request.getParameter("txt_nom");
		String ape=request.getParameter("txt_ape");
		String dni=request.getParameter("txt_dni");
		String gra=request.getParameter("txt_grado");
		
		obj.setCodestudiant(cod);
		obj.setNombre(nom);
		obj.setApellido(ape);
		obj.setDni(Integer.parseInt(dni));
		obj.setId_grado(gra);
		
		int estado = estu.registrarEstudiante(obj);
		if (estado!= -1)
			 listar(request,response);
		else 
			response.sendRedirect("error html");
		
	}

	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String dato = request.getParameter("cod");
		String codigo = dato;
		List<Detalle_estudiante> x = new Estudianteservice().listado(codigo);
		request.setAttribute("data", x);
		request.getRequestDispatcher("listado_detallematri.jsp").forward(request, response);

	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Estudiante> info = new Estudianteservice().listar();
		request.setAttribute("data", info);
		request.getRequestDispatcher("listarEstudiantes.jsp").forward(request, response);
	}

}
