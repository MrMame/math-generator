package de.mame.mathegenerator.logics.mathGenerators;

import de.mame.mathegenerator.model.formulas.Formula;

import java.util.List;

public interface MathGenerator {

    void set_numberOfExercises(Integer _numberOfExercises);
    Integer get_numberOfExercises();

    void set_numberRangeStart(Integer startValue);
    Integer get_numberRangeStart();

    void set_numberRangeEnd(Integer endValue);
    Integer get_numberRangeEnd();

    List<Formula> createExercises();



}
