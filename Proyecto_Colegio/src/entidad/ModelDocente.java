package entidad;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import modelo.Docente;
import utils.Mysqlconexion;

public class ModelDocente {

	public List<Docente> listarDocentes() {
		
		List<Docente> docentes = new ArrayList<Docente>();
		Docente docente = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			cn = Mysqlconexion.getConexion();
			String sql = "SELECT * FROM tbDocente";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				docente = new Docente();
				docente.setCodigo(rs.getString(1));
				docente.setDni(rs.getInt(2));
				docente.setNombres(rs.getString(3));
				docente.setApellidos(rs.getString(4));
				docentes.add(docente);
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
		
		return docentes;
	}
	
	public int registrarDocente(Docente docente) {
		
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		
		try {
			cn = Mysqlconexion.getConexion();
			String sql = "INSERT INTO tbDocente(codDocente,dni,nombres,apellidos) VALUES(?,?,?,?)";
			pstm.setString(1, docente.getCodigo());
			pstm.setInt(2, docente.getDni());
			pstm.setString(3, docente.getNombres());
			pstm.setString(4, docente.getApellidos());
			estado = pstm.executeUpdate();
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
		
		return estado;
	}
	
	public int actualizarDocente(Docente docente) {
		
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		
		try {
			cn = Mysqlconexion.getConexion();
			String sql = "UPDATE tbDocente SET dni=?,nombres=?,apellidos=? WHERE codDocente=?";
			pstm.setInt(1, docente.getDni());
			pstm.setString(2, docente.getNombres());
			pstm.setString(3, docente.getApellidos());
			pstm.setString(4, docente.getCodigo());
			estado = pstm.executeUpdate();
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
		
		return estado;
	}
	
	public int eliminarDocente(String codigo) {
		
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		
		try {
			cn = Mysqlconexion.getConexion();
			String sql = "DELETE FROM tbDocente WHERE codDocente=?";
			pstm.setString(1, codigo);
			estado = pstm.executeUpdate();
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
		
		return estado;
	}
}
