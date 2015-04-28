package Logica;

import java.awt.Image;
import java.sql.SQLException;
import java.util.ArrayList;

import Persistencia.ClienteDAC;

public class Cliente {

	static ClienteDAC DAC;

	String nombre;
	String apellido;
	int telefono;
	Image foto;

	public Cliente(String nombre, String apellido, int telefono) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
	}

	public static ArrayList<Cliente> getClientes() {		
		ArrayList<Cliente> arrayClientes = new ArrayList<Cliente>();
		try {
			ArrayList<String[]> array = ClienteDAC.getClientes();

			for (int i = 0; i < array.size(); i++) {
				Cliente cliente = new Cliente(array.get(i)[1], array.get(i)[2],
						Integer.parseInt(array.get(i)[3]));
				arrayClientes.add(cliente);
				System.out.println(cliente);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrayClientes;
	}

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", apellido=" + apellido
				+ ", telefono=" + telefono + ", foto=" + foto + "]";
	}
	
	

}
