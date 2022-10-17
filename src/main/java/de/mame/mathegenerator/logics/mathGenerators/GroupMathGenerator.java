package de.mame.mathegenerator.logics.mathGenerators;

import de.mame.mathegenerator.model.formulas.Formula;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class GroupMathGenerator implements MathGenerator{


    Integer _numberOfExercises;
    Integer _numberRangeStart;
    Integer _numberRangeEnd;

    ArrayList<MathGenerator> _theMathGenerators = new ArrayList<>();


    @Override
    public void set_numberOfExercises(Integer _numberOfExercises) {
        this._numberOfExercises= _numberOfExercises;
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


    public void AddMathGenerator(MathGenerator theGenerator){
        this._theMathGenerators.add(theGenerator);
    }

    @Override
    public ArrayList<Formula> createExercises() {

        ArrayList<Formula> retFormulas = new ArrayList<>();

        if(this._theMathGenerators.isEmpty()){
            return retFormulas;
        }else{
            for(MathGenerator theGenerator:this._theMathGenerators){
                theGenerator.set_numberOfExercises(this._numberOfExercises);
                theGenerator.set_numberRangeStart(this._numberRangeStart);
                theGenerator.set_numberRangeEnd(this._numberRangeEnd);
                // Add the Generators Exercises to the Return container
                retFormulas.addAll(theGenerator.createExercises());
            }
        }
        return retFormulas;
    }
}
