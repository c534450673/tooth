package com.tooth.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author subo.zhang
 * @date 2018年04月04日
 * @company own
 **/
@Getter
@Setter
@Component
@ConfigurationProperties(value = "http.client")
@Primary
public class HttpClientProperties {

    private int timeToLive;
    private int maxTotal;
    private int defaultMaxPerRoute;
    private int retryHandler;
    private boolean isRetry;
    private int connectionRequestTimeout;
    private int connectTimeout;
    private int readTimeout;

}
