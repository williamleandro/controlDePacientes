package objetos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

public class Paciente {
	private String codigo;
	private String nombre;
	private String dni;
	private String telefono;
	private String tipoSangre;
	private Calendar fechaIngreso;
	private String calle;
	private String nroCalle;
	private String dia;
	private String mes;
	private String anio;
	
	public Paciente(String codigo, String nombre, String dni, String telefono, String tipoSangre, Calendar fechaIngreso,
			String calle, String nroCalle) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.dni = dni;
		this.telefono = telefono;
		this.tipoSangre = tipoSangre;
		this.fechaIngreso = fechaIngreso;
		this.calle = calle;
		this.nroCalle = nroCalle;
	}

	public Boolean validaCampos() {
		dia = Integer.toString(this.fechaIngreso.get(java.util.Calendar.DATE));
		mes = Integer.toString(this.fechaIngreso.get(java.util.Calendar.MONTH)+1);
		anio = Integer.toString(this.fechaIngreso.get(java.util.Calendar.YEAR));
		
		return !this.codigo.isEmpty() || !this.nombre.isEmpty() || 
				!this.dni.isEmpty() || !this.telefono.isEmpty() || !this.tipoSangre.isEmpty() || 
				!this.calle.isEmpty() || !this.nroCalle.isEmpty() || !dia.isEmpty() || !mes.isEmpty() || !anio.isEmpty();
	}
	
	public void escribirPaciente() {
		FileWriter archivo = null;
        PrintWriter printWriter = null;
		
        try {
			archivo = new FileWriter("file/pacientes.txt", true);
			printWriter = new PrintWriter(archivo);
			
			printWriter.print(this.codigo+" "+this.nombre+" "+this.dni+" "+this.telefono+" "+dia+"-"+mes+"-"+anio+" "+this.tipoSangre+" "+this.calle+" "+this.nroCalle+System.lineSeparator());
			
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
