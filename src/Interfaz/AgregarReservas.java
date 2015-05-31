package Interfaz;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.Cancha;
import Logica.Cliente;
import Logica.Reserva;
import Recursos.Fondo;

import com.toedter.calendar.JCalendar;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JButton;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComboBox;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Calendar;
import java.util.Date;

public class AgregarReservas extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JCalendar calendar;
	private JTextField txtCancha;
	private JPanel panelCancha;
	private JPanel panelIdCliente;
	private JTextField txtIdCliente;
	private JPanel panelHoraReserva;
	private JTextField txtHoraReserva = new JTextField();
	private JPanel panelSeña;
	private JTextField txtSeña;
	private JPanel panelTiempoReserva;
	private JTextField txtTiempoReserva;
	private JButton btnAceptar;
	private JButton button;
	private JPanel panelHorario;
	JComboBox cboHoras = new JComboBox();
	JComboBox cboMinutos = new JComboBox();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarReservas frame = new AgregarReservas(null);
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
	public AgregarReservas(final ControlCentral instancia) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 320);

		Fondo p = new Fondo();
		p.setBackground(Color.BLACK);
		p.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(p);
		p.setLayout(null);

		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBackground(Color.WHITE);
		panel.setBounds(262, 17, 222, 158);
		p.add(panel);

		panelCancha = new JPanel();
		panelCancha
				.setBorder(new TitledBorder(UIManager
						.getBorder("TitledBorder.border"), "Cancha",
						TitledBorder.CENTER, TitledBorder.TOP, null, new Color(
								0, 0, 0)));
		panelCancha.setBounds(16, 11, 192, 43);
		p.add(panelCancha);
		panelCancha.setLayout(null);

		txtCancha = new JTextField();
		txtCancha.setBounds(6, 16, 176, 20);
		panelCancha.add(txtCancha);
		txtCancha.setColumns(10);

		panelIdCliente = new JPanel();
		panelIdCliente.setLayout(null);
		panelIdCliente
				.setBorder(new TitledBorder(UIManager
						.getBorder("TitledBorder.border"), "Id del cliente",
						TitledBorder.CENTER, TitledBorder.TOP, null, new Color(
								0, 0, 0)));
		panelIdCliente.setBounds(16, 65, 192, 43);
		p.add(panelIdCliente);

		txtIdCliente = new JTextField();
		txtIdCliente.setColumns(10);
		txtIdCliente.setBounds(6, 16, 176, 20);
		panelIdCliente.add(txtIdCliente);

		panelHoraReserva = new JPanel();
		panelHoraReserva.setLayout(null);
		panelHoraReserva
				.setBorder(new TitledBorder(UIManager
						.getBorder("TitledBorder.border"),
						"Fecha & Hora de reserva", TitledBorder.CENTER,
						TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelHoraReserva.setBounds(16, 227, 192, 43);
		p.add(panelHoraReserva);

		txtHoraReserva.setEditable(false);
		txtHoraReserva.setColumns(10);
		txtHoraReserva.setBounds(6, 16, 176, 20);
		panelHoraReserva.add(txtHoraReserva);

		panelSeña = new JPanel();
		panelSeña.setLayout(null);
		panelSeña
				.setBorder(new TitledBorder(UIManager
						.getBorder("TitledBorder.border"), "Se\u00F1a",
						TitledBorder.CENTER, TitledBorder.TOP, null, new Color(
								0, 0, 0)));
		panelSeña.setBounds(16, 119, 192, 43);
		p.add(panelSeña);

		txtSeña = new JTextField();
		txtSeña.setColumns(10);
		txtSeña.setBounds(6, 16, 176, 20);
		panelSeña.add(txtSeña);

		panelTiempoReserva = new JPanel();
		panelTiempoReserva.setLayout(null);
		panelTiempoReserva
				.setBorder(new TitledBorder(UIManager
						.getBorder("TitledBorder.border"), "Tiempo de reserva",
						TitledBorder.CENTER, TitledBorder.TOP, null, new Color(
								0, 0, 0)));
		panelTiempoReserva.setBounds(272, 193, 195, 43);
		p.add(panelTiempoReserva);

		txtTiempoReserva = new JTextField();
		txtTiempoReserva.setColumns(10);
		txtTiempoReserva.setBounds(6, 16, 169, 20);
		panelTiempoReserva.add(txtTiempoReserva);

		btnAceptar = new JButton("Cerrar");
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});

		bindHoras();
		bindMinutos();

		panelHorario = new JPanel();
		panelHorario.setLayout(null);
		panelHorario
				.setBorder(new TitledBorder(UIManager
						.getBorder("TitledBorder.border"), "Horario",
						TitledBorder.CENTER, TitledBorder.TOP, null, new Color(
								0, 0, 0)));
		panelHorario.setBounds(16, 173, 192, 43);
		p.add(panelHorario);

		cboHoras.setBounds(11, 14, 50, 20);
		panelHorario.add(cboHoras);
		cboHoras.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				Calendar c = (Calendar) calendar.getCalendar();
				txtHoraReserva.setText(c.get(Calendar.DAY_OF_MONTH) + "/"
						+ c.get(Calendar.MONTH) + "/" + c.get(Calendar.YEAR)
						+ " " + cboHoras.getSelectedItem().toString() + ":"
						+ cboMinutos.getSelectedItem().toString() + " Hs.");
			}
		});

		cboMinutos.setBounds(100, 14, 50, 20);
		panelHorario.add(cboMinutos);
		cboMinutos.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				Calendar c = (Calendar) calendar.getCalendar();
				txtHoraReserva.setText(c.get(Calendar.DAY_OF_MONTH) + "/"
						+ c.get(Calendar.MONTH) + "/" + c.get(Calendar.YEAR)
						+ " " + cboHoras.getSelectedItem().toString() + ":"
						+ cboMinutos.getSelectedItem().toString() + " Hs.");
			}
		});

		calendar = new JCalendar();
		panel.add(calendar);
		calendar.addPropertyChangeListener("calendar",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent e) {
						Calendar c = (Calendar) e.getNewValue();
						txtHoraReserva.setText(c.get(Calendar.DAY_OF_MONTH)
								+ "/" + c.get(Calendar.MONTH) + "/"
								+ c.get(Calendar.YEAR) + " "
								+ cboHoras.getSelectedItem().toString() + ":"
								+ cboMinutos.getSelectedItem().toString()
								+ " Hs.");
					}
				});

		JLabel lblHoras = new JLabel("Horas");
		lblHoras.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblHoras.setBounds(69, 17, 33, 14);
		panelHorario.add(lblHoras);

		JLabel lblMin = new JLabel("Min");
		lblMin.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMin.setBounds(160, 17, 22, 15);
		panelHorario.add(lblMin);
		btnAceptar.setBounds(379, 247, 89, 23);
		p.add(btnAceptar);

		button = new JButton("Aceptar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (validarDatos()) {
					// Llamar a lógica y persistir reserva
					try {
						Date d = new Date();
						Reserva reserva = new Reserva(Reserva
								.getUltimoIdReserva() + 1, Cliente
								.obtenerCliente(1), Cancha.obtenerCancha(1), d,
								Integer.parseInt(txtTiempoReserva.getText()),
								Integer.parseInt(txtSeña.getText()));

						// idReserva INTEGER PRIMARY KEY AUTOINCREMENT,
						// idCliente INTEGER,
						// idCancha INTEGER,
						// horario STRING,
						// realizada BOOLEAN,
						// FOREIGN KEY(idCliente) REFERENCES
						// CLIENTES(idCliente),
						// FOREIGN KEY(idCancha) REFERENCES CANCHAS(idCancha)

						reserva.persistirReserva();
						JOptionPane
								.showMessageDialog(null, "Reserva agregada!");
						instancia.actualizarCombos();
						dispose();
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null,
								"Ocurrio un problema al agregar la reserva. Codigo de error: "
										+ ex.getMessage());
					}
				}

			}

			private boolean validarDatos() {
				// Validaciones de cancha
				try {
					if (!txtCancha.getText().equals(""))
						Integer.parseInt(txtCancha.getText());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,
							"El id de la cancha no tiene formato numérico");
					return false;
				}
				if (!Cancha.verificarExistenciaCancha(Integer
						.parseInt(txtCancha.getText())))
					JOptionPane.showMessageDialog(null,
							"El id de la cancha ingresada no existe");

				// Validaciones de cliente
				try {
					if (!txtIdCliente.getText().equals(""))
						Integer.parseInt(txtIdCliente.getText());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,
							"El id del cliente no tiene formato numérico");
					return false;
				}
				if (!Cliente.verificarExistenciaCliente(Integer
						.parseInt(txtIdCliente.getText())))
					JOptionPane.showMessageDialog(null,
							"El id del cliente ingresado no existe");

				// Validaciones de seña
				if (txtSeña.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							"La seña se encuentra vacía");
					return false;
				}
				try {
					Integer.parseInt(txtSeña.getText());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,
							"La seña no tiene formato numérico");
					return false;
				}

				// Validaciones de tiempo de reserva

				if (txtTiempoReserva.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							"El tiempo de reserva se encuentra vacío");
					return false;
				}
				try {
					Integer.parseInt(txtTiempoReserva.getText());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,
							"El tiempo de reserva no tiene formato numérico");
					return false;
				}

				return true;
			}
		});
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (true) {
					JOptionPane c = new JOptionPane();
					JOptionPane.showMessageDialog(c,
							"Se agrego exitosamente su reserva.");
					dispose();
				}
				/*
				 * else { JOptionPane c = new JOptionPane();
				 * JOptionPane.showMessageDialog(c,
				 * "Hubo un fallo, verifique los datos. Gracias" ); }
				 */
			}
		});
		button.setBounds(280, 248, 89, 23);
		p.add(button);

	}

	private void bindMinutos() {
		for (int i = 0; i < 60; i++) {
			cboMinutos.addItem(String.format("%02d", i));
		}
	}

	private void bindHoras() {
		for (int i = 0; i < 24; i++) {
			cboHoras.addItem(String.format("%02d", i));
		}
	}
}
