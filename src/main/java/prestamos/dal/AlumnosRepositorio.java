package prestamos.dal;

import java.util.List;

//Interfaz con los métodos para los alumnos y con sus excepciones controladas
public interface AlumnosRepositorio {
	
	//Añade un nuevo alumno
	public void matriculaAlumno(Alumnos alum) throws Exception;
	
	//Elimina a un alumno
	public void bajaAlumno(int alum) throws Exception;
	
	//Hace un listado de todos los alumnos
	public List<Alumnos> todosAlumnos() throws Exception;
	
	//Busca a un alumno en concreto en base al identificador
	public Alumnos buscaAlumno(int alumno) throws Exception;
	
	//Metodo para buscar un alumno en base a un portatil
	public Alumnos buscaAlumno_Portatil(String id_Portatil) throws Exception;

}
