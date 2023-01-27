package prestamos.dal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//Clase con la entidad correspondiente a los portatiles 
@Entity
@Table(name = "portatil", schema="dlk_prestamos")
public class Portatil {
	
	//ATRIBUTOS
	
	@Id
	@Column(name="numero_identificador")
	private String numero_identificador;
	
	@Column(name="marca", unique = false, nullable = false)
	private String marca;
	
	@Column(name="modelo", unique = false, nullable = false)
	private String modelo;
	
	@Column(name = "md_uuid", nullable = false)
	private String md_uuid = "No Informado";


	//PROPIEDADES
	
	public String getMd_uuid() {
		return md_uuid;
	}

	public void setMd_uuid(String md_uuid) {
		this.md_uuid = md_uuid;
	}

	public String getNumero_identificador() {
		return numero_identificador;
	}

	public void setNumero_identificador(String numero_identificador) {
		this.numero_identificador = numero_identificador;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	//CONSTRUCTORES
	public Portatil(String numero_identificador, String marca, String modelo, String md_uuid) {
		super();
		this.numero_identificador = numero_identificador;
		this.marca = marca;
		this.modelo = modelo;
		this.md_uuid = md_uuid;
	}	
	
	public Portatil(String numero_identificador, String marca, String modelo) {
		super();
		this.numero_identificador = numero_identificador;
		this.marca = marca;
		this.modelo = modelo;
		this.md_uuid = this.md_uuid;
	}

	public Portatil() {
		super();
	}
	
}
