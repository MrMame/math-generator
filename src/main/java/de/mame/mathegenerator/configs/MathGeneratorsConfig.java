package de.mame.mathegenerator.configs;

import de.mame.mathegenerator.logics.mathGenerators.AdditionMathGenerator;
import de.mame.mathegenerator.logics.numberPools.RandomNumberPool;
import de.mame.mathegenerator.logics.randomizers.Randomizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


@Configuration
public class MathGeneratorsConfig {



    @Bean
    @Primary
    @Autowired
    AdditionMathGenerator getAdditionMathGenerator(RandomNumberPool theRandomNumberPool, Randomizer theRandomizer){
        return new AdditionMathGenerator(theRandomNumberPool,theRandomizer);
    }

}
