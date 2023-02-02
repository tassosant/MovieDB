package tasos.mdb.mappers;

import org.springframework.stereotype.Service;
import tasos.mdb.models.DTO.Franchises.FranchiseDTO;
import tasos.mdb.models.DTO.Movies.MovieDTO;
import tasos.mdb.models.Franchise;
import tasos.mdb.models.Movie;
import tasos.mdb.repositories.MovieRepository;
import tasos.mdb.services.movie.MovieService;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class FranchiseMapperImpl implements FranchiseMapper{

    private final MovieRepository movieRepository;




    public FranchiseMapperImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public FranchiseDTO franchiseToFranchiseDTO(Franchise franchise){
        FranchiseDTO franchiseDTO =new FranchiseDTO();
        franchiseDTO.setId(franchise.getId());
        franchiseDTO.setName(franchise.getName());
        franchiseDTO.setDescription(franchise.getDescription());
        franchiseDTO.setMovies(map(franchise.getMovies()));
        return franchiseDTO;
    }
    public Franchise franchiseDTOtoFranchise(FranchiseDTO franchiseDTO){
        Franchise franchise = new Franchise();
        franchise.setId(franchiseDTO.getId());
        franchise.setName(franchiseDTO.getName());
        franchise.setDescription(franchiseDTO.getDescription());

        franchise.setMovies(moviesIntToMovies(franchiseDTO.getMovies()));

        return franchise;
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
