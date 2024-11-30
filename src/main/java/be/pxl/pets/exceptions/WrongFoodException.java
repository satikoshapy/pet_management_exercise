package be.pxl.pets.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// TODO this should be an unchecked exception resulting in a bad request
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Wrong food")
public class WrongFoodException extends RuntimeException {

    public WrongFoodException() {
        super("Wrong food");
    }

    public WrongFoodException(String message) {
        super(message);
    }
}
