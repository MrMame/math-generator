package de.mame.mathegenerator.logics.formatters;

import de.mame.mathegenerator.model.formulas.Formula;
import de.mame.mathegenerator.model.formulas.formulaMembers.FormulaMember;
import de.mame.mathegenerator.model.formulas.formulaMembers.mathOperators.MathOperator;
import de.mame.mathegenerator.model.formulas.formulaMembers.numbers.RealNumber;
import de.mame.mathegenerator.model.formulas.formulaMembers.numbers.Number;

public class FivePlaceholderFormulaFormatter implements FormulaFormatter{

    private Formula _theFormula;
    private static String FORMAT_STRING_NUMBER = "%5d";
    private static String FORMAT_STRING_OPERATOR = "%5s";


    public FivePlaceholderFormulaFormatter(Formula Formula) {
        this._theFormula = Formula;
    }

    @Override
    public String getFormattedString() {
        StringBuilder theFormulaString = new StringBuilder();
        String formattedMember="";
        // Format Each Member of the Formula and add it to the return string
        for(FormulaMember member:this._theFormula.GetFormulaMembers()){
            // Each Type of Formulamember has its own format string
            if( member instanceof Number){
                formattedMember = String.format(this.FORMAT_STRING_NUMBER, ((Number) member).GetIntegerValue());
            }else if(member instanceof MathOperator){
                formattedMember = String.format(this.FORMAT_STRING_OPERATOR, member.GetCharacter());
            }
            // add to return string
            theFormulaString.append(formattedMember);
        }
        // Return the formatted string
        return theFormulaString.toString();
    }
}
