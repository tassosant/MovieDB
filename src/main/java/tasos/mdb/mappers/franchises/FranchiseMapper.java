package tasos.mdb.mappers.franchises;

import tasos.mdb.models.DTO.Franchises.FranchiseDTO;
import tasos.mdb.models.FilmCharacter;
import tasos.mdb.models.Franchise;
import tasos.mdb.models.Movie;
import tasos.mdb.services.franchise.FranchiseServiceImpl;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public interface FranchiseMapper {
    FranchiseDTO franchiseToFranchiseDTO(Franchise franchise);
    Franchise franchiseDTOtoFranchise(FranchiseDTO franchiseDTO);

    Collection<FranchiseDTO> franchiseToFranchiseDTO(Collection<Franchise> values);

    default Set<Integer> map(Set<Movie> value) {

        if (value == null)
            return null;
        return value.stream()
                .map(m -> m.getId())
                .collect(Collectors.toSet());
    }

    /*default Set<Movie> map(Set<Integer> values){
        if(values==null){
            return null;
        }
        return values.stream()
                .map(m-> )
    }*/
}
