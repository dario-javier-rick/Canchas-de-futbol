package Interfaz;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.Cancha;
import Recursos.Fondo;

import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComboBox;

public class AgregarCancha extends JFrame {

	private static final long serialVersionUID = 4219519238158446784L;
	private JTextField nombre;
	private JTextField maxJugadores;
	private JTextField precioPorHora;
	JComboBox tipo_cancha = new JComboBox();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarCancha frame = new AgregarCancha(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Create the frame.
	 * 
	 * @param frame
	 * @param frame
	 */
	public AgregarCancha(final ControlCentral instancia) {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
			}
		});

		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 400, 250);

		Fondo p = new Fondo();
		p.setBackground(Color.BLACK);
		p.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(p);
		p.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Nombre de la cancha",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel.setBounds(4, 11, 237, 43);
		p.add(panel);
		panel.setLayout(null);

		nombre = new JTextField();
		nombre.setBounds(6, 16, 225, 20);
		panel.add(nombre);
		nombre.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Cantidad de jugadores",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_1.setBounds(4, 54, 237, 43);
		p.add(panel_1);
		panel_1.setLayout(null);

		maxJugadores = new JTextField();
		maxJugadores.setBounds(6, 16, 225, 20);
		panel_1.add(maxJugadores);
		maxJugadores.setColumns(10);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Precio por hora",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_2.setBounds(4, 96, 237, 43);
		p.add(panel_2);
		panel_2.setLayout(null);

		precioPorHora = new JTextField();
		precioPorHora.setBounds(6, 16, 225, 20);
		panel_2.add(precioPorHora);
		precioPorHora.setColumns(10);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Piso",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_3.setBounds(4, 135, 237, 43);
		p.add(panel_3);
		panel_3.setLayout(null);

		tipo_cancha.setBounds(6, 16, 225, 20);
		panel_3.add(tipo_cancha);

		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (validarDatos()) {
					// Llamar a lógica y persistir cancha
					Cancha cancha = new Cancha(Cancha.getUltimoIdCancha() + 1,
							nombre.getText(), tipo_cancha.getSelectedItem()
									.toString(), Integer.parseInt(precioPorHora
									.getText()), Integer.parseInt(maxJugadores
									.getText()));
					cancha.persistirCancha();
					JOptionPane.showMessageDialog(null, "Cancha cargada!");
					instancia.actualizarCombos();
					dispose();
				}

			}

			private boolean validarDatos() {
				if (nombre.getText().equals("")
						|| maxJugadores.getText().equals("")
						|| precioPorHora.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							"Algunos campos estan vacíos");
					return false;
				}
				return true;
			}
		});
		btnAgregar.setBounds(284, 50, 89, 23);
		p.add(btnAgregar);

		JButton btnCancelar = new JButton("Cerrar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		btnCancelar.setBounds(284, 92, 89, 23);
		p.add(btnCancelar);

		bindPiso();
	}

	private void bindPiso() {
		tipo_cancha.addItem("Sintético");
		tipo_cancha.addItem("Parquet");
	}
}
