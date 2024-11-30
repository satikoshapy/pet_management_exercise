package be.pxl.pets.exceptions;

// TODO this should be a checked exception resulting in a bad request

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Pet too hungry")
public class PetTooHungryException extends Exception {

    public PetTooHungryException() {
        super("Pet too hungry");
    }

    public PetTooHungryException(String message) {
        super(message);
    }
}
