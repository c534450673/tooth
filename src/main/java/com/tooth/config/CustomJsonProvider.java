package com.tooth.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJsonProvider;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.ext.Provider;

/**
 * @author subo.zhang
 * @date 2018年04月04日
 * @company own
 **/
@Provider
public class CustomJsonProvider extends JacksonJsonProvider {

    @Autowired
    private ObjectMapper mapper ;

    @Override
    public void setMapper(ObjectMapper m) {
        setMapper(mapper);
    }

}
