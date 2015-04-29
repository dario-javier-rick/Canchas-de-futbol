package Logica;

import java.awt.Image;
import java.sql.SQLException;
import java.util.ArrayList;

import Persistencia.ClienteDAC;

public class Cliente {

	String nombre;
	String apellido;
	int telefono;
	Image foto;
	private static ClienteDAC DAC = new ClienteDAC();

	public Cliente() {

	}

	public Cliente(String nombre, String apellido, int telefono,
			boolean persistirCliente) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		if (persistirCliente) {
			DAC.persistirCliente(nombre, apellido, telefono);
		}
	}

	public static ArrayList<Cliente> getClientes() {
		ArrayList<Cliente> arrayClientes = new ArrayList<Cliente>();
		try {
			ArrayList<String[]> array = DAC.getClientes();

			for (int i = 0; i < array.size(); i++) {
				Cliente cliente = new Cliente(array.get(i)[1], array.get(i)[2],
						Integer.parseInt(array.get(i)[3]), false);
				arrayClientes.add(cliente);
				System.out.println(cliente);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return arrayClientes;
	}

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", apellido=" + apellido
				+ ", telefono=" + telefono + ", foto=" + foto + "]";
	}

}
