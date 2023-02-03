package tasos.mdb.services.franchise;

import tasos.mdb.models.Franchise;
import tasos.mdb.models.Movie;
import tasos.mdb.services.CrudService;

import java.util.Collection;

public interface FranchiseService extends CrudService<Franchise, Integer> {
    Collection<Franchise> findAllByName(String name);
    Collection<Movie> getMovies(int franchiseId);
    void updateMovies(int franchiseId, int[] movies);

    void deleteFranchiseByIdInMovies(int franchiseId);

    //Collection<Character> getAllCharacters(int franchiseId);


}
