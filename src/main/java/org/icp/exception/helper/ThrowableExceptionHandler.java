package org.icp.exception.helper;

import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.icp.dto.exception.ExceptionDto;
import org.icp.helper.MyResponse;

@Provider
public class ThrowableExceptionHandler implements ExceptionMapper<Throwable> {
    @Override
    public Response toResponse(Throwable exception) {
        ExceptionDto exceptionDto = new ExceptionDto(exception.getClass().getName(), exception.getMessage());

        if (exception instanceof NotFoundException) return MyResponse.notFound(exceptionDto);
        else if (exception instanceof WebApplicationException) return MyResponse.badRequest(exceptionDto);
        return MyResponse.internalServerError(exceptionDto);
    }
}
