package Logica;

import java.util.ArrayList;

import Persistencia.CanchaDAC;

public class Cancha {

	private int idCancha;
	private String nombre;
	private String tipo_cancha;
	private int precioPorHora;
	int maxJugadores;
	private static CanchaDAC DAC = new CanchaDAC();

	public Cancha(int idCancha, String nombre, String tipo_cancha, int precioPorHora,
			int maxJugadores) {
		this.setIdCancha(idCancha);
		this.setNombre(nombre);
		this.setTipo_cancha(tipo_cancha);
		this.setPrecioPorHora(precioPorHora);
		this.maxJugadores = maxJugadores;
	}

	public static ArrayList<Cancha> obtenerCanchas() {
		ArrayList<Cancha> arrayCanchas = new ArrayList<Cancha>();
		try {
			ArrayList<String[]> array = DAC.obtenerCanchas();
			for (int i = 0; i < array.size(); i++) {
				Cancha cancha = new Cancha(Integer.parseInt(array.get(i)[0]), array.get(i)[1], array.get(i)[2],
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
		String[] datos = DAC.obtenerCancha(IdCancha);
		Cancha cancha = new Cancha(Integer.parseInt(datos[0]), datos[1], datos[2],
				Integer.parseInt(datos[3]), Integer.parseInt(datos[4]));
		return cancha;
	}
	
	public static void eliminarCancha(Cancha cancha) {
		DAC.eliminarCancha(cancha.getIdCancha());
	}

	public void persistirCancha() {
		try {
			DAC.persistirCancha(this.idCancha, this.nombre, this.tipo_cancha,
					this.getPrecioPorHora(), this.maxJugadores);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}
	
	public static int getUltimoIdCancha() {
		return DAC.getUltimoIdCancha();
	}

	public static boolean verificarExistenciaCancha(int idCancha) {
		return DAC.verificarExistenciaCancha(idCancha);
	}


	@Override
	public String toString() {
		return ("Id: " + getIdCancha() +" Cancha: " +getNombre() + ", Tipo: " + getTipo_cancha());
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

	public int getPrecioPorHora() {
		return precioPorHora;
	}

	void setPrecioPorHora(int precioPorHora) {
		this.precioPorHora = precioPorHora;
	}

	public int getIdCancha() {
		return idCancha;
	}

	private void setIdCancha(int idCancha) {
		this.idCancha = idCancha;
	}






}
