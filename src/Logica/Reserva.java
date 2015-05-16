package Logica;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Persistencia.ReservaDAC;

public class Reserva {

	private Cliente cliente;
	private Cancha cancha;
	private Date horario;
	Boolean realizada;
	int seña;
	private static ReservaDAC DAC = new ReservaDAC();

	public Reserva(Cliente cliente, Cancha cancha, Date horario) {
		realizada = false;
		this.setCliente(cliente);
		this.setCancha(cancha);
		this.setHorario(horario);
	}

	public void concretar() {
		this.realizada = true;
	}

	public static ArrayList<Reserva> obtenerReservas() {
		ArrayList<Reserva> arrayReservas = new ArrayList<Reserva>();
		try {
			ArrayList<String[]> array = DAC.obtenerReservas();
			for (int i = 0; i < array.size(); i++) {
				DateFormat formatter = new SimpleDateFormat(
						"dd-MM-yyyy HH:mm:ss");
				Reserva reserva = new Reserva(
						Cliente.obtenerCliente(Integer.parseInt(array.get(i)[1])),
						Cancha.obtenerCancha(Integer.parseInt(array.get(i)[2])),
						formatter.parse(array.get(i)[3]));
				if (Boolean.parseBoolean(array.get(i)[4]))
					reserva.concretar();
				arrayReservas.add(reserva);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return arrayReservas;
	}

	@Override
	public String toString() {
		return "Reserva [cliente=" + getCliente() + ", cancha=" + getCancha()
				+ ", horario=" + getHorario() + ", realizada=" + realizada
				+ "]";
	}

	public Cliente getCliente() {
		return cliente;
	}

	void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getHorario() {
		return horario;
	}

	void setHorario(Date horario) {
		this.horario = horario;
	}

	public Cancha getCancha() {
		return cancha;
	}

	void setCancha(Cancha cancha) {
		this.cancha = cancha;
	}

}
