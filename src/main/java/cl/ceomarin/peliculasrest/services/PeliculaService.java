package cl.ceomarin.peliculasrest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.ceomarin.peliculasrest.models.Pelicula;
import cl.ceomarin.peliculasrest.repositories.PeliculaRepository;

@Service
public class PeliculaService {

	@Autowired
	private PeliculaRepository peliculaRepositorio;
	
	public List<Pelicula> listar() {
		return peliculaRepositorio.findAll();
	}
	public Pelicula peliculaPorId(Long id) {
		Optional<Pelicula> pelicula = peliculaRepositorio.findById(id);
		if(pelicula.isPresent()) {
			return pelicula.get();
		}else {
			return null;
		}
	}
	
	public Pelicula modificar(Long id, String name, int anio) {
		Optional<Pelicula> peliculaOptional = peliculaRepositorio.findById(id);
		if(peliculaOptional.isPresent() && name != null && anio > 1) {
			Pelicula peliculaToUpdate = peliculaOptional.get();
			peliculaToUpdate.setNombre(name);
			peliculaRepositorio.save(peliculaToUpdate);
			return peliculaToUpdate;
		} else {
			return null;
		}
	}
	
	public Pelicula crear(Pelicula p) {
		return peliculaRepositorio.save(p);
	}
	
	public void aliminarPelicula(Pelicula p) {
		peliculaRepositorio.delete(p);
	}
}
