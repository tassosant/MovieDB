package tasos.mdb.services.character;

import tasos.mdb.models.FilmCharacter;
import tasos.mdb.services.CrudService;

import java.util.Collection;

public interface MovieCharacterService extends CrudService<FilmCharacter, Integer> {
    Collection<FilmCharacter> findAllByName(String name);
}
