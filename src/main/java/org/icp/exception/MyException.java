package org.icp.exception;

import jakarta.ws.rs.core.Response;

public class MyException extends Exception{
    private final Response response;

    public MyException(String message, Response response) {
        super(message);
        this.response = response;
    }

    public Response getResponse() {
        return response;
    }
}
