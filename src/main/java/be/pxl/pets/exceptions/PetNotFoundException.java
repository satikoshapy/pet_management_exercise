package be.pxl.pets.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// TODO this should be an unchecked exception resulting in a NOT_FOUND http response status
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Pet not found")
public class PetNotFoundException extends RuntimeException {

    // Default constructor
    public PetNotFoundException() {
        super("Pet not found");
    }

    // Constructor that accepts a custom message
    public PetNotFoundException(String message) {
        super(message);
    }
}
