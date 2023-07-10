package cl.ceomarin.peliculasrest.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.ceomarin.peliculasrest.models.Calificacion;

@Repository
public interface CalificacionRepository extends CrudRepository<Calificacion, Long>{

	List<Calificacion> findAll();
}
