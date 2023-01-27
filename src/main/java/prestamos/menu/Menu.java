package prestamos.menu;

import java.util.Scanner;

import prestamos.dto.AlumnosDTO;
import prestamos.dto.DTOaDAO;
import prestamos.dto.PortatilesDTO;

public class Menu {

	//Método que muestra el menu y pregunta por la opción que quiera escoger
		public int mostrarMenu(Scanner scan) {
			
			int opcion;
			System.out.println("-----------------");
			System.out.println("##### MENU ######");
			System.out.println("-----------------");
			System.out.println("1. Matrícula de alumno.");
			System.out.println("2. Baja de un alumno.");
			System.out.println("3. Alta de portátil.");
			System.out.println("4. Consulta portátil asignado a un alumno.");
			System.out.println("5. Consulta alumno asignado a un portátil.");
			System.out.println("6. Ver todos los alumnos con su asignación de portátil.");		
			System.out.println("0. Cerrar menu.");
			System.out.print("[INFO] - Escriba el numero de la opcion deseada: ");
	        opcion = scan.nextInt();
			return opcion;
			
		}
		
		//Método para preguntar por los datos del Alumno.
		public AlumnosDTO preguntaAlumno() {
			
			try {
				DTOaDAO dtoAdao = new DTOaDAO();
				Scanner scan = new Scanner(System.in);
				
				System.out.printf("\nMATRICULA DE ALUMNO.\n");
				System.out.printf("\nIndique el nombre del alumno y pulse Intro: ");
				String nombre = scan.next();
				
				System.out.printf("\nIndique el telefono del alumno y pulse Intro: ");
				String telefono = scan.next();
				
				//Preguntamos por el portatil que se le va a asignar
				PortatilesDTO portatil_asignadoDTO = preguntaPortatil();	
				
				return new AlumnosDTO(nombre, telefono, dtoAdao.portatiDTOaDAO(portatil_asignadoDTO));
				
			} catch (Exception e) {
				System.out.println("Entrada Invalida. Intentelo de nuevo: ");
				return null;
			}
			
			
			
		}
		
		//Método para preguntar por un nuevo portatil.
		public PortatilesDTO preguntaPortatil() {
			
			try {
				DTOaDAO dtoAdao = new DTOaDAO();
				Scanner scan = new Scanner(System.in);
				
				System.out.printf("\nIndique el número de identificación del portatil asignado al alumno y pulse Intro: ");
				String numero_id_port = scan.next();
				
				System.out.printf("\nIndique la marca del portatil asignado al alumno y pulse Intro: ");
				String marca = scan.next();
				
				System.out.printf("\nIndique la modelo del portatil asignado al alumno y pulse Intro: ");
				String modelo = scan.next();
				
				return new PortatilesDTO(numero_id_port, marca, modelo);
				
			} catch (Exception e) {
				System.out.println("Entrada Invalida. Intentelo de nuevo: ");
				return null;
			}
			
				
		}
}
