package de.mame.mathegenerator.configs;

import de.mame.mathegenerator.logics.numberPools.RandomNumberPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class NumberPoolsConfig {

    @Bean
    @Primary
    @Autowired
    public RandomNumberPool getRandomNumberPool() {
        return new RandomNumberPool();
    }


}
