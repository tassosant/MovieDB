package tasos.mdb.services.franchise;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tasos.mdb.exceptions.FranchiseNotFoundException;
import tasos.mdb.models.Franchise;
import tasos.mdb.models.Movie;
import tasos.mdb.repositories.FranchiseRepository;
import tasos.mdb.repositories.MovieRepository;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class FranchiseServiceImpl implements FranchiseService{

    private final Logger logger = LoggerFactory.getLogger(FranchiseRepository.class);
    private final FranchiseRepository franchiseRepository;
    private final MovieRepository movieRepository;
    public FranchiseServiceImpl(FranchiseRepository franchiseRepository, MovieRepository movieRepository) {
        this.franchiseRepository = franchiseRepository;
        this.movieRepository = movieRepository;
    }

    @Override
    public Collection<Franchise> findAllByName(String name){
        return franchiseRepository.findAllByName(name);
    }

    @Override
    public Franchise findById(Integer id){
        return franchiseRepository.findById(id).orElseThrow(()
                ->new FranchiseNotFoundException(id));
    }

    @Override
    public Collection<Franchise> findAll(){
        return franchiseRepository.findAll();
    }

    @Override
    public Franchise add(Franchise entity){
        return franchiseRepository.save(entity);
    }

    @Override
    public Franchise update(Franchise entity){
        return franchiseRepository.save(entity);
    }

    @Override
    public void deleteById(Integer id){
        franchiseRepository.deleteById(id);
    }

    @Override
    public boolean exists(Integer id){
        return franchiseRepository.existsById(id);
    }

    @Override
    public Collection<Movie> getMovies(int franchiseId){
        return franchiseRepository.findById(franchiseId).get().getMovies();
    }



    @Override
    public void updateMovies(int franchiseId, int[] movies){
        Franchise franchise = franchiseRepository.findById(franchiseId).get();
        Set<Movie> moviesSet = new HashSet<>();
        for(int id: movies){
            moviesSet.add(movieRepository.findById(id).get());
        }
        franchise.setMovies(moviesSet);
        franchiseRepository.save(franchise);
    }


}