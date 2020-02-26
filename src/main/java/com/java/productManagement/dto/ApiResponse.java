package com.java.productManagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class ApiResponse implements Serializable  {
    @JsonProperty("dataResponse")
    private Object object;
    private boolean successful;
    private String message;
    private List<Error> errorList;

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public boolean getSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Error> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<Error> errorList) {
        this.errorList = errorList;
    }
}
