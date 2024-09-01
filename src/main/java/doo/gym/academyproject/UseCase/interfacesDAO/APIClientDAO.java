package doo.gym.academyproject.UseCase.interfacesDAO;

import doo.gym.academyproject.UseCase.service.request.APIRequest;
import org.springframework.http.ResponseEntity;
/**
 * Interface de APIClientDAOImpl, esta na camada de UseCase para ser usada pelas classes de serviço sem romper as camadas
 * a implementação fica na camada acima para estar mais proxima de um possivel banco de dados e para facilitar a manutenção
 */
public interface APIClientDAO {
    ResponseEntity<String> sendRequest(String url, APIRequest request);
}
