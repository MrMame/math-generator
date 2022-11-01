package de.mame.mathegenerator.logics.mathGenerators;

import de.mame.mathegenerator.logics.numberPools.RandomNumberPool;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@TestConfiguration
public class AdditionMathGeneratorTestConfiguration {

    @Bean
    @Scope("prototype")
    public RandomNumberPool getRandomNumberPool() {
        return new RandomNumberPool(1);
    }

    @Bean
    @Scope("prototype")
    AdditionMathGenerator getAdditionMathGenerator(){
        return new AdditionMathGenerator(this.getRandomNumberPool(),1);
    }

}
