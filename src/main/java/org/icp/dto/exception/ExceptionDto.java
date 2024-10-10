package org.icp.dto.exception;

import java.io.Serializable;

public class ExceptionDto implements Serializable {
    private String className;
    private String message;

    public ExceptionDto() {
    }

    public ExceptionDto(String message) {
        this.message = message;
    }

    public ExceptionDto(String className, String cause) {
        this.className = className;
        this.message = cause;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ExceptionDto{" +
                "className='" + className + '\'' +
                ", cause='" + message + '\'' +
                '}';
    }
}