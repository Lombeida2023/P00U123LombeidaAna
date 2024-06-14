package P1ProyectoGrupoH;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P1ProyectoGrupoH {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ///////////Array List
        List<GrupoHMascota> mascotasDisponibles = new ArrayList<>();
        List<GrupoHRefugio> refugios = new ArrayList<>();
        List<GrupoHSeguimiento> seguimientos = new ArrayList<>();
        System.out.println("======================================================================");
        System.out.println("LISTA  ESTATICA DISPOBLE DE LOS ANIMALES EN ADOPCION                  ");
        System.out.println("======================================================================");
        mascotasDisponibles.add(new GrupoHMascota("Perro", "Firulais", "Macho", "Labrador", 5));
        mascotasDisponibles.add(new GrupoHMascota("Gato", "Misu", "Hembra", "Siames", 3));
        mascotasDisponibles.add(new GrupoHMascota("Conejo", "Bunny", "Macho", "Angora", 2));
        mascotasDisponibles.add(new GrupoHMascota("Pájaro", "Piolín", "Macho", "Canario", 1));
        mascotasDisponibles.add(new GrupoHMascota("Hamster", "Ratatouille", "Hembra", "Roborovski", 1));
        mascotasDisponibles.add(new GrupoHMascota("Tortuga", "Flash", "Hembra", "Mediterránea", 6));
        mascotasDisponibles.add(new GrupoHMascota("Pez", "Nemo", "Macho", "Pez Payaso", 1));
        mascotasDisponibles.add(new GrupoHMascota("Loro", "Coco", "Macho", "Amazónico", 3));
        mascotasDisponibles.add(new GrupoHMascota("Iguana", "Spike", "Macho", "Iguana Verde", 4));
        mascotasDisponibles.add(new GrupoHMascota("Caballo", "Spirit", "Macho", "Pura Raza Española", 7));
        mascotasDisponibles.add(new GrupoHMascota("Hurón", "Slinky", "Hembra", "Hurón Doméstico", 2));
        mascotasDisponibles.add(new GrupoHMascota("Cuyo", "Milo", "Macho", "Cuyo Abisinio", 1));
        mascotasDisponibles.add(new GrupoHMascota("Serpiente", "Nagini", "Hembra", "Pitón Bola", 3));
;

        Menu(scanner, mascotasDisponibles, refugios, seguimientos);
    }

    public static void Caratula() {
        System.out.println("===========================================");
        System.out.println("UNIVERSIDAD DE LAS FUERZAS ARMADAS ESPE-SS ");
        System.out.println("PROGRAMACION ORIENTADA A OBJETOS");
        System.out.println("PLATAFORMA DE ADOPCION PARA GATOS Y PERROS ");
        System.out.println("LOMBEIDA ANA");
        System.out.println("NOELIA MENDOZA");
        System.out.println("==========================================");
    }

    public static void Menu(Scanner scanner, List<GrupoHMascota> mascotasDisponibles, List<GrupoHRefugio> refugios, List<GrupoHSeguimiento> seguimientos) {
        int menuOp = 0;
        do {
            Caratula();
            System.out.println("=========================================");
            System.out.println("            MENU DE OPCIONES             ");
            System.out.println("1.INGRESO DE DATOS PLATAFORMA ADOPCION   ");
            System.out.println("2.REGISTRAR AL ADOPTANTE");
            System.out.println("3.MOSTRAR MASCOTAS DISPONIBLES");
            System.out.println("4.GESTIONAR REFUGIOS");
            System.out.println("5.GESTIONAR SEGUIMIENTOS");
			System.out.println("6. ADOPTAR MASCOTA");
            System.out.println("7.SALIR");
            System.out.println("INGRESA UNA OPCION");
            menuOp = scanner.nextInt();
            switch (menuOp) {
                case 1:
                    System.out.println("=========================================");
                    GrupoHPlataformaApodcion.RegistrarDatosSujeto(scanner);
                    System.out.println("=========================================");
                    break;
                case 2:
                    System.out.println("=========================================");
                    GrupoHAdoptante.RegistrarAdoptante(scanner, mascotasDisponibles);
                    System.out.println("=========================================");
                    break;
                case 3:
                    System.out.println("=========================================");
                    mostrarMascotasDisponibles(mascotasDisponibles);
                    System.out.println("=========================================");
                    break;
                case 4:
                    System.out.println("=========================================");
                    GrupoHRefugio.gestionarRefugios(scanner, refugios, mascotasDisponibles);
                    System.out.println("=========================================");
                    break;
                case 5:
                    System.out.println("=========================================");
                    GrupoHSeguimiento.gestionarSeguimientos(scanner, seguimientos);
                    System.out.println("=========================================");
                    break;
                case 6:
                    System.out.println("=========================================");
                    GrupoHAdoptante.adoptarMascota(scanner, mascotasDisponibles);
                    System.out.println("=========================================");
                    break;
                case 7:
                    System.out.println("=========================================");
                    System.out.println("MUCHAS GRACIAS, QUE TENGA BUEN DIA       ");
                    System.out.println("=========================================");
                    break;
                default:
                    System.out.println("============================================================================");
                    System.out.println("OPCION INGRESA ES INCORRECTA, VUELVA A INGRESAR UNA DENTRO DEL RANGO(1-6)   ");
                    System.out.println("============================================================================");
            }
        } while (menuOp != 7);
    }

    public static void mostrarMascotasDisponibles(List<GrupoHMascota> mascotasDisponibles) {
        System.out.println("MASCOTAS DISPONIBLES PARA ADOPCIÓN:");
        for (GrupoHMascota mascota : mascotasDisponibles) {
            System.out.println(mascota);
        }
    }
}
