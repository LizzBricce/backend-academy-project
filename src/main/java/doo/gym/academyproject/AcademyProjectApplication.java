package doo.gym.academyproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * Classe que inicializa o spring com a configuração
 * CrossOrigin que permite a requisição de qualquer origen e qualquer cabeçalho
 */
@SpringBootApplication
@CrossOrigin(allowedHeaders = "*")
public class AcademyProjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(AcademyProjectApplication.class, args);
    }
}
