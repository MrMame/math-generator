package de.mame.mathegenerator.model.datas.formulas.members.numbers;

import de.mame.mathegenerator.model.datas.formulas.members.FormulaMember;

public interface Number extends FormulaMember {
    double GetValue();
    void SetValue(double value);
}
