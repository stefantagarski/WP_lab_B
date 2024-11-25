package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreService {
    List<Genre> listGenres();
    Optional<Genre> findByID(Long id);
}
