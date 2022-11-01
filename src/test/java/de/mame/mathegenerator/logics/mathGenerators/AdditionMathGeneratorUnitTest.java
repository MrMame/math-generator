package de.mame.mathegenerator.logics.mathGenerators;

import de.mame.mathegenerator.logics.numberPools.RandomNumberPool;
import de.mame.mathegenerator.model.formulas.Formula;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AdditionMathGeneratorUnitTest {


    private ApplicationContext _ctx;

    @BeforeEach
    public void setup(){
       this. _ctx = new AnnotationConfigApplicationContext(AdditionMathGeneratorTestConfiguration.class);
    }


    @Test
    public void getExercise_Reproducable_EachNewinstance() {



        ArrayList<List<Formula>> testResults = new ArrayList<>();

        for(int i = 1;i<5;i++){
            // Arrange
            AdditionMathGenerator testObj = _ctx.getBean(AdditionMathGenerator.class);

            testObj.set_numberOfExercises(15);
            testObj.set_numberRangeStart(1);
            testObj.set_numberRangeEnd(100);

            // Act
            testResults.add(testObj.createExercises());
        }

        // Assert
        System.out.println("-------------------------\r");
        System.out.println(testResults.get(0).get(1) + " " +
                testResults.get(1).get(1) + " " +
                testResults.get(2).get(1) + " " +
                testResults.get(3).get(1));
        System.out.println("-------------------------\r");
        System.out.println(testResults.get(0).get(2) + " " +
                testResults.get(1).get(2) + " " +
                testResults.get(2).get(2) + " " +
                testResults.get(3).get(2));


    }

}

