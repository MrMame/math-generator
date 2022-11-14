package de.mame.mathegenerator.logics.mathGenerators.additionMathGenerator;

import de.mame.mathegenerator.logics.numberPools.NumberPool;

import java.util.ArrayList;

public class UpCountingRandomNumberPool implements NumberPool {
    private ArrayList<Integer> _pool;
    private int _nextIndex = -1;

    @Override
    public void initPool(int startNumber, int endNumber) {
        this._pool = new ArrayList<>();
        for(int i = startNumber;i<= endNumber;i++){
            this._pool.add(i);
        }
    }

    @Override
    public Integer getNumberFromPool() {

        if (this._nextIndex > this._pool.size()){
            this._nextIndex = 0;
        } else{
            this._nextIndex++;
        }

        int nextNumber = this._pool.get(this._nextIndex);
        return nextNumber;
    }
}
