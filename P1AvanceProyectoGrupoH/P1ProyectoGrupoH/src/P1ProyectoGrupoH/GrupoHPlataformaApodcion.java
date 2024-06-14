package P1ProyectoGrupoH;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GrupoHPlataformaApodcion {

	private String Nombre;///////// ATRIBUTOS
	private String Apellido;
	private String Dirrecion;
	private String Correo;
	private int Edad;
	private String Cedula;
	private String telefono;

	////////// CONSTRUCTOR
	public GrupoHPlataformaApodcion(String nombre, String apellido, String dirrecion, String correo, int edad,
			String cedula, String telefono) {
		Nombre = nombre;
		Apellido = apellido;
		Dirrecion = dirrecion;
		Correo = correo;
		Edad = edad;
		Cedula = cedula;
		this.telefono = telefono;
	}

	////////// METODOS GET Y SET
	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public String getDirrecion() {
		return Dirrecion;
	}

	public void setDirrecion(String dirrecion) {
		Dirrecion = dirrecion;
	}

	public String getCorreo() {
		return Correo;
	}

	public void setCorreo(String correo) {
		Correo = correo;
	}

	public int getEdad() {
		return Edad;
	}

	public void setEdad(int edad) {
		Edad = edad;
	}

	public String getCedula() {
		return Cedula;
	}

	public void setCedula(String cedula) {
		Cedula = cedula;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	///// METODO PARA PODER REGRISTARSE
	public static void RegistrarDatosSujeto(Scanner scanner) {

		int CantidadUsuarios = 0;
		do {
			System.out.println("INGRESA LA CANTIDAD DE USUARIOS A REGISTRAR");
			CantidadUsuarios = scanner.nextInt();
			if (CantidadUsuarios <= 0 || CantidadUsuarios >= 10) {
				System.out.println("ERROR DEBE SER ENTRE 1 Y 10");
			}
		} while (CantidadUsuarios <= 0 || CantidadUsuarios >= 10);

		GrupoHPlataformaApodcion[] usuarios = new GrupoHPlataformaApodcion[CantidadUsuarios];
		for (int i = 0; i < CantidadUsuarios; i++) {
			System.out.println("INGRESA EL NOMBRE DEL USUARIO  :" + (i + 1) + " :");
			String nombre = scanner.next();
			System.out.println("INGRESA EL APELLIDO" + (i + 1) + " :");
			String apellido = scanner.next();
			System.out.println("INGRESA LA DIRRECCION" + (i + 1) + " :");
			String dirreccion = scanner.next();
			System.out.println("INGRESA EL CORREO" + (i + 1) + " :");
			String correo = scanner.next();
			int edad;
			do {
				System.out.println("INGRESA LA EDAD DEL USUARIO  :" + (i + 1) + " :");
				edad = scanner.nextInt();
				if (edad <= 0 || edad >= 60) {
					System.out.println("INGRESA LA EDAD DENTRO DEL RANGO :");
				}
				scanner.nextLine();
			} while (edad <= 0 || edad >= 60);

			System.out.println("INGRESE SU CEDULA DEL USUARIO :" + (i + 1) + " :");
			String cedula = scanner.nextLine();
			while (!validarcedula(cedula)) {
				System.out.println("CEDULA INVALIDA, INGRESE NUEVAMENTE.");
				cedula = scanner.nextLine();
			}

			String telefono;
			do {
				System.out.println("INGRESA EL TELEFONO DEL USUARIO :" + (i + 1) + " :");
				telefono = scanner.nextLine();
				if (telefono.length() != 10 || !telefono.matches("\\d+")) {
					System.out.println("ERROR: EL TELÉFONO DEBE CONTENER EXACTAMENTE 10 DÍGITOS NUMÉRICOS.");
				}
			} while (telefono.length() != 10 || !telefono.matches("\\d+"));

			usuarios[i] = new GrupoHPlataformaApodcion(nombre, apellido, dirreccion, correo, edad, cedula, telefono);

		}
		System.out.println("========================:");
		System.out.println("USUARIOS REGISTRADOS:    ");
		System.out.println("========================:");

		for (int i = 0; i < CantidadUsuarios; i++) {
			usuarios[i].mostrarDatos();
		}

	}

//////////////////metodo para validar cedula
	private static boolean validarcedula(String cedula) {
		if (cedula.length() != 10) {
			System.out.println("LA CEDULA DEBE DE TENER 10 DIGITOS.");
			return false;
		}
		for (char c : cedula.toCharArray()) {
			if (!Character.isDigit(c)) {
				System.out.println("LA CEDULA SOLO DEBE TENER DIGITOS POSITIVOS.");
				return false;
			}
		}
		return true;
	}

	public void mostrarDatos() {
		System.out.println("===========================");
		System.out.println("MOSTRAR DATOS DEL USUARIO: ");
		System.out.println("===========================");
		System.out.println("NOMBRE : " + getNombre());
		System.out.println("APELLIDO : " + getApellido());
		System.out.println("DIRECCION : " + getDirrecion());
		System.out.println("CORREO : " + getCorreo());
		System.out.println("EDAD : " + getEdad());
		System.out.println("CEDULA : " + getCedula());
		System.out.println("TELEFONO : " + getTelefono());
	}

	
	
	
}
