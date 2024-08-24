package doo.gym.academyproject.A_entity;

import doo.gym.academyproject.A_entity.Enuns.Gender;
import doo.gym.academyproject.A_entity.Enuns.FitnessGoal;

public class User{
    private double id;
    private String name;
    private String email;
    private String password;
    private PhysicalProfile physicalProfile;
    private TrainingDetails training;

    public User(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }
    public User(String name, String email, String password, PhysicalProfile physicalProfile, TrainingDetails training) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.physicalProfile = physicalProfile;
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

    public PhysicalProfile getPhysicalProfile() {
        return physicalProfile;
    }

    public void setPhysicalProfile(PhysicalProfile physicalProfile) {
        this.physicalProfile = physicalProfile;
    }

    public TrainingDetails getTraining() {
        return training;
    }

    public void setTraining(TrainingDetails training) {
        this.training = training;
    }

    public void setCharacteristics(double weight, double height, Gender gender, FitnessGoal fitnessGoal, int age) {
    }
}