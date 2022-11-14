package de.mame.mathegenerator.model.formulas.formulaMembers.mathOperators;

import de.mame.mathegenerator.model.formulas.formulaMembers.FormulaMember;

public class EqualsMathOperator implements FormulaMember, MathOperator{
    @Override
    public String GetCharacter() {
        return "=";
    }
}
