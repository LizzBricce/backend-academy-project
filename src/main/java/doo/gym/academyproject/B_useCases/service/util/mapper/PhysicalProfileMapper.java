package doo.gym.academyproject.B_useCases.service.util.mapper;

import doo.gym.academyproject.A_Entities.enuns.FitnessGoal;
import doo.gym.academyproject.A_Entities.enuns.Gender;
import doo.gym.academyproject.A_Entities.PhysicalProfile;
import doo.gym.academyproject.B_useCases.dto.PhysicalProfileDTO;
import org.springframework.stereotype.Component;

@Component
public class PhysicalProfileMapper {

    public PhysicalProfile toEntity(PhysicalProfileDTO dto) {
        if (dto == null) {
            return null;
        }

        System.out.println("Mapping DTO to PhysicalProfile: " + dto);

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

        System.out.println("Mapping PhysicalProfile to DTO: " + physicalProfile);

        PhysicalProfileDTO dto = new PhysicalProfileDTO();
        dto.setBodyWeight(physicalProfile.getBodyWeight());
        dto.setBodyHeight(physicalProfile.getBodyHeight());
        dto.setGender(physicalProfile.getGender().name());
        dto.setAge(physicalProfile.getAge());
        dto.setFitnessGoal(physicalProfile.getFitnessGoal() != null ? physicalProfile.getFitnessGoal().name() : null);

        return dto;
    }
}
