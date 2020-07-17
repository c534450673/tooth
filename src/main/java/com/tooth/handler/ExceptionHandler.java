package com.tooth.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tooth.constants.Code;
import com.tooth.constants.Message;
import com.tooth.dto.ResponseDTO;
import com.tooth.exception.BaseException;
import org.glassfish.jersey.media.multipart.FormDataParamException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.NotAllowedException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.NotSupportedException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * 统一异常处理
 *
 * @author subo.zhang
 *         2017年5月15日 上午10:39:58
 */
@Provider
public class ExceptionHandler implements ExceptionMapper<Exception> {

    private Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private ObjectMapper mapper;

    @Override
    public Response toResponse(Exception exception) {
        ResponseDTO<String> response = new ResponseDTO<>(Code.SYSTEM_ERROR.value(), Message.SYSTEM_ERROR.value());
        if (exception instanceof BaseException) {
            BaseException bException = (BaseException) exception;
            response.setCode(bException.getErrorCode());
            response.setSubCode(bException.getSubErrorCode());
            response.setMessage(bException.getErrorMessage());
        }else{
            LOG.error(exception.getMessage(), exception);
            if (exception instanceof NotAllowedException) {
                // 405异常
                return Response.status(405).entity(exception.getMessage()).build();
            } else if (exception instanceof NotFoundException) {
                // 404异常
                return Response.status(404).entity(exception.getMessage()).build();
            }else if(exception instanceof NotSupportedException){
                return Response.status(415).entity(exception.getMessage()).build();
            } else if(exception instanceof FormDataParamException){
                return Response.status(400).entity(exception.getMessage()).build();
            }
        }
        String result;
        try {
            result = mapper.writeValueAsString(response);
        } catch (JsonProcessingException e) {
            LOG.error(e.getMessage(), e);
            return Response.status(response.getCode()).entity(Message.SYSTEM_ERROR.value()).build();
        }
        return Response.ok(result).build();
    }

}
