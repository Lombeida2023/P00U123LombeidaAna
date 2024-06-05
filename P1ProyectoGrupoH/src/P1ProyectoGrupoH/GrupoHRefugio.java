package P1ProyectoGrupoH;////Paquete
//Librerias
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GrupoHRefugio {
///Atributos
	private String nombre;
	private String direccion;
	private String telefono;
	private List<GrupoHMascota> mascotas;
///constructor
	public GrupoHRefugio(String nombre, String direccion, String telefono) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.mascotas = new ArrayList<>();
	}
///Metodos Getters y Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<GrupoHMascota> getMascotas() {
		return mascotas;
	}

	public void addMascota(GrupoHMascota mascota) {
		this.mascotas.add(mascota);
	}
///Polimorfismo
	 @Override
	    public String toString() {
	        return "===========================\n" +
	               "MOSTRAR DATOS DE LOS REFUGIOS:\n" +
	               "===========================\n" +
	               "NOMBRE : " + getNombre() + "\n" +
	               "APELLIDO : " + getDireccion() + "\n" +
	               "TELEFONO : " + getTelefono()+ "\n";
	    }
//////////Metodo para el menu de gestion de Refugios
	public static void gestionarRefugios(Scanner scanner, List<GrupoHRefugio> refugios,
			List<GrupoHMascota> mascotasDisponibles) {
		int opcion;
		do {
			System.out.println("===== GESTIONAR REFUGIOS =====");
			System.out.println("1. REGISTRAR REFUGIO");
			System.out.println("2. AGREGAR MASCOTA AL REFUGIO");
			System.out.println("3. SALIR");
			System.out.print("SELECCIONE UNA OPCION: ");
			opcion = scanner.nextInt();
			scanner.nextLine(); // Limpiar el buffer

			switch (opcion) {
			case 1:
				RegistrarRefugio(scanner);
				break;
			case 2:
				RegistrarMascota( scanner, refugios, mascotasDisponibles);
				break;
			
			case 3:
				System.out.println("================================");
				System.out.println("SALIENDO DE GESTION DE REFUGIOS.");
				System.out.println("================================");

				break;
			default:
				   System.out.println("============================================================================");
                   System.out.println("OPCION INGRESA ES INCORRECTA, VUELVA A INGRESAR UNA DENTRO DEL RANGO(1-4)   ");
                   System.out.println("============================================================================");
			}
		} while (opcion != 3);
	}
	
	
	public static void RegistrarRefugio(Scanner scanner) {
		
		 int cantidadRefugios = 0;
	        do {
	            System.out.println("INGRESA LA CANTIDAD DE REFUGIOS A REGISTRAR:");
	            cantidadRefugios = scanner.nextInt();
	            if (cantidadRefugios <= 0 || cantidadRefugios >= 10) {
	                System.out.println("ERROR: DEBE SER ENTRE 1 Y 10.");
	            }
	        } while (cantidadRefugios <= 0 || cantidadRefugios >= 10);

	        // Crear el arreglo de refugios
	        GrupoHRefugio[] refugios = new GrupoHRefugio[cantidadRefugios];
	        scanner.nextLine(); // Limpiar el buffer del scanner

	        // Registro de cada refugio
	        for (int i = 0; i < cantidadRefugios; i++) {
	            System.out.println("=============================================:");
	            System.out.println("INGRESA LOS DATOS DEL REFUGIO " + (i + 1) + ":");
	            System.out.println("=============================================:");

	            System.out.print("NOMBRE DEL REFUGIO: ");
	            String nombre = scanner.nextLine();

	            System.out.print("DIRECCION DEL REFUGIO: ");
	            String direccion = scanner.nextLine();

	            String telefono;
	            do {
	                System.out.print("INGRESA EL TELÉFONO DEL REFUGIO: ");
	                telefono = scanner.nextLine();
	                if (telefono.length() != 10 || !telefono.matches("\\d+")) {
	                    System.out.println("ERROR: EL TELÉFONO DEBE CONTENER EXACTAMENTE 10 DÍGITOS NUMÉRICOS.");
	                }
	            } while (telefono.length() != 10 || !telefono.matches("\\d+"));

	            // Crear y agregar el refugio al arreglo
	            refugios[i] = new GrupoHRefugio(nombre, direccion, telefono);
	            System.out.println("REFUGIO REGISTRADO CON EXITO.");
	        }
	     // Mostrar los refugios registrados
	        System.out.println("========================:");
	        System.out.println("REFUGIOS REGISTRADOS:  ");
	        System.out.println("========================:");
	        for (int i = 0; i < cantidadRefugios; i++) {
	            System.out.println(refugios[i].toString());
	        }
	    }
	
	public static void RegistrarMascota(Scanner scanner, List<GrupoHRefugio> refugios, List<GrupoHMascota> mascotasDisponibles) {
	    // Solicitar la cantidad de mascotas a agregar
	    int cantidadMascotas;
	    do {
	        System.out.println("INGRESE LA CANTIDAD DE MASCOTAS A REGISTRAR:");
	        cantidadMascotas = scanner.nextInt();
	        scanner.nextLine(); // Limpiar el buffer
	        if (cantidadMascotas <= 0 || cantidadMascotas >= 10) {
	            System.out.println("ERROR: DEBE SER ENTRE 1 Y 10.");
	        }
	    } while (cantidadMascotas <= 0 || cantidadMascotas >= 10);

	    // Registro de cada mascota
	    for (int i = 0; i < cantidadMascotas; i++) {
	        System.out.println("INGRESE LOS DATOS DE LA MASCOTA " + (i + 1) + ":");

	        System.out.print("TIPO DE MASCOTA: ");
	        String tipoMascota = scanner.nextLine();
	        System.out.print("NOMBRE DE LA MASCOTA: ");
	        String nombreMascota = scanner.nextLine();
	        System.out.print("GÉNERO DE LA MASCOTA: ");
	        String genero = scanner.nextLine();
	        System.out.print("RAZA DE LA MASCOTA: ");
	        String raza = scanner.nextLine();
	        System.out.print("NÚMERO DE VACUNAS: ");
	        int nVacunas = scanner.nextInt();
	        scanner.nextLine(); // Limpiar el buffer

	        // Agregar la mascota a la lista de mascotas disponibles
	        GrupoHMascota nuevaMascota = new GrupoHMascota(tipoMascota, nombreMascota, genero, raza, nVacunas);
	        mascotasDisponibles.add(nuevaMascota);

	        System.out.println("Mascota agregada a la lista de mascotas disponibles.");
	    }

	    System.out.println("MASCOTAS AGREGADAS AL REFUGIO.");
	}

	
	
	}

    
		
		
	
	

