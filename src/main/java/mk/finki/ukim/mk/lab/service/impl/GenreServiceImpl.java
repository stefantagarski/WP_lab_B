package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Genre;
import mk.finki.ukim.mk.lab.repository.GenreRepository;
import mk.finki.ukim.mk.lab.service.GenreService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreServiceImpl implements GenreService {

    private final GenreRepository repository;

    public GenreServiceImpl(GenreRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Genre> listGenres() {
        return repository.genreList();
    }

    @Override
    public Optional<Genre> findByID(Long id) {
        return repository.findByID(id);
    }
}
