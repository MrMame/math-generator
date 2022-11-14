package de.mame.mathegenerator.logics.formatters;

import de.mame.mathegenerator.model.formulas.Formula;
import de.mame.mathegenerator.model.formulas.formulaMembers.FormulaMember;

import java.util.ArrayList;

public class NoFormulaFormatter implements FormulaFormatter{

    private Formula _theFormula;
    
    public NoFormulaFormatter(Formula theFormula){
        this._theFormula = theFormula;
    }

    @Override
    public String getFormattedString() {
        StringBuilder formulaString = new StringBuilder();
        // Get Each formula member string and return it without formatting
        ArrayList<FormulaMember> theMembers = (ArrayList<FormulaMember>) this._theFormula.GetFormulaMembers();
        for (FormulaMember theMember: theMembers) {
            formulaString.append(theMember.toString());
        }
        return formulaString.toString();
    }
}
