package doo.gym.academyproject.UseCase.service.util.mapper;

import doo.gym.academyproject.Entity.User;
import doo.gym.academyproject.UseCase.dto.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    /**
     * Converte a Entidade User e o DTO UserDTO
     *
     * o objetivo disso é adaptar os dados entre as camadas Entity e a camada de adaptadores de interface
     * isso separa a responsabilidade de ambas
     */
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
