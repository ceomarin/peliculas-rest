package cl.ceomarin.peliculasrest.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="peliculas")
public class Pelicula {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private int anio;
	@ManyToMany(mappedBy = "listaPeliculas")
	private List<Actor> listaActores;
	public Pelicula() {
	}
	public Pelicula(String nombre, int anio) {
		this.nombre = nombre;
		this.anio = anio;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	public List<Actor> getActores() {
		return listaActores;
	}
	public void setActores(List<Actor> actores) {
		this.listaActores = actores;
	}
	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", nombre=" + nombre + ", anio=" + anio + ", actores=" + listaActores + "]";
	}

}
