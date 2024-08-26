package doo.gym.academyproject.B_useCases.dto;

import doo.gym.academyproject.B_useCases.service.APIRequest;
import org.springframework.http.ResponseEntity;

public interface APIClient {
    ResponseEntity<String> sendRequest(String url, APIRequest request);
}
