package P1ProyectoGrupoH;

import java.util.Scanner;

public class GrupoHPreFormularioAdopcion {

	///////////Encapsulamiento
	private String nombre;
    private String direccion;
    private String telefono;
    private String ocupacion;
    private boolean experienciaMascotas;
    private boolean hogarPropio;
    
    //////Constructor
	public GrupoHPreFormularioAdopcion(String nombre, String direccion, String telefono, String ocupacion,
			boolean experienciaMascotas, boolean hogarPropio) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.ocupacion = ocupacion;
		this.experienciaMascotas = experienciaMascotas;
		this.hogarPropio = hogarPropio;
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
	public String getOcupacion() {
		return ocupacion;
	}
	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}
	public boolean isExperienciaMascotas() {
		return experienciaMascotas;
	}
	public void setExperienciaMascotas(boolean experienciaMascotas) {
		this.experienciaMascotas = experienciaMascotas;
	}
	public boolean isHogarPropio() {
		return hogarPropio;
	}
	public void setHogarPropio(boolean hogarPropio) {
		this.hogarPropio = hogarPropio;
	}

	
	
	
	public static GrupoHPreFormularioAdopcion llenarPreFormulario(Scanner scanner) {
        System.out.println("====================================");
        System.out.println("PRE-FORMULARIO DE ADOPCIÓN :        ");
        System.out.println("====================================");

        System.out.println("INGRESA TU NOMBRE:");
        String nombre = scanner.nextLine();
        System.out.println("INGRESA TU DIRECCIÓN:");
        String direccion = scanner.nextLine();
        String telefono;
        do {
            System.out.println("INGRESA EL TELÉFONO DEL USUARIO:");
            telefono = scanner.nextLine();
            if (telefono.length() != 10 || !telefono.matches("\\d+")) {
                System.out.println("ERROR: EL TELÉFONO DEBE CONTENER EXACTAMENTE 10 DÍGITOS NUMÉRICOS.");
            }
        } while (telefono.length() != 10 || !telefono.matches("\\d+"));

        System.out.println("INGRESA TU OCUPACIÓN:");
        String ocupacion = scanner.next();
        
        System.out.println("¿TIENES EXPERIENCIA CUIDANDO MASCOTAS? (true/false):");
        boolean experienciaMascotas = scanner.nextBoolean();
        
        System.out.println("¿POSEES HOGAR PROPIO? (true/false):");
        boolean hogarPropio = scanner.nextBoolean();

        GrupoHPreFormularioAdopcion preFormulario = new GrupoHPreFormularioAdopcion(nombre, direccion, telefono, ocupacion, experienciaMascotas, hogarPropio);
        preFormulario.mostrarPreFormulario();
        return preFormulario;
    }

    public void mostrarPreFormulario() {
        System.out.println("===================================:");
        System.out.println("INFORMACIÓN DEL PRE-FORMULARIO     :");
        System.out.println("===================================:");
        System.out.println("NOMBRE: " + getNombre());
        System.out.println("DIRECCIÓN: " + getDireccion());
        System.out.println("TELÉFONO: " + getDireccion());
        System.out.println("OCUPACIÓN: " + getOcupacion());
        System.out.println("EXPERIENCIA CUIDANDO MASCOTAS: " + isExperienciaMascotas());
        System.out.println("HOGAR PROPIO: " + isHogarPropio());
    }
    
}
