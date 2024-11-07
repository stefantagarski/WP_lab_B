package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Genre;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GenreRepository {

    public List<Genre> genreList(){
        return DataHolder.genreList;
    }
}
