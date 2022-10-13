package de.mame.mathegenerator.model.mathGenerators;

import de.mame.mathegenerator.model.datas.formulas.Formula;
import de.mame.mathegenerator.model.datas.formulas.members.mathoperators.AddMathOperator;
import de.mame.mathegenerator.model.datas.formulas.members.mathoperators.EqualsMathOperator;
import de.mame.mathegenerator.model.datas.formulas.members.numbers.RealNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AdditionMathGenerator
    implements MathGenerator {

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
        Integer result;
        AddMathOperator theAddMathOperator = new AddMathOperator();
        EqualsMathOperator theEqualMathOperator = new EqualsMathOperator();


        for(Integer i = 0;i<this.numberOfExercises;i++){
            // get the first number inside the range
            numA = theRand.nextInt(this.numberRangeStart,this.numberRangeEnd);
            // Get the second random number, but in the range of numA and Range End.
            numB = theRand.nextInt(this.numberRangeEnd-numA);

            result = numA + numB;

            /*
            theFormulas.add(new Formula(numA.toString() +
                             " + " +
                             numB.toString() +
                             " = " +
                             result.toString()));
            */

            Formula theFormula = new Formula();
            theFormula.AddFormulaMember(new RealNumber(numA));
            theFormula.AddFormulaMember(theAddMathOperator);
            theFormula.AddFormulaMember(new RealNumber(numB));
            theFormula.AddFormulaMember(theEqualMathOperator);
            theFormula.AddFormulaMember(new RealNumber(result));

            theFormulas.add(theFormula);


        }
        return theFormulas;
    }
}
