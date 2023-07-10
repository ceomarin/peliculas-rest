package cl.ceomarin.peliculasrest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.ceomarin.peliculasrest.exception.ActorNotFoundException;
import cl.ceomarin.peliculasrest.exception.CalificacionNotFoundException;
import cl.ceomarin.peliculasrest.exception.PeliculaNotFoundException;
import cl.ceomarin.peliculasrest.models.Actor;
import cl.ceomarin.peliculasrest.models.Calificacion;
import cl.ceomarin.peliculasrest.models.Pelicula;
import cl.ceomarin.peliculasrest.services.ActorService;
import cl.ceomarin.peliculasrest.services.CalificacionService;
import cl.ceomarin.peliculasrest.services.PeliculaService;

@RestController
@RequestMapping("/api/v1")
public class MainRestController {
	
	@Autowired
	private ActorService actorServicio;
	
	
	//actores
	@GetMapping("/actores")
	public List<Actor> listar(){
		return actorServicio.listar();
	}
	
	@GetMapping("/actores/{id}")
	public Actor mostrarById(@PathVariable Long id){
		Actor actor = actorServicio.actorPorId(id);
		if(actor == null) {
			throw new ActorNotFoundException(id);
		} else {
			return actor;
		}
	}
	
	@PostMapping("/actores")
	public Actor crear(@RequestBody Actor actor){
		return actorServicio.crear(actor);
	}
	
	@PutMapping("/actores/{id}")
	public Actor update(@RequestBody Actor actor, @PathVariable Long id) {
		return actorServicio.modificar(id,actor.getNombre());
	}
	
	@DeleteMapping("/actores/{id}")
	public void eliminar(@PathVariable Long id) {
		Actor actor = actorServicio.actorPorId(id);
		if(actor == null) {
			throw new ActorNotFoundException(id);
		} else {
			actorServicio.aliminarActor(actor);
		}
		
	}
	
	//peliculas
	@Autowired
	private PeliculaService peliculaServicio;
	
	@GetMapping("/peliculas")
	public List<Pelicula> listarPeliculas(){
		return peliculaServicio.listar();
	}
	
	@GetMapping("/peliculas/{id}")
	public Pelicula mostrarPeliculaById(@PathVariable Long id){
		Pelicula pelicula = peliculaServicio.peliculaPorId(id);
		if(pelicula == null) {
			throw new PeliculaNotFoundException(id);
		} else {
			return pelicula;
		}
	}
	
	@PostMapping("/peliculas")
	public Pelicula crearPelicula(@RequestBody Pelicula pelicula){
		return peliculaServicio.crear(pelicula);
	}
	
	@PutMapping("/peliculas/{id}")
	public Pelicula updatePelicula(@RequestBody Pelicula pelicula, @PathVariable Long id) {
		return peliculaServicio.modificar(id,pelicula.getNombre(),pelicula.getAnio());
	}
	
	@DeleteMapping("/peliculas/{id}")
	public void eliminarPelicula(@PathVariable Long id) {
		Pelicula pelicula = peliculaServicio.peliculaPorId(id);
		if(pelicula == null) {
			throw new PeliculaNotFoundException(id);
		} else {
			peliculaServicio.aliminarPelicula(pelicula);		}
		
	}
	
	//Calificaciones
	@Autowired
	private CalificacionService calificacionServicio;
	
	@GetMapping("/calificaciones")
	public List<Calificacion> listarCalificacion(){
		return calificacionServicio.listar();
	}
	
	@GetMapping("/calificaciones/{id}")
	public Calificacion mostrarCalificacionById(@PathVariable Long id){
		Calificacion calificacion = calificacionServicio.calificacionPorId(id);
		if(calificacion == null) {
			throw new CalificacionNotFoundException(id);
		} else {
			return calificacion;
		}
	}
	
	@PostMapping("/peliculas/{id}/calificaciones")
	public Calificacion crearCalificacion(@PathVariable Long id,@RequestBody Calificacion calificacion){
		Pelicula pelicula = peliculaServicio.peliculaPorId(id);
		if(pelicula != null) {			
			return calificacionServicio.crear(calificacion.getNota(),calificacion.getComentario(),pelicula);
		} else {
			throw new PeliculaNotFoundException(id);
		}
	}
}
