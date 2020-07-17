package com.tooth.config;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author subo.zhang
 * @date 2018年04月04日
 * @company own
 **/
@Configuration
public class RestTemplateConfig {

    @Autowired
    private HttpClientProperties httpClientProperties;

    @Bean
    public HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory() {
        // 长连接保持30秒
        PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager(httpClientProperties.getTimeToLive(), TimeUnit.SECONDS);
        // 总连接数
        poolingHttpClientConnectionManager.setMaxTotal(httpClientProperties.getMaxTotal());
        // 同路由的并发数
        poolingHttpClientConnectionManager.setDefaultMaxPerRoute(httpClientProperties.getDefaultMaxPerRoute());
        HttpClientBuilder httpClientBuilder = HttpClients.custom();
        httpClientBuilder.setConnectionManager(poolingHttpClientConnectionManager);
        httpClientBuilder.setRetryHandler(new DefaultHttpRequestRetryHandler(httpClientProperties.getRetryHandler(), httpClientProperties.isRetry()));
        HttpClient httpClient = httpClientBuilder.build();
        HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
        // 连接不够用的等待时间，不宜过长，必须设置，比如连接不够用时，时间过长将是灾难性的
        httpComponentsClientHttpRequestFactory.setConnectionRequestTimeout(httpClientProperties.getConnectionRequestTimeout());
        // 连接超时
        httpComponentsClientHttpRequestFactory.setConnectTimeout(httpClientProperties.getConnectTimeout());
        // 数据读取超时时间，即SocketTimeout
        httpComponentsClientHttpRequestFactory.setReadTimeout(httpClientProperties.getReadTimeout());
        return httpComponentsClientHttpRequestFactory;
    }

    @Bean
    public RestTemplate customRestTemplate() {
        RestTemplate restTemplate = new RestTemplate(httpComponentsClientHttpRequestFactory());
        /*
         * 初始化RestTemplate，RestTemplate会默认添加HttpMessageConverter
         * 添加的StringHttpMessageConverter非UTF-8
         * 所以先要移除原有的StringHttpMessageConverter，
         * 再添加一个字符集为UTF-8的StringHttpMessageConvert
         * */
        List<HttpMessageConverter<?>> converterList = restTemplate.getMessageConverters();
        for (int i = 0; i < converterList.size(); i++) {
            HttpMessageConverter<?> messageConverter = converterList.get(i);
            if (messageConverter.getClass() == StringHttpMessageConverter.class) {
                restTemplate.getMessageConverters().remove(messageConverter);
                HttpMessageConverter<?> converter = new StringHttpMessageConverter(StandardCharsets.UTF_8);
                restTemplate.getMessageConverters().set(i, converter);
                break;
            }
        }
        return restTemplate;
    }
}
