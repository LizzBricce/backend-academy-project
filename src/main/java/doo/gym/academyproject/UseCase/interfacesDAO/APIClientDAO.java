package doo.gym.academyproject.UseCase.interfacesDAO;

import doo.gym.academyproject.UseCase.service.request.APIRequest;
import org.springframework.http.ResponseEntity;

public interface APIClientDAO {
    ResponseEntity<String> sendRequest(String url, APIRequest request);
}
