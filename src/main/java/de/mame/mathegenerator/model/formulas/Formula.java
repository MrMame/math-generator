package de.mame.mathegenerator.model.formulas;

import de.mame.mathegenerator.logics.formatters.formula.FormulaFormatter;
import de.mame.mathegenerator.model.formulas.formulaMembers.FormulaMember;
import de.mame.mathegenerator.model.formulas.formulaMembers.numbers.RealNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Formula {

    //private static final String BLANKED_NUMBER_STRING = "___";

    String _value;
    ArrayList<FormulaMember> _formulaMembers = new ArrayList<>();
    FormulaFormatter _formulaFormatter;



    public Formula(FormulaFormatter formulaFormatter){
        this._formulaFormatter = formulaFormatter;
    }

    /**
     * Add a formula member to the formula. Add the members in the right order.
     * @param theFormulaMember Member to add to the formula
     */
    public void AddFormulaMember(FormulaMember theFormulaMember){
        this._formulaMembers.add(theFormulaMember);
    }

    /**
     * Get all members of the formula
     * @return List of all members of this formula
     */
    public List<FormulaMember> GetFormulaMembers(){
        return Collections.unmodifiableList(this._formulaMembers);
    }

    /**
     * Return the Formula String, but with one random blank number.
     * The printable exercises are to calculate the missing blank numbers.
     * @return Formatted formula
    * */
    public String GetFormattedFormula(){
        StringBuilder returnString = new StringBuilder();
        // Count existing numbers inside the formula
        Integer numberOfNumbers = countRealNumbers(this._formulaMembers);
        // Exception. There has to be always a number inside th formula
        if(numberOfNumbers <= 0){throw new IllegalArgumentException("There should be always a number inside the formula");}

        // Find a random number to blank out
        Integer noOfBlankedNumber;
        Random theRando = new Random(1);
        noOfBlankedNumber = (theRando.nextInt(numberOfNumbers) + 1);

        Integer cntNumber=0;
        for(FormulaMember theMember: this._formulaMembers){
            if(theMember instanceof RealNumber){
                cntNumber++;
            }
            if(noOfBlankedNumber == cntNumber) {
                returnString.append(BLANKED_NUMBER_STRING);
                noOfBlankedNumber = -1; // Set to minus, so we will have blanked numbers only once.
            }else{
                returnString.append(theMember.GetCharacter());
            }
        }

        return returnString.toString();
    }

    @Override
    public String toString() {
        StringBuilder returnString = new StringBuilder();

        for(FormulaMember theMember: this._formulaMembers){
            returnString.append(theMember.GetCharacter());
        }

        return returnString.toString();
    }


    private Integer countRealNumbers(ArrayList<FormulaMember> theList){
        Integer cnt=0;
        for(FormulaMember theMember:theList){
            if(theMember instanceof RealNumber){
                cnt++;
            }
        }
        return cnt;
    }

}
