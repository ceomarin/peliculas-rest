package cl.ceomarin.peliculasrest.exception;

public class PeliculaNotFoundException extends RuntimeException{
	 public PeliculaNotFoundException(Long id) {
		    super("No fue posible encontrar la pelicula " + id);
		  }
}
