/*
package tasos.mdb.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class MoviesCharacters{
    @EmbeddedId
    MoviesCharactersKey id;
    @Column(name = "movie_id")
    private int movie_id;
    @Column(name = "character_id")
    private int character_id;

    @ManyToOne
    @MapsId("movieId")
    @JoinColumn(name = "movie_id")
    Movie movie;

    @ManyToOne
    @MapsId("characterId")
    @JoinColumn(name = "character_id")
    FilmCharacter filmCharacter;

}
*/
