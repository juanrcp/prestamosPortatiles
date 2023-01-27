package prestamos.dto;

import org.springframework.stereotype.Service;

import prestamos.dal.Alumnos;
import prestamos.dal.Portatil;

//Servicio con la clase para convertir los DAO a DTO
@Service
public class DAOaDTO {

	//Metodo para convertir a los alumnos a DTO
	public AlumnosDTO alumnoDAOaDTO(Alumnos alum) {
		return new AlumnosDTO(alum.getId_alumno(), alum.getNombre_alumno(), alum.getTelefono_alumno(), alum.getPortatil_asignado());
	}
	
	//Metodo para convertir a los portatiles a DTO
	public PortatilesDTO portatiDAOaDTO(Portatil port) {
		return new PortatilesDTO(port.getNumero_identificador(), port.getMarca(), port.getModelo());
	}
}
