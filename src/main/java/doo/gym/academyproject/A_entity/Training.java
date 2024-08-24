
package doo.gym.academyproject.A_entity;

public class Training {

    private String trainingName;
    private String description;
//    private LocalDate dayOfWeek;
//    private boolean status;

    public Training(String trainingName, String description) {
        this.trainingName = trainingName;
        this.description = description;
    }

    public String getTrainingName() {
        return trainingName;
    }

    public void setTrainingName(String trainingName) {
        this.trainingName = trainingName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
//    public LocalDate getDayOfWeek() {
//        return dayOfWeek;
//    }
//
//    public void setDayOfWeek(LocalDate dayOfWeek) {
//        this.dayOfWeek = dayOfWeek;
//    }
//
//    public boolean isStatus() {
//        return status;
//    }
//
//    public void setStatus(boolean status) {
//        this.status = status;
//    }
}
