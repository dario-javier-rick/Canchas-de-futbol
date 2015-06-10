package Interfaz;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.Cancha;
import Logica.Cliente;
import Logica.Reserva;
import Recursos.Fondo;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.Font;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import com.toedter.calendar.JCalendar;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.border.LineBorder;

import java.awt.SystemColor;

import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionEvent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ControlCentral extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static ControlCentral frame = new ControlCentral();
	JCalendar calendario = new JCalendar();
	JComboBox cboClientes = new JComboBox();
	JComboBox cboCanchas = new JComboBox();
	JComboBox cboReservas = new JComboBox();
	private JTable tblMañana;
	private JTable tblTarde;
	DefaultTableModel mdlMañana = new DefaultTableModel(new Object[] {
			"Cancha", "Id Cliente", "Horario", "Se\u00F1a",
			"Tiempo de Reserva", "Resto a pagar", "Realizada" }, 0);
	DefaultTableModel mdlTarde = new DefaultTableModel(new Object[] { "Cancha",
			"Id Cliente", "Horario", "Se\u00F1a", "Tiempo de Reserva",
			"Resto a pagar", "Realizada" }, 0);
	
	//El ArrayList se declara como variable global, para poder trabajarlo mejor.
	ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	
	private ControlCentral ControlCentral = this;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void actualizarCombos() {
		cboClientes.removeAllItems();
		cboCanchas.removeAllItems();
		cboReservas.removeAllItems();
		bindClientes();
		bindCanchas();
		bindReservas();
	}

	/**
	 * Create the frame.
	 */
	public ControlCentral() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 506);

		Fondo p = new Fondo();
		p.setBackground(Color.BLACK);
		p.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(p);
		p.setLayout(null);

		JPanel panelCanchas = new JPanel();
		panelCanchas.setBounds(10, 11, 257, 77);
		panelCanchas.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelCanchas.setBackground(Color.BLACK);
		panelCanchas.setOpaque(false);
		panelCanchas.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Canchas",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		p.add(panelCanchas);
		panelCanchas.setLayout(null);
		cboCanchas.setFont(new Font("Tahoma", Font.PLAIN, 11));

		cboCanchas.setBounds(6, 16, 241, 20);
		panelCanchas.add(cboCanchas);

		JButton btnAgregarCanchas = new JButton("Agregar");
		btnAgregarCanchas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AgregarCancha Canchas = new AgregarCancha(frame);
				Canchas.setVisible(true);
			}
		});

		btnAgregarCanchas.setBounds(6, 47, 89, 23);
		panelCanchas.add(btnAgregarCanchas);

		JButton btnEliminarCanchas = new JButton("Eliminar");
		btnEliminarCanchas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				EliminarCancha Canchas = new EliminarCancha(ControlCentral);
				Canchas.setVisible(true);
			}
		});
		btnEliminarCanchas.setBounds(158, 47, 89, 23);
		panelCanchas.add(btnEliminarCanchas);

		JPanel panelSocios = new JPanel();
		panelSocios.setBounds(10, 187, 257, 77);
		panelSocios.setLayout(null);
		panelSocios.setOpaque(false);
		panelSocios.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelSocios.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Socios",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		panelSocios.setBackground(Color.BLACK);
		p.add(panelSocios);
		cboClientes.setFont(new Font("Tahoma", Font.PLAIN, 11));

		cboClientes.setBounds(6, 16, 241, 20);
		panelSocios.add(cboClientes);

		JButton btnAgregarClientes = new JButton("Agregar");
		btnAgregarClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AgregarClientes Canchas = new AgregarClientes(frame);
				Canchas.setVisible(true);
			}
		});
		btnAgregarClientes.setBounds(6, 47, 89, 23);
		panelSocios.add(btnAgregarClientes);

		JButton btnEliminarClientes = new JButton("Eliminar");
		btnEliminarClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				EliminarClientes Clientes = new EliminarClientes(ControlCentral);
				Clientes.setVisible(true);
			}
		});
		btnEliminarClientes.setBounds(158, 47, 89, 23);
		panelSocios.add(btnEliminarClientes);

		JPanel panelReservas = new JPanel();
		panelReservas.setBounds(10, 99, 257, 77);
		panelReservas.setLayout(null);
		panelReservas.setOpaque(false);
		panelReservas.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelReservas.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Reservas",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panelReservas.setBackground(Color.BLACK);
		p.add(panelReservas);
		cboReservas.setFont(new Font("Tahoma", Font.PLAIN, 11));

		cboReservas.setBounds(6, 16, 241, 20);
		panelReservas.add(cboReservas);

		JButton btnAgregarReservas = new JButton("Agregar");
		btnAgregarReservas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AgregarReservas reservas = new AgregarReservas(frame);
				reservas.setVisible(true);
			}
		});
		btnAgregarReservas.setBounds(6, 47, 89, 23);
		panelReservas.add(btnAgregarReservas);

		JButton btnEliminarReservas = new JButton("Eliminar");
		btnEliminarReservas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				EliminarReservas reservas = new EliminarReservas(ControlCentral);
				reservas.setVisible(true);
			}
		});
		btnEliminarReservas.setBounds(158, 47, 89, 23);
		panelReservas.add(btnEliminarReservas);

		JPanel panelGeneral = new JPanel();
		panelGeneral.setBounds(277, 11, 407, 410);
		panelGeneral.setOpaque(false);
		p.add(panelGeneral);
		panelGeneral.setLayout(null);

		final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setBorder(new TitledBorder(null, "Reservas hechas",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tabbedPane.setBounds(10, 0, 399, 399);
		panelGeneral.add(tabbedPane);

		JScrollPane scrollPane = new JScrollPane();
		JScrollPane scrollPane1 = new JScrollPane();

		tabbedPane.addTab("Mañana", null, scrollPane, null);
		tabbedPane.addTab("Tarde", null, scrollPane1, null);

		tblMañana = new JTable();
		scrollPane.setViewportView(tblMañana);
		tblMañana.setModel(mdlMañana);

		tblTarde = new JTable();
		scrollPane1.setViewportView(tblTarde);
		tblTarde.setModel(mdlTarde);

		final JButton btnMarcar = new JButton("Marcar como realizada");
		btnMarcar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (tabbedPane.getSelectedIndex() == 0) // Mañana
				{

					reservas.get(tblTarde.getSelectedRow()).concretar();
					// ¿¿Update or insert??
					reservas.get(tblTarde.getSelectedRow()).persistirReserva();
					
					bindTablasReservas();
					
					
				} else if (tabbedPane.getSelectedIndex() == 1) // Tarde
				{
					System.out.println(tblTarde.getSelectedRow());
				}

			}
		});
		btnMarcar.setBounds(518, 423, 166, 23);
		p.add(btnMarcar);
		btnMarcar.setEnabled(false);

		JPanel panelCalendario = new JPanel();
		panelCalendario.setBorder(null);
		panelCalendario.setBackground(Color.LIGHT_GRAY);
		panelCalendario.setBounds(44, 275, 202, 154);
		p.add(panelCalendario);
		panelCalendario.setForeground(new Color(0, 0, 0));
		calendario.getDayChooser().setBorder(null);
		calendario.getDayChooser().setDay(1);
		calendario.addPropertyChangeListener("calendar",
				new PropertyChangeListener() {
					public void propertyChange(PropertyChangeEvent e) {
						// Actualizar datatable
						bindTablasReservas();
						// Deshabilito botón marcar
						btnMarcar.setEnabled(false);
					}
				});

		panelCalendario.add(calendario);

		tblMañana.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				btnMarcar.setEnabled(true);
			}
		});

		tblTarde.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				btnMarcar.setEnabled(true);
			}
		});

		bindCanchas();
		bindClientes();
		bindReservas();
		bindTablasReservas();

	}

	private void bindReservas() {
		ArrayList<Reserva> reservas = Reserva.obtenerReservas();
		for (Reserva reserva : reservas) {
			cboReservas.addItem("Cliente: " + reserva.getCliente().getNombre()
					+ ", Cancha: " + reserva.getCancha().getNombre()
					+ ", Horario: " + reserva.getHorario());
		}
	}

	private void bindClientes() {
		ArrayList<Cliente> clientes = Cliente.obtenerClientes();
		for (Cliente cliente : clientes) {
			cboClientes.addItem(cliente);
		}
	}

	private void bindCanchas() {

		ArrayList<Cancha> canchas = Cancha.obtenerCanchas();
		for (Cancha cancha : canchas) {
			cboCanchas.addItem(cancha + ", Precio: $"
					+ cancha.getPrecioPorHora());
		}

	}

	private void bindTablasReservas() {
		limpiarTablas();

		reservas = Reserva.obtenerReservas(calendario
				.getCalendar());
		for (Reserva reserva : reservas) {
			String horario = String.valueOf(reserva.getHorario());
			Pattern pattern = Pattern.compile(".........ART");
			Matcher matcher = pattern.matcher(horario);
			if (matcher.find())
				horario = matcher.group();

			Vector<String> row = new Vector<String>();
			row.add(reserva.getCancha().getNombre());
			row.add(String.valueOf(reserva.getCliente().getIdCliente()));
			row.add(horario);
			row.add(String.valueOf(reserva.getSeña()));
			row.add(String.valueOf(reserva.getTiempo()));
			double resto = (reserva.getCancha().getPrecioPorHora() * (reserva
					.getTiempo() * 0.0166666667)) - reserva.getSeña(); // 1
																		// Minuto
																		// =
																		// 0,0166666667
																		// Hora

			DecimalFormat df = new DecimalFormat("##.##");
			df.setRoundingMode(RoundingMode.DOWN);

			row.add(String.valueOf(df.format(resto)));
			row.add(reserva.getRealizada());

			if (Integer.parseInt(horario.substring(0, 2)) <= 12)
				mdlMañana.addRow(row);
			else
				mdlTarde.addRow(row);
		}

	}

	private void limpiarTablas() {
		for (int i = 0; i < mdlMañana.getRowCount(); i++) {
			mdlMañana.removeRow(i);
			i--;
		}
		for (int i = 0; i < mdlTarde.getRowCount(); i++) {
			mdlTarde.removeRow(i);
			i--;
		}

	}
}
