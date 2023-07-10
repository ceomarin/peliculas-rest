package cl.ceomarin.peliculasrest.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
@Table(name="calificaciones")
public class Calificacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int nota;
	private String comentario;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pelicula_id")
	@JsonBackReference
	private Pelicula pelicula;
	public Calificacion() {
	}
	public Calificacion(int nota, String comentario,Pelicula pelicula) {
		this.nota = nota;
		this.comentario = comentario;
		this.pelicula = pelicula;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getNota() {
		return nota;
	}
	public void setNota(int nota) {
		this.nota = nota;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public Pelicula getPelicula() {
		return pelicula;
	}
	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}
	@Override
	public String toString() {
		return "Calificacion [id=" + id + ", nota=" + nota + ", comentario=" + comentario + ", pelicula=" + pelicula
				+ "]";
	}
	
}
