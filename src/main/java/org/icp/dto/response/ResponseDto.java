package org.icp.dto.response;

import java.util.Date;

public class ResponseDto {
    private String message;
    private int code;
    private Object data;
    private Date timestamp;

    public ResponseDto() {}

    public ResponseDto(String message, int code, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.timestamp = new Date();
    }

    public ResponseDto(String message, int code) {
        this.code = code;
        this.message = message;
        this.timestamp = new Date();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
