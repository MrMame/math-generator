package de.mame.mathegenerator.model.datas;

public class MainFormData {
    Integer numberOfExercises;
    Integer exercisesNumberRange;
    Integer exercisesPacketSize;
    Boolean withOperationsAdd=false;
    Boolean withOperationsSub=false;
    Boolean withOperationsMul=false;
    Boolean withOperationsDiv=false;

    public Boolean getWithOperationsAdd() {
        return withOperationsAdd;
    }

    public void setWithOperationsAdd(Boolean withOperationsAdd) {
        this.withOperationsAdd = withOperationsAdd;
    }

    public Boolean getWithOperationsSub() {
        return withOperationsSub;
    }

    public void setWithOperationsSub(Boolean withOperationsSub) {
        this.withOperationsSub = withOperationsSub;
    }

    public Boolean getWithOperationsMul() {
        return withOperationsMul;
    }

    public void setWithOperationsMul(Boolean withOperationsMul) {
        this.withOperationsMul = withOperationsMul;
    }

    public Boolean getWithOperationsDiv() {
        return withOperationsDiv;
    }

    public void setWithOperationsDiv(Boolean withOperationsDiv) {
        this.withOperationsDiv = withOperationsDiv;
    }



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
