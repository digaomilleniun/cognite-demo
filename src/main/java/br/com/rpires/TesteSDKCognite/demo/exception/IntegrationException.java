package br.com.rpires.TesteSDKCognite.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

public class IntegrationException extends RuntimeException {

    private HttpStatus httpStatus;

    public IntegrationException(String message, Exception e) {
        super(message,e);
        if (e instanceof HttpClientErrorException) {
            httpStatus = ((HttpClientErrorException) e).getStatusCode();
        } else {

            if (e.getMessage().contains(HttpStatus.BAD_REQUEST.name())) {
                httpStatus = HttpStatus.BAD_REQUEST;
            } else if (e.getMessage().contains(HttpStatus.FORBIDDEN.name())) {
                httpStatus = HttpStatus.FORBIDDEN;
            } else {
                httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            }


        }
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
