package tasos.ass_3.services.character;

import tasos.ass_3.models.FilmCharacter;
import tasos.ass_3.services.CrudService;

import java.util.Collection;

public interface MovieCharacterService extends CrudService<FilmCharacter, Integer> {
    Collection<FilmCharacter> findAllByName(String name);
}
