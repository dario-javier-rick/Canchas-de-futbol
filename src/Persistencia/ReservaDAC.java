package Persistencia;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class ReservaDAC {

	public ReservaDAC() {

	}

	public ArrayList<String[]> obtenerReservas() {
		Connection conn = BBDD.abrirConexion();
		ArrayList<String[]> array = new ArrayList<String[]>();
		try {
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30); // Seteo timeout máximo 30 segundos.
			ResultSet rs = statement.executeQuery("SELECT * FROM reservas");
			while (rs.next()) {
				String[] vector = new String[7];
				vector[0] = String.valueOf(rs.getInt("idReserva"));
				vector[1] = String.valueOf(rs.getInt("idCliente"));
				vector[2] = String.valueOf(rs.getInt("idCancha"));
				vector[3] = rs.getString("horario");
				vector[4] = String.valueOf(rs.getInt("tiempo"));
				vector[5] = String.valueOf(rs.getInt("seña"));
				vector[6] = String.valueOf(rs.getInt("realizada"));
				array.add(vector);
			}
			conn.close(); // Cierro conexion.
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return array;
	}

	public ArrayList<String[]> obtenerReservas(int dayOfMonth, int month,
			int year) {
		Connection conn = BBDD.abrirConexion();
		ArrayList<String[]> array = new ArrayList<String[]>();
		String dia = String.format("%02d", dayOfMonth);
		String mes = String.format("%02d", month);
		String año = String.format("%02d", year);
		try {
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30); // Seteo timeout máximo 30 segundos.
			ResultSet rs = statement
					.executeQuery("SELECT * FROM reservas WHERE horario like '"
							+ dia + "-" + mes + "-" + año + "%'");			
			while (rs.next()) {
				String[] vector = new String[7];
				vector[0] = String.valueOf(rs.getInt("idReserva"));
				vector[1] = String.valueOf(rs.getInt("idCliente"));
				vector[2] = String.valueOf(rs.getInt("idCancha"));
				vector[3] = rs.getString("horario");
				vector[4] = String.valueOf(rs.getInt("tiempo"));
				vector[5] = String.valueOf(rs.getInt("seña"));
				vector[6] = String.valueOf(rs.getInt("realizada"));
				array.add(vector);
			}
			conn.close(); // Cierro conexion.
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return array;
	}

	public int obtenerIdReserva(int idCliente, int idCancha, Date horario) {
		int resultado = 0;
		try {
			Connection conn = BBDD.abrirConexion();
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30); // Seteo timeout máximo 30 segundos.
			ResultSet rs = statement
					.executeQuery("SELECT idReserva FROM reservas WHERE idCliente = "
							+ idCliente + ";");
			if (rs.next()) {
				resultado = rs.getInt(1);
			}
			conn.close(); // Cierro conexion.
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return resultado;
	}

	public void eliminarReserva(int IdReserva) {
		try {
			Connection conn = BBDD.abrirConexion();
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30); // Seteo timeout máximo 30 segundos.
			statement.executeQuery("DELETE FROM reservas WHERE IdReserva = "
					+ IdReserva + ";");
			conn.close(); // Cierro conexion.
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public void eliminarReservaPorCancha(int idCancha) {
		try {
			Connection conn = BBDD.abrirConexion();
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30); // Seteo timeout máximo 30 segundos.
			statement.executeQuery("DELETE FROM reservas WHERE idCancha = "
					+ idCancha + ";");
			conn.close(); // Cierro conexion.
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public void eliminarReservaPorCliente(int idCliente) {
		try {
			Connection conn = BBDD.abrirConexion();
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30); // Seteo timeout máximo 30 segundos.
			statement.executeQuery("DELETE FROM reservas WHERE idCliente = "
					+ idCliente + ";");
			conn.close(); // Cierro conexion.
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public void persistirReserva(int idReserva, int idCliente, int idCancha,
			String horario, int tiempo, int seña, Boolean realizada) {
		Connection conn = BBDD.abrirConexion();
		try {
			
			int concretada = 0;
			if (realizada)
				concretada = 1;
			
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30); // Seteo timeout máximo 30 segundos.
			PreparedStatement prep = conn
					.prepareStatement("INSERT INTO reservas VALUES (?,?,?,?,?,?,?);");
			
			prep.setInt(1, idReserva);
			prep.setInt(2, idCliente);
			prep.setInt(3, idCancha);
			prep.setString(4, horario);
			prep.setInt(5, tiempo);
			prep.setInt(6, seña);
			prep.setInt(7, concretada);
			 
			conn.setAutoCommit(false);
			prep.executeUpdate();
			conn.commit();
			conn.setAutoCommit(true);
			conn.close(); // Cierro conexion.

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public int getUltimoIdReserva() {
		int resultado = 0;
		try {
			Connection conn = BBDD.abrirConexion();
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30); // Seteo timeout máximo 30 segundos.
			ResultSet rs = statement
					.executeQuery("SELECT MAX(idReserva) FROM reservas;");
			if (rs.next()) {
				resultado = rs.getInt(1);
			}
			conn.close(); // Cierro conexion.
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return resultado;
	}

}
