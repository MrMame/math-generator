package de.mame.mathegenerator.logics.formatters.formula;

import de.mame.mathegenerator.logics.formatters.formulaMembers.MembersFormatter;
import de.mame.mathegenerator.model.formulas.Formula;
import de.mame.mathegenerator.model.formulas.formulaMembers.FormulaMember;
import de.mame.mathegenerator.model.formulas.formulaMembers.mathOperators.MathOperator;
import de.mame.mathegenerator.model.formulas.formulaMembers.numbers.Number;

public class FormulaFormatter extends FormulaFormatterAbstract {



    public FormulaFormatter(Formula Formula, MembersFormatter NumberFormatter, MembersFormatter OperatorFormatter) {
        super(NumberFormatter, OperatorFormatter);
    }


    public String getFormattedString(Formula formula) {
        StringBuilder theFormulaString = new StringBuilder();
        String formattedMember="";
        // Format Each Member of the Formula and add it to the return string
        for(FormulaMember member:formula.GetFormulaMembers()){
            // Each Type of Formulamember has its own format string
            if( member instanceof Number){
                //formattedMember = String.format(this.FORMAT_STRING_NUMBER, ((Number) member).GetIntegerValue());
                formattedMember = this._operatorFormatter.format(((Number) member).GetIntegerValue());
            }else if(member instanceof MathOperator){
                //formattedMember = String.format(this.FORMAT_STRING_OPERATOR, member.GetCharacter());
                formattedMember = this._numberFormatter.format(member.GetCharacter());
            }
            // add to return string
            theFormulaString.append(formattedMember);
        }
        // Return the formatted string
        return theFormulaString.toString();
    }
}
