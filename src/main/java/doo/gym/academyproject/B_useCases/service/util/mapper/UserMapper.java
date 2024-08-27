package doo.gym.academyproject.B_useCases.service.util.mapper;

import doo.gym.academyproject.A_Entities.User;
import doo.gym.academyproject.B_useCases.dto.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    private final PhysicalProfileMapper physicalProfileMapper;

    public UserMapper(PhysicalProfileMapper physicalProfileMapper) {
        this.physicalProfileMapper = physicalProfileMapper;
    }

    public UserDTO toDTO(User user) {
        if (user == null) {
            return null;
        }
        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                physicalProfileMapper != null ? physicalProfileMapper.toDTO(user.getPhysicalProfile()) : null
        );
    }

    public User toEntity(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }
        return new User.UserBuilder()
                .setId(userDTO.getId())
                .setName(userDTO.getName())
                .setEmail(userDTO.getEmail())
                .setPassword(userDTO.getPassword())
                .setPhysicalProfile(physicalProfileMapper.toEntity(userDTO.getPhysicalProfile()))
                .build();
    }
}
