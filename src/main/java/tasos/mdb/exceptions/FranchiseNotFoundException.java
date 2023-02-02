package tasos.mdb.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class FranchiseNotFoundException extends EntityNotFoundException {
    public FranchiseNotFoundException(int id) {
        super("Franchise does not exist with ID: "+id);
    }
}
