package cl.ceomarin.peliculasrest.exception;

public class CalificacionNotFoundException extends RuntimeException{
	public CalificacionNotFoundException(Long id) {
	    super("No fue posible encontrar la calificacion " + id);
	  }
}
