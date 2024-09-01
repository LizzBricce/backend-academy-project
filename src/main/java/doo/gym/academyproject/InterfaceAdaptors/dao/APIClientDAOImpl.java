package doo.gym.academyproject.InterfaceAdaptors.dao;

import doo.gym.academyproject.UseCase.interfacesDAO.APIClientDAO;
import doo.gym.academyproject.UseCase.service.request.APIRequest;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Classe que implementa o metodo de requisição definido por APIClientDAO
 */
@Component
public class APIClientDAOImpl implements APIClientDAO {

    private final RestTemplate restTemplate;

    public APIClientDAOImpl() {
        this.restTemplate = new RestTemplate();
    }

    /**
     * Envia uma requisicao HTTP POST para url da api com o corpo da requisição e devolve a resposta
     */
    @Override
    public ResponseEntity<String> sendRequest(String url, APIRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<APIRequest> requestEntity = new HttpEntity<>(request, headers);
        return restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
    }
}
