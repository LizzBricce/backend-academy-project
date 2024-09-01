package doo.gym.academyproject.UseCase.service.util;

import doo.gym.academyproject.UseCase.dto.PhysicalProfileDTO;
import org.springframework.stereotype.Component;

/**
 * Classe responsavel por juntar as informações do usuario com um prompt que vai ser enviado como requisição para a API
 */
@Component
public class PromptBuilder {
    public String createPrompt(PhysicalProfileDTO dto) {
        return "monte um treino, separado em A B e C baseado no perfil: " +
                "genero: " + dto.getGender() + ", " +
                "objetivo: " + dto.getFitnessGoal() + ", " +
                "idade: " + dto.getAge() + ", " +
                "altura: " + dto.getBodyHeight() + ", " +
                "peso: " + dto.getBodyWeight();
    }
}
