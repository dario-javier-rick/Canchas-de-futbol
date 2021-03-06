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
	private JTextField txtIdCancha;
	private JPanel panelCancha;
	private JPanel panelIdCliente;
	private JTextField txtIdCliente;
	private JPanel panelHoraReserva;
	private JTextField txtHoraReserva = new JTextField();
	private JPanel panelSe�a;
	private JTextField txtSe�a;
	private JPanel panelTiempoReserva;
	private JTextField txtTiempoReserva;
	private JButton btnCerrar;
	private JButton btnAceptar;
	private JPanel panelHorario;
	JComboBox<String> cboHoras = new JComboBox<String>();
	JComboBox<String> cboMinutos = new JComboBox<String>();

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

		panelCancha = new JPanel();
		panelCancha
				.setBorder(new TitledBorder(UIManager
						.getBorder("TitledBorder.border"), "Cancha",
						TitledBorder.CENTER, TitledBorder.TOP, null, new Color(
								0, 0, 0)));
		panelCancha.setBounds(16, 11, 192, 43);
		p.add(panelCancha);
		panelCancha.setLayout(null);

		txtIdCancha = new JTextField();
		txtIdCancha.setBounds(6, 16, 176, 20);
		panelCancha.add(txtIdCancha);
		txtIdCancha.setColumns(10);

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

		panelSe�a = new JPanel();
		panelSe�a.setLayout(null);
		panelSe�a
				.setBorder(new TitledBorder(UIManager
						.getBorder("TitledBorder.border"), "Se\u00F1a",
						TitledBorder.CENTER, TitledBorder.TOP, null, new Color(
								0, 0, 0)));
		panelSe�a.setBounds(16, 119, 192, 43);
		p.add(panelSe�a);

		txtSe�a = new JTextField();
		txtSe�a.setColumns(10);
		txtSe�a.setBounds(6, 16, 176, 20);
		panelSe�a.add(txtSe�a);

		panelTiempoReserva = new JPanel();
		panelTiempoReserva.setLayout(null);
		panelTiempoReserva
				.setBorder(new TitledBorder(UIManager
						.getBorder("TitledBorder.border"), "Tiempo de reserva (minutos)",
						TitledBorder.CENTER, TitledBorder.TOP, null, new Color(
								0, 0, 0)));
		panelTiempoReserva.setBounds(272, 193, 195, 43);
		p.add(panelTiempoReserva);

		txtTiempoReserva = new JTextField();
		txtTiempoReserva.setColumns(10);
		txtTiempoReserva.setBounds(6, 16, 169, 20);
		panelTiempoReserva.add(txtTiempoReserva);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.addMouseListener(new MouseAdapter() {
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
						+ String.valueOf(c.get(Calendar.MONTH) + 1) + "/"
						+ c.get(Calendar.YEAR) + " "
						+ cboHoras.getSelectedItem().toString() + ":"
						+ cboMinutos.getSelectedItem().toString() + " Hs.");
			}
		});

		cboMinutos.setBounds(100, 14, 50, 20);
		panelHorario.add(cboMinutos);
		cboMinutos.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				Calendar c = (Calendar) calendar.getCalendar();
				txtHoraReserva.setText(c.get(Calendar.DAY_OF_MONTH) + "/"
						+ String.valueOf(c.get(Calendar.MONTH) + 1) + "/"
						+ c.get(Calendar.YEAR) + " "
						+ cboHoras.getSelectedItem().toString() + ":"
						+ cboMinutos.getSelectedItem().toString() + " Hs.");
			}
		});

		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBackground(Color.WHITE);
		panel.setBounds(262, 17, 222, 158);
		p.add(panel);

		calendar = new JCalendar();
		panel.add(calendar);
		calendar.addPropertyChangeListener("calendar",
				new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent e) {
						Calendar c = (Calendar) calendar.getCalendar();
						txtHoraReserva.setText(c.get(Calendar.DAY_OF_MONTH)
								+ "/"
								+ String.valueOf(c.get(Calendar.MONTH) + 1)
								+ "/" + c.get(Calendar.YEAR) + " "
								+ cboHoras.getSelectedItem().toString() + ":"
								+ cboMinutos.getSelectedItem().toString()
								+ " Hs.");
					}
				});
		Calendar c = (Calendar) calendar.getCalendar();
		txtHoraReserva.setText(c.get(Calendar.DAY_OF_MONTH) + "/"
				+ String.valueOf(c.get(Calendar.MONTH)+1) + "/" + c.get(Calendar.YEAR)
				+ " " + cboHoras.getSelectedItem().toString() + ":"
				+ cboMinutos.getSelectedItem().toString() + " Hs.");

		JLabel lblHoras = new JLabel("Horas");
		lblHoras.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblHoras.setBounds(69, 17, 33, 14);
		panelHorario.add(lblHoras);

		JLabel lblMin = new JLabel("Min");
		lblMin.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMin.setBounds(160, 17, 22, 15);
		panelHorario.add(lblMin);
		btnCerrar.setBounds(379, 247, 89, 23);
		p.add(btnCerrar);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if (validarDatos()) {
					// Llamar a l�gica y persistir reserva
					try {

						Calendar c = (Calendar) calendar.getCalendar();
						Date d = new Date();

						d.setDate(c.get(Calendar.DAY_OF_MONTH));
						d.setMonth(c.get(Calendar.MONTH)); // Enero es 0
						d.setYear(c.get(Calendar.YEAR));
						d.setHours(Integer.parseInt((String) cboHoras
								.getSelectedItem()));
						d.setMinutes(Integer.parseInt((String) cboMinutos
								.getSelectedItem()));
						d.setSeconds(00);

						Reserva reserva = new Reserva(Reserva
								.getUltimoIdReserva() + 1, Cliente
								.obtenerCliente(Integer.parseInt(txtIdCliente
										.getText())), Cancha
								.obtenerCancha(Integer.parseInt(txtIdCancha
										.getText())), d, Integer
								.parseInt(txtTiempoReserva.getText()), Integer
								.parseInt(txtSe�a.getText()));

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
					if (!txtIdCancha.getText().equals(""))
						Integer.parseInt(txtIdCancha.getText());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,
							"El id de la cancha no tiene formato num�rico");
					return false;
				}
				if (!Cancha.verificarExistenciaCancha(Integer
						.parseInt(txtIdCancha.getText()))) {
					JOptionPane.showMessageDialog(null,
							"El id de la cancha ingresada no existe");
					return false;
				}
				// Validaciones de cliente
				try {
					if (!txtIdCliente.getText().equals(""))
						Integer.parseInt(txtIdCliente.getText());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,
							"El id del cliente no tiene formato num�rico");
					return false;
				}
				if (!Cliente.verificarExistenciaCliente(Integer
						.parseInt(txtIdCliente.getText()))) {
					JOptionPane.showMessageDialog(null,
							"El id del cliente ingresado no existe");
					return false;
				}

				// Validaciones de se�a
				if (txtSe�a.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							"La se�a se encuentra vac�a");
					return false;
				}
				try {
					Integer.parseInt(txtSe�a.getText());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,
							"La se�a no tiene formato num�rico");
					return false;
				}

				// Validaciones de tiempo de reserva

				if (txtTiempoReserva.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							"El tiempo de reserva se encuentra vac�o");
					return false;
				}
				try {
					Integer.parseInt(txtTiempoReserva.getText());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,
							"El tiempo de reserva no tiene formato num�rico");
					return false;
				}

				return true;
			}
		});
		// btnAceptar.addMouseListener(new MouseAdapter() {
		// @Override
		// public void mouseClicked(MouseEvent arg0) {
		// if (true) {
		// JOptionPane c = new JOptionPane();
		// JOptionPane.showMessageDialog(c,
		// "Se agrego exitosamente su reserva.");
		// dispose();
		// }
		// /*
		// * else { JOptionPane c = new JOptionPane();
		// * JOptionPane.showMessageDialog(c,
		// * "Hubo un fallo, verifique los datos. Gracias" ); }
		// */
		// }
		// });
		btnAceptar.setBounds(280, 248, 89, 23);
		p.add(btnAceptar);

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
