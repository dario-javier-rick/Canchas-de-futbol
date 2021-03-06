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
			statement.setQueryTimeout(30); // Seteo timeout m�ximo 30 segundos.
			ResultSet rs = statement.executeQuery("SELECT * FROM reservas");
			while (rs.next()) {
				String[] vector = new String[7];
				vector[0] = String.valueOf(rs.getInt("idReserva"));
				vector[1] = String.valueOf(rs.getInt("idCliente"));
				vector[2] = String.valueOf(rs.getInt("idCancha"));
				vector[3] = rs.getString("horario");
				vector[4] = String.valueOf(rs.getInt("tiempo"));
				vector[5] = String.valueOf(rs.getInt("se�a"));
				vector[6] = String.valueOf(rs.getInt("realizada"));
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

	public ArrayList<String[]> obtenerReservas(int dayOfMonth, int month,
			int year) {
		Connection conn = BBDD.abrirConexion();
		ArrayList<String[]> array = new ArrayList<String[]>();
		String dia = String.format("%02d", dayOfMonth);
		String mes = String.format("%02d", month);
		String a�o = String.format("%02d", year);
		try {
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30); // Seteo timeout m�ximo 30 segundos.
			ResultSet rs = statement
					.executeQuery("SELECT * FROM reservas WHERE horario like '"
							+ dia + "-" + mes + "-" + a�o + "%'");
			while (rs.next()) {
				String[] vector = new String[7];
				vector[0] = String.valueOf(rs.getInt("idReserva"));
				vector[1] = String.valueOf(rs.getInt("idCliente"));
				vector[2] = String.valueOf(rs.getInt("idCancha"));
				vector[3] = rs.getString("horario");
				vector[4] = String.valueOf(rs.getInt("tiempo"));
				vector[5] = String.valueOf(rs.getInt("se�a"));
				vector[6] = String.valueOf(rs.getInt("realizada"));
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

	public int obtenerIdReserva(int idCliente, int idCancha, Date horario) {
		Connection conn = BBDD.abrirConexion();
		int resultado = 0;
		try {

			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30); // Seteo timeout m�ximo 30 segundos.
			ResultSet rs = statement
					.executeQuery("SELECT idReserva FROM reservas WHERE idCliente = "
							+ idCliente + ";");
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

	public void eliminarReserva(int IdReserva) {
		Connection conn = BBDD.abrirConexion();
		try {

			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30); // Seteo timeout m�ximo 30 segundos.
			statement.executeUpdate("DELETE FROM reservas WHERE IdReserva = "
					+ IdReserva + ";");
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

	public void eliminarReservaPorCancha(int idCancha) {
		Connection conn = BBDD.abrirConexion();
		try {
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30); // Seteo timeout m�ximo 30 segundos.
			statement.executeUpdate("DELETE FROM reservas WHERE idCancha = "
					+ idCancha + ";");
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

	public void eliminarReservaPorCliente(int idCliente) {
		Connection conn = BBDD.abrirConexion();
		try {
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30); // Seteo timeout m�ximo 30 segundos.
			statement.executeUpdate("DELETE FROM reservas WHERE idCliente = "
					+ idCliente + ";");
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

	public void persistirReserva(int idReserva, int idCliente, int idCancha,
			String horario, int tiempo, int se�a, Boolean realizada) {
		Connection conn = BBDD.abrirConexion();
		try {	
			int concretada = 0;
			if (realizada)
				concretada = 1;

			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30); // Seteo timeout m�ximo 30 segundos.

			PreparedStatement prep = conn
					.prepareStatement("INSERT INTO reservas VALUES (?,?,?,?,?,?,?);");
			prep.setInt(1, idReserva);
			prep.setInt(2, idCliente);
			prep.setInt(3, idCancha);
			prep.setString(4, horario);
			prep.setInt(5, tiempo);
			prep.setInt(6, se�a);
			prep.setInt(7, concretada);
			conn.setAutoCommit(false);
			prep.executeUpdate();
			conn.commit();
			conn.setAutoCommit(true);

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		finally {
			try {
				conn.close(); // Cierro conexion.
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}
	}

	public int getUltimoIdReserva() {
		int resultado = 0;
		Connection conn = BBDD.abrirConexion();
		try {
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30); // Seteo timeout m�ximo 30 segundos.
			ResultSet rs = statement
					.executeQuery("SELECT MAX(idReserva) FROM reservas;");
			if (rs.next()) {
				resultado = rs.getInt(1);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}finally {
			try {
				conn.close(); // Cierro conexion.
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}
		return resultado;
	}

	public void concretar(int idReserva) {
		Connection conn = BBDD.abrirConexion();
		try {			
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30); // Seteo timeout m�ximo 30 segundos.
			PreparedStatement prep = conn
					.prepareStatement("UPDATE reservas SET realizada = 1 WHERE idReserva = "
							+ idReserva + " ;");
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

	public boolean chequearEstado(int idReserva) {
		int resultado = 0;
		Connection conn = BBDD.abrirConexion();
		try {
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30); // Seteo timeout m�ximo 30 segundos.
			ResultSet rs = statement
					.executeQuery("SELECT realizada FROM reservas WHERE idReserva = "
							+ idReserva + ";");
			if (rs.next()) {
				resultado = rs.getInt(1);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		finally {
			try {
				conn.close(); // Cierro conexion.
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}
		if (resultado == 1)
			return true;
		else
			return false;
	}


}
