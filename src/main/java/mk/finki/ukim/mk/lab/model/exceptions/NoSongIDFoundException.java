package mk.finki.ukim.mk.lab.model.exceptions;

public class NoSongIDFoundException extends RuntimeException {
    public NoSongIDFoundException(Long id) {
        super(String.format("No Song with ID: %d found", id));
    }
}
