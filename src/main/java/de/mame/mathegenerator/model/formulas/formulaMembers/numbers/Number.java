package de.mame.mathegenerator.model.formulas.formulaMembers.numbers;

import de.mame.mathegenerator.model.formulas.formulaMembers.FormulaMember;

public interface Number extends FormulaMember {
    Double GetDoubleValue();
    Integer GetIntegerValue();
    void SetValue(Double value);
}
