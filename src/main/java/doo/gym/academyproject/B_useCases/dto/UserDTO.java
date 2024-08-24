package doo.gym.academyproject.B_useCases.dto;

import doo.gym.academyproject.A_entity.PhysicalProfile;
import doo.gym.academyproject.A_entity.TrainingDetails;

public class UserDTO {
    private int id;
    private String name;
    private String email;
    private String password;
    private int count;
    private PhysicalProfile characteristic;

    private TrainingDetails training;

    private UserDTO(){
        this.id = ++count;
    }
    public UserDTO(String name, String email, String password, PhysicalProfile characteristic, TrainingDetails training) {
        this();
        this.name = name;
        this.email = email;
        this.password = password;
        this.characteristic = characteristic;
        this.training = training;
    }

    public UserDTO(String name, String email, String password) {
        this();
        this.name = name;
        this.email = email;
        this.password = password;

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

    public void setpPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PhysicalProfile getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(PhysicalProfile characteristic) {
        this.characteristic = characteristic;
    }

    public TrainingDetails getTraining() {
        return training;
    }

    public void setTraining(TrainingDetails training) {
        this.training = training;
    }

}
