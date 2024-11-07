package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Artist;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ArtistRepository {
    public List<Artist> findAll() {
        return DataHolder.artistList;
    }

    public Optional<Artist> findById(Long id) {
        return DataHolder.artistList.stream().filter(r -> r.getId().equals(id)).findFirst();
    }
}
