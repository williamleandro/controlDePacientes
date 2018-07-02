package Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utilitarios.Validacion;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class InterfazInformeMedico extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JList list = new JList();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazInformeMedico frame = new InterfazInformeMedico();
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
	public InterfazInformeMedico() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 620);
		setVisible(true);
		setTitle("Sistema de Control de Pacientes - Clínica Nuevo Espiritu");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInformeDeMdicos = new JLabel("Informe de M\u00E9dicos");
		lblInformeDeMdicos.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblInformeDeMdicos.setBounds(180, 16, 242, 31);
		contentPane.add(lblInformeDeMdicos);
		
		JLabel label = new JLabel("Ingrese Matricula del M\u00E9dico:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setBounds(42, 81, 308, 31);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(42, 127, 318, 26);
		contentPane.add(textField);
		
		JButton button = new JButton("Buscar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textField.getText().isEmpty()) {
					if(Validacion.existeMedico(textField.getText())) {
						agregarEspecialidades(textField.getText());
					} else {
						JOptionPane.showMessageDialog(null, "Matricula de Médico Incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Matricula de Médico Vacio. Ingrese Matricula", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		button.setBounds(435, 126, 115, 29);
		contentPane.add(button);
		
		JLabel lblElMdicoTrata = new JLabel("El M\u00E9dico trata las siguientes enfermedades:");
		lblElMdicoTrata.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblElMdicoTrata.setBounds(42, 195, 411, 31);
		contentPane.add(lblElMdicoTrata);
		
		JButton btnNewButton = new JButton("Atr\u00E1s");
		btnNewButton.setBounds(219, 510, 115, 38);
		contentPane.add(btnNewButton);
		list.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		list.setBounds(201, 253, 165, 229);
		contentPane.add(list);
	}
	
	private void agregarEspecialidades(String matricula) {
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		String linea;
		
		try {
			fileReader = new FileReader(new File("file/situacionPacientes.txt"));
			bufferedReader = new BufferedReader(fileReader);
			
			DefaultListModel<String> modelo = new DefaultListModel<>();
			
			while ((linea = bufferedReader.readLine()) != null) {
				String [] datos = linea.split(" ");
				
				if(matricula.equals(datos[1])) {
					modelo.addElement(datos[1]);
				}
				
			}	
			list.setModel(modelo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
}
