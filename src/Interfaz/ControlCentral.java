package Interfaz;

import java.awt.BorderLayout;
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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ControlCentral extends JFrame {

	private JPanel contentPane;
	JComboBox cboClientes = new JComboBox();
	JComboBox cboCanchas = new JComboBox();
	JComboBox cboReservas = new JComboBox();
	private JTable table;
	private JTable table_1;
	private ControlCentral ControlCentral = this;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ControlCentral frame = new ControlCentral();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void actualizarCombos()
	{
		cboClientes.removeAllItems();
		cboCanchas.removeAllItems();
		cboReservas.removeAllItems();
		bindClientes();
		bindCanchas();
		bindReservas();
	
		//persistirCombos();
	}

	private void persistirCombos() {
		ArrayList<Cancha> canchas = new ArrayList<Cancha>();
        for(int i=0;i<cboCanchas.getItemCount();i++){
        	canchas.add((Cancha) cboCanchas.getItemAt(i));
        }
		Cancha.actualizarCanchas(canchas);
		
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        for(int i=0;i<cboClientes.getItemCount();i++){
        	clientes.add((Cliente) cboClientes.getItemAt(i));
        }
        Cliente.actualizarClientes(clientes);
		
		ArrayList<Reserva> reservas = new ArrayList<Reserva>();
        for(int i=0;i<cboReservas.getItemCount();i++){
        	reservas.add((Reserva) cboReservas.getItemAt(i));
        }
        Reserva.actualizarReservas(reservas);
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

		JPanel panel = new JPanel();
		panel.setBounds(10, 30, 257, 77);
		panel.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.setBackground(Color.BLACK);
		panel.setOpaque(false);
		panel.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Canchas",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		p.add(panel);
		panel.setLayout(null);
		cboCanchas.setFont(new Font("Tahoma", Font.PLAIN, 11));

		cboCanchas.setBounds(6, 16, 241, 20);
		panel.add(cboCanchas);

		JButton btnAgregarCanchas = new JButton("Agregar");
		btnAgregarCanchas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
			  AgregarCancha Canchas = new AgregarCancha();
			  Canchas.setVisible(true);
			}
		});
		
		btnAgregarCanchas.setBounds(6, 47, 89, 23);
		panel.add(btnAgregarCanchas);

		JButton btnEliminarCanchas = new JButton("Eliminar");
		btnEliminarCanchas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				EliminarCancha Canchas = new EliminarCancha(ControlCentral);
				  Canchas.setVisible(true);
			}
		});
		btnEliminarCanchas.setBounds(158, 47, 89, 23);
		panel.add(btnEliminarCanchas);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 127, 257, 77);
		panel_1.setLayout(null);
		panel_1.setOpaque(false);
		panel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_1.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Socios",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		panel_1.setBackground(Color.BLACK);
		p.add(panel_1);
		cboClientes.setFont(new Font("Tahoma", Font.PLAIN, 11));

		cboClientes.setBounds(6, 16, 241, 20);
		panel_1.add(cboClientes);

		JButton btnAgregarClientes = new JButton("Agregar");
		btnAgregarClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AgregarClientes Canchas = new AgregarClientes();
				  Canchas.setVisible(true);
			}
		});
		btnAgregarClientes.setBounds(6, 47, 89, 23);
		panel_1.add(btnAgregarClientes);

		JButton btnEliminarClientes = new JButton("Eliminar");
		btnEliminarClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				EliminarClientes Clientes = new EliminarClientes(ControlCentral);
				  Clientes.setVisible(true);
			}
		});
		btnEliminarClientes.setBounds(158, 47, 89, 23);
		panel_1.add(btnEliminarClientes);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 228, 257, 77);
		panel_2.setLayout(null);
		panel_2.setOpaque(false);
		panel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_2.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Reservas",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_2.setBackground(Color.BLACK);
		p.add(panel_2);
		cboReservas.setFont(new Font("Tahoma", Font.PLAIN, 11));

		cboReservas.setBounds(6, 16, 241, 20);
		panel_2.add(cboReservas);

		JButton btnAgregarReservas = new JButton("Agregar");
		btnAgregarReservas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AgregarReservas reservas = new AgregarReservas();
				  reservas.setVisible(true);
			}
		});
		btnAgregarReservas.setBounds(6, 47, 89, 23);
		panel_2.add(btnAgregarReservas);

		JButton btnEliminarReservas = new JButton("Eliminar");
		btnEliminarReservas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				EliminarReservas reservas = new EliminarReservas(ControlCentral);
				  reservas.setVisible(true);
			}
		});
		btnEliminarReservas.setBounds(158, 47, 89, 23);
		panel_2.add(btnEliminarReservas);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(288, 11, 396, 294);
		panel_3.setOpaque(false);
		p.add(panel_3);
		panel_3.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setBorder(new TitledBorder(null, "Revervas hechas",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tabbedPane.setBounds(10, 11, 386, 266);
		panel_3.add(tabbedPane);

		JScrollPane scrollPane1 = new JScrollPane();

		tabbedPane.addTab("Tarde", null, scrollPane1, null);

		table_1 = new JTable();
		scrollPane1.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(new Object[][] {
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null }, }, new String[] {
				"New column", "New column", "New column", "New column",
				"New column" }));
		
				JScrollPane scrollPane = new JScrollPane();
				tabbedPane.addTab("New tab", null, scrollPane, null);
				
						table = new JTable();
						scrollPane.setViewportView(table);
						table.setModel(new DefaultTableModel(new Object[][] {
								{ null, null, null, null, null },
								{ null, null, null, null, null },
								{ null, null, null, null, null },
								{ null, null, null, null, null },
								{ null, null, null, null, null },
								{ null, null, null, null, null },
								{ null, null, null, null, null },
								{ null, null, null, null, null },
								{ null, null, null, null, null },
								{ null, null, null, null, null },
								{ null, null, null, null, null },
								{ null, null, null, null, null }, }, new String[] { "Cancha",
								"Id Cliente", "Horario", "Se\u00F1a", "Tiempo de Reserva" }) {
							Class[] columnTypes = new Class[] { String.class, String.class,
									String.class, String.class, String.class };

							public Class getColumnClass(int columnIndex) {
								return columnTypes[columnIndex];
							}
						});
						table.getColumnModel().getColumn(4).setPreferredWidth(108);
						tabbedPane.addTab("Ma�ana", null, scrollPane, null);

		JButton btnCargar = new JButton("Cargar");
		btnCargar.setBounds(595, 423, 89, 23);
		p.add(btnCargar);

		bindCanchas();
		bindClientes();
		bindReservas();

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
			cboCanchas.addItem(cancha.getNombre() + ", Tipo: "
					+ cancha.getTipo_cancha() + ", Precio: $" + cancha.getPrecioPorHora());
		}
	}
}
