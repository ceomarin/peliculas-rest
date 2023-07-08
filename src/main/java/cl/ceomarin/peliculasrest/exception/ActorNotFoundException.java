package cl.ceomarin.peliculasrest.exception;

public class ActorNotFoundException extends RuntimeException{
	  public ActorNotFoundException(Long id) {
		    super("No fue posible encontrar al actor " + id);
		  }
}
