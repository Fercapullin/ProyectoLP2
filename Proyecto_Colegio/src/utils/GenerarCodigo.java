package utils;

import java.util.Date;

import service.DocenteService;
import service.Estudianteservice;

public class GenerarCodigo {
	
	static DocenteService ds = new DocenteService();
	static Estudianteservice es = new Estudianteservice();
	static int anio = 2020;
	
	public static String gcDocente() {
		
		String nuevoCod = obtenerNuevoNum(ds.obtenerUltimoCod().substring(5, 10));
		
		return "d"+anio+nuevoCod;
	}
	
	public static String gcEstudiante() {
		
		String nuevoCod = obtenerNuevoNum(es.obtenerUltimoCod().substring(5, 10));
		
		return "e"+anio+nuevoCod;
	}
	
	private static String obtenerNuevoNum(String cod) {
		
		String newNum = null;
		
		try {
			int num = Integer.parseInt(cod);
			num++;
			newNum = String.valueOf(num);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return newNum;
	}
}
