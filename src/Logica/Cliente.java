package Logica;

import java.awt.Image;
import java.util.ArrayList;

import Persistencia.ClienteDAC;

public class Cliente {

	private int idCliente;
	private String nombre;
	private String apellido;
	int telefono;
	Image foto;
	private static ClienteDAC DAC = new ClienteDAC();

	public Cliente() {

	}

	public Cliente(int idCliente, String nombre, String apellido, int telefono) {
		this.setIdCliente(idCliente);
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.telefono = telefono;
	}
	

	public static ArrayList<Cliente> obtenerClientes() {
		ArrayList<Cliente> arrayClientes = new ArrayList<Cliente>();
		try {
			ArrayList<String[]> array = DAC.obtenerClientes();

			for (int i = 0; i < array.size(); i++) {
				Cliente cliente = new Cliente(
						Integer.parseInt(array.get(i)[0]), array.get(i)[1],
						array.get(i)[2], Integer.parseInt(array.get(i)[3]));
				arrayClientes.add(cliente);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return arrayClientes;
	}

	public static Cliente obtenerCliente(int IdCliente) {
		String[] datos = DAC.obtenerCliente(IdCliente);
		Cliente cliente = new Cliente(Integer.parseInt(datos[0]), datos[1],
				datos[2], Integer.parseInt(datos[3]));
		return cliente;
	}

	public static void eliminarCliente(Cliente cliente) {
		DAC.eliminarCliente(cliente.getIdCliente());
	}

	public void persistirCliente() {
		try {
			DAC.persistirCliente(this.idCliente, this.nombre, this.apellido, this.telefono);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		

	}


	@Override
	public String toString() {
		return "Id: " + getIdCliente() + " , " + getApellido() + ", " + getNombre() ;
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

	public int getIdCliente() {
		return idCliente;
	}

	private void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public static int getUltimoIdCliente() {
		return DAC.getUltimoIdCliente();
	}

	public static boolean verificarExistenciaCliente(int idCliente) {
		// TODO Auto-generated method stub
		return false;
	}

}
