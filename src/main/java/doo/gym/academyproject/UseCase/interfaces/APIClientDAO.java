package doo.gym.academyproject.UseCase.interfaces;

import doo.gym.academyproject.UseCase.service.request.APIRequest;
import org.springframework.http.ResponseEntity;

public interface APIClientDAO {
    ResponseEntity<String> sendRequest(String url, APIRequest request);
}
