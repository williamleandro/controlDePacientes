package Interfaz;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;

import objetos.Paciente;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class InterfazDatosPaciente {

	private JFrame frame;
	private JTextField textCodigo;
	private JTextField textNombre;
	private JTextField textDNI;
	private JTextField textTelefono;
	private JTextField textCalle;
	private JTextField textNroCalle;
	private JDateChooser dateIngreso;
	private JComboBox<String> comboTipoSangre;

	/**
	 * Create the application.
	 */
	public InterfazDatosPaciente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 640, 620);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setTitle("Sistema de Control de Pacientes - Clínica Nuevo Espiritu");
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDatosDePacientes = new JLabel("Datos de Pacientes");
		lblDatosDePacientes.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblDatosDePacientes.setBounds(180, 16, 215, 36);
		frame.getContentPane().add(lblDatosDePacientes);
		
		JLabel lblCdigoDePaciente = new JLabel("C\u00F3digo de Paciente");
		lblCdigoDePaciente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCdigoDePaciente.setBounds(50, 78, 179, 42);
		frame.getContentPane().add(lblCdigoDePaciente);
		
		JLabel lblNombrePaciente = new JLabel("Nombre Paciente");
		lblNombrePaciente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombrePaciente.setBounds(50, 136, 179, 42);
		frame.getContentPane().add(lblNombrePaciente);
		
		textCodigo = new JTextField();
		textCodigo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textCodigo.setBounds(265, 85, 200, 32);
		frame.getContentPane().add(textCodigo);
		textCodigo.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textNombre.setBounds(265, 143, 200, 32);
		frame.getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Paciente paciente = new Paciente(textCodigo.getText(), textNombre.getText(), textDNI.getText(), textTelefono.getText(), comboTipoSangre.getSelectedItem().toString(), dateIngreso.getCalendar(), textCalle.getText(), textNroCalle.getText());
				if (paciente.validaCampos()) {
					paciente.escribirPaciente();
					JOptionPane.showMessageDialog(null, "Se ha ingresado el paciente correctamente.", "Acción Realizada", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Hay campos vacios. Procure llenar los campos.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnGuardar.setBounds(114, 512, 115, 36);
		frame.getContentPane().add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuPrincipal menuPrincipal = new MenuPrincipal();
				frame.setVisible(false);
			}
		});
		btnCancelar.setBounds(350, 512, 115, 36);
		frame.getContentPane().add(btnCancelar);
		
		JLabel lblDniPaciente = new JLabel("DNI Paciente");
		lblDniPaciente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDniPaciente.setBounds(50, 188, 149, 36);
		frame.getContentPane().add(lblDniPaciente);
		
		textDNI = new JTextField();
		textDNI.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textDNI.setColumns(10);
		textDNI.setBounds(265, 191, 200, 32);
		frame.getContentPane().add(textDNI);
		
		JLabel lblTelefonoPaciente = new JLabel("Telefono Paciente");
		lblTelefonoPaciente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTelefonoPaciente.setBounds(50, 235, 169, 36);
		frame.getContentPane().add(lblTelefonoPaciente);
		
		textTelefono = new JTextField();
		textTelefono.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textTelefono.setColumns(10);
		textTelefono.setBounds(265, 239, 200, 32);
		frame.getContentPane().add(textTelefono);
		
		JLabel lblFechaDeIngreso = new JLabel("Fecha de Ingreso");
		lblFechaDeIngreso.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFechaDeIngreso.setBounds(50, 287, 169, 31);
		frame.getContentPane().add(lblFechaDeIngreso);
		
		JLabel lblTipoDeSangre = new JLabel("Tipo de Sangre");
		lblTipoDeSangre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTipoDeSangre.setBounds(50, 334, 169, 31);
		frame.getContentPane().add(lblTipoDeSangre);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDireccin.setBounds(50, 381, 115, 32);
		frame.getContentPane().add(lblDireccin);
		
		JLabel lblCalle = new JLabel("Calle:");
		lblCalle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCalle.setBounds(114, 412, 115, 32);
		frame.getContentPane().add(lblCalle);
		
		textCalle = new JTextField();
		textCalle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textCalle.setColumns(10);
		textCalle.setBounds(265, 412, 200, 32);
		frame.getContentPane().add(textCalle);
		
		JLabel lblN = new JLabel("N\u00B0");
		lblN.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblN.setBounds(114, 454, 115, 32);
		frame.getContentPane().add(lblN);
		
		textNroCalle = new JTextField();
		textNroCalle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textNroCalle.setColumns(10);
		textNroCalle.setBounds(265, 454, 200, 32);
		frame.getContentPane().add(textNroCalle);
		
		dateIngreso = new JDateChooser();
		dateIngreso.setBounds(265, 287, 200, 31);
		dateIngreso.setDateFormatString("dd-MM-yyyy");
		dateIngreso.setFont(new Font("Tahoma", Font.PLAIN, 18));
		frame.getContentPane().add(dateIngreso);
		
		comboTipoSangre = new JComboBox<String>();
		comboTipoSangre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboTipoSangre.setModel(new DefaultComboBoxModel<String>(new String[] {"A-", "A+", "B-", "B+", "O-", "O+", "AB-", "AB+"}));
		comboTipoSangre.setBounds(265, 338, 200, 26);
		frame.getContentPane().add(comboTipoSangre);
	}
	
}
