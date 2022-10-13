package de.mame.mathegenerator.model.datas.formulas.members.numbers;

import de.mame.mathegenerator.model.datas.formulas.members.FormulaMember;

public interface Number extends FormulaMember {
    Double GetValue();
    void SetValue(Double value);
}
