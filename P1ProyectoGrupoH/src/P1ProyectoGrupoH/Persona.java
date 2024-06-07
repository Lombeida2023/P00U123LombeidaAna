package P1ProyectoGrupoH;

public abstract class Persona {

	protected String nombre;
	protected String apellido;
	protected String direccion;
	protected String correo;
	protected int edad;
	protected String cedula;
	protected String telefono;

	public Persona(String nombre, String apellido, String direccion, String correo, int edad, String cedula,
			String telefono) {

		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.correo = correo;
		this.edad = edad;
		this.cedula = cedula;
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getCorreo() {
		return correo;
	}

	public int getEdad() {
		return edad;
	}

	public String getCedula() {
		return cedula;
	}

	public String getTelefono() {
		return telefono;
	}

}
