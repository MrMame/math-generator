package de.mame.mathegenerator.logics.services;

import de.mame.mathegenerator.logics.mathGenerators.*;
import de.mame.mathegenerator.model.formulas.Formula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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


    public ArrayList<Formula> CreateMixedFormulas(Integer startNumberOfFormulasRange,
                                             Integer endNumberOfFormulasRange,
                                             Integer numberOfFormulas,
                                             boolean useAddition,boolean useSubtraction,
                                             boolean useMultiplication,boolean useDivision)
    {
        if(startNumberOfFormulasRange==null)throw new IllegalArgumentException("Must not be null");
        if(endNumberOfFormulasRange==null)throw new IllegalArgumentException("Must not be null");
        if(numberOfFormulas==null)throw new IllegalArgumentException("Must not be null");
        if(startNumberOfFormulasRange>endNumberOfFormulasRange)throw new IllegalArgumentException("Startnumber must be smaller then End Number");
        if(startNumberOfFormulasRange==endNumberOfFormulasRange)throw new IllegalArgumentException("Start- and EndNumber must not be equal");

        /* Create a FormulaList for each selected Mathgenerator Type, and store it inside a list*/
        List<List<Formula>> allFormulaLists = this.CreateMathgeneratorsFormulasLists(   startNumberOfFormulasRange,
                                                                    endNumberOfFormulasRange,
                                                                    numberOfFormulas,
                                                                    useAddition,
                                                                    useSubtraction,
                                                                    useMultiplication,
                                                                    useDivision);

        
        /* Select random formulas randomly from the mathgeneratorsformulas list  */
        ArrayList<Formula> returnFormulas = this.CreateRandomFormulaListFromGeneratorsFormulas(numberOfFormulas,
                                                                                                allFormulaLists);

        return returnFormulas;

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


    private List<List<Formula>> CreateMathgeneratorsFormulasLists(Integer startNumberOfFormulasRange,
                                                                  Integer endNumberOfFormulasRange,
                                                                  Integer numberOfFormulas,
                                                                  boolean useAddition, boolean useSubtraction,
                                                                  boolean useMultiplication, boolean useDivision) {



        List<List<Formula>> allFormulaLists = new ArrayList<>();

        /* Create Formula lists for each selected MathGenerator Type */
        if(useAddition) {
            List<Formula> additionFormulas = this.CreateAdditionFormulas(startNumberOfFormulasRange,
                    endNumberOfFormulasRange,
                    numberOfFormulas);
            allFormulaLists.add(additionFormulas);
        }
        if(useSubtraction) {
            List<Formula> subtractionFormulas = this.CreateSubtractionFormulas(startNumberOfFormulasRange,
                    endNumberOfFormulasRange,
                    numberOfFormulas);
            allFormulaLists.add(subtractionFormulas);
        }
        if(useDivision) {
            List<Formula> divisionFormulas = this.CreateDivisionFormulas(startNumberOfFormulasRange,
                    endNumberOfFormulasRange,
                    numberOfFormulas);
            allFormulaLists.add(divisionFormulas);
        }
        if(useMultiplication) {
            List<Formula> multiplicationFormulas = this.CreateMultiplicationFormulas(startNumberOfFormulasRange,
                    endNumberOfFormulasRange,
                    numberOfFormulas);
            allFormulaLists.add(multiplicationFormulas);
        }
        return allFormulaLists;
    }


    private ArrayList<Formula> CreateRandomFormulaListFromGeneratorsFormulas(int numberOfFormulas, List<List<Formula>> allFormulaLists) {
        if(numberOfFormulas<=0)throw new IllegalArgumentException("Number of Formulas must be greater then 0");
        if(allFormulaLists==null)throw new IllegalArgumentException("AllFormulasList must not be null");

        ArrayList<Formula> returnFormulas = new ArrayList<Formula>();

        /* Return Empty List if no MathgeneratorList is available*/
        if(allFormulaLists.isEmpty())return returnFormulas;

        Random theRand = new Random(1);
        int idxRandomFormulaNumber;int idxRandomMathgeneratorNumber;
        int i;
        Formula randomFormula;
        for(i=0;i<numberOfFormulas;i++){
            idxRandomFormulaNumber = theRand.nextInt(numberOfFormulas);
            idxRandomMathgeneratorNumber = theRand.nextInt(allFormulaLists.size());
            randomFormula = allFormulaLists.get(idxRandomMathgeneratorNumber).get(idxRandomFormulaNumber);
            returnFormulas.add(randomFormula);
        }
        return returnFormulas;
    }


}
