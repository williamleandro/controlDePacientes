package objetos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Medico {
	private String codigo;
	private String nombre;
	private String matricula;
	private String especialidad;
	
	public Medico(String codigo, String nombre, String matricula, String especialidad) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.matricula = matricula;
		this.especialidad = especialidad;
	}
	
	public Boolean esDatosCompletos() {
		return !this.codigo.isEmpty() || !this.nombre.isEmpty() || !this.matricula.isEmpty() || !this.especialidad.isEmpty();
	}
	
	public void escribirMedico() {
		FileWriter archivo = null;
        PrintWriter printWriter = null;
		
        try {
			archivo = new FileWriter("file/medicos.txt", true);
			printWriter = new PrintWriter(archivo);
			
			printWriter.print(this.codigo+" "+this.nombre+" "+this.matricula+" "+this.especialidad+System.lineSeparator());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				archivo.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	

}
