package app.resources.web.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.Instant;

public class StandarError implements Serializable {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant timeStamp;
    private Integer Status;
    private String error;
    private String message;
    private String path;

    public StandarError() {

    }

    public StandarError(Instant timeStamp, Integer status, String error, String message, String path) {
        this.timeStamp = timeStamp;
        Status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    public Instant getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Instant timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Integer getStatus() {
        return Status;
    }

    public void setStatus(Integer status) {
        Status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
