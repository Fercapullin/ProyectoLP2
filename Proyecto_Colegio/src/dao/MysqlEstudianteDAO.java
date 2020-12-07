package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import interfaces.EstudianteDAO;
import modelo.Detalle_estudiante;
import modelo.Estudiante;
import utils.Mysqlconexion;

public class MysqlEstudianteDAO implements EstudianteDAO {

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

	@Override
	public List<Detalle_estudiante> listado(String cod) {
		Detalle_estudiante es = null;
		List<Detalle_estudiante> data = new ArrayList<Detalle_estudiante>();
		Connection cn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			cn = Mysqlconexion.getConexion();
			String sql = "{call usp_consulta_matricula(?)}";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, cod);
			rs = pstm.executeQuery();
			while (rs.next()) {
				es = new Detalle_estudiante();
				es.setNro_matri(rs.getString(1));
				es.setGrado(rs.getString(2));
				es.setSeccion(rs.getString(3));
				es.setNombredes(rs.getString(4));
				es.setCreditos(rs.getString(5));
				
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

	@Override
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

	@Override
	public String obtenerUltimoCod() {
		
		String ultimoCod = "";
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			cn = Mysqlconexion.getConexion();
			String sql = "SELECT MAX(codEstudiante) FROM tbEstudiante;";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				ultimoCod = rs.getString(1);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				if (pstm != null) pstm.close();
				if (rs != null) rs.close();
				if (cn != null) cn.close();
			} catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return ultimoCod;
	}

	@Override
	public int actualizarEstudiante(Estudiante obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminarEstudiante(String cod) {
		// TODO Auto-generated method stub
		return 0;
	}

}
