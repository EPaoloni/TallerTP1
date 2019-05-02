package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;

@Entity
public class Ciudad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	@OneToOne
	@Cascade(value = org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private Ubicacion ubicacionGeografica;
	@ManyToOne
	private Pais pais;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Ubicacion getUbicacionGeografica() {
		return ubicacionGeografica;
	}
	public void setUbicacionGeografica(Ubicacion ubicacionGeografica) {
		this.ubicacionGeografica = ubicacionGeografica;
	}
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	
	
}
