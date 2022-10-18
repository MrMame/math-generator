package de.mame.mathegenerator.logics.mathGenerators;

import de.mame.mathegenerator.model.formulas.Formula;
import de.mame.mathegenerator.model.formulas.formulaMembers.mathoperators.EqualsMathOperator;
import de.mame.mathegenerator.model.formulas.formulaMembers.mathoperators.SubMathOperator;
import de.mame.mathegenerator.model.formulas.formulaMembers.numbers.RealNumber;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class SubtractionMathGenerator
    implements MathGenerator{

    private Integer numberOfExercises;
    private Integer numberRangeStart;
    private Integer numberRangeEnd;




    @Override
    public void set_numberOfExercises(Integer _numberOfExercises) {
        this.numberOfExercises = _numberOfExercises;
    }
    @Override
    public Integer get_numberOfExercises() {
        return this.numberOfExercises;
    }

    @Override
    public void set_numberRangeStart(Integer startValue) {
        this.numberRangeStart = startValue;
    }
    @Override
    public Integer get_numberRangeStart() {
        return this.numberRangeStart;
    }

    @Override
    public void set_numberRangeEnd(Integer endValue) {
        this.numberRangeEnd = endValue;
    }
    @Override
    public Integer get_numberRangeEnd() {
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
        Integer result;
        SubMathOperator subMathOperator = new SubMathOperator();
        EqualsMathOperator theEqualMathOperator = new EqualsMathOperator();

        Integer randomizerRangeEndNumber = this.numberRangeEnd+1;

        for(Integer i = 0;i<this.numberOfExercises;i++){
            // get the first number inside the range
            numA = theRand.nextInt(this.numberRangeStart,randomizerRangeEndNumber);
            // Get the second random number, but in the range of numA and Range End.
            numB = (this.numberRangeEnd-numA<=0) ? 0: theRand.nextInt(this.numberRangeEnd-numA);

            // We don't want negativ results
            if(numA > numB){
                result = numA - numB;
            }else{
                result = numB - numA;
            }

            // Because We don't want negative results we have to ensure that the biggest number is written first.
            Formula theFormula = new Formula();
            if(numA > numB){
                theFormula.AddFormulaMember(new RealNumber(numA));
            }else{
                theFormula.AddFormulaMember(new RealNumber(numB));}
            theFormula.AddFormulaMember(subMathOperator);
            if(numA > numB){
                theFormula.AddFormulaMember(new RealNumber(numB));
            }else{
                theFormula.AddFormulaMember(new RealNumber(numA));}
            theFormula.AddFormulaMember(theEqualMathOperator);
            theFormula.AddFormulaMember(new RealNumber(result));

            theFormulas.add(theFormula);

        }
        return theFormulas;
    }
}