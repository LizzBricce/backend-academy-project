package doo.gym.academyproject.A_entity;

import doo.gym.academyproject.A_entity.Enuns.Gender;
import doo.gym.academyproject.A_entity.Enuns.PhysicalGoal;

public class PhysicalCharacteristics {

    private double weight;
    private double height;
    private Gender gender;
    private int age;
    private PhysicalGoal physicalGoal;

    public PhysicalCharacteristics(double weight, double height, Gender gender, PhysicalGoal physicalGoal,int age) {
        this.weight = weight;
        this.height = height;
        this.gender = gender;
        this.physicalGoal = physicalGoal;
        this.age = age;
    }

    public PhysicalCharacteristics(double weight, double height) {
    }

    public PhysicalCharacteristics() {

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public PhysicalGoal getPhysicalGoal() {
        return physicalGoal;
    }

    public void setPhysicalGoal(PhysicalGoal physicalGoal) {
        this.physicalGoal = physicalGoal;
    }

}