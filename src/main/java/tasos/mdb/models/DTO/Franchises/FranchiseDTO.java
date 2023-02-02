package tasos.mdb.models.DTO.Franchises;

import lombok.Getter;
import lombok.Setter;
import tasos.mdb.models.Movie;

import java.util.Set;

@Getter
@Setter
public class FranchiseDTO {
    private int id;
    private String name;
    private String description;
    private Set<Movie> movies;
}
