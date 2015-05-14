package Persistencia;

import java.sql.*;
import java.util.ArrayList;

public class ReservaDAC {
	
	public ReservaDAC()
	{
		
	}
	
	public ArrayList<String[]> obtenerReservas() {
		Connection conn = BBDD.abrirConexion();
		ArrayList<String[]> array = new ArrayList<String[]>();
		try {
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30); // Seteo timeout máximo 30 segundos.
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

}
