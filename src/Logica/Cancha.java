package Logica;

import java.util.ArrayList;

import Persistencia.CanchaDAC;

public class Cancha {

	private String nombre;
	private String tipo_cancha;
	int precioPorHora;
	int maxJugadores;
	private static CanchaDAC DAC = new CanchaDAC();

	public Cancha(String nombre, String tipo_cancha, int precioPorHora,
			int maxJugadores) {
		this.setNombre(nombre);
		this.setTipo_cancha(tipo_cancha);
		this.precioPorHora = precioPorHora;
		this.maxJugadores = maxJugadores;
	}

	public static ArrayList<Cancha> obtenerCanchas() {
		ArrayList<Cancha> arrayCanchas = new ArrayList<Cancha>();
		try {
			ArrayList<String[]> array = DAC.obtenerCanchas();
			for (int i = 0; i < array.size(); i++) {
				Cancha cancha = new Cancha(array.get(i)[1], array.get(i)[2],
						Integer.parseInt(array.get(i)[3]),
						Integer.parseInt(array.get(i)[4]));
				arrayCanchas.add(cancha);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return arrayCanchas;
	}

	public static Cancha obtenerCancha(int IdCancha) {
		// TODO Auto-generated method stub
		return null;
	}

	public void persistirCancha() {
		try {
			DAC.persitirCancha(this.nombre, this.tipo_cancha,
					this.precioPorHora, this.maxJugadores);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	@Override
	public String toString() {
		return "Cancha [nombre=" + getNombre() + ", tipo_cancha="
				+ getTipo_cancha() + ", precioPorHora=" + precioPorHora
				+ ", maxJugadores=" + maxJugadores + "]";
	}

	public String getNombre() {
		return nombre;
	}

	void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo_cancha() {
		return tipo_cancha;
	}

	void setTipo_cancha(String tipo_cancha) {
		this.tipo_cancha = tipo_cancha;
	}

}
