package Interfaz;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.Cliente;
import Recursos.Fondo;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgregarClientes extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7420895704590513861L;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField textField_2;
	private JTextField txtTelefono;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarClientes frame = new AgregarClientes(null);
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
	public AgregarClientes(final ControlCentral instancia) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 530, 300);

		Fondo p = new Fondo();
		p.setBackground(Color.BLACK);
		p.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(p);
		p.setLayout(null);

		JPanel panel_9 = new JPanel();
		panel_9.setOpaque(false);
		panel_9.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_9.setBounds(10, 23, 510, 216);
		p.add(panel_9);
		panel_9.setLayout(null);

		JPanel panel_8 = new JPanel();
		panel_8.setBounds(72, 16, 162, 43);
		panel_9.add(panel_8);
		panel_8.setOpaque(false);
		panel_8.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_8.setLayout(null);

		txtNombre = new JTextField();
		txtNombre.setBounds(6, 16, 150, 20);
		panel_8.add(txtNombre);
		txtNombre.setColumns(10);

		JPanel panel_7 = new JPanel();
		panel_7.setBounds(350, 16, 162, 43);
		panel_9.add(panel_7);
		panel_7.setOpaque(false);
		panel_7.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_7.setLayout(null);

		txtApellido = new JTextField();
		txtApellido.setBounds(6, 16, 130, 20);
		panel_7.add(txtApellido);
		txtApellido.setColumns(10);
		
		JLabel label_8 = new JLabel("*");
		label_8.setForeground(Color.RED);
		label_8.setFont(new Font("Impact", Font.PLAIN, 55));
		label_8.setBounds(139, 16, 23, 57);
		panel_7.add(label_8);

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(72, 59, 98, 43);
		panel_9.add(panel_5);
		panel_5.setOpaque(false);
		panel_5.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5.setLayout(null);

		textField_2 = new JTextField();
		textField_2.setBounds(6, 16, 82, 20);
		panel_5.add(textField_2);
		textField_2.setColumns(10);

		JPanel panel_6 = new JPanel();
		panel_6.setBounds(290, 59, 222, 43);
		panel_9.add(panel_6);
		panel_6.setOpaque(false);
		panel_6.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_6.setLayout(null);

		JSpinner spinner = new JSpinner();
		spinner.setBounds(112, 16, 49, 20);
		panel_6.add(spinner);
		spinner.setModel(new SpinnerNumberModel(new Integer(1), null, null,
				new Integer(0)));

		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(167, 16, 49, 20);
		panel_6.add(spinner_1);
		spinner_1.setModel(new SpinnerNumberModel(1900, 1900, 2015, 1));

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(6, 16, 99, 20);
		panel_6.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {
				"Elija un mes. . . .", "Enero", "Febrero", "Marzo", "Abril",
				"Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre",
				"Noviembre", "Diciembre" }));
		
		JLabel label_6 = new JLabel("*");
		label_6.setForeground(Color.RED);
		label_6.setFont(new Font("Impact", Font.PLAIN, 55));
		label_6.setBounds(193, -25, 23, 57);
		panel_6.add(label_6);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(72, 102, 98, 43);
		panel_9.add(panel_4);
		panel_4.setOpaque(false);
		panel_4.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_4.setLayout(null);

		txtTelefono = new JTextField();
		txtTelefono.setBounds(6, 16, 86, 20);
		panel_4.add(txtTelefono);
		txtTelefono.setColumns(10);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(72, 143, 404, 66);
		panel_9.add(panel_3);
		panel_3.setOpaque(false);
		panel_3.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setLayout(null);

		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBounds(6, 12, 132, 43);
		panel_3.add(panel);
		panel.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Localidad",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel.setLayout(null);

		textField_4 = new JTextField();
		textField_4.setBounds(6, 16, 120, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel_1.setBounds(153, 12, 132, 43);
		panel_3.add(panel_1);
		panel_1.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Calle",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_1.setLayout(null);

		textField_5 = new JTextField();
		textField_5.setBounds(6, 16, 120, 20);
		panel_1.add(textField_5);
		textField_5.setColumns(10);

		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_2.setBounds(300, 12, 98, 43);
		panel_3.add(panel_2);
		panel_2.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "N\u00FAmero",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_2.setLayout(null);

		textField_6 = new JTextField();
		textField_6.setBounds(6, 16, 86, 20);
		panel_2.add(textField_6);
		textField_6.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setBounds(6, 33, 68, 14);
		panel_9.add(lblNombre);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setForeground(Color.WHITE);
		lblApellido.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblApellido.setBounds(261, 33, 81, 14);
		panel_9.add(lblApellido);

		JLabel lblDni = new JLabel("DNI");
		lblDni.setForeground(Color.WHITE);
		lblDni.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblDni.setBounds(6, 76, 46, 14);
		panel_9.add(lblDni);

		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");
		lblFechaDeNacimiento.setForeground(Color.WHITE);
		lblFechaDeNacimiento.setFont(new Font("Tahoma",
				Font.BOLD | Font.ITALIC, 11));
		lblFechaDeNacimiento.setBounds(168, 76, 116, 14);
		panel_9.add(lblFechaDeNacimiento);

		JLabel lblTelefono1 = new JLabel("Telefono:");
		lblTelefono1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblTelefono1.setForeground(Color.WHITE);
		lblTelefono1.setBounds(6, 121, 46, 14);
		panel_9.add(lblTelefono1);

		JLabel lblTelefono2 = new JLabel("Telefono");
		lblTelefono2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblTelefono2.setBounds(5, 122, 46, 14);
		panel_9.add(lblTelefono2);

		JLabel lblDireccin = new JLabel("Direcci\u00F3n");
		lblDireccin.setForeground(Color.WHITE);
		lblDireccin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblDireccin.setBounds(6, 173, 68, 14);
		panel_9.add(lblDireccin);

		JLabel label = new JLabel("Nombre");
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		label.setForeground(Color.BLACK);
		label.setBounds(5, 34, 68, 14);
		panel_9.add(label);

		JLabel label_1 = new JLabel("DNI");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		label_1.setBounds(6, 78, 46, 14);
		panel_9.add(label_1);

		JLabel label_3 = new JLabel("Direcci\u00F3n");
		label_3.setForeground(Color.BLACK);
		label_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		label_3.setBounds(5, 174, 68, 14);
		panel_9.add(label_3);

		JLabel label_4 = new JLabel("Apellido");
		label_4.setForeground(Color.BLACK);
		label_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		label_4.setBounds(261, 35, 70, 14);
		panel_9.add(label_4);

		JLabel label_5 = new JLabel("Fecha de nacimiento");
		label_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		label_5.setForeground(Color.BLACK);
		label_5.setBounds(168, 77, 115, 14);
		panel_9.add(label_5);
		
		JLabel label_2 = new JLabel("*");
		label_2.setForeground(Color.RED);
		label_2.setBounds(180, 121, 23, 57);
		panel_9.add(label_2);
		label_2.setFont(new Font("Impact", Font.PLAIN, 55));
		
		JLabel label_7 = new JLabel("*");
		label_7.setForeground(Color.RED);
		label_7.setFont(new Font("Impact", Font.PLAIN, 55));
		label_7.setBounds(232, 35, 23, 57);
		panel_9.add(label_7);

		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (validarDatos()) {
					try
					{
					// Llamar a l�gica y persistir Cliente
					Cliente cliente = new Cliente(
							Cliente.getUltimoIdCliente() + 1, txtNombre
									.getText(), txtApellido.getText(), Integer
									.parseInt(txtTelefono.getText()));
					cliente.persistirCliente();
					JOptionPane.showMessageDialog(null, "Cliente agregado!");
					instancia.actualizarCombos();
					dispose();
					}
					catch (Exception ex)
					{
						JOptionPane.showMessageDialog(null, "Ocurrio un problema al agregar el cliente. Codigo de error: "
										+ ex.getMessage());
					}
				}
			}

			private boolean validarDatos() {
				try {
					Integer.parseInt(txtTelefono.getText());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,
							"El tel�fono no tiene formato num�rico");
					return false;
				}
				return true;
			}
		});
		btnAgregar.setBounds(326, 245, 89, 23);
		p.add(btnAgregar);

		JButton btnCancelar = new JButton("Cerrar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		btnCancelar.setBounds(425, 245, 89, 23);
		p.add(btnCancelar);

		JButton btnPerfil = new JButton("Perfil");
		btnPerfil.setToolTipText("Permite agregar foto 4x4 a un usuario\r\n");
		btnPerfil.setBounds(227, 245, 89, 23);
		p.add(btnPerfil);

	}
}
