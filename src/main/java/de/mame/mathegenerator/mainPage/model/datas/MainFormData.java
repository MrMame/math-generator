package de.mame.mathegenerator.mainPage.model.datas;

public class MainFormData {
    Integer numberOfExercises;
    Integer exercisesNumberRange;
    Integer exercisesPacketSize;

    public Integer getExercisesNumberRange() {
        return exercisesNumberRange;
    }

    public void setExercisesNumberRange(Integer exercisesNumberRange) {
        this.exercisesNumberRange = exercisesNumberRange;
    }

    public Integer getExercisesPacketSize() {
        return exercisesPacketSize;
    }

    public void setExercisesPacketSize(Integer exercisesPacketSize) {
        this.exercisesPacketSize = exercisesPacketSize;
    }

    public MainFormData() {
        numberOfExercises = 10;
    }

    public Integer getNumberOfExercises() {
        return numberOfExercises;
    }
    public void setNumberOfExercises(Integer numberOfExercises) {
        this.numberOfExercises = numberOfExercises;
    }


}
