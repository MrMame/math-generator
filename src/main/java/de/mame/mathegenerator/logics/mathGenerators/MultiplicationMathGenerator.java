package de.mame.mathegenerator.logics.mathGenerators;

import de.mame.mathegenerator.logics.numberPools.NumberPool;
import de.mame.mathegenerator.model.formulas.Formula;
import de.mame.mathegenerator.model.formulas.formulaMembers.mathOperators.EqualsMathOperator;
import de.mame.mathegenerator.model.formulas.formulaMembers.mathOperators.MulMathOperator;
import de.mame.mathegenerator.model.formulas.formulaMembers.numbers.RealNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class MultiplicationMathGenerator
    implements MathGenerator{

    private Integer _numberOfExercises;
    private Integer _numberRangeStart;
    private Integer _numberRangeEnd;

    private NumberPool _numberPool;

    @Override
    public void set_numberOfExercises(Integer _numberOfExercises) {
        this._numberOfExercises = _numberOfExercises;
    }
    @Override
    public Integer get_numberOfExercises() {
        return this._numberOfExercises;
    }

    @Override
    public void set_numberRangeStart(Integer startValue) {
        this._numberRangeStart = startValue;
    }
    @Override
    public Integer get_numberRangeStart() {
        return this._numberRangeStart;
    }

    @Override
    public void set_numberRangeEnd(Integer endValue) {
        this._numberRangeEnd = endValue;
    }
    @Override
    public Integer get_numberRangeEnd() {
        return this._numberRangeEnd;
    }

    @Autowired
    public MultiplicationMathGenerator(@Qualifier("randomNumberPool") NumberPool numberPool) {
        this._numberPool = numberPool;
    }

    @Override
    public List<Formula> createExercises() {
        // Check necessary parameters
        if(this._numberRangeStart == null){throw new IllegalArgumentException();}
        if(this._numberRangeEnd == null){throw new IllegalArgumentException();}
        if(this._numberOfExercises == null){throw new IllegalArgumentException();}
        if(this._numberOfExercises <= 0){return new ArrayList<Formula>(); }
        if(this._numberRangeEnd < this._numberRangeStart){
            // switch start/end if start has higher value than beginning
            Integer tmp = this._numberRangeEnd;
            this._numberRangeEnd = this._numberRangeStart;
            this._numberRangeStart = tmp;
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
        MulMathOperator mulMathOperator = new MulMathOperator();
        EqualsMathOperator theEqualMathOperator = new EqualsMathOperator();



        // By using the results square we ensure that our exercises will not exceed the maximum range
        Double squareOfResult = (Math.sqrt(this._numberRangeEnd.doubleValue()));
        Integer randomizerRangeEndNumber = squareOfResult.intValue()+1;

        this._numberPool.initPool(this._numberRangeStart,randomizerRangeEndNumber);

        for(Integer i = 0; i<this._numberOfExercises; i++){
            // get the first number inside the range
            numA = this._numberPool.getNumberFromPool();
            // Get the second random number, but in the range of numA and Range End.
            numB = theRand.nextInt(1,randomizerRangeEndNumber);

            result = numA * numB;

            Formula theFormula = new Formula();
            theFormula.AddFormulaMember(new RealNumber(numA));
            theFormula.AddFormulaMember(mulMathOperator);
            theFormula.AddFormulaMember(new RealNumber(numB));
            theFormula.AddFormulaMember(theEqualMathOperator);
            theFormula.AddFormulaMember(new RealNumber(result));

            theFormulas.add(theFormula);

        }
        return theFormulas;
    }
}
