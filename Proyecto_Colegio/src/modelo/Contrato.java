package modelo;

import java.util.Date;

public class Contrato {
	
	private int nroContrato;
	private String nombresDocente;
	private String apellidosDocente;
	private Date fechaInicio;
	private Date fechaFin;
	private String estado;
	
	public int getNroContrato() {
		return nroContrato;
	}
	public void setNroContrato(int nroContrato) {
		this.nroContrato = nroContrato;
	}
	public String getNombresDocente() {
		return nombresDocente;
	}
	public void setNombresDocente(String nombresDocente) {
		this.nombresDocente = nombresDocente;
	}
	public String getApellidosDocente() {
		return apellidosDocente;
	}
	public void setApellidosDocente(String apellidosDocente) {
		this.apellidosDocente = apellidosDocente;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
}
