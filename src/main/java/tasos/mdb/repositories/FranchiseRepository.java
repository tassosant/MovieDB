package tasos.mdb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tasos.mdb.models.Franchise;
import tasos.mdb.models.Movie;

import java.util.Set;

public interface FranchiseRepository extends JpaRepository<Franchise, Integer> {

    @Query("select f from Franchise f where f.name like %?1%")
    Set<Franchise> findAllByName(String name);


}
