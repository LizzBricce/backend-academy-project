package doo.gym.academyproject.B_useCases.dto;

import doo.gym.academyproject.A_entity.PhysicalProfile;
import doo.gym.academyproject.A_entity.Training;

public class UserDTO {
    private int id;
    private String name;
    private String email;
    private String password;
    private PhysicalProfile characteristic;
    private Training training;

    public UserDTO() {
    }

    public UserDTO(int id, String name, String email, String password, PhysicalProfile characteristic, Training training) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.characteristic = characteristic;
        this.training = training;
    }

    public UserDTO(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // Getters e Setters
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

    public PhysicalProfile getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(PhysicalProfile characteristic) {
        this.characteristic = characteristic;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }
}
