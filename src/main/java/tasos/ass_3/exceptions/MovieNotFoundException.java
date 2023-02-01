package tasos.ass_3.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class MovieNotFoundException extends EntityNotFoundException {
    public MovieNotFoundException(int id) {
        super("Movie does not exist with ID: "+id);
    }
}
