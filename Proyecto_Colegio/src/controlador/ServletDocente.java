package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Docente;
import service.DocenteService;

@WebServlet("/ServletDocente")
public class ServletDocente extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    DocenteService ds = new DocenteService();
	
    public ServletDocente() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tipo = request.getParameter("tipo");

		if (tipo.equals("listar")) {
			listarDocentes(request, response);
		} else if (tipo.equals("actualizar")) {
			actualizarDocente(request, response);
		} else if (tipo.equals("eliminar")) {
			eliminarDocente(request, response);
		} else if (tipo.equals("actualizar-vista")) {
			obtenerActualizarVista(request, response);
		} else if (tipo.equals("registrar")) {
			registrarDocente(request, response);
		} else if (tipo.equals("buscar")) {
			buscarDocente(request, response);
		}
	}
	
	private void listarDocentes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Docente> docentes = ds.listarDocentes();
		request.setAttribute("docentes", docentes);
		request.getRequestDispatcher("listadoDocentes.jsp").forward(request, response);
	}

	private void eliminarDocente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cod = request.getParameter("cod");
		ds.eliminarDocente(cod);
		listarDocentes(request, response);
	}

	private void actualizarDocente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Docente docente = new Docente();
		docente.setCodigo(request.getParameter("codigo"));
		docente.setDni(Integer.parseInt(request.getParameter("dni")));
		docente.setNombres(request.getParameter("nombres"));
		docente.setApellidos(request.getParameter("apellidos"));

		ds.actualizarDocente(docente);
		listarDocentes(request, response);
	}

	private void obtenerActualizarVista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cod = request.getParameter("cod");
		List<Docente> docentes = ds.buscarDocente(cod);
		request.setAttribute("docente", docentes.get(0));
		request.getRequestDispatcher("actualizarDocente.jsp").forward(request, response);
	}
	
	private void registrarDocente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Docente docente = new Docente();
		docente.setCodigo(utils.GenerarCodigo.gcDocente());
		docente.setDni(Integer.parseInt(request.getParameter("dni")));
		docente.setNombres(request.getParameter("nombres"));
		docente.setApellidos(request.getParameter("apellidos"));

		ds.registrarDocente(docente);
		listarDocentes(request, response);
	}
	
	private void buscarDocente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cod = request.getParameter("cod");
		List<Docente> docentes = ds.buscarDocente(cod);
		request.setAttribute("docentes", docentes);
		request.getRequestDispatcher("listadoDocentes.jsp").forward(request, response);
	}
}
