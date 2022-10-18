package de.mame.mathegenerator.model.formDatas;

public class MainPageFormData {
    Integer numberOfExercises=100;
    Integer exercisesNumberRangeStart=1;
    Integer exercisesNumberRangeEnd=100;

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


    public Integer getExercisesNumberRangeStart() {
        return exercisesNumberRangeStart;
    }

    public void setExercisesNumberRangeStart(Integer exercisesNumberRangeStart) {
        this.exercisesNumberRangeStart = exercisesNumberRangeStart;
    }

    public Integer getExercisesNumberRangeEnd() {
        return exercisesNumberRangeEnd;
    }

    public void setExercisesNumberRangeEnd(Integer exercisesNumberRangeEnd) {
        this.exercisesNumberRangeEnd = exercisesNumberRangeEnd;
    }

    public Integer getExercisesPacketSize() {
        return exercisesPacketSize;
    }

    public void setExercisesPacketSize(Integer exercisesPacketSize) {
        this.exercisesPacketSize = exercisesPacketSize;
    }

    public MainPageFormData() {
    }

    public Integer getNumberOfExercises() {
        return numberOfExercises;
    }
    public void setNumberOfExercises(Integer numberOfExercises) {
        this.numberOfExercises = numberOfExercises;
    }


}
