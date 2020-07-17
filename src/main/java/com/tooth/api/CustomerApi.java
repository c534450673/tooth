package com.tooth.api;

import com.tooth.dto.ResponseDTO;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/customer")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
@Component
public class CustomerApi {

    @POST
    @Path(value = "/add")
    public ResponseDTO<Boolean> addCustomerInfo(){
        return null;
    }

}
