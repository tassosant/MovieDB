package tasos.mdb.services.movie;


import tasos.mdb.models.FilmCharacter;
import tasos.mdb.models.Movie;
import tasos.mdb.services.CrudService;

import java.util.Collection;

public interface MovieService extends CrudService<Movie, Integer> {
    Collection<Movie> findAllByName(String name);
    void updateCharacters(int movieId, int[] filmCharacters);

    Collection<FilmCharacter> getCharacters(int movieId);

    int updateById(int franchiseId,int movieId);

}
