package mk.finki.ukim.mk.lab.repository.impl;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Genre;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryGenreRepository {

    public List<Genre> genreList(){
        return DataHolder.genreList;
    }

    public Optional<Genre> findByID(Long id) {
        return DataHolder.genreList.stream().filter(r -> r.getId().equals(id)).findFirst();
    }
 }
