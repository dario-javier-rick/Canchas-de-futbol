package Persistencia;

import java.sql.*;
import java.util.ArrayList;

public class CanchaDAC {

	public CanchaDAC() {

	}

	public ArrayList<String[]> obtenerCanchas() {
		Connection conn = BBDD.abrirConexion();
		ArrayList<String[]> array = new ArrayList<String[]>();
		try {
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30); // Seteo timeout máximo 30 segundos.
			ResultSet rs = statement.executeQuery("SELECT * FROM canchas");
			while (rs.next()) {
				String[] vector = new String[5];
				vector[0] = String.valueOf(rs.getInt("idCancha"));
				vector[1] = rs.getString("nombre");
				vector[2] = rs.getString("tipo_cancha");
				vector[3] = String.valueOf(rs.getInt("maxJugadores"));
				vector[4] = String.valueOf(rs.getInt("precioPorHora"));
				array.add(vector);
			}
			conn.close(); // Cierro conexion.
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return array;
	}

	public int obtenerIdCancha(String nombre, String tipo_cancha,
			int maxJugadores, int precioPorHora) {
		int resultado = 0;
		try {
			Connection conn = BBDD.abrirConexion();
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30); // Seteo timeout máximo 30 segundos.
			ResultSet rs = statement
					.executeQuery("SELECT idCancha FROM canchas WHERE nombre = "
							+ nombre + ";");
			if (rs.next()) {
				resultado = rs.getInt(1);
			}
			conn.close(); // Cierro conexion.
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return resultado;
	}

	public void eliminarCancha(int idCancha) {
		try {
			Connection conn = BBDD.abrirConexion();
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30); // Seteo timeout máximo 30 segundos.
			statement.executeQuery("DELETE FROM canchas WHERE idCancha = "
					+ idCancha + ";");
			conn.close(); // Cierro conexion.
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
