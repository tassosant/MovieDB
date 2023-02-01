package tasos.ass_3.services.franchise;

import tasos.ass_3.models.Franchise;
import tasos.ass_3.services.CrudService;

import java.util.Collection;

public interface FranchiseService extends CrudService<Franchise, Integer> {
    Collection<Franchise> findAllByName(String name);
}
