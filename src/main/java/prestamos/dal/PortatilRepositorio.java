package prestamos.dal;

import java.util.List;

//Interfaz con los metodos correspondientes a los portatiles y con sus excepciones controladas
public interface PortatilRepositorio {
	
	//Método para dar de alta un nuevo portatil
	public void altaPortatil(Portatil portatil) throws Exception;
	
	//Método para buscar un portatil en concreto en base a su identificador
	public Portatil buscaPortatil(String idPortatil) throws Exception;
	
	//Método para obtener la lista de todos los portatiles
	public List<Portatil> todosPortatil() throws Exception;

}
