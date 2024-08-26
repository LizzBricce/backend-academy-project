package doo.gym.academyproject.B_useCases.dto;

import org.springframework.stereotype.Component;

@Component
public class PromptBuilder {
    public String createPrompt(PhysicalProfileDTO dto) {
        return "monte um treino baseado no perfil: " +
                "genero: " + dto.getGender() + ", " +
                "objetivo: " + dto.getFitnessGoal() + ", " +
                "idade: " + dto.getAge() + ", " +
                "altura: " + dto.getBodyHeight() + ", " +
                "peso: " + dto.getBodyWeight();
    }
}
