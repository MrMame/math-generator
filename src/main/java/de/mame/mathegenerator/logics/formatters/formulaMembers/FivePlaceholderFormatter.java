package de.mame.mathegenerator.logics.formatters.formulaMembers;

import de.mame.mathegenerator.model.formulas.formulaMembers.numbers.Number;

public class FivePlaceholderFormatter implements MembersFormatter{

    private static String FORMAT_STRING_NUMBER = "%5d";
    private static String FORMAT_STRING_OPERATOR = "%5s";

    @Override
    public String format(Integer Number) {
        return String.format(this.FORMAT_STRING_NUMBER, Number);
    }

    @Override
    public String format(String Operator) {
        return String.format(this.FORMAT_STRING_OPERATOR, Operator);
    }
}
