package de.mame.mathegenerator.logics.services;

import de.mame.mathegenerator.logics.mathGenerators.*;
import de.mame.mathegenerator.model.formulas.Formula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MathGeneratorsService {

    private final AdditionMathGenerator _theAdditionMathGenerator;
    private final DivisionMathGenerator _theDivisionMathGenerator;
    private final GroupMathGenerator _theGroupOfMathGenerators;
    private final MultiplicationMathGenerator _theMultiplicationMathGenerator;
    private final SubtractionMathGenerator _theSubtractionMathGenerator;



    @Autowired
    public MathGeneratorsService(AdditionMathGenerator theAdditionMathGenerator,
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

        this._theAdditionMathGenerator.set_numberRangeStart(startNumberOfFormulasRange);
        this._theAdditionMathGenerator.set_numberRangeEnd(endNumberOfFormulasRange);
        this._theAdditionMathGenerator.set_numberOfExercises(numberOfFormulas);

        return this._theAdditionMathGenerator.createExercises();
    }


    public List<Formula> CreateSubtractionFormulas(Integer startNumberOfFormulasRange,
                                                Integer endNumberOfFormulasRange,
                                                Integer numberOfFormulas){

        this._theSubtractionMathGenerator.set_numberRangeStart(startNumberOfFormulasRange);
        this._theSubtractionMathGenerator.set_numberRangeEnd(endNumberOfFormulasRange);
        this._theSubtractionMathGenerator.set_numberOfExercises(numberOfFormulas);

        return this._theSubtractionMathGenerator.createExercises();
    }

    public List<Formula> CreateMultiplicationFormulas(Integer startNumberOfFormulasRange,
                                                   Integer endNumberOfFormulasRange,
                                                   Integer numberOfFormulas){

        this._theMultiplicationMathGenerator.set_numberRangeStart(startNumberOfFormulasRange);
        this._theMultiplicationMathGenerator.set_numberRangeEnd(endNumberOfFormulasRange);
        this._theMultiplicationMathGenerator.set_numberOfExercises(numberOfFormulas);

        return this._theMultiplicationMathGenerator.createExercises();
    }

    public List<Formula> CreateDivisionFormulas(Integer startNumberOfFormulasRange,
                                                      Integer endNumberOfFormulasRange,
                                                      Integer numberOfFormulas){

        this._theDivisionMathGenerator.set_numberRangeStart(startNumberOfFormulasRange);
        this._theDivisionMathGenerator.set_numberRangeEnd(endNumberOfFormulasRange);
        this._theDivisionMathGenerator.set_numberOfExercises(numberOfFormulas);

        return this._theDivisionMathGenerator.createExercises();
    }


}
