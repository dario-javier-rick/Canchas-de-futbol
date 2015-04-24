package Persistencia;

import java.sql.*;
import java.util.ArrayList;

public class ClienteDAC {

	public ClienteDAC() {

	}

	public Connection abrirConexion() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "canchas_futbol";
		String userName = "root";
		String password = "123456";
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager
					.getConnection(url + dbName, userName, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public ArrayList getClientes() throws SQLException {
		Connection conn = this.abrirConexion();
		CallableStatement cStmt = conn.prepareCall("{call demoSp(?, ?)}");
		cStmt.setString(1, "abcdefg");
		
		return null;

	}

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "canchas_futbol";
		String userName = "root";
		String password = "123456";
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = DriverManager.getConnection(url + dbName,
					userName, password);

			Statement st = conn.createStatement();
			ResultSet res = st.executeQuery("SELECT * FROM  clientes");
			ResultSetMetaData rsmd = res.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			while (res.next()) {
				for (int i = 1; i <= columnsNumber; i++) {
					if (i > 1)
						System.out.print(",  ");
					String columnValue = res.getString(i);
					System.out.print(columnValue + " " + rsmd.getColumnName(i));
				}
				System.out.println("");
			}

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
