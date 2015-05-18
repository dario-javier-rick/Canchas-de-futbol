package Interfaz;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
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

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class AgregarCancha extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4219519238158446784L;
	private JTextField nombre;
	private JTextField maxJugadores;
	private JTextField precioPorHora;
	private JTextField tipo_cancha;
	JLabel lblMensaje1 = new JLabel("");
	JLabel lblMensaje2 = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarCancha frame = new AgregarCancha();
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
	public AgregarCancha() {
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
		
		JLabel labelMensaje1 = new JLabel("");
		labelMensaje1.setHorizontalAlignment(SwingConstants.CENTER);
		labelMensaje1.setForeground(Color.WHITE);
		labelMensaje1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		labelMensaje1.setBounds(4, 189, 300, 14);
		p.add(labelMensaje1);
		
		JLabel labelMensaje2 = new JLabel("");
		labelMensaje2.setHorizontalAlignment(SwingConstants.CENTER);
		labelMensaje2.setForeground(Color.BLACK);
		labelMensaje2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		labelMensaje2.setBounds(14, 189, 300, 14);
		p.add(labelMensaje2);

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

		tipo_cancha = new JTextField();
		tipo_cancha.setEnabled(false);
		tipo_cancha.setBounds(6, 16, 225, 20);
		panel_3.add(tipo_cancha);
		tipo_cancha.setText("Sintetico");
		tipo_cancha.setColumns(10);

		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (nombre.getText().equals("") || maxJugadores.getText().equals("")
						|| precioPorHora.getText().equals("")
						|| tipo_cancha.getText().equals("")) {
					lblMensaje1.setText("Algunos campos estan vac�os!");
					lblMensaje2.setText("Algunos campos estan vac�os!");
				} else {
					// tener en cuenta el idCancha
					Cancha cancha = new Cancha(Cancha.getUltimoIdCancha()+1, nombre.getText(), tipo_cancha
							.getText(), Integer.parseInt(precioPorHora
							.getText()), Integer.parseInt(maxJugadores
							.getText()));
					cancha.persistirCancha();
				}
			}
		});
		btnAgregar.setBounds(284, 50, 89, 23);
		p.add(btnAgregar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false); 
				dispose();
			}
		});
		btnCancelar.setBounds(284, 92, 89, 23);
		p.add(btnCancelar);


	}
}
