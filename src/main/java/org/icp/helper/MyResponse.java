package org.icp.helper;

import jakarta.ws.rs.core.Response;
import org.icp.dto.response.ResponseDto;

public class MyResponse {
    public enum Status {
        OK {
            @Override
            public String getMessage() {
                return "OK";
            }

            @Override
            public int getCode() {
                return 200;
            }
        },

        BAD_REQUEST {
            @Override
            public String getMessage() {
                return "BAD_REQUEST";
            }

            @Override
            public int getCode() {
                return 400;
            }
        },

        INTERNAL_SERVER_ERROR {
            @Override
            public String getMessage() {
                return "INTERNAL_SERVER_ERROR";
            }

            @Override
            public int getCode() {
                return 500;
            }
        },

        NOT_FOUND{
            @Override
            public String getMessage() {
                return "NOT_FOUND";
            }

            @Override
            public int getCode() {
                return 404;
            }
        },

        UNAUTHORIZED {
            @Override
            public String getMessage() {
                return "UNAUTHORIZED";
            }

            @Override
            public int getCode() {
                return 401;
            }
        };

        public abstract String getMessage();
        public abstract int getCode();

    }

    public static Response ok(Object data) {
        return Response
                .ok(new ResponseDto(Status.OK.getMessage(), Status.OK.getCode(), data)).build();
    }

    public static Response badRequest(Object data) {
        return Response
                .status(Status.BAD_REQUEST.getCode()).entity(new ResponseDto(Status.BAD_REQUEST.getMessage(), Status.BAD_REQUEST.getCode(), data))
                .build();
    }

    public static Response internalServerError(Object data) {
        return Response
                .serverError()
                .entity(new ResponseDto(Status.INTERNAL_SERVER_ERROR.getMessage(), Status.INTERNAL_SERVER_ERROR.getCode(), data))
                .build();
    }

    public static Response notFound(Object data) {
        return Response
                .ok(new ResponseDto(data + " data not found", Status.NOT_FOUND.getCode()))
                .build();
    }
}
