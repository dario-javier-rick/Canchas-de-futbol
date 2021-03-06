package Interfaz;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;

import Logica.Cancha;
import Logica.Reserva;
import Recursos.Fondo;

public class EliminarCancha extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -222451083314467403L;
	JComboBox<Cancha> cboCanchas = new JComboBox<Cancha>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, final ControlCentral instancia) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EliminarCancha frame = new EliminarCancha(instancia);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EliminarCancha(final ControlCentral instancia) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 404, 150);

		Fondo p = new Fondo();
		p.setBackground(Color.BLACK);
		p.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(p);
		p.setLayout(null);

		JButton btnNewButton_1 = new JButton("Eliminar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cboCanchas.getSelectedIndex() != -1) {
					// Elimino reservas asociadas a la cancha.
					Reserva.eliminarReservasPorCancha((Cancha) cboCanchas
							.getSelectedItem());
					Cancha.eliminarCancha((Cancha) cboCanchas.getSelectedItem());
					JOptionPane.showMessageDialog(null, "Cancha eliminada!");
					cboCanchas.removeAllItems();
//					cboCanchas.addItem("Seleccione una cancha. . . . ");
					bindCanchas();
				}
				instancia.actualizarCombos();
			}
		});
		btnNewButton_1.setBounds(196, 86, 89, 23);
		p.add(btnNewButton_1);

		JButton btnNewButton = new JButton("Cerrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				dispose();
			}
		});
		btnNewButton.setBounds(299, 86, 89, 23);
		p.add(btnNewButton);

		cboCanchas.setBounds(10, 11, 275, 20);
		p.add(cboCanchas);

		bindCanchas();
	}

	private void bindCanchas() {
		ArrayList<Cancha> canchas = Cancha.obtenerCanchas();
		for (Cancha cancha : canchas) {
			cboCanchas.addItem(cancha);
		}
	}
}
