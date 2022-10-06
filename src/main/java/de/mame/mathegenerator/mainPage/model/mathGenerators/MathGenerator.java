package de.mame.mathegenerator.mainPage.model.mathGenerators;

import de.mame.mathegenerator.mainPage.model.datas.Exercise;

import java.util.List;

public interface MathGenerator {

    void setNumberOfExercises(Integer numberOfExercises);
    Integer getNumberOfExercises();

    void setNumberRangeStart(Integer startValue);
    Integer getNumberRangeStart();

    void setNumberRangeEnd(Integer endValue);
    Integer getNumberRangeEnd();

    List<Exercise> createExercises();



}
