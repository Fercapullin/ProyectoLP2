package entidad;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import modelo.Contrato;
import modelo.DetalleContrato;
import modelo.Docente;
import utils.Mysqlconexion;

public class ModelContrato {
	
	public List<Contrato> getContratoPorCod(String codigo) {
		
		List<Contrato> contratos = new ArrayList<Contrato>();
		Contrato contrato = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			cn = Mysqlconexion.getConexion();
			String sql = "SELECT c.nroContrato,d.nombres,d.apellidos,c.fechaInicio,c.fechaFin,e.descEstado FROM tbContrato AS c INNER JOIN tbDocente AS d ON c.codDocente=d.codDocente INNER JOIN tbEstadoDocumento AS e ON c.idEstado=e.idEstado WHERE c.codDocente=?";
			pstm.setString(1, codigo);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				contrato = new Contrato();
				contrato.setNroContrato(rs.getInt(1));
				contrato.setNombresDocente(rs.getString(2));
				contrato.setApellidosDocente(rs.getString(3));
				contrato.setFechaInicio(new java.util.Date(rs.getDate(4).getTime()));
				contrato.setFechaFin(new java.util.Date(rs.getDate(5).getTime()));
				contrato.setEstado(rs.getString(6));
				contratos.add(contrato);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				if (pstm != null) pstm.close();
				if (cn != null) cn.close();
			} catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return contratos;
	}
	
	public List<DetalleContrato> cursosPorContrato(int nroContrato) {
		
		List<DetalleContrato> cursosPorContrato = new ArrayList<DetalleContrato>();
		DetalleContrato curso = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			cn = Mysqlconexion.getConexion();
			String sql = "SELECT dc.nroContrato,g.grado,g.seccion,c.nombreDesc FROM tbDetalleContrato AS dc INNER JOIN tbGrado AS g ON dc.idGrado=g.idGrado INNER JOIN tbCurso AS c ON dc.idCurso=c.idCurso WHERE dc.nroContrato=?;";
			pstm.setInt(1, nroContrato);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				curso = new DetalleContrato();
				curso.setNroContrato(rs.getInt(1));
				curso.setGrado(rs.getString(2));
				curso.setSeccion(rs.getString(3));
				curso.setCurso(rs.getString(4));
				cursosPorContrato.add(curso);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				if (pstm != null) pstm.close();
				if (cn != null) cn.close();
			} catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return cursosPorContrato;
	}
}
