package prestamos.dto;

import org.springframework.stereotype.Service;

//Servicio con la definicion del DTO de Portatiles
@Service
public class PortatilesDTO {
	
	//ATRIBUTOS
	private String numero_identificador;
		
	private String marca;
	
	private String modelo;
	

	//PROPIEDADES		
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
	public PortatilesDTO(String numero_identificador, String marca, String modelo) {
		super();
		this.numero_identificador = numero_identificador;
		this.marca = marca;
		this.modelo = modelo;
	}
		
	public PortatilesDTO() {
		super();
	}
	

	//ToString
	@Override
	public String toString() {
		return "PortatilesDTO [numero_identificador=" + numero_identificador + ", marca=" + marca + ", modelo=" + modelo
				+ "]";
	}	
	
}
