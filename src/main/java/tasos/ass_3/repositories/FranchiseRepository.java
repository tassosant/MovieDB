package tasos.ass_3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tasos.ass_3.models.Franchise;

import java.util.Set;

public interface FranchiseRepository extends JpaRepository<Franchise, Integer> {

    @Query("select f from Franchise f where f.name like %?1%")
    Set<Franchise> findAllByName(String name);
}
