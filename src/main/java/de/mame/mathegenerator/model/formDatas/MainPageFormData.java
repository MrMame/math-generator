package de.mame.mathegenerator.model.formDatas;

import org.hibernate.validator.constraints.ScriptAssert;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;



public class MainPageFormData {


    @Min(value=1,message="die Anzahl der Aufgaben muss mindestens {value} betragen")
    @Max(value=10000,message="Die Anzahl der Aufgaben darf höchstens {value} betragen")
    private Integer numberOfExercises=100;
    @Min(value=1,message="Das erlaubte Minimum des Zahlenbereich-Anfangs liegt bei {value}")
    @Max(value=1000000000,message="Das erlaubte Maximum des Zahlenbereich-Anfangs liegt bei {value}")
    private Integer exercisesNumberRangeStart=1;
    @Min(value=1,message="Das erlaubte Minimum des Zahlenbereich-Endes liegt bei {value}")
    @Max(value=1000000000,message="Das erlaubte Maximum des Zahlenbereich-Endes liegt bei {value}")
    private Integer exercisesNumberRangeEnd=100;

    private Boolean withOperationsAdd=true;
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
