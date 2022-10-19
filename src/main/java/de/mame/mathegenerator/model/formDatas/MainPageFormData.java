package de.mame.mathegenerator.model.formDatas;

import org.hibernate.validator.constraints.ScriptAssert;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;



public class MainPageFormData {


    @Min(value=1,message="Die Zahl muss grösser oder gleich {value} sein")
    @Max(value=10000,message="Die Zahl darf nicht grösser als {value} sein")
    private Integer numberOfExercises=100;
    @Min(value=1,message="Die Zahl muss grösser oder gleich 1 sein")
    @Max(value=1000000000,message="Die Zahl muss kleiner 1000000000 sein")
    private Integer exercisesNumberRangeStart=1;
    @Min(value=1,message="Die Zahl muss grösser oder gleich 1 sein")
    @Max(value=1000000000,message="Die Zahl muss kleiner 1000000000 sein")
    private Integer exercisesNumberRangeEnd=100;

    private Boolean withOperationsAdd=false;
    private Boolean withOperationsSub=false;
    private Boolean withOperationsMul=false;
    private Boolean withOperationsDiv=false;

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



    public Integer getNumberOfExercises() {
        return numberOfExercises;
    }
    public void setNumberOfExercises(Integer numberOfExercises) {
        this.numberOfExercises = numberOfExercises;
    }

    public MainPageFormData() {
    }


    private void EnsureRightNumberRangeOrder() {
        if(this.exercisesNumberRangeStart>this.exercisesNumberRangeEnd){
            int tmp = this.exercisesNumberRangeEnd;
            this.exercisesNumberRangeEnd = this.exercisesNumberRangeStart;
            this.exercisesNumberRangeStart = tmp;
        }
    }



}
