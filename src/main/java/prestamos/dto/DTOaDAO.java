package prestamos.dto;

import org.springframework.stereotype.Service;

import prestamos.dal.Alumnos;
import prestamos.dal.Portatil;

//Servicio con la clase para convertir los DTO a DAO
@Service
public class DTOaDAO {

	//Metodo para convertir a los alumnosDTO a DAO
	public Alumnos alumnoDTOaDAO(AlumnosDTO alum) {
		return new Alumnos(alum.getNombre_alumno(), alum.getTelefono_alumno(), alum.getPortatil_asignado());
	}
		
	//Metodo para convertir a los portatilesDTO a DAO
	public Portatil portatiDTOaDAO(PortatilesDTO port) {
		return new Portatil(port.getNumero_identificador(), port.getMarca(), port.getModelo());
	}
}
