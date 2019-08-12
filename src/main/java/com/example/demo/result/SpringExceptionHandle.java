package com.example.demo.result;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.BindException;

@RestControllerAdvice(annotations = {RestController.class, Controller.class})
public class SpringExceptionHandle {

    private static final Logger logger = LoggerFactory.getLogger(SpringExceptionHandle.class);

    @ExceptionHandler(value={BindException.class})
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public Response badRequest(BindException bind){
        logger.error("参数类型有误！"+bind.getMessage());
        return new Response(UnicomResponseEnums.BAD_REQUEST.getCode(),UnicomResponseEnums.BAD_REQUEST.getMsg());
    }


}
