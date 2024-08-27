package doo.gym.academyproject.B_useCases.interfaces;

import doo.gym.academyproject.B_useCases.service.request.APIRequest;
import org.springframework.http.ResponseEntity;

public interface APIClientDAO {
    ResponseEntity<String> sendRequest(String url, APIRequest request);
}
