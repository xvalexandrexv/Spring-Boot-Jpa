package app.resources.services.exceptions;

public class ResourceNotFoundExecption extends RuntimeException {

    public ResourceNotFoundExecption(Object id) {
        super("Resource not found. Id " + id);
    }

}
