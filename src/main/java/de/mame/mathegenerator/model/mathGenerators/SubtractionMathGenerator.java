package de.mame.mathegenerator.model.mathGenerators;

import de.mame.mathegenerator.model.datas.formulas.Formula;
import de.mame.mathegenerator.model.datas.formulas.members.mathoperators.EqualsMathOperator;
import de.mame.mathegenerator.model.datas.formulas.members.mathoperators.SubMathOperator;
import de.mame.mathegenerator.model.datas.formulas.members.numbers.RealNumber;

import java.util.ArrayList;
import java.util.List;

public class SubtractionMathGenerator
    implements MathGenerator{
    @Override
    public void setNumberOfExercises(Integer numberOfExercises) {

    }

    @Override
    public Integer getNumberOfExercises() {
        return null;
    }

    @Override
    public void setNumberRangeStart(Integer startValue) {

    }

    @Override
    public Integer getNumberRangeStart() {
        return null;
    }

    @Override
    public void setNumberRangeEnd(Integer endValue) {

    }

    @Override
    public Integer getNumberRangeEnd() {
        return null;
    }

    @Override
    public List<Formula> createExercises() {
        ArrayList<Formula> fakeFormulas = new ArrayList<>();
        Formula FakeFormula = new Formula();
        FakeFormula.AddFormulaMember(new RealNumber(12));
        FakeFormula.AddFormulaMember(new SubMathOperator());
        FakeFormula.AddFormulaMember(new RealNumber(34));
        FakeFormula.AddFormulaMember(new EqualsMathOperator());
        FakeFormula.AddFormulaMember(new RealNumber(999999));
        fakeFormulas.add(FakeFormula);
        return fakeFormulas;
    }
}
