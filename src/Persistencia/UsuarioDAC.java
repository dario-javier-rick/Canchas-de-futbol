package Persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class UsuarioDAC {

	public boolean validarDatos(String usuario, String password) {
		Connection conn = BBDD.abrirConexion();
		try {
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30); // Seteo timeout máximo 30 segundos.
			ResultSet rs = statement
					.executeQuery("SELECT contraseña FROM usuarios WHERE usuario = '"
							+ usuario + "' ORDER BY ROWID ASC LIMIT 1;");
			String passwordBBDD = "";
			
			if (!rs.isBeforeFirst())
				throw new RuntimeException("Usuario inexistente");
				
			
			
			while (rs.next()) {
				passwordBBDD = rs.getString("contraseña");
			}
			conn.close(); // Cierro conexion.
			System.out.println("Capa: UsuarioDAC Usuario =" + usuario +"; Password = " + password + "; PasswordBBDD = " + passwordBBDD +";");
			if (passwordBBDD.equals(password))
				return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		return false;
	}

	public ArrayList<String[]> getUsuarios() {

		Connection conn = BBDD.abrirConexion();
		ArrayList<String[]> array = new ArrayList<String[]>();
		try {
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30); // Seteo timeout máximo 30 segundos.
			ResultSet rs = statement.executeQuery("SELECT * FROM usuarios");
			while (rs.next()) {
				String[] vector = new String[4];
				vector[0] = String.valueOf(rs.getInt("idUsuario"));
				vector[1] = rs.getString("usuario");
				vector[2] = rs.getString("contraseña");
				vector[3] = rs.getString("email");
				vector[3] = String.valueOf(rs.getInt("nivelPermisos"));
				array.add(vector);
			}
			conn.close(); // Cierro conexion.
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return array;
	}

}
