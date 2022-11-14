package de.mame.mathegenerator.model.formulas.formulaMembers.mathOperators;

import de.mame.mathegenerator.model.formulas.formulaMembers.FormulaMember;

public class AddMathOperator implements FormulaMember, MathOperator {


    @Override
    public String GetCharacter() {
        return "+";
    }
}
