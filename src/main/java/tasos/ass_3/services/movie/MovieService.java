package tasos.ass_3.services.movie;


import tasos.ass_3.models.Movie;
import tasos.ass_3.services.CrudService;

import java.util.Collection;

public interface MovieService extends CrudService<Movie, Integer> {
    Collection<Movie> findAllByName(String name);


}
