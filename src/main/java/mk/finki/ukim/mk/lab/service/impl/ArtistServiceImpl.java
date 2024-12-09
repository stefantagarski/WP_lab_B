package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.repository.impl.InMemoryArtistRepository;
import mk.finki.ukim.mk.lab.service.ArtistService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistServiceImpl implements ArtistService {

    private final InMemoryArtistRepository repository;

    public ArtistServiceImpl(InMemoryArtistRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Artist> listArtists() {
        return repository.findAll();
    }

    @Override
    public Optional<Artist> artistFindById(Long id) {
        return repository.findById(id);
    }
}
