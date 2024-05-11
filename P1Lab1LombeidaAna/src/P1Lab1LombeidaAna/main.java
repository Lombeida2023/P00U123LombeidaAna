package P1Lab1LombeidaAna;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class main {

	 // Variables globales para almacenar datos de las opciones 1 y 2
    private static int cantidad;
    private static double precio;
    private static double total;
    private static double iva;
    private static double totalIva;
    private static String[] nombres;
    private static String[] nombresAscendente;
    private static String[] nombresDescendente;
    private static MedicoVeterinario[] veterinarios;

     
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  Scanner scanner = new Scanner(System.in);
	        int menuOp = 0;

	        do {
	            System.out.println("==============================================");
	            System.out.println("MENU DE OPCIONES                              ");
	            System.out.println("1.  REGISTRAR MEDICOS VETERINARIOS            ");
	            System.out.println("2. INGRESAR ARREGLOS DE NOMBRES Y ORDENAR     ");
	            System.out.println("3. INGRESAR DATOS Y APLICAR FORMULAS DEL IVA                                ");
	            System.out.println("4. GUARDAR INFORMACION EN UN ARCHIVO          ");
	            System.out.println("5. SALIR                                      ");
	            System.out.println("INGRESA UNA OPCION                            ");
	            System.out.println("==============================================");
	            menuOp = scanner.nextInt();

	            switch (menuOp) {
	                case 1:
	                	RegristroMedicos();
	                	//DatosAnimales();
	                	//programarCitasMedicas();
	                    break;

	                case 2:
	                	ArreglosNombres();
	                    break;
	                case 3:
	                	Iva();
	                    break;

	                case 4:
	                	 System.out.println("3. GUARDAR INFORMACION EN UN ARCHIVO TXT");
		                    guardarInformacionTXT();
	                    break;

	                case 5:
	                	  System.out.println("5. MUCHAS GRACIAS, QUE TENGA UN BUEN DIA ");
	                	break;
	                default:
	                    System.out.println("OPCION INGRESADA ES INCORRECTA, VUELVA A INGRESAR UNA DENTRO DEL RANGO");
	            }

	        } while (menuOp != 4);

	    }
		
	
    // Métodos de ordenamiento burbuja en orden ascendente y descendente
    public static void ordenarNombresAscendente(String[] nombres) {
        int cantidad = nombres.length;
        for (int i = 0; i < cantidad - 1; i++) {
            for (int j = 0; j < cantidad - i - 1; j++) {
                if (nombres[j].compareTo(nombres[j + 1]) > 0) {
                    // Intercambiar nombres[j] y nombres[j + 1]
                    String temp = nombres[j];
                    nombres[j] = nombres[j + 1];
                    nombres[j + 1] = temp;
                }
            }
        }
    }

    public static void ordenarNombresDescendente(String[] nombres) {
        int cantidad = nombres.length;
        for (int i = 0; i < cantidad - 1; i++) {
            for (int j = 0; j < cantidad - i - 1; j++) {
                if (nombres[j].compareTo(nombres[j + 1]) < 0) {
                    // Intercambiar nombres[j] y nombres[j + 1]
                    String temp = nombres[j];
                    nombres[j] = nombres[j + 1];
                    nombres[j + 1] = temp;
                }
            }
        }
    }
    
    
    
    
////////METODO PARA EL ARREGLO DE NOMBRES 
    
public static void ArreglosNombres(){
        Scanner scanner  = new Scanner(System.in);

 do {
                 System.out.println("INGRESA LA CANTIDAD DE NOMBRES A INGRESAR");
  	         cantidad = scanner.nextInt();
  	         scanner.nextLine(); // Limpiar el buffer de entrada
                     if(cantidad<=0 || cantidad >=10 ) {
                     }	
                 }while(cantidad<=0 || cantidad >=10 );
                  
                    // Crear el arreglo de nombres
                    nombres = new String[cantidad];

                    // Llenar el arreglo de nombres
                    for (int i = 0; i < cantidad; i++) {
                        System.out.println("INGRESE EL NOMBRE " + (i + 1) + ": ");
                        nombres[i] = scanner.nextLine();
                    }

                    // Ordenar los nombres utilizando el método de burbuja de forma ascendente
                    ordenarNombresAscendente(nombres);
                    nombresAscendente = Arrays.copyOf(nombres, nombres.length);

                    // Mostrar los nombres ordenados de forma ascendente
                    System.out.println("\nNombres ordenados en forma ascendente:");
                    for (String nombre : nombresAscendente) {
                        System.out.println(nombre);
                    }

                    // Ordenar los nombres utilizando el método de burbuja de forma descendente
                    ordenarNombresDescendente(nombres);
                    nombresDescendente = Arrays.copyOf(nombres, nombres.length);

                    // Mostrar los nombres ordenados de forma descendente
                    System.out.println("\nNombres ordenados en forma descendente:");
                    for (String nombre : nombresDescendente) {
                        System.out.println(nombre);
                    }
}


public static void RegristroMedicos() {
    Scanner scanner = new Scanner(System.in);
    int CantMedicos;

    // Solicita la cantidad de médicos veterinarios
    do {
        System.out.println("INGRESA LA CANTIDAD DE MEDICOS VETERINARIOS A INGRESAR (máximo 10):");
        CantMedicos = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer de entrada
        if (CantMedicos <= 0 || CantMedicos > 10) {
            System.out.println("ERROR: LA CANTIDAD DEBE DE ESTAR ENTRE 1 Y 10. INTENTA NUEVAMENTE.");
        }
    } while (CantMedicos <= 0 || CantMedicos > 10);

    // Inicializa el arreglo de médicos veterinarios con la cantidad especificada
    veterinarios = new MedicoVeterinario[CantMedicos];

    // Pide la información de cada médico veterinario
    for (int i = 0; i < CantMedicos; i++) {
        System.out.println("=========================================================");
        System.out.println("\nINGRESE LOS DATOS DEL MEDICO VETERINARIO " + (i + 1) + ":");
        System.out.println("=========================================================");

        System.out.print("INGRESE EL NOMBRE: ");
        String nombre = scanner.next();

        System.out.print("INGRESE EL APELLIDO: ");
        String apellido = scanner.next();

        // Pide la edad
        int edad;
        do {
            System.out.print("INGRESE LA EDAD (debe ser mayor a 18 y menor a 50 años): ");
            edad = scanner.nextInt();
            scanner.nextLine(); // Limpia el buffer de entrada
            if (edad <= 18 || edad >= 50) {
                System.out.println("ERROR: La edad debe estar entre 19 y 49 años.");
            }
        } while (edad <= 18 || edad >= 50);

        // Pide la especialidad
        System.out.print("INGRESE LA ESPECIALIDAD: ");
        String especialidad = scanner.next();

        // Pide el sexo
        String sexo;
        do {
            System.out.print("INGRESE EL SEXO (M para masculino, F para femenino): ");
            sexo = scanner.next().toUpperCase();
            scanner.nextLine(); // Limpia el buffer
            if (!sexo.equals("M") && !sexo.equals("F")) {
                System.out.println("ERROR: INGRESE 'M' PARA MASCULINO O 'F' PARA FEMENINO. INTENTA NUEVAMENTE.");
            }
        } while (!sexo.equals("M") && !sexo.equals("F"));

        // Crea un objeto MedicoVeterinario con los datos ingresados
        veterinarios[i] = new MedicoVeterinario(nombre, apellido, edad, especialidad, sexo);
    }

    // Muestra los datos de los médicos veterinarios
    System.out.println("\n=============================================:");
    System.out.println("\nDATOS DE LOS MEDICOS REGISTRADOS             :");
    System.out.println("\n=============================================:");
    for (int i = 0; i < CantMedicos; i++) {
        System.out.println("\nMEDICOS VETERINARIOS " + (i + 1) + ":");
        veterinarios[i].mostrarDatos();
    }
}

public static void Iva() {
	
	Scanner scanner = new Scanner(System.in);
	 System.out.println("1. INGRESAR DATOS Y APLICAR FORMULAS DEL IVA");
     // Validar cantidad
     do {
         System.out.println("INGRESE UNA CANTIDAD (entre 1 y 100):");
         cantidad = scanner.nextInt();
         if (cantidad <= 0 || cantidad > 100) {
             System.out.println("CANTIDAD NO VALIDA. Debe estar entre 1 y 100.");
         }
     } while (cantidad <= 0 || cantidad > 100);

     // Validar precio
     do {
         System.out.println("INGRESE EL PRECIO:");
         precio = scanner.nextDouble();
         if (precio <= 0 || precio > 100) {
             System.out.println("PRECIO NO VALIDO");
         }
     } while (precio <= 0 || precio > 100);

     // Calcular total, IVA y total con IVA
     total = cantidad * precio;
     iva = total * 0.15;
     totalIva = total + iva;

     System.out.println("Total sin IVA: " + total);
     System.out.println("IVA (15%): " + iva);
     System.out.println("Total con IVA: " + totalIva);

	
	
	
}
 
 public static void guardarInformacionTXT() {
	    try (FileWriter writer = new FileWriter("informacion.txt")) {
	        // Guardar nombres ordenados de la opción 2
	        writer.write("Nombres en orden ascendente:\n");
	        for (String nombre : nombresAscendente) {
	            writer.write(nombre + "\n");
	        }

	        writer.write("\nNombres en orden descendente:\n");
	        for (String nombre : nombresDescendente) {
	            writer.write(nombre + "\n");
	        }

	        // Guardar información de los médicos veterinarios de la opción 1
	        if (veterinarios != null) {
	            writer.write("\nMédicos veterinarios:\n");
	            for (MedicoVeterinario medico : veterinarios) {
	                writer.write(String.format("Nombre: %s, Apellido: %s, Edad: %d, Especialidad: %s, Sexo: %s\n",
	                        medico.getNombre(), medico.getApellido(), medico.getEdad(),
	                        medico.getEspecialidad(), medico.getSexo()));
	            }
	        } else {
	            writer.write("\nNo hay médicos veterinarios registrados.\n");
	        }

	        // Guardar información sobre el IVA de la opción 3
	        writer.write("\nInformación sobre el IVA:\n");
	        writer.write(String.format("Cantidad: %d\n", cantidad));
	        writer.write(String.format("Precio: %.2f\n", precio));
	        writer.write(String.format("Total sin IVA: %.2f\n", total));
	        writer.write(String.format("IVA (15%%): %.2f\n", iva));
	        writer.write(String.format("Total con IVA: %.2f\n", totalIva));

	        System.out.println("La información se ha guardado correctamente en 'informacion.txt'.");
	    } catch (IOException e) {
	        System.out.println("Error al guardar la información: " + e.getMessage());
	    }
	}

}
 



class MedicoVeterinario {
    // Atributos de la clase MedicoVeterinario
    private String nombre;
    private String apellido;
    private int edad;
    private String especialidad;
    private String sexo;

    // Constructor para inicializar un objeto MedicoVeterinario
    public MedicoVeterinario(String nombre, String apellido, int edad, String especialidad, String sexo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.especialidad = especialidad;
        this.sexo = sexo;
    }
    
//////////METODO PARA MOSTRAR LOS DATOS DE LOS MEDICOS VETERINARIOS
    public void mostrarDatos() {
        System.out.println("============================:");
        System.out.println("DATOS DEL MEDICO VETERINARIO:");
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Edad: " + edad);
        System.out.println("Especialidad: " + especialidad);
        System.out.println("Sexo: " + sexo);
        System.out.println("============================:");

    }
    
    ///////////METODOS PARA ACCEDER A LOS ATRIBUTOS
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public String getSexo() {
        return sexo;
    }
}





	

