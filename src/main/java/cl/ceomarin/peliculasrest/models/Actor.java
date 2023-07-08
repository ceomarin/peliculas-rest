package cl.ceomarin.peliculasrest.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="actores")
public class Actor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		  name = "actores_peliculas", 
		  joinColumns = @JoinColumn(name = "actor_id"), 
		  inverseJoinColumns = @JoinColumn(name = "pelicula_id"))
	private List<Pelicula> listaPeliculas;
	public Actor() {
	}
	public Actor(String nombre) {
		this.nombre = nombre;
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
	public List<Pelicula> getPeliculas() {
		return listaPeliculas;
	}
	public void setPeliculas(List<Pelicula> peliculas) {
		this.listaPeliculas = peliculas;
	}
	@Override
	public String toString() {
		return "Actor [id=" + id + ", nombre=" + nombre + ", peliculas=" + listaPeliculas + "]";
	}
	

}
