package de.mame.mathegenerator.logics.mathGenerators.additionMathGenerator;

import de.mame.mathegenerator.logics.mathGenerators.AdditionMathGenerator;
import de.mame.mathegenerator.logics.numberPools.RandomNumberPool;
import de.mame.mathegenerator.model.formulas.Formula;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class AdditionMathGeneratorUnitTest {


    private ApplicationContext _ctx = new AnnotationConfigApplicationContext(AdditionMathGeneratorTestConfiguration.class);

    @BeforeEach
    public void setup(){
    }


    @Test
    public void getExercise_generatesSame_originOnlyRandomizer(){

        ArrayList<String> assumptionFormulasStrings = new ArrayList<>();
        assumptionFormulasStrings.add("1+1=2");



        ArrayList<Formula> testResults;
        AdditionMathGenerator testObj = new AdditionMathGenerator(new UpCountingRandomNumberPool(),new OriginOnlyRandomizer());
        testObj.set_numberOfExercises(15);
        testObj.set_numberRangeStart(1);
        testObj.set_numberRangeEnd(100);
        testResults = (ArrayList<Formula>) testObj.createExercises();

        for(int checkFormulaNumber = 1;checkFormulaNumber<=3;checkFormulaNumber++) {
            Assert.assertEquals(testResults.get(checkFormulaNumber).toString(),
                    assumptionFormulasStrings);
        }


    }


}

