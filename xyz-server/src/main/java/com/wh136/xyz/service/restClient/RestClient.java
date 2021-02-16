package com.wh136.xyz.service.restClient;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.util.Map;

@Component
@PropertySource(value = "classpath:config/bigScreen.properties")
public class RestClient {

    @Resource
    private RestTemplate restTemplate;

    @Value("${bigScreen.server.ip}")
    private String ip;

    @Value("${bigScreen.server.port}")
    private String port;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }


    public <T> ResponseEntity<T> exchange(String url, HttpMethod method, HttpEntity<?> requestEntity,
                                          ParameterizedTypeReference<T> responseType) {
        return restTemplate.exchange(buildUrl(url), method, requestEntity, responseType);
    }

    public <T> ResponseEntity<T> exchange(String url, HttpMethod method, HttpEntity<?> requestEntity,
                                          ParameterizedTypeReference<T> responseType, Map<String, ?>uriVariables) {
        return restTemplate.exchange(buildUrl(url), method, requestEntity, responseType, uriVariables);
    }

    /**GET method*/
    public <T> ResponseEntity<T> get(String url, ParameterizedTypeReference<T> responseType) {
        return exchange(url, HttpMethod.GET, getHttpEntity(), responseType);
    }

    public <T> ResponseEntity<T> get(String url, ParameterizedTypeReference<T> responseType, Map<String, ?>uriVariables) {
        return exchange(url, HttpMethod.GET, getHttpEntity(), responseType, uriVariables);
    }

    /**POST method*/
    public <T> ResponseEntity<T> post(String url, HttpEntity<?> requestEntity, ParameterizedTypeReference<T> responseType) {
        return exchange(url, HttpMethod.POST, requestEntity, responseType);
    }

    public <T> ResponseEntity<T> post(String url, Object body, ParameterizedTypeReference<T> responseType) {
        HttpEntity<Object> entity = getHttpEntity(body);
        return post(url, entity, responseType);
    }


    private HttpEntity<String> getHttpEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        return new HttpEntity<>(headers);
    }

    private HttpEntity<Object> getHttpEntity(Object body) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_UTF8_VALUE);
        return new HttpEntity<>(body, headers);
    }

    private String buildUrl(String uri) {
        return "http://" + ip + ":" + port + uri;
    }

}
