package com.deepak.full_stack_springboot.config;

import com.deepak.full_stack_springboot.entity.Book;
import com.deepak.full_stack_springboot.entity.Review;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;


@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    private String allowedOrigins = "http://localhost:3000";
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {

        HttpMethod[] httpMethods = {
                                        HttpMethod.POST,
                                        HttpMethod.DELETE,
                                        HttpMethod.PUT,
                                        HttpMethod.PATCH
                                    };

        config.exposeIdsFor(Book.class);
        config.exposeIdsFor(Review.class);

        disableHttpMethods(Book.class, config, httpMethods);
        disableHttpMethods(Review.class, config, httpMethods);

        /*
         * Configure CORS Mapping
         */

        cors.addMapping(config.getBasePath() + "/**")
                .allowedOrigins(allowedOrigins);
    }

    private void disableHttpMethods(Class clazz,
                                    RepositoryRestConfiguration config,
                                    HttpMethod[] unsupportedActions) {

        config.getExposureConfiguration()
                .forDomainType(clazz)
                .withItemExposure((metadata, httpMethods) -> httpMethods.disable(unsupportedActions))
                .withCollectionExposure((metadata, httpMethods) -> httpMethods.disable(unsupportedActions));

    }
}
