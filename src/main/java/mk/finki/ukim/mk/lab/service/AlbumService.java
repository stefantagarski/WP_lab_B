package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Album;

import java.util.List;
import java.util.Optional;

public interface AlbumService {
    List<Album> findAll();
    Optional<Album> findByID(Long id);
}
