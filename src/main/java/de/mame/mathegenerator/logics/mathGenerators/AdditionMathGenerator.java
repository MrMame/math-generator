package de.mame.mathegenerator.logics.mathGenerators;

import de.mame.mathegenerator.model.formulas.Formula;
import de.mame.mathegenerator.model.formulas.formulaMembers.mathoperators.AddMathOperator;
import de.mame.mathegenerator.model.formulas.formulaMembers.mathoperators.EqualsMathOperator;
import de.mame.mathegenerator.model.formulas.formulaMembers.numbers.RealNumber;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class AdditionMathGenerator
    implements MathGenerator {

    private Integer _numberOfExercises;
    private Integer _numberRangeStart;
    private Integer _numberRangeEnd;

    private final Random _theRand = new Random();

    private ArrayList<Integer> _randomNumberPool;


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



        Integer numA;
        Integer numB;
        Integer result;
        AddMathOperator theAddMathOperator = new AddMathOperator();
        EqualsMathOperator theEqualMathOperator = new EqualsMathOperator();

        Integer randomizerRangeEndNumber = this._numberRangeEnd +1;


        this.initRandomNumberPool();

        for(Integer i = 0; i<this._numberOfExercises; i++){
            // get the first number inside the range
            numA = getRandomNumberFromPool();     //_theRand.nextInt( this._numberRangeStart, randomizerRangeEndNumber);
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



    /* The random number pool is a list of numbers from start to end.
    * */
    private void initRandomNumberPool(){
        this._randomNumberPool = new ArrayList<Integer>();
        for(Integer i = this._numberRangeStart; i<this._numberRangeEnd; i++){
            this._randomNumberPool.add(i);}
        }


    private Integer getRandomNumberFromPool(){
        if(this._randomNumberPool == null)throw new IllegalArgumentException("RandomNumberPool is null !");
        /* ReInit if already empty */
        if(this._randomNumberPool.isEmpty()){
            this.initRandomNumberPool();
        }
        /* Return a random number from the List. This number can be returned
        * next time only after all other numbers were taken from the list. */
        int numberIdx = _theRand.nextInt(this._randomNumberPool.size());
        Integer returnNumber = this._randomNumberPool.get(numberIdx);
        this._randomNumberPool.remove(numberIdx);
        return returnNumber;

    }
}