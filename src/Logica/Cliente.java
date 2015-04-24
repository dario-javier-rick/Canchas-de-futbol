package Logica;

import java.awt.Image;
import java.sql.SQLException;
import java.util.ArrayList;

import Persistencia.ClienteDAC;

public class Cliente {
	
	String nombre;
	int telefono;
	Image foto;
	static ClienteDAC DAC;
	
	public Cliente(){
		ClienteDAC DAC = new ClienteDAC();

	}
	
	public static ArrayList<Cliente> getClientes(){
		try {
			return DAC.getClientes();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
