package app.resources.web.exceptions;

import app.resources.services.exceptions.DataBaseException;
import app.resources.services.exceptions.ResourceNotFoundExecption;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
// anotaçao spring que vai interceptar as excepçoes que acontecem para que o objeto executre um possivel tratamento
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundExecption.class) // para quando der a excepçao cair aqui
    public ResponseEntity<StandarError> resourceNotFound(ResourceNotFoundExecption e, HttpServletRequest request) {

        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandarError err = new StandarError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);

    }

    @ExceptionHandler(DataBaseException.class) // para quando der a excepçao cair aqui
    public ResponseEntity<StandarError> database(DataBaseException e, HttpServletRequest request) {

        String error = "Data base error";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandarError err = new StandarError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);

    }

}
