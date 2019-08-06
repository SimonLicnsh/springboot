package com.mystudy.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
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
        // 根据币种名获取数据源ip
        String localIp = config.getDataSource().get(name).get("localIp") + "";
        String outerIp = config.getDataSource().get(name).get("outerIp") + "";

        // 请求传递的参数
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);

        // 请求数据源获取数据
        Response response1, response2;
        if (StringUtils.isEmpty(localIp)) {
            response1 = restTemplate.getForEntity(localIp + "/.../{name}", Response.class, params).getBody();
        }
        if (!StringUtils.isEmpty(outerIp)) {
            response2 = restTemplate.getForEntity(outerIp + "/.../{name}", Response.class, params).getBody();
        }

        // 返回数据处理
        // TODO

        return new Response();
    }
}
