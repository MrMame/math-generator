package de.mame.mathegenerator.model.formulas.formulaMembers.numbers;

import de.mame.mathegenerator.model.formulas.formulaMembers.FormulaMember;

public interface Number extends FormulaMember {
    Double GetValue();
    void SetValue(Double value);
}
