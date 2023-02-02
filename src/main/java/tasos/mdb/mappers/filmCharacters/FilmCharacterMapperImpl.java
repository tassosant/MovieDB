package tasos.mdb.mappers.filmCharacters;

import org.springframework.stereotype.Service;
import tasos.mdb.models.DTO.FilmCharacters.FilmCharacterDTO;
import tasos.mdb.models.FilmCharacter;
import tasos.mdb.models.Movie;
import tasos.mdb.repositories.MovieRepository;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class FilmCharacterMapperImpl implements FilmCharacterMapper{

    private final MovieRepository movieRepository;

    public FilmCharacterMapperImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public FilmCharacter filmCharacterDTOtoFilmCharacter(FilmCharacterDTO filmCharacterDTO){
        if(filmCharacterDTO==null)
            return null;
        FilmCharacter filmCharacter = new FilmCharacter();
        filmCharacter.setId(filmCharacterDTO.getId());
        filmCharacter.setFullName(filmCharacterDTO.getFullName());
        filmCharacter.setAlias(filmCharacterDTO.getAlias());
        filmCharacter.setGender(filmCharacterDTO.getGender());
        filmCharacter.setMovies(moviesIntToMovies(filmCharacterDTO.getMovies()));
        return filmCharacter;
    }

    public FilmCharacterDTO filmCharacterToFilmCharacterDTO(FilmCharacter filmCharacter){
        if(filmCharacter==null){
            return null;
        }
        FilmCharacterDTO filmCharacterDTO = new FilmCharacterDTO();
        filmCharacterDTO.setId(filmCharacter.getId());
        filmCharacterDTO.setFullName(filmCharacter.getFullName());
        filmCharacterDTO.setAlias(filmCharacter.getAlias());
        filmCharacterDTO.setGender(filmCharacter.getGender());
        filmCharacterDTO.setMovies(map(filmCharacter.getMovies()));
        return filmCharacterDTO;
    }

    public Collection<FilmCharacterDTO> filmCharacterToFilmCharacterDTO(Collection<FilmCharacter> values){
        Set<FilmCharacterDTO> filmCharacterDTOs = new HashSet<>(values.size());
        for(FilmCharacter value:values){
            filmCharacterDTOs.add(filmCharacterToFilmCharacterDTO(value));
        }
        return filmCharacterDTOs;
    }
    private Set<Movie> moviesIntToMovies(Set<Integer> values){

        if (values==null)
            return null;

        Set<Movie> movies = new HashSet<>();
        for(Integer value:values){
            movies.add(movieRepository.findById(value).get());
        }
        return movies;


    }


}
