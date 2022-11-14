package de.mame.mathegenerator.logics.formatters.formulaMembers;

public class RawFormatter implements MembersFormatter{
    @Override
    public String format(Integer Number) {
        return Number.toString();
    }

    @Override
    public String format(String Operator) {
        return Operator;
    }
}
