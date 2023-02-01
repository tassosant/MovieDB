package tasos.ass_3.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class MovieCharacterNotFoundException extends EntityNotFoundException {
    public MovieCharacterNotFoundException(int id) {
        super("Movie's character does not exist with ID: "+id);
    }
}
