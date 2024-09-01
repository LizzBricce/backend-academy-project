package doo.gym.academyproject.UseCase.service.interfaces;

import doo.gym.academyproject.UseCase.dto.UserDTO;

/**
 * Define os metodos implementados na classe APIServiceImpl
 *
 * o uso de interfaces segue o principio da inversão de dependências,
 * fazendo com que as outras classes dependam de abstrações e não da implementação
 */
public interface APIService {
    String generateTraining(UserDTO loggedInUser) throws Exception;
}
