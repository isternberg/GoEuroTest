package com.goeuro.data;

import com.goeuro.entities.GoEuroData;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static com.goeuro.Application.BASE_PATH;

@Component
public class GoEuroConsumer{

    public static final HttpEntity<?> REQUEST_ENTITY = null;

    public List<GoEuroData> getFor(String arg) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<GoEuroData>> data =
            restTemplate.exchange(BASE_PATH + arg,
                    HttpMethod.GET, REQUEST_ENTITY,
                    new ParameterizedTypeReference<List<GoEuroData>>() {});
        return data.getBody();
    }
}
