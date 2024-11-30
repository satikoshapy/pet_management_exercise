package be.pxl.pets.exceptions;

// TODO this should be a checked exception resulting in a bad request

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Pet too tired")
public class PetTooTiredException extends Exception {

    public PetTooTiredException() {
        super("Pet too tired");
    }

    public PetTooTiredException(String message) {
        super(message);
    }
}
