package Logica;

import java.awt.Image;
import java.util.ArrayList;

import Persistencia.ClienteDAC;

public class Cliente {

	private String nombre;
	private String apellido;
	int telefono;
	Image foto;
	private static ClienteDAC DAC = new ClienteDAC();

	public Cliente() {

	}

	public Cliente(String nombre, String apellido, int telefono,
			boolean persistirCliente) {
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.telefono = telefono;
		if (persistirCliente) {
			DAC.persistirCliente(nombre, apellido, telefono);
		}
	}

	public static ArrayList<Cliente> obtenerClientes() {
		ArrayList<Cliente> arrayClientes = new ArrayList<Cliente>();
		try {
			ArrayList<String[]> array = DAC.obtenerClientes();

			for (int i = 0; i < array.size(); i++) {
				Cliente cliente = new Cliente(array.get(i)[1], array.get(i)[2],
						Integer.parseInt(array.get(i)[3]), false);
				arrayClientes.add(cliente);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return arrayClientes;
	}
	
	public static Cliente obtenerCliente(int IdCliente) {
		String[] datos = DAC.obtenerCliente(IdCliente);
		Cliente cliente = new Cliente(datos[1], datos[2],
				Integer.parseInt(datos[3]), false);
		return cliente;
	}


	@Override
	public String toString() {
		return "Cliente [nombre=" + getNombre() + ", apellido=" + getApellido()
				+ ", telefono=" + telefono + ", foto=" + foto + "]";
	}

	public String getNombre() {
		return nombre;
	}

	void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	void setApellido(String apellido) {
		this.apellido = apellido;
	}


}
