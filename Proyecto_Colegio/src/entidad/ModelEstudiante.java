package entidad;
import java.sql.*;
import modelo.Estudiante;
import utils.Mysqlconexion;

import java.util.*;
public class ModelEstudiante {

	public List<Estudiante> listar() {
		Estudiante es = null;
		List<Estudiante> data = new ArrayList<Estudiante>();
		Connection cn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			cn = Mysqlconexion.getConexion();
			String sql = "select *from tbEstudiante";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				es = new Estudiante();
				es.setCodestudiant(rs.getString(1));
				es.setNombre(rs.getString(2));
				es.setApellido(rs.getString(3));
				es.setDni(rs.getInt(4));
				es.setId_grado(rs.getString(5));
				
				data.add(es);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (cn != null)
					cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return data;
	}
	
	
	public Estudiante buscarEstudiante(String cod) {
		
		Estudiante es = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = Mysqlconexion.getConexion();
			String sql = "select *from tbEstudiante where cod_alu=?";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, cod);
			rs = pstm.executeQuery();
			if (rs.next()) {
				es = new Estudiante();
				es.setCodestudiant(rs.getString(1));
				es.setNombre(rs.getString(2));
				es.setApellido(rs.getString(3));
				es.setDni(rs.getInt(4));
				es.setId_grado(rs.getString(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (cn != null)
					cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return es;
	}
	
	
	public int registrarEstudiante(Estudiante obj) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = Mysqlconexion.getConexion();
			String sql = "Insert into tbestudiante (codEstudiante,nombres,apellidos,dni,idGrado) values(?,?,?,?,?)";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, obj.getCodestudiant());
			pstm.setString(2, obj.getNombre());
			pstm.setString(3, obj.getApellido());
			pstm.setInt(4, obj.getDni());
			pstm.setString(5, obj.getId_grado());
			estado = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (cn != null)
					cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return estado;
	}
	
	
    public int actualizarEstudiante(Estudiante obj) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = Mysqlconexion.getConexion();
			String sql = "update tbEstudiante set nombres=?,apellidos=?, dni=?,idGrado=? where codEstudiante=?";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, obj.getNombre());
			pstm.setString(2, obj.getApellido());
			pstm.setInt(3, obj.getDni());
			pstm.setString(4, obj.getId_grado());
			pstm.setString(5, obj.getCodestudiant());
			estado = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (cn != null)
					cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return estado;
	}


   	public int eliminarEstudiante( String cod) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = Mysqlconexion.getConexion();
			String sql = "delete from tbEstudiante where codEstudiante=?";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, cod);
			estado = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (cn != null)
					cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return estado;
	}

}
