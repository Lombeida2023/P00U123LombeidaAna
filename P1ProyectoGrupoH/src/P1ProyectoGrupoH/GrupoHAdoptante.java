package P1ProyectoGrupoH;

import java.util.List;
import java.util.Scanner;

public class GrupoHAdoptante extends GrupoHPlataformaApodcion {
    private String tipoMascota;

    // Constructor
    public GrupoHAdoptante(String nombre, String apellido, String direccion, String correo, int edad, String cedula, String telefono, String tipoMascota) {
        super(nombre, apellido, direccion, correo, edad, cedula, telefono);
        this.tipoMascota = tipoMascota;
    }

    // Getters y Setters
    public String getTipoMascota() {
        return tipoMascota;
    }

    public void setTipoMascota(String tipoMascota) {
        this.tipoMascota = tipoMascota;
    }

    // Método para registrar adoptante
    public static void RegistrarAdoptante(Scanner scanner, List<GrupoHMascota> mascotasDisponibles) {
        int CantidadAdoptantes = 0;
        do {
            System.out.println("INGRESA LA CANTIDAD DE ADOPTANTES A REGISTRAR:");
            CantidadAdoptantes = scanner.nextInt();
            if (CantidadAdoptantes <= 0 || CantidadAdoptantes >= 10) {
                System.out.println("ERROR: DEBE SER ENTRE 1 Y 10.");
            }
        } while (CantidadAdoptantes <= 0 || CantidadAdoptantes >= 10);

        GrupoHAdoptante[] adoptantes = new GrupoHAdoptante[CantidadAdoptantes];
        for (int i = 0; i < CantidadAdoptantes; i++) {
            System.out.println("INGRESA EL NOMBRE DEL ADOPTANTE " + (i + 1) + ":");
            String nombre = scanner.next();
            System.out.println("INGRESA EL APELLIDO DEL ADOPTANTE " + (i + 1) + ":");
            String apellido = scanner.next();
            System.out.println("INGRESA LA DIRECCIÓN DEL ADOPTANTE " + (i + 1) + ":");
            String direccion = scanner.next();
            System.out.println("INGRESA EL CORREO DEL ADOPTANTE " + (i + 1) + ":");
            String correo = scanner.next();
            int edad;
            do {
                System.out.println("INGRESA LA EDAD DEL ADOPTANTE " + (i + 1) + ":");
                edad = scanner.nextInt();
                if (edad <= 0 || edad >= 60) {
                    System.out.println("INGRESA UNA EDAD DENTRO DEL RANGO (1-59):");
                }
                scanner.nextLine();
            } while (edad <= 0 || edad >= 60);

            System.out.println("INGRESE LA CÉDULA DEL ADOPTANTE " + (i + 1) + ":");
            String cedula = scanner.nextLine();
            while (!validarCedula(cedula)) {
                System.out.println("CÉDULA INVÁLIDA, INGRESE NUEVAMENTE:");
                cedula = scanner.nextLine();
            }

            String telefono;
            do {
                System.out.println("INGRESA EL TELÉFONO DEL ADOPTANTE " + (i + 1) + ":");
                telefono = scanner.nextLine();
                if (telefono.length() != 10 || !telefono.matches("\\d+")) {
                    System.out.println("ERROR: EL TELÉFONO DEBE CONTENER EXACTAMENTE 10 DÍGITOS NUMÉRICOS.");
                }
            } while (telefono.length() != 10 || !telefono.matches("\\d+"));

            String tipoMascota;
            boolean mascotaDisponible;
            do {
                System.out.println("INGRESA EL TIPO DE MASCOTA QUE DESEA ADOPTAR " + (i + 1) + ":");
                tipoMascota = scanner.next();
                mascotaDisponible = false;

                for (GrupoHMascota mascota : mascotasDisponibles) {
                    if (mascota.getTipoMascota().equalsIgnoreCase(tipoMascota)) {
                        mascotaDisponible = true;
                        break;
                    }
                }

                if (!mascotaDisponible) {
                    System.out.println("MASCOTA NO DISPONIBLE. POR FAVOR INGRESA UN TIPO DE MASCOTA EXISTENTE.");
                }
            } while (!mascotaDisponible);

            adoptantes[i] = new GrupoHAdoptante(nombre, apellido, direccion, correo, edad, cedula, telefono, tipoMascota);
        }
        System.out.println("========================:");
        System.out.println("ADOPTANTES REGISTRADOS:  ");
        System.out.println("========================:");

        for (int i = 0; i < CantidadAdoptantes; i++) {
            adoptantes[i].mostrarDatos();
            
        }
        System.out.println("=============================================:");
        System.out.println("GUARDAR INFORMACION DEL ADOPTANTE EN CSV:     ");
        System.out.println("=============================================:");
        Archivos.GenerarCsv(adoptantes);
    }

    // Método para validar cédula
    private static boolean validarCedula(String cedula) {
        if (cedula.length() != 10) {
            System.out.println("LA CÉDULA DEBE TENER 10 DÍGITOS.");
            return false;
        }
        for (char c : cedula.toCharArray()) {
            if (!Character.isDigit(c)) {
                System.out.println("LA CÉDULA SOLO DEBE TENER DÍGITOS.");
                return false;
            }
        }
        return true;
    }
/////////////Polimorfismo
    // Método para mostrar los datos del adoptante incluyendo el tipo de mascota
    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("TIPO DE MASCOTA QUE DESEA ADOPTAR: " + getTipoMascota());
    }
    
    public static void adoptarMascota(Scanner scanner, List<GrupoHMascota> mascotasDisponibles) {
        System.out.println("========================:");
        System.out.println("MASCOTAS DISPONIBLES:");
        System.out.println("========================:");

        for (int i = 0; i < mascotasDisponibles.size(); i++) {
            System.out.println((i + 1) + ". " + mascotasDisponibles.get(i).getNombre());
        }

        // Seleccionar una mascota existente
        int mascotaIndex;
        do {
            System.out.println("SELECCIONE EL NÚMERO DE LA MASCOTA QUE DESEA ADOPTAR:");
            while (!scanner.hasNextInt()) {
                System.out.println("ERROR: DEBE INGRESAR UN NÚMERO.");
                scanner.next(); // Consumir la entrada 
            }
            mascotaIndex = scanner.nextInt() - 1;
            scanner.nextLine(); // Limpiar el buffer
            if (mascotaIndex < 0 || mascotaIndex >= mascotasDisponibles.size()) {
                System.out.println("ERROR: SELECCIÓN INVÁLIDA. INTENTE DE NUEVO.");
            }
        } while (mascotaIndex < 0 || mascotaIndex >= mascotasDisponibles.size());

        // Mostrar el formulario de preadopción
        GrupoHPreFormularioAdopcion preFormulario = GrupoHPreFormularioAdopcion.llenarPreFormulario(scanner);

        // Limpiar el buffer después de llenar el formulario de preadopción
        scanner.nextLine();

        System.out.println("¿CONFIRMAR ADOPCIÓN DE " + mascotasDisponibles.get(mascotaIndex).getNombre() + "? (Sí/No):");
        String confirmacion = scanner.nextLine();

        if (confirmacion.equalsIgnoreCase("Sí")) {
            System.out.println("MASCOTA ADOPTADA CORRECTAMENTE.");
            mascotasDisponibles.remove(mascotaIndex);
        } else {
            System.out.println("ADOPCIÓN CANCELADA.");
        }
    }

}
