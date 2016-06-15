package com.mrncontracting.mrnknocker.dtos;


import java.io.Serializable;

/**
 * Created by Alyssa on 4/30/2016.
 */
public class DTO_Base implements Serializable{

    public String Exception = null;
    public String InnerException = null;
    public String Message = null;
    public boolean SuccessFlag = false;

    public String getException() {
        return Exception;
    }

    public void setException(String exception) {
        Exception = exception;
    }

    public String getInnerException() {
        return InnerException;
    }

    public void setInnerException(String innerException) {
        InnerException = innerException;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public boolean isSuccessFlag() {
        return SuccessFlag;
    }

    public void setSuccessFlag(boolean successFlag) {
        SuccessFlag = successFlag;
    }
}
