package doo.gym.academyproject.B_useCases.service;

import doo.gym.academyproject.A_Entities.Enuns.FitnessGoal;
import doo.gym.academyproject.A_Entities.Enuns.Gender;
import doo.gym.academyproject.A_Entities.PhysicalProfile;
import doo.gym.academyproject.B_useCases.dto.PhysicalProfileDTO;
import org.springframework.stereotype.Component;

@Component
public class PhysicalProfileMapper {

    public PhysicalProfile toEntity(PhysicalProfileDTO dto) {
        if (dto == null) {
            return null;
        }
        return new PhysicalProfile.PhysicalProfileBuilder()
                .bodyWeight(dto.getBodyWeight())
                .bodyHeight(dto.getBodyHeight())
                .gender(parseGender(dto.getGender()))
                .age(dto.getAge())
                .fitnessGoal(parseFitnessGoal(dto.getFitnessGoal()))
                .build();
    }

    public PhysicalProfileDTO toDTO(PhysicalProfile profile) {
        if (profile == null) {
            return null;
        }
        PhysicalProfileDTO dto = new PhysicalProfileDTO();
        dto.setBodyWeight(profile.getBodyWeight());
        dto.setBodyHeight(profile.getBodyHeight());
        dto.setGender(profile.getGender().name());
        dto.setAge(profile.getAge());
        dto.setFitnessGoal(profile.getFitnessGoal().name());
        return dto;
    }

    private Gender parseGender(String gender) {
        if (gender == null) {
            return null;
        }
        try {
            return Gender.valueOf(gender);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    private FitnessGoal parseFitnessGoal(String fitnessGoal) {
        if (fitnessGoal == null) {
            return null;
        }
        try {
            return FitnessGoal.valueOf(fitnessGoal);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
