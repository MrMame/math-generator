package de.mame.mathegenerator.logics.mathGenerators;

import de.mame.mathegenerator.model.formulas.Formula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MathGeneratorService {

    private final AdditionMathGenerator       _theAdditionMathGenerator;
    private final DivisionMathGenerator       _theDivisionMathGenerator;
    private final GroupMathGenerator _theGroupOfMathGenerators;
    private final MultiplicationMathGenerator _theMultiplicationMathGenerator;
    private final SubtractionMathGenerator    _theSubtractionMathGenerator;



    @Autowired
    public MathGeneratorService(AdditionMathGenerator theAdditionMathGenerator,
                                DivisionMathGenerator theDivisionMathGenerator,
                                GroupMathGenerator theGroupOfMathGenerators,
                                MultiplicationMathGenerator theMultiplicationMathGenerator,
                                SubtractionMathGenerator theSubtractionMathGenerator) {
        this._theAdditionMathGenerator= theAdditionMathGenerator;
        this._theDivisionMathGenerator = theDivisionMathGenerator;
        this._theGroupOfMathGenerators = theGroupOfMathGenerators;
        this._theMultiplicationMathGenerator = theMultiplicationMathGenerator;
        this._theSubtractionMathGenerator = theSubtractionMathGenerator;


    }

    public List<Formula> CreateAdditionFormulas(Integer startNumberOfFormulasRange,
                                                 Integer endNumberOfFormulasRange,
                                                 Integer numberOfFormulas){

        this._theAdditionMathGenerator.setNumberRangeStart(startNumberOfFormulasRange);
        this._theAdditionMathGenerator.setNumberRangeEnd(endNumberOfFormulasRange);
        this._theAdditionMathGenerator.setNumberOfExercises(numberOfFormulas);

        return this._theAdditionMathGenerator.createExercises();
    }


    public List<Formula> CreateSubtractionFormulas(Integer startNumberOfFormulasRange,
                                                Integer endNumberOfFormulasRange,
                                                Integer numberOfFormulas){

        this._theSubtractionMathGenerator.setNumberRangeStart(startNumberOfFormulasRange);
        this._theSubtractionMathGenerator.setNumberRangeEnd(endNumberOfFormulasRange);
        this._theSubtractionMathGenerator.setNumberOfExercises(numberOfFormulas);

        return this._theSubtractionMathGenerator.createExercises();
    }

    public List<Formula> CreateMultiplicationFormulas(Integer startNumberOfFormulasRange,
                                                   Integer endNumberOfFormulasRange,
                                                   Integer numberOfFormulas){

        this._theMultiplicationMathGenerator.setNumberRangeStart(startNumberOfFormulasRange);
        this._theMultiplicationMathGenerator.setNumberRangeEnd(endNumberOfFormulasRange);
        this._theMultiplicationMathGenerator.setNumberOfExercises(numberOfFormulas);

        return this._theMultiplicationMathGenerator.createExercises();
    }

    public List<Formula> CreateDivisionFormulas(Integer startNumberOfFormulasRange,
                                                      Integer endNumberOfFormulasRange,
                                                      Integer numberOfFormulas){

        this._theDivisionMathGenerator.setNumberRangeStart(startNumberOfFormulasRange);
        this._theDivisionMathGenerator.setNumberRangeEnd(endNumberOfFormulasRange);
        this._theDivisionMathGenerator.setNumberOfExercises(numberOfFormulas);

        return this._theDivisionMathGenerator.createExercises();
    }


}
