package com.mystudy.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {

    @Autowired
    private MyConfig config;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/result/{name}")
    public Response result(@PathVariable("name") String name) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);

//        String localIp = config.getDataSource().get(name).get("localIp");
//        String outerIp = config.getDataSource().get(name).get("outerIp");
//
//        Response body = restTemplate.getForEntity(localIp + "/.../{name}", Response.class, params).getBody();
//        Response body1 = restTemplate.getForEntity(outerIp + "/.../{name}", Response.class, params).getBody();

        return new Response();
    }
}
