package com.tooth.config;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class JacksonConfig {

    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static ObjectMapper objectMapperInstance;

    /**
     * jackson objectMapper注入及配置
     *
     * @return ObjectMapper
     */
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addDeserializer(LocalDateTime.class,
                new LocalDateTimeDeserializer(FORMATTER))
                .addSerializer(new LocalDateTimeSerializer(FORMATTER));

        mapper.registerModule(javaTimeModule)
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                //不序列化null和""
                .setSerializationInclusion(Include.NON_NULL)
                .setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"))
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapperInstance = mapper;
        return mapper;
    }

    public static ObjectMapper getObjectMapperInstance(){
        return objectMapperInstance;
    }

}
