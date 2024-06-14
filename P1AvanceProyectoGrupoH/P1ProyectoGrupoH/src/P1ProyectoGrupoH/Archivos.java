package P1ProyectoGrupoH;
////////////Librerias
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Archivos {

	
	
	//////////Metodo para generar la escritura y lectura de datos guardando los datos del arreglo en el archivo csv
	static void GenerarCsv(GrupoHAdoptante[]adoptantes) {
		
		try(FileWriter archivo= new FileWriter("Adoptantes.csv",true);
				PrintWriter escrito= new PrintWriter(archivo)){
			for(GrupoHAdoptante a: adoptantes) {
			escrito.println(a.getNombre()+","+a.getApellido()+","+a.getDirrecion()+","+a.getCorreo()+","
			+a.getEdad()+","+a.getCedula()+","+a.getTelefono()+","+a.getTipoMascota());
				
			}
			System.out.println("ARCHIVO CSV GENERADO CON EXITO");
		}catch(IOException e) {
			System.out.println("ERROR AL GENERAR ARCHIVO CSV " +e.getMessage());

			
		}
	}
	
	
	//////////Metodo para generar la escritura y lectura de datos guardando los datos del arreglo en el archivo Json 

	static void GenerarJson(GrupoHRefugio[] refugios) {
		try(FileWriter archivo = new FileWriter("ResgistrarRefugios.json",true);
				PrintWriter escrito= new  PrintWriter(archivo)){
			for (GrupoHRefugio r:  refugios) {
		escrito.println("{");
		escrito.println("  \"Nombre\": \"" + r.getNombre() + "\",");
		escrito.println("  \"Apellido\": \"" + r.getDireccion() + "\",");
		escrito.println("  \"Direccion\": \"" + r.getTelefono() + "\",");
		escrito.println("}");
		
			}
			System.out.println("ARCHIVO JSON GENERADO CON EXITO");

		}catch(IOException e) {
			
			System.out.println("ERROR AL GENERAR ARCHIVO JSON"+ e.getMessage());
	
		}
		
		
		
	}
}
