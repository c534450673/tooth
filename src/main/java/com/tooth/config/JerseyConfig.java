package com.tooth.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

/**
 * @author subo.zhang
 * @description
 * @date 2020/7/16
 * @company 和合信诺
 */
@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        packages("com.tooth.*");
    }
}
