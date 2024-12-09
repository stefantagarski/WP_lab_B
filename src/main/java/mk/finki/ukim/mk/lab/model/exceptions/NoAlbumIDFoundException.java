package mk.finki.ukim.mk.lab.model.exceptions;

public class NoAlbumIDFoundException extends RuntimeException {
    public NoAlbumIDFoundException(Long id) {
        super(String.format("No Album with ID: %d found", id));
    }
}
