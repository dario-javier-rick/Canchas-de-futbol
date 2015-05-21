package Interfaz;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Recursos.Fondo;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;


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


public class AgregarReservas extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JCalendar calendar = new JCalendar();

	private JTextField textField;
	private JPanel panel_1;
	private JPanel panel_2;
	private JTextField textField_1;
	private JPanel panel_3;
	private JTextField txtHoraReserva = new JTextField();
	private JPanel panel_4;
	private JTextField textField_3;
	private JPanel panel_5;
	private JTextField textField_4;
	private JButton btnAceptar;
	private JButton button;
	private JPanel panel_6;
	JComboBox cboHoras = new JComboBox();
	JComboBox cboMinutos = new JComboBox();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarReservas frame = new AgregarReservas();
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
	public AgregarReservas() {
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

		panel.add(calendar);
				
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Cancha",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(16, 11, 192, 43);
		p.add(panel_1);
		panel_1.setLayout(null);

		textField = new JTextField();
		textField.setBounds(6, 16, 176, 20);
		panel_1.add(textField);
		textField.setColumns(10);

		JLabel label = new JLabel("New label");
		label.setBounds(-54, 24, 200, 50);
		p.add(label);

		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Id del cliente",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(16, 65, 192, 43);
		p.add(panel_2);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(6, 16, 176, 20);
		panel_2.add(textField_1);

		panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Fecha & Hora de reserva",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(16, 227, 192, 43);
		p.add(panel_3);

		txtHoraReserva.setEditable(false);
		txtHoraReserva.setColumns(10);
		txtHoraReserva.setBounds(6, 16, 176, 20);
		panel_3.add(txtHoraReserva);

		panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Se\u00F1a",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_4.setBounds(16, 119, 192, 43);
		p.add(panel_4);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(6, 16, 176, 20);
		panel_4.add(textField_3);

		panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Tiempo de reserva",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5.setBounds(272, 193, 195, 43);
		p.add(panel_5);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(6, 16, 169, 20);
		panel_5.add(textField_4);

		btnAceptar = new JButton("Cancelar");
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		btnAceptar.setBounds(379, 247, 89, 23);
		p.add(btnAceptar);

		button = new JButton("Aceptar");
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

		panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Horario",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_6.setBounds(16, 173, 192, 43);
		p.add(panel_6);

		cboHoras.setBounds(11, 14, 50, 20);
		panel_6.add(cboHoras);
		cboHoras.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				txtHoraReserva.setText(cboHoras.getSelectedItem().toString()+ ":" 
//						+ cboMinutos.getSelectedItem().toString()
						+ " Hs.");
			}
		});

		cboMinutos.setBounds(100, 14, 50, 20);
		panel_6.add(cboMinutos);
		cboMinutos.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				txtHoraReserva
						.setText(cboHoras.getSelectedItem().toString() + ":"
//								+ cboMinutos.getSelectedItem().toString()
								+ " Hs.");
			}
		});

		JLabel lblHoras = new JLabel("Horas");
		lblHoras.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblHoras.setBounds(69, 17, 33, 14);
		panel_6.add(lblHoras);

		JLabel lblMin = new JLabel("Min");
		lblMin.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMin.setBounds(160, 17, 22, 15);
		panel_6.add(lblMin);

		bindHoras();
		bindMinutos();
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
