package doo.gym.academyproject.B_useCases.dto;


import doo.gym.academyproject.A_entity.Enuns.Gender;
import doo.gym.academyproject.A_entity.Enuns.FitnessGoal;

public class PhysicalProfileDTO {

    private final Gender gender;
    private final FitnessGoal fitnessGoal;
    private final double weight;
    private final double height;
    private final int age;

    public PhysicalProfileDTO(Gender gender, FitnessGoal fitnessGoal, int age, double height, double weight) {
        this.gender = gender;
        this.fitnessGoal = fitnessGoal;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public FitnessGoal getFitnessGoal() {
        return fitnessGoal;
    }

    @Override
    public  String toString() {
        return "create a workout A, B, C for a person of the sex"
                + gender +
                "with the goal of" +
                " " + fitnessGoal;
    }
}