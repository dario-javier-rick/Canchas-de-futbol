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

import java.util.ArrayList;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

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
	private JTable tblMa�ana;
	private JTable tblTarde;
	DefaultTableModel mdlMa�ana = new DefaultTableModel(new Object[]{"Cancha","Id Cliente", "Horario", "Se\u00F1a", "Tiempo de Reserva", "Realizada"}, 0);
	DefaultTableModel mdlTarde = new DefaultTableModel(new Object[]{"Cancha","Id Cliente", "Horario", "Se\u00F1a", "Tiempo de Reserva", "Realizada"}, 0);
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
//		persistirCombos();
	}

//	private void persistirCombos() {
//		ArrayList<Cancha> canchas = new ArrayList<Cancha>();
//		for (int i = 0; i < cboCanchas.getItemCount(); i++) {
//			canchas.add((Cancha) cboCanchas.getItemAt(i));
//		}
//		Cancha.actualizarCanchas(canchas);
//
//		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
//		for (int i = 0; i < cboClientes.getItemCount(); i++) {
//			clientes.add((Cliente) cboClientes.getItemAt(i));
//		}
//		Cliente.actualizarClientes(clientes);
//
//		ArrayList<Reserva> reservas = new ArrayList<Reserva>();
//		for (int i = 0; i < cboReservas.getItemCount(); i++) {
//			reservas.add((Reserva) cboReservas.getItemAt(i));
//		}
//		Reserva.actualizarReservas(reservas);
//	}

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
		
		JPanel panelCalendario = new JPanel();
		panelCalendario.setForeground(new Color(0, 0, 0));
		panelCalendario.setBounds(8, 11, 399, 197);
		panelGeneral.add(panelCalendario);
		calendario.addPropertyChangeListener("calendar",
				new PropertyChangeListener() {
					public void propertyChange(PropertyChangeEvent e) {
						// Actualizar datatable
						bindTablasReservas();
					}
				});

		
		panelCalendario.add(calendario);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setBorder(new TitledBorder(null, "Revervas hechas",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tabbedPane.setBounds(8, 219, 399, 180);
		panelGeneral.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		JScrollPane scrollPane1 = new JScrollPane();
		
		tabbedPane.addTab("Ma�ana", null, scrollPane, null);
		tabbedPane.addTab("Tarde", null, scrollPane1, null);
		
		tblMa�ana = new JTable();
		scrollPane.setViewportView(tblMa�ana);
		tblMa�ana.setModel(mdlMa�ana);
		
		tblTarde = new JTable();
		scrollPane1.setViewportView(tblTarde);
		tblTarde.setModel(mdlTarde);
		

		JButton btnCargar = new JButton("Cargar");
		btnCargar.setBounds(595, 423, 89, 23);
		p.add(btnCargar);

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
		
		ArrayList<Reserva> reservas = Reserva.obtenerReservas(calendario.getCalendar());
		for (Reserva reserva : reservas)
		{
			String horario = String.valueOf(reserva.getHorario());
			Pattern pattern = Pattern.compile(".........ART");
			Matcher matcher = pattern.matcher(horario);
			if (matcher.find())
				horario = matcher.group();

			
			Vector<String> row = new Vector<String>();
		    row.add(reserva.getCancha().getNombre());
		    row.add(String.valueOf(reserva.getCliente().getIdCliente()));
		    row.add(horario);
		    row.add(String.valueOf(reserva.getSe�a()));
		    row.add(String.valueOf(reserva.getTiempo()));
		    row.add(reserva.getRealizada());
		    
		    if (Integer.parseInt(horario.substring(0, 2)) <= 12)
		    	mdlMa�ana.addRow(row);
		    else
		    	mdlTarde.addRow(row);
		}
		
	}

	private void limpiarTablas() {		
		for (int i = 0; i<mdlMa�ana.getRowCount(); i++)
		{
			mdlMa�ana.removeRow(i);
		}
		for (int i = 0; i<mdlTarde.getRowCount(); i++)
		{
			mdlTarde.removeRow(i);
		}
		
	}
}
