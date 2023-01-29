package prestamos.dal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//Clase con la entidad de los alumnos con sus datos
@Entity
@Table(name="alumnos", schema="dlk_prestamos")
public class Alumnos {
	
	//ATRIBUTOS
	
	@Id
	//ID autogenerado
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_alumno") 
	private int id_alumno;
	
	@Column(name = "nombre_alumno", unique = false, nullable = false)
	private String nombre_alumno;
	
	@Column(name = "telefono_alumno", unique = true, nullable = false)
	private String telefono_alumno;
	
	//Establecemos relacion con la tabla portatiles y fijamos las alteraciones en cascada
	@OneToOne(cascade = CascadeType.ALL)
	Portatil portatil_asignado;
	
	@Column(name = "md_uuid", nullable = false)
	private String md_uuid = "No Informado";

	
	//PROPIEDADES
	public String getMd_uuid() {
		return md_uuid;
	}

	public void setMd_uuid(String md_uuid) {
		this.md_uuid = md_uuid;
	}

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
	public Alumnos(int id_alumno, String nombre_alumno, String telefono_alumno, Portatil portatil_asignado,
			String md_uuid) {
		super();
		this.id_alumno = id_alumno;
		this.nombre_alumno = nombre_alumno;
		this.telefono_alumno = telefono_alumno;
		this.portatil_asignado = portatil_asignado;
		this.md_uuid = md_uuid;
	}
	
	public Alumnos(String nombre_alumno, String telefono_alumno, Portatil portatil_asignado) {
		super();
		this.id_alumno = this.id_alumno;
		this.nombre_alumno = nombre_alumno;
		this.telefono_alumno = telefono_alumno;
		this.portatil_asignado = portatil_asignado;
		this.md_uuid = this.md_uuid;
	}

	public Alumnos() {
		super();
	}	
	
}
