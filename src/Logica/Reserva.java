package Logica;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import Persistencia.ReservaDAC;

public class Reserva {

	private int idReserva;
	private Cliente cliente;
	private Cancha cancha;
	private Date horario;
	private int tiempo;
	private int seña;
	Boolean realizada;

	private static ReservaDAC DAC = new ReservaDAC();

	public Reserva(int idReserva, Cliente cliente, Cancha cancha, Date horario,
			int tiempo, int seña) {
		realizada = false;
		this.setIdReserva(idReserva);
		this.setCliente(cliente);
		this.setCancha(cancha);
		this.setHorario(horario);
		this.setTiempo(tiempo);
		this.setSeña(seña);

	}

	public void concretar() {
		this.realizada = true;
	}

	public static void concretar(int idReserva) {
		DAC.concretar(idReserva);
	}

	public static ArrayList<Reserva> obtenerReservas() {
		ArrayList<Reserva> arrayReservas = new ArrayList<Reserva>();
		try {
			ArrayList<String[]> array = DAC.obtenerReservas();
			for (int i = 0; i < array.size(); i++) {
				DateFormat formatter = new SimpleDateFormat(
						"dd-MM-yyyy HH:mm:ss");
				Reserva reserva = new Reserva(
						Integer.parseInt(array.get(i)[0]),
						Cliente.obtenerCliente(Integer.parseInt(array.get(i)[1])),
						Cancha.obtenerCancha(Integer.parseInt(array.get(i)[2])),
						formatter.parse(array.get(i)[3]), Integer
								.parseInt(array.get(i)[4]), Integer
								.parseInt(array.get(i)[5]));
				if (Boolean.parseBoolean(array.get(i)[6]))
					reserva.concretar();
				arrayReservas.add(reserva);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return arrayReservas;
	}

	public static ArrayList<Reserva> obtenerReservas(Calendar calendar) {
		ArrayList<Reserva> arrayReservas = new ArrayList<Reserva>();
		try {
			ArrayList<String[]> array = DAC.obtenerReservas(
					calendar.get(Calendar.DAY_OF_MONTH),
					calendar.get(Calendar.MONTH) + 1,
					calendar.get(Calendar.YEAR));
			for (int i = 0; i < array.size(); i++) {
				DateFormat formatter = new SimpleDateFormat(
						"dd-MM-yyyy HH:mm:ss");
				Reserva reserva = new Reserva(
						Integer.parseInt(array.get(i)[0]),
						Cliente.obtenerCliente(Integer.parseInt(array.get(i)[1])),
						Cancha.obtenerCancha(Integer.parseInt(array.get(i)[2])),
						formatter.parse(array.get(i)[3]), Integer
								.parseInt(array.get(i)[4]), Integer
								.parseInt(array.get(i)[5]));
				if (Boolean.parseBoolean(array.get(i)[6]))
					reserva.concretar();
				arrayReservas.add(reserva);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return arrayReservas;
	}

	public void persistirReserva() {
		try {
			// Formato: '31-05-2015 10:00:00'
			@SuppressWarnings("deprecation")
			String horario = String.format("%02d", this.getHorario().getDate())
					+ "-" + String.format("%02d", this.getHorario().getMonth()+1) // Enero = 0
					+ "-" + String.format("%04d", this.getHorario().getYear())
					+ " " + String.format("%02d", this.getHorario().getHours())
					+ ":"
					+ String.format("%02d", this.getHorario().getMinutes())
					+ ":"
					+ String.format("%02d", this.getHorario().getSeconds());
			DAC.persistirReserva(this.idReserva, this.cliente.getIdCliente(),
					this.cancha.getIdCancha(), horario, this.getTiempo(),
					this.getSeña(), this.realizada);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	public static int getUltimoIdReserva() {
		return DAC.getUltimoIdReserva();
	}

	public static void eliminarReservasPorCancha(Cancha cancha) {
		DAC.eliminarReservaPorCancha(cancha.getIdCancha());
	}

	public static void eliminarReservasPorCliente(Cliente cliente) {
		DAC.eliminarReservaPorCliente(cliente.getIdCliente());
	}

	public static void eliminarReserva(Reserva reserva) {
		DAC.eliminarReserva(reserva.getIdReserva());

	}

	@Override
	public String toString() {
		return "Reserva " + this.idReserva + " Cliente: " + getCliente()
				+ ", Cancha:" + getCancha() + ", Horario:" + getHorario()
				+ ", Realizada: " + realizada + "]";
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

	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public String getRealizada() {
		boolean realizada = DAC.chequearEstado(this.idReserva);
		if (realizada)
			return "Si";
		else
			return "No";
	}

	private void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}

	public int getTiempo() {
		return tiempo;
	}

	public int getSeña() {
		return seña;
	}

	private void setSeña(int seña) {
		this.seña = seña;
	}

}
