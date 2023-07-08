package cl.ceomarin.peliculasrest.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.ceomarin.peliculasrest.models.Pelicula;

@Repository
public interface PeliculaRepository extends CrudRepository<Pelicula,Long>{
	public List<Pelicula> findAll();
}
