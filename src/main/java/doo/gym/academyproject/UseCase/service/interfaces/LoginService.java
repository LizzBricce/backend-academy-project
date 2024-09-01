package doo.gym.academyproject.UseCase.service.interfaces;

import doo.gym.academyproject.Entity.User;
/**
 * Define os metodos implementados na classe LoginServiceImpl
 *
 * o uso de interfaces segue o principio da inversão de dependências,
 * fazendo com que as outras classes dependam de abstrações e não da implementação
 */
public interface LoginService {

    User authenticateUser(String email, String password);
}