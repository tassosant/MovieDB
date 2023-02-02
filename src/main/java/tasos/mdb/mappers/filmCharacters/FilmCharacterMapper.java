package tasos.mdb.mappers.filmCharacters;

import tasos.mdb.models.DTO.FilmCharacters.FilmCharacterDTO;
import tasos.mdb.models.FilmCharacter;
import tasos.mdb.models.Movie;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public interface FilmCharacterMapper {

    FilmCharacter filmCharacterDTOtoFilmCharacter(FilmCharacterDTO filmCharacterDTO);
    FilmCharacterDTO filmCharacterToFilmCharacterDTO(FilmCharacter filmCharacter);

    Collection<FilmCharacterDTO> filmCharacterToFilmCharacterDTO(Collection<FilmCharacter> values);
    default Set<Integer> map(Set<Movie> value) {

        if (value == null)
            return null;
        return value.stream()
                .map(m -> m.getId())
                .collect(Collectors.toSet());
    }
}
