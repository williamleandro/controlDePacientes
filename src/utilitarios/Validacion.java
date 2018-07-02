package utilitarios;

import java.io.*;

public class Validacion {
	
	/*
	 * Se lee el archivo de Usuarios para validar que 
	 * el usuario y el password ingreasado
	 * sea el correcto. Así poder acceder al sistema.
	 */
	public static Boolean esUsuarioValido(String user, String pass) {
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		String linea;
		Boolean existeUsuario = false;
		
		try {
			fileReader = new FileReader(new File("C:\\Users\\wajaya\\eclipse-workspace\\Analisis-De-Software-2018\\ControldePacientes\\file\\usuarios.txt"));
			bufferedReader = new BufferedReader(fileReader);
			
			while ((linea = bufferedReader.readLine()) != null) {
				String [] datos = linea.split(" ");
				
				if ((user.equals(datos[0])) && (pass.equals(datos[1]))) {
					existeUsuario = true;
					break;
				}
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				//Cierro el archivo cuando salga del Try o cuando hay una Exception
				fileReader.close();	
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return existeUsuario;
	}
	
	
	public static Boolean existeMedico(String matricula) {
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		String linea;
		Boolean existeMedico = false;
		
		try {
			fileReader = new FileReader(new File("file/situacionPacientes.txt"));
			bufferedReader = new BufferedReader(fileReader);
			
			while ((linea = bufferedReader.readLine()) != null) {
				String [] datos = linea.split(" ");
				
				if ((matricula.equals(datos[1]))) {
					existeMedico = true;
					break;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return existeMedico;
	}

}
