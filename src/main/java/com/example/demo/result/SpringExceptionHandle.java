package com.example.demo.result;

import org.apache.ibatis.datasource.DataSourceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.net.BindException;
import java.net.ConnectException;
import java.sql.SQLException;

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

    @ExceptionHandler(value = NoHandlerFoundException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public Response badRequestNotFound(){
        logger.error("404 错误");
        return new Response(UnicomResponseEnums.NOT_FOUND.getCode(),UnicomResponseEnums.NOT_FOUND.getMsg());
    }

    @ExceptionHandler(value = {SQLException.class, DataAccessException.class})
    @ResponseBody
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public Response databaseException(){
        logger.error("数据库异常");
        return new Response(UnicomResponseEnums.DATABASE_ERROR.getCode(),UnicomResponseEnums.DATABASE_ERROR.getMsg());
    }

    @ExceptionHandler(value = ConnectException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
    public Response connect(){
        logger.error("连接异常");
        return new Response(UnicomResponseEnums.CONNECTION_ERROR.getCode(),UnicomResponseEnums.CONNECTION_ERROR.getMsg());
    }

}
