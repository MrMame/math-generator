package de.mame.mathegenerator.logics.numberPools;

public interface NumberPool {
    void initPool(int startNumber, int endNumber);
    Integer getNumberFromPool();
}
