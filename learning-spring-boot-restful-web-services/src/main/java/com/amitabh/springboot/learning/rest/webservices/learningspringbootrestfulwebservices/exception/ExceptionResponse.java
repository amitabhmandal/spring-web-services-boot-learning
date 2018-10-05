package com.amitabh.springboot.learning.rest.webservices.learningspringbootrestfulwebservices.exception;

import java.util.Date;

public class ExceptionResponse {

    
    private Date timeStamp;
    private String exceptionMessage;
    private String userSpecificDetails;
    
    public Date getTimeStamp() {
        return timeStamp;
    }
    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
    public String getExceptionMessage() {
        return exceptionMessage;
    }
    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }
    public String getUserSpecificDetails() {
        return userSpecificDetails;
    }
    public void setUserSpecificDetails(String userSpecificDetails) {
        this.userSpecificDetails = userSpecificDetails;
    }
    public ExceptionResponse(Date timeStamp2, String message, String description) {
        super();
        this.timeStamp = timeStamp2;
        this.exceptionMessage = message;
        this.userSpecificDetails = description;
        // TODO Auto-generated constructor stub
    }
    
    
    

}
