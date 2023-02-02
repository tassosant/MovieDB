package tasos.mdb.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import tasos.mdb.models.DTO.Movies.MovieDTO;
import tasos.mdb.models.FilmCharacter;
import tasos.mdb.models.Movie;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;



//I created manually the map because I had a bug issue
public interface MovieMapper{


    Movie movieDTOtoMovie (MovieDTO movieDTO);
    MovieDTO movieToMovieDTO(Movie movie);

    Collection<MovieDTO> movieToMovieDTO(Collection<Movie> movie);


    default Set<Integer> map(Set<FilmCharacter> value) {

        if (value == null)
            return null;
        return value.stream()
                .map(f -> f.getId())
                .collect(Collectors.toSet());
    }
}

