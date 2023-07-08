package cl.ceomarin.peliculasrest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.ceomarin.peliculasrest.models.Actor;
import cl.ceomarin.peliculasrest.repositories.ActorRepository;

@Service
public class ActorService {

	@Autowired
	private ActorRepository actorRepositorio;
	
	public List<Actor> listar() {
		return actorRepositorio.findAll();
	}
	public Actor actorPorId(Long id) {
		Optional<Actor> actor = actorRepositorio.findById(id);
		if(actor.isPresent()) {
			return actor.get();
		}else {
			return null;
		}
	}
	
	public Actor modificar(Long id, String name) {
		Optional<Actor> actorOptional = actorRepositorio.findById(id);
		if(actorOptional.isPresent() && name != null) {
			Actor actorToUpdate = actorOptional.get();
			actorToUpdate.setNombre(name);
			actorRepositorio.save(actorToUpdate);
			return actorToUpdate;
		} else {
			return null;
		}
	}
	
	public Actor crear(Actor a) {
		return actorRepositorio.save(a);
	}
	
	public void aliminarActor(Actor a) {
		actorRepositorio.delete(a);
	}
}
