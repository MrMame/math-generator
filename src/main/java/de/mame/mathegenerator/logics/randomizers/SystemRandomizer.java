package de.mame.mathegenerator.logics.randomizers;

import java.util.Random;

public class SystemRandomizer implements Randomizer{

    private Random _theRand;

    public SystemRandomizer(){
        this._theRand = new Random();
    }

    @Override
    public int getInt(int origin, int bound) {
        return this._theRand.nextInt(origin,bound);
    }


}
