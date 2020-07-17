package com.tooth.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tooth.constants.Code;
import com.tooth.constants.Message;
import com.tooth.constants.SubCode;
import com.tooth.dto.ResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.Set;

/**
 * 验证失败 处理
 * Created by subo.zhang on 2017/6/9.
 */
@Provider
public class ValidationHandler implements ExceptionMapper<ConstraintViolationException> {

    private final Logger LOG = LoggerFactory.getLogger(getClass().getName());

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public Response toResponse(ConstraintViolationException exception) {
        Set<ConstraintViolation<?>> constraintViolations = exception.getConstraintViolations();
        ResponseDTO response = new ResponseDTO<>(Code.PARAMETER_VERIFY_FAILED.value(), Message.PARAMS_VALIDATION_FAILED.value());
        response.setSubCode(SubCode.PARAMETERS_FAILED.value());
        response.setMessage(formatMessage(constraintViolations));
        String result;
        try {
            result = objectMapper.writeValueAsString(response);
        } catch (JsonProcessingException e) {
            LOG.error(e.getMessage(), e);
            return Response.status(Code.SYSTEM_ERROR.value()).entity(Message.SYSTEM_ERROR.value()).build();
        }
        return Response.ok(result).build();
    }

    /**
     * 格式化验证信息
     *
     * @param constraintViolations
     * @return
     */
    private String formatMessage(Set<ConstraintViolation<?>> constraintViolations) {
        StringBuilder str = new StringBuilder();
        if (constraintViolations == null || constraintViolations.size() < 1) {
            return str.toString();
        }

        int i = 0;
        for (ConstraintViolation<?> constraintViolation : constraintViolations) {
            str.append(constraintViolation.getMessage());
            if (i < constraintViolations.size() - 1) {
                str.append(";");
            }
            i++;
        }
        return str.toString();
    }
}
