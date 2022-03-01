package br.com.rpires.TesteSDKCognite.demo.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestHandlerException extends ResponseEntityExceptionHandler {

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<Object> handleBadRequest(BadRequestException e) {
        ApiError api = new ApiError();
        api.setMessage(e.getMessage());
        api.setStatus(e.getHttpStatus());
        return new ResponseEntity<>(api, api.getStatus());
    }

    @ExceptionHandler({IntegrationException.class})
    public ResponseEntity<Object> handleIntegrationException(IntegrationException e) {
        ApiError api = new ApiError();
        api.setMessage(e.getMessage());
        api.setStatus(e.getHttpStatus());
        return new ResponseEntity<>(api, api.getStatus());
    }
}
