package doo.gym.academyproject.UseCase.dto;

public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private String password;
    private PhysicalProfileDTO physicalProfile;

    public UserDTO(Long id, String name, String email, String password, PhysicalProfileDTO physicalProfile) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.physicalProfile = physicalProfile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public PhysicalProfileDTO getPhysicalProfile() {
        return physicalProfile;
    }

    public void setPhysicalProfile(PhysicalProfileDTO physicalProfile) {
        this.physicalProfile = physicalProfile;
    }
}
