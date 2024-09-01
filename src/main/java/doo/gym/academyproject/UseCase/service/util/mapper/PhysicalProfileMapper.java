package doo.gym.academyproject.UseCase.service.util.mapper;

import doo.gym.academyproject.Entity.enuns.FitnessGoal;
import doo.gym.academyproject.Entity.enuns.Gender;
import doo.gym.academyproject.Entity.PhysicalProfile;
import doo.gym.academyproject.UseCase.dto.PhysicalProfileDTO;
import org.springframework.stereotype.Component;

/**
 * Converte a Entidade PhysicalProfile e o DTO PhysicalProfileDTO
 *
 * o objetivo disso é adaptar os dados entre as camadas Entity e a camada de adaptadores de interface
 * isso separa a responsabilidade de ambas
 */
@Component
public class PhysicalProfileMapper {

    public PhysicalProfile toEntity(PhysicalProfileDTO dto) {
        if (dto == null) {
            return null;
        }

        return new PhysicalProfile.PhysicalProfileBuilder()
                .bodyWeight(dto.getBodyWeight())
                .bodyHeight(dto.getBodyHeight())
                .gender(Gender.valueOf(dto.getGender()))
                .age(dto.getAge())
                .fitnessGoal(dto.getFitnessGoal() != null ? FitnessGoal.valueOf(dto.getFitnessGoal()) : null)
                .build();
    }

    public PhysicalProfileDTO toDTO(PhysicalProfile physicalProfile) {
        if (physicalProfile == null) {
            return null;
        }


        PhysicalProfileDTO dto = new PhysicalProfileDTO();
        dto.setBodyWeight(physicalProfile.getBodyWeight());
        dto.setBodyHeight(physicalProfile.getBodyHeight());
        dto.setGender(physicalProfile.getGender().name());
        dto.setAge(physicalProfile.getAge());
        dto.setFitnessGoal(physicalProfile.getFitnessGoal() != null ? physicalProfile.getFitnessGoal().name() : null);

        return dto;
    }
}
