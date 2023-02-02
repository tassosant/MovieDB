package tasos.mdb.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tasos.mdb.models.DTO.FilmCharacters.FilmCharacterDTO;
import tasos.mdb.models.DTO.Movies.MovieDTO;
import tasos.mdb.models.FilmCharacter;
import tasos.mdb.models.Franchise;
import tasos.mdb.models.Gender;
import tasos.mdb.models.Movie;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Component
@Mapper(componentModel = "spring")
public abstract class MovieMapperImpl implements MovieMapper{
    @Override
    public MovieDTO movieToMovieDTO(Movie movie){
        if(movie==null)
            return null;
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setId(movie.getId());
        movieDTO.setTitle(movie.getTitle());
        movieDTO.setGenre(movie.getGenre());
        movieDTO.setYear(movie.getYear());
        movieDTO.setDirector(movie.getDirector());
        movieDTO.setPicture(movie.getPicture());
        movieDTO.setTrailer(movie.getTrailer());
        movieDTO.setFranchise(franchiseId(movie));
        movieDTO.setFilmCharacters( map( movie.getFilmCharacters() ));

        return movieDTO;
    }

    private int franchiseId(Movie movie){
        if(movie == null)
            return 0;
        if(movie.getFranchise() == null)
            return 0;

        return movie.getFranchise().getId();
    }

    public Collection<MovieDTO> movieToMovieDTO(Collection<Movie> movies){
        if(movies==null){
            return null;
        }

        Collection<MovieDTO> collection = new ArrayList<MovieDTO>(movies.size());
        for(Movie movie:movies){
            collection.add(movieToMovieDTO(movie));
        }
        return collection;
    }

}
