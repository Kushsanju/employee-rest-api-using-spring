package rancom.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class ResourceNotFoundeException extends RuntimeException{
    private static final long serialVersionUID= 1L;
    public ResourceNotFoundeException(String message){
        super(message);
    }

}
