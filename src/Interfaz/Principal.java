package Interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import Persistencia.ClienteDAC;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnReservas = new JButton("Reservas");
		btnReservas.setBounds(241, 175, 89, 23);
		frame.getContentPane().add(btnReservas);
		
		JButton btnClientes = new JButton("Clientes");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cliente.main(null);
			}
		});
		btnClientes.setBounds(241, 114, 89, 23);
		frame.getContentPane().add(btnClientes);
		
		JButton btnCanchas = new JButton("Canchas");
		btnCanchas.setBounds(54, 114, 129, 23);
		frame.getContentPane().add(btnCanchas);
		
		JButton btnCanchasDisponibles = new JButton("Canchas disponibles");
		btnCanchasDisponibles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ClienteDAC.crearClientesDePrueba();
					Logica.Cliente.getClientes();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnCanchasDisponibles.setBounds(54, 175, 129, 23);
		frame.getContentPane().add(btnCanchasDisponibles);
	}
}
