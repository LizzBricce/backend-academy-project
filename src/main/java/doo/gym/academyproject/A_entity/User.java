package doo.gym.academyproject.A_entity;

import doo.gym.academyproject.A_entity.Enuns.Gender;
import doo.gym.academyproject.A_entity.Enuns.PhysicalGoal;

public class User{
    private double id;
    private String name;
    private String email;
    private String password;
    private PhysicalCharacteristics characteristics;
    private TrainingDetails training;

    public User(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }
    public User(String name, String email, String password, PhysicalCharacteristics characteristics, TrainingDetails training) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.characteristics = characteristics;
        this.training = training;
    }

    public User() {

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

    public double getId() {
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

    public PhysicalCharacteristics getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(PhysicalCharacteristics characteristics) {
        this.characteristics = characteristics;
    }

    public TrainingDetails getTraining() {
        return training;
    }

    public void setTraining(TrainingDetails training) {
        this.training = training;
    }

    public void setCharacteristics(double weight, double height, Gender gender, PhysicalGoal physicalGoal, int age) {
    }
}