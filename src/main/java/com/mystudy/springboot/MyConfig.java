package com.mystudy.springboot;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.Map;

@Component
@PropertySource(value = "classpath:/static/test.yml", factory = YamlPropertySourceFactory.class)
@ConfigurationProperties(prefix = "currency")
@Configuration
public class MyConfig {

    private Map<String, Map<String, Object>> dataSource;

    public Map<String, Map<String, Object>> getDataSource() {
        return dataSource;
    }

    public void setDataSource(Map<String, Map<String, Object>> dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
