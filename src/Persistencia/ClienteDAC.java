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
			conn.close(); // Cierro conexion.
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return array;
	}

	public void persistirCliente(String nombre, String apellido, int telefono) {
		Connection conn = BBDD.abrirConexion();
		Statement statement;
		try {
			statement = conn.createStatement();
			statement.setQueryTimeout(30); // Seteo timeout máximo 30 segundos.
			statement.executeUpdate("insert into CLIENTES values('" + nombre
					+ "', '" + apellido + "', " + telefono + ")");
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

}
