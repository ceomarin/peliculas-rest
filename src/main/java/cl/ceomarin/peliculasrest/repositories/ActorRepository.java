package cl.ceomarin.peliculasrest.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.ceomarin.peliculasrest.models.Actor;

@Repository
public interface ActorRepository extends CrudRepository<Actor,Long>{

	public List<Actor> findAll();
	
}
