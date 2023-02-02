package tasos.mdb.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tasos.mdb.mappers.franchises.FranchiseMapper;
import tasos.mdb.mappers.franchises.FranchiseMapperImpl;
import tasos.mdb.models.DTO.Franchises.FranchiseDTO;
import tasos.mdb.repositories.FranchiseRepository;
import tasos.mdb.services.franchise.FranchiseService;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("api/v1/franchises")
public class FranchiseController {


    private final FranchiseService franchiseService;
    private final FranchiseMapper franchiseMapper;



    public FranchiseController(FranchiseService franchiseService, FranchiseMapper franchiseMapper) {
        this.franchiseService = franchiseService;
        this.franchiseMapper = franchiseMapper;
    }

    @GetMapping
    public ResponseEntity findAll(){
        return ResponseEntity.ok(
             franchiseMapper.franchiseToFranchiseDTO(franchiseService.findAll())
        );
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable int id){
        return ResponseEntity.ok(franchiseMapper.
                franchiseToFranchiseDTO(
                        franchiseService.findById(id)
                )
        );
    }

    @PostMapping
    public ResponseEntity add(@RequestBody FranchiseDTO entity) throws URISyntaxException{

        franchiseService.add(franchiseMapper.franchiseDTOtoFranchise(entity));
        URI uri = new URI("ap1/franchises/"+entity.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("{id}")
    public ResponseEntity update(@RequestBody FranchiseDTO entity, @PathVariable int id){
        if(id!= entity.getId())
            return ResponseEntity.badRequest().build();
        franchiseService.update(franchiseMapper.franchiseDTOtoFranchise(entity));
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable int id){
        franchiseService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("{id}/movies")
    public ResponseEntity updateMovies(@PathVariable int id, @RequestBody int[] movieIds){

        franchiseService.updateMovies(id,movieIds);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("{id}/characters")
    public ResponseEntity getAllFranchiseCharacters(@PathVariable int id){
        //will change
        return ResponseEntity.noContent().build();
    }
}
