package Persistencia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BBDD {

	private static String Path = "C:/PROG3_TP2_BBDD.db";

	public static Connection abrirConexion() {
		Connection conexion = null;
		try {
			Class.forName("org.sqlite.JDBC");
			conexion = DriverManager.getConnection("jdbc:sqlite:" + Path);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.err.println(e.getMessage());
		}
		return conexion;
	}

	public static void verificarExistenciaBBDD() {
		if (!new File(Path).isFile())
			crearBBDD();
	}

	private static void crearBBDD() {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager
					.getConnection("jdbc:sqlite:" + Path);
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30); // Seteo timeout máximo 30 segundos.
			statement
					.executeUpdate(leerArchivo("src/Persistencia/lib/Query_Create.sql"));
			statement
					.executeUpdate(leerArchivo("src/Persistencia/lib/Query_Insert.sql"));
			conn.close();// Cierro conexion.
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	private static String leerArchivo(String path) {
		String contenido = "";
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(path)));
			try {
				String linea;
				while ((linea = br.readLine()) != null) {
					contenido = contenido + linea;
				}
			} finally {
				br.close();
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return contenido;
	}

}
