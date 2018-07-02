package Interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import utilitarios.Validacion;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JPasswordField;

public class Login {

	private JFrame frame;
	private JTextField usuarioField;
	private MenuPrincipal menuPrincipal;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		frame.setBounds(100, 100, 640, 580);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Sistema de Control de Pacientes - Clínica Nuevo Espiritu");
		frame.setLocationRelativeTo(null);
		
		JLabel lblBienvenidoAlSistema = new JLabel("Bienvenido al Sistema de Control de Pacientes");
		lblBienvenidoAlSistema.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenidoAlSistema.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblBienvenidoAlSistema.setBounds(15, 16, 588, 60);
		frame.getContentPane().add(lblBienvenidoAlSistema);
		
		JLabel lblClnicaNuevoEspiritu = new JLabel("Cl\u00EDnica Nuevo Espiritu");
		lblClnicaNuevoEspiritu.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblClnicaNuevoEspiritu.setBounds(183, 67, 256, 31);
		frame.getContentPane().add(lblClnicaNuevoEspiritu);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsuario.setBounds(95, 183, 117, 31);
		frame.getContentPane().add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblContrasea.setBounds(95, 250, 117, 31);
		frame.getContentPane().add(lblContrasea);
		
		usuarioField = new JTextField();
		usuarioField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		usuarioField.setBounds(227, 183, 200, 30);
		frame.getContentPane().add(usuarioField);
		usuarioField.setColumns(10);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!usuarioField.getText().isEmpty() || !passwordField.getText().isEmpty()) {
					if(Validacion.esUsuarioValido(usuarioField.getText(), passwordField.getText())) {
						menuPrincipal = new MenuPrincipal();
						frame.setVisible(false);
					} else {
						JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrecto.", "Error", JOptionPane.ERROR_MESSAGE);
					}
					
				} else {
					JOptionPane.showMessageDialog(null, "Ingrese usuario y contraseña para poder ingresar.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnIngresar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnIngresar.setBounds(246, 322, 124, 42);
		frame.getContentPane().add(btnIngresar);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordField.setBounds(227, 250, 200, 30);
		frame.getContentPane().add(passwordField);
	}

	public JFrame getFrame() {
		return frame;
	}
}


