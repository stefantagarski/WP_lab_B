package mk.finki.ukim.mk.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Genre {
    private Long id;
    private String name;

    public Genre(String name) {
        this.name = name;
        this.id = (long) (Math.random() * 1000);
    }
}
