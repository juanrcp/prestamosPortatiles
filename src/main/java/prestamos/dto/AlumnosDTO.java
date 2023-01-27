package prestamos.dto;

import org.springframework.stereotype.Service;

import prestamos.dal.Portatil;

//Servicio con la definicion del DTO de Alumnos
@Service
public class AlumnosDTO {

	//ATRIBUTOS
	
	private int id_alumno;
		
	private String nombre_alumno;
		
	private String telefono_alumno;
			
	Portatil portatil_asignado;
		
		
	//PROPIEDADES

	public Portatil getPortatil_asignado() {
		return portatil_asignado;
	}

	public void setPortatil_asignado(Portatil portatil_asignado) {
		this.portatil_asignado = portatil_asignado;
	}

	public int getId_alumno() {
		return id_alumno;
	}

	public void setId_alumno(int id_alumno) {
		this.id_alumno = id_alumno;
	}

	public String getNombre_alumno() {
		return nombre_alumno;
	}

	public void setNombre_alumno(String nombre_alumno) {
		this.nombre_alumno = nombre_alumno;
	}

	public String getTelefono_alumno() {
		return telefono_alumno;
	}

	public void setTelefono_alumno(String telefono_alumno) {
		this.telefono_alumno = telefono_alumno;
	}


	//CONSTRUCTOR
	public AlumnosDTO(String nombre_alumno, String telefono_alumno, Portatil portatil_asignado) {
			super();
			this.id_alumno = this.id_alumno;
			this.nombre_alumno = nombre_alumno;
			this.telefono_alumno = telefono_alumno;
			this.portatil_asignado = portatil_asignado;
	}
	
	public AlumnosDTO(int id_alumno, String nombre_alumno, String telefono_alumno, Portatil portatil_asignado) {
		super();
		this.id_alumno = id_alumno;
		this.nombre_alumno = nombre_alumno;
		this.telefono_alumno = telefono_alumno;
		this.portatil_asignado = portatil_asignado;
}
	
	

	public AlumnosDTO() {
		super();
	}

	//ToString
	@Override
	public String toString() {
		return "AlumnosDTO [id_alumno=" + id_alumno + ", nombre_alumno=" + nombre_alumno + ", telefono_alumno="
				+ telefono_alumno + ", portatil_asignado=" + portatil_asignado + "]";
	}
}
