package de.mame.mathegenerator.configs;

import de.mame.mathegenerator.logics.mathGenerators.AdditionMathGenerator;
import de.mame.mathegenerator.logics.numberPools.RandomNumberPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
public class MathGeneratorsConfig {



    @Bean
    @Primary
    @Autowired
    AdditionMathGenerator getAdditionMathGenerator(RandomNumberPool theRandomNumberPool){
        return new AdditionMathGenerator(theRandomNumberPool);
    }

}
