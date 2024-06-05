package P1ProyectoGrupoH;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GrupoHSeguimiento {

	private String adoptanteNombre;
	private String adoptanteCedula;
	private String mascotaNombre;
	private List<String> reportes;

	public GrupoHSeguimiento(String adoptanteNombre, String adoptanteCedula, String mascotaNombre) {
		this.adoptanteNombre = adoptanteNombre;
		this.adoptanteCedula = adoptanteCedula;
		this.mascotaNombre = mascotaNombre;
		this.reportes = new ArrayList<>();
	}

	public String getAdoptanteNombre() {
		return adoptanteNombre;
	}

	public void setAdoptanteNombre(String adoptanteNombre) {
		this.adoptanteNombre = adoptanteNombre;
	}

	public String getAdoptanteCedula() {
		return adoptanteCedula;
	}

	public void setAdoptanteCedula(String adoptanteCedula) {
		this.adoptanteCedula = adoptanteCedula;
	}

	public String getMascotaNombre() {
		return mascotaNombre;
	}

	public void setMascotaNombre(String mascotaNombre) {
		this.mascotaNombre = mascotaNombre;
	}

	public List<String> getReportes() {
		return reportes;
	}

	public void addReporte(String reporte) {
		this.reportes.add(reporte);
	}


	
	@Override
	public String toString() {
	    return "===========================\n" +
	           "MOSTRAR DATOS DE SEGUIMIENTO:\n" +
	           "===========================\n" +
	           "NOMBRE DE ADOPTANTE : " + getAdoptanteNombre() + "\n" +
	           "CEDULA  : " + getAdoptanteCedula()+ "\n" +
	           "NOMBRE DE LA MASCOTA : " + getMascotaNombre() + "\n" +
	           "REPORTES : " + getReportes() + "\n";
	}
	public static void gestionarSeguimientos(Scanner scanner, List<GrupoHSeguimiento> seguimientos) {
		int opcion;
		do {
			System.out.println("===== GESTIONAR SEGUIMIENTOS =====");
			System.out.println("1. Registrar nuevo seguimiento");
			System.out.println("2. Agregar reporte de seguimiento");
			System.out.println("3. Mostrar seguimientos");
			System.out.println("4. Salir");
			System.out.print("Seleccione una opción: ");
			opcion = scanner.nextInt();
			scanner.nextLine(); // Limpiar el buffer

			switch (opcion) {
			case 1:
				RegistrarSeguimiento( scanner, seguimientos);
				break;
			case 2:
				AgregarReporteSeguimiento(scanner, seguimientos);
				break;
			case 3:
				 MostrarSeguimiento( scanner, seguimientos);
				break;
			case 4:
				System.out.println("Saliendo de gestión de seguimientos.");
				break;
			default:
				System.out.println("Opción no válida. Intente nuevamente.");
			}
		} while (opcion != 4);
	}
	
	public static void RegistrarSeguimiento(Scanner scanner,List<GrupoHSeguimiento> seguimientos) {
		
		System.out.print("NOMBRE DEL ADOPTANTE: ");
		String adoptanteNombre = scanner.nextLine();
		System.out.println("INGRESE SU CEDULA DEL ADOPTANTE :" );
		String adoptanteCedula= scanner.nextLine();
		while (!validarcedula(adoptanteCedula)) {
			System.out.println("CEDULA INVALIDA, INGRESE NUEVAMENTE.");
			adoptanteCedula = scanner.nextLine();
		}
		System.out.print("NOMBRE DE LA MASCOTA: ");
		String mascotaNombre = scanner.nextLine();
		GrupoHSeguimiento seguimiento = new GrupoHSeguimiento(adoptanteNombre, adoptanteCedula, mascotaNombre);
		seguimientos.add(seguimiento);
		System.out.println("SEGIMIENTO REGISTRADO CON EXITO.");
		
	}
	
/////////////////metodo para validar cedula
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
	
	public static void AgregarReporteSeguimiento(Scanner scanner,List<GrupoHSeguimiento> seguimientos) {
		
		System.out.println("SELECIONA UN SEGUMIENTO:");
		for (int i = 0; i < seguimientos.size(); i++) {
			System.out.println((i + 1) + ". " + seguimientos.get(i).getAdoptanteNombre() + " - "
					+ seguimientos.get(i).getMascotaNombre());
		}
		int seguimientoIndex = scanner.nextInt() - 1;
		scanner.nextLine(); // Limpiar el buffer

		if (seguimientoIndex >= 0 && seguimientoIndex < seguimientos.size()) {
			System.out.print("AGREGAR REPORTE AL SEGUIMIENTO: ");
			String reporte = scanner.nextLine();
			seguimientos.get(seguimientoIndex).addReporte(reporte);
			System.out.println("REPORTE AGREGADO AL SEGUIMIENTO.");
		} else {
			System.out.println("SEGUIMIENTO NO VALIDO.");
		}
	}
	
	public static void MostrarSeguimiento(Scanner scanner,List<GrupoHSeguimiento> seguimientos) {
		for (GrupoHSeguimiento s : seguimientos) {
			System.out.println(s);
		}
	}
}
