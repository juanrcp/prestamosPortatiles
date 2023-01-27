package prestamos.consultas;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prestamos.dal.Alumnos;
import prestamos.dal.AlumnosRepositorioImple;
import prestamos.dal.Portatil;
import prestamos.dal.PortatilRepositorioImple;

//Servicio para inyectar las implementaciones de los servicios de la capa DAL
@Service
public class Consultas {
	
	@Autowired
	private AlumnosRepositorioImple ari;
	
	@Autowired
	private PortatilRepositorioImple pri;

	@Transactional
	public void matriculaAlumno(Alumnos alum) {

		ari.matriculaAlumno(alum);
		//A parte de al alumno guardamos el nuevo portatil
		pri.altaPortatil(alum.getPortatil_asignado());
	}
	
	@Transactional
	public void bajaAlumno(int alum) {		
		
		ari.bajaAlumno(alum);
	}
	
	@Transactional
	public Alumnos buscaAlumno(int alumno) {
		return ari.buscaAlumno(alumno);
	}
	
	@Transactional
	public Portatil buscaPortatil(String portatil) {
		return pri.buscaPortatil(portatil);
	}
	
	@Transactional
	public List<Alumnos> todosAlumnos() {
		return ari.todosAlumnos();
	}
	
	@Transactional
	public List<Portatil> todosPortatiles() {
		return pri.todosPortatil();
	}
	
	@Transactional
	public void altaPortatil(Portatil portatil) {
		pri.altaPortatil(portatil);
	}
	
	public Alumnos buscaAlumno_Portatil(String id_Portatil) {
		return ari.buscaAlumno_Portatil(id_Portatil);
	}
}
