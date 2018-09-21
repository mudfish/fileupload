package com.dylan.common.fileupload.exception;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MyFileNotFoundException extends RuntimeException
{
    private static final long serialVersionUID = 1L;
    
    public MyFileNotFoundException( String message) {
        super(message);
    }
    
    public MyFileNotFoundException( String message,  Throwable cause) {
        super(message, cause);
    }
}
