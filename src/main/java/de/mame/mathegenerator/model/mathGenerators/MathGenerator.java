package de.mame.mathegenerator.model.mathGenerators;

import de.mame.mathegenerator.model.datas.formulas.Formula;

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
