package Persistencia;

import java.sql.*;
import java.util.ArrayList;

public class ClienteDAC {

	public ClienteDAC() {

	}

	public Connection abrirConexion() {
		Connection conexion = null;
		try {
			Class.forName("org.sqlite.JDBC");
			conexion = DriverManager
					.getConnection("jdbc:sqlite:C:/sampleDario.db");
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.err.println(e.getMessage());
		}
		return conexion;
	}

	public static ArrayList<String[]> getClientes() {
		
		ClienteDAC cliente = new ClienteDAC();
		Connection conn = cliente.abrirConexion();
		ArrayList<String[]> array = new ArrayList<String[]>();
		try 
		{			
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30); // Seteo timeout máximo 30 segundos.
			ResultSet rs = statement.executeQuery("SELECT * FROM clientes");
			while (rs.next()) 
			{
				String[] vector = new String[4];
				vector[0] = String.valueOf(rs.getInt("id"));
				vector[1] = rs.getString("nombre");
				vector[2] = rs.getString("apellido");
				vector[3] = String.valueOf(rs.getInt("telefono"));
				array.add(vector);
			}			
			conn.close(); // Cierro conexion.
		} 
		catch (Exception e) 
		{
			System.err.println(e.getMessage());
		}
		return array;
	}

	public static void crearClientesDePrueba() {
		try {
			ClienteDAC cliente = new ClienteDAC();
			Connection conn = cliente.abrirConexion();

			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30); // Seteo timeout máximo 30 segundos.
			statement.executeUpdate("drop table if exists CLIENTES");
			statement
					.executeUpdate("create table CLIENTES (id integer, nombre string, apellido string, telefono integer)");
			statement
					.executeUpdate("insert into CLIENTES values(1, 'Karen', 'Perez', 46600000)");
			statement
					.executeUpdate("insert into CLIENTES values(2, 'Darío', 'Rick', 42223456)");

			conn.close();// Cierro conexion.
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
