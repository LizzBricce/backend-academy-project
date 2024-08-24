package doo.gym.academyproject.B_useCases.dto;


import doo.gym.academyproject.A_entity.Enuns.Gender;
import doo.gym.academyproject.A_entity.Enuns.PhysicalGoal;

public class PhyCharacteristicsDTO{

    private Gender gender;
    private PhysicalGoal physicalGoal;
    private double weight;
    private double height;
    private int age;

    public PhyCharacteristicsDTO(Gender gender, PhysicalGoal physicalGoal
//                                 ,int age, double height, double weight
    ){
        this.gender = gender;
        this.physicalGoal = physicalGoal;
//        this.age = age;
//        this.weight = weigth;
//        this.heigth = height;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    @Override
    public  String toString() {
        return "create a workout A, B, C for a person of the sex"
                + gender +
//                "com o imc"
//                + IMC +
                "with the goal of" +
                " " +physicalGoal;
    }
}