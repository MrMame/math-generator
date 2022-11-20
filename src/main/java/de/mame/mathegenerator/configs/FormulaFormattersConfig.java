package de.mame.mathegenerator.configs;

import de.mame.mathegenerator.logics.formatters.formula.FormulaFormatter;
import de.mame.mathegenerator.logics.formatters.formulaMembers.RawFormatter;
import de.mame.mathegenerator.logics.randomizers.Randomizer;
import de.mame.mathegenerator.logics.randomizers.SystemRandomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class FormulaFormattersConfig {

    @Bean
    @Scope("prototype")
    FormulaFormatter getRawFormulaFormatter(){
        return new FormulaFormatter(new RawFormatter(),new RawFormatter());
    }


}
