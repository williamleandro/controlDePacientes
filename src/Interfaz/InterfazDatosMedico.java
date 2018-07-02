package Interfaz;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import objetos.Medico;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;

public class InterfazDatosMedico {

	private JFrame frame;
	private JTextField textCodigo;
	private JTextField textNombre;
	private JTextField textMatricula;
	private JTextField textEspecialidad;
	

	/**
	 * Create the application.
	 */
	public InterfazDatosMedico() {
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
		
		JLabel lblDatosDeMdico = new JLabel("Datos del M\u00E9dico");
		lblDatosDeMdico.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblDatosDeMdico.setBounds(190, 16, 198, 42);
		frame.getContentPane().add(lblDatosDeMdico);
		
		JLabel lblCdigoDelMdico = new JLabel("C\u00F3digo del M\u00E9dico");
		lblCdigoDelMdico.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCdigoDelMdico.setBounds(40, 124, 162, 30);
		frame.getContentPane().add(lblCdigoDelMdico);
		
		JLabel lblNombreDelMdico = new JLabel("Nombre del M\u00E9dico");
		lblNombreDelMdico.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombreDelMdico.setBounds(40, 200, 176, 30);
		frame.getContentPane().add(lblNombreDelMdico);
		
		JLabel lblEspecializacinDelMdico = new JLabel("Especializaci\u00F3n del M\u00E9dico");
		lblEspecializacinDelMdico.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEspecializacinDelMdico.setBounds(40, 345, 241, 30);
		frame.getContentPane().add(lblEspecializacinDelMdico);
		
		textCodigo = new JTextField();
		textCodigo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textCodigo.setBounds(311, 124, 181, 30);
		frame.getContentPane().add(textCodigo);
		textCodigo.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textNombre.setBounds(311, 202, 181, 30);
		frame.getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		textMatricula = new JTextField();
		textMatricula.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textMatricula.setBounds(311, 347, 181, 30);
		frame.getContentPane().add(textMatricula);
		textMatricula.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Medico medico = new Medico(textCodigo.getText(), textNombre.getText(), textMatricula.getText(), textEspecialidad.getText());
				if(medico.esDatosCompletos()) {
					medico.escribirMedico();
					JOptionPane.showMessageDialog(null, "Se ha ingresado al médico correctamente.", "Acción Realizada", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Hay campos vacios. Procure llenar los campos.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnGuardar.setBounds(84, 472, 115, 36);
		frame.getContentPane().add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnCancelar.setBounds(377, 472, 115, 36);
		frame.getContentPane().add(btnCancelar);
		
		JLabel lblMatrculaDelMdico = new JLabel("Matr\u00EDcula del M\u00E9dico");
		lblMatrculaDelMdico.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMatrculaDelMdico.setBounds(40, 276, 198, 30);
		frame.getContentPane().add(lblMatrculaDelMdico);
		
		textEspecialidad = new JTextField();
		textEspecialidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textEspecialidad.setColumns(10);
		textEspecialidad.setBounds(311, 278, 181, 30);
		frame.getContentPane().add(textEspecialidad);
	}
}
