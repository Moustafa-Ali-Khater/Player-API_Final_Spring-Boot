package com.spring.playerapi.config;


import com.spring.playerapi.model.Player;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

@org.springframework.context.annotation.Configuration
public class Configuration implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config);
        HttpMethod[] prevenMethod = {HttpMethod.GET, HttpMethod.POST, HttpMethod.PUT, HttpMethod.DELETE};

        config.getExposureConfiguration().forDomainType(Player.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(prevenMethod))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(prevenMethod));
    }
}
