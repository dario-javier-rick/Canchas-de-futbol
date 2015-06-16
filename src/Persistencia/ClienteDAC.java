package Persistencia;

import java.sql.*;
import java.util.ArrayList;

public class ClienteDAC {

	public ClienteDAC() {

	}

	public ArrayList<String[]> obtenerClientes() {
		Connection conn = BBDD.abrirConexion();
		ArrayList<String[]> array = new ArrayList<String[]>();
		try {
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30); // Seteo timeout máximo 30 segundos.
			ResultSet rs = statement.executeQuery("SELECT * FROM clientes");
			while (rs.next()) {
				String[] vector = new String[4];
				vector[0] = String.valueOf(rs.getInt("idCliente"));
				vector[1] = rs.getString("nombre");
				vector[2] = rs.getString("apellido");
				vector[3] = String.valueOf(rs.getInt("telefono"));
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

	public String[] obtenerCliente(int idCliente) {
		Connection conn = BBDD.abrirConexion();
		String[] datos = new String[4];
		try {
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30); // Seteo timeout máximo 30 segundos.
			ResultSet rs = statement
					.executeQuery("SELECT * FROM clientes WHERE idCliente = "
							+ idCliente + ";");
			if (rs.next()) {
				datos[0] = String.valueOf(rs.getInt("idCliente"));
				datos[1] = rs.getString("nombre");
				datos[2] = rs.getString("apellido");
				datos[3] = String.valueOf(rs.getInt("telefono"));
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

	public void persistirCliente(int idCliente, String nombre, String apellido,
			int telefono) {
		Connection conn = BBDD.abrirConexion();
		try {
			PreparedStatement prep = conn
					.prepareStatement("INSERT INTO clientes VALUES (?,?,?,?);");
			prep.setInt(1, idCliente);
			prep.setString(2, nombre);
			prep.setString(3, apellido);
			prep.setInt(4, telefono);
			conn.setAutoCommit(false);
			prep.executeUpdate();
			conn.commit();
			conn.setAutoCommit(true);

		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				conn.close(); // Cierro conexion.
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}
	}

	public int obteneridCliente(String nombre, String apellido, int telefono) {
		int resultado = 0;
		Connection conn = BBDD.abrirConexion();
		try {
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30); // Seteo timeout máximo 30 segundos.
			ResultSet rs = statement
					.executeQuery("SELECT idCliente FROM clientes WHERE nombre = "
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

	public void eliminarCliente(int idCliente) {
		Connection conn = BBDD.abrirConexion();
		try {
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30); // Seteo timeout máximo 30 segundos.
			statement.executeQuery("DELETE FROM clientes WHERE idCliente = "
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

	public int getUltimoIdCliente() {
		Connection conn = BBDD.abrirConexion();
		int resultado = 0;
		try {
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30); // Seteo timeout máximo 30 segundos.
			ResultSet rs = statement
					.executeQuery("SELECT MAX(idCliente) FROM clientes;");
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

	public boolean verificarExistenciaCliente(int idCliente) {
		Connection conn = BBDD.abrirConexion();
		try {

			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30); // Seteo timeout máximo 30 segundos.
			ResultSet rs = statement
					.executeQuery("SELECT idCliente FROM clientes WHERE idCliente = "
							+ idCliente + ";");
			if (rs.next()) {
				return true;
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
		return false;
	}

}
