package Interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import Logica.Usuario;
import Recursos.Fondo;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inicio extends JFrame {


	private static final long serialVersionUID = 1L;
	
	JLabel lblMensaje1 = new JLabel("");
	JLabel lblMensaje2 = new JLabel("");
	private JPasswordField txtContraseña;
	private JTextField txtUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Persistencia.BBDD.verificarExistenciaBBDD();
					Inicio frame = new Inicio();
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
	public Inicio() {

		setIconImage(Toolkit.getDefaultToolkit().getImage(Inicio.class.getResource("/Recursos/images.jpg")));
		setTitle("CourtManager");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		
		Fondo p = new Fondo();
		p.setBackground(Color.BLACK);
		p.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(p);
		p.setLayout(null);
		
		JLabel lblCacho1 = new JLabel("Cacho");
		lblCacho1.setForeground(Color.WHITE);
		lblCacho1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblCacho1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCacho1.setBounds(271, 26, 118, 31);
		p.add(lblCacho1);
		
		JLabel lblCacho2 = new JLabel("Cacho");
		lblCacho2.setForeground(Color.BLACK);
		lblCacho2.setHorizontalAlignment(SwingConstants.CENTER);
		lblCacho2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblCacho2.setBounds(266, 26, 118, 31);
		p.add(lblCacho2);
		
		JLabel lblElRey1 = new JLabel("El Rey de las canchas");
		lblElRey1.setForeground(Color.WHITE);
		lblElRey1.setHorizontalAlignment(SwingConstants.CENTER);
		lblElRey1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 28));
		lblElRey1.setBounds(143, 79, 378, 31);
		p.add(lblElRey1);
		
		JLabel lblElRey2 = new JLabel("El Rey de las canchas");
		lblElRey2.setForeground(Color.BLACK);
		lblElRey2.setHorizontalAlignment(SwingConstants.CENTER);
		lblElRey2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 28));
		lblElRey2.setBounds(138, 79, 378, 31);
		p.add(lblElRey2);
		
		JLabel lblUsuario1 = new JLabel("Usuario:");
		lblUsuario1.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario1.setForeground(Color.WHITE);
		lblUsuario1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblUsuario1.setBackground(Color.WHITE);
		lblUsuario1.setBounds(111, 167, 173, 25);
		p.add(lblUsuario1);
		
		JLabel lblUsuario2 = new JLabel("Usuario:");
		lblUsuario2.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario2.setForeground(Color.BLACK);
		lblUsuario2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblUsuario2.setBackground(Color.WHITE);
		lblUsuario2.setBounds(120, 169, 146, 25);
		p.add(lblUsuario2);

		JLabel lblContraseña1 = new JLabel("Contrase\u00F1a:");
		lblContraseña1.setBackground(Color.WHITE);
		lblContraseña1.setForeground(Color.WHITE);
		lblContraseña1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblContraseña1.setHorizontalAlignment(SwingConstants.CENTER);
		lblContraseña1.setBounds(94, 205, 173, 25);
		p.add(lblContraseña1);
		
		JLabel lblContraseña2 = new JLabel("Contrase\u00F1a:");
		lblContraseña2.setForeground(Color.BLACK);
		lblContraseña2.setBackground(Color.WHITE);
		lblContraseña2.setHorizontalAlignment(SwingConstants.CENTER);
		lblContraseña2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblContraseña2.setBounds(102, 205, 146, 25);
		p.add(lblContraseña2);
		
		
		txtUsuario = new JTextField();
		txtUsuario.setForeground(Color.BLACK);
		txtUsuario.setBounds(256, 169, 152, 20);
		p.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		
		txtContraseña = new JPasswordField(10);
		txtContraseña.setSize(152, 20);
		txtContraseña.setLocation(256, 209);
		txtContraseña.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(64, 64, 64), new Color(64, 64, 64), new Color(64, 64, 64), new Color(64, 64, 64)), null));
		txtContraseña.setHorizontalAlignment(SwingConstants.CENTER);
		txtContraseña.setForeground(Color.BLACK);
		txtContraseña.setBackground(Color.WHITE);
		p.add(txtContraseña);
		txtContraseña.setColumns(10);

		
		JButton btnOk = new JButton("Ingresar");
		btnOk.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
				if (Usuario.validarDatos(txtUsuario.getText(), txtContraseña.getPassword()))
				{
					lblMensaje1.setText("Bienvenido al sistema!");
					lblMensaje2.setText("Bienvenido al sistema!");
					ControlCentral.main(null);
				}
				}
				catch (Exception e)
				{
					lblMensaje1.setText(e.getMessage());
					lblMensaje2.setText(e.getMessage());
				}
			}


		});
		btnOk.setBounds(437, 208, 77, 23);
		p.add(btnOk);
		lblMensaje1.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		lblMensaje1.setForeground(Color.WHITE);
		lblMensaje1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblMensaje1.setBounds(200, 308, 300, 14);
		p.add(lblMensaje1);
		lblMensaje2.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblMensaje2.setForeground(Color.BLACK);
		lblMensaje2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblMensaje2.setBounds(200, 304, 300, 14);
		p.add(lblMensaje2);
	}
}

