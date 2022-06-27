package com.example.comic.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.support.HttpRequestWrapper;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.stream.Stream;

public class LLRestTemplate {

    private RestTemplate restTemplate;

    public LLRestTemplate(){
        restTemplate = new RestTemplateBuilder().build();
    }

    public String post(String url, String[] headers, String body){
        HttpHeaders h = new HttpHeaders();
        for(int i=0, length = headers.length; i < length; i+=2){
            h.add(headers[i], headers[i+1]);
        }
        ResponseEntity<String> resp = restTemplate.postForEntity(url, new HttpEntity(body, h), String.class);
        return resp.getBody();
    }


    public String get(String url, String[] headers){
        HttpHeaders h = new HttpHeaders();
        for(int i=0, length = headers.length; i < length; i+=2){
            h.add(headers[i], headers[i+1]);
        }
        ResponseEntity<String> resp = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity(h), String.class);
        return resp.getBody();
    }


}
