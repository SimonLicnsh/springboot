package com.mystudy.springboot;

import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.DefaultPropertySourceFactory;
import org.springframework.core.io.support.EncodedResource;
import java.io.IOException;

public class YamlPropertySourceFactory extends DefaultPropertySourceFactory {


    @Override
    public PropertySource<?> createPropertySource(String name, EncodedResource resource) throws IOException {

        if (null == resource) {
            super.createPropertySource(name, resource);
        }
        return new YamlPropertySourceLoader().load(resource.getResource().getFilename(), resource.getResource()).get(0);
    }

}

