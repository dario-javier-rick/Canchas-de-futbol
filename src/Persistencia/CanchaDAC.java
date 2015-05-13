package Persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CanchaDAC {

	public ArrayList<String[]> obtenerCanchas() {
		// Corregir método!
		Connection conn = BBDD.abrirConexion();
		ArrayList<String[]> array = new ArrayList<String[]>();
		try {
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30); // Seteo timeout máximo 30 segundos.
			ResultSet rs = statement.executeQuery("SELECT * FROM canchas");
			while (rs.next()) {
				String[] vector = new String[4];
				vector[0] = String.valueOf(rs.getInt("idCliente"));
				vector[1] = rs.getString("nombre");
				vector[2] = rs.getString("apellido");
				vector[3] = String.valueOf(rs.getInt("telefono"));
				vector[4] = String.valueOf(rs.getInt("telefono"));
				array.add(vector);
			}
			conn.close(); // Cierro conexion.
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return array;
	}

}
