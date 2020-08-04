package com.tooth.api;

import com.tooth.api.vo.ManagerInfo;
import com.tooth.dto.ResponseDTO;
import com.tooth.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@Path("/manager")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
@Controller
@Validated
public class ManagerApi {

    @Autowired
    private ManagerService managerService;

    @Path(value = "/register")
    @POST
    public ResponseDTO<Boolean> register(@Valid ManagerInfo managerInfo) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        return new ResponseDTO<>(managerService.registerManager(managerInfo));
    }
}
