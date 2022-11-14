package de.mame.mathegenerator.logics.mathGenerators;

import de.mame.mathegenerator.logics.numberPools.NumberPool;
import de.mame.mathegenerator.logics.randomizers.Randomizer;
import de.mame.mathegenerator.model.formulas.Formula;
import de.mame.mathegenerator.model.formulas.formulaMembers.mathOperators.AddMathOperator;
import de.mame.mathegenerator.model.formulas.formulaMembers.mathOperators.EqualsMathOperator;
import de.mame.mathegenerator.model.formulas.formulaMembers.numbers.RealNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class AdditionMathGenerator
    implements MathGenerator {

    private Integer _numberOfExercises;
    private Integer _numberRangeStart;
    private Integer _numberRangeEnd;

    private Randomizer _theRand;

    private NumberPool _theRandomNumberPool;

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




    @Autowired(required = false)
    public AdditionMathGenerator(NumberPool theNumberPool, Randomizer theRandomizer) {
        this._theRandomNumberPool = theNumberPool;
        this._theRand = theRandomizer;
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
        List<Formula> theFormulas = new ArrayList<>();

        Integer numA;
        Integer numB;
        Integer result;
        AddMathOperator theAddMathOperator = new AddMathOperator();
        EqualsMathOperator theEqualMathOperator = new EqualsMathOperator();

        Integer randomizerRangeEndNumber = this._numberRangeEnd +1;


        this._theRandomNumberPool.initPool(this._numberRangeStart, this._numberRangeEnd);

        for(Integer i = 0; i<this._numberOfExercises; i++){
            // get the first number inside the range
            numA = _theRandomNumberPool.getNumberFromPool();
            numB = _theRand.nextInt(1,randomizerRangeEndNumber-numA+1);

            result = numA + numB;

            /* Randomly change numA and NumB position in formula. That will end
             in a more mixed formula look.*/
            Formula theFormula = new Formula();
            if(this._theRand.nextInt(1,3) == 1){
                theFormula.AddFormulaMember(new RealNumber(numA));
                theFormula.AddFormulaMember(theAddMathOperator);
                theFormula.AddFormulaMember(new RealNumber(numB));
            }else{
                theFormula.AddFormulaMember(new RealNumber(numB));
                theFormula.AddFormulaMember(theAddMathOperator);
                theFormula.AddFormulaMember(new RealNumber(numA));
            }
            theFormula.AddFormulaMember(theEqualMathOperator);
            theFormula.AddFormulaMember(new RealNumber(result));

            theFormulas.add(theFormula);

        }
        return theFormulas;
    }


}