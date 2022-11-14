package de.mame.mathegenerator.logics.formatters.formulaMembers;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class RawFormatterTest {

    @Test
    void ValidNumber_formats_ok() {
        //Arrange
        RawFormatter rawFormatter = new RawFormatter();
        //Act
        String formattedString = rawFormatter.format(123);
        //Assert
        Assert.assertEquals(formattedString,
                            "123");
    }


   @Test
    void ValidOperators_format_ok() {
        //Arrange
        RawFormatter rawFormatter = new RawFormatter();
        //Act
        String formattedString = rawFormatter.format("+");
        //Assert
        Assert.assertEquals(formattedString,
                "+");
    }

}