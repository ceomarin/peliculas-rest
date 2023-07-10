package cl.ceomarin.peliculasrest.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="peliculas")
public class Pelicula {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private int anio;
	@OneToMany(mappedBy = "pelicula", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Calificacion> calificaciones;
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
	public List<Calificacion> getCalificaciones() {
		return calificaciones;
	}
	public void setCalificaciones(List<Calificacion> calificaciones) {
		this.calificaciones = calificaciones;
	}
	public List<Actor> getListaActores() {
		return listaActores;
	}
	public void setListaActores(List<Actor> listaActores) {
		this.listaActores = listaActores;
	}
	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", nombre=" + nombre + ", anio=" + anio + ", actores=" + listaActores + "]";
	}

}
