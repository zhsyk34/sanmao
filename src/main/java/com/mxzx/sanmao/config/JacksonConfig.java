package com.mxzx.sanmao.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.*;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@Configuration
@Slf4j
public class JacksonConfig {

    @Bean
    public Module module(PageSerializer pageSerializer) {
        return new SimpleModule().addSerializer(pageSerializer);
    }

    //    @Bean
//    @Primary
    public ObjectMapper jsonObjectMapper() {
        return Jackson2ObjectMapperBuilder
                .json()
                .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .build();
    }

    //    @Primary
//    @Bean
    public ObjectMapper mapper(List<Module> modules) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);

        Optional.ofNullable(modules).ifPresent(ms -> ms.forEach(mapper::registerModule));

        return mapper;
    }

    //    @Bean
    public Jackson2ObjectMapperBuilder objectMapperBuilder(List<Module> modules) {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder() {
            @Override
            public void configure(ObjectMapper objectMapper) {
                super.configure(objectMapper);

                logger.info(">>>>>>>>>>>>>>>modules size:{}", modules.size());

                for (Module module : modules) {
                    System.err.println(module.getClass());

                    if (module instanceof SimpleModule) {
                        objectMapper.registerModule(module);
                    }
                }
//                modules.forEach(objectMapper::registerModule);
            }
        };

        builder.serializationInclusion(JsonInclude.Include.NON_NULL);

        return builder;
    }

    //    @Bean
    public Jackson2ObjectMapperBuilderCustomizer builderCustomizer(PageSerializer pageSerializer) {
        return jacksonObjectMapperBuilder -> {
            ObjectMapper mapper = new ObjectMapper();

            mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);

            SimpleModule module = new SimpleModule().addSerializer(pageSerializer);
            mapper.registerModule(module);

            jacksonObjectMapperBuilder.configure(mapper);
        };
    }

    @Bean
    @Primary
    public MappingJackson2HttpMessageConverter converter() {
        return new MappingJackson2HttpMessageConverter() {
            @Override
            protected void writeInternal(Object object, Type type, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
                ObjectMapper mapper = super.getObjectMapper();
                String result = mapper.writeValueAsString(object);
                System.err.println(result);
            }
        };
    }
}
