package org.icp.exception.helper;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.icp.exception.MyException;

@Provider
public class MyExceptionHandler extends Throwable implements ExceptionMapper<MyException> {
    @Override
    public Response toResponse(MyException exception) {
        return exception.getResponse();
    }
}
