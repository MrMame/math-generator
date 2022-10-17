package de.mame.mathegenerator.logics.mathGenerators;

import de.mame.mathegenerator.model.formulas.Formula;

import java.util.List;

public interface MathGenerator {

    void setNumberOfExercises(Integer numberOfExercises);
    Integer getNumberOfExercises();

    void setNumberRangeStart(Integer startValue);
    Integer getNumberRangeStart();

    void setNumberRangeEnd(Integer endValue);
    Integer getNumberRangeEnd();

    List<Formula> createExercises();



}
