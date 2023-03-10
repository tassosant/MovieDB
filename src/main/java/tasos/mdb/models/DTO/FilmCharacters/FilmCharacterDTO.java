package tasos.mdb.models.DTO.FilmCharacters;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class FilmCharacterDTO {
    private int id;
    private String fullName;
    private String alias;
    private String gender;
    private Set<Integer> movies;
}
