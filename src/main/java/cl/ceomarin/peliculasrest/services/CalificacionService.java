package cl.ceomarin.peliculasrest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.ceomarin.peliculasrest.models.Calificacion;
import cl.ceomarin.peliculasrest.models.Pelicula;
import cl.ceomarin.peliculasrest.repositories.CalificacionRepository;

@Service
public class CalificacionService {

	@Autowired
	private CalificacionRepository calificacionRepositorio;
	
	public List<Calificacion> listar() {
		return calificacionRepositorio.findAll();
	}
	
	public Calificacion calificacionPorId(Long id) {
		Optional<Calificacion> calificacion = calificacionRepositorio.findById(id);
		if(calificacion.isPresent()) {
			return calificacion.get();
		}else {
			return null;
		}
	}
	
	public Calificacion crear(int nota, String comentario,Pelicula p) {
		Calificacion c = new Calificacion(nota,comentario,p);
			return calificacionRepositorio.save(c);			
	}
	
	public Calificacion modificar(Long id, int nota, String comentario) {
		Optional<Calificacion> calificacionOptional = calificacionRepositorio.findById(id);
		if(calificacionOptional.isPresent() && comentario != null && nota > 1) {
			Calificacion calificacionToUpdate = calificacionOptional.get();
			calificacionToUpdate.setNota(nota);
			calificacionToUpdate.setComentario(comentario);
			calificacionRepositorio.save(calificacionToUpdate);
			return calificacionToUpdate;
		} else {
			return null;
		}
	}
}
