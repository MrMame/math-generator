package de.mame.mathegenerator.logics.formatters;

import de.mame.mathegenerator.model.formulas.Formula;
import de.mame.mathegenerator.model.formulas.formulaMembers.mathOperators.AddMathOperator;
import de.mame.mathegenerator.model.formulas.formulaMembers.mathOperators.EqualsMathOperator;
import de.mame.mathegenerator.model.formulas.formulaMembers.numbers.RealNumber;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FivePlaceholderFormulaFormatterTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void ArrayOfValidFormulas_are_wellFormatted() {
        //Arrange
        Formula testFormula = new Formula();
        testFormula.AddFormulaMember(new RealNumber(12));
        testFormula.AddFormulaMember(new AddMathOperator());
        testFormula.AddFormulaMember(new RealNumber(88));
        testFormula.AddFormulaMember(new EqualsMathOperator());
        testFormula.AddFormulaMember(new RealNumber(100));

        FivePlaceholderFormulaFormatter theFormatter = new FivePlaceholderFormulaFormatter(testFormula);

        //Act
        String formatted = theFormatter.getFormattedString();

        //ASSERT
        String assertString = "   12    +   88    =  100";
        Assert.assertEquals(assertString,
                            formatted);

    }
}