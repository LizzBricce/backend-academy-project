package doo.gym.academyproject.B_useCases.dto;

import doo.gym.academyproject.B_useCases.service.APIRequest;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class APIClientImpl implements APIClient {

    private final RestTemplate restTemplate;

    public APIClientImpl() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public ResponseEntity<String> sendRequest(String url, APIRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<APIRequest> requestEntity = new HttpEntity<>(request, headers);
        return restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
    }
}
