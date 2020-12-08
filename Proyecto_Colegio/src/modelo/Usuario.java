package modelo;

public class Usuario {
	
	private int idUsuario;
	private String codDocente;
	private String codEstudiante;
	private String usuario;
	private String clave;
	private int idRol;
	
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getCodDocente() {
		return codDocente;
	}
	public void setCodDocente(String codDocente) {
		this.codDocente = codDocente;
	}
	public String getCodEstudiante() {
		return codEstudiante;
	}
	public void setCodEstudiante(String codEstudiante) {
		this.codEstudiante = codEstudiante;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public int getIdRol() {
		return idRol;
	}
	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}
}
