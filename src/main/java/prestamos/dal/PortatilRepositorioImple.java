package prestamos.dal;

import java.util.List;

import javax.persistence.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

//Repositorio que implementa los metodos de la interfaz de portatiles
@Repository
public class PortatilRepositorioImple implements PortatilRepositorio{

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public void altaPortatil(Portatil portatil) {
		
		entityManager.persist(portatil);
	}

	@Override
	public Portatil buscaPortatil(String idPortatil) {
		
		try {
			String jpql = "SELECT port FROM Portatil port WHERE port.numero_identificador = :idPortatil";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("idPortatil", idPortatil);
			
			List<Portatil>portatil = query.getResultList();
			
			return portatil.get(0);
			
		} catch (Exception e) {
			System.out.println("Entrada Invalida. Acción no realizada!!!!!!!!!");
			return null;
		}
		
	}

	@Override
	public List<Portatil> todosPortatil() {
		
		try {
			return entityManager.createQuery("SELECT port FROM Portatil port").getResultList();
			
		} catch (Exception e) {
			System.out.println("Entrada Invalida. Acción no realizada!!!!!!!!!");
			return null;
		}

	}

}
