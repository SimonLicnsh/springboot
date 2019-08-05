package com.mystudy.springboot;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Map;

@Component
@PropertySource("classpath:/static/test.yml")
@ConfigurationProperties(prefix = "currency")
@Configuration
public class MyConfig {

    private List<Map<String, String>> dataSource;

    public List<Map<String, String>> getDataSource() {
        return dataSource;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
