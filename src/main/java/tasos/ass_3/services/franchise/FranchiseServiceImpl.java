package tasos.ass_3.services.franchise;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tasos.ass_3.exceptions.FranchiseNotFoundException;
import tasos.ass_3.models.Franchise;
import tasos.ass_3.repositories.FranchiseRepository;

import java.util.Collection;

@Service
public class FranchiseServiceImpl implements FranchiseService{

    private final Logger logger = LoggerFactory.getLogger(FranchiseRepository.class);
    private final FranchiseRepository franchiseRepository;

    public FranchiseServiceImpl(FranchiseRepository franchiseRepository) {
        this.franchiseRepository = franchiseRepository;
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
}
