package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import interfaces.UsuarioDAO;
import modelo.Docente;
import modelo.Usuario;
import utils.Mysqlconexion;

public class MysqlUsuarioDAO implements UsuarioDAO {

	@Override
	public Usuario autenticar(Usuario usuario) {
		
		Usuario user = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			cn = Mysqlconexion.getConexion();
			String sql = "SELECT * FROM tbUsuario WHERE usuario=? AND clave=?;";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, usuario.getUsuario());
			pstm.setString(2, usuario.getClave());
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				user = new Usuario();
				user.setCodEstudiante(rs.getString(3));
				user.setClave(rs.getString(4));
				user.setIdRol(rs.getInt(5));
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
		
		return user;
	}

}
