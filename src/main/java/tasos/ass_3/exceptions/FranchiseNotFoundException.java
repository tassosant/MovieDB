package tasos.ass_3.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class FranchiseNotFoundException extends EntityNotFoundException {
    public FranchiseNotFoundException(int id) {
        super("Franchise does not exist with ID: "+id);
    }
}
