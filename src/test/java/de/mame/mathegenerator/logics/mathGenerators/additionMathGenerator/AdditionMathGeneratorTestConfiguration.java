package de.mame.mathegenerator.logics.mathGenerators.additionMathGenerator;

import de.mame.mathegenerator.logics.mathGenerators.AdditionMathGenerator;
import de.mame.mathegenerator.logics.numberPools.RandomNumberPool;
import de.mame.mathegenerator.logics.randomizers.Randomizer;
import de.mame.mathegenerator.logics.randomizers.SystemRandomizer;
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
    public Randomizer getSystemRandomizer() {
        return new SystemRandomizer();
    }



    @Bean
    @Scope("prototype")
    AdditionMathGenerator getAdditionMathGenerator(){
        return new AdditionMathGenerator(this.getRandomNumberPool(),this.getSystemRandomizer());
    }

}
