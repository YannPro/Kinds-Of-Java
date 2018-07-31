package com.yannyao.demo.yimo.filter;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.yannyao.demo.yimo.Exception.ApiErrors;
import com.yannyao.demo.yimo.Exception.BaseErrors;
import com.yannyao.demo.yimo.Exception.BusinessException;
import com.yannyao.demo.yimo.response.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import sun.misc.BASE64Encoder;

import javax.annotation.Resource;
import javax.validation.ValidationException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by jsm on 2017/5/11.
 */
@EnableWebMvc
@ControllerAdvice
@ResponseBody
public class ErrorHandler {


    private final static Logger logger = LoggerFactory.getLogger(ErrorHandler.class);

    @ExceptionHandler(BusinessException.class)
    public BaseResponse handlerBusinessException(BusinessException e) {
        logger.error(e.getErrMsg(), e);
        BaseResponse resp = new BaseResponse(e);
        return resp;
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public BaseResponse handlerException(HttpMessageNotReadableException e) {
        logger.error("错误", e);
        BaseResponse resp = new BaseResponse(BaseErrors.JSON_FORMAT_ERROR);
        return resp;
    }

    @ExceptionHandler(JsonParseException.class)
    public BaseResponse handlerException(JsonParseException e) {
        logger.error("json格式错误", e);
        BaseResponse resp = new BaseResponse(BaseErrors.JSON_FORMAT_ERROR);
        return resp;
    }

    @ExceptionHandler(InvalidFormatException.class)
    public BaseResponse handlerException(InvalidFormatException e) {
        logger.error("错误", e);
        BaseResponse resp = new BaseResponse(BaseErrors.JSON_FORMAT_ERROR);
        return resp;
    }

    @ExceptionHandler(ValidationException.class)
    public BaseResponse handlerValidationException(ValidationException e) {
        logger.error(e.getCause().getMessage(), e);
        BaseResponse resp = new BaseResponse((ApiErrors) e.getCause());
        return resp;
    }

    @ExceptionHandler(Exception.class)
    public BaseResponse handlerException(Exception e) {
        logger.error("SYS_ERROR", e);
        BaseResponse resp = new BaseResponse(BaseErrors.SERVER_ERROR.setArgs(e.getMessage()).setEmArgs("服务器出小差了~"));
//        sendError(e.getMessage(),e.printStackTrace());

        return resp;
    }




}
