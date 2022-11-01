package de.mame.mathegenerator.configs;

import de.mame.mathegenerator.logics.mathGenerators.AdditionMathGenerator;
import de.mame.mathegenerator.logics.numberPools.RandomNumberPool;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
public class MathGeneratorsConfig {


    @Bean
    @Primary
    public RandomNumberPool getRandomNumberPool() {
        return new RandomNumberPool();
    }

    @Bean
    @Primary
    AdditionMathGenerator getAdditionMathGenerator(){
        return new AdditionMathGenerator(this.getRandomNumberPool());
    }

}
