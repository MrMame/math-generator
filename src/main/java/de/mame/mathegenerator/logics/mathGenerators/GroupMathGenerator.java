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
    public void setNumberOfExercises(Integer numberOfExercises) {
        this._numberOfExercises=numberOfExercises;
    }
    @Override
    public Integer getNumberOfExercises() {
        return this._numberOfExercises;
    }

    @Override
    public void setNumberRangeStart(Integer startValue) {
        this._numberRangeStart = startValue;
    }
    @Override
    public Integer getNumberRangeStart() {
        return this._numberRangeStart;
    }

    @Override
    public void setNumberRangeEnd(Integer endValue) {
        this._numberRangeEnd = endValue;
    }
    @Override
    public Integer getNumberRangeEnd() {
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
                theGenerator.setNumberOfExercises(this._numberOfExercises);
                theGenerator.setNumberRangeStart(this._numberRangeStart);
                theGenerator.setNumberRangeEnd(this._numberRangeEnd);
                // Add the Generators Exercises to the Return container
                retFormulas.addAll(theGenerator.createExercises());
            }
        }
        return retFormulas;
    }
}
