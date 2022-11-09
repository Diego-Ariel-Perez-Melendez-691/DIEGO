import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class DatosUsuario {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	
	public Connection conectar() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/usuarios511","root","");
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"eror al conbectar"+ e.getMessage());
		}
		return con;
	}
	public boolean insertavUsuario(vUsuario u) {
		boolean guardado=false;
		int guardar;

		String sql ="insert into usuario values (null,?,?,?,?)";
		try {
			ps = conectar().prepareStatement(sql);
			ps.setString(1, u.getNombre());
			ps.setString(2, u.getAp());
			ps.setString(3, u.getAm());
			ps.setString(4, u.getCurp());
			guardar = ps.executeUpdate();
			if(guardar>0){
				guardado=true;
			}else {
				guardado=false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"eror al guardar"+ e.getMessage());
			
		}
		
		return guardado;
	}
	public vUsuario consultaVUsuario(int id) {
		vUsuario u =new vUsuario();
		String sql="select * from usuario where id=?";
		try {
			ps=conectar().prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next()) {
				u.setId(rs.getInt(1));
				u.setNombre(rs.getString(2));
				u.setAp(rs.getString(3));
				u.setAm(rs.getString(4));
				u.setCurp(rs.getString(5));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"eror al consultar"+ e.getMessage());
				}
		
		
		return u;
	}
	public boolean actualizavUsuario(vUsuario u) {
		boolean actualizado=false;
		int actualizar;

		String sql ="update usuario set Nombre=?,Ap=? ,Am=? ,Curp=? where id=?";
		try {
			ps = conectar().prepareStatement(sql);
			ps.setString(1, u.getNombre());
			ps.setString(2, u.getAp());
			ps.setString(3, u.getAm());
			ps.setString(4, u.getCurp());
			ps.setInt(5, u.getId());
			actualizar= ps.executeUpdate();
			if(actualizar>0){
				actualizado=true;
			}else {
				actualizado=false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"eror al guardar"+ e.getMessage());
			
		}
		
		return actualizado;
	}
	public boolean eliminarVUsuario(int id) {
		String sql="delete  from usuario where id=?";
		boolean eliminado=false ;
		int eliminar;
		try {
			ps=conectar().prepareStatement(sql);
			ps.setInt(1, id);
			eliminar=ps.executeUpdate();
			if(eliminar>0) {
				eliminado=true;
			}else {
				eliminado=false;
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"eror al eliminar"+ e.getMessage());
		}
		
		
		return eliminado;
	}
}
