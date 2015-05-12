package Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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

public class Inicio extends JFrame {

	private JPanel contentPane;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBackground(Color.RED);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(294, 118, 76, 25);
		p.add(lblNewLabel);
		
		JLabel label = new JLabel("Login");
		label.setForeground(Color.LIGHT_GRAY);
		label.setBackground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		label.setBounds(290, 118, 76, 25);
		p.add(label);
		
		txtPassword = new JTextField();
		txtPassword.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(64, 64, 64), new Color(64, 64, 64), new Color(64, 64, 64), new Color(64, 64, 64)), null));
		txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtPassword.setForeground(Color.BLACK);
		txtPassword.setBackground(Color.WHITE);
		txtPassword.setBounds(256, 154, 152, 20);
		p.add(txtPassword);
		txtPassword.setColumns(10);
		
		JButton btnOk = new JButton("Ok");
		btnOk.setBounds(413, 153, 52, 23);
		p.add(btnOk);
		
		JLabel label_1 = new JLabel("Generar Password");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		label_1.setBounds(256, 189, 152, 14);
		p.add(label_1);
		
		JLabel label_2 = new JLabel("Generar Password");
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		label_2.setBounds(254, 189, 152, 14);
		p.add(label_2);
		
		JLabel lblCacho = new JLabel("Cacho");
		lblCacho.setForeground(Color.WHITE);
		lblCacho.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblCacho.setHorizontalAlignment(SwingConstants.CENTER);
		lblCacho.setBounds(266, 214, 118, 31);
		p.add(lblCacho);
		
		JLabel lblElReyDe = new JLabel("El Rey de las canchas");
		lblElReyDe.setForeground(Color.WHITE);
		lblElReyDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblElReyDe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 28));
		lblElReyDe.setBounds(142, 256, 378, 31);
		p.add(lblElReyDe);
		
		JLabel label_3 = new JLabel("Cacho");
		label_3.setForeground(Color.BLACK);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		label_3.setBounds(260, 214, 118, 31);
		p.add(label_3);
		
		JLabel label_4 = new JLabel("El Rey de las canchas");
		label_4.setForeground(Color.BLACK);
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 28));
		label_4.setBounds(138, 256, 378, 31);
		p.add(label_4);
	}
}
