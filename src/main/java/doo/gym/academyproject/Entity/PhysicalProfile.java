package doo.gym.academyproject.Entity;

import doo.gym.academyproject.Entity.enuns.FitnessGoal;
import doo.gym.academyproject.Entity.enuns.Gender;

/**
 * Classe que representa o perfil fisico/caracteristicas
 * é com base nessas informações que o treino é gerado de forma personalizada
 */
public class PhysicalProfile {

    private final double bodyWeight;
    private final double bodyHeight;
    private final Gender gender;
    private final int age;
    private final FitnessGoal fitnessGoal;

    private PhysicalProfile(double bodyWeight, double bodyHeight, Gender gender, int age, FitnessGoal fitnessGoal) {
        this.bodyWeight = bodyWeight;
        this.bodyHeight = bodyHeight;
        this.gender = gender;
        this.age = age;
        this.fitnessGoal = fitnessGoal;
    }

    public double getBodyWeight() {
        return bodyWeight;
    }

    public double getBodyHeight() {
        return bodyHeight;
    }

    public Gender getGender() {
        return gender;
    }
    public int getAge() {
        return age;
    }

    public FitnessGoal getFitnessGoal() {
        return fitnessGoal;
    }

    /**
     * uso do padrao Builder com o objetivo de melhorar a instancia do Objeto
     */
    public static class PhysicalProfileBuilder{
        private double bodyWeight;
        private double bodyHeight;
        private Gender gender;
        private int age;
        private FitnessGoal fitnessGoal;

        public PhysicalProfileBuilder bodyWeight(double bodyWeight) {
            this.bodyWeight = bodyWeight;
            return this;
        }

        public PhysicalProfileBuilder bodyHeight(double bodyHeight) {
            this.bodyHeight = bodyHeight;
            return this;
        }

        public PhysicalProfileBuilder gender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public PhysicalProfileBuilder age(int age) {
            this.age = age;
            return this;
        }

        public PhysicalProfileBuilder fitnessGoal(FitnessGoal fitnessGoal) {
            this.fitnessGoal = fitnessGoal;
            return this;
        }

        public PhysicalProfile build() {
            return new PhysicalProfile(bodyWeight, bodyHeight, gender, age, fitnessGoal);
        }
    }

}