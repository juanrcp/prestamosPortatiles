package prestamos.dal;

import java.util.List;

import javax.persistence.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

//Repositorio que implementa los metodos de la interfaz AlumnosServices
@Repository
public class AlumnosRepositorioImple implements AlumnosRepositorio{

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public void matriculaAlumno(Alumnos alum) {
		
		try {
			entityManager.persist(alum);
			System.out.println("Alumno Matriculado!!!");
			
		} catch (Exception e) {
			System.out.println("Entrada Invalida. Acción no realizada!!!!!!!!!");
		}
	}

	@Override
	public void bajaAlumno(int alum) {
		
		try {
			
			String jpql = "SELECT alum FROM Alumnos alum WHERE alum.id_alumno = :alum";
	        Query query = entityManager.createQuery(jpql);
	        query.setParameter("alum", alum);
			
	        //Obtenemos el primer y único elemento de la lista
			entityManager.remove(query.getResultList().get(0));
			
			System.out.println("Alumno dado de baja!!!!!");
			
		} catch (Exception e) {
			System.out.println("Entrada Invalida. Acción no realizada!!!!!!!!!");
		}
		
	}

	@Override
	public List<Alumnos> todosAlumnos(){
		
		try {
			return entityManager.createQuery("SELECT alum FROM Alumnos alum").getResultList();
			
		} catch (Exception e) {
			System.out.println("Error. Acción no realizada!!!!!!!!!");
			return null;
		}
		
	}

	@Override
	public Alumnos buscaAlumno(int id) {
		
		try {
			String jpql = "SELECT alum FROM Alumnos alum WHERE alum.id_alumno = :id";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("id", id);
			List<Alumnos> al = query.getResultList();
			return al.get(0);
			
		} catch (Exception e) {
			System.out.println("Entrada Invalida. Acción no realizada!!!!!!!!!");
			return null;
		}
		
	}
	
	@Override
	public Alumnos buscaAlumno_Portatil(String id_Portatil) {
		
		try {
			//Dado que mediante jpql no puede lograrse con la relacion establecida. Ver prueba:
			/*String jpql = "SELECT port FROM Portatil port WHERE port.portatil_asignado = 'id_Portatil'";
			 *Query query = entityManager.createQuery(jpql);
			 *query.setParameter("id_Portatil", id_Portatil);
			 *List<Alumnos> al = query.getResultList();
			 *System.out.println(al);
			 *return al.get(0);
			 */
			
			//Lo conseguimos de esta forma. Haciendo una lista de usuarios y vamos comparando los
			//id de cada objeto portátil con el id_portatil suministrado
			List<Alumnos> listaAlumnos = todosAlumnos();
			Alumnos alumnosAsociado = new Alumnos();
			
			for (Alumnos alumnos : listaAlumnos) {
				if(alumnos.getPortatil_asignado().getNumero_identificador().equals(id_Portatil)) {
					alumnosAsociado = alumnos;
				}
				else {
					System.out.printf("\n¡¡¡La referencia introducida no existe o esta desocupada!!!.");
				}
			}
			
			return alumnosAsociado;
			
		} catch (Exception e) {
			System.out.println("Entrada Invalida. Acción no realizada!!!!!!!!!");
			return null;
		}
		
	}

}
