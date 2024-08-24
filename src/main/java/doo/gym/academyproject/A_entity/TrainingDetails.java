package doo.gym.academyproject.A_entity;

public class TrainingDetails {
    private String trainingA;
    private String trainingB;
    private String trainingC;
    private String fullTraining;

    public TrainingDetails(String trainingA, String trainingB, String trainingC) {
        this.trainingA = trainingA;
        this.trainingB = trainingB;
        this.trainingC = trainingC;
    }

    public TrainingDetails() {
    }

    public String getTrainingA() {
        return trainingA;
    }

    public void setTrainingA(String trainingA) {
        this.trainingA = trainingA;
    }

    public String getTrainingB() {
        return trainingB;
    }

    public void setTrainingB(String trainingB) {
        this.trainingB = trainingB;
    }

    public String getTrainingC() {
        return trainingC;
    }

    public void setTrainingC(String trainingC) {
        this.trainingC = trainingC;
    }

    public String getFullTraining() {
        return fullTraining;
    }

    public void setFullTraining(String fullTraining) {
        this.fullTraining = fullTraining;
    }
}

