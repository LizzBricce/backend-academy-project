package doo.gym.academyproject.A_entity;

public class Training {
    private String trainingA;
    private String trainingB;
    private String trainingC;
    private String fullTraining;

    public Training(String trainingA, String trainingB, String trainingC) {
        this.trainingA = trainingA;
        this.trainingB = trainingB;
        this.trainingC = trainingC;
    }

    public String getTrainingA() {
        return trainingA;
    }

    public String getTrainingB() {
        return trainingB;
    }

    public String getTrainingC() {
        return trainingC;
    }

    public String getFullTraining() {
        return fullTraining;
    }

    public void setFullTraining(String fullTraining) {
        this.fullTraining = fullTraining;
    }
}
