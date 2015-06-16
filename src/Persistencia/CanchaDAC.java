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
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				conn.close(); // Cierro conexion.
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}
		return array;
	}

	public String[] obtenerCancha(int idCancha) {
		Connection conn = BBDD.abrirConexion();
		String[] datos = new String[5];
		try {
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30); // Seteo timeout máximo 30 segundos.
			ResultSet rs = statement
					.executeQuery("SELECT * FROM canchas WHERE idCancha = "
							+ idCancha + ";");
			if (rs.next()) {
				datos[0] = String.valueOf(rs.getInt("idCancha"));
				datos[1] = rs.getString("nombre");
				datos[2] = rs.getString("tipo_cancha");
				datos[3] = String.valueOf(rs.getInt("maxJugadores"));
				datos[4] = String.valueOf(rs.getInt("precioPorHora"));
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				conn.close(); // Cierro conexion.
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}
		return datos;
	}

	public int obtenerIdCancha(String nombre, String tipo_cancha,
			int maxJugadores, int precioPorHora) {

		Connection conn = BBDD.abrirConexion();
		int resultado = 0;
		try {

			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30); // Seteo timeout máximo 30 segundos.
			ResultSet rs = statement
					.executeQuery("SELECT idCancha FROM canchas WHERE nombre = "
							+ nombre + ";");
			if (rs.next()) {
				resultado = rs.getInt(1);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				conn.close(); // Cierro conexion.
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}
		return resultado;
	}

	public void eliminarCancha(int idCancha) {
		Connection conn = BBDD.abrirConexion();
		try {
			conn.setAutoCommit(false);
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30); // Seteo timeout máximo 30 segundos.
			statement.execute("DELETE FROM canchas WHERE idCancha = "
					+ idCancha + ";");
			conn.commit();
			conn.setAutoCommit(true);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				conn.close(); // Cierro conexion.
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}
	}

	public void persistirCancha(int idCancha, String nombre,
			String tipo_cancha, int precioPorHora, int maxJugadores) {
		Connection conn = BBDD.abrirConexion();
		try {
			PreparedStatement prep = conn
					.prepareStatement("INSERT INTO canchas VALUES (?,?,?,?,?);");
			prep.setInt(1, idCancha);
			prep.setString(2, nombre);
			prep.setString(3, tipo_cancha);
			prep.setInt(4, maxJugadores);
			prep.setInt(5, precioPorHora);
			conn.setAutoCommit(false);
			prep.executeUpdate();
			conn.commit();
			conn.setAutoCommit(true);

		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				conn.close(); // Cierro conexion.
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}
	}

	public int getUltimoIdCancha() {
		Connection conn = BBDD.abrirConexion();
		int resultado = 0;
		try {
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30); // Seteo timeout máximo 30 segundos.
			ResultSet rs = statement
					.executeQuery("SELECT MAX(idCancha) FROM canchas;");
			if (rs.next()) {
				resultado = rs.getInt(1);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				conn.close(); // Cierro conexion.
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}
		return resultado;
	}

	public boolean verificarExistenciaCancha(int idCancha) {
		Connection conn = BBDD.abrirConexion();
		try {
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30); // Seteo timeout máximo 30 segundos.
			ResultSet rs = statement
					.executeQuery("SELECT idCancha FROM canchas WHERE idCancha = "
							+ idCancha + ";");
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				conn.close();// Cierro conexion.
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}
		return false;
	}

}
