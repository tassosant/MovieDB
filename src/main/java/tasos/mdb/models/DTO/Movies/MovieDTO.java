package tasos.mdb.models.DTO.Movies;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class MovieDTO {
    private int id;
    private String title;
    private String genre;
    private int year;
    private String director;
    private String picture;
    private String trailer;
    private int franchise;
    private Set<Integer> filmCharacters;
}
