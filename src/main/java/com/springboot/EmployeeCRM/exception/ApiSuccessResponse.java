package com.springboot.EmployeeCRM.exception;

public class ApiSuccessResponse extends ApiResponse{
    Object responseObject;

    public ApiSuccessResponse(boolean success,String error, Object responseObject){
        super(success,error);
        this.responseObject=responseObject;
    }

    public Object getResponseObject() {
        return responseObject;
    }

    public void setResponseObject(Object responseObject) {
        this.responseObject = responseObject;
    }
}
