package Interfaz;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Recursos.Fondo;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

public class ControlCentral extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JComboBox cboCanchas = new JComboBox();
	JComboBox cboSocios = new JComboBox();
	JComboBox cboReservas = new JComboBox();
	private JTable table;
	private JTable table_1;

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

	/**
	 * Create the frame.
	 */
	public ControlCentral() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);

		Fondo p = new Fondo();
		p.setBackground(Color.BLACK);
		p.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(p);
		p.setLayout(null);

		JPanel panel = new JPanel();
		panel.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.setBackground(Color.BLACK);
		panel.setOpaque(false);
		panel.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Canchas",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel.setBounds(27, 30, 200, 77);
		p.add(panel);
		panel.setLayout(null);

		
		cboCanchas.setBounds(6, 16, 188, 20);
		panel.add(cboCanchas);

		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.setBounds(6, 47, 89, 23);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Eliminar");
		btnNewButton_1.setBounds(105, 47, 89, 23);
		panel.add(btnNewButton_1);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setOpaque(false);
		panel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_1.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Socios",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(28, 127, 200, 77);
		p.add(panel_1);

		
		cboSocios.setBounds(6, 16, 188, 20);
		panel_1.add(cboSocios);

		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(6, 47, 89, 23);
		panel_1.add(btnAgregar);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(105, 47, 89, 23);
		panel_1.add(btnEliminar);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setOpaque(false);
		panel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_2.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Reservas",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(28, 228, 200, 77);
		p.add(panel_2);

		
		cboReservas.setBounds(6, 16, 188, 20);
		panel_2.add(cboReservas);

		JButton btnAgregar_1 = new JButton("Agregar");
		btnAgregar_1.setBounds(6, 47, 89, 23);
		panel_2.add(btnAgregar_1);

		JButton btnEliminar_1 = new JButton("Eliminar");
		btnEliminar_1.setBounds(105, 47, 89, 23);
		panel_2.add(btnEliminar_1);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(277, 53, 396, 252);
		p.add(tabbedPane);

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
			/**
					 * 
					 */
					private static final long serialVersionUID = 1L;

		});
		table.getColumnModel().getColumn(4).setPreferredWidth(108);

		JScrollPane scrollPane1 = new JScrollPane();
		tabbedPane.addTab("New tab", null, scrollPane, null);

		tabbedPane.addTab("New tab", null, scrollPane1, null);

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
		
		bindCanchas();
		bindSocios();
		bindReservas();

	}

	private void bindReservas() {
		
	}

	private void bindSocios() {
		// TODO Auto-generated method stub
		ArrayList<Logica.Cliente> socios = Logica.Cliente.getClientes(); 
		for (Logica.Cliente cliente : socios)
		{
			cboSocios.addItem(cliente.getNombre());			
		}
	}

	private void bindCanchas() {
		// TODO Auto-generated method stub
		
		
	}
}