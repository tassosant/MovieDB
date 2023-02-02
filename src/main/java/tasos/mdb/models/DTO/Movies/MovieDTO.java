package tasos.mdb.models.DTO.Movies;

import lombok.Getter;
import lombok.Setter;
import tasos.mdb.models.FilmCharacter;
import tasos.mdb.models.Franchise;
import tasos.mdb.models.Gender;

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
