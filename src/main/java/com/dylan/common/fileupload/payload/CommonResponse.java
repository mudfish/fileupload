package com.dylan.common.fileupload.payload;

public class CommonResponse
{
    private Boolean success;
    private String message;
    private Object data;
    
    public CommonResponse( Boolean success,  String message,  Object data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }
    
    public Boolean getSuccess() {
        return this.success;
    }
    
    public void setSuccess( Boolean success) {
        this.success = success;
    }
    
    public String getMessage() {
        return this.message;
    }
    
    public void setMessage( String message) {
        this.message = message;
    }
    
    public Object getData() {
        return this.data;
    }
    
    public void setData( Object data) {
        this.data = data;
    }
}
