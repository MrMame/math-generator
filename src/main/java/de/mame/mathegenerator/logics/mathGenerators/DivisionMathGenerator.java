package de.mame.mathegenerator.logics.mathGenerators;

import de.mame.mathegenerator.model.formulas.Formula;
import de.mame.mathegenerator.model.formulas.formulaMembers.mathoperators.DivMathOperator;
import de.mame.mathegenerator.model.formulas.formulaMembers.mathoperators.EqualsMathOperator;
import de.mame.mathegenerator.model.formulas.formulaMembers.mathoperators.RemainMathOperator;
import de.mame.mathegenerator.model.formulas.formulaMembers.numbers.RealNumber;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class DivisionMathGenerator
    implements MathGenerator{

    private Integer numberOfExercises;
    private Integer numberRangeStart;
    private Integer numberRangeEnd;

    @Override
    public void setNumberOfExercises(Integer numberOfExercises) {
        this.numberOfExercises = numberOfExercises;
    }
    @Override
    public Integer getNumberOfExercises() {
        return this.numberOfExercises;
    }

    @Override
    public void setNumberRangeStart(Integer startValue) {
        this.numberRangeStart = startValue;
    }
    @Override
    public Integer getNumberRangeStart() {
        return this.numberRangeStart;
    }

    @Override
    public void setNumberRangeEnd(Integer endValue) {
        this.numberRangeEnd = endValue;
    }
    @Override
    public Integer getNumberRangeEnd() {
        return this.numberRangeEnd;
    }

    @Override
    public List<Formula> createExercises() {
        // Check necessary parameters
        if(this.numberRangeStart == null){throw new IllegalArgumentException();}
        if(this.numberRangeEnd == null){throw new IllegalArgumentException();}
        if(this.numberOfExercises == null){throw new IllegalArgumentException();}
        if(this.numberOfExercises <= 0){return new ArrayList<Formula>(); }
        if(this.numberRangeEnd < this.numberRangeStart){
            // switch start/end if start has higher value than beginning
            Integer tmp = this.numberRangeEnd;
            this.numberRangeEnd = this.numberRangeStart;
            this.numberRangeStart = tmp;
        }
        // create list of string
        return createListOfFormulas();
    }

    private List<Formula> createListOfFormulas() {
        List<Formula> theFormulas = new ArrayList<Formula>();

        Random theRand = new Random();

        Integer numA;
        Integer numB;
        Integer switchTmp;
        Integer result;
        Integer remain=0;

        DivMathOperator divMathOperator = new DivMathOperator();
        EqualsMathOperator theEqualMathOperator = new EqualsMathOperator();
        RemainMathOperator theRemainMathOperator = new RemainMathOperator();

        Integer randomizerRangeEndNumber = this.numberRangeEnd+1;

        for(Integer i = 0;i<this.numberOfExercises;i++){
            // get the first number inside the range
            numA = theRand.nextInt(this.numberRangeStart,randomizerRangeEndNumber);
            // Get the second random number, but in the range of numA and Range End.
            numB = (this.numberRangeEnd-numA<=0) ? 0: theRand.nextInt(this.numberRangeEnd-numA);

            // NumA shall always be bigger then numB, so we don't get results lower then zero
            if(numB > numA){
                switchTmp = numB;
                numB = numA;
                numA = switchTmp;
            }

            // Division by zero is not allowed to us
            if(numA <= 0 || numB <= 0){
                result = 0;
                remain = 0;
            }else{
                result = numA / numB;
                remain = numA % numB;
            }


            Formula theFormula = new Formula();
            theFormula.AddFormulaMember(new RealNumber(numA));
            theFormula.AddFormulaMember(divMathOperator);
            theFormula.AddFormulaMember(new RealNumber(numB));
            theFormula.AddFormulaMember(theEqualMathOperator);
            theFormula.AddFormulaMember(new RealNumber(result));
            /* Only show Remain Operator if something is remaining to show */
            if(remain > 0){
                theFormula.AddFormulaMember(theRemainMathOperator);
                theFormula.AddFormulaMember(new RealNumber(remain));
            }

            theFormulas.add(theFormula);

        }
        return theFormulas;
    }
}
