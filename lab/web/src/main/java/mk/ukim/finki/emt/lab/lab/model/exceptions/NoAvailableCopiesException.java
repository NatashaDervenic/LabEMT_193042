package mk.ukim.finki.emt.lab.lab.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NoAvailableCopiesException extends RuntimeException{
    public NoAvailableCopiesException(){
        super("No more available copies!");
    }

}