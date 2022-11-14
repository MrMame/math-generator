package de.mame.mathegenerator.logics.mathGenerators.additionMathGenerator;

import de.mame.mathegenerator.logics.randomizers.Randomizer;

public class OriginOnlyRandomizer implements Randomizer {

    public OriginOnlyRandomizer(){
    }

    @Override
    public int nextInt(int origin, int bound) {
        return origin;
    }
}
