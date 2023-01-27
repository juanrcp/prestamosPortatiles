package prestamos.controlador;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import prestamos.consultas.Consultas;
import prestamos.dal.Alumnos;
import prestamos.dal.Portatil;
import prestamos.dto.AlumnosDTO;
import prestamos.dto.DAOaDTO;
import prestamos.dto.DTOaDAO;
import prestamos.dto.PortatilesDTO;
import prestamos.menu.Menu;

//Controlador que gestiona la comunicación entre modelo y vista
@Controller
public class Main {

	public static void main(String[] args) {

		// Definimos el contexto
		ApplicationContext context = new ClassPathXmlApplicationContext("contexto.xml");
		Consultas consulta = (Consultas) context.getBean(Consultas.class);

		// Scaner para iniciar la captura del valor
		Scanner scan = new Scanner(System.in);

		// Variables para el menu
		Menu m = new Menu();
		int opcion = 0;

		// Variable para paso de DTO a DAO
		DTOaDAO dtoAdao = new DTOaDAO();
		DAOaDTO daoAdto = new DAOaDTO();

		try {
		do {
			System.out.println();
			
				// Mostramos el menu, introducimos el scan y guardamos la opción seleccionada
				opcion = m.mostrarMenu(scan);
				

			// Opciones del programa
			switch (opcion) {

			// Opción para insertar un alumno
			case 1:

				System.out.println("Opción escogida: Matricular Alumno.");
				// Preguntamos por el alumno
				AlumnosDTO alum = m.preguntaAlumno();
				
				consulta.matriculaAlumno(dtoAdao.alumnoDTOaDAO(alum));

				break;

			// Opción para dar de baja a un alumno
			case 2:

				System.out.println("Opción escogida: Baja Alumno.");
				// Mostramos todos los alumnos para preguntar cual quiere borrar
				List<Alumnos> listaAlumnos = consulta.todosAlumnos();
				for (Alumnos alumno : listaAlumnos) {
					System.out.println((daoAdto.alumnoDAOaDTO(alumno)).toString());
				}
				
				Boolean error = false;
				int id;

				do {
					try {
						
						System.out.printf("\nIndique el ID del Alumno que desee dar de baja y pulse Intro: ");
						id = scan.nextInt();
						consulta.bajaAlumno(id);
						
					} catch (Exception e) {
						System.out.println("Entrada Invalida. Intente de nuevo.");
						id = scan.nextInt();
						error = true;
					}
				}while(error);


				break;
			// Opción para dar de alta un portatil
			case 3:

				System.out.println("Opción escogida: Alta Portatil.");
				// Preguntamos por el portatil
				PortatilesDTO port = m.preguntaPortatil();

				consulta.altaPortatil(dtoAdao.portatiDTOaDAO(port));
				System.out.println("Portatil Registrado!!!");

				break;

			// Opción para consultar que portatil tiene un usuario concreto
			case 4:

				System.out.println("Opcion escogida: Consulta portátil asignado a un alumno.");
				System.out.println();
				// Mostramos todos los alumnos para preguntar de cual queremos detalles
				listaAlumnos = consulta.todosAlumnos();
				for (Alumnos alumno : listaAlumnos) {
					System.out.println((daoAdto.alumnoDAOaDTO(alumno)).toString());
				}

				System.out.printf("\nIndique el ID del Alumno cuyos datos del portatil desee conocer y pulse Intro: ");
				int idAlumno = scan.nextInt();

				Alumnos alumnosSelect = consulta.buscaAlumno(idAlumno);

				Portatil portSelect = consulta
						.buscaPortatil(alumnosSelect.getPortatil_asignado().getNumero_identificador());

				System.out.println(daoAdto.portatiDAOaDTO(portSelect).toString());

				break;

			// Opción para consultar el alumno según el portátil que tenga.
			case 5:

				System.out.println("Opcion escogida: Consulta alumno asignado a un portátil.");
				System.out.println();
				// Mostramos todos los alumnos para preguntar de cual queremos detalles

				for (Portatil portatil : consulta.todosPortatiles()) {
					PortatilesDTO portatilDTO = daoAdto.portatiDAOaDTO(portatil);
					System.out.println(portatilDTO.toString());
				}

				System.out.printf(
						"\nIndique el Numero Identificador del Portátil el cual quiere verse su asignación y pulse Intro: ");
				String idPortatil = scan.next();

				System.out.println(daoAdto.alumnoDAOaDTO(consulta.buscaAlumno_Portatil(idPortatil)).toString());

				break;

			
			  //Opción para ver todos los alumnos con sus portatiles 
			case 6:
				System.out.println("Opcion escogida: Ver todos los alumnos con su asignación de portátil.");
				System.out.println();
				listaAlumnos = consulta.todosAlumnos();
				
				for (Alumnos alumno : listaAlumnos) {
					System.out.println(daoAdto.alumnoDAOaDTO(alumno).toString());
					
					for (Portatil portatil : consulta.todosPortatiles()) {
						if(portatil.getNumero_identificador().equals(alumno.getPortatil_asignado().getNumero_identificador())){
							System.out.println("Portatil asociado:");
							System.out.println(daoAdto.portatiDAOaDTO(portatil).toString());
						}
						System.out.println();
					}
				}
			  
			  break;
			 
			case 0:
				System.out.println("Ha cerrado la aplicación. Gracias por usarla.");

				break;

			// Opción en caso de que se introduzca una opción NO valida.
			default:
				System.out.println("Opción no válida, escoja una Opción del [0 - 6] y pulse intro.");

				break;
			}

			System.out.println();

		} while (opcion != 0);
			
		} catch (Exception e) {
			System.out.println("ERROR. Acción no realizada!!!!!!!");
		}
	}

}
