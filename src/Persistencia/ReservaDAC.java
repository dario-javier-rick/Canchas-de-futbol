package Persistencia;

import java.sql.*;
import java.util.ArrayList;

public class ReservaDAC {

	public ReservaDAC() {

	}

	public ArrayList<String[]> obtenerReservas() {
		Connection conn = BBDD.abrirConexion();
		ArrayList<String[]> array = new ArrayList<String[]>();
		try {
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30); // Seteo timeout m�ximo 30 segundos.
			ResultSet rs = statement.executeQuery("SELECT * FROM reservas");
			while (rs.next()) {
				String[] vector = new String[5];
				vector[0] = String.valueOf(rs.getInt("idReserva"));
				vector[1] = String.valueOf(rs.getInt("idCliente"));
				vector[2] = String.valueOf(rs.getInt("idCancha"));
				vector[3] = String.valueOf(rs.getInt("horario"));
				vector[4] = String.valueOf(rs.getInt("realizada"));
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
			statement.setQueryTimeout(30); // Seteo timeout m�ximo 30 segundos.
			ResultSet rs = statement.executeQuery("SELECT idReserva FROM reservas WHERE idCliente = "
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
			statement.setQueryTimeout(30); // Seteo timeout m�ximo 30 segundos.
			statement.executeQuery("DELETE FROM canchas WHERE IdReserva = "
					+ IdReserva + ";");
			conn.close(); // Cierro conexion.
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
