package Logica;

import Persistencia.CanchaDAC;

public class Cancha {
	
	String nombre;
	String tipo_cancha;
	int precioPorHora;
	int maxJugadores;
	private static CanchaDAC DAC = new CanchaDAC();
	
	public Cancha(String nombre, String tipo_cancha, int precioPorHora, int maxJugadores){
		this.nombre = nombre;
		this.tipo_cancha = tipo_cancha;
		this.precioPorHora = precioPorHora;
		this.maxJugadores = maxJugadores;
	}

	
	@Override
	public String toString() {
		return "Cancha [nombre=" + nombre + ", tipo_cancha=" + tipo_cancha
				+ ", precioPorHora=" + precioPorHora + ", maxJugadores="
				+ maxJugadores + "]";
	}

}
