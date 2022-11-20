package de.mame.mathegenerator.logics.formatters.formula;

import de.mame.mathegenerator.logics.formatters.formulaMembers.MembersFormatter;
import de.mame.mathegenerator.model.formulas.Formula;

public abstract class FormulaFormatterAbstract {

    protected MembersFormatter _numberFormatter;
    protected MembersFormatter _operatorFormatter;

    public FormulaFormatterAbstract(MembersFormatter NumberFormatter, MembersFormatter OperatorFormatter){
        this._numberFormatter = NumberFormatter;
        this._operatorFormatter = OperatorFormatter;

    }

    public abstract String getFormattedString(Formula formula);

}
