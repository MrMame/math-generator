package de.mame.mathegenerator.configs;

import de.mame.mathegenerator.logics.mathGenerators.AdditionMathGenerator;
import de.mame.mathegenerator.logics.randomizers.Randomizer;
import de.mame.mathegenerator.logics.randomizers.SystemRandomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class RandomizersConfig {

    @Bean
    @Scope("prototype")
    Randomizer getSystemRandomizer(){
        return new SystemRandomizer();
    }



}
