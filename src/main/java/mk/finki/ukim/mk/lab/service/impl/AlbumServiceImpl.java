package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Album;
import mk.finki.ukim.mk.lab.repository.impl.InMemoryAlbumRepository;
import mk.finki.ukim.mk.lab.repository.jpa.AlbumRepository;
import mk.finki.ukim.mk.lab.service.AlbumService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumServiceImpl implements AlbumService {
    private final AlbumRepository albumRepository;

    public AlbumServiceImpl(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }


    @Override
    public List<Album> findAll() {
        return albumRepository.findAll();
    }

    @Override
    public Optional<Album> findByID(Long id) {
        return albumRepository.findById(id);
    }
}
