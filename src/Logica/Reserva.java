package Logica;

import java.util.Date;

import Persistencia.ReservaDAC;

public class Reserva {

	Cliente cliente;
	Cancha cancha;
	Date horario;
	Boolean realizada;
	private static ReservaDAC DAC = new ReservaDAC();

	public Reserva(Cliente cliente, Cancha cancha, Date horario){
		realizada = false;
		this.cliente = cliente;
		this.cancha = cancha;
		this.horario = horario;
	}
	
	public void concretar()
	{
		this.realizada = true;
	}
	
	
	@Override
	public String toString() {
		return "Reserva [cliente=" + cliente + ", cancha=" + cancha
				+ ", horario=" + horario + ", realizada=" + realizada + "]";
	}

}
